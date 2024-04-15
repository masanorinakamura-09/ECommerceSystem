package com.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    public String getLogout(){
        return "redirect:/SampleEC/home";
    }
}
