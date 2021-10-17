package com.donation.repository;

import com.donation.entity.Donation;
import com.donation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    public abstract List<Donation> findByUser(User user);

    @Query(value = "SELECT d.* FROM donations d\n" +
            "JOIN institutions i ON d.institution_id = i.id \n" +
            "JOIN countries c ON i.country_id = c.id\n" +
            "WHERE \n" +
            "d.user_id = ?1 AND\n" +
            "c.id = ?2 AND\n" +
            "d.donation_date BETWEEN (SELECT CAST(DATE_FORMAT(?3 ,'%Y-%m-01') AS DATE)) AND (SELECT LAST_DAY(?3))", nativeQuery = true)
    public abstract Donation existsDonation(Long userId, Long countryId, Date donationDate);
}
