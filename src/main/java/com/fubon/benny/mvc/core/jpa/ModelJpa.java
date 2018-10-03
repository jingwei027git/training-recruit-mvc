package com.fubon.benny.mvc.core.jpa;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Model JPA
 */
@NoRepositoryBean
public interface ModelJpa<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
