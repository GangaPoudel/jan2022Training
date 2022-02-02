package com.bufferexample.redisdemo.repository;

import com.bufferexample.redisdemo.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUsers();
}
