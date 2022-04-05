package com.bigtyno.restaurant.utils;

import com.bigtyno.restaurant.dto.FoodDto;
import com.bigtyno.restaurant.dto.RestaurantRequestDto;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public static void ValidFood(FoodDto foodDto) {
        // 허용값 1000 이상 1000이상 100만원 이하
        if (foodDto.getPrice() < 1000 || foodDto.getPrice() >1000000){
            throw new IllegalArgumentException("허용가격에 해당하지 않습니다.");
        }
        // 100원 단위
        if (foodDto.getPrice() % 100 != 0){
            throw new IllegalArgumentException("백원 단위 아닙니다.");
        }
    }

    public static void ValidRestaurant(RestaurantRequestDto requestDto) {
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
    }
}
