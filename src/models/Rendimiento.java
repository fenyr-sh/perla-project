package models;

import java.util.Date;

/**
 *
 * @author Fenyr Shell
 */
public class Rendimiento {
    
    private Long id = null;
    private String puerto_buque;
    private String puerto_muelle;
    private String puerto_producto;
    private double puerto_tonelaje;
    private Date puerto_arribo;
    private double puerto_arribo_hora;
    private Date puerto_desatraque;
    private double puerto_desatraque_hora;
    private double puerto_zarpe;
    private Date muelle_atraque;
    private double muelle_atraque_hora;
    private Date operacion_inicio;
    private double operacion_inicio_hora;
    private Date operacion_termino;
    private double operacion_termino_hora;
    private double operacion_demoras;

    public Rendimiento(String puerto_buque, String puerto_muelle, String puerto_producto, double puerto_tonelaje, Date puerto_arribo, double puerto_arribo_hora, Date puerto_desatraque, double puerto_desatraque_hora, double puerto_zarpe, Date muelle_atraque, double muelle_atraque_hora, Date operacion_inicio, double operacion_inicio_hora, Date operacion_termino, double operacion_termino_hora, double operacion_demoras) {
        this.puerto_buque = puerto_buque;
        this.puerto_muelle = puerto_muelle;
        this.puerto_producto = puerto_producto;
        this.puerto_tonelaje = puerto_tonelaje;
        this.puerto_arribo = puerto_arribo;
        this.puerto_arribo_hora = puerto_arribo_hora;
        this.puerto_desatraque = puerto_desatraque;
        this.puerto_desatraque_hora = puerto_desatraque_hora;
        this.puerto_zarpe = puerto_zarpe;
        this.muelle_atraque = muelle_atraque;
        this.muelle_atraque_hora = muelle_atraque_hora;
        this.operacion_inicio = operacion_inicio;
        this.operacion_inicio_hora = operacion_inicio_hora;
        this.operacion_termino = operacion_termino;
        this.operacion_termino_hora = operacion_termino_hora;
        this.operacion_demoras = operacion_demoras;
    }

    public Rendimiento() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPuerto_zarpe() {
        return puerto_zarpe;
    }

    public void setPuerto_zarpe(double puerto_zarpe) {
        this.puerto_zarpe = puerto_zarpe;
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

}
