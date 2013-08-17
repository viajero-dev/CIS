/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.commons.util.NumberUtils;
import com.vg.scfc.financing.cis.ent.Expenditure;
import com.vg.scfc.financing.cis.ent.ExpenditureType;
import com.vg.scfc.financing.cis.ui.controller.ExpenditureController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import com.vg.scfc.financing.cis.ui.validator.Validator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodel
 */
public class ExpendituresPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form ExpendituresPanel
     */
    public ExpendituresPanel() {
        initComponents();
        initTextBoxesListener();
        startUpSettings();
    }

    private void startUpSettings() {
        setFieldsEditable(false);
    }

    /**
     * Set KeyListeners
     */
    private void initTextBoxesListener() {
        txtMonthlyDeduction.addKeyListener(this);
        txtMonthlyHouseholdBill.addKeyListener(this);
        txtAmortization.addKeyListener(this);
        txtMaintenanceDesc.addKeyListener(this);
        txtMaintenance.addKeyListener(this);
        txtLivingAllowance.addKeyListener(this);
        txtEducationDesc.addKeyListener(this);
        txtEducation.addKeyListener(this);
        txtOthers.addKeyListener(this);
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
        txtMonthlyDeduction = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMonthlyHouseholdBill = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaintenanceDesc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAmortization = new javax.swing.JTextField();
        txtMaintenance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLivingAllowance = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEducationDesc = new javax.swing.JTextField();
        txtEducation = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotalExpenditure = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtOthers = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNetIncome = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Regular Monthly Salary Deduction");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        txtMonthlyDeduction.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMonthlyDeduction.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonthlyDeduction.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMonthlyDeductionFocusLost(evt);
            }
        });
        add(txtMonthlyDeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 5, 140, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Monthly Household Bill");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));

        txtMonthlyHouseholdBill.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMonthlyHouseholdBill.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonthlyHouseholdBill.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMonthlyHouseholdBillFocusLost(evt);
            }
        });
        add(txtMonthlyHouseholdBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 140, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Amortization (House, Vehicle, etc.)");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        txtMaintenanceDesc.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMaintenanceDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaintenanceDescFocusLost(evt);
            }
        });
        add(txtMaintenanceDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 80, 140, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Maintenance for");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, -1, -1));

        txtAmortization.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtAmortization.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAmortization.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmortizationFocusLost(evt);
            }
        });
        add(txtAmortization, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 55, 140, -1));

        txtMaintenance.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMaintenance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMaintenance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaintenanceFocusLost(evt);
            }
        });
        add(txtMaintenance, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 140, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("Living Allowance");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        txtLivingAllowance.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtLivingAllowance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLivingAllowance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLivingAllowanceFocusLost(evt);
            }
        });
        add(txtLivingAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 105, 140, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setText("Education for");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 136, -1, -1));

        txtEducationDesc.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtEducationDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEducationDescFocusLost(evt);
            }
        });
        add(txtEducationDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 131, 140, -1));

        txtEducation.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtEducation.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEducation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEducationFocusLost(evt);
            }
        });
        add(txtEducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 131, 140, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("Others");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 161, -1, -1));

        txtTotalExpenditure.setEditable(false);
        txtTotalExpenditure.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtTotalExpenditure.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalExpenditure.setFocusable(false);
        add(txtTotalExpenditure, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 190, 140, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("P");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 195, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("P");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 35, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setText("P");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 136, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setText("P");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setText("P");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 85, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel16.setText("P");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel17.setText("P");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel18.setText("Total Expenditures");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 195, -1, -1));

        txtOthers.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtOthers.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtOthers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOthersFocusLost(evt);
            }
        });
        add(txtOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 159, 140, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel19.setText("P");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 161, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel20.setText("Net Income");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 220, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel21.setText("P");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 220, -1, -1));

        txtNetIncome.setEditable(false);
        txtNetIncome.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtNetIncome.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNetIncome.setFocusable(false);
        add(txtNetIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 215, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtMonthlyDeductionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthlyDeductionFocusLost
        txtMonthlyDeduction.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMonthlyDeduction)).doubleValue()));
        computeTotalExpenditureAndNetIncome(UIValidator.MoneyCommaRemover(txtMonthlyDeduction.getText()));
    }//GEN-LAST:event_txtMonthlyDeductionFocusLost

    private void txtMonthlyHouseholdBillFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthlyHouseholdBillFocusLost
        txtMonthlyHouseholdBill.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMonthlyHouseholdBill)).doubleValue()));
        computeTotalExpenditureAndNetIncome(UIValidator.MoneyCommaRemover(txtMonthlyHouseholdBill.getText()));
    }//GEN-LAST:event_txtMonthlyHouseholdBillFocusLost

    private void txtAmortizationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmortizationFocusLost
        txtAmortization.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtAmortization)).doubleValue())); 
        computeTotalExpenditureAndNetIncome(UIValidator.MoneyCommaRemover(txtAmortization.getText()));
    }//GEN-LAST:event_txtAmortizationFocusLost

    private void txtMaintenanceDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaintenanceDescFocusLost
        txtMaintenanceDesc.setText(UIValidator.validate(txtMaintenanceDesc));
    }//GEN-LAST:event_txtMaintenanceDescFocusLost

    private void txtMaintenanceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaintenanceFocusLost
        txtMaintenance.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMaintenance)).doubleValue())); 
        computeTotalExpenditureAndNetIncome(UIValidator.MoneyCommaRemover(txtMaintenance.getText()));
    }//GEN-LAST:event_txtMaintenanceFocusLost

    private void txtLivingAllowanceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLivingAllowanceFocusLost
        txtLivingAllowance.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtLivingAllowance)).doubleValue())); 
        computeTotalExpenditureAndNetIncome(UIValidator.MoneyCommaRemover(txtLivingAllowance.getText()));
    }//GEN-LAST:event_txtLivingAllowanceFocusLost

    private void txtEducationDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEducationDescFocusLost
        txtEducationDesc.setText(UIValidator.validate(txtEducationDesc)); 
    }//GEN-LAST:event_txtEducationDescFocusLost

    private void txtEducationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEducationFocusLost
        txtEducation.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtEducation)).doubleValue())); 
        computeTotalExpenditureAndNetIncome(UIValidator.MoneyCommaRemover(txtEducation.getText()));
    }//GEN-LAST:event_txtEducationFocusLost

    private void txtOthersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOthersFocusLost
        txtOthers.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtOthers)).doubleValue()));
        computeTotalExpenditureAndNetIncome(UIValidator.MoneyCommaRemover(txtOthers.getText()));
    }//GEN-LAST:event_txtOthersFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAmortization;
    private javax.swing.JTextField txtEducation;
    private javax.swing.JTextField txtEducationDesc;
    private javax.swing.JTextField txtLivingAllowance;
    private javax.swing.JTextField txtMaintenance;
    private javax.swing.JTextField txtMaintenanceDesc;
    private javax.swing.JTextField txtMonthlyDeduction;
    private javax.swing.JTextField txtMonthlyHouseholdBill;
    private javax.swing.JTextField txtNetIncome;
    private javax.swing.JTextField txtOthers;
    private javax.swing.JTextField txtTotalExpenditure;
    // End of variables declaration//GEN-END:variables
    private List<Expenditure> expenditures;
    private String formNo;
    private BigDecimal totalMonthlyIncome;
    private HeaderPanel headerPanel;
    private BigDecimal total = new BigDecimal("0");

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public BigDecimal getTotalMonthlyIncome() {
        if (totalMonthlyIncome == null) {
            totalMonthlyIncome = new BigDecimal("0");
        }
        return totalMonthlyIncome;
    }

    public void setTotalMonthlyIncome(BigDecimal totalMonthlyIncome) {
        this.totalMonthlyIncome = totalMonthlyIncome;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public void setExpenditures(List<Expenditure> expenditures) {
        this.expenditures = expenditures;
        setExpenditureData(this.expenditures);
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
                if (txtMonthlyDeduction.isFocusOwner()) {
                txtMonthlyHouseholdBill.requestFocus();
            } else if (txtMonthlyHouseholdBill.isFocusOwner()) {
                txtAmortization.requestFocus();
            } else if (txtAmortization.isFocusOwner()) {
                txtMaintenanceDesc.requestFocus();
            } else if (txtMaintenanceDesc.isFocusOwner()) {
                if (Validator.getInstance().isEmpty(txtMaintenanceDesc.getText())) {
                    txtMaintenance.setEnabled(false);
                    txtMaintenanceDesc.setEnabled(false);
                    txtLivingAllowance.requestFocus();
                } else {
                    txtMaintenance.requestFocus();
                }
            } else if (txtMaintenance.isFocusOwner()) {
                txtLivingAllowance.requestFocus();
            } else if (txtLivingAllowance.isFocusOwner()) {
                txtEducationDesc.requestFocus();
            } else if (txtEducationDesc.isFocusOwner()) {
                if (Validator.getInstance().isEmpty(txtEducationDesc.getText())) {
                    txtEducation.setEnabled(false);
                    txtEducationDesc.setEnabled(false);
                    txtOthers.requestFocus();
                } else {
                    txtEducation.requestFocus();
                }
            } else if (txtEducation.isFocusOwner()) {
                txtOthers.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtOthers.isFocusOwner()) {
                if (txtEducation.isEnabled()) {
                    txtEducation.requestFocus();
                } else {
                    txtEducationDesc.setEnabled(true);
                    txtEducation.setEnabled(true);
                    txtEducationDesc.requestFocus();
                }
            } else if (txtEducation.isFocusOwner()) {
                txtEducationDesc.requestFocus();
            } else if (txtEducationDesc.isFocusOwner()) {
                txtLivingAllowance.requestFocus();
            } else if (txtLivingAllowance.isFocusOwner()) {
                if (txtMaintenance.isEnabled()) {
                    txtMaintenance.requestFocus();
                } else {
                    txtMaintenanceDesc.setEnabled(true);
                    txtMaintenance.setEnabled(true);
                    txtMaintenanceDesc.requestFocus();
                }
            } else if (txtMaintenance.isFocusOwner()) {
                txtMaintenanceDesc.requestFocus();
            } else if (txtMaintenanceDesc.isFocusOwner()) {
                txtAmortization.requestFocus();
            } else if (txtAmortization.isFocusOwner()) {
                txtMonthlyHouseholdBill.requestFocus();
            } else if (txtMonthlyHouseholdBill.isFocusOwner()) {
                txtMonthlyDeduction.requestFocus();
            }
                break;
        }
    }

    private void computeTotalExpenditureAndNetIncome(String value) {
//        BigDecimal sumOfExpenditureValues = toBigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyDeduction.getText()))
//                .add(toBigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyHouseholdBill.getText())))
//                .add(toBigDecimal(UIValidator.MoneyCommaRemover(txtAmortization.getText())))
//                .add(toBigDecimal(UIValidator.MoneyCommaRemover(txtMaintenance.getText())))
//                .add(toBigDecimal(UIValidator.MoneyCommaRemover(txtLivingAllowance.getText())))
//                .add(toBigDecimal(UIValidator.MoneyCommaRemover(txtEducation.getText())))
//                .add(toBigDecimal(UIValidator.MoneyCommaRemover(txtOthers.getText())));
        total = total.add(toBigDecimal(value));
        txtTotalExpenditure.setText(total.round(MathContext.UNLIMITED).toString());
    }
    
    private BigDecimal toBigDecimal(String value) {
        return new BigDecimal(value);
    }

    public void setFieldsEditable(boolean value) {
        txtMonthlyDeduction.setEditable(value);
        txtMonthlyHouseholdBill.setEditable(value);
        txtAmortization.setEditable(value);
        txtMaintenance.setEditable(value);
        txtMaintenanceDesc.setEditable(value);
        txtLivingAllowance.setEditable(value);
        txtEducation.setEditable(value);
        txtEducationDesc.setEditable(value);
        txtOthers.setEditable(value);
        
        txtMonthlyDeduction.setFocusable(value);
        txtMonthlyHouseholdBill.setFocusable(value);
        txtAmortization.setFocusable(value);
        txtMaintenance.setFocusable(value);
        txtMaintenanceDesc.setFocusable(value);
        txtLivingAllowance.setFocusable(value);
        txtEducation.setFocusable(value);
        txtEducationDesc.setFocusable(value);
        txtOthers.setFocusable(value);
        
        if(value) {
            txtMonthlyDeduction.requestFocus();
        }
    }

    public void resetToDefault() {
        txtMonthlyDeduction.setText("");
        txtMonthlyHouseholdBill.setText("");
        txtAmortization.setText("");
        txtMaintenance.setText("");
        txtMaintenanceDesc.setText("");
        txtLivingAllowance.setText("");
        txtEducation.setText("");
        txtEducationDesc.setText("");
        txtOthers.setText("");
        txtTotalExpenditure.setText("0");
        txtNetIncome.setText("0");
    }

    public void setExpenditureData(List<Expenditure> expenditures) {
        if (expenditures == null || expenditures.isEmpty()) {
            resetToDefault();
        } else {
            for (Expenditure e : expenditures) {
                switch (e.getExpenditureType().getId()) {
                    case 1:
                        /* Regular Monthly Salary Deduction */
                        txtMonthlyDeduction.setText(NumberUtils.doubleToString(e.getAmount()));
                        break;
                    case 2:
                        /* Monthly Household Bill */
                        txtMonthlyHouseholdBill.setText(NumberUtils.doubleToString(e.getAmount()));
                        break;
                    case 3:
                        /* Amortization */
                        txtAmortization.setText(NumberUtils.doubleToString(e.getAmount()));
                        break;
                    case 4:
                        /* Maintenance */
                        txtMaintenance.setText(NumberUtils.doubleToString(e.getAmount()));
                        txtMaintenanceDesc.setText(e.getAdditionalInfo());
                        break;
                    case 5:
                        /* Living Allowance */
                        txtLivingAllowance.setText(NumberUtils.doubleToString(e.getAmount()));
                        break;
                    case 6:
                        /* Education */
                        txtEducation.setText(NumberUtils.doubleToString(e.getAmount()));
                        txtEducationDesc.setText(e.getAdditionalInfo());
                        break;
                    case 7:
                        /* Others */
                        txtOthers.setText(NumberUtils.doubleToString(e.getAmount()));
                        break;
                }
            }
            BigDecimal totalExpenditures = ExpenditureController.getInstance().totalExpenditures(expenditures);

            txtTotalExpenditure.setText(totalExpenditures.toPlainString());
            txtNetIncome.setText(getTotalMonthlyIncome().subtract(totalExpenditures).toPlainString());
        }
    }

    public boolean saveExpenditures() {
        List<Expenditure> objects = ExpenditureController.getInstance().createNew(createNew(new ArrayList<Expenditure>()), headerPanel.getFormNo());
        setExpenditures(objects);
        return !objects.isEmpty();
    }

    public boolean updateExpenditures() {
        List<Expenditure> objects = ExpenditureController.getInstance().update(headerPanel.getFormNo(), createNew(expenditures));
        setExpenditures(objects);
        return !objects.isEmpty();
    }

    private List<Expenditure> createNew(List<Expenditure> e) {
        List<Expenditure> results = new ArrayList<>();
        if (e.isEmpty()) {
            Expenditure ex;
            /* Regular Monthly Salary Deduction */
            if (!txtMonthlyDeduction.getText().equals("")) {
                ExpenditureType eType = ExpenditureController.getInstance().findByID(1);
                ex = new Expenditure();
                ex.setExpenditureType(eType);
                ex.setAdditionalInfo("");
                ex.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyDeduction.getText())).doubleValue());
                ex.setTxFormNo(headerPanel.getFormNo());
                results.add(ex);
            }

            /* Monthly Household Bill */
            if (!txtMonthlyHouseholdBill.getText().equals("")) {
                ExpenditureType eType = ExpenditureController.getInstance().findByID(2);
                ex = new Expenditure();
                ex.setExpenditureType(eType);
                ex.setAdditionalInfo("");
                ex.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyHouseholdBill.getText())).doubleValue());
                ex.setTxFormNo(headerPanel.getFormNo());
                results.add(ex);
            }

            /* Amortization */
            if (!txtAmortization.getText().equals("")) {
                ExpenditureType eType = ExpenditureController.getInstance().findByID(3);
                ex = new Expenditure();
                ex.setExpenditureType(eType);
                ex.setAdditionalInfo("");
                ex.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtAmortization.getText())).doubleValue());
                ex.setTxFormNo(headerPanel.getFormNo());
                results.add(ex);
            }

            /* Maintenance */
            if (!txtMaintenance.getText().equals("")) {
                ExpenditureType eType = ExpenditureController.getInstance().findByID(4);
                ex = new Expenditure();
                ex.setExpenditureType(eType);
                ex.setAdditionalInfo(txtMaintenanceDesc.getText());
                ex.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtMaintenance.getText())).doubleValue());
                ex.setTxFormNo(headerPanel.getFormNo());
                results.add(ex);
            }

            /* Living allowance */
            if (!txtLivingAllowance.getText().equals("")) {
                ExpenditureType eType = ExpenditureController.getInstance().findByID(5);
                ex = new Expenditure();
                ex.setExpenditureType(eType);
                ex.setAdditionalInfo("");
                ex.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtLivingAllowance.getText())).doubleValue());
                ex.setTxFormNo(headerPanel.getFormNo());
                results.add(ex);
            }

            /* Education */
            if (!txtEducation.getText().equals("")) {
                ExpenditureType eType = ExpenditureController.getInstance().findByID(6);
                ex = new Expenditure();
                ex.setExpenditureType(eType);
                ex.setAdditionalInfo(txtEducationDesc.getText());
                ex.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtEducation.getText())).doubleValue());
                ex.setTxFormNo(headerPanel.getFormNo());
                results.add(ex);
            }

            /* Others */
            if (!txtOthers.getText().equals("")) {
                ExpenditureType eType = ExpenditureController.getInstance().findByID(7);
                ex = new Expenditure();
                ex.setExpenditureType(eType);
                ex.setAdditionalInfo("");
                ex.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtOthers.getText())).doubleValue());
                ex.setTxFormNo(headerPanel.getFormNo());
                results.add(ex);
            }
            return results;
        } else {
            for (Expenditure expenditure : e) {
                switch (expenditure.getExpenditureType().getId()) {
                    case 1:
                        /* Regular Monthly Salary Deduction */
                        if (!txtMonthlyDeduction.getText().equals("")) {
                            expenditure.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyDeduction.getText())).doubleValue());
                        } else {
                            expenditure.setAmount(0);
                        }
                        break;
                    case 2:
                        /* Monthly Household Bill */
                        if (!txtMonthlyHouseholdBill.getText().equals("")) {
                            expenditure.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyHouseholdBill.getText())).doubleValue());
                        } else {
                            expenditure.setAmount(0);
                        }
                        break;
                    case 3:
                        /* Amortization */
                        if (!txtAmortization.getText().equals("")) {
                            expenditure.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtAmortization.getText())).doubleValue());
                        } else {
                            expenditure.setAmount(0);
                        }
                        break;
                    case 4:
                        /* Maintenance */
                        if (!txtMaintenance.getText().equals("")) {
                            expenditure.setAdditionalInfo(txtMaintenanceDesc.getText());
                            expenditure.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtMaintenance.getText())).doubleValue());
                        } else {
                            expenditure.setAdditionalInfo("");
                            expenditure.setAmount(0);
                        }
                        break;
                    case 5:
                        /* Living allowance */
                        if (!txtLivingAllowance.getText().equals("")) {
                            expenditure.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtLivingAllowance.getText())).doubleValue());
                        } else {
                            expenditure.setAmount(0);
                        }
                        break;
                    case 6:
                        /* Education */
                        if (!txtEducation.getText().equals("")) {
                            expenditure.setAdditionalInfo(txtEducationDesc.getText());
                            expenditure.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtEducation.getText())).doubleValue());
                        } else {
                            expenditure.setAdditionalInfo("");
                            expenditure.setAmount(0);
                        }
                        break;
                   case 7:
                       /* Others */
                        if (!txtOthers.getText().equals("")) {
                            expenditure.setAmount(new BigDecimal(UIValidator.MoneyCommaRemover(txtOthers.getText())).doubleValue());
                        } else {
                            expenditure.setAmount(0);
                        }
                       break;
                }
            }
            return e;
        }
    }
}
