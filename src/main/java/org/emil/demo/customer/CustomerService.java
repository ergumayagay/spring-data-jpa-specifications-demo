package org.emil.demo.customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
	
	public List<Customer> findCustomers(LocalDate date);
	
	public void createCustomer(Customer customer);

}
