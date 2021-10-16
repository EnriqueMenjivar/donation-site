package com.donation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/donations")
public class DonationController {

    private static final String INDEX_TEMPALTE = "donation/index";

    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView(INDEX_TEMPALTE);

        mav.addObject("donations", 100);
        return mav;
    }
}
