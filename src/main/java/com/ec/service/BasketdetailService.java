package com.ec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ec.entity.Basketdetail;
import com.ec.entity.Customer;
import com.ec.entity.Merchandise;
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

    public boolean Exists(Merchandise merchandise,Customer customer) {
        return basketdetailRepository.existsByMerchandiseIdAndCustomerId(merchandise.getId(),customer.getId());
    }

    public Basketdetail findBasketDetail(Merchandise merchandise,Customer customer) {
        return basketdetailRepository.findByMerchandiseIdAndCustomerId(merchandise.getId(),customer.getId());
    }

    public List<Basketdetail> getBasketList(Integer id){
        return basketdetailRepository.findByCustomerId(id);
    }
}
