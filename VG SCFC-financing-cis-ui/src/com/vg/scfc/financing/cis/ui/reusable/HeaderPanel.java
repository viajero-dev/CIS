/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.Color;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author rodel
 */
public class HeaderPanel extends javax.swing.JPanel {

    /**
     * Creates new form HeaderPanel
     */
    public HeaderPanel() {
        initComponents();
        setApplicationStatus("");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIDNo = new javax.swing.JTextField();
        txtFormNo = new javax.swing.JTextField();
        labelApplicationStatus = new javax.swing.JLabel();
        try {
            txtAppDate = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SOUTHPOINT CREDIT AND FINANCE CORP.");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, 1040, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CREDIT APPLICATION FORM");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 28, 1040, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("All Information will be treated confidential. Please print legibly and check appropriate boxes");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 48, 1040, -1));

        txtIDNo.setEditable(false);
        txtIDNo.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtIDNo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIDNo.setText("00000");
        txtIDNo.setFocusable(false);
        add(txtIDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(958, 35, 70, -1));

        txtFormNo.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtFormNo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFormNo.setText("00000");
        add(txtFormNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(958, 35, 70, -1));

        labelApplicationStatus.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        labelApplicationStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelApplicationStatus.setText("APPROVED");
        add(labelApplicationStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 5, 280, -1));

        txtAppDate.setEditable(false);
        txtAppDate.setFocusable(false);
        txtAppDate.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtAppDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(958, 60, 70, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Application Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 65, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Form No");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelApplicationStatus;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtAppDate;
    private javax.swing.JTextField txtFormNo;
    private javax.swing.JTextField txtIDNo;
    // End of variables declaration//GEN-END:variables

    public void setApplicationStatus(String status) {
        switch (status) {
            case "APPROVED":
                labelApplicationStatus.setText("APPROVED");
                labelApplicationStatus.setForeground(Color.DARK_GRAY);
                break;
            case "DISAPPROVED":
                labelApplicationStatus.setText("DISAPPROVED");
                labelApplicationStatus.setForeground(Color.RED);
                break;
            default:
                labelApplicationStatus.setText("PENDING");
                labelApplicationStatus.setForeground(Color.BLUE);
                break;
        }
    }

    public void setFormNo(String formNo) {
        txtFormNo.setText(formNo);
    }
    
    public String getFormNo() {
        return txtFormNo.getText().toUpperCase().trim();
    }
    
    public void setIDNo(String IDNo) {
        txtIDNo.setText(IDNo);
    }
    
    public String getIDNo() {
        return txtIDNo.getText();
    }

    public Date getApplicationDate() {
        Date result = new Date();
        try {
            result = txtAppDate.getDate();
        } catch (ParseException ex) {
            UIValidator.log(ex, HeaderPanel.class);
        }
        return result;
    }
    
    public void setApplicationDate(Date date) {
        txtAppDate.setDate(date);
    }
    
    public void enableFields(boolean value) {
        txtFormNo.setEditable(value);
        txtFormNo.setFocusable(value);
        txtAppDate.setEditable(value);
        txtAppDate.setFocusable(value);
    }

}
