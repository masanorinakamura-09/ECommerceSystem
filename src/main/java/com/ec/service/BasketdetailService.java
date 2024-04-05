package com.ec.service;

import org.springframework.stereotype.Service;

import com.ec.repository.BasketdetailRepository;

@Service
public class BasketdetailService {
    private final BasketdetailRepository basketdetailRepository;

    public BasketdetailService(BasketdetailRepository basketdetailRepository) {
        super();
        this.basketdetailRepository = basketdetailRepository;
    }

}
