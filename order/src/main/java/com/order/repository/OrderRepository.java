package com.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.order.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long>{

}
