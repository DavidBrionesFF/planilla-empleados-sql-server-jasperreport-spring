package com.planilla.empleado.view;

import com.planilla.empleado.configuration.ImageView;
import com.planilla.empleado.model.Actividad;
import com.planilla.empleado.model.Empleado;
import com.planilla.empleado.model.Pago;
import com.planilla.empleado.repository.ActividadRepository;
import com.planilla.empleado.repository.EmpleadoRepository;
import com.planilla.empleado.repository.PagoRepository;
import com.planilla.empleado.service.ReportService;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "singleton")
public class EmpleadosView extends javax.swing.JFrame {
    //Repositorys
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private ActividadRepository actividadRepository;
    
    //Views
    @Autowired
    private NuevoEmpleadoView nuevoEmpleadoView;
    
    @Autowired
    private ReportService reporService;
    
    private List<Empleado> empleados;
    
    @PostConstruct
    public void init(){
        empleados = empleadoRepository.findAll();
        jButton1.setIcon(ImageView.getImage("030-worker.png"));
        jButton2.setIcon(ImageView.getImage("003-change.png"));
        jButton3.setIcon(ImageView.getImage("011-salary.png"));
        jButton4.setIcon(ImageView.getImage("034-department.png"));
        jButton5.setIcon(ImageView.getImage("018-documents.png"));
        jButton6.setIcon(ImageView.getImage("018-documents.png"));
        jButton7.setIcon(ImageView.getImage("018-documents.png"));
        this.init_empleados();
    }
    
    public void init_empleados(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("Identidad");
        defaultTableModel.addColumn("No. Ficha");
        defaultTableModel.addColumn("Cargo");
        defaultTableModel.addColumn("Activo");
        empleados.forEach((t) -> {
            defaultTableModel.addRow(new Object[]{
                t.getId(),
                t.getNombre(),
                t.getDni(),
                t.getIdentificacion(),
                t.getCargo(),
                (t.isActivo())? "ACTIVO": "INACTIVO"
            });
        });
        tblEmpleados.setModel(defaultTableModel);
        tblEmpleados.getSelectionModel().addListSelectionListener((e) -> {
            List<Empleado> getEmpleado = empleados
                    .stream()   
                    .filter((t) -> {
                        return t.getId() == 
                                Integer.parseInt(tblEmpleados
                                        .getValueAt(tblEmpleados.getSelectedRow(), 0)
                                        .toString());
                    }).collect(Collectors.toList());
            if(getEmpleado.size()>0){
                nuevoEmpleadoView.setLocationRelativeTo(this);
                nuevoEmpleadoView.setEmpleado(getEmpleado.get(0));
                nuevoEmpleadoView.setVisible(true);
            }
        });     
    }
    
    public void init_pago(){
        List<Pago> pagos = pagoRepository.findAll();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Monto");
        defaultTableModel.addColumn("Cargos");
        defaultTableModel.addColumn("Id empleado");
        defaultTableModel.addColumn("Fecha Pago");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        
        pagos.forEach((t) -> {
            defaultTableModel.addRow(new Object[]{
                t.getId(),
                t.getMonto(),
                t.getCargos(),
                findById(t.getEmpleado()).getNombre(),
                dateFormat.format(t.getFecha_pago())
            });
        });
        tblEmpleados.setModel(defaultTableModel);
//        tblEmpleados.getSelectionModel().addListSelectionListener((e) -> {
//            List<Empleado> getEmpleado = empleados
//                    .stream()   
//                    .filter((t) -> {
//                        return t.getId() == Integer.parseInt(tblEmpleados.getValueAt(tblEmpleados.getSelectedRow(), 0).toString());
//                    }).collect(Collectors.toList());
//            if(getEmpleado.size()>0){
//                nuevoEmpleadoView.setLocationRelativeTo(this);
//                nuevoEmpleadoView.setEmpleado(getEmpleado.get(0));
//                nuevoEmpleadoView.setVisible(true);
//            }
//        });     
    }
    
    public void init_actividad(){
        List<Actividad> actividades = actividadRepository.findAll();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Fecha Marcada");
        defaultTableModel.addColumn("Fecha Entrada");
        defaultTableModel.addColumn("Fecha Fecha Salida");
        defaultTableModel.addColumn("Id Empleado");
        defaultTableModel.addColumn("Asistido");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        
        actividades.forEach((t) -> {
            defaultTableModel.addRow(new Object[]{
                t.getId(),
                dateFormat.format(t.getFecha_entrada()),
                dateFormat.format(t.getFecha_entrada()),
                dateFormat.format(t.getFecha_salida()),
                findById(t.getEmpleado()).getNombre(),
                (t.isTrabajado())? "ASISTIDO": "NO ASISTIDO"
            });
        });
        tblEmpleados.setModel(defaultTableModel);
    }
    
    public EmpleadosView() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empleados");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Empleados");

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblEmpleados.setToolTipText("Tabla");
        jScrollPane2.setViewportView(tblEmpleados);

        jButton1.setBackground(new java.awt.Color(13, 71, 161));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar Empleado");
        jButton1.setToolTipText("Agregar Empleado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(13, 71, 161));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Empleados");
        jButton2.setToolTipText("Empleados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(13, 71, 161));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Pagos");
        jButton3.setToolTipText("Pagos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(13, 71, 161));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Actividades");
        jButton4.setToolTipText("Actividades");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(13, 71, 161));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Imprimir Empleados");
        jButton5.setToolTipText("Imprimir Empleados");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(13, 71, 161));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("ImprimirActividad");
        jButton6.setToolTipText("ImprimirActividad");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(13, 71, 161));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Imprimir Pagos");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)
                        .addGap(20, 20, 20)
                        .addComponent(jButton3)
                        .addGap(20, 20, 20)
                        .addComponent(jButton4)
                        .addGap(20, 20, 20)
                        .addComponent(jButton5)
                        .addGap(20, 20, 20)
                        .addComponent(jButton6)
                        .addGap(20, 20, 20)
                        .addComponent(jButton7))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        nuevoEmpleadoView.setLocationRelativeTo(this);
        nuevoEmpleadoView.setEmpleado(new Empleado());
        nuevoEmpleadoView.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.init();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //Pago
        this.init_pago();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.init_actividad();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        reporService.onViewEmpleado();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        reporService.onViewActividad();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        reporService.onViewPago();
    }//GEN-LAST:event_jButton7ActionPerformed


    private Empleado findById(int id){
        List<Empleado> getEmpleado = empleados
                    .stream()   
                    .filter((t) -> {
                        return t.getId() == id;
                    }).collect(Collectors.toList());
        if(getEmpleado.size()>0){
            return getEmpleado.get(0);
        }else{
            return empleadoRepository.findById(id);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEmpleados;
    // End of variables declaration//GEN-END:variables
}
