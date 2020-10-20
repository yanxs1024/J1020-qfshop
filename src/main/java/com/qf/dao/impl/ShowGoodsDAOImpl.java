package com.qf.dao.impl;

import com.qf.dao.ShowGoodsDAO;
import com.qf.domain.Product;
import com.qf.utils.DatabaseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ShowGoodsDAOImpl implements ShowGoodsDAO {
    private JdbcTemplate jdbcTemplate = DatabaseUtils.getJdbcTemplate();

    @Override
    public List<Product> show() {
        String sql = "SELECT * FROM tb_product";
        List<Product> show = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return show;
    }
}
