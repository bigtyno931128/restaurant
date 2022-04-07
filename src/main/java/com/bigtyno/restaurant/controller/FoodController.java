package com.bigtyno.restaurant.controller;

import com.bigtyno.restaurant.dto.FoodDto;
import com.bigtyno.restaurant.dto.FoodResponseDto;
import com.bigtyno.restaurant.entity.Food;
import com.bigtyno.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    //음식점에 메뉴판 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodList) {

        foodService.createFood(restaurantId, foodList);

    }

    // 음식점에 메뉴판 가져오기
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getFoodList(@PathVariable Long restaurantId) {
        return foodService.getFoodList(restaurantId);
    }
}
