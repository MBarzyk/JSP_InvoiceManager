package com.javagda25.jsp_invoicemanager.service;

import com.javagda25.jsp_invoicemanager.database.EntityDao;
import com.javagda25.jsp_invoicemanager.database.InvoiceDao;
import com.javagda25.jsp_invoicemanager.model.Invoice;

import java.util.List;
import java.util.Optional;

public class InvoiceService {
    private EntityDao entityDao = new EntityDao();
    private InvoiceDao invoiceDao = new InvoiceDao();

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

    public void setInvoicePaid (Long invoiceIdentifier) {
        invoiceDao.setInvoicePaid(invoiceIdentifier);
    }

    public void setRelease (Long invoiceIdentifier) {
        invoiceDao.handInvoice(invoiceIdentifier);
    }
}
