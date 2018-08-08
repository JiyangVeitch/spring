package com.veitch.service;

import com.veitch.pojo.User;

import java.util.List;

public interface UserService {

    User login(User user);

    int insertUser(User user);

    List<User> selectAll();

    int deleteById(String id);

    User selectById(String id);

    int updateUser(User user);
}
