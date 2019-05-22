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
    
    public void findByBuque(String buque, String carga, String producto, String date1, String date2) throws DAOException {
        datos = rendimiento.getBy(buque, carga, producto, date1, date2);
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "BUQUE";
            case 2: return "MUELLE";
            case 3: return "TIPO DE CARGA";
            case 4: return "PRODUCTO";
            case 5: return "TONELAJE";
            case 6: return "FECHA ARRIBO";
            case 7: return "FECHA ATRAQUE";
            case 8: return "FECHA DESATRAQUE";
            case 9: return "FECHA ZARPE";
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
            case 3: return r.getPuerto_carga();
            case 4: return r.getPuerto_producto();
            case 5: return r.getPuerto_tonelaje();
            case 6: return r.getPuerto_arribo();
            case 7: return r.getMuelle_atraque();
            case 8: return r.getPuerto_desatraque();
            case 9: return r.getPuerto_zarpe();
                        
            default: return "[no]";
        }
    }
    
    
}
