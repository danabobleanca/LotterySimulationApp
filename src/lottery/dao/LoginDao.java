package lottery.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import lottery.model.Login;
import lottery.model.UserRegister;

@Repository
public class LoginDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public Boolean loginDetails(String email, String password) {
		String queryString="SELECT l FROM Login l WHERE l.email=:email AND l.password=:password";
		List<Login> list=(List<Login>) hibernateTemplate.findByNamedParam(queryString, new String[] {"email","password"}, new Object[] {email, password});
		if(list.size()>0) {
			return true;
		}else
			return false;
	}
	
	public Login getUser(String email) {
		String query="SELECT l from Login l ON l.email=:email";
		List<Login> user=(List<Login>) hibernateTemplate.findByNamedParam(query, "email", email);
		if(user.size()>0) {
			return user.get(0);
		}else {
			return null;
		}
	}
}
