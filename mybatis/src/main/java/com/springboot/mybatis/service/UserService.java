package com.springboot.mybatis.service;

import com.springboot.mybatis.domain.User;

import java.util.List;

/**
 * @AUTHOR Yrp
 * @CREATE 2018-05-25
 * 08:52
 **/
public interface UserService {

    List<User> findAllUser();

    User findUserById(Integer id);

    Integer addUser(String name, Integer age, String gender);

    Integer deleteUserById(Integer id);

    Integer updateUser(User user);

}
