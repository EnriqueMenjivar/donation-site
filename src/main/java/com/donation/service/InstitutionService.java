package com.donation.service;

import com.donation.entity.Country;
import com.donation.entity.Institution;
import com.donation.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Institution> findByCountry(Country country) {
        return institutionRepository.findByCountry(country);
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
    public Institution findById(Long id) {
        return institutionRepository.findById(id).orElse(null);
    }
}
