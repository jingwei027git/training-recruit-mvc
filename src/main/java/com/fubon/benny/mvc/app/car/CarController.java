package com.fubon.benny.mvc.app.car;

import com.fubon.benny.mvc.domain.car.Car;
import com.fubon.benny.mvc.domain.car.dao.CarDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/cars")
@RestController
public class CarController {

  private CarDao carDao;

  CarController(
    @Autowired CarDao carDao)
  {
    this.carDao = carDao;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Car> read(
    @PathVariable Long id)
  {
    final Car car = carDao.getJpa().findOne(id);
    log.info("{}", car);

    return ResponseEntity.ok(car);
  }

}
