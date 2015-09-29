package application.model.repository;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.model.UserRole;

/***
 * 
 * @author Vu, Nguyen
 * @Since Sept 17, 2015
 */

@Repository
@Qualifier(value = "userRoleRepository")
public interface UserRoleRepository extends CrudRepository<UserRole,Long>{
	
}
