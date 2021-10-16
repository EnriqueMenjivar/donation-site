package com.donation.service;

import com.donation.entity.Donation;
import com.donation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Donation save(Donation donation) {

        return donationRepository.save(donation);
    }
}
