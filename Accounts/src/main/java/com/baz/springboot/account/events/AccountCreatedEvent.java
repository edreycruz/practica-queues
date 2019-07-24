package com.baz.springboot.account.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AccountCreatedEvent {

	public int id;

	public String accountNumber;

	public int userId;

}
