package com.bigtyno.restaurant.repository;

import com.bigtyno.restaurant.entity.Food;
import com.bigtyno.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    //같은 음식점 내에서는 음식 이름이 중복될 수 없다.
    boolean existsByRestaurantAndName(Restaurant restaurant, String name);

    List<Food> findAllByRestaurant(Restaurant restaurant);
}
