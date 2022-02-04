package com.pos.orders.Orders.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author Timofti Gabriel
 */

@Data
@Document
public class Order {
    @Id
    private String objectId;
    private String clientId;
    private Date date;
    private List<Item> items;
    private Status status;

    public Order(String clientId, Date date, List<Item> items, Status status) {
        this.clientId = clientId;
        this.date = date;
        this.items = items;
        this.status = status;
    }
}
