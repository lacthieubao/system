package application.config;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;

public class ResourceSystem {

	public final static Resource ICON_LOGO = new FileResource(new File(ClassLoader
			.getSystemResource("images/icon_logo.png").getFile()));
	
	public final static Resource ICON_SETTING = new FileResource(new File(ClassLoader
			.getSystemResource("images/icon_setting.png").getFile()));

}
