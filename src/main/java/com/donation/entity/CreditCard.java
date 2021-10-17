package com.donation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "You must add the credit card name")
    private String name;

    @NotNull(message = "You must add the credit card balance")
    @Column(nullable = false)
    private Float balance;

    @Column(length = 16, nullable = false)
    @NotEmpty(message = "You must add de credit card number")
    @Size(min = 16, max = 16, message = "The credit card number must have 16 characters")
    private String number;

    @Column(length = 4, nullable = false)
    @NotEmpty(message = "You must add de credit card PIN code")
    @Size(min = 4, max = 4, message = "The credit card PIN code must have 4 characters")
    private String pin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public CreditCard(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
