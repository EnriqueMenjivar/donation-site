package com.donation.service;

import com.donation.entity.CreditCard;
import com.donation.entity.User;
import com.donation.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard save(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public List<CreditCard> findByUser(User user) {
        return creditCardRepository.findByUser(user);
    }

    public CreditCard findById(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

}
