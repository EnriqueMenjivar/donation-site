package com.donation.service;

import com.donation.entity.Country;
import com.donation.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {

        return countryRepository.findAll();
    }
}
