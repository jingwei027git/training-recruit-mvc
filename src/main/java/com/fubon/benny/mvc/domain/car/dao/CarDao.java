package com.fubon.benny.mvc.domain.car.dao;

import com.fubon.benny.mvc.core.dao.ModelDao;
import com.fubon.benny.mvc.domain.car.Car;
import com.fubon.benny.mvc.domain.car.jpa.CarJpa;

public interface CarDao extends ModelDao<Car, Long> {

  @Override
  CarJpa getJpa();

}
