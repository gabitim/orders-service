package com.pos.orders.service;

import com.pos.orders.model.Item;
import com.pos.orders.model.Order;
import com.pos.orders.model.Status;
import com.pos.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Timofti Gabriel
 */

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public void addToOrder(String itemId, String orderId, String userId) {
        //mock item
        Item newItem = new Item(itemId, "Carte 1", 23.2, 2);

        orderRepository.findById(orderId)
                .map(order -> {
                    List<Item> currentItems = order.getItems();
                    currentItems.add(newItem);
                    order.setItems(currentItems);

                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    Order newOrder = new Order(
                            userId,
                            new Date(System.currentTimeMillis()),
                            List.of(newItem),
                            Status.NotInitialized);

                    return orderRepository.save(newOrder);
                });
    }
}
