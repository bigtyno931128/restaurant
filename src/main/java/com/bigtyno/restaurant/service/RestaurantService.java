package com.bigtyno.restaurant.service;

import com.bigtyno.restaurant.dto.RestaurantRequestDto;
import com.bigtyno.restaurant.entity.Restaurant;
import com.bigtyno.restaurant.repository.RestaurantRepository;
import com.bigtyno.restaurant.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository =restaurantRepository;
    }

    public Restaurant registeredRestaurant(RestaurantRequestDto requestDto){
        //    1. 허용값: 1,000원 ~ 100,000원 입력
        Validator.ValidRestaurant(requestDto);
        Restaurant restaurant = new Restaurant(requestDto);


        return  restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getListRestaurant() {
        return  restaurantRepository.findAll();
    }
}
