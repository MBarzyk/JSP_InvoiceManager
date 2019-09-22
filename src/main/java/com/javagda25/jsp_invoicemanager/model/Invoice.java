package com.javagda25.jsp_invoicemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dateOfCreation;

    @Column(nullable = false)
    private String clientName;

    @Column(length = 10)
    private String clientNip;

    private String clientAddress;

    @Column(nullable = false, columnDefinition = "tinyint default 0")
    private boolean paid;

    private LocalDateTime dateOfRelease;
    private LocalDateTime dateOfPayment;

    @Formula(value = "(SELECT SUM(p.price * p.stock) from product p where p.invoice_id = id)")
    private Double billValue;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private List<Product> productList;


    public Invoice(String clientName, String clientNIP, String clientAddress) {
        this.clientName = clientName;
        this.clientNip = clientNIP;
        this.clientAddress = clientAddress;
    }
}
