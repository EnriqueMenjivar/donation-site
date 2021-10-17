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
@RequestMapping("/api")
public class DataRestController {

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{email}/exists-email")
    public Boolean existsByEmail(@PathVariable("email") String email) {
        return userService.existsByEmail(email);
    }

    @GetMapping("/user/{id}/exists-id")
    public Boolean existsByIdDocument(@PathVariable("id") Long id) {
        return userService.existsByIdDocument(id);
    }

    @GetMapping("/country/{id}/institutions")
    public List<Institution> findByCountry(@PathVariable Long id) {
        Country country = countryService.findById(id);

        return institutionService.findByCountry(country);
    }

    @GetMapping("/user/{id}/donations")
    public UserDonationDto getDonations(@PathVariable("id") Long id) {
        User user = userService.findByIdDocument(id);

        return UserDonationDto.entityToDto(user);
    }
}
