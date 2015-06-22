/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistcontable.formularios;

import com.sistcontable.dao.CuentaDAO;
import com.sistcontable.dao.EstadoDAO;
import com.sistcontable.dao.RubroDAO;
import com.sistcontable.model.Cuenta;
import com.sistcontable.model.Estado;
import com.sistcontable.model.Rubro;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.SingleSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrador
 */
public class FrmCuenta extends javax.swing.JPanel {
    Cuenta cuenta  = new Cuenta();
    CuentaDAO cuentaDAO = new CuentaDAO();
    EstadoDAO estadoDAO = new EstadoDAO();
    RubroDAO rubroDAO = new RubroDAO();
    List<Cuenta> cuentaLista = cuentaDAO.searchAllCuentas();
    List<Estado> estadoLista = estadoDAO.searchAllEstados();
    List<Rubro> rubroLista = rubroDAO.searchAllRubros();
    
    
    //private DefaultListModel modeloLista = new DefaultListModel();
    //private List<Usuario> objUsuario;
    //private String idActual;
    //private Boolean isUpdate = Boolean.FALSE;

    /**
     * Creates new form FrmCuenta
     */
    public FrmCuenta() {
        initComponents();
        cargarTodosLosDatos();
    }
    
    public void cargarTodosLosDatos(){
        CargarTablas();
        CargarEstadosFinancierosEnListaDelPanel2();
        CargarRubrosEnListaDelPanel2();
        CargarNombresCuentasEnListaDelPanel2();
        
        CargarEstadosFinancierosEnListaDelPanel3();
        CargarRubrosEnListaDelPanel3();
        CargarNombresCuentasEnListaDelPanel3();
        this.repaint();
        
    }
    
    public void CargarTablas(){

        //definiendo el modelo de la tabla--------------------------------------
        DefaultTableModel model = new DefaultTableModel();

        //agregando columnas
        model.addColumn("ID CUENTA");
        model.addColumn("ESTADO FINANCIERO");
        model.addColumn("RUBRO");
        model.addColumn("NOMBRE CUENTA");
        model.addColumn("CUENTA MAYOR");

        //llenando el modelo de la tabla. agregando filas-----------------------
        for(int i=0; i<cuentaLista.size(); i++){
            model.addRow(new Object[]{cuentaLista.get(i).getIdCuenta().toString(),
                cuentaLista.get(i).getEstado().getNombreEstado().toString(),
                cuentaLista.get(i).getRubro().getNombreRubro().toString(),
                cuentaLista.get(i).getNombreCuenta(),
                cuentaLista.get(i).getCuentaMayor().toString()  });
        }
        
        //fin modelo de la tabla -----------------------------------------------

        //asignando el modelo de la tabla a la tabla de mi interfaz.
        jTable_panel1_catalogo.setModel(model);
        jTable_panel3_catalogo.setModel(model);
        jTable_panel4_catalogo.setModel(model);
    }
    
    
    
    public void CargarEstadosFinancierosEnListaDelPanel2(){
               
        for(int i=0; i<estadoLista.size() ; i++){
        jComboBox_panel2_estadosFinancieros.addItem(
                estadoLista.get(i).getIdEstado().toString() +
                "- "+
                estadoLista.get(i).getNombreEstado().toString());        
        }
    }
    
    
    public void CargarRubrosEnListaDelPanel2(){      
        for(int i=0; i<rubroLista.size() ; i++){
        jComboBox_panel2_rubros.addItem(
                rubroLista.get(i).getIdRubro().toString()+
                "- "+
                rubroLista.get(i).getNombreRubro().toString());        
        }
    }
    
    public void CargarNombresCuentasEnListaDelPanel2(){      
        for(int i=0; i<cuentaLista.size() ; i++){
        jComboBox_panel2_cuentaMayor.addItem(
                cuentaLista.get(i).getIdCuenta().toString()+
                "- "+
                cuentaLista.get(i).getNombreCuenta().toString().replace('_',' '));        
        }
    }
    
    public void CargarEstadosFinancierosEnListaDelPanel3(){
               
        for(int i=0; i<estadoLista.size() ; i++){
        jComboBox_panel3_estado.addItem(
                estadoLista.get(i).getIdEstado().toString() +
                "- "+
                estadoLista.get(i).getNombreEstado().toString());        
        }
    }
    
    
    public void CargarRubrosEnListaDelPanel3(){      
        for(int i=0; i<rubroLista.size() ; i++){
        jComboBox_panel3_rubro.addItem(
                rubroLista.get(i).getIdRubro().toString()+
                "- "+
                rubroLista.get(i).getNombreRubro().toString());        
        }
    }
    
    public void CargarNombresCuentasEnListaDelPanel3(){      
        for(int i=0; i<cuentaLista.size() ; i++){
        jComboBox_panel3_cuentaMayor.addItem(
                cuentaLista.get(i).getIdCuenta().toString()+
                "- "+
                cuentaLista.get(i).getNombreCuenta().toString().replace('_',' '));        
        }
    }
    
