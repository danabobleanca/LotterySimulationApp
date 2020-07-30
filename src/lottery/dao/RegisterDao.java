package lottery.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import lottery.model.UserRegister;

@Repository
public class RegisterDao {
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Boolean saveUser(UserRegister register) {
		Boolean success;
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(register);
			tx.commit();
			success=true;
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			success=false;
		}
		return success;
	}

	
}
