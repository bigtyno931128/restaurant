package com.bigtyno.restaurant.entity;

import com.bigtyno.restaurant.dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Orders {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany
    @Column(nullable = false)
    private List<OrderFood> orderFoodList;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;


    public Orders(String restaurantName, List<OrderFood> foodOrderDtoList, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.orderFoodList = foodOrderDtoList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
