package models.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import models.Rendimiento;
import models.dao.DAOException;
import models.dao.RendimientoDAO;

/**
 *
 * @author Fenyr Shell
 */
public class MySQLRendimientoDAO implements RendimientoDAO {
    
    private final Connection conn;
    private final String TABLE = "rendimientos";
    private final String INSERT = "INSERT INTO " + TABLE + "(puerto_buque, puerto_muelle, puerto_carga, puerto_producto, puerto_tonelaje, puerto_arribo, puerto_arribo_hora, puerto_desatraque, puerto_desatraque_hora, puerto_zarpe, puerto_zarpe_hora, muelle_atraque, muelle_atraque_hora, operacion_inicio, operacion_inicio_hora, operacion_termino, operacion_termino_hora, operacion_demoras) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE " + TABLE + " SET puerto_buque = ?, puerto_muelle = ?, puerto_carga = ?, puerto_producto = ?, puerto_tonelaje = ?, puerto_arribo = ?, puerto_arribo_hora = ?, puerto_desatraque = ?, puerto_desatraque_hora = ?, puerto_zarpe = ?, puerto_zarpe_hora = ?, muelle_atraque = ?, muelle_atraque_hora = ?, operacion_inicio = ?, operacion_inicio_hora = ?, operacion_termino = ?, operacion_termino_hora = ?, operacion_demoras = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM " + TABLE + " WHERE id = ?";
    private final String GETALL = "SELECT * FROM " + TABLE + " ORDER BY id DESC LIMIT 1, 5";
    private final String GETONE = "SELECT * FROM " + TABLE + " WHERE id = ?";
    private final String GETBY = "SELECT * FROM " + TABLE + " WHERE puerto_buque LIKE ? OR puerto_carga LIKE ? OR puerto_producto LIKE ? AND puerto_arribo BETWEEN ? AND ?";
    
    public MySQLRendimientoDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void validate(Rendimiento r) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String arribo = df.format(r.getPuerto_arribo());
            
