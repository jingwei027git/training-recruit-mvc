package com.fubon.benny.mvc.domain.car.jpa;

import com.fubon.benny.mvc.core.jpa.ModelJpa;
import com.fubon.benny.mvc.domain.car.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarJpa extends ModelJpa<Car, Long> {

}
