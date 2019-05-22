package models.dao;

import java.sql.Date;
import java.util.List;
import models.Rendimiento;

/**
 *
 * @author Fenyr Shell
 */
public interface RendimientoDAO extends DAO<Rendimiento, Long> {

    public List<Rendimiento> getByBuque(String buque, Date arribo_inicio, Date arribo_fin) throws DAOException;
    
}
