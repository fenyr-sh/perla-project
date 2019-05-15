package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fenyr Shell
 */
public class Rendimiento {
    
    private int id;
    private String puerto_buque;
    private String puerto_muelle;
    private String puerto_producto;
    private double puerto_tonelaje;
    private Date puerto_arribo;
    private double puerto_arribo_hora;
    private Date puerto_desatraque;
    private double puerto_desatraque_hora;
    private Date muelle_atraque;
    private double muelle_atraque_hora;
    private Date operacion_inicio;
    private double operacion_inicio_hora;
    private Date operacion_termino;
    private double operacion_termino_hora;
    private double operacion_demoras;
    private final Connection connection;
    private String table = "rendimientos";
    private final String INSERT = "INSERT INTO " + table 
            + " (id, puerto_buque, puerto_muelle, puerto_producto, puerto_tonelaje, "
            + "puerto_arribo, puerto_arribo_hora, puerto_desatraque, puerto_desatraque_hora, "
            + "muelle_atraque, muelle_atraque_hora, operacion_inicio, "
            + "operacion_inicio_hora, operacion_termino, operacion_termino_hora,"
            + "operacion_demoras) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public Rendimiento(Connection connection) {
        this.connection = connection;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPuerto_buque() {
        return puerto_buque;
    }

    public void setPuerto_buque(String puerto_buque) {
        this.puerto_buque = puerto_buque;
    }

    public String getPuerto_muelle() {
        return puerto_muelle;
    }

    public void setPuerto_muelle(String puerto_muelle) {
        this.puerto_muelle = puerto_muelle;
    }

    public String getPuerto_producto() {
        return puerto_producto;
    }

    public void setPuerto_producto(String puerto_producto) {
        this.puerto_producto = puerto_producto;
    }

    public double getPuerto_tonelaje() {
        return puerto_tonelaje;
    }

    public void setPuerto_tonelaje(double puerto_tonelaje) {
        this.puerto_tonelaje = puerto_tonelaje;
    }

    public Date getPuerto_arribo() {
        return puerto_arribo;
    }

    public void setPuerto_arribo(Date puerto_arribo) {
        this.puerto_arribo = puerto_arribo;
    }

    public double getPuerto_arribo_hora() {
        return puerto_arribo_hora;
    }

    public void setPuerto_arribo_hora(double puerto_arribo_hora) {
        this.puerto_arribo_hora = puerto_arribo_hora;
    }

    public Date getPuerto_desatraque() {
        return puerto_desatraque;
    }

    public void setPuerto_desatraque(Date puerto_desatraque) {
        this.puerto_desatraque = puerto_desatraque;
    }

    public double getPuerto_desatraque_hora() {
        return puerto_desatraque_hora;
    }

    public void setPuerto_desatraque_hora(double puerto_desatraque_hora) {
        this.puerto_desatraque_hora = puerto_desatraque_hora;
    }

    public Date getMuelle_atraque() {
        return muelle_atraque;
    }

    public void setMuelle_atraque(Date muelle_atraque) {
        this.muelle_atraque = muelle_atraque;
    }

    public double getMuelle_atraque_hora() {
        return muelle_atraque_hora;
    }

    public void setMuelle_atraque_hora(double muelle_atraque_hora) {
        this.muelle_atraque_hora = muelle_atraque_hora;
    }

    public Date getOperacion_inicio() {
        return operacion_inicio;
    }

    public void setOperacion_inicio(Date operacion_inicio) {
        this.operacion_inicio = operacion_inicio;
    }

    public double getOperacion_inicio_hora() {
        return operacion_inicio_hora;
    }

    public void setOperacion_inicio_hora(double operacion_inicio_hora) {
        this.operacion_inicio_hora = operacion_inicio_hora;
    }

    public Date getOperacion_termino() {
        return operacion_termino;
    }

    public void setOperacion_termino(Date operacion_termino) {
        this.operacion_termino = operacion_termino;
    }

    public double getOperacion_termino_hora() {
        return operacion_termino_hora;
    }

    public void setOperacion_termino_hora(double operacion_termino_hora) {
        this.operacion_termino_hora = operacion_termino_hora;
    }

    public double getOperacion_demoras() {
        return operacion_demoras;
    }

    public void setOperacion_demoras(double operacion_demoras) {
        this.operacion_demoras = operacion_demoras;
    }
    
    public void save() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT);
        
        ps.setString(1, puerto_buque);
        ps.setString(2, puerto_muelle);
        ps.setString(3, puerto_producto);
        ps.setDouble(4, puerto_tonelaje);
        ps.setDate(5, puerto_arribo);
        ps.setDouble(6, puerto_arribo_hora);
        ps.setDate(7, puerto_desatraque);
        ps.setDouble(8, puerto_desatraque_hora);
        ps.setDate(9, muelle_atraque);
        ps.setDouble(10, muelle_atraque_hora);
        ps.setDate(11, operacion_inicio);
        ps.setDouble(12, operacion_inicio_hora);
        ps.setDate(13, operacion_termino);
        ps.setDouble(14, operacion_termino_hora);
        ps.setDouble(15, operacion_demoras);
        
        ps.executeUpdate();
        
        if (connection != null) {
            connection.close();
        }
    }
    
    
}
