package com.leiwang.foodordering.dao;
import com.leiwang.foodordering.domain.*;

public interface MenuDao {
	public void createDish(Menu menu);
	public Menu getDishById(int id);
	public void updateDish(Menu menu);
	public void deleteDish(Menu menu);

}
