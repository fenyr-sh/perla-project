package models.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import models.dao.DAOManager;
import models.dao.RendimientoDAO;

/**
 *
 * @author Fenyr Shell
 */
public class MySQLDaoManager implements DAOManager {
    private Connection conn;
    private RendimientoDAO rendimientos = null;

    public MySQLDaoManager(String host, String username, String password, String database) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?serverTimezone=UTC", username, password);
    }

    @Override
    public RendimientoDAO getRendimientoDAO() {
        if (rendimientos == null)  {
            rendimientos = new MySQLRendimientoDAO(conn);
        }
        
        return rendimientos;
    }

}
