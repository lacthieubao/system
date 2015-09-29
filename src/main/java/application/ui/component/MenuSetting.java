package application.ui.component;

import application.config.ServerConfiguration;
import application.model.User;
import application.ui.view.MainView;
import application.ui.view.UserView;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 28, 2015
 * 
 */

public class MenuSetting extends MenuBar{
	
	private MenuItem menuLogout;
	private MenuItem menuEdit;
	private MenuItem menuAdministrator;
		
	public MenuSetting(){
		configuration();
		buildLayout();
		registryAction();
	}
	
	private void buildLayout(){}
	
	private void registryAction(){
		menuEdit.setCommand(new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				MainView.setContentView(new UserView());
			}
		});
	}
	
	private void configuration(){
		MenuItem menuParent = this.addItem("", FontAwesome.GEARS, null);
		menuLogout = menuParent.addItem("Logout",FontAwesome.HAND_O_RIGHT,null);
		menuEdit = menuParent.addItem("Edit Info",FontAwesome.EDIT,null);
//		if(ServerConfiguration.getInstance().getUser().getUsername().equals("user1"))
		menuAdministrator = menuParent.addItem("Administrator",FontAwesome.USER_MD,null);
	}
}