    public void CargarTablasEnMemoria(){
    cuentaLista = cuentaDAO.searchAllCuentas();
    estadoLista = estadoDAO.searchAllEstados();
    rubroLista = rubroDAO.searchAllRubros();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane_cuenta = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_panel1_catalogo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_panel2_idcuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_panel2_estadosFinancieros = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_panel2_rubros = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField_panel2_nombrecuenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_panel2_cuentaMayor = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_panel3_catalogo = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField_panel3_idcuenta = new javax.swing.JTextField();
        jComboBox_panel3_estado = new javax.swing.JComboBox();
        jComboBox_panel3_rubro = new javax.swing.JComboBox();
        jTextField_panel3_nombre = new javax.swing.JTextField();
        jComboBox_panel3_cuentaMayor = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_panel4_catalogo = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTextField_panel4_idcuenta = new javax.swing.JTextField();
        jTextField_panel4_nombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1059, 515));

        jTabbedPane_cuenta.setPreferredSize(new java.awt.Dimension(1059, 515));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CATALOGO DE CUENTAS");

        jTable_panel1_catalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable_panel1_catalogo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane_cuenta.addTab("Catalogo de cuentas", jPanel2);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESAR NUEVA CUENTA");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ID CUENTA:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ESTADO FINANCIERO AL QUE PERTENECE:");

        jComboBox_panel2_estadosFinancieros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_panel2_estadosFinancierosActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("RUBRO:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("NOMBRE DE LA CUENTA:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CUENTA PADRE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField_panel2_nombrecuenta)
                        .addComponent(jComboBox_panel2_cuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField_panel2_idcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBox_panel2_rubros, javax.swing.GroupLayout.Alignment.LEADING, 0, 302, Short.MAX_VALUE)
                        .addComponent(jComboBox_panel2_estadosFinancieros, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(320, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_panel2_idcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_panel2_estadosFinancieros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_panel2_rubros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_panel2_nombrecuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_panel2_cuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistcontable/imagenes/filesave.png"))); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane_cuenta.addTab("Ingresar nueva cuenta", jPanel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MODIFICAR CUENTA EXISTENTE");

        jScrollPane1.setEnabled(false);

        jTable_panel3_catalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_panel3_catalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_panel3_catalogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_panel3_catalogo);

        jLabel11.setText("Seleccione la cuenta a modificar dando clic sobre la tabla:");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("ID CUENTA:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("ESTADO FINANCIERO AL QUE PERTENECE:");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("RUBRO");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("NOMBRE DE LA CUENTA:");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("CUENTA PADRE:");

        jTextField_panel3_idcuenta.setEnabled(false);

        jComboBox_panel3_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_panel3_estadoActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistcontable/imagenes/editar.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_panel3_cuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField_panel3_idcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox_panel3_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox_panel3_rubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_panel3_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jTextField_panel3_idcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox_panel3_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox_panel3_rubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jTextField_panel3_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jComboBox_panel3_cuentaMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane_cuenta.addTab("Modificar cuenta existente", jPanel4);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ELIMINACION DE CUENTA");

        jLabel17.setText("Seleccione la fila de la tabla a eliminar:");

        jTable_panel4_catalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_panel4_catalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_panel4_catalogoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_panel4_catalogo);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField_panel4_idcuenta.setEnabled(false);

        jTextField_panel4_nombre.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextField_panel4_nombre.setEnabled(false);
        jTextField_panel4_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_panel4_nombreActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ID CUENTA:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("NOMBRE DE LA CUENTA:");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sistcontable/imagenes/delete.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_panel4_idcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_panel4_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(427, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_panel4_idcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_panel4_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane_cuenta.addTab("Eliminar cuenta", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_panel4_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_panel4_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_panel4_nombreActionPerformed

    private void jComboBox_panel2_estadosFinancierosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_panel2_estadosFinancierosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_panel2_estadosFinancierosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Cuenta c = new Cuenta();
        Rubro  r=new Rubro();
        BigDecimal cMayor;
        

        c.setIdCuenta(BigDecimal.valueOf(Double.parseDouble(jTextField_panel2_idcuenta.getText())));
  
        int separador = jComboBox_panel2_estadosFinancieros.getSelectedItem().toString().indexOf("-");
        String x = jComboBox_panel2_estadosFinancieros.getSelectedItem().toString().substring(0, separador);
        c.setEstado(estadoDAO.obtenerEstadoByID(x));
        
        separador = jComboBox_panel2_rubros.getSelectedItem().toString().indexOf("-");
        x = jComboBox_panel2_rubros.getSelectedItem().toString().substring(0, separador);
        c.setRubro(rubroDAO.obtenerRubroByID(x));
        
        
        c.setNombreCuenta(jTextField_panel2_nombrecuenta.getText());
        
        
        separador = jComboBox_panel2_cuentaMayor.getSelectedItem().toString().indexOf("-");
        x = jComboBox_panel2_cuentaMayor.getSelectedItem().toString().substring(0, separador);
        c.setCuentaMayor(cuentaDAO.obtenerCuentaByID(x).getIdCuenta());
        
        //JOptionPane.showMessageDialog(null, c.getIdCuenta()+" "+c.getEstado().getIdEstado()+" "+c.getRubro().getIdRubro()+" "+c.getNombreCuenta()+" "+c.getCuentaMayor());
        cuentaDAO.saveCuenta(c);
        if(cuentaDAO.saveCuenta(c)){
                JOptionPane.showMessageDialog(null, "cuenta guardada correctamente.");
                CargarTablasEnMemoria();
                cargarTodosLosDatos();
        }
        else{
                JOptionPane.showMessageDialog(null, "cuenta guardada.");
                cargarTodosLosDatos();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Cuenta c = new Cuenta();
        Rubro  r=new Rubro();
        BigDecimal cMayor;
 
        c.setIdCuenta(BigDecimal.valueOf(Double.parseDouble(jTextField_panel3_idcuenta.getText())));
  
        int separador = jComboBox_panel3_estado.getSelectedItem().toString().indexOf("-");
        String x = jComboBox_panel3_estado.getSelectedItem().toString().substring(0, separador);
        c.setEstado(estadoDAO.obtenerEstadoByID(x));
        
        separador = jComboBox_panel3_rubro.getSelectedItem().toString().indexOf("-");
        x = jComboBox_panel3_rubro.getSelectedItem().toString().substring(0, separador);
        c.setRubro(rubroDAO.obtenerRubroByID(x));
        
        
        c.setNombreCuenta(jTextField_panel3_nombre.getText());
        
        
        separador = jComboBox_panel3_cuentaMayor.getSelectedItem().toString().indexOf("-");
        x = jComboBox_panel3_cuentaMayor.getSelectedItem().toString().substring(0, separador);
        c.setCuentaMayor(cuentaDAO.obtenerCuentaByID(x).getIdCuenta());
        
        JOptionPane.showMessageDialog(null, c.getIdCuenta()+" "+c.getEstado().getIdEstado()+" "+c.getRubro().getIdRubro()+" "+c.getNombreCuenta()+" "+c.getCuentaMayor());
        if(cuentaDAO.updateCuenta(c)){
                JOptionPane.showMessageDialog(null, "cuenta actualizada correctamente.");
                CargarTablasEnMemoria();
                cargarTodosLosDatos();
        }
        else
                JOptionPane.showMessageDialog(null, "cuenta no se pudo actualizar.");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable_panel3_catalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_panel3_catalogoMouseClicked
        
        jTextField_panel3_idcuenta.setText(jTable_panel3_catalogo.getValueAt(jTable_panel3_catalogo.getSelectedRow(), 0).toString());
        jTextField_panel3_nombre.setText(jTable_panel3_catalogo.getValueAt(jTable_panel3_catalogo.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_jTable_panel3_catalogoMouseClicked

    private void jComboBox_panel3_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_panel3_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_panel3_estadoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        if(cuentaDAO.deleteCuenta(BigDecimal.valueOf(Double.parseDouble(jTextField_panel4_idcuenta.getText())))){
                JOptionPane.showMessageDialog(null, "cuenta borrada correctamente.");
                CargarTablasEnMemoria();
                cargarTodosLosDatos();
        }
        else
                JOptionPane.showMessageDialog(null, "cuenta no se puede borrar \n Revise que no se este ocupando en ninguna transaccion.");
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable_panel4_catalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_panel4_catalogoMouseClicked
        
           jTextField_panel4_idcuenta.setText(jTable_panel4_catalogo.getValueAt(jTable_panel4_catalogo.getSelectedRow(), 0).toString());
           jTextField_panel4_nombre.setText(jTable_panel4_catalogo.getValueAt(jTable_panel4_catalogo.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_jTable_panel4_catalogoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox_panel2_cuentaMayor;
    private javax.swing.JComboBox jComboBox_panel2_estadosFinancieros;
    private javax.swing.JComboBox jComboBox_panel2_rubros;
    private javax.swing.JComboBox jComboBox_panel3_cuentaMayor;
    private javax.swing.JComboBox jComboBox_panel3_estado;
    private javax.swing.JComboBox jComboBox_panel3_rubro;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTabbedPane jTabbedPane_cuenta;
    private javax.swing.JTable jTable_panel1_catalogo;
    private javax.swing.JTable jTable_panel3_catalogo;
    private javax.swing.JTable jTable_panel4_catalogo;
    private javax.swing.JTextField jTextField_panel2_idcuenta;
    private javax.swing.JTextField jTextField_panel2_nombrecuenta;
    private javax.swing.JTextField jTextField_panel3_idcuenta;
    private javax.swing.JTextField jTextField_panel3_nombre;
    private javax.swing.JTextField jTextField_panel4_idcuenta;
    private javax.swing.JTextField jTextField_panel4_nombre;
    // End of variables declaration//GEN-END:variables
}
