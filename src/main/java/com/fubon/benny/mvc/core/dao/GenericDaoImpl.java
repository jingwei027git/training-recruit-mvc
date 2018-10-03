package com.fubon.benny.mvc.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

public abstract class GenericDaoImpl implements GenericDao {

  @PersistenceContext
  private EntityManager entityManager;

  protected Session getHibernateSession()
  {
    return entityManager.unwrap(Session.class);
  }

}
