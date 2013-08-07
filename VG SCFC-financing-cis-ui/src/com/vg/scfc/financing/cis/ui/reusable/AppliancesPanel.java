/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.Appliance;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;
import com.vg.scfc.financing.cis.ui.controller.ApplianceAssetsController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;

/**
 *
 * @author rodel
 */
public class AppliancesPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form AppliancesPanel
     */
    public AppliancesPanel() {
        initComponents();
        startUpSettings();
    }

    private void initKeyListeners() {
        comboApplianceType.addKeyListener(this);
        txtEstValue.addKeyListener(this);
    }
    
    private void startUpSettings() {
        setFieldsEditable(false);
        initKeyListeners();
        initApplianceTable();
    }
    
    private void initApplianceTable() {
        tableAppliance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAppliance.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tableAppliance.getSelectedRow();
                    if (selectedIndex >= 0) {
                        setApplianceAsset(appliances.get(selectedIndex));
                    }
                } catch (Exception e) {
                    UIValidator.log(e, AppliancesPanel.class);
                }
            }
        });
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

        appliances = ObservableCollections.observableList(new LinkedList<Appliance>());
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAppliance = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        comboApplianceType = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtEstValue = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalEstValue = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, appliances, tableAppliance);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${type}"));
        columnBinding.setColumnName("Type");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tableAppliance);
        tableAppliance.getColumnModel().getColumn(0).setResizable(false);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 433, 90));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Type:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        comboApplianceType.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        comboApplianceType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Television", "Refrigerator", "Washing Machine", "Aircon Unit", "Computer", "DVD/VCD", "Others" }));
        comboApplianceType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboApplianceTypeItemStateChanged(evt);
            }
        });
        add(comboApplianceType, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 105, 144, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Est. value");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        txtEstValue.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtEstValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstValueFocusLost(evt);
            }
        });
        add(txtEstValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 105, 140, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Total Est. value");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 135, -1, -1));

        txtTotalEstValue.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtTotalEstValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 140, -1));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEstValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstValueFocusLost
        estimatedValue = new BigDecimal(UIValidator.isNumeric(txtEstValue));
    }//GEN-LAST:event_txtEstValueFocusLost

    private void comboApplianceTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboApplianceTypeItemStateChanged
        switch (comboApplianceType.getSelectedIndex()) {
            case 0:
                type = "TELEVISION";
                break;
            case 1:
                type = "REFRIGERATOR";
                break;
            case 2:
                type = "WASHING MACHINE";
                break;
            case 3:
                type = "AIRCON UNIT";
                break;
            case 4:
                type = "COMPUTER";
                break;
            case 5:
                type = "DVD/VCD";
                break;
            case 6:
                do {
                type = JOptionPane.showInputDialog(null, "Enter Type:", "SYSTEM MESSAGE", JOptionPane.QUESTION_MESSAGE);
            } while (!type.equals(""));

        }
    }//GEN-LAST:event_comboApplianceTypeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<Appliance> appliances;
    private javax.swing.JComboBox comboApplianceType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAppliance;
    private javax.swing.JTextField txtEstValue;
    private javax.swing.JTextField txtTotalEstValue;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private String type;
    private BigDecimal estimatedValue;
    private int selectedIndex;

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
                if (comboApplianceType.isFocusOwner()) {
                txtEstValue.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtEstValue.isFocusOwner()) {
                comboApplianceType.requestFocus();
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        comboApplianceType.setEnabled(value);
        txtEstValue.setEditable(value);
    }

    public void resetToDefault() {
        comboApplianceType.setSelectedIndex(0);
        txtEstValue.setText("");
    }

    public void setApplianceAsset(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            Appliance a = (Appliance) o;
            switch (a.getType()) {
                case "TELEVISION":
                    comboApplianceType.setSelectedIndex(0);
                    break;
                case "REFRIGERATOR":
                    comboApplianceType.setSelectedIndex(1);
                    break;
                case "WASHING MACHINE":
                    comboApplianceType.setSelectedIndex(2);
                    break;
                case "AIRCON UNIT":
                    comboApplianceType.setSelectedIndex(3);
                    break;
                case "COMPUTER":
                    comboApplianceType.setSelectedIndex(4);
                    break;
                case "DVD/VCD":
                    comboApplianceType.setSelectedIndex(5);
                    break;
                default:
                    comboApplianceType.setSelectedIndex(6);
                    break;
            }
            txtEstValue.setText(a.getAmount() + "");
        }
    }

    public boolean saveApplianceAsset() {
        Object o = ApplianceAssetsController.getInstance().createNew(type, estimatedValue);
        setApplianceAsset(o);
        return o != null;
    }

    public boolean updateApplianceAsset() {
        Object o = ApplianceAssetsController.getInstance().update("", type, estimatedValue);
        setApplianceAsset(o);
        return o != null;
    }
    
    public void refreshTable(List<Appliance> a) {
        appliances.clear();
        appliances.addAll(a);
        if(!appliances.isEmpty()) {
            tableAppliance.setRowSelectionInterval(0, 0);
        }
    }

}
