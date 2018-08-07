package com.leiwang.foodordering.dao.jdbc;

import com.leiwang.foodordering.dao.UserDao;
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

/**
 * DAO for User using JdbcTemplate
 *
 * @author Lei
 */
@Repository
public class UserDaoJdbcImpl implements UserDao {
    @Autowired
    private JdbcTemplate dbTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private UserRowMapper rowMapper;

    @PostConstruct
    public void setup() {
        jdbcInsert = new SimpleJdbcInsert(dbTemplate);
        jdbcInsert.setTableName("customer");
        jdbcInsert.setGeneratedKeyName("id");
        rowMapper = new UserRowMapper();
    }

    static class UserRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet row, int arg1) throws SQLException {
            User user = new User();
            user.setId(row.getInt("id"));
            user.setName(row.getString("name"));
            user.setEmail(row.getString("email"));
            user.setPassword(row.getString("password"));
            user.setAddress(row.getString("address"));
            user.setCellphone(row.getString("cellphone"));
            return user;
        }
    }

    @Override
    public User createUser(User newUser) {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("name", newUser.getName());
        args.put("email", newUser.getEmail());
        args.put("password", newUser.getPassword());
        args.put("address", newUser.getAddress());
        args.put("cellphone", newUser.getCellphone());
        Number userId = jdbcInsert.executeAndReturnKey(args); // userId is generated by database
        newUser.setId(userId.intValue()); // set userId into the new object
        return newUser;
    }

    @SuppressWarnings("unchecked")
    @Override
    public User getUserByEmail(String email) {
        if (email.isEmpty()) {
            return null;
        } else {
            List<User> results = dbTemplate.query("select * from customer where email = ?",
                    new Object[]{email}, rowMapper);
            return results.isEmpty() ? null : results.get(0);
        }
    }

    @Override
    public void updateUser(User user) {
        dbTemplate.update("update customer set name=?, email=?, password=? address=?, cellphone=?  where id=?",
                new Object[]{user.getName(), user.getEmail(), user.getPassword(),
                        user.getAddress(), user.getCellphone(), user.getId()});

    }

    @Override
    public void deleteUser(User user) {
        dbTemplate.update("delete from customer where id=?", new Object[]{user.getId()});
    }

}
