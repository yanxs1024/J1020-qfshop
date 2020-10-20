package com.qf.service.impl;

import com.qf.dao.DetailDAO;
import com.qf.dao.impl.DetailDAOImpl;
import com.qf.domain.Product;
import com.qf.service.DetailService;

import java.util.List;

public class DetailServiceImpl implements DetailService {
    private DetailDAO dao = new DetailDAOImpl();
    @Override
    public List<Product> showDetail(String id) {
        return dao.showDetail(id);
    }
}
