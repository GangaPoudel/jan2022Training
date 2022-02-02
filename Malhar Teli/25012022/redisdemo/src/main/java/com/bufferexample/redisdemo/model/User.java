package com.bufferexample.redisdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("users")
public class User implements Serializable {

    @Id

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;

}
