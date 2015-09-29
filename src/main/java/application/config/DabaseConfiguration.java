//package application.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
///***
// * 
// * @author Vu, Nguyen
// * @Since Sept 17, 2015
// * @Description Config Connection Database and Hibernate Jpa
// */
//
//// Disable @Configuration because we using Auto Configuration (feature of Spring Boost)
////@Configuration
////@ComponentScan
////@EntityScan(basePackages = "model")
////@EnableJpaRepositories(basePackages = "model.repository")
//public class DabaseConfiguration {
//
//	@Autowired
//	private Environment env;
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("db.driver"));
//		dataSource.setUrl(env.getProperty("db.url"));
//		dataSource.setUsername("db.username");
//		dataSource.setPassword("db.password");
//		return dataSource;
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//
//		// Config package contains Model ( POJO Class)
//		entityManagerFactory.setPackagesToScan(env
//				.getProperty("entitymanager.packagesToScan"));
//
//		// config adapter
//		HibernateJpaVendorAdapter vendorApdater = new HibernateJpaVendorAdapter();
//		entityManagerFactory.setJpaVendorAdapter(vendorApdater);
//
//		// config hibernate
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect",
//				env.getProperty("hibernate.dialect"));
//		properties.put("hibernate.show_sql",
//				env.getProperty("hibernate.show_sql"));
//		properties.put("hibernate.hbm2dll.auto",
//				env.getProperty("hibernate.hbm2dll.auto"));
//		entityManagerFactory.setJpaProperties(properties);
//
//		return entityManagerFactory;
//	}
//
//	@Bean
//	public JpaTransactionManager transactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory()
//				.getObject());
//		return transactionManager;
//	}
//
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
//
//}
