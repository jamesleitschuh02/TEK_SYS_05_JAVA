package com.example.myspringdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.myspringdata.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}

