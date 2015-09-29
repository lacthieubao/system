package application.ui;


import org.springframework.beans.factory.annotation.Autowired;

import application.ui.view.LoginView;
import application.ui.view.MainView;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 16, 2015
 * @Description Login System User Interface
 */

@Theme("valo")
@SpringUI
public class SystemUI extends UI {
	
	@Autowired(required=true)
    private SpringViewProvider viewProvider;
	
	@Override
	protected void init(VaadinRequest request) {
		final Navigator navigator = new Navigator(this, this);
		navigator.addProvider(viewProvider);
		navigator.addView(LoginView.VIEW_NAME, new LoginView());
		navigator.addView(MainView.VIEW_NAME, new MainView());
	}
	
}
