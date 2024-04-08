/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.EstadoPrestamo;
import org.itson.dominio.Libro;
import org.itson.dominio.Prestamo;
import org.itson.negocio.LibroNegocio;
import org.itson.negocio.PrestamoNegocio;

/**
 *
 * @author marco
 */
public class FrmDevolverLibro extends javax.swing.JFrame {

    private PrestamoNegocio pmNegocio;
    private DefaultTableModel prestamosTableModel;
    /**
     * Creates new form FrmDevolverLibro
     */
    public FrmDevolverLibro() throws Exception {
        pmNegocio = new PrestamoNegocio();
        initComponents();
        inicializarTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDevolver = new javax.swing.JTable();
        btnDevolver = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDevolver.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaDevolver);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 520, 330));

        btnDevolver.setText("Devolver Libro");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 140, 50));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        FrmPrincipal frm = new FrmPrincipal();
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        // TODO add your handling code here:
        int selectedRow = tablaDevolver.getSelectedRow();

        if (selectedRow == -1) {
            
            mostrarAlerta("Seleccione un préstamo para devolver.");
            return;
        }

        try {
           
            Prestamo prestamo = obtenerPrestamoSeleccionado(selectedRow);
            
            this.pmNegocio.liberarPrestamo(prestamo);
          
            mostrarAlerta("Devolución realizada correctamente.");   
            
        } catch (Exception ex) {
            // Mostrar mensaje de error en caso de excepción
            mostrarAlerta("Error al devolver el préstamo: " + ex.getMessage());
        }
        
        this.dispose();
        FrmPrincipal frm = new FrmPrincipal();
        frm.setVisible(true);
        
    }//GEN-LAST:event_btnDevolverActionPerformed

    private Prestamo obtenerPrestamoSeleccionado(int rowIndex) throws Exception {

        DefaultTableModel model = (DefaultTableModel) tablaDevolver.getModel();
        String isbn = (String) model.getValueAt(rowIndex, 1);

        return pmNegocio.obtenerPrestamoByIsbn(isbn);
    }
    
    public void inicializarTabla() throws Exception{
        prestamosTableModel = new DefaultTableModel();
        prestamosTableModel.addColumn("Libro");
        prestamosTableModel.addColumn("ISBN");
        prestamosTableModel.addColumn("Estado");
        prestamosTableModel.addColumn("Usuario Poseedor");

        tablaDevolver.setModel(prestamosTableModel);
        obtenerPrestamos();
    }
    
    public void obtenerPrestamos() throws Exception {
        List<Prestamo> prestamos = this.pmNegocio.obtenerPrestamoDisponibilidad(EstadoPrestamo.PRESTADO);
        for (Prestamo prestamo : prestamos) {
            for (Libro libro : prestamo.getLibros()) {
                // Obtener los detalles del libro
                String nombreLibro = libro.getTitulo();
                String isbn = libro.getIsbn();
                EstadoPrestamo estado = prestamo.getEstado();

                // Obtener el nombre del usuario asociado al préstamo
                String nombreUsuario = prestamo.getUsuario().getNombre();

                // Crear el arreglo de objetos para agregar a la tabla
                Object[] rowData = {nombreLibro, isbn, estado, nombreUsuario};

                // Agregar la fila a la tabla de prestamos
                prestamosTableModel.addRow(rowData);
            }
        }
    }
    
    private void mostrarAlerta(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Alerta", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmDevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmDevolverLibro().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FrmDevolverLibro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDevolver;
    // End of variables declaration//GEN-END:variables
}