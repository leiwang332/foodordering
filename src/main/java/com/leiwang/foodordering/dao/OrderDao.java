package com.leiwang.foodordering.dao;

import com.leiwang.foodordering.domain.Order;

public interface OrderDao {
	public void createOrder(Order newOrder);
	public Order getOrderById(int id);
}
