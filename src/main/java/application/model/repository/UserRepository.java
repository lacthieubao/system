package application.model.repository;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.model.User;

/***
 * 
 * @author Vu, Nguyen
 * @Since Sept 17, 2015
 */

@Repository
@Qualifier(value = "userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	User findByEmail(String email);
}
