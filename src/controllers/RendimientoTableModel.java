package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Rendimiento;
import models.dao.DAOException;
import models.dao.RendimientoDAO;

/**
 *
 * @author Fenyr Shell
 */
public class RendimientoTableModel extends AbstractTableModel {
    
    private final RendimientoDAO rendimiento;
    private List<Rendimiento> datos = new ArrayList<>();

    public RendimientoTableModel(RendimientoDAO rendimiento) {
        this.rendimiento = rendimiento;
    }
    
    public void updateModel() throws DAOException {
        datos = rendimiento.getAll();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "BUQUE";
            case 2: return "MUELLE";
            case 3: return "PRODUCTO";
            case 4: return "TONELAJE";
            case 5: return "ARRIBO";
            case 6: return "ARRIBO HORA";
            case 7: return "DESATRAQUE";
            case 8: return "DESATRAQUE HORA";
            case 9: return "ZARPE";
            case 10: return "MUELLE ATRAQUE";
            case 11: return "PUERTO ARRIBO HORA";
            case 12: return "OPERACION INICIO";
            case 13: return "OPERACION INICIO HORA";
            case 14: return "OPERACION TERMINO";
            case 15: return "OPERACION TERMINO HORA";
            case 16: return "OPERACION DEMORAS";
            
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rendimiento r = datos.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return r.getId();
            case 1: return r.getPuerto_buque();
            case 2: return r.getPuerto_muelle();
            case 3: return r.getPuerto_producto();
            case 4: return r.getPuerto_tonelaje();
            case 5: return r.getPuerto_arribo();
            case 6: return r.getPuerto_arribo_hora();
            case 7: return r.getPuerto_desatraque();
            case 8: return r.getPuerto_desatraque_hora();
            case 9: return r.getPuerto_zarpe();
            case 10: return r.getMuelle_atraque();
            case 11: return r.getMuelle_atraque_hora();
            case 12: return r.getOperacion_inicio();
            case 13: return r.getOperacion_inicio_hora();
            case 14: return r.getOperacion_termino();
            case 15: return r.getOperacion_termino_hora();
            case 16: return r.getOperacion_demoras();
                        
            default: return "[no]";
        }
    }
    
    
}
