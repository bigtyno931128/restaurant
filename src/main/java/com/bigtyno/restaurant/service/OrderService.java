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
import org.hibernate.criterion.Order;
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

            //음식을 주문할 수량 (quantity)
            //    1. 허용값: 1 ~ 100
            //    2. 허용값이 아니면 에러 발생시킴

            if (foodOrderRequestDto.getQuantity() < 1 || foodOrderRequestDto.getQuantity() >100){
                throw new IllegalArgumentException("허용수량 에 해당하지 않습니다.");
            }
            int quantity = foodOrderRequestDto.getQuantity();


            Food food = foodRepository.findById(foodOrderRequestDto.getId()).orElseThrow(
                    () -> new IllegalArgumentException(""));

            // OrderFood 를 생성자를 통해 초기화.
            OrderFood orderFood = new OrderFood(food, quantity);

            // FoodOrderDto 를 생성자를 통해 초기화 .
            FoodOrderDto foodOrderDto = new FoodOrderDto(
                    food.getName(),
                    quantity,
                    food.getPrice() * quantity
            );

            orderFoodList.add(orderFood);

            totalPrice += orderFood.getPrice();
            orderFoodRepository.save(orderFood);

            foodOrderDtoList.add(foodOrderDto);
        }

        //"주문 음식 가격들의 총 합" 이 주문 음식점의 "최소주문 가격" 을 넘지 않을 시 에러 발생시킴
        if(restaurant.getMinOrderPrice() > totalPrice-deliveryFee)
            throw new IllegalArgumentException("");

        OrderDto orderDto = new OrderDto(restaurantName,foodOrderDtoList,deliveryFee,totalPrice);
        Orders orders = new Orders(restaurantName,orderFoodList,deliveryFee,totalPrice);
        ordersRepository.save(orders);
        return orderDto;
    }

    // 그 동안 성공한 모든 주문 조회 하기
    public List<OrderDto> getAllOrder() {

        List<Orders> ordersList = ordersRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();

        //주문 리스트에서 주문 하나씩 확인하기.
        for(Orders orders: ordersList){
            String restaurantName = orders.getRestaurantName();
            //controller 에 보내줄 <FoodOrderDto> 에 값 채워주기 위해서
            List<FoodOrderDto> foodOrderDtoList  = new ArrayList<>();
            //주문에서 foods 하나씩 꺼내기.
            for(OrderFood orderFood :orders.getOrderFoodList()){
                String name = orderFood.getName();
                int quantity = orderFood.getQuantity();
                int price = orderFood.getPrice();

                FoodOrderDto foodOrderDto = new FoodOrderDto(
                  name,quantity,price
                );
                foodOrderDtoList.add(foodOrderDto);
            }

            int deliveryFee = orders.getDeliveryFee();
            int totalPrice = orders.getTotalPrice();

            OrderDto orderDto = new OrderDto(
                    restaurantName,foodOrderDtoList,deliveryFee,totalPrice
            );

            orderDtoList.add(orderDto);
        }
        return  orderDtoList;
    }
}