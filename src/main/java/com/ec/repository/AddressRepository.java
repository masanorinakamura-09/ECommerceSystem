package com.ec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByCustomerIdAndPriority(Integer id,Boolean priority);

    boolean existsByCustomerIdAndPostCode(Integer Id,String postcode);

    List<Address> findByCustomerId(Integer id);
}
