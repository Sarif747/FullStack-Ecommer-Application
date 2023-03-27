package com.fullstack.springbootecommerce.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fullstack.springbootecommerce.dao.CustomerRepository;
import com.fullstack.springbootecommerce.dto.Purchase;
import com.fullstack.springbootecommerce.dto.PurchaseResponse;
import com.fullstack.springbootecommerce.entity.Customer;
import com.fullstack.springbootecommerce.entity.Order;
import com.fullstack.springbootecommerce.entity.OrderItem;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        
        String theEmail = customer.getEmail();
        
        Customer customerFromDB = customerRepository.findByEmail(theEmail);
        
        if(customerFromDB != null) {
        	
        	customer = customerFromDB;
        }
        		
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

      
        return UUID.randomUUID().toString();
    }
}
