package perlaproject;

import database.DatabaseConnection;
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

        DatabaseConnection connection = new DatabaseConnection();
        connection.setConnectionData("jdbc:mysql:", "localhost", "3306", "test", "karlos", "", "UTC");

        try {
            connection.loadDriver();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {

        }

        try {
            connection.openConnection();

            // Do something with the Connection
            stmt = connection.getConnection().createStatement();

            rs = stmt.executeQuery("SELECT * FROM users");
            
            while (rs.next()) {                
                System.out.println(rs.getString("name"));
            }
            
            // Now do something with the ResultSet ....

            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

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
