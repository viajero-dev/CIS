/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.Address;
import com.vg.scfc.financing.cis.ui.controller.AddressController;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import com.vg.scfc.financing.commons.ent.Barangay;
import com.vg.scfc.financing.commons.ui.dlg.BarangayDlg;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author rodel
 */
public class SimpleAddressPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form SimpleAddressPanel
     */
    public SimpleAddressPanel() {
        initComponents();
        initKeyListeners();
        initOptionGroup();
    }
    
    private void initKeyListeners() {
        txtBrgy.addKeyListener(this);
        txtZipcode.addKeyListener(this);
        txtStreet.addKeyListener(this);
        optionAddressOwned.addKeyListener(this);
        optionAddressRenting.addKeyListener(this);
        optionAddressLiving.addKeyListener(this);
        optionAddressOthers.addKeyListener(this);
        txtYrsOfStay.addKeyListener(this);
    }
    
    private void initOptionGroup() {
        optionAddressGroup.add(optionAddressOwned);
        optionAddressGroup.add(optionAddressRenting);
        optionAddressGroup.add(optionAddressLiving);
        optionAddressGroup.add(optionAddressOthers);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionAddressGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBrgy = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtZipcode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        optionAddressOwned = new javax.swing.JRadioButton();
        optionAddressRenting = new javax.swing.JRadioButton();
        optionAddressLiving = new javax.swing.JRadioButton();
        optionAddressOthers = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtYrsOfStay = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Brgy.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setText("Description");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtBrgy.setToolTipText("Press F5 to search");
        add(txtBrgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 5, 80, -1));

        txtDesc.setEditable(false);
        txtDesc.setToolTipText("Press F5 to search");
        txtDesc.setFocusable(false);
        add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 500, -1));

        jLabel2.setText("Zipcode");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        txtZipcode.setToolTipText("Press F5 to search");
        txtZipcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtZipcodeFocusLost(evt);
            }
        });
        add(txtZipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 5, 80, -1));

        jLabel3.setText("Street");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        txtStreet.setToolTipText("Press F5 to search");
        txtStreet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStreetFocusLost(evt);
            }
        });
        add(txtStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, 230, -1));

        jLabel5.setText("Status");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        optionAddressOwned.setSelected(true);
        optionAddressOwned.setText("Owned");
        add(optionAddressOwned, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 55, -1, -1));

        optionAddressRenting.setText("Renting");
        add(optionAddressRenting, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 55, -1, -1));

        optionAddressLiving.setText("Living with Parents/Relatives");
        add(optionAddressLiving, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, -1, -1));

        optionAddressOthers.setText("Others");
        add(optionAddressOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 55, -1, -1));

        jLabel6.setText("Yrs. of stay");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        txtYrsOfStay.setToolTipText("Press F5 to search");
        txtYrsOfStay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtYrsOfStayFocusLost(evt);
            }
        });
        add(txtYrsOfStay, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 55, 80, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 580, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void txtZipcodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtZipcodeFocusLost
        txtZipcode.setText(UIValidator.validate(txtZipcode));
    }//GEN-LAST:event_txtZipcodeFocusLost

    private void txtStreetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStreetFocusLost
        txtStreet.setText(UIValidator.validate(txtStreet));
        txtDesc.setText(txtStreet.getText() + "," + txtDesc.getText());
    }//GEN-LAST:event_txtStreetFocusLost

    private void txtYrsOfStayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYrsOfStayFocusLost
        txtYrsOfStay.setText(UIValidator.isNumeric(txtYrsOfStay));
        setAddress(createNew(new Address()));
    }//GEN-LAST:event_txtYrsOfStayFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.ButtonGroup optionAddressGroup;
    private javax.swing.JRadioButton optionAddressLiving;
    private javax.swing.JRadioButton optionAddressOthers;
    private javax.swing.JRadioButton optionAddressOwned;
    private javax.swing.JRadioButton optionAddressRenting;
    private javax.swing.JTextField txtBrgy;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtYrsOfStay;
    private javax.swing.JTextField txtZipcode;
    // End of variables declaration//GEN-END:variables
    private String addressType;
    private String formNo;
    private String personType;
    private Barangay barangay;
    private Address address;
    private JDialog dialog;

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setBarangay(Barangay barangay) {
        this.barangay = barangay;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    private Address createNew(Address a) {
        a.setBrgyCode(txtBrgy.getText());
        a.setBrgyDesc(barangay.getAddress());
        a.setZipCode(txtZipcode.getText());
        a.setAddress(txtStreet.getText());
        a.setAddressType(addressType);
        if (optionAddressOwned.isSelected()) {
            a.setStatus("OWNED");
        }
        if (optionAddressRenting.isSelected()) {
            a.setStatus("RENTING");
        }
        if (optionAddressLiving.isSelected()) {
            a.setStatus("LIVING WITH PARENTS/RELATIVES");
        }
        if (optionAddressOthers.isSelected()) {
            a.setStatus("OTHERS");
        }
        a.setYearsOfStay(txtYrsOfStay.getText());
        return a;
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
                if (txtBrgy.isFocusOwner()) {
                txtZipcode.requestFocus();
            } else if (txtZipcode.isFocusOwner()) {
                txtStreet.requestFocus();
            } else if (txtStreet.isFocusOwner()) {
                optionAddressOwned.requestFocus();
            } else if (optionAddressOwned.isFocusOwner()) {
                optionAddressRenting.requestFocus();
            } else if (optionAddressRenting.isFocusOwner()) {
                optionAddressLiving.requestFocus();
            } else if (optionAddressLiving.isFocusOwner()) {
                optionAddressOthers.requestFocus();
            } else if (optionAddressOthers.isFocusOwner()) {
                txtYrsOfStay.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtYrsOfStay.isFocusOwner()) {
                optionAddressOthers.requestFocus();
            } else if (optionAddressOthers.isFocusOwner()) {
                optionAddressLiving.requestFocus();
            } else if (optionAddressLiving.isFocusOwner()) {
                optionAddressRenting.requestFocus();
            } else if (optionAddressRenting.isFocusOwner()) {
                optionAddressOwned.requestFocus();
            } else if (optionAddressOwned.isFocusOwner()) {
                txtStreet.requestFocus();
            } else if (txtStreet.isFocusOwner()) {
                txtZipcode.requestFocus();
            } else if (txtZipcode.isFocusOwner()) {
                txtBrgy.requestFocus();
            }
                break;
            case KeyEvent.VK_F5:
                if (txtBrgy.isFocusOwner()) {
                BarangayDlg barangayDlg = new BarangayDlg(null, true);
                barangayDlg.setBarangayService(UISetting.getBarangayService());
                barangayDlg.setVisible(true);
                if (barangayDlg.getBarangay() != null) {
                    setBarangay(barangayDlg.getBarangay());
                    txtBrgy.setText(barangay.getCode());
                    txtDesc.setText(barangay.getAddress());
                }
            }
                break;
        }
    }

    public void saveAddress() {
        List<Address> a = AddressController.getInstance().save(formNo, personType, createNew(new Address()));
        if (a.isEmpty()) {
            UIValidator.promptErrorMessageOn("SAVE");
        } else {
            for (Address addr : a) {
                if (addr.getAddressType().equals(addressType)) {
                    setAddress(addr);
                    break;
                }
            }
            setVisible(false);
        }
    }

}
