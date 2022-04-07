package com.bigtyno.restaurant.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Orders {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany
    @Column(nullable = false)
    private List<OrderFood> foods = new ArrayList<>();

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;


    public Orders(String restaurantName, List<OrderFood> foodOrderDtoList, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = foodOrderDtoList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
