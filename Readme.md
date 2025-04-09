# Spring Cloud Gateway and Circuit Breaker

This is a demo application comprising of following services:

| Service Name | Description |
| -------- | ----------- |
|orders-service| Manages the orders|
|products-service| Manages the products|
|discovery-service|Eureka server|
|gateway-service| Spring cloud gateway

**Order Service Endpoints**

```json
POST http://localhost:8899/orders/create

{
    "orderId":"O-001",
    "customerName": "Ashish",
    "ids":["P001", "P002", "P003"]
}
```

**Product Service Endpoints**

```json
GET http://localhost:8888/products/P001

POST http://localhost:8888/products/bulk
["P001", "P002", "P003"]
```