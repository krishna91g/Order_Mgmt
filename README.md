Order Management System

Implement an order management system that has two microservices: Order Service and Order Item Service. The Order Service is responsible for creating new orders, retrieving existing order info. Similarly, Order Item Service is

responsible for creating order items, retrieving order items. Order Item has below data:

Spring boot is used for building project for order management

There are two microservices namely:

Order Service - For creating Orders

OrderItem Service - For creating Order Items

API details for Order Service as below -

Fetch all Orders URL : URL : http://localhost:8082/order-management/orders For eg : URL : http://localhost:8082/order-management/orders HTTP Method : GET

Fetch a particluar Order for a given Id URL : URL : http://localhost:8082/order-management/orders/{id} For eg : URL : http://localhost:8082/order-management/ordesr/1 HTTP Method : GET

Create order URL : http://localhost:8082/order-management/order HTTP Method : POST Request Payload example - { "customerName":"Rajiv", "shippingAddress":"Pune India", "total":"999", "orderItem": { "productCode":"PC", "productName":"Router", "quantity":10 } }

API details for OrderItem Service as below -

Fetch all Order Items URL : http://localhost:8081/order-management/orderItems For eg : http://localhost:8081/order-management/orderItems HTTP Method : GET

Fetch a particluar Order Item for a given Id URL : http://localhost:8081/order-management/orderItem/{orderItemId} For eg : http://localhost:8081/order-management/orderItem/1 HTTP Method : GET

Create Order Item URL : http://localhost:8081/order-management/orderItem HTTP Method : POST Request Payload example - {"productCode":"Nokia1100","productName":"Nokia Phone","quantity": "100"}

Note: Eureka server is configured but not being used, written a simple feign client for inter-process communication among microservices
