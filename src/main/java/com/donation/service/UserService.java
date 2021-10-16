package com.donation.service;

import com.donation.entity.User;
import com.donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {

        return userRepository.save(user);
    }
}
