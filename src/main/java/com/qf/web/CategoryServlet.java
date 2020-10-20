package com.qf.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.domain.Category;
import com.qf.domain.CategoryManager;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
    protected void queryByLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();

        // 1. 接收数据
        String levelParam = request.getParameter("level");
        int level = Integer.parseInt(levelParam);


        // 2. 处理数据
        List<Category> categories = CategoryManager.queryByLevel(level);

        // 3. 响应数据
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(categories);
        out.write(jsonString);
    }

    protected void queryByParent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();

        // 1. 获取数据
        String parent = request.getParameter("parent");

        // 2. 处理数据
        List<Category> categories = CategoryManager.queryByParent(parent);

        // 3. 响应数据
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(categories);
        out.write(jsonString);
    }

    protected void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        PrintWriter out = response.getWriter();

        Map<String, String[]> parameterMap = request.getParameterMap();
        Category category = new Category();

        try {
            BeanUtils.populate(category,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CategoryManager.add(category);
    }

}

