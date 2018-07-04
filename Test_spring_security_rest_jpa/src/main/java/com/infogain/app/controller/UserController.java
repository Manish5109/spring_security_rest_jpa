/*******************************************************************************
 * Copyright (c) 2018 Infogain.
 *******************************************************************************/
package com.infogain.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.entity.AppUser;
import com.infogain.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * save user details.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/save2", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public AppUser save2(@RequestBody AppUser user, HttpServletRequest request) {
		return userService.saveUser(user);
	}

	/**
	 * save user details.
	 * 
	 * @return
	 */
	// @RequestMapping(value = "/users/save1", method = RequestMethod.POST)
	// @PreAuthorize("hasRole('ROLE_USER')")
	// public AppUser save1(@RequestBody AppUser user, HttpServletRequest request) {
	// return userService.saveUser(user);
	// }

	/**
	 * save user details.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/save", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public AppUser save(@RequestBody AppUser user, HttpServletRequest request) {
		return userService.saveUser(user);
	}

	/**
	 * save user details.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/allUser", method = RequestMethod.POST)
	public List<AppUser> getAllUser() {
		return userService.getAllUser();
	}

}
