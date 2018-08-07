package com.leiwang.foodordering.dao;
import com.leiwang.foodordering.domain.*;

public interface UserDao {
    public User createUser(User newUser);
    public User getUserByEmail(String email);
    public void updateUser(User user);
    public void deleteUser(User user);
}
