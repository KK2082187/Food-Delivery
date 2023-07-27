package com.geekster.Food.Delivery.App.Controllers;

import com.geekster.Food.Delivery.App.Models.Order;
import com.geekster.Food.Delivery.App.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Order createOrder(@RequestParam String userEmail, @RequestParam String token, @RequestBody Order order){
        return orderService.createOrder(order);
    }
    @GetMapping("/getOrder/{orderId}")
    public Order getOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }
}
