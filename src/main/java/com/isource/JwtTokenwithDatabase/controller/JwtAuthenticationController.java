package com.isource.JwtTokenwithDatabase.controller;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.isource.JwtTokenwithDatabase.config.JwtTokenUtil;
import com.isource.JwtTokenwithDatabase.config.JwtUserDetailsService;
import com.isource.JwtTokenwithDatabase.model.JwtRequest;
import com.isource.JwtTokenwithDatabase.model.JwtResponse;
import com.isource.JwtTokenwithDatabase.model.UserDTO;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "user/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getEmailID(), authenticationRequest.getPassword());

		System.out.println(authenticationRequest.getEmailID());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmailID());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "users/createuser", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
