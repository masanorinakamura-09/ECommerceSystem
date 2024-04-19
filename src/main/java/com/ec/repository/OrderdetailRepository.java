package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Orderdetail;

public interface OrderdetailRepository extends JpaRepository<Orderdetail, Integer> {

}
