/*******************************************************************************
 * Copyright (c) 2018 Infogain.
 *******************************************************************************/
package com.infogain.app.controller.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.entity.AppUser;
import com.infogain.app.exception.AuthenticationException;
import com.infogain.app.util.JwtUtil;

/**
 * Either we can use ${context}/login or ${context}/auth/login
 * 
 * @author Manish Kumar
 * @since Jul 3, 2018
 */
@RestController
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * signup.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	public String login(@RequestBody AppUser user, HttpServletRequest request) {
		User user1 = null;
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
			user1 = (User) authentication.getPrincipal();
		} catch (Exception e) {
			throw new AuthenticationException("Error while auth.", e);
		}
		final String token = jwtUtil.genToken(user1);
		return token;
	}
}
