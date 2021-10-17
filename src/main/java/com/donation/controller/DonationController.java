package com.donation.controller;

import com.donation.entity.CreditCard;
import com.donation.entity.Donation;
import com.donation.entity.Institution;
import com.donation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/donations")
public class DonationController {

    private static final String INDEX_TEMPALTE = "donation/index";
    private static final String CREATE_TEMPALTE = "donation/create";

    @Autowired
    private CountryService countryService;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private DonationService donationService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView(INDEX_TEMPALTE);

        mav.addObject("donations", donationService.findByUser(getLoggedUser()));
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView(CREATE_TEMPALTE);

        mav.addObject("newDonation", new Donation());
        mav.addObject("countries", countryService.findAll());
        mav.addObject("institutions", institutionService.findAll());
        mav.addObject("cards", creditCardService.findByUser(getLoggedUser()));
        return mav;
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("newDonation") Donation donation, BindingResult results, @RequestParam("cardId") Long cardId, RedirectAttributes redirAttrs) {

        if(donation.getInstitution().getId() == null) {
            redirAttrs.addFlashAttribute("message", "Please select a valid institution");
            return "redirect:/donations/create";
        }

        //If there are errors
        if (results.hasErrors()) {
            redirAttrs.addFlashAttribute("errors", results.getAllErrors());
            return "redirect:/donations/create";
        }

        //If user has already donated to selected country
        Institution institution = institutionService.findById(donation.getInstitution().getId());
        Donation existsDonation = donationService.existsDonation(getLoggedUser().getIdDocument(), institution.getCountry().getId(), new Date());
        if (existsDonation != null) {
            redirAttrs.addFlashAttribute("message", "You've already donate to " + institution.getCountry().getName() + " this month, please select an institution of different country or wait until next month.");
            return "redirect:/donations/create";
        }

        CreditCard card = creditCardService.findById(cardId);
        if(donation.getDonationAmount() > card.getBalance()){
            redirAttrs.addFlashAttribute("message", "The selected card doesn't have enough money to make the donation.");
            return "redirect:/donations/create";
        }

        donation.setDonationDate(new Date());
        donation.setUser(getLoggedUser());
        donationService.save(donation);

        card.setBalance(card.getBalance() - donation.getDonationAmount());
        creditCardService.save(card);

        redirAttrs.addFlashAttribute("message", "Donation was made successfully");
        return "redirect:/donations";
    }

    private com.donation.entity.User getLoggedUser(){
        User securityUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userService.findByEmail(securityUser.getUsername());
    }
}
