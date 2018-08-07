package com.leiwang.foodordering.domain;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;

public class User implements Serializable {
    private int id;
    @Size(min=3,max=30)
    private String name;
    @NotEmpty
    private String email;
    @Size(min=6,max=15)
    private String password;
    @NotEmpty
    private String address;
    private String cellphone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }


}