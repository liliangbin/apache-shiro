package com.example.app.shiro.demo.controller;

import com.example.app.shiro.demo.model.UserInfo;
import com.example.app.shiro.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Test {

    @Autowired
    UserInfoRepository userInfoRepository;

    @RequestMapping("/test")
    public Object ff() {

        UserInfo userInfo = userInfoRepository.findByUsername("admin");

        return userInfo.getRoleList();
    }
}
