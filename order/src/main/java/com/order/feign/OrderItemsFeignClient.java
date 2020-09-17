package com.order.feign;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.entity.Products;

@FeignClient(name="OrderItem",url="http://localhost:8081/order-management")
public interface OrderItemsFeignClient {
	/**
	 * Interface method to get the products information from a different microservice.
	 * @return
	 */
	@GetMapping("/orderItems")
	public List<Products> retrieveAllProducts();
	
	@GetMapping("/orderItems/{Id}")
	public Optional<Products> retrieveProductsById(@PathVariable Long Id);
	
}
