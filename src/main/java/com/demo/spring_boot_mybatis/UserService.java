package com.demo.spring_boot_mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findById(int id) {
        return userMapper.findById(id);
    }
}
