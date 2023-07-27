package com.geekster.Food.Delivery.App.Controllers;

import com.geekster.Food.Delivery.App.Models.FoodItem;
import com.geekster.Food.Delivery.App.Models.Order;
import com.geekster.Food.Delivery.App.Services.FoodItemService;
import com.geekster.Food.Delivery.App.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/foodItem")
    public List<FoodItem> getAllFoodItem(){
        return foodItemService.getAllFoodItem();
    }
    @GetMapping("/foodItem/{id}")
    public FoodItem getFoodItemById(@PathVariable Long id){
        return foodItemService.getFoodItemById(id);
    }
    @PostMapping("/foodItem")
    public ResponseEntity<String> createFoodItem(@RequestBody FoodItem foodItem){
        HttpStatus status;
        String msg = "";
        if(foodItemService.addFoodItem(foodItem)){
            msg = "Food item added";
            status = HttpStatus.ACCEPTED;
        }else{
            msg = "Invalid data";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(msg,status);
    }

    @DeleteMapping("/foodItem/{id}")
    public void deleteFoodItem(@PathVariable Long id){
        foodItemService.deleteFoodItem(id);
    }
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
