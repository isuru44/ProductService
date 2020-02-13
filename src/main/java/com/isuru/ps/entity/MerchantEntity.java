package com.isuru.ps.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "merchant")
@Data
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchantId;
    private String merchantName;
}
