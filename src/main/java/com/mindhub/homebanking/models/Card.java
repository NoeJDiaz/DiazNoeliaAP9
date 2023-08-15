package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private Long id;
    private String cardholder;
    private CardType type;
    private CardColor color;
    private Double number;
    private Double cvv;
    private LocalDate thruDate;
    private LocalDate fromDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "holder_id")
    private Client holder;
    public Card() {

    }

    public Card(String cardholder, CardType type, CardColor color, Double number, Double cvv, LocalDate thruDate, LocalDate fromDate) {
        this.cardholder =cardholder;
        this.type =type;
        this.color =color;
        this.number =number;
        this.cvv =cvv;
        this.thruDate =thruDate;
        this.fromDate =fromDate;
    }

    public Long getId() {
        return id;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
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

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }

}
