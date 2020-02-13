package com.isuru.ps.controller;

import com.isuru.ps.dto.ProductDto;
import com.isuru.ps.entity.ProductEntity;
import com.isuru.ps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntity> getAllProduct(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @PutMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId){
        return productService.deleteProduct(productId);
    }
    
}
