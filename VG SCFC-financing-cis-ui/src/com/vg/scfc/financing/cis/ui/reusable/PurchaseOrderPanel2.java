/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.commons.util.DateUtil;
import com.vg.commons.util.NumberUtils;
import com.vg.commons.util.UIMgr;
import com.vg.hrm.user.ent.Employee;
import com.vg.hrm.user.ui.dlg.EmployeesDlg;
import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.ui.controller.PurchaseOrderController;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import com.vg.scfc.financing.cis.ui.validator.Validator;
import com.vg.vmi.dealer.uts.ent.McColor;
import com.vg.vmi.dealer.uts.ent.McMake;
import com.vg.vmi.dealer.uts.ent.McModel;
import com.vg.vmi.dealer.uts.ui.dlg.ColorDlg;
import com.vg.vmi.dealer.uts.ui.dlg.MakeDlg;
import com.vg.vmi.dealer.uts.ui.dlg.ModelDlg;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author rodel
 */
public class PurchaseOrderPanel2 extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form PurchaseOrderPanel2
     */
    public PurchaseOrderPanel2() {
        initComponents();
        initKeyListener();
        txtMakeCode.putClientProperty("Quaqua.TextField.style", "search");
        txtColorCode.putClientProperty("Quaqua.TextField.style", "search");
        txtModelCode.putClientProperty("Quaqua.TextField.style", "search");
        txtCICode.putClientProperty("Quaqua.TextField.style", "search");
    }

    private void initKeyListener() {
        comboPurpose.addKeyListener(this);
        comboMotorStatus.addKeyListener(this);
        txtMakeCode.addKeyListener(this);
        txtColorCode.addKeyListener(this);
        txtModelCode.addKeyListener(this);
        txtDownPayment.addKeyListener(this);
        txtTerm.addKeyListener(this);
        txtMA.addKeyListener(this);
        txtPrice.addKeyListener(this);
        txtBal.addKeyListener(this);
        txtInsAmount.addKeyListener(this);
        txtInsComp.addKeyListener(this);
        txtReleasedDate.addKeyListener(this);
        checkApproved.addKeyListener(this);
        checkDisApproved.addKeyListener(this);
        txtCICode.addKeyListener(this);
        txtRemarks.addKeyListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        comboPurpose = new javax.swing.JComboBox();
        txtMakeDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMakeCode = new javax.swing.JTextField();
        txtColorCode = new javax.swing.JTextField();
        txtColorDesc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTerm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtModelDesc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDownPayment = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtModelCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMA = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        try {
            txtReleasedDate = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        checkApproved = new javax.swing.JCheckBox();
        checkDisApproved = new javax.swing.JCheckBox();
        txtBal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtInsAmount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtInsComp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemarks = new javax.swing.JTextArea();
        comboMotorStatus = new javax.swing.JComboBox();
        txtCICode = new javax.swing.JTextField();
        txtCIDesc = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Purpose");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        comboPurpose.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        comboPurpose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PERSONAL", "BUSINESS", "OTHERS" }));
        add(comboPurpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 100, -1));

        txtMakeDesc.setEditable(false);
        txtMakeDesc.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMakeDesc.setFocusable(false);
        add(txtMakeDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 30, 250, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Make");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));

        txtMakeCode.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtMakeCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 70, -1));

        txtColorCode.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtColorCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 55, 70, -1));

        txtColorDesc.setEditable(false);
        txtColorDesc.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtColorDesc.setFocusable(false);
        add(txtColorDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 55, 250, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Color");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        txtTerm.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtTerm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTermFocusLost(evt);
            }
        });
        add(txtTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 105, 90, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Model");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, -1, -1));

        txtModelDesc.setEditable(false);
        txtModelDesc.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtModelDesc.setFocusable(false);
        add(txtModelDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 80, 250, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("Down.");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        txtDownPayment.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtDownPayment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDownPaymentFocusLost(evt);
            }
        });
        add(txtDownPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 105, 160, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setText("Term");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        txtModelCode.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtModelCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("Price");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtPrice.setFocusable(false);
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 5, 325, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("M.A.");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 135, -1, -1));

        txtMA.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMAFocusLost(evt);
            }
        });
        add(txtMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 325, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setText("Released Date");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        txtReleasedDate.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtReleasedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 105, 70, -1));

        checkApproved.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        checkApproved.setText("APPROVED");
        checkApproved.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkApprovedItemStateChanged(evt);
            }
        });
        add(checkApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 105, -1, -1));

        checkDisApproved.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        checkDisApproved.setForeground(new java.awt.Color(203, 28, 28));
        checkDisApproved.setText("DISAPPROVED");
        checkDisApproved.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkDisApprovedItemStateChanged(evt);
            }
        });
        add(checkDisApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 105, -1, -1));

        txtBal.setEditable(false);
        txtBal.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtBal.setFocusable(false);
        txtBal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBalFocusLost(evt);
            }
        });
        add(txtBal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 325, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel17.setText("Bal.");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 35, -1, -1));

        txtInsAmount.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtInsAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInsAmountFocusLost(evt);
            }
        });
        add(txtInsAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 55, 270, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel18.setText("Insurance Amount");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel19.setText("Insurance Comp.");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 85, -1, -1));

        txtInsComp.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtInsComp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInsCompFocusLost(evt);
            }
        });
        add(txtInsComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 80, 270, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setText("Remarks");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, -1, -1));

        txtRemarks.setColumns(20);
        txtRemarks.setRows(5);
        jScrollPane1.setViewportView(txtRemarks);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 155, 735, -1));

        comboMotorStatus.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        comboMotorStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REPO", "BRAND NEW" }));
        add(comboMotorStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 5, 110, -1));

        txtCICode.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtCICode, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 70, -1));

        txtCIDesc.setEditable(false);
        txtCIDesc.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCIDesc.setFocusable(false);
        add(txtCIDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 130, 250, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel16.setText("CI Coll.");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 135, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void checkApprovedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkApprovedItemStateChanged
        if (checkApproved.isSelected()) {
            checkApproved.setSelected(true);
            checkDisApproved.setSelected(false);
        }
    }//GEN-LAST:event_checkApprovedItemStateChanged

    private void checkDisApprovedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkDisApprovedItemStateChanged
        if (checkDisApproved.isSelected()) {
            checkApproved.setSelected(false);
            checkDisApproved.setSelected(true);
        }
    }//GEN-LAST:event_checkDisApprovedItemStateChanged

    private void txtDownPaymentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDownPaymentFocusLost
        txtDownPayment.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtDownPayment)).doubleValue()));
        txtPrice.setText(NumberUtils.doubleToString(PurchaseOrderController.getInstance().computePrice(new BigDecimal(UIValidator.MoneyCommaRemover(txtDownPayment.getText())),
                (txtTerm.getText().equals("") ? new BigDecimal("1") : new BigDecimal(UIValidator.MoneyCommaRemover(txtTerm.getText()))))));
    }//GEN-LAST:event_txtDownPaymentFocusLost

    private void txtTermFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTermFocusLost
        txtTerm.setText(UIValidator.isNumeric(txtTerm));
        txtPrice.setText(NumberUtils.doubleToString(PurchaseOrderController.getInstance().computePrice(new BigDecimal(UIValidator.MoneyCommaRemover(txtDownPayment.getText())),
                (txtTerm.getText().equals("") ? new BigDecimal("1") : new BigDecimal(UIValidator.MoneyCommaRemover(txtTerm.getText()))))));
    }//GEN-LAST:event_txtTermFocusLost

    private void txtMAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMAFocusLost
        txtMA.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMA)).doubleValue()));
        txtBal.setText(NumberUtils.doubleToString(PurchaseOrderController.getInstance().computeBalance(new BigDecimal(UIValidator.MoneyCommaRemover(txtPrice.getText())),
                new BigDecimal(UIValidator.MoneyCommaRemover(txtMA.getText())))));
    }//GEN-LAST:event_txtMAFocusLost

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        txtPrice.setText(UIValidator.isNumeric(txtPrice));
    }//GEN-LAST:event_txtPriceFocusLost

    private void txtBalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBalFocusLost
        txtBal.setText(UIValidator.isNumeric(txtBal));
    }//GEN-LAST:event_txtBalFocusLost

    private void txtInsAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInsAmountFocusLost
        txtInsAmount.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtInsAmount)).doubleValue()));
    }//GEN-LAST:event_txtInsAmountFocusLost

    private void txtInsCompFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInsCompFocusLost
        txtInsComp.setText(UIValidator.validate(txtInsComp));
    }//GEN-LAST:event_txtInsCompFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkApproved;
    private javax.swing.JCheckBox checkDisApproved;
    private javax.swing.JComboBox comboMotorStatus;
    private javax.swing.JComboBox comboPurpose;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBal;
    private javax.swing.JTextField txtCICode;
    private javax.swing.JTextField txtCIDesc;
    private javax.swing.JTextField txtColorCode;
    private javax.swing.JTextField txtColorDesc;
    private javax.swing.JTextField txtDownPayment;
    private javax.swing.JTextField txtInsAmount;
    private javax.swing.JTextField txtInsComp;
    private javax.swing.JTextField txtMA;
    private javax.swing.JTextField txtMakeCode;
    private javax.swing.JTextField txtMakeDesc;
    private javax.swing.JTextField txtModelCode;
    private javax.swing.JTextField txtModelDesc;
    private javax.swing.JTextField txtPrice;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtReleasedDate;
    private javax.swing.JTextArea txtRemarks;
    private javax.swing.JTextField txtTerm;
    // End of variables declaration//GEN-END:variables
    private HeaderPanel headerPanel;
    private String personType;
    private PurchaseOrder purchaseOrder;
    private McMake make;
    private McColor color;
    private McModel model;
    private Employee ci;

    public void setCi(Employee ci) {
        this.ci = ci;
    }

    public void setMake(McMake make) {
        this.make = make;
    }

    public void setColor(McColor color) {
        this.color = color;
    }

    public void setModel(McModel model) {
        this.model = model;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        setPurchaseOrderValues(this.purchaseOrder);
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
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
                if (comboPurpose.isFocusOwner()) {
                comboMotorStatus.requestFocus();
            } else if (comboMotorStatus.isFocusOwner()) {
                txtMakeCode.requestFocus();
            } else if (txtMakeCode.isFocusOwner()) {
                txtColorCode.requestFocus();
            } else if (txtColorCode.isFocusOwner()) {
                txtModelCode.requestFocus();
            } else if (txtModelCode.isFocusOwner()) {
                txtDownPayment.requestFocus();
            } else if (txtDownPayment.isFocusOwner()) {
                txtTerm.requestFocus();
            } else if (txtTerm.isFocusOwner()) {
                txtMA.requestFocus();
            } else if (txtMA.isFocusOwner()) {
                txtInsAmount.requestFocus();
            } else if (txtInsAmount.isFocusOwner()) {
                txtInsComp.requestFocus();
            } else if (txtInsComp.isFocusOwner()) {
                txtReleasedDate.requestFocus();
            } else if (txtReleasedDate.isFocusOwner()) {
                checkApproved.requestFocus();
            } else if (checkApproved.isFocusOwner()) {
                checkDisApproved.requestFocus();
            } else if (checkDisApproved.isFocusOwner()) {
                txtCICode.requestFocus();
            } else if (txtCICode.isFocusOwner()) {
                txtRemarks.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtRemarks.isFocusOwner()) {
                txtCICode.requestFocus();
            } else if (txtCICode.isFocusOwner()) {
                checkDisApproved.requestFocus();
            } else if (checkDisApproved.isFocusOwner()) {
                checkApproved.requestFocus();
            } else if (checkApproved.isFocusOwner()) {
                txtReleasedDate.requestFocus();
            } else if (txtReleasedDate.isFocusOwner()) {
                txtInsComp.requestFocus();
            } else if (txtInsComp.isFocusOwner()) {
                txtInsAmount.requestFocus();
            } else if (txtInsAmount.isFocusOwner()) {
                txtMA.requestFocus();
            } else if (txtMA.isFocusOwner()) {
                txtTerm.requestFocus();
            } else if (txtTerm.isFocusOwner()) {
                txtDownPayment.requestFocus();
            } else if (txtDownPayment.isFocusOwner()) {
                txtModelCode.requestFocus();
            } else if (txtModelCode.isFocusOwner()) {
                txtColorCode.requestFocus();
            } else if (txtColorCode.isFocusOwner()) {
                txtMakeCode.requestFocus();
            } else if (txtMakeCode.isFocusOwner()) {
                comboMotorStatus.requestFocus();
            } else if (comboMotorStatus.isFocusOwner()) {
                comboPurpose.requestFocus();
            }
                break;
            case KeyEvent.VK_F5:
                if (txtMakeCode.isFocusOwner()) {
                MakeDlg makeDlg = new MakeDlg(null, true);
                makeDlg.setMakeService(UISetting.getMakeService());
                makeDlg.setDefault();
                UIMgr.centerToScreen(makeDlg);
                makeDlg.setVisible(true);
                if (makeDlg.getSelectedMake() != null) {
                    setMake(makeDlg.getSelectedMake());
                    txtMakeCode.setText(make.getCode());
                    txtMakeDesc.setText(make.getName().toUpperCase());
                }
            } else if (txtColorCode.isFocusOwner()) {
                ColorDlg colorDlg = new ColorDlg(null, true);
                colorDlg.setColorService(UISetting.getColorService());
                colorDlg.setDefault();
                UIMgr.centerToScreen(colorDlg);
                colorDlg.setVisible(true);
                if (colorDlg.getSelectedColor() != null) {
                    setColor(colorDlg.getSelectedColor());
                    txtColorCode.setText(color.getCode());
                    txtColorDesc.setText(color.getName().toUpperCase());
                }
            } else if (txtModelCode.isFocusOwner()) {
                ModelDlg modelDlg = new ModelDlg(null, true);
                modelDlg.setModelService(UISetting.getModelService());
                modelDlg.setDefault();
                UIMgr.centerToScreen(modelDlg);
                modelDlg.setVisible(true);
                if (modelDlg.getSelectedModel() != null) {
                    setModel(modelDlg.getSelectedModel());
                    txtModelCode.setText(model.getCode().toUpperCase());
                    txtModelDesc.setText(model.getDescription().toUpperCase());
                }
            } else if (txtCICode.isFocusOwner()) {
                EmployeesDlg employeeDlg = new EmployeesDlg(null, true);
                employeeDlg.setEmployeeService(UISetting.getEmployeeService());
                employeeDlg.setDefault();
                UIMgr.centerToScreen(employeeDlg);
                employeeDlg.setVisible(true);
                if (employeeDlg.getSelectedEmployee() != null) {
                    setCi(employeeDlg.getSelectedEmployee());
                    txtCICode.setText(ci.getId());
                    txtCIDesc.setText(ci.getProperName());
                }
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        comboPurpose.setEnabled(value);
        comboMotorStatus.setEnabled(value);
        txtMakeCode.setEditable(value);
        txtColorCode.setEditable(value);
        txtModelCode.setEditable(value);
        txtDownPayment.setEditable(value);
        txtTerm.setEditable(value);
        txtMA.setEditable(value);
        txtInsAmount.setEditable(value);
        txtInsComp.setEditable(value);
        txtReleasedDate.setEditable(value);
        checkApproved.setEnabled(value);
        checkDisApproved.setEnabled(value);
        txtCICode.setEditable(value);
        txtRemarks.setEditable(value);

        comboPurpose.setFocusable(value);
        comboMotorStatus.setFocusable(value);
        txtMakeCode.setFocusable(value);
        txtColorCode.setFocusable(value);
        txtModelCode.setFocusable(value);
        txtDownPayment.setFocusable(value);
        txtTerm.setFocusable(value);
        txtMA.setFocusable(value);
        txtInsAmount.setFocusable(value);
        txtInsComp.setFocusable(value);
        txtReleasedDate.setFocusable(value);
        checkApproved.setFocusable(value);
        checkDisApproved.setFocusable(value);
        txtCICode.setFocusable(value);
        txtRemarks.setFocusable(value);

        if (value) {
            comboPurpose.requestFocus();
        }
    }

    public void resetToDefault() {
        comboPurpose.setSelectedIndex(0);
        comboMotorStatus.setSelectedIndex(0);
        txtMakeCode.setText("");
        txtMakeDesc.setText("");
        txtColorCode.setText("");
        txtColorDesc.setText("");
        txtModelCode.setText("");
        txtModelDesc.setText("");
        txtDownPayment.setText("");
        txtTerm.setText("");
        txtMA.setText("");
        txtPrice.setText("");
        txtBal.setText("");
        txtInsAmount.setText("");
        txtInsComp.setText("");
        txtReleasedDate.setText("");
        checkApproved.setSelected(false);
        checkDisApproved.setSelected(false);
        txtCICode.setText("");
        txtCIDesc.setText("");
        txtRemarks.setText("");
    }

    private PurchaseOrder createNew(PurchaseOrder p) {
        p.setEncodeDate(DateUtil.now());
        p.setPurpose((String) comboPurpose.getSelectedItem());
        if (((String) comboMotorStatus.getSelectedItem()).equals("REPO")) {
            p.setBrandNew(false);
        } else {
            p.setBrandNew(true);
        }
        p.setMcMake(make);
        p.setMcColor(color);
        p.setMcModel(model);
        p.setDownPayment(new BigDecimal(UIValidator.MoneyCommaRemover(txtDownPayment.getText())).doubleValue());
        p.setTerm(Integer.parseInt(txtTerm.getText()));
        p.setMonthlyAmortization(new BigDecimal(UIValidator.MoneyCommaRemover(txtMA.getText())).doubleValue());
        if (txtInsAmount.getText().equals("")) {
            p.setInsuranceAmount(0);
        } else {
            p.setInsuranceAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtInsAmount.getText())).doubleValue());
        }
        p.setInsuranceCompany(txtInsComp.getText());
        if (checkApproved.isSelected()) {
            p.setStatus("APPROVED");
            p.setStatusDate(new Date());
            try {
                p.setReleaseDate(txtReleasedDate.getDate());
            } catch (ParseException ex) {
                UIValidator.log(ex, PurchaseOrderPanel2.class);
            }
        } else if (checkDisApproved.isSelected()) {
            p.setStatus("DISAPPROVED");
//            p.setReleaseDate(null);
        } else {
            p.setStatus("");
//            p.setReleaseDate(null);
        }
        p.setCiCollector(txtCICode.getText());
        p.setRemarks(Validator.getInstance().newLineRemover(txtRemarks.getText()).toUpperCase());
        return p;
    }

    private void setPurchaseOrderValues(PurchaseOrder p) {
        if (p == null) {
            resetToDefault();
        } else {
            System.out.println("Version" + p.getVersion());
            switch (p.getPurpose()) {
                case "PERSONAL":
                    break;
            }
            if (p.isBrandNew()) {
                comboMotorStatus.setSelectedIndex(1);
            } else {
                comboMotorStatus.setSelectedIndex(0);
            }
            txtMakeCode.setText(p.getMcMake().getCode());
            txtMakeDesc.setText(p.getMcMake().getName());
            setMake(p.getMcMake());
            txtColorCode.setText(p.getMcColor().getCode());
            txtColorDesc.setText(p.getMcColor().getName());
            setColor(p.getMcColor());
            txtModelCode.setText(p.getMcModel().getCode());
            txtModelDesc.setText(p.getMcModel().getDescription());
            setModel(p.getMcModel());
            txtDownPayment.setText(NumberUtils.doubleToString(p.getDownPayment()));
            txtTerm.setText(p.getTerm() + "");
            txtMA.setText(NumberUtils.doubleToString(p.getMonthlyAmortization()));
            double price = PurchaseOrderController.getInstance().computePrice(new BigDecimal(p.getDownPayment()), new BigDecimal(p.getTerm() + ""));
            txtPrice.setText(NumberUtils.doubleToString(price));
            txtBal.setText(NumberUtils.doubleToString(PurchaseOrderController.getInstance().computeBalance(new BigDecimal(price), new BigDecimal(p.getMonthlyAmortization()))));
            txtInsAmount.setText(NumberUtils.doubleToString(p.getInsuranceAmount()));
            txtInsComp.setText(p.getInsuranceCompany());
            if (p.getReleaseDate() != null) {
                txtReleasedDate.setDate(p.getReleaseDate());
            }
            switch (p.getStatus()) {
                case "APPROVED":
                    checkApproved.setSelected(true);
                    break;
                case "DISAPPROVED":
                    checkDisApproved.setSelected(true);
                    break;
                case "PENDING":
                    checkApproved.setSelected(false);
                    checkDisApproved.setSelected(false);
                    break;
            }
            Employee e = PurchaseOrderController.getInstance().findByID(p.getCiCollector());
            if (e != null) {
                setCi(e);
                txtCICode.setText(e.getId());
                txtCIDesc.setText(e.getProperName());
            }
            txtRemarks.setText(p.getRemarks());
        }
    }

    public boolean savePurchaseOrder() {
        PurchaseOrder p = PurchaseOrderController.getInstance().save(headerPanel.getFormNo(), createNew(new PurchaseOrder()));
        setPurchaseOrder(p);
        return p != null;
    }

    public boolean updatePurchaseOrder() {
        PurchaseOrder p = PurchaseOrderController.getInstance().update(headerPanel.getFormNo(), createNew(purchaseOrder));
        setPurchaseOrder(p);
        return p != null;
    }
}
