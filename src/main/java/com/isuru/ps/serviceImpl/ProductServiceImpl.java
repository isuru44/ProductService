package com.isuru.ps.serviceImpl;

import com.isuru.ps.dto.ProductDto;
import com.isuru.ps.entity.CategoryEntity;
import com.isuru.ps.entity.MerchantEntity;
import com.isuru.ps.entity.ProductEntity;
import com.isuru.ps.repository.ProductRepository;
import com.isuru.ps.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<String> saveProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productDto,productEntity);

        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(productDto.getCategory(),categoryEntity);
        productEntity.setCategory(categoryEntity);

        MerchantEntity merchantEntity = new MerchantEntity();
        BeanUtils.copyProperties(productDto.getMerchant(),merchantEntity);
        productEntity.setMerchant(merchantEntity);

        productRepository.save(productEntity);
        return ResponseEntity.ok("Saved");
    }

    @Override
    public ResponseEntity<ProductEntity> getProduct(Long productId) {
        ProductEntity entity = productRepository.findByProductId(productId);
        return ResponseEntity.ok(entity);
    }

    @Override
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> list = productRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<String> updateProduct(ProductDto productDto) {
        return saveProduct(productDto);
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long productId) {
        ProductEntity entity = productRepository.findByProductId(productId);
        productRepository.delete(entity);;
        return ResponseEntity.ok("Deleted");
    }
}
