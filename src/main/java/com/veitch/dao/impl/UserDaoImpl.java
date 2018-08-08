package com.veitch.dao.impl;

import com.veitch.dao.UserDao;
import com.veitch.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User login(User user) {

        String sql = "SELECT * FROM user WHERE name= ? AND password=?";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, user.getName(), user.getPassword());

        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }

        return null;

    }

    @Override
    public int insertUser(User user) {

        String sql = " INSERT INTO user(name,password) VALUES (?,?)";

        int rs = jdbcTemplate.update(sql, user.getName(), user.getPassword());

        if (rs > 0) {
            return rs;
        }

        return 0;
    }

    @Override
    public List<User> selectAll() {
        List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM user";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            list.add(user);
        }

        return list;
    }

    @Override
    public int deleteById(String id) {
        String sql = "DELETE FROM user WHERE id=?";

        int rs = jdbcTemplate.update(sql, id);

        if (rs > 0) {
            return rs;
        }

        return 0;
    }

    @Override
    public User selectById(String id) {

        String sql = "SELECT * FROM user WHERE id=?";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, id);

        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }

        return null;
    }

    @Override
    public int updateUser(User user) {
        String sql = "UPDATE user SET name=?,password=? WHERE id =?";

        int rs = jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getId());

        if (rs > 0) {
            return rs;
        }

        return 0;

    }

}
