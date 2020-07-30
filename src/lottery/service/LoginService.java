package lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lottery.dao.LoginDao;
import lottery.model.Login;
import lottery.model.UserRegister;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;

	public Boolean getLoginDetails(String email, String password) {
		return loginDao.loginDetails(email, password);
	}
	
	public Login getUser(String email) {
		return loginDao.getUser(email);
	}
}
