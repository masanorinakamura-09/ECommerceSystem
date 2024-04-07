package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
