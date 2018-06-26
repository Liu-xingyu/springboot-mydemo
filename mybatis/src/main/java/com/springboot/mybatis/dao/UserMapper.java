package com.springboot.mybatis.dao;

import com.springboot.mybatis.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @AUTHOR Yrp
 * @CREATE 2018-05-25
 * 08:45
 **/
@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<User> findAllUser();

    @Select("select * from users where id=#{id}")
    User findUserById(@Param("id") Integer id);

    @Insert("insert into users(name,age,gender) values(#{name},#{age},#{gender})")
    Integer addUser(@Param("name") String name, @Param("age") Integer age, @Param("gender") String gender);

    @Delete("delete from users where id=#{id}")
    Integer deleteUserById(@Param("id") Integer id);

    @Update({"update users set name=#{name},age=#{age},gender=#{gender} where id=#{id}"})
    Integer updateUser(@Param("name") String name, @Param("age") Integer age, @Param("gender") String gender, @Param("id") Integer id);

}
