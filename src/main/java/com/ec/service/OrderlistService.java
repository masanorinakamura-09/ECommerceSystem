package com.ec.service;

import java.util.List;
import java.util.Optional;

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

        public List<Orderlist> getOrderList(Integer customerid) {
            return orderlistrepository.findByCustomerIdOrderByDateDescIdAsc(customerid);
        }

        public Optional<Orderlist> getOrderDetailList(Integer id) {
            return orderlistrepository.findById(id);
        }
}
