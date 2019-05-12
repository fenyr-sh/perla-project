package controllers;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JTextField;
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
}
