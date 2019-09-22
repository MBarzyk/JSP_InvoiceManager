package com.javagda25.jsp_invoicemanager.controller;

import com.javagda25.jsp_invoicemanager.model.Invoice;
import com.javagda25.jsp_invoicemanager.model.TaxType;
import com.javagda25.jsp_invoicemanager.service.InvoiceService;
import com.javagda25.jsp_invoicemanager.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/product-add")
public class ProductAddServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceId = Long.parseLong(req.getParameter("invoiceId"));

        req.setAttribute("invoiceId", invoiceId);

        req.getRequestDispatcher("/product-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceIdentifier = Long.parseLong(req.getParameter("invoice_getting_products"));

        Optional<Invoice> invoiceOptional = invoiceService.getInvoiceById(invoiceIdentifier);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();

            String name = req.getParameter("product_name");
            double price = Double.parseDouble(req.getParameter("product_price"));
            TaxType taxType = TaxType.valueOf(req.getParameter("product_taxtype"));
            int stock = Integer.parseInt(req.getParameter("product_stock"));

            productService.addProduct(invoice, name, price, taxType, stock);
            resp.sendRedirect("/product-list?invoiceId=" + invoiceIdentifier);
        }
    }
}
