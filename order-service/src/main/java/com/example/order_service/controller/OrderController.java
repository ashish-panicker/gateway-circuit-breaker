package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.model.Product;
import com.example.order_service.service.OrderService;
import feign.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderCreateRequest request){
        List<Product> products = orderService.fetchProducts(Arrays.asList(request.ids()));
        Order order = new Order(request.orderId(), request.customerName(), products);
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Order Service error occurred: " + ex.getMessage());
    }
}
