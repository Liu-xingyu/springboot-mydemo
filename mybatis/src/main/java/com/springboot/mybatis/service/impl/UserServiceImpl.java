package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.dao.UserMapper;
import com.springboot.mybatis.domain.User;
import com.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR Yrp
 * @CREATE 2018-05-25
 * 08:53
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public Integer addUser(String name, Integer age, String gender) {
        return userMapper.addUser(name, age, gender);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user.getName(), user.getAge(), user.getGender(), user.getId());
    }
}
