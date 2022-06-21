package com.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
