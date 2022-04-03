package com.bigtyno.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderDto(String restaurantName, List<FoodOrderDto> foodOrderDtoList, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = foodOrderDtoList;
        this.deliveryFee =deliveryFee;
        this.totalPrice = totalPrice;
    }
}
