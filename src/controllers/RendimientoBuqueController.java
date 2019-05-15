package controllers;

import java.util.Date;
import views.rendimiento.buque.*;

/**
 *
 * @author Fenyr Shell
 */
public class RendimientoBuqueController {

    public RendimientoBuqueController() {

    }
    
    public void index() {
        Index index =  new Index();
        index.setVisible(true);
    }
    
    public void create() {
//        Create create =  new Create();
//        create.setVisible(true);
    }
    
    public void show(String puertoBuque, String puertoMuelle, String puertoProducto,
            double puertoTonelaje, Date puertoArribo, double puertoArriboHora,
            Date puertoDesatraque, double puertoDesatraqueHora, Date muelleAtraque,
            double muelleAtraqueHora, Date operacionInicio, double operacionInicioHora,
            Date operacionTermino, double operacionTerminoHora, double operacionDemoras) {
        
        Show show =  new Show();
        show.setData(puertoBuque, puertoMuelle, puertoProducto, puertoTonelaje,
                puertoArribo, puertoArriboHora, puertoDesatraque, puertoDesatraqueHora,
                muelleAtraque, muelleAtraqueHora, operacionInicio, 
                operacionInicioHora, operacionTermino, operacionTerminoHora, operacionDemoras);
        
        show.setVisible(true);
    }
}
