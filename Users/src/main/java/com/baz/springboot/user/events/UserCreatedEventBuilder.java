package com.baz.springboot.user.events;

import com.baz.springboot.user.model.User;

public class UserCreatedEventBuilder {

	public static UserCreatedEvent build(User user) {
		return UserCreatedEvent.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.build();
	}
}
