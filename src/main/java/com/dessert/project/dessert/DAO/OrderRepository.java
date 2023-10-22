package com.dessert.project.dessert.DAO;

import com.dessert.project.dessert.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Orders, Integer> {
}
