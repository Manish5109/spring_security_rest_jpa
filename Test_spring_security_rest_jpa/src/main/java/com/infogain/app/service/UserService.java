/*******************************************************************************
 * Copyright (c) 2018 Infogain.
 *******************************************************************************/
package com.infogain.app.service;

import java.util.List;

import com.infogain.app.entity.AppUser;

/**
 * @author Manish Kumar
 * @since Jul 3, 2018
 */
public interface UserService {

	/**
	 * Save user details and return user id.
	 * 
	 * @param user
	 * @return
	 */
	public AppUser saveUser(AppUser user);

	/**
	 * Get all users.
	 * 
	 * @return
	 */
	public List<AppUser> getAllUser();

	/**
	 * Get user details by Id.
	 * 
	 * @param id
	 * @return
	 */
	public AppUser getUser(Long id);

}
