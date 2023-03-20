package com.fullstack.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.springbootecommerce.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
