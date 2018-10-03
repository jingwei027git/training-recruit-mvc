package com.fubon.benny.mvc.core.dao;

import com.fubon.benny.mvc.core.jpa.ModelJpa;
import java.io.Serializable;

public interface ModelDao<T, ID extends Serializable> extends GenericDao {

  default ModelJpa<T, ID> getJpa()
  {
    throw new RuntimeException("jpa repository not assign");
  }

}
