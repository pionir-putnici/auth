package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Role;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.RoleRepository;
import com.hellokoding.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
 //       User user1 = userRepository.findUserWithRoles(username);
        
       // roleRepository.findUserRoles(username).findUserRoles.setParameter("tags", username);

//        user.getRoles().add(e);
        
//        Set<Role> roles = roleRepository.findUserRoles(username);
//        user.setRoles(roles);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
//       	boolean tt = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
      	Authentication tt1 = SecurityContextHolder.getContext().getAuthentication();

        
//        org.springframework.security.core.userdetails.User bb = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
//	public UserDetails loadUserByUsername(String userName)
//			throws UsernameNotFoundException {
//		UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
//		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
//		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getUserName(),
//				activeUserInfo.getPassword(), Arrays.asList(authority));
//		return userDetails;
//	}
}
