package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shortDescription;
    private String longDescription;
    private Double costToBuy;
    private Double costToSell;
    @ManyToOne
    @JoinColumn(name = "idBrand")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;

}
