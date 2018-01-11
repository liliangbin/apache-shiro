package com.example.app.shiro.demo.service;

import com.example.app.shiro.demo.model.UserInfo;
import com.example.app.shiro.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo findByUsername(String username) {

        return userInfoRepository.findByUsername(username);
    }

}
