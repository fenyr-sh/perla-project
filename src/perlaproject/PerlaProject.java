package perlaproject;

import database.Configuration;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fenyr Shell
 */
public class PerlaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Configuration config = new Configuration();

        try {
            config.loadProperties();
        } catch (IOException ex) {
            System.out.println("The config.properties file does not exist, default properties loaded.");
        }
        
        Connection conn = null;
        try {
            // jdbc:mysql://localhost:3306/test, user, password
            String URL = String.format("%s//[(host=%s,port=%s)]/%s", config.getProperty("DB_PROTOCOL"), config.getProperty("DB_HOST"), config.getProperty("DB_PORT"), config.getProperty("DB_DATABASE"));
            conn = DriverManager.getConnection(URL, config.getProperty("DB_USERNAME"), config.getProperty("DB_PASSWORD"));
            // Do something with the Connection
            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
}
