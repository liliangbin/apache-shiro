package com.example.app.shiro.demo.repository;

import com.example.app.shiro.demo.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

    public UserInfo findByUsername(String username );
}
