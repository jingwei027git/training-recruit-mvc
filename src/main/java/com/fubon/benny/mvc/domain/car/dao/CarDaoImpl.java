package com.fubon.benny.mvc.domain.car.dao;

import com.fubon.benny.mvc.core.annotation.NonTx;
import com.fubon.benny.mvc.core.annotation.TxRead;
import com.fubon.benny.mvc.core.dao.ModelDaoImpl;
import com.fubon.benny.mvc.domain.car.Car;
import com.fubon.benny.mvc.domain.car.jpa.CarJpa;
import lombok.Getter;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

@TxRead
@Repository
public class CarDaoImpl extends ModelDaoImpl<Car, Long> implements CarDao {

  @Getter(onMethod = @__({@NonTx}))
  @Autowired
  private CarJpa jpa;

}
