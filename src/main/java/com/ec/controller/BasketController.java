package com.ec.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ec.entity.Basketdetail;
import com.ec.entity.Customer;
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

    @GetMapping("/{id}/")
    public String getBasket(@PathVariable("id") Integer id,Model model,Model payment) {

        List<Basketdetail> basketlist=basketdetailservice.getBasketList(id);
        model.addAttribute("merchandiselist",basketlist);
        var sum=0;
        for(Basketdetail item:basketlist){
            sum+=item.getMerchandise().getPrice()*item.getQty();
        }
        payment.addAttribute("payment",sum);
        return "ECommerce/basket";
    }

    @PostMapping("/add/{id}/")
    public String UpdateMerchandise(@PathVariable("id") Integer id,
            @RequestParam("qty") Integer qty) {
            Customer customer=customerservice.getCustomer(1);
            Merchandise merchandise=merchandiseservice.getMerchandise(id);

            if(!basketdetailservice.Exists(merchandise, customer)) {
                return AddMerchandise(customer,merchandise,qty);
            }

            Basketdetail basketdetail=basketdetailservice.findBasketDetail(merchandise, customer);
            basketdetail.setQty(basketdetail.getQty()+qty);

            basketdetailservice.saveBasketdetail(basketdetail);
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
}
