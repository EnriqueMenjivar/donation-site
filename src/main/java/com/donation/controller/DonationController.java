package com.donation.controller;

import com.donation.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/donations")
public class DonationController {

    private static final String INDEX_TEMPALTE = "donation/index";
    private static final String CREATE_TEMPALTE = "donation/create";

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView(INDEX_TEMPALTE);

        mav.addObject("donations", 100);
        return mav;
    }

    public ModelAndView create() {
        ModelAndView mav = new ModelAndView(CREATE_TEMPALTE);

        mav.addObject("countries", countryService.findAll());
        return mav;
    }
}
