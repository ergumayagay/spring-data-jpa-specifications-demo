package org.emil.demo.customer;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(@RequestParam @DateTimeFormat(iso= ISO.DATE) LocalDate date){
		
		return customerService.findCustomers(date);
	}

	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer customer) {
		
		customerService.createCustomer(customer);	
	}
	

}
