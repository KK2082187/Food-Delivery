package com.geekster.Food.Delivery.App.Repository;

import com.geekster.Food.Delivery.App.Models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodItemRepo extends JpaRepository<FoodItem,Long> {
    FoodItem findByFoodItemId(Long foodItemId);
}
