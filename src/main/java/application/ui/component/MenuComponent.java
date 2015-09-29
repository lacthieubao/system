package application.ui.component;

import java.util.List;

import application.config.ResourceSystem;
import application.model.Menu;
import application.model.dao.MenuDao;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 21, 2015
 * @description Component Menu Item, auto generate Menu from database
 */

public class MenuComponent extends HorizontalLayout {

	private MenuBar menuBar;

	private List<Menu> menuParent;
	
	private  MenuDao nenuDao = new MenuDao();

	public MenuComponent() {
		configurationComponent();
		buildLayout();
	}

	private void configurationComponent() {
		buildMenuBar();
	}

	public void buildLayout() {
		this.addComponent(menuBar);
		setSpacing(true);
	}

	private void buildMenuBar() {
		menuBar = new MenuBar();
		menuParent = nenuDao.findByLevel(1);
		for (Menu menu : menuParent) {
			MenuItem menuItem = menuBar.addItem(menu.getName(), null, null);
			addChildrenMenu(menuItem,menu.getId());
		}
	}

	private void addChildrenMenu(MenuItem menuItem, long idparent) {
		List<Menu> menuChildrens = nenuDao.findByIdparent(idparent);
		if (menuChildrens != null)
			for (Menu menuchild : menuChildrens) {
				menuItem.addItem(menuchild.getName(), null, null);
				addChildrenMenu(menuItem, menuchild.getId());
			}
	}
	
}
