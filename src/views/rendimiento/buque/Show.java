package views.rendimiento.buque;

import controllers.Util;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Fenyr Shell
 */
public class Show extends javax.swing.JFrame {

    /**
     * Creates new form Preview
     */
    public Show() {
        initComponents();
    }
    
    public void setData(String puertoBuque, String puertoMuelle, String puertoCarga, String puertoProducto,
            double puertoTonelaje, Date puertoArribo, double puertoArriboHora,
            Date puertoDesatraque, double puertoDesatraqueHora, Date puertoZarpe, double puertoZarpeHora, Date muelleAtraque,
            double muelleAtraqueHora, Date operacionInicio, double operacionInicioHora,
            Date operacionTermino, double operacionTerminoHora, double operacionDemoras) {
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        double puerto_arribo = Util.numberDate(puertoArribo, puertoArriboHora);
        double puerto_desatraque = Util.numberDate(puertoDesatraque, puertoDesatraqueHora);
        double puerto_zarpe = Util.numberDate(puertoZarpe, puertoZarpeHora) - puerto_desatraque;
        double puerto_tiempo = (puerto_desatraque - puerto_arribo) + puerto_zarpe;
        double puerto_rendimiento = puertoTonelaje/puerto_tiempo;
        
        double muelle_atraque = Util.numberDate(muelleAtraque, muelleAtraqueHora);
        double muelle_tiempo = (puerto_desatraque - muelle_atraque);
        double muelle_rendimiento = puertoTonelaje/muelle_tiempo;
        
        double operacion_inicio = Util.numberDate(operacionInicio, operacionInicioHora);
        double operacion_termino = Util.numberDate(operacionTermino, operacionTerminoHora);
        double operacion_tiempo = (operacion_termino - operacion_inicio) - operacionDemoras;
        double operacion_rendimiento = puertoTonelaje/operacion_tiempo;
        
        txtPuertoBuque.setText(puertoBuque);
        txtPuertoMuelle.setText(puertoMuelle);
        txtPuertoProducto.setText(puertoProducto);
        txtPuertoTonelaje.setText(puertoTonelaje + "");
        txtPuertoZarpe.setText(df.format(puerto_zarpe));
        txtPuertoArribo.setText((int) Math.round(puerto_arribo) + "");
        txtPuertoDesatraque.setText((int) Math.round(puerto_desatraque) + "");
        txtPuertoTiempo.setText((int) Math.round(puerto_tiempo) + "");
        txtPuertoRendimiento.setText((int) Math.round(puerto_rendimiento) + "");
        
        txtMuelleAtraque.setText((int) Math.round(muelle_atraque) + "");
        txtMuelleDesatraque.setText((int) Math.round(puerto_desatraque) + "");
        txtMuelleTiempo.setText((int) Math.round(muelle_tiempo) + "");
        txtMuelleRendimiento.setText((int) Math.round(muelle_rendimiento) + "");
        
        txtOperacionInicio.setText((int) Math.round(operacion_inicio) + "");
        txtOperacionTermino.setText((int) Math.round(operacion_termino) + "");
        txtOperacionTiempo.setText((int) Math.round(operacion_tiempo) + "");
        txtOperacionDemoras.setText(operacionDemoras + "");
        txtOperacionRendimiento.setText((int) Math.round(operacion_rendimiento) + "");
        
        txtPuertoArribo.setToolTipText(puertoArribo + "");
        txtPuertoDesatraque.setToolTipText(puertoDesatraque.toString());
        txtMuelleAtraque.setToolTipText(muelleAtraque.toString());
        txtMuelleDesatraque.setToolTipText(puertoDesatraque.toString());
        txtOperacionInicio.setToolTipText(operacionInicio.toString());
        txtOperacionTermino.setToolTipText(operacionTermino.toString());
        txtPuertoRendimiento.setToolTipText(puerto_rendimiento + "");
        txtMuelleRendimiento.setToolTipText(muelle_rendimiento + "");
        txtOperacionRendimiento.setToolTipText(operacion_rendimiento + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPuertoBuque = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPuertoMuelle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPuertoProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPuertoTonelaje = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPuertoArribo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPuertoDesatraque = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPuertoZarpe = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPuertoTiempo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPuertoRendimiento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMuelleAtraque = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMuelleDesatraque = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMuelleTiempo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtMuelleRendimiento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtOperacionInicio = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtOperacionTermino = new javax.swing.JTextField();
        txtOperacionRendimiento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtOperacionTiempo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtOperacionDemoras = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preview");
        setResizable(false);

        jLabel1.setText("Buque:");

        txtPuertoBuque.setEditable(false);

        jLabel2.setText("Muelle:");

        txtPuertoMuelle.setEditable(false);

        jLabel3.setText("Producto:");

        txtPuertoProducto.setEditable(false);

        jLabel4.setText("Tonelaje:");

        txtPuertoTonelaje.setEditable(false);

        jLabel5.setText("Arribo:");

        txtPuertoArribo.setEditable(false);

        jLabel6.setText("Desatraque:");

        txtPuertoDesatraque.setEditable(false);

        jLabel7.setText("Hora de zarpe:");

        txtPuertoZarpe.setEditable(false);

        jLabel8.setText("Tiempo:");

        txtPuertoTiempo.setEditable(false);

        jLabel9.setText("Rendimiento:");

        txtPuertoRendimiento.setEditable(false);

        jLabel11.setText("Atraque:");

        txtMuelleAtraque.setEditable(false);

        jLabel12.setText("Desatraque:");

        txtMuelleDesatraque.setEditable(false);

        jLabel10.setText("Buque en Puerto");

        jLabel13.setText("Buque en Muelle");

        jLabel17.setText("Tiempo:");

        txtMuelleTiempo.setEditable(false);

        jLabel18.setText("Rendimiento:");

        txtMuelleRendimiento.setEditable(false);

        jLabel14.setText("Buque en Operación");

        jLabel15.setText("Inic. Operación:");

        txtOperacionInicio.setEditable(false);

        jLabel16.setText("Term. Operación:");

        txtOperacionTermino.setEditable(false);

        txtOperacionRendimiento.setEditable(false);

        jLabel19.setText("Rendimiento:");

        jLabel20.setText("Tiempo:");

        txtOperacionTiempo.setEditable(false);

        jLabel21.setText("Demoras:");

        txtOperacionDemoras.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPuertoProducto)
                                    .addComponent(txtPuertoArribo)
                                    .addComponent(txtPuertoZarpe)
                                    .addComponent(txtPuertoBuque))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPuertoMuelle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPuertoTonelaje, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPuertoDesatraque, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPuertoTiempo, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(txtPuertoRendimiento)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMuelleAtraque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMuelleDesatraque))
                            .addComponent(txtMuelleTiempo)
                            .addComponent(txtMuelleRendimiento)
                            .addComponent(txtOperacionRendimiento)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtOperacionTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(txtOperacionInicio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOperacionDemoras, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(txtOperacionTermino)))))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPuertoBuque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPuertoMuelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPuertoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPuertoTonelaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPuertoArribo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPuertoDesatraque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPuertoZarpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtPuertoTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPuertoRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMuelleAtraque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtMuelleDesatraque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtMuelleTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMuelleRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtOperacionInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtOperacionTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtOperacionTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtOperacionDemoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtOperacionRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMuelleAtraque;
    private javax.swing.JTextField txtMuelleDesatraque;
    private javax.swing.JTextField txtMuelleRendimiento;
    private javax.swing.JTextField txtMuelleTiempo;
    private javax.swing.JTextField txtOperacionDemoras;
    private javax.swing.JTextField txtOperacionInicio;
    private javax.swing.JTextField txtOperacionRendimiento;
    private javax.swing.JTextField txtOperacionTermino;
    private javax.swing.JTextField txtOperacionTiempo;
    private javax.swing.JTextField txtPuertoArribo;
    private javax.swing.JTextField txtPuertoBuque;
    private javax.swing.JTextField txtPuertoDesatraque;
    private javax.swing.JTextField txtPuertoMuelle;
    private javax.swing.JTextField txtPuertoProducto;
    private javax.swing.JTextField txtPuertoRendimiento;
    private javax.swing.JTextField txtPuertoTiempo;
    private javax.swing.JTextField txtPuertoTonelaje;
    private javax.swing.JTextField txtPuertoZarpe;
    // End of variables declaration//GEN-END:variables
}
