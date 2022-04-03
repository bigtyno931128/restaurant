package com.bigtyno.restaurant.repository;



import com.bigtyno.restaurant.entity.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFoodRepository extends JpaRepository<OrderFood,Long> {
}
