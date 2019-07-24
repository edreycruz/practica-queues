package com.baz.springboot.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baz.springboot.log.model.Account;

public interface AccountLogRepository extends JpaRepository<Account, Integer> {

}
