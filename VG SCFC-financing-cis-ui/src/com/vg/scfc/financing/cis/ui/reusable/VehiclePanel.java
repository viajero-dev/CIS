/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.Vehicle;
import com.vg.scfc.financing.cis.ui.controller.VehicleAssetsController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class VehiclePanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form VehiclePanel
     */
    public VehiclePanel() {
        initComponents();
        startUpSettings();
    }

    private void startUpSettings() {
        setFieldsEditable(false);
        initKeyListeners();
        initVehicleTable();
    }

    private void initVehicleTable() {
        tableVehicle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableVehicle.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tableVehicle.getSelectedRow();
                    if (selectedIndex >= 0) {
                        setVehicle(vehicles.get(selectedIndex));
                    }
                } catch (Exception e) {
                    UIValidator.log(e, VehiclePanel.class);
                }
            }
        });
    }

    /**
     * Set KeyListeners
     */
    private void initKeyListeners() {
        txtTypeModel.addKeyListener(this);
        txtYrsUsed.addKeyListener(this);
        comboUsed.addKeyListener(this);
        txtEstValue.addKeyListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        vehicles = ObservableCollections.observableList(new LinkedList<Vehicle>());
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVehicle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTypeModel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtYrsUsed = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEstValue = new javax.swing.JTextField();
        comboUsed = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableVehicle.setColumnSelectionAllowed(true);
        tableVehicle.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, vehicles, tableVehicle);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${type}"));
        columnBinding.setColumnName("Type/Model");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${age}"));
        columnBinding.setColumnName("Years of Age");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${use}"));
        columnBinding.setColumnName("Used As");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tableVehicle);
        tableVehicle.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableVehicle.getColumnModel().getColumn(1).setPreferredWidth(90);
        tableVehicle.getColumnModel().getColumn(1).setMaxWidth(90);
        tableVehicle.getColumnModel().getColumn(2).setPreferredWidth(95);
        tableVehicle.getColumnModel().getColumn(2).setMaxWidth(95);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 600, 90));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Type/Model");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, -1, -1));

        txtTypeModel.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtTypeModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTypeModelFocusLost(evt);
            }
        });
        add(txtTypeModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 115, 255, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Yrs. Used");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 145, -1, -1));

        txtYrsUsed.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtYrsUsed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtYrsUsedFocusLost(evt);
            }
        });
        add(txtYrsUsed, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 140, 80, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Use as");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 145, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Est. Value");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 170, -1, -1));

        txtEstValue.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtEstValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstValueFocusLost(evt);
            }
        });
        add(txtEstValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 165, 255, -1));

        comboUsed.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        comboUsed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Public", "Private" }));
        add(comboUsed, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 140, 120, -1));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void txtYrsUsedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYrsUsedFocusLost
        yearsUsed = new BigDecimal(UIValidator.isNumeric(txtYrsUsed));
    }//GEN-LAST:event_txtYrsUsedFocusLost

    private void txtTypeModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeModelFocusLost
        typeModel = UIValidator.validate(txtTypeModel);
    }//GEN-LAST:event_txtTypeModelFocusLost

    private void txtEstValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstValueFocusLost
        estimatedValue = new BigDecimal(UIValidator.isNumeric(txtEstValue));
    }//GEN-LAST:event_txtEstValueFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboUsed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVehicle;
    private javax.swing.JTextField txtEstValue;
    private javax.swing.JTextField txtTypeModel;
    private javax.swing.JTextField txtYrsUsed;
    private java.util.List<Vehicle> vehicles;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private BigDecimal yearsUsed;
    private String typeModel;
    private BigDecimal estimatedValue;
    private String use;
    private int selectedIndex;
    private String formNo;
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        setVechicleInfo(this.vehicle);
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        refreshTable(this.vehicles);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (txtTypeModel.isFocusOwner()) {
                txtYrsUsed.requestFocus();
            } else if (txtYrsUsed.isFocusOwner()) {
                comboUsed.requestFocus();
            } else if (comboUsed.isFocusOwner()) {
                txtEstValue.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtEstValue.isFocusOwner()) {
                comboUsed.requestFocus();
            } else if (comboUsed.isFocusOwner()) {
                txtYrsUsed.requestFocus();
            } else if (txtYrsUsed.isFocusOwner()) {
                txtTypeModel.requestFocus();
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtTypeModel.setEditable(value);
        txtYrsUsed.setEditable(value);
        comboUsed.setEnabled(value);
        txtEstValue.setEditable(value);
    }

    public void resetToDefault() {
        txtTypeModel.setText("");
        txtYrsUsed.setText("");
        comboUsed.setSelectedIndex(0);
        txtEstValue.setText("");
    }

    public void setVechicleInfo(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            Vehicle v = (Vehicle) o;
            txtTypeModel.setText(v.getType());
            txtYrsUsed.setText(v.getAge() + "");
            switch (v.getUse()) {
                case "PUBLIC":
                    comboUsed.setSelectedIndex(0);
                    break;
                case "PRIVATE":
                    comboUsed.setSelectedIndex(1);
                    break;
            }
            txtEstValue.setText(new BigDecimal(v.getAmount()).toPlainString());
        }
    }

    public boolean saveVehicleAsset() {
        List<Vehicle> v = VehicleAssetsController.getInstance().createNew(formNo, createNew(new Vehicle()));
        setVehicles(v);
        return !v.isEmpty();
    }

    public boolean updateVehicleAsset() {
        List<Vehicle> v = VehicleAssetsController.getInstance().update(formNo, createNew(vehicle));
        setVehicles(v);
        return !v.isEmpty();
    }

    public void refreshTable(List<Vehicle> v) {
        vehicles.clear();
        vehicles.addAll(v);
        if (!vehicles.isEmpty()) {
            tableVehicle.setRowSelectionInterval(0, 0);
        }
    }

    public Vehicle createNew(Vehicle v) {
        v.setType(txtTypeModel.getText());
        v.setAge(Integer.parseInt(txtYrsUsed.getText()));
        v.setUse((String) comboUsed.getSelectedItem());
        v.setAmount(new BigDecimal(txtEstValue.getText()).doubleValue());
        return v;
    }

}
