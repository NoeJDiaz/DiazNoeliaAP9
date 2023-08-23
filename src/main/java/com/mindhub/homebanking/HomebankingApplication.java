package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalTime.now;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {

		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository,  CardsRepository cardsRepository) {
		return (args)-> {
			Client client1 = new Client("Melva", "Morel", "melba@mindhub.com", passwordEncoder.encode("123321"));
			Client client2 = new Client("Luna", "Da Silva", "Lulu@mindhub.com",passwordEncoder.encode("124421"));

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

/*
			Loan Loan1 = new Loan("Hipotecario",500000.00, List.of(12,24,36,48,60));
			client1.addLoan(Loan1);
			loanRepository.save(Loan1);

			Loan Loan2 = new Loan("Personal",100000.00, List.of(6,12,24));
			client1.addLoan(Loan2);
			loanRepository.save(Loan2);

			Loan Loan3 = new Loan("Automotriz",300000.00, List.of(6,12,24,36));
			client1.addLoan(Loan3);
			loanRepository.save(Loan3);


 */
			Loan loan3 = new Loan("Automotriz",300000.00, List.of(6,12,24,36));
			Loan loan2 = new Loan("Personal",100000.00, List.of(6,12,24));
			Loan loan1 = new Loan("Hipotecario",500000.00, List.of(12,24,36,48,60));

			loanRepository.save(loan1);
			loanRepository.save(loan2);
			loanRepository.save(loan3);
			ClientLoan clientLoan1 = new ClientLoan(60, 400000.00, client1, loan1);
			clientLoanRepository.save(clientLoan1);

			ClientLoan clientLoan2 = new ClientLoan(12, 50000.00, client1, loan1);

			clientLoanRepository.save(clientLoan2);

			ClientLoan clientLoan3 = new ClientLoan(24, 100000.00, client2, loan2);
			clientLoanRepository.save(clientLoan3);
			ClientLoan clientLoan4 = new ClientLoan(36, 200000.00, client2, loan3);
			clientLoanRepository.save(clientLoan4);

			Card card1 = new Card("Melva Morel", CardType.DEBIT,CardColor.GOLD,1231546464616587.00,455.00,LocalDate.now().plusYears(5),LocalDate.now());
			client1.addCard(card1);
			cardsRepository.save(card1);
			Card card2 = new Card("Melva Morel", CardType.CREDIT,CardColor.TITANIUM,1231546555501578.00,321.00,LocalDate.now().plusYears(5),LocalDate.now());
			client1.addCard(card2);
			cardsRepository.save(card2);

			Card card3 = new Card("Luna Da Silva", CardType.CREDIT,CardColor.SILVER,1231546556054867.00,322.00,LocalDate.now().plusYears(5),LocalDate.now());
			client2.addCard(card3);
			cardsRepository.save(card3);

		};
	}

}