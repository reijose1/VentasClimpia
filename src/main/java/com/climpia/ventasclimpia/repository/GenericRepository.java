package com.climpia.ventasclimpia.repository;

import java.util.List;

/**
 *
 * @author Reinaldo Carrillo
 */
public interface GenericRepository <T> {
    T save(T entity);
    T update(T entity);
    T findById(Object entityId);
    String delete (T entity);
    List <T> findAll(T entity);
}
