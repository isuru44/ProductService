package com.isuru.ps.service;

import com.isuru.ps.dto.ProductDto;
import com.isuru.ps.entity.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<String> saveProduct(ProductDto productDto);
    ResponseEntity<ProductEntity> getProduct(Long productId);
    ResponseEntity<List<ProductEntity>> getAllProducts();
    ResponseEntity<String> updateProduct(ProductDto productDto);
    ResponseEntity<String> deleteProduct(Long productId);
}
