package com.donation.controller;

import com.donation.entity.CreditCard;
import com.donation.entity.Donation;
import com.donation.entity.Institution;
import com.donation.service.CreditCardService;
import com.donation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/credit-cards")
public class CreditCardController {

        private static final String INDEX_TEMPALTE = "credit_cards/index";

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView(INDEX_TEMPALTE);

        mav.addObject("cards", creditCardService.findByUser(getLoggedUser()));
        mav.addObject("newCard", new CreditCard());
        return mav;
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("newCard") CreditCard card, BindingResult results, RedirectAttributes redirAttrs) {

        //If there are errors
        if (results.hasErrors()) {
            redirAttrs.addFlashAttribute("errors", results.getAllErrors());
            return "redirect:/credit-cards";
        }

        card.setUser(getLoggedUser());
        creditCardService.save(card);

        redirAttrs.addFlashAttribute("message", "Credit card was added successfully");
        return "redirect:/credit-cards";
    }

    private com.donation.entity.User getLoggedUser(){
        User securityUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userService.findByEmail(securityUser.getUsername());
    }
}
