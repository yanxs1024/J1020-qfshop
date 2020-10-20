package com.qf.web;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收数据
        // 2. 处理数据
        // 3. 响应数据
        ValidateCode validateCode = new ValidateCode(130,30,4,10);
        validateCode.write(response.getOutputStream());

        String code = validateCode.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("captcha",code);

//        //生成图片
//        ValidateCode validateCode = new ValidateCode(150,30,4,5);
//        validateCode.write(response.getOutputStream());
//
//        //将图片保存到对应的字符串，保存到session
//        String code = validateCode.getCode();
//        HttpSession session = request.getSession();
//        session.setAttribute("captcha",code);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
