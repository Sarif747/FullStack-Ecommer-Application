package com.fullstack.springbootecommerce.dto;


import lombok.Data;

import java.util.Set;

import com.fullstack.springbootecommerce.entity.Address;
import com.fullstack.springbootecommerce.entity.Customer;
import com.fullstack.springbootecommerce.entity.Order;
import com.fullstack.springbootecommerce.entity.OrderItem;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}