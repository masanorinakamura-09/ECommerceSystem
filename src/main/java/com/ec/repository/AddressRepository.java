package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByCustomerIdAndPriority(Integer Id,Boolean priority);

    boolean existsByCustomerIdAndPostCode(Integer Id,String postcode);
}
