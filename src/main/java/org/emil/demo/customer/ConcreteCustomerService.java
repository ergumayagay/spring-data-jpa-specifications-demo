package org.emil.demo.customer;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcreteCustomerService implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findCustomers(LocalDate date) {
		
		//customRespository.fin
		
	//	customerRepository.findAll(CustomerSpecs.customerHasBirthDay(date));
		
		
		return customerRepository.findAll(CustomerSpecs.customerHasBirthDay(date).
				and(CustomerSpecs.customerHasName("Rec")));
		
		//return customerRepository.findAll(CustomerSpecs.customerHasBirthDay(date));
	}

	@Override
	public void createCustomer(Customer customer) {
		
		customerRepository.save(customer);
	}

}
