package com.bigtyno.restaurant.entity;

import com.bigtyno.restaurant.dto.RestaurantRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name ="RESTAURANT_ID")
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

//    @OneToMany(mappedBy = "food", fetch = FetchType.EAGER)
//    @JsonIgnoreProperties({"food"})
//    private List<Food> foodList;

    public Restaurant(RestaurantRequestDto requestDto){
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}
