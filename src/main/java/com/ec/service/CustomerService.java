package com.ec.service;

import org.springframework.stereotype.Service;

import com.ec.entity.Customer;
import com.ec.repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerrepository;

    public CustomerService(CustomerRepository customerrepository) {
        this.customerrepository = customerrepository;
    }

    public Customer getCustomer(Integer id) {
        return customerrepository.findById(id).get();
    }

    public void saveCustomer(Customer customer) {
        customerrepository.save(customer);
    }
}
