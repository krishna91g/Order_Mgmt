package com.order.item.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.item.entity.Products;
import com.order.item.exception.CustomException;
import com.order.item.service.ProductService;

/**
 * @author Krishna
 *
 */
@RestController
@Validated
@RequestMapping("/order-management")
public class OrderItemController {

	@Autowired
	private ProductService productService;
	
	/*
	 * This API is used to retrieve all products
	 * 
	 */
	
	@GetMapping("/orderItems")
	public List<Products> retrieveAllProducts() {
		List<Products> products = null;
		products = productService.retrieveAllProducts();
		if (products.size() == 0)
			throw new CustomException("No products available");
		else
			return products;

	}

	/*
	 * This API is used to retrieve products for the given product code
	 * 
	 */
	@GetMapping("/orderItems/{Id}")
	public Optional<Products> retrieveProductsById(@PathVariable Long Id) {
		Optional<Products> prd = productService.retrieveProductsById(Id);
		if (!prd.isPresent())
			throw new CustomException("No products available for the Product Code::" + Id);
		else
			return prd;

	}

	/*
	 * This API is used to create product *
	 */

	@PostMapping(value = "/orderItem")
	public Products saveProducts(@RequestBody @Valid Products product) {
		return productService.saveProduct(product);

	}
	
		
}
