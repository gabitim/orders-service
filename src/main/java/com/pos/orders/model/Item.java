package com.pos.orders.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Timofti Gabriel
 */

@Data
@AllArgsConstructor
public class Item {
    private String isbn;
    private String title;
    private Double price;
    private Integer quantity;
}
