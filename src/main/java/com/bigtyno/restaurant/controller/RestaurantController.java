package com.bigtyno.restaurant.controller;

import com.bigtyno.restaurant.dto.RestaurantRequestDto;
import com.bigtyno.restaurant.entity.Restaurant;
import com.bigtyno.restaurant.repository.RestaurantRepository;
import com.bigtyno.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    //음식점 등록
    @PostMapping(" /restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto requestDto){
        return restaurantService.createRestaurant(requestDto);
    }

    //음식점 조회
    @GetMapping(" /restaurants")
    public List<Restaurant> getListRestaurant(){
        List<Restaurant> restaurantList = restaurantService.getListRestaurant();
        return restaurantList;
    }

}
