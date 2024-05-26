package com.nestor.data;

import com.nestor.model.Order;

public interface OrderRepository {
	Order save(Order order);
}
