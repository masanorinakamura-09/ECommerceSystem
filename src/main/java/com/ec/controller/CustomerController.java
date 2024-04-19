package com.ec.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.service.CustomerDetail;
import com.ec.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerservice;

    public CustomerController(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    @GetMapping("/detail/")
    public String getCustomerDetail(@AuthenticationPrincipal CustomerDetail customerdetail,Model model) {
        model.addAttribute("customer",customerdetail.getCustomer());
        return "ECommerce/customer";
    }


}
