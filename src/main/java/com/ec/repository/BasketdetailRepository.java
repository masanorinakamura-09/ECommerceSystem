package com.ec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Basketdetail;
import com.ec.entity.Customer;
import com.ec.entity.Merchandise;

public interface BasketdetailRepository extends JpaRepository<Basketdetail, Integer> {
    boolean existsByMerchandiseIdAndCustomerId(Integer merchandaise_id,Integer customer_id);

    Basketdetail findByMerchandiseIdAndCustomerId(Integer merchandaise_id,Integer customer_id);

    Basketdetail deleteByMerchandiseIdAndCustomerId(Integer merchandaise_id,Integer customer_id);

    List<Basketdetail> findByCustomerId(Integer customer_id);
}
