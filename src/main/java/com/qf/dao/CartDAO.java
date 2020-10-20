package com.qf.dao;

import com.qf.domain.Cart;

import java.util.List;

public interface CartDAO {
    void addCart(String loginId, String goodsId, String price);

    List<Cart> getCart(String loginId);

    int count(String loginId);
}
