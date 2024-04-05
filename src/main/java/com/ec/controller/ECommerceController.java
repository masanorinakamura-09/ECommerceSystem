package com.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.entity.Merchandise;
import com.ec.service.MerchandiseService;

import jakarta.persistence.EnumType;

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

    @GetMapping("/food")
    public String getFoodList(Model model) {
        model.addAttribute("merchandiselist",service.getCategoryList("食品"));
        return "ECommerce/home";
    }

    @GetMapping("/medicine")
    public String getMedicineList(Model model) {
        model.addAttribute("merchandiselist",service.getCategoryList("薬剤"));
        return "ECommerce/home";
    }

    @GetMapping("/alcohol")
    public String getAlcoholList(Model model) {
        model.addAttribute("merchandiselist",service.getCategoryList("お酒"));
        return "ECommerce/home";
    }

    @GetMapping("/stationery")
    public String getStationeryList(Model model) {
        model.addAttribute("merchandiselist",service.getCategoryList("文房具"));
        return "ECommerce/home";
    }

    @GetMapping("/electronics")
    public String getElectronicsList(Model model) {
        model.addAttribute("merchandiselist",service.getCategoryList("家電"));
        return "ECommerce/home";
    }



}


