package com.atech.flight.app.utils;

import java.util.List;

/**
 * Utility to Simplify CRUD operations
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
public interface GenericCrudService<T, ID> {

    public T save(T entity);

    public T update(T entity);

    public void delete(ID id);

    public List<T> findAll();

    public T findOne(ID id);
}
