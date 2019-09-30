package com.javagda25.jsp_invoicemanager.service;

import com.javagda25.jsp_invoicemanager.database.EntityDao;
import com.javagda25.jsp_invoicemanager.model.Invoice;
import com.javagda25.jsp_invoicemanager.model.Product;
import com.javagda25.jsp_invoicemanager.model.TaxType;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private EntityDao entityDao = new EntityDao();

    public ProductService() {
    }


    public void addProduct(Invoice invoice, String name, double price, TaxType taxType, int stock) {
        Product product = new Product(name, price, taxType, stock);
        product.setInvoice(invoice);
        entityDao.saveOrUpdate(product);
    }

    public List<Product> findAll() {
        return entityDao.getall(Product.class);
    }

    public void deleteProduct(Long id) {
        entityDao.delete(Product.class, id);
    }

    public Optional<Product> getById(Long id) {
       return entityDao.getById(Product.class, id);
    }

    public void update (Product product) {
        entityDao.saveOrUpdate(product);
    }
}
