package com.baz.springboot.log.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baz.springboot.log.model.User;
import com.baz.springboot.log.repository.UserLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserCreatedLogRabbitListener {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserLogRepository userLogRepository;

	@SneakyThrows
	// Defina listener RabbitListener
	@RabbitListener(queues={"#{userCreatedLogQueue.name}"})
	public void handleUserCreatedEvent(String message) {
		log.info("rabbit listener User Created Log Event");
		// Recupere objeto User
		User user = objectMapper.readValue(message, User.class); 
		 log.info("event: {}", user);

		// Almacene objeto User
		userLogRepository.save(user);
		log.info("--------------------------------------------------------------");
	}
}
