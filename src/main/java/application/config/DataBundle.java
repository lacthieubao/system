package application.config;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 16, 2015
 * @Description Contain resouceBundle for application
 */

public class DataBundle {
	
	private static ResourceBundle resourceBundle;
	private static final String PATH_RESOURCE = "lang/lang";
	
	static{
		resourceBundle = ResourceBundle.getBundle(PATH_RESOURCE,  Locale.getDefault());	
	}
	
	public static String getValue(String key){
		return resourceBundle.getString(key);
	}
	public static Object getObject(String key){
		return resourceBundle.getObject(key);
	}
	public static String[] getArrayString(String key){
		return resourceBundle.getStringArray(key);
	}
}
