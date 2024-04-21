package com.ec.service;

import org.springframework.stereotype.Service;

import com.ec.entity.Orderlist;
import com.ec.repository.OrderlistRepository;

@Service
public class OrderlistService {
        private final OrderlistRepository orderlistrepository;

        public OrderlistService(OrderlistRepository orderlistrepository) {
            super();
            this.orderlistrepository = orderlistrepository;
        }

        public void saveOrderList(Orderlist orderlist) {
            orderlistrepository.save(orderlist);
        }

        public Orderlist getOrderList(Integer customerid) {
            return orderlistrepository.findByCustomerId(customerid);
        }
}
