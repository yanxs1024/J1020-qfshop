package com.qf.web;

import com.qf.domain.Cart;
import com.qf.domain.Product;
import com.qf.service.CartService;
import com.qf.service.DetailService;
import com.qf.service.ProductService;
import com.qf.service.ShowGoodsService;
import com.qf.service.impl.CartServiceImpl;
import com.qf.service.impl.DetailServiceImpl;
import com.qf.service.impl.ProductServiceImpl;
import com.qf.service.impl.ShowGoodsServiceImpl;
import com.qf.utils.FileUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/product")
@MultipartConfig
public class ProductServlet extends BaseServlet {
    private ProductService service = new ProductServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 更新数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        Product product = new Product();
        try {
            BeanUtils.populate(product, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String latinName = request.getParameter("name");
        String utf8Name = new String(latinName.getBytes("iso-8859-1"), "utf-8");
        product.setName(utf8Name);

        String lstinSummary = request.getParameter("summary");
        String utf8Summary = new String(lstinSummary.getBytes("iso-8859-1"), "utf-8");
        product.setSummary(utf8Summary);

        // 存图片
        Part picture = request.getPart("picture");
        String relativePath = FileUtils.storage(picture);

        // 设置图片属性
        product.setPicture(relativePath);

        service.add(product);
    }


    protected void showGoods(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");

        ShowGoodsService service = new ShowGoodsServiceImpl();

        List<Product> glist = service.show();

        ServletContext servletContext = request.getServletContext();

        servletContext.setAttribute("glist", glist);

        request.getRequestDispatcher("/goodsList.jsp").forward(request, response);

    }

    protected void showDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");

        DetailService service = new DetailServiceImpl();

        String id = request.getParameter("id");

        List<Product> goods = service.showDetail(id);

        ServletContext application = request.getServletContext();

        application.setAttribute("goods", goods.get(0));

        request.getRequestDispatcher("/goodsDetail.jsp").forward(request, response);

    }

    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");

        String loginId = request.getParameter("loginId");
        String goodsId = request.getParameter("goodsId");
        String price = request.getParameter("price");

        HttpSession session = request.getSession();

//        if (loginId == null) {
//            //登录
////            session.setAttribute("msg", "添加购物车必须先登录！");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        } else {
            CartService service = new CartServiceImpl();

            service.addCart(loginId, goodsId, price);
            response.sendRedirect("cartSuccess.jsp");
//        }
    }

    protected void getCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");

        String loginId = request.getParameter("loginId");

        CartService service = new CartServiceImpl();
        List<Cart> carts = service.getCart(loginId);

        ServletContext application = request.getServletContext();
        application.setAttribute("carts", carts);

        request.getRequestDispatcher("/cart.jsp").forward(request, response);

    }


}