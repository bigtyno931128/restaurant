package com.bigtyno.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;
}
