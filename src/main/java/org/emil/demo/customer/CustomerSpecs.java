package org.emil.demo.customer;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecs {

	public static Specification<Customer> customerHasBirthDay(LocalDate date){
		
		return(root,query,builder) -> builder.equal(root.get("birthDay"),date);
	
	}
	
	public static Specification<Customer> customerIsCreatedThisWeek(LocalDate date){
		return (root, query,builder) -> builder.between(root.get("dateCreated"), LocalDate.now(), LocalDate.now().plusWeeks(1));
	}
	
	
	public static Specification<Customer> customerHasName(String name){
		
		return new Specification<Customer>(){

			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				return criteriaBuilder.equal(root.get("name"), name);
			}
			
		};
		
	}
}
