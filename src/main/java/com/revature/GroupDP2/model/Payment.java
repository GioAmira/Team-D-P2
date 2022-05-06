package com.revature.GroupDP2.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment", schema = "groupd")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "cvv_number")
    private Integer cvv_number;

    public Payment() {

    }

    public Payment(Integer cardNumber , LocalDate expirationDate , Integer cvv_number) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv_number = cvv_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCvv_number() {
        return cvv_number;
    }

    public void setCvv_number(Integer cvv_number) {
        this.cvv_number = cvv_number;
    }
}
