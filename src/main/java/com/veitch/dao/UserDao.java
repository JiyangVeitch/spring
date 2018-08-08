package com.veitch.dao;


import com.veitch.pojo.User;

import java.util.List;


public interface UserDao {
    User login(User user);

    int insertUser(User user);

    List<User> selectAll();

    int deleteById(String id);

    User selectById(String id);

    int updateUser(User user);
}
