package com.springboot.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.springboot.web.app.model.Customer;
import com.springboot.web.app.repository.CustomerRepository;

@Controller
@RequestMapping(path="/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	
	// create customer
	@PostMapping("/newcustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerRepo.save(customer), HttpStatus.CREATED);
	}

	// get all users
	@GetMapping("/getall")
	public @ResponseBody Iterable<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
    @GetMapping("/gethome")
    public String goHomepage(){
        return "homepage";
    }
	
}
