/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.PersonalInfo;
import com.vg.scfc.financing.cis.ui.controller.PersonalInfoController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class SearchPersonalInfoPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchPersonalInfoPanel
     */
    public SearchPersonalInfoPanel() {
        initComponents();
        initTablePersonalInfo();
        txtSearch.putClientProperty("Quaqua.TextField.style", "search");
        txtSearch.setText("Search");
        initSearchListener();
    }

    private void initSearchListener() {
        txtSearch.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        refreshTable(PersonalInfoController.getInstance().findBySearchCriteria(txtSearch.getText()));
                        break;
                }
            }

        });

        tablePersonalInfo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_F5:
                        dialog.setVisible(false);
                        break;
                }
            }

        });
    }

    private void initTablePersonalInfo() {
        tablePersonalInfo.putClientProperty("Quaqua.Table.style", "striped");
        tablePersonalInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablePersonalInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tablePersonalInfo.getSelectedRow();
                    if (selectedIndex >= 0) {
                        setPersonalInfo(personalInfos.get(selectedIndex));
                    }
                } catch (Exception e) {
                    UIValidator.log(e, CharacterReferenceDependentPanel.class);
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

        personalInfos = ObservableCollections.observableList(new LinkedList<PersonalInfo>());
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonalInfo = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 230, -1));

        tablePersonalInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablePersonalInfo.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, personalInfos, tablePersonalInfo);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${clientNo}"));
        columnBinding.setColumnName("Client #");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fullName}"));
        columnBinding.setColumnName("Full Name");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tablePersonalInfo);
        tablePersonalInfo.getColumnModel().getColumn(0).setPreferredWidth(75);
        tablePersonalInfo.getColumnModel().getColumn(0).setMaxWidth(75);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 30, 370, 250));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 3, 130, -1));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        refreshTable(PersonalInfoController.getInstance().findBySearchCriteria(txtSearch.getText()));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.selectAll();
    }//GEN-LAST:event_txtSearchFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<PersonalInfo> personalInfos;
    private javax.swing.JTable tablePersonalInfo;
    private javax.swing.JTextField txtSearch;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private int selectedIndex = 0;
    private PersonalInfo personalInfo;
    private JDialog dialog;

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
    
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    private void refreshTable(List<PersonalInfo> p) {
        personalInfos.clear();
        personalInfos.addAll(p);
        if (!personalInfos.isEmpty()) {
            tablePersonalInfo.setRowSelectionInterval(0, 0);
        }
    }
}
