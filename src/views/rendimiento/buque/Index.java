package views.rendimiento.buque;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import controllers.RendimientoTableModel;
import controllers.Util;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableColumnModel;
import models.Rendimiento;
import models.dao.DAOException;
import models.dao.DAOManager;

/**
 *
 * @author Fenyr Shell
 */
public class Index extends javax.swing.JFrame {

    private RendimientoTableModel model;
    private final DAOManager manager;
    public static Integer limit = 25;
    private final Color defaultTableForeground;
    private final Color defaultTableBackground;

    /**
     * Creates new form Index
     *
     * @param manager
     * @throws models.dao.DAOException
     */
    public Index(DAOManager manager) throws DAOException {
        initComponents();
        setLookAndFeel("nimbus");
        mnTema.setVisible(false);
        this.manager = manager;
        this.model = new RendimientoTableModel(manager.getRendimientoDAO());
        this.model.updateModel(limit);
        this.table.setModel(model);
        defaultTableBackground = table.getBackground();
        defaultTableForeground = table.getForeground();
        setColumWidth();

        mnEliminar.setEnabled(false);
        mnEditar.setEnabled(false);
        mnVer.setEnabled(false);
        mnGenerar.setEnabled(false);

        this.table.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (table.getSelectedRow() != -1);

            mnEliminar.setEnabled(seleccionValida);
            mnEditar.setEnabled(seleccionValida);
            mnVer.setEnabled(seleccionValida);
            mnGenerar.setEnabled(seleccionValida);

        });

