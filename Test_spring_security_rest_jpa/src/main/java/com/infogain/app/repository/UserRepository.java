package com.infogain.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.infogain.app.entity.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {

	public AppUser findByUserName(String username);

}
