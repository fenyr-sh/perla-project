package models.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private final String INSERT = "INSERT INTO rendimientos(puerto_buque, puerto_muelle, puerto_producto, puerto_tonelaje, puerto_arribo, puerto_arribo_hora, puerto_desatraque, puerto_desatraque_hora, puerto_zarpe, muelle_atraque, muelle_atraque_hora, operacion_inicio, operacion_inicio_hora, operacion_termino, operacion_termino_hora, operacion_demoras) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE rendimientos SET puerto_buque = ?, puerto_muelle = ?, puerto_producto = ?, puerto_tonelaje = ?, puerto_arribo = ?, puerto_arribo_hora = ?, puerto_desatraque = ?, puerto_desatraque_hora = ?, puerto_zarpe = ?, muelle_atraque = ?, muelle_atraque_hora = ?, operacion_inicio = ?, operacion_inicio_hora = ?, operacion_termino = ?, operacion_termino_hora = ?, operacion_demoras = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM rendimientos WHERE id = ?";
    private final String GETALL = "SELECT * FROM rendimientos";
    private final String GETONE = "SELECT * FROM rendimientos WHERE id = ?";
    
    public MySQLRendimientoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Rendimiento r) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs =  null;
        try {
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, r.getPuerto_buque());
            ps.setString(2, r.getPuerto_muelle());
            ps.setString(3, r.getPuerto_producto());
            ps.setDouble(4, r.getPuerto_tonelaje());
            ps.setDate(5, new Date(r.getPuerto_arribo().getTime()));
            ps.setDouble(6, r.getPuerto_arribo_hora());
            ps.setDate(7, new Date(r.getPuerto_desatraque().getTime()));
            ps.setDouble(8, r.getPuerto_desatraque_hora());
            ps.setDouble(9, r.getPuerto_zarpe());
            ps.setDate(10, new Date(r.getMuelle_atraque().getTime()));
            ps.setDouble(11, r.getMuelle_atraque_hora());
            ps.setDate(12, new Date(r.getOperacion_inicio().getTime()));
            ps.setDouble(13, r.getOperacion_inicio_hora());
            ps.setDate(14, new Date(r.getOperacion_termino().getTime()));
            ps.setDouble(15, r.getOperacion_termino_hora());
            ps.setDouble(16, r.getOperacion_demoras());
            
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
            ps.setString(3, r.getPuerto_producto());
            ps.setDouble(4, r.getPuerto_tonelaje());
            ps.setDate(5, new Date(r.getPuerto_arribo().getTime()));
            ps.setDouble(6, r.getPuerto_arribo_hora());
            ps.setDate(7, new Date(r.getPuerto_desatraque().getTime()));
            ps.setDouble(8, r.getPuerto_desatraque_hora());
            ps.setDouble(9, r.getPuerto_zarpe());
            ps.setDate(10, new Date(r.getMuelle_atraque().getTime()));
            ps.setDouble(11, r.getMuelle_atraque_hora());
            ps.setDate(12, new Date(r.getOperacion_inicio().getTime()));
            ps.setDouble(13, r.getOperacion_inicio_hora());
            ps.setDate(14, new Date(r.getOperacion_termino().getTime()));
            ps.setDouble(15, r.getOperacion_termino_hora());
            ps.setDouble(16, r.getOperacion_demoras());
            ps.setLong(17, r.getId());
            
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
        String puerto_producto = rs.getString("puerto_producto");
        double puerto_tonelaje = rs.getDouble("puerto_tonelaje");
        Date puerto_arribo = rs.getDate("puerto_arribo");
        double puerto_arribo_hora = rs.getDouble("puerto_arribo_hora");
        Date puerto_desatraque = rs.getDate("puerto_desatraque");
        double puerto_desatraque_hora = rs.getDouble("puerto_desatraque_hora");
        double puerto_zarpe = rs.getDouble("puerto_zarpe");
        Date muelle_atraque = rs.getDate("muelle_atraque");
        double muelle_atraque_hora = rs.getDouble("muelle_atraque_hora");
        Date operacion_inicio = rs.getDate("operacion_inicio");
        double operacion_inicio_hora = rs.getDouble("operacion_inicio_hora");
        Date operacion_termino = rs.getDate("operacion_termino");
        double operacion_termino_hora = rs.getDouble("operacion_termino_hora");
        double operacion_demoras = rs.getDouble("operacion_demoras");
        
        Rendimiento rendimiento = new Rendimiento(puerto_buque, puerto_muelle, puerto_producto, puerto_tonelaje, puerto_arribo, puerto_arribo_hora, puerto_desatraque, puerto_desatraque_hora, puerto_zarpe, muelle_atraque, muelle_atraque_hora, operacion_inicio, operacion_inicio_hora, operacion_termino, operacion_termino_hora, operacion_demoras);
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

}
