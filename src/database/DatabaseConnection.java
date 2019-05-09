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
    private DatabaseConfiguration config;

    public DatabaseConnection() {
        config = new DatabaseConfiguration();
    }

    public DatabaseConnection(DatabaseConfiguration databaseConfiguration) {
        config = databaseConfiguration;
    }
    
    public void setConnectionData(String protocol, String host, String port,
            String database, String username, String password, String timezone) {
        
        config.setConfiguration(protocol, host, port, database, username, password, timezone);
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
    
    public void openConnection() throws SQLException {
        String URL = String.format("%s//[(host=%s,port=%s,user=%s,password=%s)]/%s?serverTimezone=%s", 
                config.getProperty("DB_PROTOCOL"), 
                config.getProperty("DB_HOST"), 
                config.getProperty("DB_PORT"), 
                config.getProperty("DB_USERNAME"),
                config.getProperty("DB_PASSWORD"),
                config.getProperty("DB_DATABASE"),
                config.getProperty("DB_TIMEZONE"));
        
        connection = DriverManager.getConnection(URL);
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        connection = null;
    }
    
}
