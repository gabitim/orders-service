package com.pos.orders.api;

import com.pos.orders.exceptions.ResourceNotFoundException;
import com.pos.orders.model.Order;
import com.pos.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Timofti Gabriel
 */

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    List<Order>  getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable String id) throws ResourceNotFoundException {
        return orderService.getOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No order found with this id: " + id));
    }

    @PutMapping("/orders")
    ResponseEntity<?> addToOrder(@RequestParam(name = "itemId", required = true) String itemId) {

        try {
            orderService.addToOrder(itemId, "61fd73ddc0f520432afb72", "12415212as");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
