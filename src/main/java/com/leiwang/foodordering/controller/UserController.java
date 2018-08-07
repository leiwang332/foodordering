package com.leiwang.foodordering.controller;

import com.leiwang.foodordering.dao.UserDao;
import com.leiwang.foodordering.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST,  headers="Accept=application/json")
	public boolean loginPost(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userDao.getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(@RequestParam("email") String email,
			               @RequestParam("password") String password, 
			               @RequestParam("name") String name,
			               @RequestParam("address") String address,
						   @RequestParam("phone") String phone) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setAddress(address);
		user.setCellphone(phone);
		User newUser = userDao.createUser(user);
		return newUser;
	}
}
