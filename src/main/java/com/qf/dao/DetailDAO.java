package com.qf.dao;

import com.qf.domain.Product;

import java.util.List;

public interface DetailDAO {
    List<Product> showDetail(String id);
}
