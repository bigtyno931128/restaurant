package com.bigtyno.restaurant.repository;


import com.bigtyno.restaurant.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
