package controllers;

import database.DatabaseConfiguration;
import database.DatabaseConnection;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import views.rendimiento.buque.*;

/**
 *
 * @author Fenyr Shell
 */
public class RendimientoBuqueController {
    
    private Statement stmt = null;
    private ResultSet rs = null;
    private final DatabaseConnection db_conn;

    public RendimientoBuqueController() {
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

        db_conn = new DatabaseConnection(db_config);
    }
    
    public void index() {
        Index index =  new Index();
        index.setVisible(true);
    }
    
    public void create() {
        Create create =  new Create();
        create.setVisible(true);
    }
    
    public void show(String puertoBuque, String puertoMuelle, String puertoProducto,
            double puertoTonelaje, Date puertoArribo, double puertoArriboHora,
            Date puertoDesatraque, double puertoDesatraqueHora, double puertoZarpe, Date muelleAtraque,
            double muelleAtraqueHora, Date operacionInicio, double operacionInicioHora,
            Date operacionTermino, double operacionTerminoHora, double operacionDemoras) {
        
        Show show =  new Show();
        show.setData(puertoBuque, puertoMuelle, puertoProducto, puertoTonelaje,
                puertoArribo, puertoArriboHora, puertoDesatraque, puertoDesatraqueHora,
                puertoZarpe, muelleAtraque, muelleAtraqueHora, operacionInicio, 
                operacionInicioHora, operacionTermino, operacionTerminoHora, operacionDemoras);
        
        show.setVisible(true);
    }
}
