package com.qf.service.impl;

import com.qf.dao.ProductDAO;
import com.qf.dao.impl.ProductDAOImpl;
import com.qf.domain.Product;
import com.qf.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDAO dao = new ProductDAOImpl();

    @Override
    public boolean add(Product product) {
        return dao.insert(product) == 1;
    }
}
