package application.services.external;

import application.model.User;


/***
 * 
 * @author Vu, Nguyen
 * @Since Sept 17, 2015
 */

public interface UserService {

	public boolean authorization(String username, String password);
	
	public User getUserInfo(String username);

}
