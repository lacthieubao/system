package application.ui.view;

import org.springframework.beans.factory.annotation.Autowired;

import application.config.ResourceSystem;
import application.model.User;
import application.ui.component.MenuComponent;
import application.ui.component.MenuSetting;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;


/**
 * 
 * @author Vu, Nguyen
 * @since Sept 21, 2015
 * @description Main form system
 */

@DesignRoot
@SpringView(name = MainView.VIEW_NAME)
public class MainView extends CustomComponent implements View{
	
	@Autowired
	private SpringViewProvider viewProvider;

	public static final String VIEW_NAME = "main";
	private Label iconLogo;
	private MenuComponent menu;
	private MenuSetting menuSetting;
	private static Panel panelContain;
	
	private User currentUser;
	
	public MainView(User user){
		this.currentUser = user;
		configurationComponent();
		buildLayout();
	}
	
	public User getCurrentUser(){
		return currentUser;
	}
	
	public MainView(){
		this(null);
	}
	
	private void configurationComponent(){
		iconLogo = new Label();
		iconLogo.setIcon(ResourceSystem.ICON_LOGO);
		
		menu = new MenuComponent();
		
		menuSetting = new MenuSetting();
		
		panelContain = new Panel("View");
		panelContain.setSizeFull();
		
	}

	private void buildLayout(){
		VerticalLayout verticalLayout = new VerticalLayout();

		//Build Layout Header
		HorizontalLayout headerLayout = new HorizontalLayout();
		headerLayout.setSizeFull();
		headerLayout.addComponent(iconLogo);
		headerLayout.addComponent(menu);
		headerLayout.addComponent(menuSetting);
		headerLayout.setComponentAlignment(iconLogo, Alignment.TOP_LEFT);
		headerLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);
		headerLayout.setComponentAlignment(menuSetting, Alignment.TOP_RIGHT);
		headerLayout.setSpacing(true);
		verticalLayout.addComponent(headerLayout,0);
		
		HorizontalLayout formLayout = new HorizontalLayout();
		formLayout.addComponent(panelContain);
		formLayout.setExpandRatio(panelContain, 1.0f);
		verticalLayout.addComponent(formLayout,1);
		
		setCompositionRoot(verticalLayout);
	}
	
	public  static void setContentView(Component component){
		panelContain.setContent(component);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}
	
}
