package com.mindhub.homebanking.controller;


import com.mindhub.homebanking.configuration.WebAuthentication;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
    List<Client> allClients = clientRepository.findAll();

    System.out.println("Antes "+allClients.size());

    List<ClientDTO> convertedList = allClients
            .stream()
            .map(currentClient -> new ClientDTO(currentClient))
            .collect(Collectors.toList());

    System.out.println("Despues");


    return convertedList;
}

@GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id){
            return new ClientDTO(clientRepository.findById(id).get());
}

/*@GetMapping ("/clients/current")
    public ClientDTO getCurrentClient(Authentication authentication){
            return  clientRepository.findByEmail(authentication.getName());

    };*/
        @RequestMapping(path = "/api/clients", method = RequestMethod.POST)
        public ResponseEntity<Object> register(
                @RequestParam String firstName, @RequestParam String lastName,
                @RequestParam String email, @RequestParam String password) {
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
            }
            if (clientRepository.findByEmail(email) !=  null) {
                return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
            }
           clientRepository.save(new Client(firstName, lastName, email, passwordEncoder.encode(password)));
            return new ResponseEntity<>(HttpStatus.CREATED);

}
}