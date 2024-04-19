package com.ec.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ec.entity.Basketdetail;
import com.ec.entity.Customer;
import com.ec.entity.Merchandise;
import com.ec.entity.Orderdetail;
import com.ec.service.BasketdetailService;
import com.ec.service.CustomerDetail;
import com.ec.service.CustomerService;
import com.ec.service.CustomerDetailService;
import com.ec.service.MerchandiseService;
import com.ec.service.OrderdetailService;

@Controller
@RequestMapping("basket")
public class BasketController {
    private final BasketdetailService basketdetailservice;
    private final MerchandiseService merchandiseservice;
    private final OrderdetailService orderdetailservice;
    private final CustomerService customerservice;

    public BasketController(BasketdetailService basketdetailservice, MerchandiseService merchandiseservice, CustomerService customerservice, OrderdetailService orderdetailservice) {
        super();
        this.basketdetailservice = basketdetailservice;
        this.merchandiseservice = merchandiseservice;
        this.orderdetailservice = orderdetailservice;
        this.customerservice = customerservice;
    }

    @GetMapping("/detail/")
    public String getBasket(@AuthenticationPrincipal CustomerDetail customerdetail,Model model,Model paymentModel,Model customer) {

        List<Basketdetail> basketlist=basketdetailservice.getBasketList(customerdetail.getCustomer().getId());
        model.addAttribute("merchandiselist",basketlist);
        var sum=0;
        for(Basketdetail item:basketlist){
            sum+=item.getMerchandise().getPrice()*item.getQty();
        }
        paymentModel.addAttribute("payment",sum);
        customer.addAttribute("customer",customerdetail.getCustomer());
        return "ECommerce/basket";
    }

    @PostMapping("/add/{id}/")
    public String UpdateMerchandise(@PathVariable("id") Integer id,
            @RequestParam("qty") Integer qty,
            @AuthenticationPrincipal CustomerDetail customerdetail) {
            Customer customer=customerdetail.getCustomer();
            Merchandise merchandise=merchandiseservice.getMerchandise(id);

            if(!basketdetailservice.Exists(merchandise, customer)) {
                return AddMerchandise(customer,merchandise,qty);
            }

            Basketdetail basketdetail=basketdetailservice.findBasketDetail(merchandise, customer);
            basketdetail.setQty(basketdetail.getQty()+qty);

            basketdetailservice.saveBasketdetail(basketdetail);
            return "redirect:/sampleEC/home";
    }

    @PostMapping("/delete/{id}/")
    public String DeleteMerchandise(@PathVariable("id") Integer id,@AuthenticationPrincipal CustomerDetail customerdetail) {
        basketdetailservice.DeleteMerchandise(id, customerdetail.getCustomer().getId());
        return "redirect:/basket/detail/";
    }

    @PostMapping("/determine/{id}/")
    public String Determine(@AuthenticationPrincipal CustomerDetail customerdetail) {
        List<Basketdetail> basketlist=basketdetailservice.getBasketList(customerdetail.getCustomer().getId());
        Customer customer=customerdetail.getCustomer();
        var sum=0;

        for(Basketdetail item:basketlist) {
            Orderdetail orderdetail=new Orderdetail();
            orderdetail.setCustomer(customer);
            orderdetail.setMerchandise(item.getMerchandise());
            orderdetail.setQty(item.getQty());

            sum+=item.getMerchandise().getPrice()*item.getQty();
            orderdetailservice.saveOrder(orderdetail);
        }

        basketdetailservice.DeleteBasket(customer.getId());
        customer.setCash(customer.getCash()-sum);
        customerservice.saveCustomer(customer);

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

    @PostMapping("/payment")
    public String Payment(@AuthenticationPrincipal CustomerDetail customerdetail,Model model,Model paymentModel,Model customer) {

        List<Basketdetail> basketlist=basketdetailservice.getBasketList(customerdetail.getCustomer().getId());
        model.addAttribute("merchandiselist",basketlist);
        var sum=0;
        for(Basketdetail item:basketlist){
            sum+=item.getMerchandise().getPrice()*item.getQty();
        }
        paymentModel.addAttribute("payment",sum);
        customer.addAttribute("customer",customerdetail.getCustomer());

        return "ECommerce/payment";
    }
}
