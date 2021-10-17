package com.donation.service;

import com.donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.donation.entity.User user = userRepository.findByEmail(username);
		return buildUser(user, new ArrayList<GrantedAuthority>());
	}
	
	private User buildUser(com.donation.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(), true, true, true, true,  authorities);
	}
}
