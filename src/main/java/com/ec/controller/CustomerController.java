package com.ec.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.entity.Address;
import com.ec.entity.Customer;
import com.ec.entity.Orderlist;
import com.ec.service.AddressService;
import com.ec.service.CustomerDetail;
import com.ec.service.OrderlistService;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final OrderlistService orderlistservice;
    private final AddressService addressservice;

    public CustomerController(OrderlistService ordelistservice, AddressService addressservice) {
        this.orderlistservice = ordelistservice;
        this.addressservice = addressservice;
    }

    @GetMapping("/detail/")
    public String getCustomerDetail() {
        return "ECommerce/customer";
    }

    @GetMapping("/orderlist/")
    public String orderlist() {
       return "ECommerce/orderlist";
    }

    @PostMapping("/orderdetail/{id}/")
    public String orderdetail(@PathVariable("id") Integer id,Model model) {
        Orderlist orderlist=orderlistservice.getOrderDetailList(id).get();
        model.addAttribute("orderlist",orderlist);
        return "ECommerce/orderdetail";
    }

    @GetMapping("/addresslist/")
    public String GetAddressList(@AuthenticationPrincipal CustomerDetail customerdetail,Model model) {
        List<Address> addressList=addressservice.getAddressList(customerdetail.getCustomer().getId());
        model.addAttribute("addresslist",addressList);
        return "ECommerce/addresslist";
    }

    @ModelAttribute("loginuser")
    public Customer customer(@AuthenticationPrincipal CustomerDetail customerdetail) {
        return customerdetail.getCustomer();
    }

    @ModelAttribute("orderlist")
    public List<Orderlist> orderlist(@AuthenticationPrincipal CustomerDetail customerdetail) {
        return orderlistservice.getOrderList(customerdetail.getCustomer().getId());
    }

    @ModelAttribute("useraddress")
    public Address address(@AuthenticationPrincipal CustomerDetail customerdetail) {
    return addressservice.getPriorityAddress(customerdetail.getCustomer().getId());
            }
}

