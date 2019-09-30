package com.javagda25.jsp_invoicemanager.controller;

import com.javagda25.jsp_invoicemanager.service.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/invoice-set-paid")
public class InvoiceSetPaidServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceId = Long.parseLong(req.getParameter("invoiceId"));

        invoiceService.setInvoicePaid(invoiceId);

        resp.sendRedirect("/invoice-list");
    }
}
