package com.fullstack.springbootecommerce.service;

import com.fullstack.springbootecommerce.dto.Purchase;
import com.fullstack.springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