//        PlaceHolder ph = new PlaceHolder(txtBuscarBuque, "Buque");
//        PlaceHolder ph2 = new PlaceHolder(txtBuscarCarga, "Tipo de Carga");
//        PlaceHolder ph3 = new PlaceHolder(txtBuscarProducto, "Producto");   
        dateArribo.setCalendar(Calendar.getInstance());
        dateDesatraque.setCalendar(Calendar.getInstance());

    }

    private void setColumWidth() {

        TableColumnModel column = table.getColumnModel();
        column.getColumn(0).setPreferredWidth(20);
        column.getColumn(1).setPreferredWidth(60);
        column.getColumn(2).setPreferredWidth(30);
        column.getColumn(3).setPreferredWidth(100);
        column.getColumn(4).setPreferredWidth(80);
        column.getColumn(5).setPreferredWidth(40);
        column.getColumn(6).setPreferredWidth(80);
        column.getColumn(7).setPreferredWidth(80);
        column.getColumn(8).setPreferredWidth(100);
        column.getColumn(9).setPreferredWidth(80);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        root = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        txtBuscarCarga = new javax.swing.JTextField();
        txtBuscarBuque = new javax.swing.JTextField();
        dateDesatraque = new com.toedter.calendar.JDateChooser();
        dateArribo = new com.toedter.calendar.JDateChooser();
        cbxRegistros = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnAgregar = new javax.swing.JMenuItem();
        mnEditar = new javax.swing.JMenuItem();
        mnEliminar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnVer = new javax.swing.JMenuItem();
        mnGenerar = new javax.swing.JMenuItem();
        mnTema = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RENDIMIENTOS");
        setMinimumSize(new java.awt.Dimension(1000, 500));

        jScrollPane1.setBorder(null);

        root.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rootMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RENDIMIENTOS DE PRODUCTIVIDAD DE BUQUE ");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        cbxRegistros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "25", "50", "100", "250", "500" }));
        cbxRegistros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRegistrosItemStateChanged(evt);
            }
        });

        jLabel2.setText("Registros:");

        jLabel3.setText("Arribo:");

        jLabel4.setText("Desatraque:");

        jLabel5.setText("Buque:");

        jLabel6.setText("Tipo carga:");

        jLabel7.setText("Producto:");

        javax.swing.GroupLayout rootLayout = new javax.swing.GroupLayout(root);
        root.setLayout(rootLayout);
        rootLayout.setHorizontalGroup(
            rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(rootLayout.createSequentialGroup()
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxRegistros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRefrescar)
                        .addGap(18, 18, 18)
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateArribo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateDesatraque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarBuque)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarCarga)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscarProducto))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        rootLayout.setVerticalGroup(
            rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarBuque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateDesatraque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateArribo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(root);

        jMenu1.setText("Rendimiento");

        mnAgregar.setText("Agregar");
        mnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAgregarActionPerformed(evt);
            }
        });
        jMenu1.add(mnAgregar);

        mnEditar.setText("Editar");
        mnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEditarActionPerformed(evt);
            }
        });
        jMenu1.add(mnEditar);

        mnEliminar.setText("Eliminar");
        mnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEliminarActionPerformed(evt);
            }
        });
        jMenu1.add(mnEliminar);
        jMenu1.add(jSeparator1);

        mnVer.setText("Ver");
        mnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVerActionPerformed(evt);
            }
        });
        jMenu1.add(mnVer);

        mnGenerar.setText("Generar");
        mnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGenerarActionPerformed(evt);
            }
        });
        jMenu1.add(mnGenerar);

        jMenuBar1.add(jMenu1);

        mnTema.setText("Tema");

        jMenuItem1.setText("Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnTema.add(jMenuItem1);

        jMenuItem2.setText("Nimbus");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnTema.add(jMenuItem2);

        jMenuItem3.setText("Metal");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnTema.add(jMenuItem3);

        jMenuItem4.setText("Motif");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnTema.add(jMenuItem4);

        jMenuBar1.add(mnTema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            String buque = txtBuscarBuque.getText();
            String carga = txtBuscarCarga.getText();
            String producto = txtBuscarProducto.getText();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = df.format(dateArribo.getDate());
            String date2 = df.format(dateDesatraque.getDate());

            model.findByBuque(buque, carga, producto, date1, date2, limit);
            model.fireTableDataChanged();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error en SQL", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Verifica que la fecha de arribo y desatraque son correctas.", "Error en fecha", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void update() {
        try {
            model.updateModel(limit);
            model.fireTableDataChanged();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error en SQL", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Rendimiento getRendimientoSeleccionado() throws DAOException {
        Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);

        return manager.getRendimientoDAO().get(id);
    }

    private void agregar() {
        new Create(manager, model).setVisible(true);
    }

    private void editar() {
        try {
            Edit edit = new Edit(manager, model, getRendimientoSeleccionado());
            edit.setVisible(true);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error en SQL", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void eliminar() {
        Rendimiento rendimiento;

        try {
            rendimiento = getRendimientoSeleccionado();
            if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres borrar este rendimiento?" + "\nID = " + rendimiento.getId() + ", BUQUE = " + rendimiento.getPuerto_buque(),
                    "Borrar rendimiento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                manager.getRendimientoDAO().delete(rendimiento);

                model.updateModel(limit);
                model.fireTableDataChanged();
            }
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error en SQL", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void generarPDF(Rendimiento r) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        
        double puerto_arribo = Util.numberDate(r.getPuerto_arribo(), r.getPuerto_arribo_hora());
        double puerto_desatraque = Util.numberDate(r.getPuerto_desatraque(), r.getPuerto_desatraque_hora());
        double puerto_zarpe = Util.numberDate(r.getPuerto_zarpe(), r.getPuerto_zarpe_hora()) - puerto_desatraque;
        double puerto_tiempo = (puerto_desatraque - puerto_arribo) + puerto_zarpe;
        double puerto_rendimiento = r.getPuerto_tonelaje()/puerto_tiempo;
        
        double muelle_atraque = Util.numberDate(r.getMuelle_atraque(), r.getMuelle_atraque_hora());
        double muelle_tiempo = (puerto_desatraque - muelle_atraque);
        double muelle_rendimiento = r.getPuerto_tonelaje()/muelle_tiempo;
        
        double operacion_inicio = Util.numberDate(r.getOperacion_inicio(), r.getOperacion_inicio_hora());
        double operacion_termino = Util.numberDate(r.getOperacion_termino(), r.getOperacion_termino_hora());
        double operacion_tiempo = (operacion_termino - operacion_inicio) - r.getOperacion_demoras();
        double operacion_rendimiento = r.getPuerto_tonelaje()/operacion_tiempo;
        
        Document document = new Document();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Image img = Image.getInstance(getClass().getClassLoader().getResource("images/logo1.png"));
        Image img2 = Image.getInstance(getClass().getClassLoader().getResource("images/logo2.png"));
                
        PdfWriter.getInstance(document, new FileOutputStream("Rendimiento_" + r.getPuerto_buque() + "_" + df.format(r.getPuerto_arribo()) + ".pdf"));
        
        document.open();
        
        img.setAlignment(Image.ALIGN_LEFT);
        img2.setAbsolutePosition(380, 705);
        
        img.scaleAbsolute(200, 70);
        img2.scaleAbsolute(120, 120);
        
        document.add(img);
        document.add(img2);
        
        PdfPTable pdfTable = new PdfPTable(6);

        Font font =  new Font();
        font.setSize(10);

        PdfPCell encabezado = new PdfPCell(new Paragraph("RENDIMIENTOS DE PRODUCTIVIDAD DE BUQUE", font));
        encabezado.setColspan(6);
        encabezado.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pdfTable.addCell(encabezado);

        PdfPCell buque = new PdfPCell(new Paragraph("Buque: " + r.getPuerto_buque(), font));
        buque.setColspan(4);
        pdfTable.addCell(buque);

        PdfPCell muelle = new PdfPCell(new Paragraph("Muelle: " + r.getPuerto_muelle(), font));
        muelle.setColspan(2);
        pdfTable.addCell(muelle);

        pdfTable.addCell(new PdfPCell(new Paragraph("Arribo:", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph("Atraque:", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph("Inicio de operación:", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph("Termino de operación:", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph("Desatraque:", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph("Hora de zarpe:", font)));

        pdfTable.addCell(new PdfPCell(new Paragraph(df.format(r.getPuerto_arribo()), font)));
        pdfTable.addCell(new PdfPCell(new Paragraph(df.format(r.getMuelle_atraque()), font)));
        pdfTable.addCell(new PdfPCell(new Paragraph(df.format(r.getOperacion_inicio()), font)));
        pdfTable.addCell(new PdfPCell(new Paragraph(df.format(r.getOperacion_termino()), font)));
        pdfTable.addCell(new PdfPCell(new Paragraph(df.format(r.getPuerto_desatraque()), font)));
        pdfTable.addCell(new PdfPCell(new Paragraph(r.getPuerto_zarpe_hora() + "", font)));

        pdfTable.addCell(new PdfPCell(new Paragraph((int) Math.round(puerto_arribo) + "", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph((int) Math.round(muelle_atraque) + "", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph((int) Math.round(operacion_inicio) + "", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph((int) Math.round(operacion_termino) + "", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph((int) Math.round(puerto_desatraque) + "", font)));
        pdfTable.addCell(new PdfPCell(new Paragraph(new DecimalFormat("#.##").format(puerto_zarpe) + "", font)));

        PdfPCell producto = new PdfPCell(new Paragraph("Producto: " + r.getPuerto_producto(), font));
        producto.setColspan(4);
        pdfTable.addCell(producto);

        PdfPCell tonelaje = new PdfPCell(new Paragraph("Tonelaje: " + r.getPuerto_tonelaje(), font));
        tonelaje.setColspan(2);
        pdfTable.addCell(tonelaje);

        // HBP: HORAS TOTALES DESDE QUE EL BUQUE ARRIBA HASTA QUE ZARPA 
        PdfPCell hbp = new PdfPCell(new Paragraph("HBP: " + (int) Math.round(puerto_tiempo), font));
        hbp.setColspan(2);
        pdfTable.addCell(hbp);

        // HBM: HORAS TOTALES… TODO EL TIEMPO QUE EL BUQUE ESTUVO EN EL MUELLE .. DESDE QUE ATRACA HASTA QUE DESATRACA
        PdfPCell hbm = new PdfPCell(new Paragraph("HBM: " + (int) Math.round(muelle_tiempo), font));
        hbm.setColspan(2);
        pdfTable.addCell(hbm);

        // HBO: TOTAL DE HORAS DESDE EL INICIO DE SUS OPERACIONES DE CARGA HASTA QUE TERMINA SUS OPERACIONES DE CARGA 
        PdfPCell hbo = new PdfPCell(new Paragraph("HBO: " + (int) Math.round(operacion_tiempo), font));
        hbo.setColspan(2);
        pdfTable.addCell(hbo);

        // THBP: RENDIMIENTO DE BUQUE EN PUERTO 
        PdfPCell thbp = new PdfPCell(new Paragraph("THBP: " + (int) Math.round(puerto_rendimiento), font));
        thbp.setColspan(2);
        pdfTable.addCell(thbp);

        // THBM: RENDIMIENTO DE BUQUE EN MUELLE
        PdfPCell thbm = new PdfPCell(new Paragraph("THBM: " + (int) Math.round(muelle_rendimiento), font));
        thbm.setColspan(2);
        pdfTable.addCell(thbm);

        // THBO: RENDIMIENTO DE BUQUE EN OPERACIÓN 
        PdfPCell thbo = new PdfPCell(new Paragraph("THBO: " + (int) Math.round(operacion_rendimiento), font));
        thbo.setColspan(2);
        pdfTable.addCell(thbo);

        // Agregamos la tabla al documento            
        document.add(pdfTable);

        document.close();
    }

    private void ver() {
        try {
            Rendimiento r = getRendimientoSeleccionado();

            String puertoBuque = r.getPuerto_buque();
            String puertoMuelle = r.getPuerto_muelle();
            String puertoCarga = r.getPuerto_carga();
            String puertoProducto = r.getPuerto_producto();
            double puertoTonelaje = r.getPuerto_tonelaje();
            Date puertoArribo = r.getPuerto_arribo();
            double puertoArriboHora = r.getPuerto_arribo_hora();
            Date puertoDesatraque = r.getPuerto_desatraque();
            double puertoDesatraqueHora = r.getPuerto_desatraque_hora();
            Date puertoZarpe = r.getPuerto_zarpe();
            double puertoZarpeHora = r.getPuerto_zarpe_hora();
            Date muelleAtraque = r.getMuelle_atraque();
            double muelleAtraqueHora = r.getMuelle_atraque_hora();
            Date operacionInicio = r.getOperacion_inicio();
            double operacionInicioHora = r.getOperacion_inicio_hora();
            Date operacionTermino = r.getOperacion_termino();
            double operacionTerminoHora = r.getOperacion_termino_hora();
            double operacionDemoras = r.getOperacion_demoras();

            Show show = new Show();

            show.setData(puertoBuque, puertoMuelle, puertoCarga, puertoProducto, puertoTonelaje,
                    puertoArribo, puertoArriboHora, puertoDesatraque, puertoDesatraqueHora,
                    puertoZarpe, puertoZarpeHora, muelleAtraque, muelleAtraqueHora, operacionInicio,
                    operacionInicioHora, operacionTermino, operacionTerminoHora, operacionDemoras);

            show.setVisible(true);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error en SQL", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void refrescar() {
        try {
            model.updateModel(limit);
            update();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error en SQL", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Establece la apariencia de la aplicación.
     * @param name nombre del tema.
     */
    private void setLookAndFeel(String name) {
        try {
            switch (name) {
                case "system":
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;

                case "nimbus":
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;

                case "metal":
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                    
                case "motif":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
                    
                case "GTK":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                    break;

                default:
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
            }

            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        update();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void rootMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rootMouseClicked
        // TODO add your handling code here:
        table.clearSelection();
    }//GEN-LAST:event_rootMouseClicked

    private void mnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_mnAgregarActionPerformed

    private void mnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEditarActionPerformed
        editar();
    }//GEN-LAST:event_mnEditarActionPerformed

    private void mnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_mnEliminarActionPerformed

    private void mnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGenerarActionPerformed
        try {
            generarPDF(getRendimientoSeleccionado());
            JOptionPane.showMessageDialog(rootPane, "PDF generado exitosamente!", "PDF generado", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException | DocumentException | DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnGenerarActionPerformed

    private void mnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVerActionPerformed
        ver();
    }//GEN-LAST:event_mnVerActionPerformed

    private void cbxRegistrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRegistrosItemStateChanged
        // TODO add your handling code here:
        limit = Integer.parseInt(cbxRegistros.getSelectedItem().toString());
        update();
    }//GEN-LAST:event_cbxRegistrosItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        setLookAndFeel("system");
        table.getTableHeader().setBackground(defaultTableBackground);
        table.getTableHeader().setForeground(defaultTableForeground);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        setLookAndFeel("nimbus");
        table.getTableHeader().setBackground(defaultTableBackground);
        table.getTableHeader().setForeground(defaultTableForeground);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        setLookAndFeel("metal");
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        setLookAndFeel("motif");
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JComboBox<String> cbxRegistros;
    private com.toedter.calendar.JDateChooser dateArribo;
    private com.toedter.calendar.JDateChooser dateDesatraque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnAgregar;
    private javax.swing.JMenuItem mnEditar;
    private javax.swing.JMenuItem mnEliminar;
    private javax.swing.JMenuItem mnGenerar;
    private javax.swing.JMenu mnTema;
    private javax.swing.JMenuItem mnVer;
    private javax.swing.JPanel root;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBuscarBuque;
    private javax.swing.JTextField txtBuscarCarga;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
