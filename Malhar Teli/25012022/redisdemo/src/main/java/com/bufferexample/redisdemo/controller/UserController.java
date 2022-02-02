package com.bufferexample.redisdemo.controller;

import com.bufferexample.redisdemo.model.User;
import com.bufferexample.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        boolean result= userService.saveUser(user);
        if(result)
            return ResponseEntity.ok("User Created Successfully");
        else return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Not Created Successfully");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchAllUser(){
        List<User> users;
        users = userService.fetchAllUsers();
        if (users.size() > 0)
            return ResponseEntity.ok(users);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
