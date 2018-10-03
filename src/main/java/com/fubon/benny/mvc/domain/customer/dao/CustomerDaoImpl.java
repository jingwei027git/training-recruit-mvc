package com.fubon.benny.mvc.domain.customer.dao;

import com.fubon.benny.mvc.core.annotation.NonTx;
import com.fubon.benny.mvc.core.annotation.TxRead;
import com.fubon.benny.mvc.core.dao.ModelDaoImpl;
import com.fubon.benny.mvc.domain.customer.Customer;
import com.fubon.benny.mvc.domain.customer.jpa.CustomerJpa;
import lombok.Getter;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

@TxRead
@Repository
public class CustomerDaoImpl extends ModelDaoImpl<Customer, Long> implements CustomerDao {

  @Getter(onMethod = @__({@NonTx}))
  @Autowired
  private CustomerJpa jpa;

}
