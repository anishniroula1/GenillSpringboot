package com.genill.user.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	public Customer getByFirstName(String firstName) {
		return repo.findByFirstName(firstName);
	}

}
