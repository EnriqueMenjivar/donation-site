package com.donation.controller;

import com.donation.dto.UserDonationDto;
import com.donation.entity.Country;
import com.donation.entity.Institution;
import com.donation.entity.User;
import com.donation.service.CountryService;
import com.donation.service.InstitutionService;
import com.donation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/{id}/institutions")
    public List<Institution> findByCountry(@PathVariable Long id) {
        Country country = countryService.findById(id);

        return institutionService.findByCountry(country);
    }

}
