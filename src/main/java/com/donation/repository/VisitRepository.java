package com.donation.repository;

import com.donation.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query(value = "SELECT IFNULL(SUM(v.views),0) AS views FROM visits v", nativeQuery = true)
    public abstract Integer getTotalVisits();

    @Query(value = "SELECT * FROM visits v WHERE DATE_FORMAT(v.date, '%Y-%m-%d') = CURDATE() LIMIT 1", nativeQuery = true)
    public abstract Visit getTodayVisit();
}
