package ro.teamnet.zth.api.em;

import java.util.List;

/**
 * Created by Adi on 29.04.2015.
 */
public interface EntityManager {

    <T> T findById(Class<T> entityClass, int id);
    <T> List<T> findAll(Class<T> entityClass);
    <T> Object insert(T entity);
    <T> T update(T entity);
    void delete(Object entity);

}
