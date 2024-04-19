package com.ec.service;

import org.springframework.stereotype.Service;

import com.ec.entity.Orderdetail;
import com.ec.repository.OrderdetailRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderdetailService {
    private final OrderdetailRepository orderdetailrepository;

    public OrderdetailService(OrderdetailRepository orderdetailrepository) {
        this.orderdetailrepository = orderdetailrepository;
    }

    @Transactional
    public void saveOrder(Orderdetail orderdetail) {
        orderdetailrepository.save(orderdetail);
    }
}
