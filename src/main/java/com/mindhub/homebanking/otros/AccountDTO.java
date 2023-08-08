package com.mindhub.homebanking.otros;

import com.mindhub.homebanking.models.Account;

import java.time.LocalDate;

public class AccountDTO {

    private Long id;
    private String number;
    private LocalDate creationDate;
    private Double balance;

public AccountDTO(Account account){
    this.id = account.getId();
    this.number = account.getNumber();
    this.creationDate = account.getCreationDate();
    this.balance = account.getBalance();
}

    public Long getId() {
        return id;
    }

    public void setNumber (String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setCreationDate (LocalDate creationDate){
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setBalance (Double balance){
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
}
