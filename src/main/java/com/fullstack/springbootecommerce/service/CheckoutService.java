package com.fullstack.springbootecommerce.service;

import com.fullstack.springbootecommerce.dto.PaymentInfo;
import com.fullstack.springbootecommerce.dto.Purchase;
import com.fullstack.springbootecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
	
	PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}
