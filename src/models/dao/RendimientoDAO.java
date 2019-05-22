package models.dao;

import java.util.List;
import models.Rendimiento;

/**
 *
 * @author Fenyr Shell
 */
public interface RendimientoDAO extends DAO<Rendimiento, Long> {

    public List<Rendimiento> getBy(String buque, String carga, String producto, String arribo_inicio, String arribo_fin) throws DAOException;
    
    public void validate(Rendimiento r) throws DAOException;
}
