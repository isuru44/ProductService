package com.isuru.ps.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductDto {
    private Long productId;
    private String title;
    private String url;
    private Double price;
    private Double msrp;
    private Boolean isAvailable;
    private String description;
    private CategoryDto category;
    private MerchantDto merchant;
}
