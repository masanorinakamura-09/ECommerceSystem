package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Merchandise;

public interface MerchandiseRepository extends JpaRepository<Merchandise,Integer>{

}
