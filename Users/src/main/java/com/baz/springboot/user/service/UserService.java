package com.baz.springboot.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.baz.springboot.user.events.UserCreatedEvent;
import com.baz.springboot.user.events.UserCreatedEventBuilder;
import com.baz.springboot.user.model.User;
import com.baz.springboot.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	// Inyecte Bean ApplicationEventPublisher publisher
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {

		log.info("create user service start");

		userRepository.save(user);

		log.info("publishing User Created Event");

		// Implemente envio de evento UserCreatedEvent
		publisher.publishEvent(UserCreatedEventBuilder.build(user));
	}
}
