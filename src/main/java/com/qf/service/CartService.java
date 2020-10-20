package com.qf.service;

import com.qf.domain.Cart;

import java.util.List;

public interface CartService {
    void addCart(String loginId, String goodsId, String price);

    List<Cart> getCart(String goodsId);

    int Count(String loginId);
}
