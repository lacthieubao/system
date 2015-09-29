package application.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.model.Menu;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 21, 2015
 * @description Menu repository help generate Menu item on menu bar
 *
 */

@Repository
@Qualifier(value = "menuRepository")
public interface MenuRepository extends  CrudRepository<Menu, Long> {
	
	public List<Menu> findByIdparent(long idparent);

	public List<Menu> findByLevel(int level);
}
