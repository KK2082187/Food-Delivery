package com.geekster.Food.Delivery.App.Repository;

import com.geekster.Food.Delivery.App.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
