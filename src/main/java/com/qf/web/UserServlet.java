package com.qf.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import com.qf.utils.EmailUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/user")
@MultipartConfig
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();

    //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();

        // 1. 接收数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vcode = request.getParameter("vcode");

        HttpSession session = request.getSession();
        String captcha = (String) session.getAttribute("captcha");

        // 2. 处理数据
        Map<String, Object> responseObj = new HashMap<>();
        boolean queryByUP = service.queryByUP(username, password);

        if (!vcode.equalsIgnoreCase(captcha)) {
            responseObj.put("succsee", false);
            responseObj.put("msg", "你验证怎么输的？");
        } else if (queryByUP == true) {
            responseObj.put("success", true);
            responseObj.put("msg", "operation success");

        } else {
            responseObj.put("success", false);
            responseObj.put("msg", "用户名或密码错误，请重新输入");
        }

        // 3. 响应数据
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(responseObj));
    }

    //注册
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");
        // PrintWriter out = response.getWriter();

        // 1. 接收数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 2. 处理数据
        //生成激活码
        UUID code = UUID.randomUUID();

        //发送邮件
        String Code = code.toString();
        EmailUtils.sendRegisterSuccess(request.getParameter("email"), Code);
        user.setCode(Code);

        // 3. 响应数据
        service.add(user);
    }

    //检查邮箱
    protected void check_email(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text:plain;charset=utf-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");

        boolean queryByEmail = service.queryByEmail(email);

        if (queryByEmail == true) {
            out.write("true");
        } else {
            out.write("false");
        }
    }

    //检查用户名
    protected void check_username(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");

        PrintWriter out = response.getWriter();

        // 1. 接收数据
        String username = request.getParameter("username");

        // 2. 处理数据
        boolean queryByUsername = service.queryByUsername(username);
        if (queryByUsername == true) {
            out.write("true");
        } else {
            out.write("false");
        }
    }

    //激活
    protected void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out = response.getWriter();

        String code = request.getParameter("code");
        boolean queryCode = service.queryCode(code);

        if (queryCode == true) {
            out.write("true");
        } else {
            out.write("false");
        }
    }

    //展示个人信息
    protected void showUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        request.getSession().setAttribute("user",username);
        response.sendRedirect("index.jsp");
    }


    //管理员登录
    protected void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HashMap<Object, Object> responseObj = new HashMap<>();
        boolean queryAdmin = service.queryAdmin(username, password);

        if (queryAdmin == true) {
            responseObj.put("success", true);
            responseObj.put("msg", "operation success");

        } else {
            responseObj.put("success", false);
            responseObj.put("msg", "用户名或密码错误，请重新输入");
        }
    }

}