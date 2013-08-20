/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.commons.util.NumberUtils;
import com.vg.scfc.financing.cis.ent.CreditRef;
import com.vg.scfc.financing.cis.ui.controller.CreditReferenceController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class CreditReferencePanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form CreditReferencePanel
     */
    public CreditReferencePanel() {
        initComponents();
        startUpSettings();
    }

    private void startUpSettings() {
        setFieldsEditable(false);
        initTextBoxesListener();
        initCreditReferenceTable();
    }

    private void initCreditReferenceTable() {
        tableCreditReference.putClientProperty("Quaqua.Table.style", "striped" );
        tableCreditReference.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCreditReference.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tableCreditReference.getSelectedRow();
                    if (selectedIndex >= 0) {
                        setCreditReference(creditReferences.get(selectedIndex));
                    }
                } catch (Exception e) {
                    UIValidator.log(e, CreditReferencePanel.class);
                }
            }
        });
    }

    /**
     * Set TextBoxes KeyListener
     */
    private void initTextBoxesListener() {
        txtCRName.addKeyListener(this);
        txtCRItemOnCredit.addKeyListener(this);
        txtCRLoanAmount.addKeyListener(this);
        txtCRMonthlyAmort.addKeyListener(this);
        txtCRTerm.addKeyListener(this);
        txtCRAmountPaid.addKeyListener(this);
        txtCRRemainingBal.addKeyListener(this);
        txtCRAddress.addKeyListener(this);
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

        creditReferences = ObservableCollections.observableList(new LinkedList<CreditRef>());
        jLabel1 = new javax.swing.JLabel();
        txtCRName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCRItemOnCredit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCRLoanAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCRMonthlyAmort = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCRTerm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCRAmountPaid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCRRemainingBal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCRAddress = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCreditReference = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 105, -1, -1));

        txtCRName.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRNameFocusLost(evt);
            }
        });
        add(txtCRName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 359, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Item on credit");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 155, -1, -1));

        txtCRItemOnCredit.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRItemOnCredit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRItemOnCreditFocusLost(evt);
            }
        });
        add(txtCRItemOnCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 127, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Loan Amount");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 155, -1, -1));

        txtCRLoanAmount.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRLoanAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRLoanAmountFocusLost(evt);
            }
        });
        add(txtCRLoanAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 127, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Monthly Amort.");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, -1, -1));

        txtCRMonthlyAmort.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRMonthlyAmort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRMonthlyAmortFocusLost(evt);
            }
        });
        add(txtCRMonthlyAmort, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 175, 127, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Term");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        txtCRTerm.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRTerm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRTermFocusLost(evt);
            }
        });
        add(txtCRTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 175, 127, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Amount paid");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 205, -1, -1));

        txtCRAmountPaid.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRAmountPaid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRAmountPaidFocusLost(evt);
            }
        });
        add(txtCRAmountPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 127, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Remaining Bal.");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 205, -1, -1));

        txtCRRemainingBal.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRRemainingBal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRRemainingBalFocusLost(evt);
            }
        });
        add(txtCRRemainingBal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 127, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("Address");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, -1, -1));

        txtCRAddress.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCRAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCRAddressFocusLost(evt);
            }
        });
        add(txtCRAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 125, 359, -1));

        tableCreditReference.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, creditReferences, tableCreditReference);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${creRefName}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${creRefAddress}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(tableCreditReference);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 980, 90));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCRItemOnCreditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRItemOnCreditFocusLost
        txtCRItemOnCredit.setText(UIValidator.validate(txtCRItemOnCredit));
    }//GEN-LAST:event_txtCRItemOnCreditFocusLost

    private void txtCRMonthlyAmortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRMonthlyAmortFocusLost
        txtCRMonthlyAmort.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtCRMonthlyAmort)).doubleValue()));
    }//GEN-LAST:event_txtCRMonthlyAmortFocusLost

    private void txtCRAmountPaidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRAmountPaidFocusLost
        txtCRAmountPaid.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtCRAmountPaid)).doubleValue()));
    }//GEN-LAST:event_txtCRAmountPaidFocusLost

    private void txtCRLoanAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRLoanAmountFocusLost
        txtCRLoanAmount.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtCRLoanAmount)).doubleValue()));
    }//GEN-LAST:event_txtCRLoanAmountFocusLost

    private void txtCRTermFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRTermFocusLost
        txtCRTerm.setText(UIValidator.validate(txtCRTerm));
    }//GEN-LAST:event_txtCRTermFocusLost

    private void txtCRRemainingBalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRRemainingBalFocusLost
        txtCRRemainingBal.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtCRRemainingBal)).doubleValue()));
    }//GEN-LAST:event_txtCRRemainingBalFocusLost

    private void txtCRNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRNameFocusLost
        txtCRName.setText(UIValidator.validate(txtCRName));
    }//GEN-LAST:event_txtCRNameFocusLost

    private void txtCRAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCRAddressFocusLost
        txtCRAddress.setText(UIValidator.validate(txtCRAddress));
    }//GEN-LAST:event_txtCRAddressFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<CreditRef> creditReferences;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableCreditReference;
    private javax.swing.JTextField txtCRAddress;
    private javax.swing.JTextField txtCRAmountPaid;
    private javax.swing.JTextField txtCRItemOnCredit;
    private javax.swing.JTextField txtCRLoanAmount;
    private javax.swing.JTextField txtCRMonthlyAmort;
    private javax.swing.JTextField txtCRName;
    private javax.swing.JTextField txtCRRemainingBal;
    private javax.swing.JTextField txtCRTerm;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private int selectedIndex;
    private CreditRef creditReference;
    private HeaderPanel headerPanel;

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setCreditReference(CreditRef creditReference) {
        this.creditReference = creditReference;
        setCreditReferenceData(this.creditReference);
    }

    public void setTableCreditReference(JTable tableCreditReference) {
        this.tableCreditReference = tableCreditReference;
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
                if (txtCRName.isFocusOwner()) {
                txtCRAddress.requestFocus();
            } else if (txtCRAddress.isFocusOwner()) {
                txtCRItemOnCredit.requestFocus();
            } else if (txtCRItemOnCredit.isFocusOwner()) {
                txtCRLoanAmount.requestFocus();
            } else if (txtCRLoanAmount.isFocusOwner()) {
                txtCRMonthlyAmort.requestFocus();
            } else if (txtCRMonthlyAmort.isFocusOwner()) {
                txtCRTerm.requestFocus();
            } else if (txtCRTerm.isFocusOwner()) {
                txtCRAmountPaid.requestFocus();
            } else if (txtCRAmountPaid.isFocusOwner()) {
                txtCRRemainingBal.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtCRRemainingBal.isFocusOwner()) {
                txtCRAmountPaid.requestFocus();
            } else if (txtCRAmountPaid.isFocusOwner()) {
                txtCRTerm.requestFocus();
            } else if (txtCRTerm.isFocusOwner()) {
                txtCRMonthlyAmort.requestFocus();
            } else if (txtCRMonthlyAmort.isFocusOwner()) {
                txtCRLoanAmount.requestFocus();
            } else if (txtCRLoanAmount.isFocusOwner()) {
                txtCRItemOnCredit.requestFocus();
            } else if (txtCRItemOnCredit.isFocusOwner()) {
                txtCRAddress.requestFocus();
            } else if (txtCRAddress.isFocusOwner()) {
                txtCRName.requestFocus();
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtCRName.setEditable(value);
        txtCRAddress.setEditable(value);
        txtCRItemOnCredit.setEditable(value);
        txtCRLoanAmount.setEditable(value);
        txtCRMonthlyAmort.setEditable(value);
        txtCRTerm.setEditable(value);
        txtCRAmountPaid.setEditable(value);
        txtCRRemainingBal.setEditable(value);

        txtCRName.setFocusable(value);
        txtCRAddress.setFocusable(value);
        txtCRItemOnCredit.setFocusable(value);
        txtCRLoanAmount.setFocusable(value);
        txtCRMonthlyAmort.setFocusable(value);
        txtCRTerm.setFocusable(value);
        txtCRAmountPaid.setFocusable(value);
        txtCRRemainingBal.setFocusable(value);
        tableCreditReference.setFocusable(value);
        
        if(value) {
            txtCRName.requestFocus();
        }
    }

    public void resetToDefault() {
        txtCRName.setText("");
        txtCRAddress.setText("");
        txtCRItemOnCredit.setText("");
        txtCRLoanAmount.setText("");
        txtCRMonthlyAmort.setText("");
        txtCRTerm.setText("");
        txtCRAmountPaid.setText("");
        txtCRRemainingBal.setText("");
    }

    public void setCreditReferenceData(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            CreditRef cr = (CreditRef) o;
            txtCRName.setText(cr.getCreRefName());
            txtCRAddress.setText(cr.getCreRefAddress());
            txtCRItemOnCredit.setText(cr.getCreItem());
            txtCRLoanAmount.setText(new BigDecimal(cr.getCreRefLoanAmount()).toPlainString());
            txtCRMonthlyAmort.setText(new BigDecimal(cr.getCreRefMonthly()).toPlainString());
            txtCRTerm.setText(cr.getCreRefTerm());
            txtCRAmountPaid.setText(new BigDecimal(cr.getCreRefAmountPaid()).toPlainString());
            txtCRRemainingBal.setText(new BigDecimal(cr.getCreRefBalance()).toPlainString());
        }
    }

    public boolean saveCreditReference() {
        List<CreditRef> c = CreditReferenceController.getInstance().createNew(createNew(new CreditRef()), headerPanel.getFormNo());
        refreshTable(c);
        return !c.isEmpty();
    }

    public boolean updateCreditReference() {
        List<CreditRef> c = CreditReferenceController.getInstance().update(headerPanel.getFormNo(), createNew(creditReference));
        refreshTable(c);
        return !c.isEmpty();
    }

    public void refreshTable(List<CreditRef> c) {
        creditReferences.clear();
        creditReferences.addAll(c);
        if (!creditReferences.isEmpty()) {
            tableCreditReference.setRowSelectionInterval(0, 0);
        } else {
            resetToDefault();
        }
    }

    public CreditRef createNew(CreditRef c) {
        c.setCreRefName(txtCRName.getText());
        c.setCreRefAddress(txtCRAddress.getText());
        c.setCreItem(txtCRItemOnCredit.getText());
        c.setCreRefLoanAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtCRLoanAmount.getText())).doubleValue());
        c.setCreRefMonthly(new BigDecimal(UIValidator.MoneyCommaRemover(txtCRMonthlyAmort.getText())).doubleValue());
        c.setCreRefTerm(txtCRTerm.getText());
        c.setCreRefAmountPaid(new BigDecimal(UIValidator.MoneyCommaRemover(txtCRAmountPaid.getText())).doubleValue());
        c.setCreRefBalance(new BigDecimal(UIValidator.MoneyCommaRemover(txtCRRemainingBal.getText())).doubleValue());
        return c;
    }
}
