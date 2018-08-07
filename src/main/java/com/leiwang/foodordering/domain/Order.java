package com.leiwang.foodordering.domain;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class Order implements Serializable {
	enum Status {
		NEW,
		PROCESSING,
		FULFILLED
	};
	
	private int orderId;
	private Restaurant restaurant;
	private User user;
	private List<Menu> dishes;
	private Date ordertime;
	private double total;
	private Status status;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Menu> getDishes() {
		return dishes;
	}
	public void setDishes(List<Menu> dishes) {
		this.dishes = dishes;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}
