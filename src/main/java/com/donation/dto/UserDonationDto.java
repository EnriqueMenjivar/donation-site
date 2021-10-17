package com.donation.dto;

import com.donation.entity.Donation;
import com.donation.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDonationDto {

    private Long idDocument;
    private String surname;
    private String name;
    private String email;
    private List<DonationDto> donations = new ArrayList<>();

    public UserDonationDto(){}

    public static UserDonationDto entityToDto(User user) {
        UserDonationDto dto = new UserDonationDto();

        dto.setIdDocument(user.getIdDocument());
        dto.setSurname(user.getSurname());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        List<DonationDto> donationDtos = user.getDonations().stream().map(DonationDto::entityToDto).collect(Collectors.toList());
        dto.setDonations(donationDtos);

        return dto;
    }

    public Long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DonationDto> getDonations() {
        return donations;
    }

    public void setDonations(List<DonationDto> donations) {
        this.donations = donations;
    }
}
