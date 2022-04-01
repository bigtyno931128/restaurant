package com.bigtyno.restaurant.service;

import com.bigtyno.restaurant.dto.RestaurantRequestDto;
import com.bigtyno.restaurant.entity.Restaurant;
import com.bigtyno.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository =restaurantRepository;
    }

    public Restaurant createRestaurant(RestaurantRequestDto requestDto){

        //2. 최소주문 가격 (minOrderPrice)
        //    1. 허용값: 1,000원 ~ 100,000원 입력
        if(requestDto.getMinOrderPrice() <1000 || requestDto.getMinOrderPrice() > 100000)
            throw new IllegalArgumentException();
        //    2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원은 입력 가능)
        if(requestDto.getMinOrderPrice() %100 != 0)
            throw new IllegalArgumentException();
        //    3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
        //3. 기본 배달비 (deliveryFee)
        //    1. 허용값: 0원 ~ 10,000원
        if(requestDto.getDeliveryFee() <0 || requestDto.getDeliveryFee() >10000)
            throw new IllegalArgumentException();
        //    2. 500 원 단위로만 입력 가능 (예. 2,200원 입력 시 에러발생. 2,500원 입력 가능)
        if(requestDto.getDeliveryFee() %500 != 0)
            throw new IllegalArgumentException();
        //    3. 허용값이 아니거나 1,000원 단위 입력이 아닌 경우 에러 발생시킴

        Restaurant restaurant = new Restaurant(requestDto);

        return  restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getListRestaurant() {
        return  restaurantRepository.findAll();
    }
}
