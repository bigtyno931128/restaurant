package com.bigtyno.restaurant.controller;

import com.bigtyno.restaurant.dto.RestaurantRequestDto;
import com.bigtyno.restaurant.entity.Restaurant;
import com.bigtyno.restaurant.repository.RestaurantRepository;
import com.bigtyno.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
