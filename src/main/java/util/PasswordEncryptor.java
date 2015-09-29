//package util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//public class PasswordEncryptor {
//	
//		@Autowired
//	    private PasswordEncoder passwordEncoder;
//
//	    private static PasswordEncryptor instance;
//
//	    public static PasswordEncryptor getInstance() {
//	        if(instance == null) {
//	            instance = new PasswordEncryptor();
//	        }
//
//	        return instance;
//	    }
//
//	    public String encrypt(String str) {
//	        return passwordEncoder().encode(str);
//	    }
//	    
//	    @Bean
//		public PasswordEncoder passwordEncoder(){
//			if(passwordEncoder == null)
//				passwordEncoder = new BCryptPasswordEncoder();
//			
//			return passwordEncoder;
//		}
//	    
//}