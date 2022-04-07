package com.bigtyno.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class OrderFood {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ORDER_FOOD_ID")
    private Long id;

//    @Column(nullable = false)
//    @OneToOne
//    private Food food;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "ORDERS_ID")
    private Orders orders;


    public OrderFood(Food food, int quantity) {
        this.name = food.getName();
        this.quantity = quantity;
        this.price = food.getPrice()* quantity;
    }
}
