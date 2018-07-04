/*******************************************************************************
 * Copyright (c) 2018 Infogain.
 *******************************************************************************/
package com.infogain.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.app.entity.AppUser;
import com.infogain.app.repository.UserRepository;

/**
 * @author Manish Kumar
 * @since Jul 3, 2018
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.infogain.test.service.UserService#saveUser(com.infogain.test.entity.User)
	 */
	@Override
	public AppUser saveUser(AppUser user) {
		LOGGER.debug("Saving user: {}", user);
		return userRepository.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.infogain.test.service.UserService#getAllUser()
	 */
	@Override
	public List<AppUser> getAllUser() {
		Iterator<AppUser> iterator = userRepository.findAll().iterator();
		List<AppUser> users = new ArrayList<>();
		while (iterator.hasNext()) {
			AppUser user = iterator.next();
			users.add(user);
		}
		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.infogain.test.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public AppUser getUser(Long id) {
		return userRepository.findOne(id);

	}

}
