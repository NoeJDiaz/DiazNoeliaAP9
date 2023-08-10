package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
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
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
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

			Transaction Transaction1 = new Transaction(TransactionType.DEBIT,-3200.00,"Comida",LocalDate.now());
			Account1.addTransaction(Transaction1);
			transactionRepository.save(Transaction1);

			Transaction Transaction2 = new Transaction(TransactionType.CREDIT,1500.00,"Otros",LocalDate.now());
			Account1.addTransaction(Transaction2);
			transactionRepository.save(Transaction2);

			Transaction Transaction3 = new Transaction(TransactionType.CREDIT,1580.00,"Farmacia",LocalDate.now());
			Account2.addTransaction(Transaction3);
			transactionRepository.save(Transaction3);

			Transaction Transaction4 = new Transaction(TransactionType.DEBIT,-1200.00,"Local",LocalDate.now());
			Account2.addTransaction(Transaction4);
			transactionRepository.save(Transaction4);

			Transaction Transaction5 = new Transaction(TransactionType.DEBIT,-6000.00,"Tienda",LocalDate.now());
			Account3.addTransaction(Transaction5);
			transactionRepository.save(Transaction5);

			Transaction Transaction6 = new Transaction(TransactionType.CREDIT,3000.00,"Joyeria",LocalDate.now());
			Account4.addTransaction(Transaction6);
			transactionRepository.save(Transaction6);
		};
	}
}