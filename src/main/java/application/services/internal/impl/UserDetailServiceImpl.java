package application.services.internal.impl;
//package services.internal.impl;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import model.User;
//import model.UserRole;
//import model.repository.UserRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///***
// * 
// * @author Vu, Nguyen
// * @Since Sept 17, 2015
// * @description Implement UserDetialService of Spring Security to Certificate
// *              and authorization when User Login
// */
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//
//	@Autowired
//	UserRepository userDao;
//
//	@Transactional(readOnly = true)
//	@Override
//	public UserDetails loadUserByUsername(final String username)
//			throws UsernameNotFoundException {
//		User user = userDao.findByUsername(username);
//		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
//		
//		return buildUserForAuthentication(user, authorities);
//	}
//
//	private org.springframework.security.core.userdetails.User buildUserForAuthentication(
//			User user, List<GrantedAuthority> authorities) {
//		return new org.springframework.security.core.userdetails.User(
//				user.getUsername(), user.getPassword(), authorities);
//	}
//
//	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
//
//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//		// Build user's authorities
//		for (UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
//		}
//
//		return new ArrayList<GrantedAuthority>(setAuths);
//	}
//
//}
