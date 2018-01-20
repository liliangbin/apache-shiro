package com.example.app.shiro.demo.controller;

        import com.example.app.shiro.demo.model.SysPermission;
        import com.example.app.shiro.demo.model.SysRole;
        import com.example.app.shiro.demo.model.UserInfo;
        import com.example.app.shiro.demo.repository.UserInfoRepository;
        import com.example.app.shiro.demo.service.UserInfoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController

public class Test {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping("/test")
    public Object ff() {

        UserInfo userInfo = userInfoService.findByUsername("li");

        userInfo.getRoleList();


        return userInfo;
    }
}

