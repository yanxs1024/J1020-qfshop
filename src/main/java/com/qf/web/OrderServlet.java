package com.qf.web;

import com.qf.service.OrderService;
import com.qf.service.impl.OrderServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/order")
@MultipartConfig
public class OrderServlet extends BaseServlet {
    private OrderService service = new OrderServiceImpl();

    protected void creatOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");

        String loginId = request.getParameter("loginId");
        String goodsId = request.getParameter("goodsId");
        String time = request.getParameter("time");
        String amount = request.getParameter("amount");

        HttpSession session = request.getSession();

        service.creatOrder(loginId,goodsId,time,amount);
        response.sendRedirect("orderSuccess.jsp");
    }


}
