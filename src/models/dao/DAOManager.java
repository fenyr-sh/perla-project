package models.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Fenyr Shell
 */
public interface DAOManager {
    
    RendimientoDAO getRendimientoDAO();
    
    void loadConfigurationFromFile(File file) throws FileNotFoundException, IOException, SQLException;
    
    void closeConnection() throws SQLException;
}
