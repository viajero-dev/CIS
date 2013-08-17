/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.Sibling;
import com.vg.scfc.financing.cis.ui.controller.SiblingController;
import com.vg.scfc.financing.cis.ui.panel.MainPanel;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class SiblingsPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form SiblingsPanel
     */
    public SiblingsPanel() {
        initComponents();
        startUpSettings();
    }

    private void startUpSettings() {
        setFieldsEditable(false);
        initTextBoxesListener();
        initTableSibling();
    }

    /**
     * Set TextBox Listener
     */
    private void initTextBoxesListener() {
        txtSiblingName.addKeyListener(this);
        txtSiblingAddress.addKeyListener(this);
        txtSiblingContact.addKeyListener(this);
    }

    private void initTableSibling() {
        tableSibling.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableSibling.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tableSibling.getSelectedRow();
                    if (selectedIndex >= 0) {
                        Sibling s = siblings.get(selectedIndex);
                        if (s != null) {
                            setSibling(s);
                        }
                    }
                } catch (Exception e) {
                    UIValidator.log(e, MainPanel.class);
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

        siblings = ObservableCollections.observableList(new LinkedList<Sibling>());
        jLabel1 = new javax.swing.JLabel();
        txtSiblingName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSiblingAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSiblingContact = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSibling = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 105, -1, -1));

        txtSiblingName.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtSiblingName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSiblingNameFocusLost(evt);
            }
        });
        add(txtSiblingName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 255, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Address");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtSiblingAddress.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtSiblingAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSiblingAddressFocusLost(evt);
            }
        });
        add(txtSiblingAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 125, 255, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Contact");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, -1, -1));

        txtSiblingContact.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtSiblingContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSiblingContactFocusLost(evt);
            }
        });
        add(txtSiblingContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 140, -1));

        tableSibling.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, siblings, tableSibling);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${siblingName}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${siblingContactNo}"));
        columnBinding.setColumnName("Contact #");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tableSibling);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 390, 90));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSiblingNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSiblingNameFocusLost
        txtSiblingName.setText(UIValidator.validate(txtSiblingName));
    }//GEN-LAST:event_txtSiblingNameFocusLost

    private void txtSiblingAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSiblingAddressFocusLost
        txtSiblingAddress.setText(UIValidator.validate(txtSiblingAddress));
    }//GEN-LAST:event_txtSiblingAddressFocusLost

    private void txtSiblingContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSiblingContactFocusLost
        txtSiblingContact.setText(UIValidator.isNumeric(txtSiblingContact));
    }//GEN-LAST:event_txtSiblingContactFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Sibling> siblings;
    private javax.swing.JTable tableSibling;
    private javax.swing.JTextField txtSiblingAddress;
    private javax.swing.JTextField txtSiblingContact;
    private javax.swing.JTextField txtSiblingName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private Sibling sibling;
    private MainPanel mainPanel;
    private HeaderPanel headerPanel;
    private int selectedIndex = -1;

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setSibling(Sibling sibling) {
        if (sibling == null) {
            sibling = new Sibling();
        }
        this.sibling = sibling;
        setSiblingInfo(this.sibling);
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
                if (txtSiblingName.isFocusOwner()) {
                txtSiblingAddress.requestFocus();
            } else if (txtSiblingAddress.isFocusOwner()) {
                txtSiblingContact.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtSiblingContact.isFocusOwner()) {
                txtSiblingAddress.requestFocus();
            } else if (txtSiblingAddress.isFocusOwner()) {
                txtSiblingName.requestFocus();
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtSiblingName.setEditable(value);
        txtSiblingAddress.setEditable(value);
        txtSiblingContact.setEditable(value);
        
        txtSiblingName.setFocusable(value);
        txtSiblingAddress.setFocusable(value);
        txtSiblingContact.setFocusable(value);
        tableSibling.setFocusable(value);
        
        if(value) {
            txtSiblingName.requestFocus();
        }
    }

    public void resetToDefault() {
        txtSiblingName.setText("");
        txtSiblingAddress.setText("");
        txtSiblingContact.setText("");
    }

    public void setSiblingInfo(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            Sibling s = (Sibling) o;
            txtSiblingName.setText(s.getSiblingName());
            txtSiblingAddress.setText(s.getSiblingAddress());
            txtSiblingContact.setText(s.getSiblingContactNo());
        }
    }

    public boolean saveSibling() {
        List<Sibling> s = SiblingController.getInstance().createNew(createNew(new Sibling()), headerPanel.getFormNo());
        refreshTable(s);
        return !s.isEmpty();
    }

    public boolean updateSibling() {
        List<Sibling> s = SiblingController.getInstance().update(headerPanel.getFormNo(), createNew(this.sibling));
        refreshTable(s);
        return !s.isEmpty();
    }

    public void refreshTable(List<Sibling> s) {
        if (!s.isEmpty()) {
            siblings.clear();
            siblings.addAll(s);
            tableSibling.setRowSelectionInterval(0, 0);
        } else {
            resetToDefault();
        }
    }

    public Sibling createNew(Sibling s) {
        s.setSiblingName(txtSiblingName.getText());
        s.setSiblingAddress(txtSiblingAddress.getText());
        s.setSiblingContactNo(txtSiblingContact.getText());
        return s;
    }
}
