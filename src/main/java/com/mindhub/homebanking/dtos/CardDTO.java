package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;

import java.time.LocalDate;

public class CardDTO {
    private Long id;
    private String cardholder;
    private CardType type;
    private CardColor color;
    private Double number;
    private Double cvv;
    private LocalDate thruDate;
    private LocalDate fromDate;
    public  CardDTO(Card card) {
    this.id = card.getId();
    this.cardholder = card.getCardholder();
    this.type = card.getType();
    this.color = card.getColor();
    this.number = card.getNumber();
    this.cvv = card.getCvv();
    this.thruDate = card.getThruDate();
    this.fromDate = card.getFromDate();
    }
    public Long getId() {
        return id;
    }
    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }
    public String getCardholder() {
        return cardholder;
    }
    public void setType(CardType type) {
        this.type = type;
    }
    public CardType getType() {
        return type;
    }
    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }
    public Double getNumber() {
        return number;
    }
    public void setNumber(Double number) {
        this.number = number;
    }
    public Double getCvv() {
        return cvv;
    }

    public void setCvv(Double cvv) {
        this.cvv = cvv;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }


    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }






}
