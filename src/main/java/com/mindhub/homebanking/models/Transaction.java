package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private Long id;
    private TransactionType type;
    private Double amount;
    private String description;
    private LocalDate date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Account owner;

    public Transaction(){

    }

    public Transaction(TransactionType type, Double amount, String description, LocalDate date ){

        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }





    public Long getId() {
        return id;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
    public TransactionType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner= owner;
    }
}
