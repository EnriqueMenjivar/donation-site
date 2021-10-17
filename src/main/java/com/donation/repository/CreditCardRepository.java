package com.donation.repository;

import com.donation.entity.CreditCard;
import com.donation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    public abstract List<CreditCard> findByUser(User user);
}
