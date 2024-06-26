/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.gui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.dao.UsuarioDAO;
import org.itson.dominio.Libro;
import org.itson.dominio.Usuario;
import org.itson.negocio.LibroNegocio;

/**
 *
 * @author Admin
 */
public class frmBuscarLibro extends javax.swing.JFrame {

    private LibroNegocio libroNegocio;
    private DefaultTableModel modeloTabla;
    
    /**
     * Creates new form frmBuscarLibro
     */
    public frmBuscarLibro() {
        initComponents();
        libroNegocio = new LibroNegocio();
        
        //Inicializa el modelo de la tabla con los nombres de las columnas editados
        modeloTabla = new DefaultTableModel(new Object[][]{}, new String[]{"ISBN", "Titulo", "Autor", "Disponibilidad"});
        
        //Asigna el modelo de la tabla creado a la tabla de libros
        tablaLibros.setModel(modeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTodos = new javax.swing.JButton();
        btnISBN = new javax.swing.JButton();
        btnTitulo = new javax.swing.JButton();
        btnAutor = new javax.swing.JButton();
        btnPrestados = new javax.swing.JButton();
        btnDisponibles = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar libros");

        btnTodos.setText("Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        btnISBN.setText("ISBN");
        btnISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnISBNActionPerformed(evt);
            }
        });

        btnTitulo.setText("Titulo");
        btnTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTituloActionPerformed(evt);
            }
        });

        btnAutor.setText("Autor");
        btnAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorActionPerformed(evt);
            }
        });

        btnPrestados.setText("Prestados");
        btnPrestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestadosActionPerformed(evt);
            }
        });

        btnDisponibles.setText("Disponibles");
        btnDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponiblesActionPerformed(evt);
            }
        });

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaLibros);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTodos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnISBN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTitulo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAutor))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(btnDisponibles)
                                        .addGap(71, 71, 71)
                                        .addComponent(btnPrestados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBorrar)))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTodos)
                    .addComponent(btnISBN)
                    .addComponent(btnTitulo)
                    .addComponent(btnAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisponibles)
                    .addComponent(btnPrestados)
                    .addComponent(btnRegresar)
                    .addComponent(btnBorrar))
                .addGap(12, 12, 12)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón con el cuál se buscan todos los libros registrados y se añaden a
     * la tabla.
     * @param evt Evento actionPerformed del botón. 
     */
    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try{
            List<Libro> librosEncontrados = libroNegocio.obtenerTodosLosLibros();
            actualizarTabla(librosEncontrados);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar todos los libros: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    /**
     * Botón con el cuál se busca un único libro por su ISBN y se añade a la
     * tabla.
     * @param evt Evento actionPerformed del botón.
     */
    private void btnISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnISBNActionPerformed
        String ISBN = txtBusqueda.getText().trim();
        try{
            Libro libroEncontrado = libroNegocio.obtenerLibroISBN(ISBN);
            actualizarTablaLibroUnico(libroEncontrado);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar libro con ese ISBN: " + e.getMessage());
        }
    }//GEN-LAST:event_btnISBNActionPerformed

    /**
     * Botón con el cuál se buscan todos los libros con títulos similares y se
     * añaden a la tabla.
     * @param evt Evento actionPerformed del botón.
     */
    private void btnTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTituloActionPerformed
        String titulo = txtBusqueda.getText().trim();
        try{
            List<Libro> librosEncontrados = libroNegocio.obtenerLibroTitulo(titulo);
            actualizarTabla(librosEncontrados);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar libros por titulo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTituloActionPerformed

    /**
     * Botón con el cuál se buscan todos los libros del mismo autor y se añaden
     * a la tabla.
     * @param evt Evento actionPerformed del botón.
     */
    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed
        String autor = txtBusqueda.getText().trim();
        try{
            List<Libro> librosEncontrados = libroNegocio.obtenerLibroAutor(autor);
            actualizarTabla(librosEncontrados);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar libros por autor: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAutorActionPerformed

    /**
     * Botón con el cuál se buscan todos los libros disponibles y se añaden a
     * la tabla.
     * @param evt Evento actionPerformed del botón.
     */
    private void btnDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponiblesActionPerformed
        try{
            List<Libro> librosEncontrados = libroNegocio.obtenerLibrosDisponibles();
            actualizarTabla(librosEncontrados);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar libros disponibles: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDisponiblesActionPerformed

    /**
     * Botón con el cuál se buscan todos los libros prestados y se añaden a la
     * tabla (Este botón le generó depresión a Tadeo, así que lo dropeó con la
     * esperanza de que un valiente algún día pueda hacerlo funcionar).
     * @param evt Evento actionPerformed del botón.
     */
    private void btnPrestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestadosActionPerformed
        try{
            Usuario usuario = obtenerUsuarioActual();
            List<Libro> librosPrestados = libroNegocio.obtenerLibrosPrestados(usuario);
            actualizarTabla(librosPrestados);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar libros prestados, el error es: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPrestadosActionPerformed

    /**
     * Botón para regresar al frame Principal.
     * @param evt Evento actionPerformed del botón.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        this.dispose();
        frmPrincipal.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaLibros.getModel();
        modelo.setRowCount(0);
    }//GEN-LAST:event_btnBorrarActionPerformed

    //Metodo para actualizar la tabla con los resultados de busqueda
    private void actualizarTabla(List<Libro> libros){
        DefaultTableModel modelo = (DefaultTableModel) tablaLibros.getModel();
        modelo.setRowCount(0);
        
        for(Libro libro : libros){
            modelo.addRow(new Object[]{libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.isDisponibilidad()});
        }
    }
    
    //Este metodo unicamente existe para buscar libro por ISBN, puesto que es el unico
    //metodo que busca un solo libro en lugar de una lista
    private void actualizarTablaLibroUnico(Libro libro){
        DefaultTableModel modelo = (DefaultTableModel) tablaLibros.getModel();
        modelo.setRowCount(0);
        modelo.addRow(new Object[]{libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.isDisponibilidad()});
    }
    
    private Usuario obtenerUsuarioActual() throws Exception{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nombreUsuario = txtBusqueda.getText().trim();
        return usuarioDAO.getUsuarioByName(nombreUsuario);
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
            java.util.logging.Logger.getLogger(frmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutor;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnDisponibles;
    private javax.swing.JButton btnISBN;
    private javax.swing.JButton btnPrestados;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTitulo;
    private javax.swing.JButton btnTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
