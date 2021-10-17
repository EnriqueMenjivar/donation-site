package com.donation.dto;

import com.donation.entity.Donation;

import java.util.Date;

public class DonationDto {
    private String country;
    private String institution;
    private Float donationAmount;
    private Date donationDate;

    public DonationDto(){}

    public static DonationDto entityToDto(Donation donation) {
        DonationDto dto = new DonationDto();

        dto.setCountry(donation.getInstitution().getCountry().getName());
        dto.setInstitution(donation.getInstitution().getName());
        dto.setDonationDate(donation.getDonationDate());
        dto.setDonationAmount(donation.getDonationAmount());

        return dto;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Float getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(Float donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }
}
