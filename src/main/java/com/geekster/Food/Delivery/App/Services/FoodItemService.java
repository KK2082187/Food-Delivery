package com.geekster.Food.Delivery.App.Services;

import com.geekster.Food.Delivery.App.Models.FoodItem;
import com.geekster.Food.Delivery.App.Repository.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodItemService {
    @Autowired
    private IFoodItemRepo foodItemRepo;
    public List<FoodItem> getAllFoodItem() {
        return foodItemRepo.findAll();
    }
    public FoodItem createFoodItem(FoodItem foodItem){
        return foodItemRepo.save(foodItem);
    }

    public FoodItem getFoodItemById(Long id) {
        return foodItemRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("food item not find"));
    }

    public void deleteFoodItem(Long id) {
        foodItemRepo.deleteById(id);
    }
    public boolean addFoodItem(FoodItem foodItem){
        foodItemRepo.save(foodItem);
        return true;
    }
}
