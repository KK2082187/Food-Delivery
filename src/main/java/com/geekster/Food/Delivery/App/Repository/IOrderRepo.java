package com.geekster.Food.Delivery.App.Repository;

import com.geekster.Food.Delivery.App.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo  extends JpaRepository<Order,Long>{
    Order findByFoodOrderId(Long orderId);
}
