package application;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import application.config.ServerConfiguration;

/**
 * 
 * @author Vu, Nguyen
 * @since Sept 16, 2015
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {VelocityAutoConfiguration.class})
public class SystemApplication {
	
    public static void main(String[] args) {
    	ApplicationContext applicationContext = SpringApplication.run(SystemApplication.class, args);
    	ServerConfiguration.instance().setDataSource((DataSource) applicationContext.getBean("dataSource"));
    }
}
