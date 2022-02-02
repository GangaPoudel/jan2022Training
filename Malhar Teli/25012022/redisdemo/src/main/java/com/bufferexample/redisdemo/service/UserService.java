package com.bufferexample.redisdemo.service;

import com.bufferexample.redisdemo.model.User;

import java.util.List;

public interface UserService {

    boolean saveUser(User user);

    List<User> fetchAllUsers();
}
