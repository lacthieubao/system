package application.services.external.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.User;
import application.model.repository.UserRepository;
import application.services.external.UserService;

/***
 * 
 * @author Vu, Nguyen
 * @Since Sept 17, 2015
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	private UserRepository userRepository;

	@Override
	public boolean authorization(String username, String password) {
		try{
		User user = userRepository.findByUsername(username);
		if (user == null || !user.getPassword().equals(password))
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public User getUserInfo(String username) {
		return userRepository.findByUsername(username);
	}
	
}
