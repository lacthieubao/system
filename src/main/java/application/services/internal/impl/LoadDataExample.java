package application.services.internal.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Menu;
import application.model.User;
import application.model.UserRole;
import application.model.repository.MenuRepository;
import application.model.repository.UserRepository;
import application.model.repository.UserRoleRepository;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 21, 2015
 * @description Load data sample for system
 */
@Service
public class LoadDataExample {

	@Autowired(required = true)
	MenuRepository menuRepository;

	public void createMenuItemExample() {
		for (int i = 0; i < 25; i++) {
			if (i < 5) {
				Menu menu = new Menu();
				menu.setId(i + 1);
				menu.setIdparent(0);
				menu.setLevel(1);
				menu.setName("menu" + i + 1);
				menuRepository.save(menu);
			}
			else if (i < 10) {
				Menu menu = new Menu();
				menu.setId(i + 1);
				menu.setIdparent(1);
				menu.setLevel(2);
				menu.setName("menu" + i + 1);
				menuRepository.save(menu);
			}
			else if (i < 15) {
				Menu menu = new Menu();
				menu.setId(i + 1);
				menu.setIdparent(2);
				menu.setLevel(2);
				menu.setName("menu" + i + 1);
				menuRepository.save(menu);
			}
			else if (i < 20) {
				Menu menu = new Menu();
				menu.setId(i + 1);
				menu.setIdparent(3);
				menu.setLevel(2);
				menu.setName("menu" + i + 1);
				menuRepository.save(menu);
			}
			else if (i < 25) {
				Menu menu = new Menu();
				menu.setId(i + 1);
				menu.setIdparent(4);
				menu.setLevel(2);
				menu.setName("menu" + i + 1);
				menuRepository.save(menu);
			}
		}
	}

	@Autowired(required = true)
	private UserRepository userRepository;

	@Autowired(required = true)
	private UserRoleRepository userRoleRepository;

	public void createExampleUserData() {
		for (int i = 0; i < 100; i++) {
			User user = User.createUser("user" + i, "user" + i
					+ "@capgemini.com", "user" + i);
			user.setAge(20+i);
			user.setBirthday(new Date());
			user.setSex(i%2==0?1:0);
			user.setName("Nguyen van "+i);
			UserRole userRole = new UserRole("User", user);
			userRepository.save(user);
			userRoleRepository.save(userRole);
		}
	}

}
