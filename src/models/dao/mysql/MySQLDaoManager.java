package models.dao.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
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

    public MySQLDaoManager() {
        
    }

    @Override
    public void loadConfigurationFromFile(File configurationFile) throws FileNotFoundException, IOException, SQLException {
        Properties p = new Properties();
        
        InputStream inputStream = new FileInputStream(configurationFile);
        p.load(inputStream);
        
        String URL = String.format("%s//[(host=%s,port=%s,user=%s,password=%s)]/%s?serverTimezone=%s",
                                p.getProperty("DB_PROTOCOL"),
                                p.getProperty("DB_HOST"),
                                p.getProperty("DB_PORT"),
                                p.getProperty("DB_USERNAME"),
                                p.getProperty("DB_PASSWORD"),
                                p.getProperty("DB_DATABASE"),
                                p.getProperty("DB_TIMEZONE"));
        
        conn = DriverManager.getConnection(URL);
        
        inputStream.close();
    }
    
    @Override
    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    
    @Override
    public RendimientoDAO getRendimientoDAO() {
        if (rendimientos == null)  {
            rendimientos = new MySQLRendimientoDAO(conn);
        }
        
        return rendimientos;
    }

}
