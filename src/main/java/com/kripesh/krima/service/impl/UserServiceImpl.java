package com.kripesh.krima.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.krima.dao.RoleDao;
import com.kripesh.krima.dao.UserDao;
import com.kripesh.krima.model.Role;
import com.kripesh.krima.model.User;
import com.kripesh.krima.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;

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
		user.setActive(true);
		Role userRole = roleDao.findByRole("ROLE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return userDao.save(user);
	}

}
