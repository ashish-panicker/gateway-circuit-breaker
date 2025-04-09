package com.example.order_service.controller;

public record OrderCreateRequest(
        String orderId, String customerName, String[] ids
) {
}
