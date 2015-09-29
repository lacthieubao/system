package application.ui.view;

import application.config.DataBundle;
import application.config.ServerConfiguration;
import application.config.enums.GenderEnum;
import application.model.User;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * 
 * @author Vu, Nguyen
 *
 */

@DesignRoot
@SpringView(name = UserView.VIEW_NAME)
public class UserView extends VerticalLayout implements View {

	public final static String VIEW_NAME = "userinfo";

	private Label title, section;

	@PropertyId("name")
	private TextField field_Name;
	@PropertyId("birthday")
	private DateField field_Birthday;
	@PropertyId("username")
	private TextField field_UserName;
	@PropertyId("sex")
	private OptionGroup field_Sex;
	
	private User user;

	public UserView(User user) {
		this.user = user;
		init();
	}

	private void init() {
		Configuration();
		buildLayout();
		bindingData();
	}

	private void Configuration() {
		title = new Label(DataBundle.getValue("field.forms"));
		title.addStyleName(ValoTheme.LABEL_H1);

		section = new Label(DataBundle.getValue("field.personalinfo"));
		section.addStyleName(ValoTheme.LABEL_H2);
		section.addStyleName(ValoTheme.LABEL_COLORED);

		field_Name = new TextField(DataBundle.getValue("field.name"));
		field_Name.setWidth("50%");

		field_Birthday = new DateField(DataBundle.getValue("field.birthday"));

		field_UserName = new TextField(DataBundle.getValue("field.username"));
		field_UserName.setReadOnly(true);
		field_UserName.setRequired(true);

		field_Sex = new OptionGroup(DataBundle.getValue("field.sex"));
		field_Sex.addItems(GenderEnum.FEMALE, GenderEnum.MALE, GenderEnum.OTHER);
		field_Sex.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
	}

	private void buildLayout() {
		setSpacing(true);
		setMargin(true);
		addComponent(title);

		final FormLayout form = new FormLayout();
		form.setMargin(false);
		form.setWidth("800px");
		form.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		
		form.addComponent(section);
		form.addComponent(field_Name);
		form.addComponent(field_Birthday);
		form.addComponent(field_UserName);
		form.addComponent(field_Sex);
		addComponent(form);
	}

	private void bindingData(){
		final Item item = new BeanItem<User>(user);
		final FieldGroup fieldGroup = new FieldGroup(item);
		fieldGroup.bindMemberFields(this);
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
