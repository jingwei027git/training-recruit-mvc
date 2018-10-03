package com.fubon.benny.mvc.domain.car;

import com.fubon.benny.mvc.core.model.ModelId;
import com.fubon.benny.mvc.domain._common.enums.Color;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "car")
public class Car extends ModelId {

  private String name;

  private String brand;

  @Enumerated(EnumType.STRING)
  private Color color;

  private BigDecimal price;

}
