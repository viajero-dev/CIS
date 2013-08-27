/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.commons.util.DateUtil;
import com.vg.commons.util.NumberUtils;
import com.vg.scfc.financing.cis.ent.SourceOfIncome;
import com.vg.scfc.financing.cis.ui.controller.SourceOfIncomeController;
import com.vg.scfc.financing.cis.ui.panel.MainPanel;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.text.ParseException;
import javax.swing.JTextField;

/**
 *
 * @author rodel
 */
public class SourceOfIncomePanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form SourceOfIncomePanel
     */
    public SourceOfIncomePanel() {
        initComponents();
        initOptions();
        initKeyListener();
        startUpSettings();
    }

    private void startUpSettings() {
        setFieldsEditable(false);
    }

    /**
     * Set radio button group
     */
    private void initOptions() {
        optionBusinessRegistrationStatusGroup.add(optionBusinessRegistered);
        optionBusinessRegistrationStatusGroup.add(optionBusinessNotRegistered);
    }

    /**
     * Set KeyListeners
     */
    private void initKeyListener() {
        checkMonthlySalaryCompensation.addKeyListener(this);
        checkSourceBusiness.addKeyListener(this);
        checkSourceFarmProducts.addKeyListener(this);
        checkSourceOthers.addKeyListener(this);
        checkFarmAgri.addKeyListener(this);
        checkFarmLiveStock.addKeyListener(this);
        txtMonthlySalaryCompensation.addKeyListener(this);
        txtBusinessNature.addKeyListener(this);
        optionBusinessRegistered.addKeyListener(this);
        optionBusinessNotRegistered.addKeyListener(this);
        txtMonthlyIncomeForBusiness.addKeyListener(this);
        txtFarmHarvestSchedule.addKeyListener(this);
        txtFarmAvgProductIncome.addKeyListener(this);
        txtMonthlyIncomeForFarmProducts.addKeyListener(this);
        txtOtherSourceDesc.addKeyListener(this);
        txtMonthlyIncomeForOtherSources.addKeyListener(this);
        txtAgri.addKeyListener(this);
        txtLiveStock.addKeyListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionBusinessRegistrationStatusGroup = new javax.swing.ButtonGroup();
        checkMonthlySalaryCompensation = new javax.swing.JCheckBox();
        checkSourceBusiness = new javax.swing.JCheckBox();
        lblHarvestSched = new javax.swing.JLabel();
        optionBusinessRegistered = new javax.swing.JRadioButton();
        optionBusinessNotRegistered = new javax.swing.JRadioButton();
        checkSourceFarmProducts = new javax.swing.JCheckBox();
        checkFarmLiveStock = new javax.swing.JCheckBox();
        checkFarmAgri = new javax.swing.JCheckBox();
        lblNatureOfBusiness = new javax.swing.JLabel();
        txtMonthlySalaryCompensation = new javax.swing.JTextField();
        lblAvgProductIncome = new javax.swing.JLabel();
        txtFarmAvgProductIncome = new javax.swing.JTextField();
        checkSourceOthers = new javax.swing.JCheckBox();
        lblOtherSourceDesc = new javax.swing.JLabel();
        txtOtherSourceDesc = new javax.swing.JTextField();
        lblAvgMonthlyIncome = new javax.swing.JLabel();
        txtBusinessNature = new javax.swing.JTextField();
        lblAvgMonthlyIncomeForBusiness = new javax.swing.JLabel();
        txtMonthlyIncomeForBusiness = new javax.swing.JTextField();
        lblAvgMonthlyIncomeForOtherSources = new javax.swing.JLabel();
        txtMonthlyIncomeForFarmProducts = new javax.swing.JTextField();
        lblAvgMonthlyIncomeForFarmProducts = new javax.swing.JLabel();
        txtMonthlyIncomeForOtherSources = new javax.swing.JTextField();
        try {
            txtFarmHarvestSchedule = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        txtAgri = new javax.swing.JTextField();
        txtLiveStock = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkMonthlySalaryCompensation.setText("Monthly Salary Compensation");
        checkMonthlySalaryCompensation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkMonthlySalaryCompensationItemStateChanged(evt);
            }
        });
        add(checkMonthlySalaryCompensation, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        checkSourceBusiness.setText("Business");
        checkSourceBusiness.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkSourceBusinessItemStateChanged(evt);
            }
        });
        add(checkSourceBusiness, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, -1, -1));

        lblHarvestSched.setText("Harvest Schedule");
        lblHarvestSched.setEnabled(false);
        add(lblHarvestSched, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        optionBusinessRegistered.setText("Registered");
        optionBusinessRegistered.setEnabled(false);
        add(optionBusinessRegistered, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 80, -1, -1));

        optionBusinessNotRegistered.setText("Not Registered");
        optionBusinessNotRegistered.setEnabled(false);
        add(optionBusinessNotRegistered, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 80, -1, -1));

        checkSourceFarmProducts.setText("Farm Products");
        checkSourceFarmProducts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkSourceFarmProductsItemStateChanged(evt);
            }
        });
        add(checkSourceFarmProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        checkFarmLiveStock.setText("LiveStock");
        checkFarmLiveStock.setEnabled(false);
        checkFarmLiveStock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkFarmLiveStockItemStateChanged(evt);
            }
        });
        add(checkFarmLiveStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 160, -1, -1));

        checkFarmAgri.setText("Agricultural");
        checkFarmAgri.setEnabled(false);
        checkFarmAgri.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkFarmAgriItemStateChanged(evt);
            }
        });
        add(checkFarmAgri, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 135, -1, -1));

        lblNatureOfBusiness.setText("Nature of Business");
        lblNatureOfBusiness.setEnabled(false);
        add(lblNatureOfBusiness, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        txtMonthlySalaryCompensation.setEnabled(false);
        txtMonthlySalaryCompensation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMonthlySalaryCompensationFocusLost(evt);
            }
        });
        add(txtMonthlySalaryCompensation, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 5, 127, -1));

        lblAvgProductIncome.setText("Avg. Product Inc");
        lblAvgProductIncome.setEnabled(false);
        add(lblAvgProductIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 215, -1, -1));

        txtFarmAvgProductIncome.setEnabled(false);
        txtFarmAvgProductIncome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFarmAvgProductIncomeFocusLost(evt);
            }
        });
        add(txtFarmAvgProductIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 127, -1));

        checkSourceOthers.setText("Other Sources");
        checkSourceOthers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkSourceOthersItemStateChanged(evt);
            }
        });
        add(checkSourceOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 235, -1, -1));

        lblOtherSourceDesc.setText("Please specify");
        lblOtherSourceDesc.setEnabled(false);
        add(lblOtherSourceDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 265, -1, -1));

        txtOtherSourceDesc.setEnabled(false);
        txtOtherSourceDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOtherSourceDescFocusLost(evt);
            }
        });
        add(txtOtherSourceDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 150, -1));

        lblAvgMonthlyIncome.setText("Avg. Monthly Compensation");
        lblAvgMonthlyIncome.setEnabled(false);
        add(lblAvgMonthlyIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        txtBusinessNature.setEnabled(false);
        txtBusinessNature.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBusinessNatureFocusLost(evt);
            }
        });
        add(txtBusinessNature, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 55, 127, -1));

        lblAvgMonthlyIncomeForBusiness.setText("Avg. Monthly Income");
        lblAvgMonthlyIncomeForBusiness.setEnabled(false);
        add(lblAvgMonthlyIncomeForBusiness, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        txtMonthlyIncomeForBusiness.setEnabled(false);
        txtMonthlyIncomeForBusiness.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMonthlyIncomeForBusinessFocusLost(evt);
            }
        });
        add(txtMonthlyIncomeForBusiness, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 55, 127, -1));

        lblAvgMonthlyIncomeForOtherSources.setText("Avg. Monthly Income");
        lblAvgMonthlyIncomeForOtherSources.setEnabled(false);
        add(lblAvgMonthlyIncomeForOtherSources, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 265, -1, -1));

        txtMonthlyIncomeForFarmProducts.setEnabled(false);
        txtMonthlyIncomeForFarmProducts.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMonthlyIncomeForFarmProductsFocusLost(evt);
            }
        });
        add(txtMonthlyIncomeForFarmProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 127, -1));

        lblAvgMonthlyIncomeForFarmProducts.setText("Avg. Monthly Income");
        lblAvgMonthlyIncomeForFarmProducts.setEnabled(false);
        add(lblAvgMonthlyIncomeForFarmProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 215, -1, -1));

        txtMonthlyIncomeForOtherSources.setEnabled(false);
        txtMonthlyIncomeForOtherSources.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMonthlyIncomeForOtherSourcesFocusLost(evt);
            }
        });
        add(txtMonthlyIncomeForOtherSources, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 127, -1));

        txtFarmHarvestSchedule.setEnabled(false);
        add(txtFarmHarvestSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 185, 127, -1));

        txtAgri.setEnabled(false);
        add(txtAgri, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 135, 127, -1));

        txtLiveStock.setEnabled(false);
        add(txtLiveStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 127, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void checkMonthlySalaryCompensationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkMonthlySalaryCompensationItemStateChanged
        if (checkMonthlySalaryCompensation.isSelected()) {
            lblAvgMonthlyIncome.setEnabled(true);
            txtMonthlySalaryCompensation.setEnabled(true);
        } else {
            lblAvgMonthlyIncome.setEnabled(false);
            txtMonthlySalaryCompensation.setEnabled(false);
        }
    }//GEN-LAST:event_checkMonthlySalaryCompensationItemStateChanged

    private void checkSourceBusinessItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkSourceBusinessItemStateChanged
        if (checkSourceBusiness.isSelected()) {
            lblNatureOfBusiness.setEnabled(true);
            lblAvgMonthlyIncomeForBusiness.setEnabled(true);
            txtBusinessNature.setEnabled(true);
            optionBusinessRegistered.setEnabled(true);
            optionBusinessNotRegistered.setEnabled(true);
            txtMonthlyIncomeForBusiness.setEnabled(true);
        } else {
            lblNatureOfBusiness.setEnabled(false);
            lblAvgMonthlyIncomeForBusiness.setEnabled(false);
            txtBusinessNature.setEnabled(false);
            optionBusinessRegistered.setEnabled(false);
            optionBusinessNotRegistered.setEnabled(false);
            txtMonthlyIncomeForBusiness.setEnabled(false);
        }
    }//GEN-LAST:event_checkSourceBusinessItemStateChanged

    private void checkSourceFarmProductsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkSourceFarmProductsItemStateChanged
        if (checkSourceFarmProducts.isSelected()) {
            lblHarvestSched.setEnabled(true);
            lblAvgProductIncome.setEnabled(true);
            lblAvgMonthlyIncomeForFarmProducts.setEnabled(true);
            checkFarmAgri.setEnabled(true);
            checkFarmLiveStock.setEnabled(true);
            txtFarmHarvestSchedule.setEnabled(true);
            txtFarmAvgProductIncome.setEnabled(true);
            txtMonthlyIncomeForFarmProducts.setEnabled(true);
        } else {
            lblHarvestSched.setEnabled(false);
            lblAvgProductIncome.setEnabled(false);
            lblAvgMonthlyIncomeForFarmProducts.setEnabled(false);
            checkFarmAgri.setEnabled(false);
            checkFarmLiveStock.setEnabled(false);
            txtFarmHarvestSchedule.setEnabled(false);
            txtFarmAvgProductIncome.setEnabled(false);
            txtMonthlyIncomeForFarmProducts.setEnabled(false);
        }
    }//GEN-LAST:event_checkSourceFarmProductsItemStateChanged

    private void checkSourceOthersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkSourceOthersItemStateChanged
        if (checkSourceOthers.isSelected()) {
            lblOtherSourceDesc.setEnabled(true);
            lblAvgMonthlyIncomeForOtherSources.setEnabled(true);
            txtOtherSourceDesc.setEnabled(true);
            txtMonthlyIncomeForOtherSources.setEnabled(true);
        } else {
            lblOtherSourceDesc.setEnabled(false);
            lblAvgMonthlyIncomeForOtherSources.setEnabled(false);
            txtOtherSourceDesc.setEnabled(false);
            txtMonthlyIncomeForOtherSources.setEnabled(false);
        }
    }//GEN-LAST:event_checkSourceOthersItemStateChanged

    private void txtMonthlySalaryCompensationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthlySalaryCompensationFocusLost
        txtMonthlySalaryCompensation.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMonthlySalaryCompensation)).doubleValue()));
    }//GEN-LAST:event_txtMonthlySalaryCompensationFocusLost

    private void txtMonthlyIncomeForBusinessFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthlyIncomeForBusinessFocusLost
        txtMonthlyIncomeForBusiness.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMonthlyIncomeForBusiness)).doubleValue()));
    }//GEN-LAST:event_txtMonthlyIncomeForBusinessFocusLost

    private void txtMonthlyIncomeForFarmProductsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthlyIncomeForFarmProductsFocusLost
        txtMonthlyIncomeForFarmProducts.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMonthlyIncomeForFarmProducts)).doubleValue()));
    }//GEN-LAST:event_txtMonthlyIncomeForFarmProductsFocusLost

    private void txtMonthlyIncomeForOtherSourcesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMonthlyIncomeForOtherSourcesFocusLost
        txtMonthlyIncomeForOtherSources.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtMonthlyIncomeForOtherSources)).doubleValue()));
    }//GEN-LAST:event_txtMonthlyIncomeForOtherSourcesFocusLost

    private void txtFarmAvgProductIncomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFarmAvgProductIncomeFocusLost
        txtFarmAvgProductIncome.setText(NumberUtils.doubleToString(new BigDecimal(UIValidator.isNumeric(txtFarmAvgProductIncome)).doubleValue()));
    }//GEN-LAST:event_txtFarmAvgProductIncomeFocusLost

    private void txtBusinessNatureFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusinessNatureFocusLost
        txtBusinessNature.setText(UIValidator.validate(txtBusinessNature));
    }//GEN-LAST:event_txtBusinessNatureFocusLost

    private void txtOtherSourceDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOtherSourceDescFocusLost
        txtOtherSourceDesc.setText(UIValidator.validate(txtOtherSourceDesc));
    }//GEN-LAST:event_txtOtherSourceDescFocusLost

    private void checkFarmAgriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkFarmAgriItemStateChanged
        if (checkFarmAgri.isSelected()) {
            txtAgri.setEnabled(true);
        } else {
            txtAgri.setEnabled(false);
        }
    }//GEN-LAST:event_checkFarmAgriItemStateChanged

    private void checkFarmLiveStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkFarmLiveStockItemStateChanged
        if (checkFarmLiveStock.isSelected()) {
            txtLiveStock.setEnabled(true);
        } else {
            txtLiveStock.setEnabled(false);
        }
    }//GEN-LAST:event_checkFarmLiveStockItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkFarmAgri;
    private javax.swing.JCheckBox checkFarmLiveStock;
    private javax.swing.JCheckBox checkMonthlySalaryCompensation;
    private javax.swing.JCheckBox checkSourceBusiness;
    private javax.swing.JCheckBox checkSourceFarmProducts;
    private javax.swing.JCheckBox checkSourceOthers;
    private javax.swing.JLabel lblAvgMonthlyIncome;
    private javax.swing.JLabel lblAvgMonthlyIncomeForBusiness;
    private javax.swing.JLabel lblAvgMonthlyIncomeForFarmProducts;
    private javax.swing.JLabel lblAvgMonthlyIncomeForOtherSources;
    private javax.swing.JLabel lblAvgProductIncome;
    private javax.swing.JLabel lblHarvestSched;
    private javax.swing.JLabel lblNatureOfBusiness;
    private javax.swing.JLabel lblOtherSourceDesc;
    private javax.swing.JRadioButton optionBusinessNotRegistered;
    private javax.swing.JRadioButton optionBusinessRegistered;
    private javax.swing.ButtonGroup optionBusinessRegistrationStatusGroup;
    private javax.swing.JTextField txtAgri;
    private javax.swing.JTextField txtBusinessNature;
    private javax.swing.JTextField txtFarmAvgProductIncome;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtFarmHarvestSchedule;
    private javax.swing.JTextField txtLiveStock;
    private javax.swing.JTextField txtMonthlyIncomeForBusiness;
    private javax.swing.JTextField txtMonthlyIncomeForFarmProducts;
    private javax.swing.JTextField txtMonthlyIncomeForOtherSources;
    private javax.swing.JTextField txtMonthlySalaryCompensation;
    private javax.swing.JTextField txtOtherSourceDesc;
    // End of variables declaration//GEN-END:variables
    private String personType;
    private String clientNo;
    private SourceOfIncome sourceOfIncome;
    private JTextField txtTotalMonthlyIncome;
    private HeaderPanel headerPanel;
    private MainPanel mainPanel;

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setTxtTotalMonthlyIncome(JTextField txtTotalMonthlyIncome) {
        this.txtTotalMonthlyIncome = txtTotalMonthlyIncome;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setSourceOfIncome(SourceOfIncome sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
        setSourceOfIncomeData(this.sourceOfIncome);
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
                if (checkMonthlySalaryCompensation.isFocusOwner()) {
                if (checkMonthlySalaryCompensation.isSelected()) {
                    txtMonthlySalaryCompensation.requestFocus();
                } else {
                    checkSourceBusiness.requestFocus();
                }
            } else if (txtMonthlySalaryCompensation.isFocusOwner()) {
                checkSourceBusiness.requestFocus();
            } else if (checkSourceBusiness.isFocusOwner()) {
                if (checkSourceBusiness.isSelected()) {
                    txtBusinessNature.requestFocus();
                } else {
                    checkSourceFarmProducts.requestFocus();
                }
            } else if (txtBusinessNature.isFocusOwner()) {
                optionBusinessRegistered.requestFocus();
            } else if (optionBusinessRegistered.isFocusOwner()) {
                optionBusinessNotRegistered.requestFocus();
            } else if (optionBusinessNotRegistered.isFocusOwner()) {
                txtMonthlyIncomeForBusiness.requestFocus();
            } else if (txtMonthlyIncomeForBusiness.isFocusOwner()) {
                checkSourceFarmProducts.requestFocus();
            } else if (checkSourceFarmProducts.isFocusOwner()) {
                if (checkSourceFarmProducts.isSelected()) {
                    checkFarmAgri.requestFocus();
                } else {
                    checkSourceOthers.requestFocus();
                }
            } else if (checkFarmAgri.isFocusOwner()) {
                txtAgri.requestFocus();
            } else if (txtAgri.isFocusOwner()) {
                checkFarmLiveStock.requestFocus();
            } else if (checkFarmLiveStock.isFocusOwner()) {
                txtLiveStock.requestFocus();
            } else if (txtLiveStock.isFocusOwner()) {
                txtFarmHarvestSchedule.requestFocus();
            } else if (txtFarmHarvestSchedule.isFocusOwner()) {
                txtFarmAvgProductIncome.requestFocus();
            } else if (txtFarmAvgProductIncome.isFocusOwner()) {
                txtMonthlyIncomeForFarmProducts.requestFocus();
            } else if (txtMonthlyIncomeForFarmProducts.isFocusOwner()) {
                checkSourceOthers.requestFocus();
            } else if (checkSourceOthers.isFocusOwner()) {
                if (checkSourceOthers.isSelected()) {
                    txtOtherSourceDesc.requestFocus();
                }
            } else if (txtOtherSourceDesc.isFocusOwner()) {
                txtMonthlyIncomeForOtherSources.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        checkMonthlySalaryCompensation.setEnabled(value);
        txtMonthlySalaryCompensation.setEditable(value);
        checkSourceBusiness.setEnabled(value);
        txtBusinessNature.setEditable(value);
        optionBusinessRegistered.setEnabled(value);
        optionBusinessNotRegistered.setEnabled(value);
        txtMonthlyIncomeForBusiness.setEditable(value);
        checkSourceFarmProducts.setEnabled(value);
        checkFarmAgri.setEnabled(value);
        checkFarmLiveStock.setEnabled(value);
        txtAgri.setEditable(value);
        txtLiveStock.setEditable(value);
        txtBusinessNature.setEditable(value);
        txtFarmHarvestSchedule.setEditable(value);
        txtFarmAvgProductIncome.setEditable(value);
        txtMonthlyIncomeForFarmProducts.setEditable(value);
        checkSourceOthers.setEnabled(value);
        txtOtherSourceDesc.setEditable(value);
        txtMonthlyIncomeForOtherSources.setEditable(value);

        checkMonthlySalaryCompensation.setFocusable(value);
        txtMonthlySalaryCompensation.setFocusable(value);
        checkSourceBusiness.setFocusable(value);
        txtBusinessNature.setFocusable(value);
        optionBusinessRegistered.setFocusable(value);
        optionBusinessNotRegistered.setFocusable(value);
        txtMonthlyIncomeForBusiness.setFocusable(value);
        checkSourceFarmProducts.setFocusable(value);
        checkFarmAgri.setFocusable(value);
        checkFarmLiveStock.setFocusable(value);
        txtAgri.setFocusable(value);
        txtLiveStock.setFocusable(value);
        txtBusinessNature.setFocusable(value);
        txtFarmHarvestSchedule.setFocusable(value);
        txtFarmAvgProductIncome.setFocusable(value);
        txtMonthlyIncomeForFarmProducts.setFocusable(value);
        checkSourceOthers.setFocusable(value);
        txtOtherSourceDesc.setFocusable(value);
        txtMonthlyIncomeForOtherSources.setFocusable(value);

        if (value) {
            checkMonthlySalaryCompensation.requestFocus();
        }
    }

    public void resetToDefault() {
        checkMonthlySalaryCompensation.setSelected(false);
        txtMonthlySalaryCompensation.setText("");
        checkSourceBusiness.setSelected(false);
        txtBusinessNature.setText("");
        optionBusinessRegistered.setSelected(true);
        optionBusinessNotRegistered.setSelected(false);
        txtMonthlyIncomeForBusiness.setText("");
        checkSourceFarmProducts.setSelected(false);
        checkFarmAgri.setSelected(false);
        checkFarmLiveStock.setSelected(false);
        txtFarmHarvestSchedule.setText("");
        txtFarmAvgProductIncome.setText("");
        txtMonthlyIncomeForFarmProducts.setText("");
        checkSourceOthers.setSelected(false);
        txtOtherSourceDesc.setText("");
        txtMonthlyIncomeForOtherSources.setText("");
    }

    public void setSourceOfIncomeData(Object o) {
        if (o == null) {
            resetToDefault();
//            totalMonthlyIncome((SourceOfIncome) o);
        } else {
            SourceOfIncome s = (SourceOfIncome) o;
            /* Monthly Salary Compensation */
            if (s.getIncSalary() > 0) {
                checkMonthlySalaryCompensation.setSelected(true);
            } else {
                checkMonthlySalaryCompensation.setSelected(false);
            }
            txtMonthlySalaryCompensation.setText(new BigDecimal(s.getIncSalary()).toPlainString());

            /* Business */
            if (s.getIncBusiness() > 0) {
                checkSourceBusiness.setSelected(true);
            } else {
                checkSourceBusiness.setSelected(false);
            }
            txtBusinessNature.setText(s.getIncNature());
            if (s.isIncRegistered()) {
                optionBusinessRegistered.setSelected(true);
                optionBusinessNotRegistered.setSelected(false);
            } else {
                optionBusinessRegistered.setSelected(false);
                optionBusinessNotRegistered.setSelected(true);
            }
            txtMonthlyIncomeForBusiness.setText(new BigDecimal(s.getIncBusiness()).toPlainString());

            /* Farm Products */
            if (s.getIncFarm() > 0) {
                checkSourceFarmProducts.setSelected(true);
            } else {
                checkSourceFarmProducts.setSelected(false);
            }
            if (!s.getIncArgriculture().equals("") || !s.getIncArgriculture().equals(" ")) {
                checkFarmAgri.setSelected(true);
            } else {
                checkFarmAgri.setSelected(false);
            }
            txtAgri.setText(s.getIncArgriculture());
            if (!s.getIncLiveStock().equals("") || !s.getIncLiveStock().equals(" ")) {
                checkFarmLiveStock.setSelected(true);
            } else {
                checkFarmLiveStock.setSelected(false);
            }
            txtLiveStock.setText(s.getIncLiveStock());
            txtFarmHarvestSchedule.setText(s.getIncHarvestDate());
            txtFarmAvgProductIncome.setText(new BigDecimal(s.getIncAverageProd()).toPlainString());
            txtMonthlyIncomeForFarmProducts.setText(new BigDecimal(s.getIncFarm()).toPlainString());

            /* Other Sources */
            if (s.getIncOther() > 0) {
                checkSourceOthers.setSelected(true);
            } else {
                checkSourceOthers.setSelected(false);
            }
            txtOtherSourceDesc.setText(s.getIncOtherSource());
            txtMonthlyIncomeForOtherSources.setText(new BigDecimal(s.getIncOther()).toPlainString());
//            totalMonthlyIncome(s);
        }
    }

    public boolean saveSourceOfIncome() {
        Object o = null;
        try {
            o = SourceOfIncomeController.getInstance().createNew(createNew(new SourceOfIncome()), headerPanel.getFormNo(), personType, clientNo);
        } catch (ParseException ex) {
            UIValidator.log(ex, SourceOfIncomePanel.class);
        }
        setSourceOfIncome((SourceOfIncome) o);
        return o != null;
    }

    public boolean updateSourceOfIncome() {
        Object o = null;
        try {
            o = SourceOfIncomeController.getInstance().update(headerPanel.getFormNo(), createNew(sourceOfIncome));
        } catch (ParseException ex) {
            UIValidator.log(ex, SourceOfIncomePanel.class);
        }
        setSourceOfIncome((SourceOfIncome) o);
        return o != null;
    }

    public boolean saveCoMakerSourceOfIncome() {
        Object o = null;
        try {
            o = SourceOfIncomeController.getInstance().createNew(createNew(new SourceOfIncome()), headerPanel.getFormNo(), mainPanel.getSelectedCoMaker().getPersonType().getTypeID(), mainPanel.getSelectedCoMaker().getClientNo());
        } catch (ParseException ex) {
            UIValidator.log(ex, SourceOfIncomePanel.class);
        }
        setSourceOfIncome((SourceOfIncome) o);
        return o != null;
    }

    public void totalMonthlyIncome(SourceOfIncome s) {
        txtTotalMonthlyIncome.setText(SourceOfIncomeController.getInstance().computeTotalMonthlyIncome(s).toPlainString());
    }

    private SourceOfIncome createNew(SourceOfIncome s) throws ParseException {
        if (checkMonthlySalaryCompensation.isSelected()) {
            s.setIncSalary(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlySalaryCompensation.getText())).doubleValue());
        } else {
            s.setIncSalary(0);
        }
        if (checkSourceBusiness.isSelected()) {
            s.setIncNature(txtBusinessNature.getText());
            if (optionBusinessRegistered.isSelected()) {
                s.setIncRegistered(true);
            } else {
                s.setIncRegistered(false);
            }
            s.setIncBusiness(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyIncomeForBusiness.getText())).doubleValue());
        } else {
            s.setIncNature("");
            s.setIncRegistered(false);
            s.setIncBusiness(0);
        }
        if (checkSourceFarmProducts.isSelected()) {
            if (checkFarmAgri.isSelected()) {
                s.setIncArgriculture(txtAgri.getText());
            } else {
                s.setIncArgriculture("");
            }
            if (checkFarmLiveStock.isSelected()) {
                s.setIncLiveStock(txtBusinessNature.getText());
            } else {
                s.setIncLiveStock("");
            }
            s.setIncHarvestDate(DateUtil.toString(txtFarmHarvestSchedule.getDate(), "yyyy-MM-dd"));
            s.setIncAverageProd(new BigDecimal(UIValidator.MoneyCommaRemover(txtFarmAvgProductIncome.getText())).doubleValue());
            s.setIncFarm(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyIncomeForFarmProducts.getText())).doubleValue());
        } else {
            s.setIncArgriculture("");
            s.setIncLiveStock("");
            s.setIncAverageProd(0);
            s.setIncFarm(0);
        }
        if (checkSourceOthers.isSelected()) {
            s.setIncOtherSource(txtOtherSourceDesc.getText());
            s.setIncOther(new BigDecimal(UIValidator.MoneyCommaRemover(txtMonthlyIncomeForOtherSources.getText())).doubleValue());
        } else {
            s.setIncOtherSource("");
            s.setIncOther(0);
        }

        return s;
    }
}
