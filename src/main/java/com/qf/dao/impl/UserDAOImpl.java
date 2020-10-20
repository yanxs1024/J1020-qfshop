package com.qf.dao.impl;

import com.qf.dao.UserDAO;
import com.qf.domain.User;
import com.qf.utils.DatabaseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private JdbcTemplate jdbcTemplate = DatabaseUtils.getJdbcTemplate();

    //查询是否有重复username
    @Override
    public boolean queryByUsername(String username) {
        String sql ="SELECT * FROM tb_user WHERE username=?";
        List<User> query = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class), username);
        if (query.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //查询是否有重复email
    @Override
    public boolean queryByEmail(String email) {
        String sql ="SELECT * FROM tb_user WHERE email=?";
        List<User> query = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class), email);
        if (query.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //添加一个用户（注册写入数据库）
    @Override
    public int add(User user) {
        String sql = "INSERT INTO tb_user(`username`,`password`,`email`,`gender`,`code`,`role`,`state`) VALUES(?,?,?,?,?,1,2);";
        return jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getGender(),
                user.getCode());
    }

    //激活判断（直接查改）
    @Override
    public boolean queryCode(String code) {
        String sql = "UPDATE tb_user SET flag=1 where code=?";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), code);

        if (query.size() == 1) {
            return true;
        } else {
            return false;
        }
    }


    //查询数据库是否有这条数据
    @Override
    public boolean queryByUP(String username, String password) {
        String sql = "SELECT * FROM tb_user WHERE username=? AND password=?";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username, password);

        if (query.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    //管理员登录
    @Override
    public boolean queryAdmin(String username, String password) {
        String sql = "SELECT * FROM tb_user WHERE username=? AND password=? AND role=0";
        List<User> query = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class), username, password);
        if (query.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
}

