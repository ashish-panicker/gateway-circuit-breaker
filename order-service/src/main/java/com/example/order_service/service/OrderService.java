package com.example.order_service.service;

import com.example.order_service.model.Order;
import com.example.order_service.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final ProductService productService;
    private final List<Order> orders = new ArrayList<>();

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> fetchProducts(List<String> ids){
        return productService.getProductsByIds(ids);
    }

    public List<Order> findAllOrders(){
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }
}
