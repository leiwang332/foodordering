package com.leiwang.foodordering.domain;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;

public class Menu implements Serializable {
 
	private int id;
	@NotEmpty
	private String restaurantName;
	@NotEmpty
	private int restaurantId;
	@NotEmpty
	private String dishName;
	@Size(min=5,max=100) 
	private String dishDescription;
	@NotEmpty
	private float dishPrice;
	private Integer dishImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setRestaurantId(int id) {
        this.restaurantId = id;
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

    public float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(float dishPrice) {
        this.dishPrice = dishPrice;
    }
    
    public Integer getDishImage() {
        return dishImage;
    }

    public void setDishImage(Integer dishImage) {
        this.dishImage = dishImage;
    }
}
