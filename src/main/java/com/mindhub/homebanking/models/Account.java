package com.mindhub.homebanking.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String number;
    private LocalDate creationDate;
    private Double balance;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Client owner;

    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER)
    Set<Transaction> transactions = new HashSet<>();
    public Account(){

    }
public Account( String number, LocalDate creationDate, Double balance){
    this.number = number;
    this.creationDate = creationDate;
    this.balance = balance;
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


    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transaction.setOwner(this);
       transactions.add(transaction);
    }
}
