package perlaproject;

import database.DatabaseConfiguration;
import database.DatabaseConnection;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fenyr Shell
 */
public class PerlaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statement stmt = null;
        ResultSet rs = null;

        File config_file = new File("db_configuration");
        DatabaseConfiguration db_config =  new DatabaseConfiguration(config_file);
        // Configuracion predeterminada en caso de no existir un archivo con la configuracion.
        db_config.setConfiguration("jdbc:mysql:", "localhost", "3306", "app", "guest", "secret", "UTC");
        
        try {
            // Carga la configuracion a partir de un archivo.
            db_config.loadConfiguration();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        DatabaseConnection db_conn = new DatabaseConnection(db_config);
        
        try {
            db_conn.openConnection();

            // Do something with the Connection
            stmt = db_conn.getConnection().createStatement();

            rs = stmt.executeQuery("SELECT * FROM users");
            
            while (rs.next()) {                
                System.out.println(rs.getString("username") + " --- " + rs.getString("password") + " --- " + rs.getString("role"));
            }
            
            // Now do something with the ResultSet ....

            db_conn.closeConnection();
            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

}
