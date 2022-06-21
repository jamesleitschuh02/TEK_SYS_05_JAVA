package com.springboot.web.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.web.app.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
