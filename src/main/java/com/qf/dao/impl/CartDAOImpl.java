package com.qf.dao.impl;

import com.qf.dao.CartDAO;
import com.qf.domain.Cart;
import com.qf.utils.DatabaseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class CartDAOImpl implements CartDAO {


    @Override
    public void addCart(String loginId, String goodsId, String price) {
        String sql="insert into tb_cart (uid,pid,Num,money) values (?,?,?,?)";
        int update = DatabaseUtils.getJdbcTemplate().update(sql,
                1,
                goodsId,
                1,
                price);

    }

    @Override
    public List<Cart> getCart(String loginId) {
        String sql = "SELECT * FROM tb_cart WHERE uid=?";
        List<Cart> query = DatabaseUtils.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Cart.class), 1);
        return query;
    }

    @Override
    public int count(String loginId) {
        String sql="select sum(money) from tb_cart where uid=?";
        Integer integer = DatabaseUtils.getJdbcTemplate().queryForObject(sql, Integer.class, 1);
        return integer;
    }
}
