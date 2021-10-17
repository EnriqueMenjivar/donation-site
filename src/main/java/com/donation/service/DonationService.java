package com.donation.service;

import com.donation.entity.Donation;
import com.donation.entity.User;
import com.donation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }

    public List<Donation> findByUser(User user) {
        return donationRepository.findByUser(user);
    }

    public Donation existsDonation(Long userId, Long countryId, Date donationDate) {
        return donationRepository.existsDonation(userId, countryId, donationDate);
    }
}
