package com.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.entity.Address;
import com.ec.entity.Basketdetail;
import com.ec.entity.Customer;
import com.ec.service.AddressService;
import com.ec.service.BasketdetailService;
import com.ec.service.CustomerDetail;
import com.ec.service.CustomerService;
import com.ec.service.MerchandiseService;
@Controller
@RequestMapping("sampleEC")
public class ECommerceController  {
    private final MerchandiseService service;
    private final CustomerService customerservice;
    private final AddressService addressservice;
    private final BasketdetailService basketdetailservice;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ECommerceController(MerchandiseService service, CustomerService customerservice, AddressService addressservice, BasketdetailService basketdetailservice) {
        this.service = service;
        this.customerservice = customerservice;
        this.addressservice = addressservice;
        this.basketdetailservice = basketdetailservice;
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

    @GetMapping("/furniture")
    public String getAlcoholList(Model model) {
        model.addAttribute("merchandiselist",service.getCategoryList("家具"));
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

    @GetMapping("/customer_register")
    public String getCustomerRegister(Model model,Customer customer,Address address) {
        model.addAttribute("customer",customer);
        model.addAttribute("address",address);
        return "ECommerce/customer_register";
    }

    @PostMapping("/customer_register")
    public String customerRegister(@Validated Customer customer,BindingResult resultc,
           @Validated Address address,BindingResult resulta,Model model) {


        customer.setCash(10000);
        customer.getAuthentication().setCustomer(customer);

        String password=customer.getAuthentication().getPassword();
        customer.getAuthentication().setPassword(passwordEncoder.encode(password));


        address.setCustomer(customer);
        address.setName(customer.getName());
        address.setTelephoneNumber(customer.getTelephoneNumber());
        address.setPriority(true);

        if(resultc.hasErrors()||resulta.hasErrors()) {
            return getCustomerRegister(model,customer,address);
        }


        customerservice.saveCustomer(customer);
        addressservice.saveAddress(address);

        return "redirect:/sampleEC/home";
    }

    @ModelAttribute("loginuser")
    public Customer customer(@AuthenticationPrincipal CustomerDetail customerdetail) {
        if(customerdetail!=null) {
            return customerdetail.getCustomer();
            }else {
                return null;
                }
    }

    @ModelAttribute("basketitems")
    public Integer getBasketItems(@AuthenticationPrincipal CustomerDetail customerdetail){
        if(customerdetail!=null) {
            var basketlist=basketdetailservice.getBasketList(customerdetail.getCustomer().getId());
            var sum=0;
            for(Basketdetail item : basketlist) {
                    sum+=item.getQty();
            }
            return sum;
            }else {
                return null;
            }
    }
}


