package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.*;

@Entity

public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER)
    Set<Account> accounts = new HashSet<>();
    public Client(){

    }
    public Client(String firstName, String lastName, String email){

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
}

        public Long getId() {
            return id;
        }

        public void SetName (String firstName){
    this.firstName = firstName;
     }

        public String getFirstName() {
            return firstName;
        }

        public void SetLastName (String lastName){
        this.lastName = lastName;
    }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
        public void SetEmail (String email){
        this.email = email;
    }

        public Set<Account> getAccounts() {
            return accounts;
        }

        public void addAccount(Account account) {
            account.setOwner(this);
            accounts.add(account);
        }

}