        try {
            ps = conn.prepareStatement("SELECT * FROM " + TABLE + " WHERE puerto_buque = ? AND puerto_arribo = ?");
            ps.setString(1, r.getPuerto_buque());
            ps.setString(2, arribo);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                throw new DAOException("Registro duplicado");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void save(Rendimiento r) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs =  null;
        try {
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, r.getPuerto_buque());
            ps.setString(2, r.getPuerto_muelle());
            ps.setString(3, r.getPuerto_carga());
            ps.setString(4, r.getPuerto_producto());
            ps.setDouble(5, r.getPuerto_tonelaje());
            ps.setDate(6, new Date(r.getPuerto_arribo().getTime()));
            ps.setDouble(7, r.getPuerto_arribo_hora());
            ps.setDate(8, new Date(r.getPuerto_desatraque().getTime()));
            ps.setDouble(9, r.getPuerto_desatraque_hora());
            ps.setDate(10, new Date(r.getPuerto_zarpe().getTime()));
            ps.setDouble(11, r.getPuerto_zarpe_hora());
            ps.setDate(12, new Date(r.getMuelle_atraque().getTime()));
            ps.setDouble(13, r.getMuelle_atraque_hora());
            ps.setDate(14, new Date(r.getOperacion_inicio().getTime()));
            ps.setDouble(15, r.getOperacion_inicio_hora());
            ps.setDate(16, new Date(r.getOperacion_termino().getTime()));
            ps.setDouble(17, r.getOperacion_termino_hora());
            ps.setDouble(18, r.getOperacion_demoras());
            
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya guardado!!!");
            }

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                r.setId(rs.getLong(1));
            }else {
                throw new DAOException("No puedo asignar ID es este rendimiento!!!");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void update(Rendimiento r) throws DAOException {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(UPDATE);
            
            ps.setString(1, r.getPuerto_buque());
            ps.setString(2, r.getPuerto_muelle());
            ps.setString(3, r.getPuerto_carga());
            ps.setString(4, r.getPuerto_producto());
            ps.setDouble(5, r.getPuerto_tonelaje());
            ps.setDate(6, new Date(r.getPuerto_arribo().getTime()));
            ps.setDouble(7, r.getPuerto_arribo_hora());
            ps.setDate(8, new Date(r.getPuerto_desatraque().getTime()));
            ps.setDouble(9, r.getPuerto_desatraque_hora());
            ps.setDate(10, new Date(r.getPuerto_zarpe().getTime()));
            ps.setDouble(11, r.getPuerto_zarpe_hora());
            ps.setDate(12, new Date(r.getMuelle_atraque().getTime()));
            ps.setDouble(13, r.getMuelle_atraque_hora());
            ps.setDate(14, new Date(r.getOperacion_inicio().getTime()));
            ps.setDouble(15, r.getOperacion_inicio_hora());
            ps.setDate(16, new Date(r.getOperacion_termino().getTime()));
            ps.setDouble(17, r.getOperacion_termino_hora());
            ps.setDouble(18, r.getOperacion_demoras());
            ps.setLong(19, r.getId());
            
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya modificado el modelo!!!");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void delete(Rendimiento r) throws DAOException {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, r.getId());
            
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Puede que el alumno no se haya borrado!!!");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }
    
    private Rendimiento convert(ResultSet rs) throws SQLException {
        String puerto_buque = rs.getString("puerto_buque");
        String puerto_muelle = rs.getString("puerto_muelle");
        String puerto_carga = rs.getString("puerto_carga");
        String puerto_producto = rs.getString("puerto_producto");
        double puerto_tonelaje = rs.getDouble("puerto_tonelaje");
        Date puerto_arribo = rs.getDate("puerto_arribo", Calendar.getInstance());
        double puerto_arribo_hora = rs.getDouble("puerto_arribo_hora");
        Date puerto_desatraque = rs.getDate("puerto_desatraque", Calendar.getInstance());
        double puerto_desatraque_hora = rs.getDouble("puerto_desatraque_hora");
        Date puerto_zarpe = rs.getDate("puerto_zarpe");
        double puerto_zarpe_hora = rs.getDouble("puerto_zarpe_hora");
        Date muelle_atraque = rs.getDate("muelle_atraque", Calendar.getInstance());
        double muelle_atraque_hora = rs.getDouble("muelle_atraque_hora");
        Date operacion_inicio = rs.getDate("operacion_inicio", Calendar.getInstance());
        double operacion_inicio_hora = rs.getDouble("operacion_inicio_hora");
        Date operacion_termino = rs.getDate("operacion_termino", Calendar.getInstance());
        double operacion_termino_hora = rs.getDouble("operacion_termino_hora");
        double operacion_demoras = rs.getDouble("operacion_demoras");
        Rendimiento rendimiento = new Rendimiento(puerto_buque, puerto_muelle, puerto_carga, puerto_producto, puerto_tonelaje, puerto_arribo, puerto_arribo_hora, puerto_desatraque, puerto_desatraque_hora, puerto_zarpe, puerto_zarpe_hora, muelle_atraque, muelle_atraque_hora, operacion_inicio, operacion_inicio_hora, operacion_termino, operacion_termino_hora, operacion_demoras);
        rendimiento.setId(rs.getLong("id"));
        
        return rendimiento;
    }

    @Override
    public List<Rendimiento> getAll() throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Rendimiento> rendimiento = new ArrayList<>();
            
        try {
            ps = conn.prepareStatement(GETALL);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                rendimiento.add(convert(rs));
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        
        return rendimiento;
    }

    @Override
    public Rendimiento get(Long id) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rendimiento rendimiento = null;
            
        try {
            ps = conn.prepareStatement(GETONE);
            ps.setLong(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                rendimiento = convert(rs);
            }else {
                throw new DAOException("No se ha encontrado ese registro!!!");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        
        return rendimiento;
    }
    
    @Override
    public List<Rendimiento> getBy(String buque, String carga, String producto, String arribo_inicio, String arribo_fin) throws DAOException {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Rendimiento> rendimiento = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement(GETBY);
            ps.setString(1, "%" + buque + "%");
            ps.setString(2, "%" + carga + "%");
            ps.setString(3, "%" + producto + "%");
            ps.setString(4, "'" + arribo_inicio + "'");
            ps.setString(5, "'" + arribo_fin + "'");
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                rendimiento.add(convert(rs));
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
            
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        
        return rendimiento;
    }
}
