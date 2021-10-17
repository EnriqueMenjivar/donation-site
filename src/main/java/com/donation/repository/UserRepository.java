package com.donation.repository;

import com.donation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public abstract User findByEmail(String email);
    public abstract User findByIdDocument(Long id);
    public abstract  Boolean existsByIdDocument(Long idDocument);
    public abstract  Boolean existsByEmail(String email);
}
