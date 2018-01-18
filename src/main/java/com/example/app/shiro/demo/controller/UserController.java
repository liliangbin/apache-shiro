package com.example.app.shiro.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    /**
     * 用户查询.
     *
     * @return
     */

    @RequestMapping("/userList")

    public String userInfo() {

        return "userInfo";

    }


    /**
     * 用户添加;
     *
     * @return
     */

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd() {

        return "userInfoAdd";

    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
}