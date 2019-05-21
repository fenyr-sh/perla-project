package controllers;

import com.toedter.calendar.JDateChooser;
import database.DatabaseConfiguration;
import database.DatabaseConnection;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 *
 * @author Fenyr Shell
 */
public final class Util {

    private Util() {}
    
    /**
     * Convierte una fecha y hora a numero decimal y aplica la formula: 
     * ((fecha - 1) * 24) + hora).
     * @param date fecha.
     * @param hour hora.
     * @return fecha y hora convertida a decimal.
     */
    public static double numberDate(Date date, double hour) {
        int numberDate = (int) DateUtil.getExcelDate(date);
        double result = ((numberDate - 1) * 24) + hour;

        return result;
    }

    /**
     * Evalua si al precionar una tecla el valor es numerico.
     * @param component
     * @param evt KeyEvent
     */
    public static void onlyNumber(Component component, KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.')) {
            evt.consume();
            component.getToolkit().beep();
        }else {
        }
    }
    
    /**
     * Convierte a mayuscula cada letra.
     * @param evt 
     */
    public static void onlyUpperCase(KeyEvent evt) {
        char c = evt.getKeyChar();
        
        if (Character.isLowerCase(c)) {
            String cadena = ("" + c).toUpperCase();
            c = cadena.charAt(0);
            evt.setKeyChar(c);
        }
    }
    
    /**
     * Retorna verdadero si el/los campo(s) JTextField(s) estan vacios.
     * @param textFields JTextField a evaluar.
     * @return verdadero o falso.
     */
    public static boolean fieldIsEmpty(JTextField... textFields) {
        boolean empty = false;
        
        for (JTextField item : textFields) {
            if(item.getText().isEmpty()) {
                empty = true;
            }
        }
        
        return empty;
    }

    /**
     * Retorna verdadero si el/los campo(s) JDateChooser estan vacios.
     * @param dateChoosers JDateChooser a evaluar.
     * @return verdadero o falso.
     */
    public static boolean dateIsEmpty(JDateChooser... dateChoosers) {
        boolean empty = false;
        
        for(JDateChooser item : dateChoosers){
            if (item.getDate() == null) {
                empty = true;
            }
        }
        
        return empty;
    }
    
    public static void generatePDF(Component component) {
        File config_file = new File("db_configuration");
        DatabaseConfiguration db_config = new DatabaseConfiguration(config_file);
        // Configuracion predeterminada en caso de no existir un archivo con la configuracion.
        db_config.setConfiguration("jdbc:mysql:", "localhost", "3306", "app", "guest", "secret", "UTC");
        
        try {
            // Carga la configuracion a partir de un archivo.
            db_config.loadConfiguration();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        DatabaseConnection db_conn = new DatabaseConnection(db_config);
        
        JasperReport report;
        
        URL path = component.getClass().getClassLoader().getResource("pdf/rendimiento.jasper");

        Map<String, Object> map = new HashMap<>();
        
        try {
            db_conn.openConnection();
            report = (JasperReport) JRLoader.loadObject(path);
            map.put("id_user", 2);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, db_conn.getConnection());
            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jasperViewer.setVisible(true);
            
        } catch (JRException | SQLException ex) {
            System.out.println(ex.getCause());
        } finally {
            
            try {
                if (db_conn.getConnection() != null) {
                    db_conn.closeConnection();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
