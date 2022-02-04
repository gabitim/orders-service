package com.pos.orders.repository;

import com.pos.orders.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Timofti Gabriel
 */

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
