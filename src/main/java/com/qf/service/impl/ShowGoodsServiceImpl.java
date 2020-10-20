package com.qf.service.impl;

import com.qf.dao.ShowGoodsDAO;
import com.qf.dao.impl.ShowGoodsDAOImpl;
import com.qf.domain.Product;
import com.qf.service.ShowGoodsService;

import java.util.List;

public class ShowGoodsServiceImpl implements ShowGoodsService {
    private ShowGoodsDAO dao = new ShowGoodsDAOImpl();

    @Override
    public List<Product> show() {
        return dao.show();
    }
}
