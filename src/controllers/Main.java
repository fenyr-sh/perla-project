package controllers;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
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
        // Establece la apariencia de la aplicación.
//        try {
//            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        File config_file = new File("db_configuration");

        DAOManager manager = new MySQLDaoManager();

        try {
            
            manager.loadConfigurationFromFile(config_file);
            new Index(manager).setVisible(true);
            
        } catch (IOException ex) {
            
        } catch (SQLException ex) {
            
        } catch (DAOException ex) {
            
        }

        

        
        
        
    }
}
