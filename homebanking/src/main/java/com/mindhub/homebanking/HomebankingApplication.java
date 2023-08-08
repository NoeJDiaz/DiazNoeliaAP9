package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {

		SpringApplication.run(HomebankingApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository) {
		return (args)-> {
			Client client1 = new Client("Melva", "Morel", "melba@mindhub.com");
			Client client2 = new Client("Luna", "Da Silva", "Lulu@mindhub.com");

			clientRepository.save(client1);
			clientRepository.save(client2);

			Account Account1 = new Account( "VIN001", LocalDate.now(),5000.00);
			client1.addAccount(Account1);
			accountRepository.save(Account1);

			Account Account2 = new Account( "VIN002", LocalDate.now().plusDays(1),7500.00);
			client1.addAccount(Account2);
			accountRepository.save(Account2);

			Account Account3 = new Account( "VIN003", LocalDate.now(),7000.00);
			client2.addAccount(Account3);
			accountRepository.save(Account3);

			Account Account4 = new Account( "VIN004", LocalDate.now().plusDays(10),13000.00);
			client2.addAccount(Account4);
			accountRepository.save(Account4);


		};
	}
}