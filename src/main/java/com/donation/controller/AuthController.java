package com.donation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    public static final String HOME_TEMPLATE = "home";

    @GetMapping
    public ModelAndView home() {

        return new ModelAndView(HOME_TEMPLATE);
    }
}
