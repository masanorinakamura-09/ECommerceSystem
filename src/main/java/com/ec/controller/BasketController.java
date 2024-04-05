package com.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.entity.Merchandise;
import com.ec.service.BasketdetailService;

@Controller
@RequestMapping("basket")
public class BasketController {
    private final BasketdetailService basketdetailservice;

    public BasketController(BasketdetailService basketdetailservice) {
        this.basketdetailservice = basketdetailservice;
    }

    @PostMapping("/add")
    public String AddMerchandise(Merchandise merchandise) {
            var m=merchandise.getName();
            return "redirect:/sampleEC/home";
    }
}
