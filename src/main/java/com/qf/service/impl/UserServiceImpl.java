package com.qf.service.impl;

import com.qf.dao.UserDAO;
import com.qf.dao.impl.UserDAOImpl;
import com.qf.domain.User;
import com.qf.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    //查询是否有重复username
    @Override
    public boolean queryByUsername(String username) {
        return userDAO.queryByUsername(username);
    }

    //查询是否有重复email
    @Override
    public boolean queryByEmail(String email) {
        return userDAO.queryByEmail(email);
    }

    //添加一个用户（注册写入数据库）
    @Override
    public boolean add(User user) {
        int result = userDAO.add(user);
        return result == 1;
    }

    //激活判断
    @Override
    public boolean queryCode(String code) {
        return userDAO.queryCode(code);
    }

    //查询数据库是否有这条数据
    @Override
    public boolean queryByUP(String username, String password) {
        return userDAO.queryByUP(username,password);
    }

    //管理员登录
    @Override
    public boolean queryAdmin(String username, String password) {
        return userDAO.queryAdmin(username,password);
    }


}
