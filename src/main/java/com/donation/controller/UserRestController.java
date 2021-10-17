package com.donation.controller;

import com.donation.dto.UserDonationDto;
import com.donation.entity.User;
import com.donation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{email}/exists-email")
    public Boolean existsByEmail(@PathVariable("email") String email) {
        return userService.existsByEmail(email);
    }

    @GetMapping("/{id}/exists-id")
    public Boolean existsByIdDocument(@PathVariable("id") Long id) {
        return userService.existsByIdDocument(id);
    }


    @GetMapping("/{id}/donations")
    public ResponseEntity<?> getDonations(@PathVariable("id") Long id) {
        User user = userService.findByIdDocument(id);

        if(user == null){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(UserDonationDto.entityToDto(user), HttpStatus.OK);
    }
}
