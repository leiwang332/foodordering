package com.leiwang.foodordering.controller;

import com.leiwang.foodordering.dao.RestaurantDao;
import com.leiwang.foodordering.dao.UserDao;
import com.leiwang.foodordering.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RestaurantDao restDao;
	
	@RequestMapping(value="/restaurantList", method = RequestMethod.GET, headers="Accept=application/json")
	public List<Restaurant> showAllRestaurant ( ){
		return null;
	}
}
