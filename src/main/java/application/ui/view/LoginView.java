package application.ui.view;

import org.springframework.beans.factory.annotation.Autowired;

import application.config.DataBundle;
import application.config.UserContext;
import application.services.external.UserService;
import application.services.internal.impl.LoadDataExample;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 21, 2015
 * @Description Login form system
 */

@SpringView(name = LoginView.VIEW_NAME)
public class LoginView extends CustomComponent implements View {
	private static final long serialVersionUID = 1L;

	public static final String VIEW_NAME = "";

	private TextField field_User;
	private PasswordField field_Password;
	private Button button_Login;

	@Autowired
	private UserService userServiceImpl;
	
	public LoginView() {
		configurationComponent();
		buildLayout();
	}

	private void configurationComponent() {
		field_User = new TextField(DataBundle.getValue("field.username"));
		field_User.setInputPrompt("User Name");
		field_User.setIcon(FontAwesome.USER);

		field_Password = new PasswordField(
				DataBundle.getValue("field.password"));
		field_Password.setInputPrompt("Password");
		field_Password.setIcon(FontAwesome.LOCK);

		button_Login = new Button(DataBundle.getValue("field.login"));
		button_Login.addClickListener(e -> doLogin());
	}
	
	private void doLogin() {
		boolean author = userServiceImpl.authorization(field_User.getValue(),
				field_Password.getValue());
		if (!author)
			Notification
					.show("Login failed !",
							"User name or password doesn't existed",
							Type.ERROR_MESSAGE);
		else
		{
			getUI().getNavigator().navigateTo(MainView.VIEW_NAME);
		}
		
	}

	private void buildLayout() {

		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(field_User);
		formLayout.addComponent(field_Password);
		formLayout.addComponent(button_Login);

		Panel panel = new Panel("LOGIN");
		panel.setSizeUndefined();
		panel.setContent(formLayout);

		CssLayout layout = new CssLayout();
		layout.addStyleName("loginlayout");
		layout.addComponent(panel);

		setCompositionRoot(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
