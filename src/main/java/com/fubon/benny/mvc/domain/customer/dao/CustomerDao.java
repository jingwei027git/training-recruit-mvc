package com.fubon.benny.mvc.domain.customer.dao;

import com.fubon.benny.mvc.core.dao.ModelDao;
import com.fubon.benny.mvc.domain.customer.Customer;
import com.fubon.benny.mvc.domain.customer.jpa.CustomerJpa;

public interface CustomerDao extends ModelDao<Customer, Long> {

  @Override
  CustomerJpa getJpa();

}
