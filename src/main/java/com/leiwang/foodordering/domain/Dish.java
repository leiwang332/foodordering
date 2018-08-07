package com.leiwang.foodordering.domain;

import java.io.Serializable;

/**
 * Created by Lei on 10/21/2017.
 */
public class Dish implements Serializable {

    private int dishId;
    private String restaurantName;
    private int restaurantId;
    private String dishName;
    private String dishDescription;
    private double dishPrice;
    private Integer dishImage;

    public Dish(int restaurantId, String dishName, String dishDescription, double price) {
        this(restaurantId, dishName, dishDescription, price, null);
    }

    public Dish(int restaurantId, String dishName, String dishDescription, double price, Integer imageId) {
        this.restaurantId = restaurantId;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.dishPrice = price;
        this.dishImage = imageId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public Integer getDishImage() {
        return dishImage;
    }

    public void setDishImage(Integer dishImage) {
        this.dishImage = dishImage;
    }

}
