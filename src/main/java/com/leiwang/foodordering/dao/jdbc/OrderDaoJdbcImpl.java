package com.leiwang.foodordering.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.leiwang.foodordering.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.leiwang.foodordering.domain.Menu;
import com.leiwang.foodordering.domain.Order;
import com.leiwang.foodordering.domain.Restaurant;

@Repository
public class OrderDaoJdbcImpl implements OrderDao {
	@Autowired
	private JdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private OrderRowMapper rowMapper;
	private static Restaurant restaurant;
	private List<Menu> dishes;
	
	
	static class OrderRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet row, int arg1) throws SQLException {
			Order order = new Order();
			
			int restaurantId = row.getInt("restaurantId");
			//restaurant = RestaurantDaoJdbcImpl.getRestaurantById(restaurantId);
			
			
			
			order.setRestaurant(restaurant);
			//order.setDishes(row.getInt("orderId"));
			return null;
		}
	}
	
	@PostConstruct
	public void setup(){
		jdbcInsert = new SimpleJdbcInsert(dbTemplate);
		jdbcInsert.setTableName("orders");
		jdbcInsert.setGeneratedKeyName("orderId");
		rowMapper = new OrderRowMapper();
	}

	@Override
	public void createOrder(Order newOrder){
		Map<String, Object> args = new HashMap<String, Object>();
		//args.put("")
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Order getOrderById(int id){
//		return (Order)dbTemplate.query("select * from orders where orderId=?", new Object []{orderId},rowMapper).get(0);
		return null;
	}
	
	

}
