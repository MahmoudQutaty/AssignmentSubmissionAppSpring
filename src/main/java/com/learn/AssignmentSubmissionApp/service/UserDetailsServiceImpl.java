package com.learn.AssignmentSubmissionApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.AssignmentSubmissionApp.domain.User;
import com.learn.AssignmentSubmissionApp.repository.UserRepository;
import com.learn.AssignmentSubmissionApp.util.CustomPasswordEncoder;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private CustomPasswordEncoder customPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<User> user = userRepository.findByUsername(userName);
		return user.orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}

}
