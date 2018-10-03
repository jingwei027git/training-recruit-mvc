package com.fubon.benny.mvc.app.customer;

import com.fubon.benny.mvc.domain.customer.Customer;
import com.fubon.benny.mvc.domain.customer.dao.CustomerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/customers")
@RestController
public class CustomerController {

  private CustomerDao customerDao;

  CustomerController(
    @Autowired CustomerDao customerDao)
  {
    this.customerDao = customerDao;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> read(
    @PathVariable Long id)
  {
    final Customer customer = customerDao.getJpa().findOne(id);
    log.info("{}", customer);

    return ResponseEntity.ok(customer);
  }

}
