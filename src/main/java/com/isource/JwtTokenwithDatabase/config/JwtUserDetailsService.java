package com.isource.JwtTokenwithDatabase.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isource.JwtTokenwithDatabase.dao.UserDao;
import com.isource.JwtTokenwithDatabase.model.DAOUser;
import com.isource.JwtTokenwithDatabase.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String emailID) throws UsernameNotFoundException {
		DAOUser user = userDao.findByEmailID(emailID);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + emailID);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmailID(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setEmailID(user.getEmailID());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}

}
