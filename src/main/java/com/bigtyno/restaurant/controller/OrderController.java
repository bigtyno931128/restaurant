package com.bigtyno.restaurant.controller;

import com.bigtyno.restaurant.dto.OrderDto;
import com.bigtyno.restaurant.dto.OrderRequestDto;
import com.bigtyno.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public OrderDto creatOrder(@RequestBody OrderRequestDto orderRequestDto){

       return orderService.createOrder(orderRequestDto);
    }

//    @GetMapping("/orders")
//    public void getOrder(){
//
//    }

}
