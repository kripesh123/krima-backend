package com.kripesh.krima.controller;

import static com.kripesh.krima.controller.util.ApiConstants.API_VER;
import static com.kripesh.krima.controller.util.ApiConstants.USER_LOGIN_PATH;
import static com.kripesh.krima.controller.util.ApiConstants.USER_PATH;
import static com.kripesh.krima.controller.util.ApiConstants.USER_REGISTER_PATH;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.krima.model.User;
import com.kripesh.krima.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(API_VER + USER_PATH)
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> json) throws
            ServletException {
        if(json.get("username") == null || json.get("password") ==null) {
            throw new ServletException("Please fill in username and password");
        }

        String userName = json.get("username");
        String password = json.get("password");

        User user= userService.findByUserName(userName);
        if (user==null) {
            throw new ServletException("User name not found.");
        }

        String pwd = user.getPassword();

        if(!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password");
        }

        return Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }

	@RequestMapping(value = USER_REGISTER_PATH, method = RequestMethod.POST)
	public User registerUser(@RequestBody User user) {
		return userService.save(user);
	}
}
