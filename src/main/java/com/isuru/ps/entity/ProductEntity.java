package com.isuru.ps.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long productId;
    private String title;
    private String url;
    private Double price;
    private Double msrp;
    private String description;
    private Boolean isAvailable;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="category_id", nullable=false)
    private CategoryEntity category;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="merchant_id", nullable=false)
    private MerchantEntity merchant;
}
