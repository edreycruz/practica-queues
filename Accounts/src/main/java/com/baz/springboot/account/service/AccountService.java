package com.baz.springboot.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.baz.springboot.account.events.AccountCreatedEventBuilder;
import com.baz.springboot.account.model.Account;
import com.baz.springboot.account.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	// Inyecte la dependencia faltante
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void createAccount(Account account) {

		log.info("create account service start");

		accountRepository.save(account);

		log.info("publishing Account Created Event");
		
		
		// Implemente la logica faltante
		publisher.publishEvent(AccountCreatedEventBuilder.build(account));
	}
}
