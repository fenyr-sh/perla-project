package models.dao;

import java.util.List;
import models.Rendimiento;

/**
 *
 * @author Fenyr Shell
 * @param <T>
 * @param <K>
 */
public interface DAO<T, K> {
    
    void save(T r) throws DAOException;
    
    void update(T r) throws DAOException;
    
    void delete(T r) throws DAOException;
    
    List<T> getAll() throws DAOException;
    
    T get(K id) throws DAOException;
    
}
