package com.qf.dao.impl;

import com.qf.dao.CategoryDAO;
import com.qf.domain.Category;
import com.qf.utils.DatabaseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private JdbcTemplate jdbcTemplate = DatabaseUtils.getJdbcTemplate();

    @Override
    public int insert(Category category) {
        String sql = "INSERT INTO tb_category(name,parent,level) VALUES(?,?,?)";
        int result = jdbcTemplate.update(sql,
                category.getName(),
                category.getParent(),
                category.getLevel());

        String lastIdSql = "SELECT last_insert_id()";
        String lastId = jdbcTemplate.queryForObject(lastIdSql,String.class);
        category.setId(lastId);

        return result;
    }

    @Override
    public List<Category> queryAll() {
        String sql = "SELECT * FROM tb_category";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }
}
