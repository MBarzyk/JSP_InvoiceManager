package com.javagda25.jsp_invoicemanager.service;

import com.javagda25.jsp_invoicemanager.database.EntityDao;
import com.javagda25.jsp_invoicemanager.model.Invoice;

import java.util.List;
import java.util.Optional;

public class InvoiceService {
    private EntityDao entityDao = new EntityDao();

    public InvoiceService() {
    }

    public void addInvoice(String clientName, String clientNIP, String clientAddress) {
        entityDao.saveOrUpdate(new Invoice(clientName, clientNIP, clientAddress));
    }

    public List<Invoice> getAll() {
        return entityDao.getall(Invoice.class);
    }

    public Optional<Invoice> getInvoiceById(Long invoiceIdentifier) {
        return entityDao.getById(Invoice.class, invoiceIdentifier);
    }
}
