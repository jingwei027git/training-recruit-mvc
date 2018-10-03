package com.fubon.benny.mvc.domain.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fubon.benny.mvc.core.model.ModelId;
import com.fubon.benny.mvc.domain._common.enums.Sex;
import com.fubon.benny.mvc.domain.car.Car;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, exclude = {"cars"})
@Entity
@Table(name = "customer")
public class Customer extends ModelId {

  private String name;

  private Integer age;

  @Enumerated(EnumType.STRING)
  private Sex sex;

  private BigDecimal money;

  private String comment;

  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(
    name = "mapping_customer_car",
    joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "car_id", referencedColumnName = "id")})
  private List<Car> cars;

}
