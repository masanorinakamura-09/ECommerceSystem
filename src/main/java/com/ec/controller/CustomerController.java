package com.ec.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.entity.Customer;
import com.ec.entity.Orderlist;
import com.ec.service.CustomerDetail;
import com.ec.service.OrderlistService;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final OrderlistService orderlistservice;

    public CustomerController(OrderlistService ordelistservice) {
        this.orderlistservice = ordelistservice;
    }

    @GetMapping("/detail/")
    public String getCustomerDetail() {
        return "ECommerce/customer";
    }

    @GetMapping("/orderlist/")
    public String orderlist() {
       return "ECommerce/orderlist";
    }

    @ModelAttribute
    public Customer customer(@AuthenticationPrincipal CustomerDetail customerdetail) {
        return customerdetail.getCustomer();
    }

    @ModelAttribute
    public Orderlist orderlist(@AuthenticationPrincipal CustomerDetail customerdetail) {
        return orderlistservice.getOrderList(customerdetail.getCustomer().getId());
    }
}

