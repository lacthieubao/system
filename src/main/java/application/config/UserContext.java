package application.config;

import java.util.Locale;

import application.model.User;

public class UserContext {
	
	private User currentUser;
	private Locale currentLocale;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User user) {
		this.currentUser = user;
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}
	
}
