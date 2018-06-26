package com.springboot.mybatis.controller;

import com.springboot.mybatis.domain.User;
import com.springboot.mybatis.service.MailService;
import com.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @AUTHOR Yrp
 * @CREATE 2018-05-25
 * 08:51
 **/
@Controller
public class UserController {

    public static final String SUCCESS_PAGE = "index";
    public static final String ERROR_PAGE = "error";
    public static final String REDIRECT_URL = "redirect:/allUser";
    public static final String MODEL_STR = "userList";

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/allUser")
    public String getAllUsers(Model model) {
        List<User> userList = userService.findAllUser();
        model.addAttribute(MODEL_STR, userList);
        // 发送邮件
        String mailTo = "873750200@qq.com";
        String subject = "测试springboot集成mail发送邮件";
        StringBuilder content = new StringBuilder();
        for (User user : userList) {
            if (user != null) {
                content.append(user.toString()).append("<br>");
            }
        }
//        mailService.sendSimpleEmail(mailTo,subject,content);
        mailService.sendHtmlMail(mailTo, subject, content.toString());
        return SUCCESS_PAGE;
    }

    @RequestMapping(value = "/addUser/{name}&{age}&{gender}")
    public String addUser(@PathVariable("name") String name, @PathVariable("age") Integer age, @PathVariable("gender") String gender) {
        Integer count = userService.addUser(name, age, gender);
        return returnVal(count);
    }

    @RequestMapping(value = "/getUserById/{id}")
    public String getUserById(Model model, @PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        model.addAttribute(MODEL_STR, user);
        return SUCCESS_PAGE;
    }

    @RequestMapping(value = "/deleteById/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        Integer count = userService.deleteUserById(id);
        return returnVal(count);
    }

    @RequestMapping(value = "/updateUser/{id}&{name}&{age}&{gender}")
    public String updateUser(@PathVariable Integer id, @PathVariable String name, @PathVariable Integer age, @PathVariable String gender) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        Integer count = userService.updateUser(user);
        return returnVal(count);
    }

    public String returnVal(Integer count) {
        if (count == 1)
            return REDIRECT_URL;
        else
            return ERROR_PAGE;
    }
}
