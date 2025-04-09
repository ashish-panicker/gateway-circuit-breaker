package com.example.order_service.service;

import com.example.order_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductService {

    @PostMapping("/products/bulk")
    public List<Product> getProductsByIds(@RequestBody List<String> ids);
}
