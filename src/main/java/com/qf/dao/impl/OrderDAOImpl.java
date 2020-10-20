package com.qf.dao.impl;

import com.qf.dao.OrderDAO;
import com.qf.utils.DatabaseUtils;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void creatOrder(String loginId, String goodsId, String time,String amount) {
        String sql = "INSERT INTO tb_order (id,total_mount,state,creation_time,uid) VALUE(?,?,?,?,?)";
        int update = DatabaseUtils.getJdbcTemplate().update(sql,
                goodsId,
                amount,
                1,
                time,
                loginId);
    }
}
