package com.bigtyno.restaurant.service;

import com.bigtyno.restaurant.dto.FoodOrderDto;
import com.bigtyno.restaurant.dto.FoodOrderRequestDto;
import com.bigtyno.restaurant.dto.OrderDto;
import com.bigtyno.restaurant.dto.OrderRequestDto;
import com.bigtyno.restaurant.entity.Food;
import com.bigtyno.restaurant.entity.Orders;
import com.bigtyno.restaurant.entity.OrderFood;
import com.bigtyno.restaurant.entity.Restaurant;
import com.bigtyno.restaurant.repository.FoodRepository;
import com.bigtyno.restaurant.repository.OrderFoodRepository;
import com.bigtyno.restaurant.repository.OrdersRepository;
import com.bigtyno.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrdersRepository ordersRepository;
    private final OrderFoodRepository orderFoodRepository;

    @Autowired
    public OrderService(FoodRepository foodRepository, RestaurantRepository restaurantRepository, OrdersRepository ordersRepository, OrderFoodRepository orderFoodRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.ordersRepository = ordersRepository;
        this.orderFoodRepository = orderFoodRepository;
    }

    @Transactional
    public OrderDto createOrder(OrderRequestDto orderRequestDto) {

        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException(""));
        //주문 리스트
        List<OrderFood> orderFoodList = new ArrayList<>();
        // controller 에 보내줄 OrderDto 에 필요한 list.
        List<FoodOrderDto> foodOrderDtoList  = new ArrayList<>();

        String restaurantName = restaurant.getName();
        int deliveryFee = restaurant.getDeliveryFee();

        int totalPrice = deliveryFee;

        for (FoodOrderRequestDto foodOrderRequestDto : orderRequestDto.getFoods()) {

            int quantity = foodOrderRequestDto.getQuantity();
            System.out.println(quantity);
            Food food = foodRepository.findById(foodOrderRequestDto.getId()).orElseThrow(
                    () -> new IllegalArgumentException(""));

            OrderFood orderFood = new OrderFood(food, quantity);

            FoodOrderDto foodOrderDto = new FoodOrderDto(
                    food.getName(),
                    quantity,
                    food.getPrice() * quantity
            );

            orderFoodList.add(orderFood);
            totalPrice += orderFood.getPrice() ;
            orderFoodRepository.save(orderFood);
            foodOrderDtoList.add(foodOrderDto);

        }

        OrderDto orderDto = new OrderDto(restaurantName,foodOrderDtoList,deliveryFee,totalPrice);
        Orders orders = new Orders(restaurantName,orderFoodList,deliveryFee,totalPrice);
        ordersRepository.save(orders);
        return orderDto;
    }
}