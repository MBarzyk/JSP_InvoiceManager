package com.javagda25.jsp_invoicemanager.controller;

import com.javagda25.jsp_invoicemanager.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product-delete")
public class ProductDeleteServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productId = Long.parseLong(req.getParameter("productId"));


        productService.deleteProduct(productId);


        resp.sendRedirect("/product-list");
    }
}
