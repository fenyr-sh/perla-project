package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fenyr Shell
 */
public class DatabaseConnection {
    
    private Connection connection = null;
    private final DatabaseConfiguration db_config;

    /**
     * Crea una nueva instancia de la clase con configuración.
     * 
     * @param databaseConfiguration
     */
    public DatabaseConnection(DatabaseConfiguration databaseConfiguration) {
        db_config = databaseConfiguration;
    }
    
    /**
     * Inicia el driver de conexión a la base de datos Mysql.
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void loadDriver() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // The newInstance() call is a work around for some
        // broken Java implementations

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    }
    
    /**
     * Abre la conexión con la base de datos.
     * 
     * @throws SQLException 
     */
    public void openConnection() throws SQLException {
        String URL = String.format("%s//[(host=%s,port=%s,user=%s,password=%s)]/%s?serverTimezone=%s",
                db_config.getProperty("DB_PROTOCOL"),
                db_config.getProperty("DB_HOST"),
                db_config.getProperty("DB_PORT"),
                db_config.getProperty("DB_USERNAME"),
                db_config.getProperty("DB_PASSWORD"),
                db_config.getProperty("DB_DATABASE"),
                db_config.getProperty("DB_TIMEZONE"));
        
        connection = DriverManager.getConnection(URL);
    }
    
    /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return conexión.
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Cierra la conexion con la base de datos.
     * 
     * @throws java.sql.SQLException
     */
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
}
