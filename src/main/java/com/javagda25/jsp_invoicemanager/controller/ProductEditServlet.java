package com.javagda25.jsp_invoicemanager.controller;

import com.javagda25.jsp_invoicemanager.model.Invoice;
import com.javagda25.jsp_invoicemanager.model.Product;
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

@WebServlet("/product-edit")
public class ProductEditServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productId = Long.parseLong(req.getParameter("productId"));

        Optional<Product> productToEdit = productService.getById(productId);
        if (productToEdit.isPresent()) {
            Product product = productToEdit.get();

            req.setAttribute("invoiceId", product.getInvoice().getId());
            req.setAttribute("productId", product.getId());
            req.setAttribute("productName", product.getName());
            req.setAttribute("productPrice", product.getPrice());
            req.setAttribute("productTaxType", product.getTaxType());
            req.setAttribute("productStock", product.getStock());

            req.getRequestDispatcher("/product-add.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/product-add");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Long invoiceIdentifier = Long.parseLong(req.getParameter("invoice_getting_products"));

        Optional<Invoice> invoiceOptional = invoiceService.getInvoiceById(invoiceIdentifier);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();

            Long editedProductId = Long.valueOf(req.getParameter("product_id"));
            String name = req.getParameter("product_name");
            double price = Double.parseDouble(req.getParameter("product_price"));
            TaxType taxType = TaxType.valueOf(req.getParameter("product_taxtype"));
            int stock = Integer.parseInt(req.getParameter("product_stock"));

            Product editedProduct = new Product(editedProductId, name, price, taxType, stock);

            editedProduct.setInvoice(invoice);

            productService.update(editedProduct);

            resp.sendRedirect("/product-list?invoiceId=" + invoiceIdentifier);
        }
    }
}
