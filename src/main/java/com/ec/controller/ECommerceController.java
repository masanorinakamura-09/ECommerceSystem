package com.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.service.MerchandiseService;

@Controller
@RequestMapping("sampleEC")
public class ECommerceController {
    private final MerchandiseService service;

    public ECommerceController(MerchandiseService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String getList(Model model) {

        model.addAttribute("merchandiselist",service.getMerchandisereList());
        return "ECommerce/home";
    }
}
