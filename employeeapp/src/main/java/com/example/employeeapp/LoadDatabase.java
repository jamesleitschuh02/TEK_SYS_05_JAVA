package com.example.employeeapp;

import entity.EmployeeEntity;
import repositories.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository) {
        EmployeeEntity e = new EmployeeEntity();
        e.setName("Bob");
        e.setRole("manager");
        return args -> {
            log.info("Preloading " + employeeRepository.save(new EmployeeEntity("James L", "Dev")));
            log.info("Preloading " + employeeRepository.save(e));
        };
    }
}
