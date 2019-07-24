package com.baz.springboot.account.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.baz.springboot.account.model.Account;
import com.baz.springboot.account.service.AccountService;
import com.baz.springboot.account.user.events.UserCreatedEvent;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserCreatedListener {

	@Autowired
	private AccountService accountService;

	@SneakyThrows
	@EventListener
	public void handleUserCreatedEvent(UserCreatedEvent uce) {
		log.info("handling User Created Event {}", uce);

		Account account = Account.builder()
				.userId(uce.getId())
				.build();

		accountService.createAccount(account);
		log.info("--------------------------------------------------------------");
	}
}
