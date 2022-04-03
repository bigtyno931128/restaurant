package com.bigtyno.restaurant.entity;

import com.bigtyno.restaurant.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_NAME", nullable = false)
    private Restaurant restaurant;


    public Food(Restaurant restaurant,FoodDto foodDto ){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurant = restaurant;
    }

    public Food(String restaurantName, Long quantity, Long price) {
    }
}
