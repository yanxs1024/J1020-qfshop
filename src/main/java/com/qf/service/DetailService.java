package com.qf.service;

import com.qf.domain.Product;

import java.util.List;

public interface DetailService {
    List<Product> showDetail(String id);
}
