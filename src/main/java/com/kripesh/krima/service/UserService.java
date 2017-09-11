package com.kripesh.krima.service;

import java.util.List;

import com.kripesh.krima.model.User;

public interface UserService {

	List<User> findAll();

	User findByUserName(String userName);

	User findByUserId(Long userId);

	User save(User user);
}
