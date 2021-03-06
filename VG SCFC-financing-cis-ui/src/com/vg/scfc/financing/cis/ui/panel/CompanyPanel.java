/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.panel;

import com.vg.scfc.financing.cis.ent.Company;
import com.vg.scfc.financing.cis.ui.controller.CompanyController;
import com.vg.scfc.financing.cis.ui.reusable.HeaderPanel;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author rodel
 */
public class CompanyPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form CompanyPanel
     */
    public CompanyPanel() {
        initComponents();
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
        txtOwner = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtOfficeAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNatureBusiness = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtYearOfOperation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTIN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBussPermitNo = new javax.swing.JTextField();
        try {
            txtIssuedOn = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        try {
            txtExpireOn = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Owner/President");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        txtOwner.setToolTipText("Press F5 to search");
        txtOwner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOwnerFocusLost(evt);
            }
        });
        add(txtOwner, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 5, 230, -1));

        jLabel2.setText("Principal Office Address");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));

        txtOfficeAddress.setToolTipText("Press F5 to search");
        txtOfficeAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOfficeAddressFocusLost(evt);
            }
        });
        add(txtOfficeAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 435, -1));

        jLabel3.setText("Nature of Business");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        txtNatureBusiness.setToolTipText("Press F5 to search");
        txtNatureBusiness.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNatureBusinessFocusLost(evt);
            }
        });
        add(txtNatureBusiness, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 55, 150, -1));

        jLabel4.setText("Years of Operation");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        txtYearOfOperation.setToolTipText("Press F5 to search");
        txtYearOfOperation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtYearOfOperationFocusLost(evt);
            }
        });
        add(txtYearOfOperation, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 55, 140, -1));

        jLabel5.setText("Contact #");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, -1, -1));

        jLabel6.setText("Expires On");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 135, -1, -1));

        txtEmail.setToolTipText("Press F5 to search");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 80, 210, -1));

        jLabel7.setText("Tax Identification (T. I. N.)");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        txtContact.setToolTipText("Press F5 to search");
        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactFocusLost(evt);
            }
        });
        add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 150, -1));

        jLabel8.setText("E mail");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 85, -1, -1));

        jLabel9.setText("Issued On");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 135, -1, -1));

        txtTIN.setToolTipText("Press F5 to search");
        txtTIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTINFocusLost(evt);
            }
        });
        add(txtTIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 105, 150, -1));

        jLabel10.setText("Buss. Permit No.");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        txtBussPermitNo.setToolTipText("Press F5 to search");
        txtBussPermitNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBussPermitNoFocusLost(evt);
            }
        });
        add(txtBussPermitNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 105, 140, -1));

        txtIssuedOn.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtIssuedOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 150, -1));

        txtExpireOn.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtExpireOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 130, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtOwnerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOwnerFocusLost
        txtOwner.setText(UIValidator.validate(txtOwner));
    }//GEN-LAST:event_txtOwnerFocusLost

    private void txtOfficeAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOfficeAddressFocusLost
        txtOfficeAddress.setText(UIValidator.validate(txtOfficeAddress));
    }//GEN-LAST:event_txtOfficeAddressFocusLost

    private void txtNatureBusinessFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNatureBusinessFocusLost
        txtNatureBusiness.setText(UIValidator.validate(txtNatureBusiness));
    }//GEN-LAST:event_txtNatureBusinessFocusLost

    private void txtYearOfOperationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYearOfOperationFocusLost
        txtYearOfOperation.setText(UIValidator.isNumeric(txtYearOfOperation));
    }//GEN-LAST:event_txtYearOfOperationFocusLost

    private void txtContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusLost
        txtContact.setText(UIValidator.isNumeric(txtContact));
    }//GEN-LAST:event_txtContactFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        txtEmail.setText(UIValidator.validate(txtEmail));
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtTINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTINFocusLost
        txtTIN.setText(UIValidator.isNumeric(txtTIN));
    }//GEN-LAST:event_txtTINFocusLost

    private void txtBussPermitNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBussPermitNoFocusLost
        txtBussPermitNo.setText(UIValidator.isNumeric(txtBussPermitNo));
    }//GEN-LAST:event_txtBussPermitNoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBussPermitNo;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtExpireOn;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtIssuedOn;
    private javax.swing.JTextField txtNatureBusiness;
    private javax.swing.JTextField txtOfficeAddress;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JTextField txtTIN;
    private javax.swing.JTextField txtYearOfOperation;
    // End of variables declaration//GEN-END:variables
    private HeaderPanel headerPanel;
    private String companyName;
    private Company company;

    public void setCompany(Company company) {
        this.company = company;
        setCompanyInfo(this.company);
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
            case KeyEvent.VK_TAB:
            case KeyEvent.VK_ENTER:
                if (txtOwner.isFocusOwner()) {
                txtOfficeAddress.requestFocus();
            } else if (txtOfficeAddress.isFocusOwner()) {
                txtNatureBusiness.requestFocus();
            } else if (txtNatureBusiness.isFocusOwner()) {
                txtYearOfOperation.requestFocus();
            } else if (txtYearOfOperation.isFocusOwner()) {
                txtContact.requestFocus();
            } else if (txtContact.isFocusOwner()) {
                txtEmail.requestFocus();
            } else if (txtEmail.isFocusOwner()) {
                txtTIN.requestFocus();
            } else if (txtTIN.isFocusOwner()) {
                txtBussPermitNo.requestFocus();
            } else if (txtBussPermitNo.isFocusOwner()) {
                txtIssuedOn.requestFocus();
            } else if (txtIssuedOn.isFocusOwner()) {
                txtExpireOn.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtExpireOn.isFocusOwner()) {
                txtIssuedOn.requestFocus();
            } else if (txtIssuedOn.isFocusOwner()) {
                txtBussPermitNo.requestFocus();
            } else if (txtBussPermitNo.isFocusOwner()) {
                txtTIN.requestFocus();
            } else if (txtTIN.isFocusOwner()) {
                txtEmail.requestFocus();
            } else if (txtEmail.isFocusOwner()) {
                txtContact.requestFocus();
            } else if (txtContact.isFocusOwner()) {
                txtYearOfOperation.requestFocus();
            } else if (txtYearOfOperation.isFocusOwner()) {
                txtNatureBusiness.requestFocus();
            } else if (txtNatureBusiness.isFocusOwner()) {
                txtOfficeAddress.requestFocus();
            } else if (txtOfficeAddress.isFocusOwner()) {
                txtOwner.requestFocus();
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtOwner.setEditable(value);
        txtOfficeAddress.setEditable(value);
        txtNatureBusiness.setEditable(value);
        txtYearOfOperation.setEditable(value);
        txtTIN.setEditable(value);
        txtBussPermitNo.setEditable(value);
        txtContact.setEditable(value);
        txtEmail.setEditable(value);
        txtIssuedOn.setEditable(value);
        txtExpireOn.setEditable(value);
        
        txtOwner.setFocusable(value);
        txtOfficeAddress.setFocusable(value);
        txtNatureBusiness.setFocusable(value);
        txtYearOfOperation.setFocusable(value);
        txtTIN.setFocusable(value);
        txtBussPermitNo.setFocusable(value);
        txtContact.setFocusable(value);
        txtEmail.setFocusable(value);
        txtIssuedOn.setFocusable(value);
        txtExpireOn.setFocusable(value);
        
        if(value) {
            txtOwner.requestFocus();
        }
    }

    public void resetToDefault() {
        txtOwner.setText("");
        txtOfficeAddress.setText("");
        txtNatureBusiness.setText("");
        txtYearOfOperation.setText("");
        txtTIN.setText("");
        txtBussPermitNo.setText("");
        txtContact.setText("");
        txtEmail.setText("");
        txtIssuedOn.setDate(new Date());
        txtExpireOn.setDate(new Date());
    }

    public void setCompanyInfo(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            Company c = (Company) o;
            txtOwner.setText(c.getPresident());
            txtOfficeAddress.setText(c.getAddress());
            txtNatureBusiness.setText(c.getNatureOfBusiness());
            txtYearOfOperation.setText(c.getYearOfService() + "");
            txtTIN.setText(c.getTin());
            txtBussPermitNo.setText(c.getBusinessPermitNo());
            txtContact.setText(c.getContactNo());
            txtEmail.setText(c.getEmail());
            txtIssuedOn.setDate(c.getIssuedDate());
            txtExpireOn.setDate(c.getExpirationDate());
        }
    }

    public boolean saveCompanyInformation() {
        Company c = CompanyController.getInstance().createNew(createNew(new Company()), headerPanel.getFormNo(), headerPanel.getApplicationDate(), companyName);
        setCompany(c);
        return c != null;
    }

    public boolean updateCompanyInformation() {
        return true;
    }

    private Company createNew(Company c) {
        c.setPresident(txtOwner.getText());
        c.setAddress(txtOfficeAddress.getText());
        c.setNatureOfBusiness(txtNatureBusiness.getText());
        if (txtYearOfOperation.getText().equals("")) {
            c.setYearOfService(0);
        } else {
            c.setYearOfService(Integer.parseInt(txtYearOfOperation.getText()));
        }
        c.setContactNo(txtContact.getText());
        c.setTin(txtTIN.getText());
        c.setEmail(txtEmail.getText());
        c.setBusinessPermitNo(txtBussPermitNo.getText());
        try {
            c.setIssuedDate(txtIssuedOn.getDate());
            c.setExpirationDate(txtExpireOn.getDate());
        } catch (ParseException ex) {
            UIValidator.log(ex, CompanyPanel.class);
        }
        return c;
    }
}
