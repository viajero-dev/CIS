/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.commons.util.DateUtil;
import com.vg.commons.util.NumberUtils;
import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.ui.controller.PurchaseOrderController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

/**
 *
 * @author rodel
 */
public class PurchaseOrderPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form PurchaseOrderPanel
     */
    public PurchaseOrderPanel() {
        initComponents();
        startUpSettings();
    }

    private void startUpSettings() {
        initKeyListener();
    }

    private void initKeyListener() {
        txtUnitApplied.addKeyListener(this);
        txtDownpayment.addKeyListener(this);
        txtInsurance.addKeyListener(this);
        txtTerm.addKeyListener(this);
        txtAmort.addKeyListener(this);
        comboMotorStatus.addKeyListener(this);
        comboPurpose.addKeyListener(this);
        txtRemarks.addKeyListener(this);
        checkApproved.addKeyListener(this);
        checkDisApproved.addKeyListener(this);
    }
    
    private void resetCombos() {
        comboMotorStatus.removeAllItems();
        comboMotorStatus.addItem("REPO");
        comboMotorStatus.addItem("BRAND NEW");
        
        comboPurpose.removeAllItems();
        comboPurpose.addItem("PERSONAL");
        comboPurpose.addItem("BUSINESS");
        comboPurpose.addItem("OTHERS");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUnitApplied = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        txtDownpayment = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        txtInsurance = new javax.swing.JTextField();
        txtTerm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRemarks = new javax.swing.JTextField();
        comboPurpose = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboMotorStatus = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAmort = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        checkApproved = new javax.swing.JCheckBox();
        checkDisApproved = new javax.swing.JCheckBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Unit Applied");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        txtUnitApplied.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtUnitApplied.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUnitAppliedFocusLost(evt);
            }
        });
        add(txtUnitApplied, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 5, 170, -1));

        jLabel100.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel100.setText("Downpayment");
        add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));

        txtDownpayment.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtDownpayment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDownpaymentFocusLost(evt);
            }
        });
        add(txtDownpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 30, 157, -1));

        jLabel101.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel101.setText("Insurance");
        add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        txtInsurance.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtInsurance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInsuranceFocusLost(evt);
            }
        });
        add(txtInsurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 55, 157, -1));

        txtTerm.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtTerm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTermFocusLost(evt);
            }
        });
        add(txtTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 5, 90, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Term");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, -1, -1));

        txtRemarks.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtRemarks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRemarksFocusLost(evt);
            }
        });
        add(txtRemarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 230, -1));

        comboPurpose.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        comboPurpose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PERSONAL", "BUSINESS", "OTHERS" }));
        add(comboPurpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 5, 140, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Purpose");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        comboMotorStatus.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        comboMotorStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REPO", "BRAND NEW" }));
        add(comboMotorStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 55, 140, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("M A");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 35, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Status");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        txtAmort.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtAmort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmortFocusLost(evt);
            }
        });
        add(txtAmort, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 30, 140, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Remarks");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 35, -1, -1));

        checkApproved.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        checkApproved.setText("APPROVED");
        checkApproved.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkApprovedItemStateChanged(evt);
            }
        });
        add(checkApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 55, -1, -1));

        checkDisApproved.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        checkDisApproved.setForeground(new java.awt.Color(203, 28, 28));
        checkDisApproved.setText("DISAPPROVED");
        checkDisApproved.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkDisApprovedItemStateChanged(evt);
            }
        });
        add(checkDisApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 55, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void checkApprovedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkApprovedItemStateChanged
        if (checkApproved.isSelected()) {
            checkApproved.setSelected(true);
            checkDisApproved.setSelected(false);
        }
    }//GEN-LAST:event_checkApprovedItemStateChanged

    private void txtUnitAppliedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUnitAppliedFocusLost
        txtUnitApplied.setText(UIValidator.validate(txtUnitApplied));
    }//GEN-LAST:event_txtUnitAppliedFocusLost

    private void txtDownpaymentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDownpaymentFocusLost
        txtDownpayment.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtDownpayment)).doubleValue()));
    }//GEN-LAST:event_txtDownpaymentFocusLost

    private void txtInsuranceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInsuranceFocusLost
        txtInsurance.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtInsurance)).doubleValue()));
    }//GEN-LAST:event_txtInsuranceFocusLost

    private void txtTermFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTermFocusLost
        txtTerm.setText(UIValidator.isNumeric(txtTerm));
    }//GEN-LAST:event_txtTermFocusLost

    private void txtAmortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmortFocusLost
        txtAmort.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtAmort)).doubleValue()));
    }//GEN-LAST:event_txtAmortFocusLost

    private void txtRemarksFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemarksFocusLost
        txtRemarks.setText(UIValidator.validate(txtRemarks));
    }//GEN-LAST:event_txtRemarksFocusLost

    private void checkDisApprovedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkDisApprovedItemStateChanged
        if (checkDisApproved.isSelected()) {
            checkApproved.setSelected(false);
            checkDisApproved.setSelected(true);
        }
    }//GEN-LAST:event_checkDisApprovedItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkApproved;
    private javax.swing.JCheckBox checkDisApproved;
    private javax.swing.JComboBox comboMotorStatus;
    private javax.swing.JComboBox comboPurpose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAmort;
    private javax.swing.JTextField txtDownpayment;
    private javax.swing.JTextField txtInsurance;
    private javax.swing.JTextField txtRemarks;
    private javax.swing.JTextField txtTerm;
    private javax.swing.JTextField txtUnitApplied;
    // End of variables declaration//GEN-END:variables
    private PurchaseOrder purchaseOrder;
    private HeaderPanel headerPanel;

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        setPurchaseOrderInfo(this.purchaseOrder);
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
                if (txtUnitApplied.isFocusOwner()) {
                txtDownpayment.requestFocus();
            } else if (txtDownpayment.isFocusOwner()) {
                txtInsurance.requestFocus();
            } else if (txtInsurance.isFocusOwner()) {
                txtTerm.requestFocus();
            } else if (txtTerm.isFocusOwner()) {
                txtAmort.requestFocus();
            } else if (txtAmort.isFocusOwner()) {
                comboMotorStatus.requestFocus();
            } else if (comboMotorStatus.isFocusOwner()) {
                comboPurpose.requestFocus();
            } else if (comboPurpose.isFocusOwner()) {
                txtRemarks.requestFocus();
            } else if (txtRemarks.isFocusOwner()) {
                checkApproved.requestFocus();
            } else if (checkApproved.isFocusOwner()) {
                checkDisApproved.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (checkDisApproved.isFocusOwner()) {
                checkApproved.requestFocus();
            } else if (checkApproved.isFocusOwner()) {
                txtRemarks.requestFocus();
            } else if (txtRemarks.isFocusOwner()) {
                comboPurpose.requestFocus();
            } else if (comboPurpose.isFocusOwner()) {
                comboMotorStatus.requestFocus();
            } else if (comboMotorStatus.isFocusOwner()) {
                txtAmort.requestFocus();
            } else if (txtAmort.isFocusOwner()) {
                txtTerm.requestFocus();
            } else if (txtTerm.isFocusOwner()) {
                txtInsurance.requestFocus();
            } else if (txtInsurance.isFocusOwner()) {
                txtDownpayment.requestFocus();
            } else if (txtDownpayment.isFocusOwner()) {
                txtUnitApplied.requestFocus();
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtUnitApplied.setEditable(value);
        txtDownpayment.setEditable(value);
        txtInsurance.setEditable(value);
        txtTerm.setEditable(value);
        txtAmort.setEditable(value);
        comboMotorStatus.setEnabled(value);
        comboPurpose.setEnabled(value);
        txtRemarks.setEditable(value);
        checkApproved.setEnabled(value);
        checkDisApproved.setEnabled(value);
    }

    public void resetToDefault() {
        txtUnitApplied.setText("");
        txtDownpayment.setText("");
        txtInsurance.setText("");
        txtTerm.setText("");
        txtAmort.setText("");
        comboMotorStatus.setSelectedIndex(0);
        comboPurpose.setSelectedIndex(0);
        txtRemarks.setText("");
        checkApproved.setSelected(false);
        checkDisApproved.setSelected(false);
    }

    public void setPurchaseOrderInfo(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            PurchaseOrder po = (PurchaseOrder) o;
            txtUnitApplied.setText(po.getUnitApplied());
            txtDownpayment.setText(NumberUtils.doubleToString(po.getDownPayment()));
            txtInsurance.setText(NumberUtils.doubleToString(po.getInsurance()));
            txtTerm.setText(po.getTerm() + "");
            txtAmort.setText(NumberUtils.doubleToString(po.getMonthlyAmortization()));
            comboMotorStatus.removeAllItems();
            if (po.isBrandNew()) {
                comboMotorStatus.addItem("BRAND NEW");
            } else {
                comboMotorStatus.addItem("REPO");
            }
            comboPurpose.removeAllItems();
            comboPurpose.addItem(po.getPurpose());
            txtRemarks.setText(po.getRemarks());
            switch (po.getStatus()) {
                case "APPROVED":
                    checkApproved.setSelected(true);
                    checkDisApproved.setSelected(false);
                    headerPanel.setApplicationStatus("APPROVED");
                    break;
                case "DISAPPROVED":
                    checkApproved.setSelected(false);
                    checkDisApproved.setSelected(true);
                    headerPanel.setApplicationStatus("DISAPPROVED");
                    break;
                default:
                    checkApproved.setSelected(false);
                    checkDisApproved.setSelected(false);
                    headerPanel.setApplicationStatus("PENDING");
                    break;
            }
        }
    }

    public boolean savePurchaseOrder() {
        PurchaseOrder p = PurchaseOrderController.getInstance().createNew(headerPanel.getFormNo(), createNew(new PurchaseOrder()));
        setPurchaseOrder(p);
        return p != null;
    }

    public boolean updatePurchaseOrder() {
        PurchaseOrder p = PurchaseOrderController.getInstance().update(headerPanel.getFormNo(), createNew(purchaseOrder));
        setPurchaseOrder(p);
        return p != null;
    }

    private PurchaseOrder createNew(PurchaseOrder p) {
        p.setEncodeDate(DateUtil.now());
        p.setUnitApplied(txtUnitApplied.getText());
        p.setDownPayment(new BigDecimal(UIValidator.MoneyCommaRemover(txtDownpayment.getText())).doubleValue());
        p.setInsurance(new BigDecimal(UIValidator.MoneyCommaRemover(txtInsurance.getText())).doubleValue());
        p.setTerm(Integer.parseInt(txtTerm.getText()));
        p.setMonthlyAmortization(new BigDecimal(UIValidator.MoneyCommaRemover(txtAmort.getText())).doubleValue());
        if (((String) comboMotorStatus.getSelectedItem()).equals("REPO")) {
            p.setBrandNew(false);
        } else {
            p.setBrandNew(true);
        }
        p.setPurpose((String) comboPurpose.getSelectedItem());
        p.setRemarks(txtRemarks.getText());
        if (checkApproved.isSelected()) {
            p.setStatus("APPROVED");
        } else if (checkDisApproved.isSelected()) {
            p.setStatus("DISAPPROVED");
        } else {
            p.setStatus("PENDING");
        }

        return p;
    }
}
