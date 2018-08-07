package com.leiwang.foodordering.dao.jdbc;

import com.leiwang.foodordering.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.leiwang.foodordering.dao.RestaurantDao;


/**
 * DAO for Restaurant using JdbcTemplate
 *
 * @author Lei
 */

@Repository
public class RestaurantDaoJdbcImpl implements RestaurantDao {
    @Autowired
    private JdbcTemplate dbTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private RestaurantRowMapper rowMapper;

    static class RestaurantRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet row, int arg1) throws SQLException {
            Restaurant restaurant = new Restaurant();
            restaurant.setId(row.getInt("id"));
            restaurant.setName(row.getString("RestaurantName"));
            restaurant.setCategoryId(row.getInt("FoodTypeId"));
            restaurant.setAddress(row.getString("Address"));
            restaurant.setDeliveryFee(row.getFloat("DeliveryFee"));
            restaurant.setPhone(row.getString("Phone"));
            restaurant.setDescription(row.getString("Description"));
            restaurant.setImage(row.getInt("Picture"));
            return restaurant;
        }
    }

    @PostConstruct
    public void setup() {
        jdbcInsert = new SimpleJdbcInsert(dbTemplate);
        jdbcInsert.setTableName("restaurant");
        jdbcInsert.setGeneratedKeyName("id");
        rowMapper = new RestaurantRowMapper();
    }

    @Override
    public void crtateRestaurant(Restaurant newRestaurant) {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("RestaurantName", newRestaurant.getName());
        args.put("FoodTypeId", newRestaurant.getCategoryId());
        args.put("Address", newRestaurant.getAddress());
        args.put("DeliveryFee", newRestaurant.getDeliveryFee());
        args.put("Phone", newRestaurant.getPhone());
        args.put("Description", newRestaurant.getDescription());
        args.put("Picture", newRestaurant.getImage());
        Number restaurantId = jdbcInsert.executeAndReturnKey(args);
        newRestaurant.setId(restaurantId.intValue());
    }


    @SuppressWarnings("unchecked")
    public Restaurant getRestaurantById(int id) {
        return (Restaurant) dbTemplate.query("select * from restaurant where id=?", new Object[]{id}, rowMapper).get(0);

    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        dbTemplate.update("update restaurant set RestaurantName=?, FoodTypeId=?, Address=?, DeliveryFee=?, Phone=?"
                + "Description=?, Picture=? where id=?", new Object[]{restaurant.getName(),
                restaurant.getCategoryId(), restaurant.getAddress(), restaurant.getDeliveryFee(),
                restaurant.getPhone(), restaurant.getDescription(), restaurant.getImage(), restaurant.getId()});
    }

    @Override
    public void deleteRestaurant(Restaurant restaurant) {
        dbTemplate.update("delete from restaurant where id=?", new Object[]{restaurant.getId()});
    }

    @Override
    public List<Restaurant> listAllRestaurant() {

        return null;

    }


}
