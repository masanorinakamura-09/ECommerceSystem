package com.ec.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ec.entity.Address;
import com.ec.entity.Basketdetail;
import com.ec.entity.Customer;
import com.ec.entity.Merchandise;
import com.ec.entity.Orderdetail;
import com.ec.entity.Orderdetail.Status;
import com.ec.entity.Orderlist;
import com.ec.service.AddressService;
import com.ec.service.BasketdetailService;
import com.ec.service.CustomerDetail;
import com.ec.service.CustomerService;
import com.ec.service.MerchandiseService;
import com.ec.service.OrderdetailService;
import com.ec.service.OrderlistService;

@Controller
@RequestMapping("basket")
public class BasketController {
    private final BasketdetailService basketdetailservice;
    private final MerchandiseService merchandiseservice;
    private final OrderdetailService orderdetailservice;
    private final OrderlistService orderlistservice;
    private final AddressService addressservice;

    public BasketController(BasketdetailService basketdetailservice,
            MerchandiseService merchandiseservice,
            CustomerService customerservice,
            OrderlistService orderlistservice,
            OrderdetailService orderdetailservice, AddressService addressservice) {
        this.basketdetailservice = basketdetailservice;
        this.merchandiseservice = merchandiseservice;
        this.orderdetailservice = orderdetailservice;
        this.orderlistservice = orderlistservice;
        this.addressservice = addressservice;
    }


    @GetMapping("/detail/")
    public String getBasket() {
        return "ECommerce/basket";
    }

    @PostMapping("/add/{id}/")
    public String UpdateMerchandise(@AuthenticationPrincipal CustomerDetail customerdetail,
            @PathVariable("id") Integer id,
            @RequestParam("qty") Integer qty,
            Model model) {
            Customer customer=customerdetail.getCustomer();
            Merchandise merchandise=merchandiseservice.getMerchandise(id);

            if(!basketdetailservice.Exists(merchandise, customer)) {
                return AddMerchandise(customer,merchandise,qty);
            }

            Basketdetail basketdetail=basketdetailservice.findBasketDetail(merchandise, customer);
            basketdetail.setQty(basketdetail.getQty()+qty);

            basketdetailservice.saveBasketdetail(basketdetail);
            model.addAttribute("success",true);
            return "redirect:/sampleEC/home";
    }

    @PostMapping("/delete/{id}/")
    public String DeleteMerchandise(@PathVariable("id") Integer id,@AuthenticationPrincipal CustomerDetail customerdetail) {
        basketdetailservice.DeleteMerchandise(id, customerdetail.getCustomer().getId());
        return "redirect:/basket/detail/";
    }

    @PostMapping("/determine/")
    public String Determine(@AuthenticationPrincipal CustomerDetail customerdetail
            ,Address address,@RequestParam("id")Integer id) {
        Customer customer=customerdetail.getCustomer();
        List<Basketdetail> basketlist=basketdetailservice.getBasketList(customer.getId());
        var sum=0;
        List<Orderdetail> orderdetails=new ArrayList<Orderdetail>();

        for(Basketdetail item:basketlist) {
            Orderdetail orderdetail=new Orderdetail();
            orderdetail.setMerchandise(item.getMerchandise());
            orderdetail.setQty(item.getQty());
            orderdetail.setStatus(Status.受注);

            orderdetails.add(orderdetail);
            orderdetailservice.saveOrder(orderdetail);
            sum+=item.getMerchandise().getPrice()*item.getQty();
        }

        LocalDate date=LocalDate.now();
        Integer dateid=date.getDayOfMonth();
        Random rand=new Random();
        Integer randid=rand.nextInt(8999)+1000;

        Orderlist orderlist=new Orderlist();
        orderlist.setId(Integer.parseInt(""+customer.getId()+dateid+randid));
        orderlist.setCustomer(customer);
        orderlist.setOrderdetails(orderdetails);
        orderlist.setDate(date);

        orderlist.setAddress(addressservice.getAddress(id).get());

        orderlistservice.saveOrderList(orderlist);
        basketdetailservice.DeleteBasket(customer.getId());

        return "redirect:/sampleEC/home";
    }

    public String AddMerchandise(Customer customer,Merchandise merchandise,
            Integer qty) {
            Basketdetail basketdetail=new Basketdetail();
            basketdetail.setCustomer(customer);
            basketdetail.setMerchandise(merchandise);
            basketdetail.setQty(qty);

            basketdetailservice.saveBasketdetail(basketdetail);
            return "redirect:/sampleEC/home";
    }

    @GetMapping("/payment")
    public String GetPayment() {
        return "ECommerce/payment";
    }

    @PostMapping("/payment")
    public String Payment() {
        return "ECommerce/payment";
    }


    @GetMapping("/address")
    public String GetAddress(Model model,Address address,@AuthenticationPrincipal CustomerDetail customerdetail) {
        List<Address> addressList=addressservice.getAddressList(customerdetail.getCustomer().getId());

        model.addAttribute("address", address);
        model.addAttribute("addresslist", addressList);
        return "ECommerce/addressregister";
    }

    @PostMapping("/address")
    public String ChangeAddress(@Validated Address address,BindingResult result,
            @AuthenticationPrincipal CustomerDetail customerdetail,Model model) {
        address.setCustomer(customerdetail.getCustomer());
        address.setPriority(false);

        if(result.hasErrors()) {
            return GetAddress(model,address,customerdetail);
        }

        if(!(addressservice.existsAddress(customerdetail.getCustomer().getId()
                , address.getPostCode()))){
        addressservice.saveAddress(address);
        }

        return "ECommerce/payment";
    }

    @PostMapping("/selectaddress")
    public String SelectAddress(Model model,@RequestParam("selectaddress")Integer id) {
        Address address= addressservice.getAddress(id).get();
        model.addAttribute("useraddress",address);
        return "ECommerce/payment";
    }

    @ModelAttribute("loginuser")
    public Customer customer(@AuthenticationPrincipal CustomerDetail customerdetail) {
        return customerdetail.getCustomer();
    }

    @ModelAttribute("merchandiselist")
    public List<Basketdetail> merchandiselist(@AuthenticationPrincipal CustomerDetail customerdetail){
        return basketdetailservice.getBasketList(customerdetail.getCustomer().getId());
    }

    @ModelAttribute("payment")
    public Integer payment(@AuthenticationPrincipal CustomerDetail customerdetail) {
        List<Basketdetail> basketlist=basketdetailservice.getBasketList(customerdetail.getCustomer().getId());
        var sum=0;
        for(Basketdetail item:basketlist){
            sum+=item.getMerchandise().getPrice()*item.getQty();
        }
        return sum;
    }

    @ModelAttribute("useraddress")
    public Address address(@AuthenticationPrincipal CustomerDetail customerdetail) {
    return addressservice.getPriorityAddress(customerdetail.getCustomer().getId());
    }
}
