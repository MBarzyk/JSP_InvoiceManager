package com.javagda25.jsp_invoicemanager.controller;

import com.javagda25.jsp_invoicemanager.model.Invoice;
import com.javagda25.jsp_invoicemanager.service.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/invoice-list")
public class InvoiceListServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Invoice> invoices = invoiceService.getAll();

        req.setAttribute("invoiceList", invoices);

        req.getRequestDispatcher("/invoice-list.jsp").forward(req, resp);
    }
}
