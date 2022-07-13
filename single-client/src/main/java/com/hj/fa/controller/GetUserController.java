package com.hj.fa.controller;

import com.hj.fa.annotation.CurrentUser;
import com.hj.fa.model.User;
import com.hj.fa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GetUserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public User user(Principal user){
        return userService.getUserByUserName("test",user.getName());
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('view_hello_world')")
    public String helloWorld(){
        return "hello,world";
    }

    @GetMapping("/test")
    public String helloTest(){
        return "hello,test";
    }

    @GetMapping("/userInfo")
    public User getUserInfo(@CurrentUser User user){
        return user;
    }

}