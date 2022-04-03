package com.bigtyno.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodOrderRequestDto {
    Long id;
    int quantity;
}
