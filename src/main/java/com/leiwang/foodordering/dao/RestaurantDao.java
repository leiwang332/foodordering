package com.leiwang.foodordering.dao;
import java.util.List;

import com.leiwang.foodordering.domain.*;

public interface RestaurantDao {
	public void crtateRestaurant(Restaurant newRestaurant);
    public Restaurant getRestaurantById(int id);
    public void updateRestaurant(Restaurant restaurant);
    public void deleteRestaurant(Restaurant restaurant);
    public List<Restaurant> listAllRestaurant();
}
