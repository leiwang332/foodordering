package com.leiwang.foodordering.domain;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private int id;
    private String name;
    private Integer image;
    private String category;
    private int categoryId;
    private String address;
    private String description;
    private float deliveryFee;
    private String phone;

    public Restaurant() {
    }

    public Restaurant(String name, Integer image, String category, int categoryId, String address,
                      String description, float deliveryFee, String phone) {
        this.name = name;
        this.image = image;
        this.category = category;
        this.categoryId = categoryId;
        this.address = address;
        this.description = description;
        this.deliveryFee = deliveryFee;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageId() {
        return image;
    }

    public void setImage(Integer imageId) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
