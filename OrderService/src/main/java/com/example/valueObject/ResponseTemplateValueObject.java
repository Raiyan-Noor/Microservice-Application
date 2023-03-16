package com.example.valueObject;

import com.example.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObject {
    private Product product;
    private Order order;
}
