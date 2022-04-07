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
    @Column(name = "FOOD_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", insertable = false, updatable = false)
    private Restaurant restaurant;

    private String restaurantName;

    public Food(Restaurant restaurant,FoodDto foodDto ){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurant = restaurant;
        this.restaurantName = restaurant.getName();
    }

    public Food(String restaurantName, Long quantity, Long price) {
    }
}
