package com.javagda25.jsp_invoicemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @Formula(value = "(case when (taxType='PRODUCTS') then (price*0.23) when (taxType='SERVICES') then (price*0.08) end)")
    private double taxValue;

    @Enumerated(EnumType.STRING)
    private TaxType taxType;

    private int stock;

    @ToString.Exclude
    @ManyToOne()
    private Invoice invoice;

    public Product(String name, double price, TaxType taxType, int stock) {
        this.name = name;
        this.price = price;
        this.taxType = taxType;
        this.stock = stock;
    }

    public Product(Long editedProductId, String name, double price, TaxType taxType, int stock) {
        this.id = editedProductId;
        this.name = name;
        this.price = price;
        this.taxType = taxType;
        this.stock = stock;
    }
}
