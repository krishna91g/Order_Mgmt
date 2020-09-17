package com.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.order.entity.Orders;
import com.order.entity.Products;
import com.order.exception.CustomException;
import com.order.feign.OrderItemsFeignClient;
import com.order.service.OrderService;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/order-management")
public class OrderController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	OrderItemsFeignClient orderItemsFeignClient;
	
	/**
	 * This API is used to retrieve all orders
	 * 
	 */
	@GetMapping(value = "/orders", produces = "application/json")
	public List<Orders> getAllOrders() {
		List<Orders> order = null;
		order = orderService.retrieveAllOrders();
		if (order.size()==0) {
			throw new CustomException("No orders available");
		} else {
			return order;
		}
	}
	
	/**
	 * This API is used to retrieve orders for the given Id
	 * 
	 */
	@GetMapping("/orders/{Id}")
	public Optional<Orders> getOrdersById(@PathVariable Long Id) throws Throwable  {
		Optional<Orders> order = null;
		order =  orderService.retrieveOrderById(Id);		
		if (order == null || !order.isPresent()) {
			throw new CustomException("No orders available for the Order Id::" + Id);
		} else {
			return order;
		}
		
	}
			
	/**
	 * This API is used to save new Order
	 * 
	 */
	@PostMapping(value = "/order")
	public Orders saveOrder(@RequestBody @Valid Orders order) {
		Products prduct = new Products("PC","Router",99);
		order.getProducts().add(prduct);
		return orderService.saveOrders(order);
		
	}
	/**
	 * This API is used to fetch all Order Items from OrderItem MS using feign Client
	 * 
	 */
	
	@GetMapping("/orderItems")
	public List<Products> getAllProduct(){
		List<Products> products = null;
		products = orderItemsFeignClient.retrieveAllProducts();
		if (products.size()==0) {
			throw new CustomException("No products available");
		} else {
			return products;
		}
	}
	
	/**
	 * This API is used to fetch Order Items from OrderItem MS for a given Id using feign Client
	 * 
	 */
	
	@GetMapping("/orderItems/{Id}")
	public Optional<Products> getProductsById(@PathVariable Long Id) {
		Optional<Products> prd = orderItemsFeignClient.retrieveProductsById(Id);
		if (!prd.isPresent())
			throw new CustomException("No products available for the Product Code::" + Id);
		else
			return prd;

	}
}
