package com.example.controller;

import com.example.entity.Order;
import com.example.service.OrderService;
import com.example.valueObject.ResponseTemplateValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order){
        System.out.println("Hello");
        return orderService.saveOrder(order);
    }

//    @GetMapping("/{id}")
//    public Order findOrderById(@PathVariable("id") String orderId){
//        System.out.println("hello");
//        return orderService.findOrderById(orderId);
//    }
    @GetMapping("/{id}")
    public ResponseTemplateValueObject getOrderWithProduct(@PathVariable("id") String orderId){
        return orderService.getOrderWithProduct(orderId);
    }
}