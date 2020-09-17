package com.order.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.item.entity.Products;
import com.order.item.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Products> retrieveAllProducts() {
		return (List<Products>) productRepository.findAll();
	}
	public Optional<Products> retrieveProductsById(Long Id) {
		Optional<Products> productslist =  productRepository.findById(Id);
			return productslist;
			
	}
	public Products saveProduct(Products product) {
		Products prd = productRepository.save(product);
		return prd;
		
	}
  }

