package com.example.product_service.controller;

import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productService.findProduct(id)
                .map(product -> ResponseEntity.ok(product))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Product>> getProductsByIds(@RequestBody List<String> ids) {
        List<Product> productList = ids.stream()
                .map(id -> productService.findProduct(id)
                        .map(product -> product)
                        .orElseThrow(() -> new RuntimeException("No product available for id {"+id+"}")))
                .toList();
        return ResponseEntity.ok(productList);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }

}
