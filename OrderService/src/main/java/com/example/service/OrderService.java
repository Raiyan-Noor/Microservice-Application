package com.example.service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import com.example.valueObject.Product;
import com.example.valueObject.ResponseTemplateValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseTemplateValueObject getOrderWithProduct(String orderId) {
        ResponseTemplateValueObject ResponseValueObject = new ResponseTemplateValueObject();

        Order order = orderRepository.findOrderById(orderId);
        Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + order.getProductId(), Product.class);
        //Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customers/" + order.getCustomerId(), Customer.class);
        //Employee employee = restTemplate.getForObject("http://Employee-SERVICE/employees/" + order.getEmployeeId(), Employee.class);

        // The bellow line is also correct. static port is replaced by service
        // Customer customer = restTemplate.getForObject("http://localhost:9001/customers/" + order.getCustomerId(), Customer.class);

        //ResponseValueObject.setCustomer(customer);
        ResponseValueObject.setProduct(product);
        //ResponseValueObject.setProduct(employee);
        ResponseValueObject.setOrder(order);

        return ResponseValueObject;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderById(String userId) {
        return orderRepository.findOrderById(userId);
    }
}