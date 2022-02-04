package com.pos.orders.Orders;

import com.pos.orders.Orders.model.Item;
import com.pos.orders.Orders.model.Order;
import com.pos.orders.Orders.model.Status;
import com.pos.orders.Orders.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(OrderRepository orderRepository) {
		return args -> {

			List<Item> items = new ArrayList<>();
			items.add(new Item("1", "Carte 1", 23.2, 2));
			items.add(new Item("2", "Carte 2", 24.2, 3));
			Order order = new Order(
					"12412",
					new Date(System.currentTimeMillis()),
					items,
					Status.Initialized
			);
			orderRepository.insert(order);
		};
	}
}
