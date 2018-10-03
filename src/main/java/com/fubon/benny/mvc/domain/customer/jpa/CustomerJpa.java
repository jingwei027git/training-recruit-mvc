package com.fubon.benny.mvc.domain.customer.jpa;

import com.fubon.benny.mvc.core.jpa.ModelJpa;
import com.fubon.benny.mvc.domain.customer.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpa extends ModelJpa<Customer, Long> {

}
