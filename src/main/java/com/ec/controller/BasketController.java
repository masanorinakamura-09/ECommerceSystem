package com.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ec.entity.Basketdetail;
import com.ec.entity.Merchandise;
import com.ec.service.BasketdetailService;
import com.ec.service.CustomerService;
import com.ec.service.MerchandiseService;

@Controller
@RequestMapping("basket")
public class BasketController {
    private final BasketdetailService basketdetailservice;
    private final MerchandiseService merchandiseservice;
    private final CustomerService customerservice;

    public BasketController(BasketdetailService basketdetailservice, MerchandiseService merchandiseservice, CustomerService customerservice) {
        super();
        this.basketdetailservice = basketdetailservice;
        this.merchandiseservice = merchandiseservice;
        this.customerservice = customerservice;
    }

    @PostMapping("/add/{id}/")
    public String AddMerchandise(@PathVariable("id") Integer id,
            @RequestParam("qty") Integer qty) {
            Basketdetail basketdetail=new Basketdetail();
            basketdetail.setCustomer(customerservice.getCustomer(1));
            basketdetail.setMerchandise(merchandiseservice.getMerchandise(id));
            basketdetail.setQty(qty);

            basketdetailservice.saveBasketdetail(basketdetail);
            return "redirect:/sampleEC/home";
    }
}
