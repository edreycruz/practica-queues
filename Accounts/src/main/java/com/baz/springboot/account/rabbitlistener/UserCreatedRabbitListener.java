package com.baz.springboot.account.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.baz.springboot.account.user.events.UserCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserCreatedRabbitListener {

	// Inyecte Bean ApplicationEventPublisher publisher
@Autowired
	private ApplicationEventPublisher publisher;
	@Autowired
	private ObjectMapper objectMapper;

	@SneakyThrows
	@RabbitListener(queues = { "#{userCreatedAccountQueue.name}" })
	public void handleUserCreatedEvent(String message) {
		log.info("rabbit listener User Created Event");
		UserCreatedEvent uce = objectMapper.readValue(message, UserCreatedEvent.class);
		log.info("event: {}", uce);
		log.info("publishing User Created Event (from Account)");

		// Implemente envio de evento UserCreatedEvent
		publisher.publishEvent(uce);
		log.info("--------------------------------------------------------------");
	}
}
