package com.donation.service;

import com.donation.entity.Visit;
import com.donation.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }
    public Integer getTotalVisits() {
        return visitRepository.getTotalVisits();
    }

    public Visit getTodayVisit() {
        return visitRepository.getTodayVisit();
    }
}
