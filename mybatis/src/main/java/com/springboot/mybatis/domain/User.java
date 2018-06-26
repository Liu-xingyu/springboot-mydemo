package com.springboot.mybatis.domain;

import java.io.Serializable;

/**
 * @AUTHOR Yrp
 * @CREATE 2018-05-25
 * 08:43
 **/
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id=").append(id)
                .append(";name=").append(name)
                .append(";age=").append(age)
                .append(";gender=").append(gender);
        return builder.toString();
    }
}
