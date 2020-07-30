package lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lottery.dao.RegisterDao;
import lottery.model.UserRegister;

@Service
public class RegisterService {

	@Autowired
	RegisterDao register;
	
	public Boolean saveUser(UserRegister registerUser) {
		return register.saveUser(registerUser);
	}
	
}
