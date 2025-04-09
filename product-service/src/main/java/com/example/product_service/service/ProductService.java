package com.example.product_service.service;

import com.example.product_service.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = List.of(
            new Product("P001", "Wireless Mouse", "Ergonomic wireless mouse", 25.99),
            new Product("P002", "Gaming Keyboard", "Mechanical keyboard with RGB lighting", 79.49),
            new Product("P003", "Laptop Stand", "Aluminum stand for laptops", 32.99),
            new Product("P004", "HD Monitor", "24-inch full HD monitor", 149.99),
            new Product("P005", "Webcam", "1080p webcam with built-in microphone", 59.99),
            new Product("P006", "USB-C Hub", "6-in-1 USB-C hub", 39.95),
            new Product("P007", "External SSD", "1TB portable SSD", 119.95),
            new Product("P008", "Bluetooth Speaker", "Portable Bluetooth speaker", 45.50),
            new Product("P009", "Wireless Charger", "Fast wireless charging pad", 29.90),
            new Product("P010", "Noise Cancelling Headphones", "Over-ear noise cancelling headphones", 199.00)
    );

    public Optional<Product> findProduct(String productId){
        return products.stream().filter(p -> p.getProductId().equals(productId)).findFirst();
    }

}
