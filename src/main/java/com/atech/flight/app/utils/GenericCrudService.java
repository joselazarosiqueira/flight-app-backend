package com.atech.flight.app.utils;

import java.util.List;

/**
 * Utility to Simplify CRUD operations
 *
 * @author José Júnior <jose.junior@jetsoft.com.br>
 */
public interface GenericCrudService<T, ID> {

    public T save(T vo);

    public T update(T vo);

    public void delete(ID id);

    public List<T> findAll();

    public T findOne(ID id);
}
