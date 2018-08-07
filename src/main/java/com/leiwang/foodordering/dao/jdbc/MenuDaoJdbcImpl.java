package com.leiwang.foodordering.dao.jdbc;

import com.leiwang.foodordering.dao.MenuDao;
import com.leiwang.foodordering.domain.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class MenuDaoJdbcImpl implements MenuDao {
	@Autowired
	private JdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private MenuRowMapper rowMapper;
	
	
	static class MenuRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet row, int arg1) throws SQLException {
			Menu menu = new Menu();
			menu.setId(row.getInt("id"));
			menu.setRestaurantId(row.getInt("restaurantId"));
			menu.setRestaurantName(row.getString("restaurantName"));
			menu.setDishName(row.getString("dishName"));
			menu.setDishDescription(row.getString("dishDescription"));
			menu.setDishPrice(row.getFloat("dishPrice"));
			menu.setDishImage(row.getInt("dishImage"));
			return menu;
			
		}
	}
	
	
	 @PostConstruct
	  public void setup() {
			jdbcInsert = new SimpleJdbcInsert(dbTemplate);
			jdbcInsert.setTableName("menu");
			jdbcInsert.setGeneratedKeyName("id");
			rowMapper = new MenuRowMapper();
	 }
	 
	 @Override		
	public void createDish(Menu menu){
		 Map<String, Object> args = new HashMap<String, Object>();
		  args.put("restaurantId",menu.getRestaurantId());
		  args.put("restaurantName", menu.getRestaurantName());
		  args.put("dishName", menu.getDishName());
		  args.put("dishDescription", menu.getDishDescription());
		  args.put("dishPrice", menu.getDishPrice());
		  args.put("dishImage", menu.getDishImage());
		  Number dishId = jdbcInsert.executeAndReturnKey(args);
		  menu.setId(dishId.intValue());
		  }
	 
	 @SuppressWarnings("unchecked")
	 @Override 
	public Menu getDishById(int id){
		 return (Menu) dbTemplate.query("select * from menu where id=?",new Object[]{id},rowMapper).get(0);
	 }
	 
	 @Override 
	public void updateDish(Menu menu){
		 dbTemplate.update("update menu set dishName=?, dishDescription=?,dishPrice=?,dishImage=? where dishId=?",
				 new Object[]{menu.getDishName(), menu.getDishDescription(), menu.getDishPrice(),menu.getDishImage(),menu.getId()});
	 }
	 
	 
	 
	@Override
	public void deleteDish(Menu menu){
			 dbTemplate.update("delete from menu where dishId=?",new Object[]{menu.getId()});
		 }

}
