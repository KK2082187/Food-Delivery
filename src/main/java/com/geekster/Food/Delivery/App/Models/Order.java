package com.geekster.Food.Delivery.App.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "food_order_id")
    private Long foodOrderId;

    @ManyToOne
    @JoinColumn(name="food_item_id")
    private FoodItem foodItem;

    @OneToOne
    private User user;
}
