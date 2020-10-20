package com.qf.dao;

public interface OrderDAO {
    void creatOrder(String loginId, String goodsId, String time, String amount);
}
