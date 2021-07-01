/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edd.universidades;

import com.universidades.dao.UniversidadesModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Josue Figueroa
 */


public class Tabla_unis extends javax.swing.JFrame {

    /**
     * Creates new form Tabla_unis
     */
    private UniversidadesTableModel universidades;
    
    public Tabla_unis() {
        universidades = new UniversidadesTableModel();
        UniversidadesModel.verificarTablaUniversidades();
        universidades.addRows(UniversidadesModel.getUniversidades());
      
        initComponents();
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jT_Uni = new javax.swing.JTable();
        jBNuevo = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jT_Uni.setModel(universidades);
        jScrollPane1.setViewportView(jT_Uni);

        jBNuevo.setText("Nuevo");
        jBNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBNuevoMouseClicked(evt);
            }
        });
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBEditar.setText("Editar");
        jBEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEditarMouseClicked(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEliminarMouseClicked(evt);
            }
        });

        jBMostrar.setText("Mostrar");
        jBMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBMostrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jBNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBMostrar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNuevo)
                    .addComponent(jBEditar)
                    .addComponent(jBEliminar)
                    .addComponent(jBMostrar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void levantarModalUni( String modalidad, double id){
        UniversidadesForm universidadModel = new UniversidadesForm(modalidad, id);
        
        universidadModel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                boolean reload = ((UniversidadesForm) e.getSource()).getReloadParent();
                if (reload){
                    universidades.clearTableModelData();
                    universidades.addRows(UniversidadesModel.getUniversidades());
                    jT_Uni.repaint();
                }
            }
        });
        universidadModel.setVisible(true);
    }
     
      private double obtenerIDSeleccionado(){
        double id = -1;
        int rowIndex = jT_Uni.getSelectedRow();
        id = Double.valueOf(jT_Uni.getModel().getValueAt(rowIndex, 0).toString());
        return id;
    }
    
    private void jBNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNuevoMouseClicked
        // TODO add your handling code here:
        levantarModalUni("INS", 0);
    }//GEN-LAST:event_jBNuevoMouseClicked

    private void jBEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseClicked
        // TODO add your handling code here:
        //TODO obtener el id a partir del registro seleccionado de la tabla
        // Primero creamos una instancia de la pantalla, Clase

        levantarModalUni("UPD", obtenerIDSeleccionado());
    }//GEN-LAST:event_jBEditarMouseClicked

    private void jBEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        //TODO obtener el id a partir del registro seleccionado de la tabla

        levantarModalUni("DEL", obtenerIDSeleccionado());
    }//GEN-LAST:event_jBEliminarMouseClicked

    private void jBMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBMostrarMouseClicked
        // TODO add your handling code here:
        levantarModalUni("DSP", obtenerIDSeleccionado());
    }//GEN-LAST:event_jBMostrarMouseClicked

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNuevoActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabla_unis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_unis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_unis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_unis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_unis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBMostrar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jT_Uni;
    // End of variables declaration//GEN-END:variables
}
