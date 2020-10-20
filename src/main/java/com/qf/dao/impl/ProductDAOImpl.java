package com.qf.dao.impl;

import com.qf.dao.ProductDAO;
import com.qf.domain.Product;
import com.qf.utils.DatabaseUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductDAOImpl implements ProductDAO {
    private JdbcTemplate jdbcTemplate = DatabaseUtils.getJdbcTemplate();

    @Override
    public int insert(Product product) {
        String sql = "INSERT INTO tb_product(name, pubDate, picture, price, star, summary, cid) VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                product.getName(),
                product.getPubDate(),
                product.getPicture(),
                product.getPrice(),
                product.getStar(),
                product.getSummary(),
                product.getCid());
    }
}
