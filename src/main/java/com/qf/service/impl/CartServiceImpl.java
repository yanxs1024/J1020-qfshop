package com.qf.service.impl;

import com.qf.dao.CartDAO;
import com.qf.dao.impl.CartDAOImpl;
import com.qf.domain.Cart;
import com.qf.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
   private CartDAO dao = new CartDAOImpl();


    @Override
    public void addCart(String loginId, String goodsId, String price) {
        dao.addCart(loginId,goodsId,price);
    }

    @Override
    public List<Cart> getCart(String loginId) {
        return dao.getCart(loginId);
    }

    @Override
    public int Count(String loginId) {
        return dao.count(loginId);
    }
}
