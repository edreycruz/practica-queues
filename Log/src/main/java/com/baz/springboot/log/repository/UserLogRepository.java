package com.baz.springboot.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baz.springboot.log.model.User;

public interface UserLogRepository extends JpaRepository<User, Integer> {

}
