package com.mindhub.homebanking.dtos;



import com.mindhub.homebanking.models.Client;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private Set<AccountDTO> account = new HashSet<>();


    public ClientDTO (Client client){
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.account = client.getAccounts().stream().map(account -> new AccountDTO(account)).collect(Collectors.toSet());
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


    public Set<AccountDTO> getAccounts() {
        return account;
    }

}
