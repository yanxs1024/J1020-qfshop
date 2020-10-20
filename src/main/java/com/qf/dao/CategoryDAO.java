package com.qf.dao;

import com.qf.domain.Category;

import java.util.List;

public interface CategoryDAO {

    // 插入一条DAO数据
    int insert(Category category);

    // 查询所有
    List<Category> queryAll();
}
