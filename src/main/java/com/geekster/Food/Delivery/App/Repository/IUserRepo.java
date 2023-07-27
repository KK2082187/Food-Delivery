package com.geekster.Food.Delivery.App.Repository;

import com.geekster.Food.Delivery.App.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    User findByUserId(Long userId);
    User findFirstByUserEmail(String userEmail);
}
