package com.qf.service.impl;

import com.qf.dao.OrderDAO;
import com.qf.dao.impl.OrderDAOImpl;
import com.qf.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDAO dao = new OrderDAOImpl();

    @Override
    public void creatOrder(String loginId, String goodsId, String time, String amount) {
        dao.creatOrder(loginId,goodsId,time,amount);
    }
}
