package com.example.app.shiro.demo.service;

import com.example.app.shiro.demo.model.SysPermission;
import com.example.app.shiro.demo.model.SysRole;
import com.example.app.shiro.demo.model.UserInfo;
import com.example.app.shiro.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo findByUsername(String username) {

        UserInfo userInfo = userInfoRepository.findByUsername(username);
        if (userInfo.getRoleList() != null && userInfo.getRoleList().size() != 0) {
            for (SysRole role : userInfo.getRoleList()) {
                role.setUserInfos(null);
                Iterable<SysPermission> sysPermissions = role.getPermissions();
                for(SysPermission sysPermission : role.getPermissions()){
                    sysPermission.setRoles(null);
                }
            }
        }
        return userInfo;

    }

}
