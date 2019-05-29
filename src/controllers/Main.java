package controllers;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.dao.DAOException;
import models.dao.DAOManager;
import models.dao.mysql.MySQLDaoManager;
import views.rendimiento.buque.Index;

/**
 *
 * @author Fenyr Shell
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File config_file = new File("db_configuration");

        DAOManager manager = new MySQLDaoManager();

        try {
            
            manager.loadConfigurationFromFile(config_file);
            new Index(manager).setVisible(true);
            
        } catch (IOException ex) {
            System.out.println("Error en IO: " + ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error IO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos!"
                    + "\nRevisa el archivo de configuración."
                    + "\n\nError: \n" + ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        } catch (DAOException ex) {
            System.out.println("Error en DAO: " + ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en SQL", JOptionPane.INFORMATION_MESSAGE);
        }        
        
    }
}
