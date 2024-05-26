package com.nestor.data;

import org.springframework.data.repository.CrudRepository;

import com.nestor.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
