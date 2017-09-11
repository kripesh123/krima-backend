package com.kripesh.krima.controller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.krima.model.User;
import com.kripesh.krima.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserResource {
	@Autowired
	UserService userService;
	
	@RequestMapping("/user/users")
	public List<User> findAllUsers(){
		return userService.findAll();
	}
	
	@RequestMapping(value = "/user/userName", method = RequestMethod.POST)
	public User findByUserName(@RequestBody String userName) {
		return userService.findByUserName(userName);
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
	
}
