package com.ec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Merchandise;

public interface MerchandiseRepository extends JpaRepository<Merchandise,Integer>{
    List<Merchandise> findByCategory(String category);
}
