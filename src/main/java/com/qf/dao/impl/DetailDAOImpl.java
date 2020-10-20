package com.qf.dao.impl;

import com.qf.dao.DetailDAO;
import com.qf.domain.Product;
import com.qf.utils.DatabaseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DetailDAOImpl implements DetailDAO {
    private JdbcTemplate jdbcTemplate = DatabaseUtils.getJdbcTemplate();

    @Override
    public List<Product> showDetail(String id) {
        String sql = "SELECT * FROM tb_product WHERE id=?";

        List<Product> showDetail = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), id);

        return showDetail;
    }
}
