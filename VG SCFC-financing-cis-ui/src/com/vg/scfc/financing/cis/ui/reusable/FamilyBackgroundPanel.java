/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.Family;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import com.vg.scfc.financing.cis.ui.controller.FamilyBackgroundController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;

/**
 *
 * @author rodel
 */
public class FamilyBackgroundPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form FamilyBackgroundPanel
     */
    public FamilyBackgroundPanel() {
        initComponents();
        initTextBoxListener();
        startUpSettings();
    }
    
    private void startUpSettings() {
        setFieldsEditable(false);
    }

    /**
     * Set Textbox Listener
     */
    private void initTextBoxListener() {
        txtFatherName.addKeyListener(this);
        txtFatherAddress.addKeyListener(this);
        txtFatherOccupation.addKeyListener(this);
        txtFatherAge.addKeyListener(this);
        txtMotherName.addKeyListener(this);
        txtMotherAddress.addKeyListener(this);
        txtMotherOccupation.addKeyListener(this);
        txtMotherAge.addKeyListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtFatherAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFatherOccupation = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFatherName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMotherAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMotherOccupation = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMotherName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFatherAge = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMotherAge = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Father's Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        txtFatherAddress.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtFatherAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFatherAddressFocusLost(evt);
            }
        });
        add(txtFatherAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 290, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Address");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));

        txtFatherOccupation.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtFatherOccupation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFatherOccupationFocusLost(evt);
            }
        });
        add(txtFatherOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 55, 160, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Occupation");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        txtFatherName.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtFatherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFatherNameFocusLost(evt);
            }
        });
        add(txtFatherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 5, 290, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Mother's Name");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, -1, -1));

        txtMotherAddress.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMotherAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMotherAddressFocusLost(evt);
            }
        });
        add(txtMotherAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 105, 290, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Address");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        txtMotherOccupation.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMotherOccupation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMotherOccupationFocusLost(evt);
            }
        });
        add(txtMotherOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 160, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("Occupation");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 135, -1, -1));

        txtMotherName.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMotherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMotherNameFocusLost(evt);
            }
        });
        add(txtMotherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 290, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setText("Age");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        txtFatherAge.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtFatherAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFatherAgeFocusLost(evt);
            }
        });
        add(txtFatherAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 55, 75, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("Age");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 135, -1, -1));

        txtMotherAge.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtMotherAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMotherAgeFocusLost(evt);
            }
        });
        add(txtMotherAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 130, 75, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtFatherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFatherNameFocusLost
        fathersName = UIValidator.validate(txtFatherName);
    }//GEN-LAST:event_txtFatherNameFocusLost

    private void txtFatherAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFatherAddressFocusLost
        fathersAddress = UIValidator.validate(txtFatherAddress);
    }//GEN-LAST:event_txtFatherAddressFocusLost

    private void txtFatherOccupationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFatherOccupationFocusLost
        fathersOccupation = UIValidator.validate(txtFatherOccupation);
    }//GEN-LAST:event_txtFatherOccupationFocusLost

    private void txtFatherAgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFatherAgeFocusLost
        fathersAge = Integer.parseInt(UIValidator.isNumeric(txtFatherAge));
    }//GEN-LAST:event_txtFatherAgeFocusLost

    private void txtMotherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMotherNameFocusLost
        mothersName = UIValidator.validate(txtMotherName);
    }//GEN-LAST:event_txtMotherNameFocusLost

    private void txtMotherAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMotherAddressFocusLost
        mothersAddress = UIValidator.validate(txtMotherAddress);
    }//GEN-LAST:event_txtMotherAddressFocusLost

    private void txtMotherOccupationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMotherOccupationFocusLost
        mothersOccupation = UIValidator.validate(txtMotherAddress);
    }//GEN-LAST:event_txtMotherOccupationFocusLost

    private void txtMotherAgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMotherAgeFocusLost
        mothersAge = Integer.parseInt(UIValidator.isNumeric(txtMotherAge));
    }//GEN-LAST:event_txtMotherAgeFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtFatherAddress;
    private javax.swing.JTextField txtFatherAge;
    private javax.swing.JTextField txtFatherName;
    private javax.swing.JTextField txtFatherOccupation;
    private javax.swing.JTextField txtMotherAddress;
    private javax.swing.JTextField txtMotherAge;
    private javax.swing.JTextField txtMotherName;
    private javax.swing.JTextField txtMotherOccupation;
    // End of variables declaration//GEN-END:variables
    private String fathersName;
    private String fathersAddress;
    private String fathersOccupation;
    private int fathersAge;
    private String mothersName;
    private String mothersAddress;
    private String mothersOccupation;
    private int mothersAge;

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
                if (txtFatherName.isFocusOwner()) {
                txtFatherAddress.requestFocus();
            } else if (txtFatherAddress.isFocusOwner()) {
                txtFatherOccupation.requestFocus();
            } else if (txtFatherOccupation.isFocusOwner()) {
                txtFatherAge.requestFocus();
            } else if (txtFatherAge.isFocusOwner()) {
                txtMotherName.requestFocus();
            } else if (txtMotherName.isFocusOwner()) {
                txtMotherAddress.requestFocus();
            } else if (txtMotherAddress.isFocusOwner()) {
                txtMotherOccupation.requestFocus();
            } else if (txtMotherOccupation.isFocusOwner()) {
                txtMotherAge.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtMotherAge.isFocusOwner()) {
                txtMotherOccupation.requestFocus();
            } else if (txtMotherOccupation.isFocusOwner()) {
                txtMotherAddress.requestFocus();
            } else if (txtMotherAddress.isFocusOwner()) {
                txtMotherName.requestFocus();
            } else if (txtMotherName.isFocusOwner()) {
                txtFatherAge.requestFocus();
            } else if (txtFatherAge.isFocusOwner()) {
                txtFatherOccupation.requestFocus();
            } else if (txtFatherOccupation.isFocusOwner()) {
                txtFatherAddress.requestFocus();
            } else if (txtFatherAddress.isFocusOwner()) {
                txtFatherName.requestFocus();
            }
                break;
        }
    }

    public void setFamilyBackground(List<Object> objects) {
        if (objects == null || objects.isEmpty()) {
            resetToDefault();
        } else {
            for (Object object : objects) {
                Family f = (Family) object;
                switch (f.getFamRelation()) {
                    case "FATHER":
                        txtFatherName.setText(f.getFamName());
                        txtFatherAddress.setText(f.getFamAddress());
                        txtFatherOccupation.setText(f.getFamOccupation());
//                        txtFatherAge.setText(f.getFamAge());
                        break;
                    case "MOTHER":
                        txtMotherName.setText(f.getFamName());
                        txtMotherName.setText(f.getFamAddress());
                        txtMotherName.setText(f.getFamOccupation());
//                        txtMotherName.setText(f.getFamAge());
                        break;
                }
            }
        }
    }

    public void setFieldsEditable(boolean value) {
        txtFatherName.setEditable(value);
        txtFatherAddress.setEditable(value);
        txtFatherOccupation.setEditable(value);
        txtFatherAge.setEditable(value);
        txtMotherName.setEditable(value);
        txtMotherAddress.setEditable(value);
        txtMotherAge.setEditable(value);
        txtMotherOccupation.setEditable(value);
    }

    public void resetToDefault() {
        txtFatherName.setText("");
        txtFatherAddress.setText("");
        txtFatherOccupation.setText("");
        txtFatherAge.setText("");
        txtMotherName.setText("");
        txtMotherAddress.setText("");
        txtMotherAge.setText("");
        txtMotherOccupation.setText("");
    }

    public boolean saveFamilyBackground() {
        List<Object> objects = FamilyBackgroundController.getInstance().createNew(fathersName, fathersAddress, fathersOccupation, fathersAge, mothersName, mothersAddress, mothersOccupation, mothersAge);
        setFamilyBackground(objects);
        return objects != null && !objects.isEmpty();
    }

    public boolean updateFamilyBackground() {
        List<Object> objects = FamilyBackgroundController.getInstance().update("", fathersName, fathersAddress, fathersOccupation, fathersAge, mothersName, mothersAddress, mothersOccupation, mothersAge);
        setFamilyBackground(objects);
        return objects != null && !objects.isEmpty();
    }
}
