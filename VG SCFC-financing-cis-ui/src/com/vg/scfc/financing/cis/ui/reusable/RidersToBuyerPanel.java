/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.Identification;
import com.vg.scfc.financing.cis.ui.controller.RidersToBuyerController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

/**
 *
 * @author rodel
 */
public class RidersToBuyerPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form RidersToBuyerPanel
     */
    public RidersToBuyerPanel() {
        initComponents();
        initKeyListeners();
    }

    private void initKeyListeners() {
        txtCompetent.addKeyListener(this);
        txtIdNo.addKeyListener(this);
        txtPlaceOfIssue.addKeyListener(this);
        txtIssueDate.addKeyListener(this);
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
        txtCompetent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFormNo1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPlaceOfIssue = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        try {
            txtIssueDate = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdNo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFormNo4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("I certify that the above Information I have disclosed in the SouthPoint Credit and Finance Corp. Credit Application Form is true and correct to the best of my knowledge and belief.");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 860, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("I hereby authorize its representative to conduct the corresponding credit investigation thereon.");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 25, 860, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Competent Evidence of Identity:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 160, -1));

        txtCompetent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompetentFocusLost(evt);
            }
        });
        add(txtCompetent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 42, 150, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID No.");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 45, 30, -1));
        add(txtFormNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 90, 80, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Place of Issue:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 45, 80, -1));

        txtPlaceOfIssue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPlaceOfIssueFocusLost(evt);
            }
        });
        add(txtPlaceOfIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 42, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Date of Issue:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 45, 70, -1));

        txtIssueDate.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 42, 90, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("INFORMATION REQUIRED UNDER R.A. 3765");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 230, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("1)Cash/Delivered Price. 2)Downpayment. 3)Difference Between 1&2. 4)Non-finance Charges 4A)");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 95, 480, -1));

        txtIdNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdNoFocusLost(evt);
            }
        });
        add(txtIdNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 42, 100, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("4B)");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 95, 20, -1));
        add(txtFormNo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 80, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("5)Total financed.");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 95, 100, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("6)Finance charges. 7)Simple annual percentage rate.");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 860, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("I have read and agreed to the above terms and conditions and to all stipulated in the Contract of Sale with Reservation of the Title/Chattel Mortgage to be executed if this proposal");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 135, 860, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("is accepted. The above stipulations contain all terms and conditions of this proposed purchase. ");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 155, 860, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("I hereby certify that I have been duly furnished the above prior to the instant credit sale transaction.");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 175, 860, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdNoFocusLost
        txtIdNo.setText(txtIdNo.getText().toUpperCase());
    }//GEN-LAST:event_txtIdNoFocusLost

    private void txtPlaceOfIssueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlaceOfIssueFocusLost
        txtPlaceOfIssue.setText(txtPlaceOfIssue.getText().toUpperCase());
    }//GEN-LAST:event_txtPlaceOfIssueFocusLost

    private void txtCompetentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompetentFocusLost
        txtCompetent.setText(txtCompetent.getText().toUpperCase());
    }//GEN-LAST:event_txtCompetentFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCompetent;
    private javax.swing.JTextField txtFormNo1;
    private javax.swing.JTextField txtFormNo4;
    private javax.swing.JTextField txtIdNo;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtIssueDate;
    private javax.swing.JTextField txtPlaceOfIssue;
    // End of variables declaration//GEN-END:variables
    private Identification identification;
    private HeaderPanel headerPanel;
    private String personType;

    public void setIdentification(Identification identification) {
        this.identification = identification;
        setRidersToBuyerValues(this.identification);
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setFieldsEditable(boolean value) {
        txtCompetent.setEditable(value);
        txtIdNo.setEditable(value);
        txtPlaceOfIssue.setEditable(value);
        txtIssueDate.setEditable(value);

        txtCompetent.setFocusable(value);
        txtIdNo.setFocusable(value);
        txtPlaceOfIssue.setFocusable(value);
        txtIssueDate.setFocusable(value);

        if (value) {
            txtCompetent.requestFocus();
        }
    }

    public void resetToDefault() {
        txtCompetent.setText("");
        txtIdNo.setText("");
        txtIssueDate.setText("");
        txtPlaceOfIssue.setText("");
    }

    private Identification createNew(Identification i) {
        try {
            i.setDateOfIssue(txtIssueDate.getDate());
        } catch (ParseException ex) {
            UIValidator.log(ex, RidersToBuyerPanel.class);
        }
        i.setIdNo(txtIdNo.getText());
        i.setPlaceOfIssue(txtPlaceOfIssue.getText());
        i.setIssuedBy(txtCompetent.getText());
        return i;
    }

    public void setRidersToBuyerValues(Identification i) {
        if (i == null) {
            resetToDefault();
        } else {
            txtCompetent.setText(i.getIssuedBy());
            txtIdNo.setText(i.getIdNo());
            txtIssueDate.setDate(i.getDateOfIssue());
            txtPlaceOfIssue.setText(i.getPlaceOfIssue());
        }
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
                if (txtCompetent.isFocusOwner()) {
                txtIdNo.requestFocus();
            } else if (txtIdNo.isFocusOwner()) {
                txtPlaceOfIssue.requestFocus();
            } else if (txtPlaceOfIssue.isFocusOwner()) {
                txtIssueDate.requestFocus();
            }
                break;
        }
    }

    public boolean saveAgreement() {
        System.out.println("Saving for " + headerPanel.getFormNo() + " (" + personType + ")...");
        Identification i = RidersToBuyerController.getInstance().save(headerPanel.getFormNo(), personType, createNew(new Identification()));
        setIdentification(i);
        return i != null;
    }
}
