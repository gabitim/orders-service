package com.pos.orders.Orders.repository;

import com.pos.orders.Orders.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Timofti Gabriel
 */
public interface OrderRepository extends MongoRepository<Order, String> {
}
