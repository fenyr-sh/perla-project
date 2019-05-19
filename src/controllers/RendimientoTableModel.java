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
            case 1: return "PUERTO BUQUE";
            case 2: return "PUERTO MUELLE";
            case 3: return "PUERTO PRODUCTO";
            case 4: return "PUERTO TONELAJE";
            
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
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
            
            default: return "[no]";
        }
    }
    
    
}
