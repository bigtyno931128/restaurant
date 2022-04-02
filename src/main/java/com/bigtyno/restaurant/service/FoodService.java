package com.bigtyno.restaurant.service;

import com.bigtyno.restaurant.dto.FoodDto;
import com.bigtyno.restaurant.entity.Food;
import com.bigtyno.restaurant.entity.Restaurant;
import com.bigtyno.restaurant.repository.FoodRepository;
import com.bigtyno.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository,RestaurantRepository restaurantRepository){
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }
    
    //메뉴판 등록
    @Transactional
    public void createFood(Long restaurantId, List<FoodDto> foodList){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException(""));

        for(FoodDto foodDto:foodList) {
            // 음식점에는 중복된 음식이름 사용 불가
            //System.out.println(restaurant.getId());
           //System.out.println(foodDto.getName());
            if (foodRepository.existsByRestaurantAndName(restaurant, foodDto.getName())) {
                throw new IllegalArgumentException("음식명이 중복안됩니다.");

            }
            // 허용값 1000 이상 1000이상 100만원 이하
            //System.out.println(foodDto.getPrice());
            if (foodDto.getPrice() < 1000 || foodDto.getPrice() >1000000){
                throw new IllegalArgumentException("허용가격에 해당하지 않습니다.");
            }
            // 100원 단위

            if (foodDto.getPrice() % 100 != 0){
                throw new IllegalArgumentException("백원 단위 아닙니다.");
            }
                Food food = new Food(restaurant, foodDto);
                foodRepository.save(food);
        }
    }
    
    //메뉴판가져오기
    public List<Food> getFoodList(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                IllegalArgumentException::new);
        return foodRepository.findAllByRestaurant(restaurant);
    }
}
