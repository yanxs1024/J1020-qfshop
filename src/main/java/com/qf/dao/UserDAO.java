package com.qf.dao;

import com.qf.domain.User;

public interface UserDAO {

    //查询是否有重复username
    boolean queryByUsername(String username);

    //查询是否有重复email
    boolean queryByEmail(String email);

    //添加一个用户（注册写入数据库）
    int add(User user);

    //激活判断
    boolean queryCode(String code);

    //查询数据库是否有这条数据
    boolean queryByUP(String username, String password);

    //管理员登录
    boolean queryAdmin(String username, String password);
}
