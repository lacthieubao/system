package application.services.internal.impl;
//package services.internal.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import util.PasswordEncryptor;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private UserDetailsService UserDetialsServiceImpl;
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/auth/**").authenticated();
//		http.formLogin()
//			.defaultSuccessUrl("/")
//			.loginPage("/login")
//			.permitAll()
//			.and()
//			.logout()
//			.logoutSuccessUrl("/login")
//			.permitAll();
//	}
//	
//	   @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(UserDetialsServiceImpl)
//	                .passwordEncoder(PasswordEncryptor.getInstance().passwordEncoder());
//	    }
//	
//}
