/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.formularios;

import com.sistcontable.dao.PersonaDAO;
import com.sistcontable.model.Persona;
import com.sistcontable.model.Telefono;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Miranda
 */
public class FrmPersona extends javax.swing.JPanel {
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();
    private DefaultListModel modeloLista = new DefaultListModel();
    private List<Persona> objPersona;
    private BigDecimal idActual;
    private Boolean isUpdate = Boolean.FALSE;

    /**
     * Creates new form FrmTab1
     */
    public FrmPersona() {
        initComponents();
        Actualizar_lista();
        jList1.setModel(modeloLista);
        textPrimerNombre.setEditable(false);
        textSegundoNombre.setEditable(false);
        textPrimerApellido.setEditable(false);
        textSegundoApellido.setEditable(false);
        textCargo.setEditable(false);
        textTelFijo.setEditable(false);
        textTelMovil.setEditable(false);
        textTelAuxiliar.setEditable(false);
        textDUI.setEditable(false);
        textEmail.setEditable(false);
        textDireccion.setEditable(false);
    }
    
    public void Actualizar_lista() {
        objPersona = personaDAO.searchAllPerson();

        if (!(objPersona.isEmpty())) {
            this.modeloLista.clear();
            for (int i = 0; i < objPersona.size(); i++) {
                modeloLista.addElement(objPersona.get(i));
            }
            jList1.setSelectedIndex(0);
        }
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
        jList1 = new javax.swing.JList();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textPrimerNombre = new javax.swing.JTextField();
        textSegundoNombre = new javax.swing.JTextField();
        textPrimerApellido = new javax.swing.JTextField();
        textSegundoApellido = new javax.swing.JTextField();
        combMunicipio = new javax.swing.JComboBox();
        textCargo = new javax.swing.JTextField();
        combSexo = new javax.swing.JComboBox();
        textDUI = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        textDireccion = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textTelFijo = new javax.swing.JTextField();
        textTelMovil = new javax.swing.JTextField();
        textTelAuxiliar = new javax.swing.JTextField();
        labelMensaje = new javax.swing.JLabel();
        textFechNac = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1059, 515));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista"));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistcontable/imagenes/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistcontable/imagenes/editnew.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistcontable/imagenes/filesave.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistcontable/imagenes/delete.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("sssssss"));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel1.setText("Primer Nombre");

        jLabel2.setText("Segundo Nombre");

        jLabel3.setText("Primer Apellido");

        jLabel4.setText("Segundo Apellido");

        jLabel5.setText("Cargo");

        jLabel6.setText("Sexo");

        jLabel7.setText("Fecha Nacimiento");

        jLabel8.setText("DUI");

        jLabel9.setText("Municipio");

        jLabel10.setText("Email");

        jLabel11.setText("Direccion");

        combMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        jScrollPane3.setViewportView(textDireccion);

        jLabel12.setText("Telefono Movil");

        jLabel13.setText("Telefono Auxiliar");

        jLabel14.setText("Telefono Fijo");

        textFechNac.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(112, 112, 112)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textFechNac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textDUI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                        .addComponent(textCargo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combMunicipio, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textTelAuxiliar, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textTelMovil, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textTelFijo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combSexo, javax.swing.GroupLayout.Alignment.LEADING, 0, 195, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(labelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textTelFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textTelMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(textTelAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(textFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textDUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(labelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        boolean resp = Boolean.FALSE;
        if(textPrimerNombre.getText().equals("") || textPrimerApellido.getText().equals("") || textDireccion.getText().equals("")
                || textDUI.getText().equals("")){
            MostrarMensaje("Uno o mas campos estan vacios","cancel.png", labelMensaje);
        }else{
            
            persona.setPrimerNombre(textPrimerNombre.getText());
            persona.setSegundoNombre(textSegundoNombre.getText());
            persona.setPrimerApellido(textPrimerApellido.getText());
            persona.setSegundoApellido(textSegundoApellido.getText());
            //falta hacer consulta del municipio
            combMunicipio.getSelectedItem();
            persona.setIdMunicipio(1);
            /////////////////////////////////
            persona.setCargo(textCargo.getText());
            
            persona.setSexo("F");
            persona.setFechaNac(textFechNac.getDate());
            persona.setDui(textDUI.getText());
            persona.setEMail(textEmail.getText());
            persona.setDireccion(textDireccion.getText());
               
            resp=personaDAO.savePerson(persona);
            //personaDAO.savePerson();
            //resp=personaDAO.savePrueba(prueba);
            
            /*if(isUpdate)
                resp=personaDAO.updatePerson(persona);
            else{
                resp=personaDAO.savePerson(persona);
            }*/
            if (resp) {
                MostrarMensaje("Usuario Registrado Corecctamente","ok.png", labelMensaje);
                // mandar a guardar los telefonos si hay
                Actualizar_lista();
            } else {
                MostrarMensaje("Error al tratar de Registrar el Usuario","cancel.png", labelMensaje);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        isUpdate = Boolean.TRUE;
        
        textPrimerNombre.setEditable(true);
        textSegundoNombre.setEditable(true);
        textPrimerApellido.setEditable(true);
        textSegundoApellido.setEditable(true);
        textCargo.setEditable(true);
        textTelFijo.setEditable(true);
        textTelMovil.setEditable(true);
        textTelAuxiliar.setEditable(true);
        textDUI.setEditable(true);
        textEmail.setEditable(true);
        textDireccion.setEditable(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        isUpdate = Boolean.FALSE;
        
        textPrimerNombre.setEditable(true);
        textSegundoNombre.setEditable(true);
        textPrimerApellido.setEditable(true);
        textSegundoApellido.setEditable(true);
        textCargo.setEditable(true);
        textTelFijo.setEditable(true);
        textTelMovil.setEditable(true);
        textTelAuxiliar.setEditable(true);
        textDUI.setEditable(true);
        textEmail.setEditable(true);
        textDireccion.setEditable(true);
        
        textPrimerNombre.setText("");
        textSegundoNombre.setText("");
        textPrimerApellido.setText("");
        textSegundoApellido.setText("");
        textCargo.setText("");
        textTelFijo.setText("");
        textTelMovil.setText("");
        textTelAuxiliar.setText("");
        textDUI.setText("");
        textEmail.setText("");
        textDireccion.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        boolean resp = Boolean.FALSE;
        resp=personaDAO.deletePerson(idActual);
        
        Actualizar_lista();
        
        if(resp)
            MostrarMensaje("Registro Eliminado","ok.png", labelMensaje);
        else
            MostrarMensaje("Error al tratar de eliminar el registro","cancel.png", labelMensaje);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        int index = jList1.getSelectedIndex();

        if (index != -1) {

            Persona objMostrarPersona = (Persona) modeloLista.getElementAt(index);

            idActual = objMostrarPersona.getIdPersona();
            
            textPrimerNombre.setText(objMostrarPersona.getPrimerNombre());
            textSegundoNombre.setText(objMostrarPersona.getSegundoNombre());
            textPrimerApellido.setText(objMostrarPersona.getPrimerApellido());
            textSegundoApellido.setText(objMostrarPersona.getSegundoApellido());
            textCargo.setText(objMostrarPersona.getCargo());
            textTelFijo.setText("");
            textTelMovil.setText("");
            textTelAuxiliar.setText("");
            textDUI.setText(objMostrarPersona.getDui());
            textEmail.setText(objMostrarPersona.getEMail());
            textDireccion.setText(objMostrarPersona.getDireccion());
            
        }
        textPrimerNombre.setEditable(false);
        textSegundoNombre.setEditable(false);
        textPrimerApellido.setEditable(false);
        textSegundoApellido.setEditable(false);
        textCargo.setEditable(false);
        textTelFijo.setEditable(false);
        textTelMovil.setEditable(false);
        textTelAuxiliar.setEditable(false);
        textDUI.setEditable(false);
        textEmail.setEditable(false);
        textDireccion.setEditable(false);
    }//GEN-LAST:event_jList1ValueChanged

    public void MostrarMensaje(String msj, String nameImagen, JLabel label) {
        label.setText(msj);
        String path = "/com/sistcontable/imagenes/"+nameImagen;
        URL url = this.getClass().getResource(path); 
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox combMunicipio;
    private javax.swing.JComboBox combSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelMensaje;
    private javax.swing.JTextField textCargo;
    private javax.swing.JTextField textDUI;
    private javax.swing.JTextPane textDireccion;
    private javax.swing.JTextField textEmail;
    private com.toedter.calendar.JDateChooser textFechNac;
    private javax.swing.JTextField textPrimerApellido;
    private javax.swing.JTextField textPrimerNombre;
    private javax.swing.JTextField textSegundoApellido;
    private javax.swing.JTextField textSegundoNombre;
    private javax.swing.JTextField textTelAuxiliar;
    private javax.swing.JTextField textTelFijo;
    private javax.swing.JTextField textTelMovil;
    // End of variables declaration//GEN-END:variables
}
