package com.ec.service;

import org.springframework.stereotype.Service;

import com.ec.entity.Basketdetail;
import com.ec.repository.BasketdetailRepository;

import jakarta.transaction.Transactional;

@Service
public class BasketdetailService {
    private final BasketdetailRepository basketdetailRepository;

    public BasketdetailService(BasketdetailRepository basketdetailRepository) {

        this.basketdetailRepository = basketdetailRepository;
    }


    @Transactional
    public void saveBasketdetail(Basketdetail basketdetail) {
        basketdetailRepository.save(basketdetail);
    }
}
