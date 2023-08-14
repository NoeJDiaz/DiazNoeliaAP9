package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.ClientLoan;

import java.util.HashSet;
import java.util.Set;

public class ClientLoanDTO {
    private Long id;
    private Integer payments;
    private Double amount;
    private Long loanId;
    private String name;

    public  ClientLoanDTO(){

    }

    public ClientLoanDTO (ClientLoan clientLoan){
        this.id = clientLoan.getId();
        this.payments = clientLoan.getPayments();
        this.amount = clientLoan.getAmount();
        this.loanId = clientLoan.getLoan().getId();
        this.name = clientLoan.getLoan().getName();
    }

    public Long getId() {
        return id;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public Integer getPayments() {
        return payments;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getLoanId() {
        return loanId;
    }

    public String getName() {
        return name;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public void setname(String name) {
        this.name = name;
    }
}
