package com.springboot.web.app.repository;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import com.springboot.web.app.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
