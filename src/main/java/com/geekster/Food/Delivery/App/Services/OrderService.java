package com.geekster.Food.Delivery.App.Services;

import com.geekster.Food.Delivery.App.Models.FoodItem;
import com.geekster.Food.Delivery.App.Models.Order;
import com.geekster.Food.Delivery.App.Models.User;
import com.geekster.Food.Delivery.App.Repository.IFoodItemRepo;
import com.geekster.Food.Delivery.App.Repository.IOrderRepo;
import com.geekster.Food.Delivery.App.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
     IOrderRepo iOrderRepo;
    @Autowired
     IUserRepo iUserRepo;
    @Autowired
     IFoodItemRepo iFoodItemRepo;
    public List<Order> getAllOrders() {
        return iOrderRepo.findAll();
    }
    public Order getOrderById(Long orderId){
        return iOrderRepo.findByFoodOrderId(orderId);
    }

    public Order createOrder(Order order) {
        User user  = iUserRepo.findByUserId(order.getUser().getUserId());
        order.setUser(user);
        FoodItem foodItem = iFoodItemRepo.findByFoodItemId(order.getFoodItem().getFoodItemId());
        order.setFoodItem(foodItem);
        return iOrderRepo.save(order);
    }
}
