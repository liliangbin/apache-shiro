package com.example.app.shiro.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long uid;//用户的id

    @Column(unique = true)
    private String username;//账号

    private String name;//昵称或是真实的名字。

    private String password;//密码
    private String salt;//加密密码的盐；
    private byte state;//用户状态的，0创建未认证，（比如，没有激活，没有输入验证码等等）--等待用户的验证  1，正常的状态，2，用户被锁定

    @ManyToMany(fetch = FetchType.EAGER)//立即重数据库中加载数据。
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;//一个用户具有多个角色

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }


    public List<SysRole> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐.
     *
     * @return
     */

    public String getCredentialsSalt() {

        return this.username + this.salt;

    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roleList=" + roleList +
                '}';
    }
}
