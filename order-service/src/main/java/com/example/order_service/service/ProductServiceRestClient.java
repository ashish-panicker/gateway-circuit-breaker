package com.example.order_service.service;

import com.example.order_service.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceRestClient {

    public List<Product> getProductsByIds(List<String> ids) {
        ResponseEntity<Product[]> response = RestClient
                                                .create()
                                                .post()
                                                .uri("http://localhost:8888/products/bulk")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .body(ids)
                                                .retrieve()
                                                .toEntity(Product[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(response.getBody());
        }
        return List.of();
    }
}
