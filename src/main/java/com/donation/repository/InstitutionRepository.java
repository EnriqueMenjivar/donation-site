package com.donation.repository;

import com.donation.entity.Country;
import com.donation.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    public abstract List<Institution> findByCountry(Country country);
}
