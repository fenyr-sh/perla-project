package models.dao;

import java.util.List;

/**
 *
 * @author Fenyr Shell
 * @param <T>
 * @param <K>
 * @param <I>
 */
public interface DAO<T, K, I> {
    
    void save(T r) throws DAOException;
    
    void update(T r) throws DAOException;
    
    void delete(T r) throws DAOException;
    
    List<T> getAll(I limit) throws DAOException;
    
    T get(K id) throws DAOException;
    
}
