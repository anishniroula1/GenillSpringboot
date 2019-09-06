package com.genill.user.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
	
	Customer findByFirstName(String firstname);
}
