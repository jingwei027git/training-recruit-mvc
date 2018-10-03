package com.fubon.benny.mvc.core.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ModelId implements Model {

  @Id
  protected Long id;

}
