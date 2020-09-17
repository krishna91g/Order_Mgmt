package com.order.item.repository;


import org.springframework.data.repository.CrudRepository;

import com.order.item.entity.Products;

public interface ProductRepository extends CrudRepository<Products, Long>{
	
}
