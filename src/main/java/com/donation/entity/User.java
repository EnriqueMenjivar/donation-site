package com.donation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @NotNull(message = "You must add your ID Document")
    private Long idDocument;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "You must add your last name")
    private String surname;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "You must add your first name")
    private String name;

    @Column(length = 100, unique = true, nullable = false)
    @NotEmpty(message = "You must add your email")
    @Email(message = "Must be a well-formed email address")
    private String email;

    @NotEmpty(message = "You must add your password")
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Donation> donations = new ArrayList<>();

    public User(){}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
}
