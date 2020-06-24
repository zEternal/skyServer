package com.star.tcs.controller;

import com.star.tcs.bean.User;
import com.star.tcs.service.IUserService;
import com.star.tcs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
   private IUserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public String saveUser(@RequestBody User users){
        System.out.println("----------------" + users);
        /*User user = new User();
        user.setUsername("akai");
        user.setPassword("123456");
        user.setRole(1);*/
        users.setRole(1);
        userService.saveUser(users);
        System.out.println("452454574575");
        return "ok";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(@RequestBody String mo){
        System.out.println(mo);
        List<User> list = userService.findAll();
        return list;
    }
}
