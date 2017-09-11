package com.kripesh.krima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.krima.dao.UserDao;
import com.kripesh.krima.model.User;
import com.kripesh.krima.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public User findByUserId(Long userId) {
		return userDao.findByUserId(userId);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

}
