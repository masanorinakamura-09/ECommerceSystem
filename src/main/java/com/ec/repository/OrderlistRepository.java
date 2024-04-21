package com.ec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Orderlist;

public interface OrderlistRepository extends JpaRepository<Orderlist, Integer> {
     Orderlist findByCustomerId(Integer customerId);
}
