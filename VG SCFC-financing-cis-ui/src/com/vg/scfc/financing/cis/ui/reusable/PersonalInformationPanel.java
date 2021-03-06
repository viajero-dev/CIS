/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.commons.util.UIMgr;
import com.vg.scfc.financing.cis.ent.Address;
import com.vg.scfc.financing.cis.ent.LiveUpdatePicture;
import com.vg.scfc.financing.cis.ent.PersonalInfo;
import com.vg.scfc.financing.cis.ent.Religion;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.ent.Tribe;
import com.vg.scfc.financing.cis.ui.controller.AddressController;
import com.vg.scfc.financing.cis.ui.controller.FormController;
import com.vg.scfc.financing.cis.ui.controller.PersonalInfoController;
import com.vg.scfc.financing.cis.ui.controller.PhotoController;
import com.vg.scfc.financing.cis.ui.dialog.AddressDialog;
import com.vg.scfc.financing.cis.ui.dialog.PersonalInfoDialog;
import com.vg.scfc.financing.cis.ui.panel.MainPanel;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.java.balloontip.BalloonTip;
import vg.img.service.Caller;
import vg.img.ui.WebCamDlg;

/**
 *
 * @author rodel
 */
public class PersonalInformationPanel extends javax.swing.JPanel implements KeyListener, Caller {

    /**
     * Creates new form PersonalInformationPanel
     */
    public PersonalInformationPanel() {
        initComponents();
        startUpSettings();
        enableTakePicture(false);
    }

    private void startUpSettings() {
        initGenderOption();
        initTextBoxListener();
        initRadioButtonListener();
        initComboBoxValues();
        initComboBoxListener();
        setFieldsEditable(false);
        resetToDefault();
        txtLastName.putClientProperty("Quaqua.TextField.style", "search");
        policySetting();
    }

    public final void policySetting() {
        UISetting.policy.addIndexedComponent(txtLastName);
        UISetting.policy.addIndexedComponent(txtFirstName);
        UISetting.policy.addIndexedComponent(txtMiddleName);
        UISetting.policy.addIndexedComponent(txtBirthDate);
        UISetting.policy.addIndexedComponent(txtBirthPlace);
        UISetting.policy.addIndexedComponent(optionMale);
        UISetting.policy.addIndexedComponent(optionFemale);
        UISetting.policy.addIndexedComponent(txtContact);
        UISetting.policy.addIndexedComponent(comboStatus);
        UISetting.policy.addIndexedComponent(comboMarriedOption);
        UISetting.policy.addIndexedComponent(comboEducationStatus);
        UISetting.policy.addIndexedComponent(comboTribe);
        UISetting.policy.addIndexedComponent(comboReligion);
        UISetting.policy.addIndexedComponent(txtCitizenship);
        UISetting.policy.addIndexedComponent(txtPresentAddress);
        UISetting.policy.addIndexedComponent(txtPreviousAddress);
    }

    /**
     * Add Gender radio buttons to Button Group
     */
    private void initGenderOption() {
        optionGroupGender.add(optionMale);
        optionGroupGender.add(optionFemale);
    }

    /**
     * Add KeyListeners to all text boxes
     */
    private void initTextBoxListener() {
        txtLastName.addKeyListener(this);
        txtFirstName.addKeyListener(this);
        txtMiddleName.addKeyListener(this);
        txtBirthDate.addKeyListener(this);
        txtBirthPlace.addKeyListener(this);
        txtPreviousAddress.addKeyListener(this);
        txtContact.addKeyListener(this);
        txtContact.addKeyListener(this);
        txtPreviousAddress.addKeyListener(this);
        txtPresentAddress.addKeyListener(this);
        txtAge.addKeyListener(this);
    }

    /**
     * Add Key Listeners to all combo box
     */
    private void initComboBoxListener() {
        comboTribe.addKeyListener(this);
        comboReligion.addKeyListener(this);
        txtCitizenship.addKeyListener(this);
        comboStatus.addKeyListener(this);
        comboMarriedOption.addKeyListener(this);
        comboEducationStatus.addKeyListener(this);
    }

    /**
     * Add Key Listener to all radio buttons
     */
    private void initRadioButtonListener() {
        optionMale.addKeyListener(this);
        optionFemale.addKeyListener(this);
    }

    /**
     * Set all Combo Box values
     */
    private void initComboBoxValues() {
        tribes = PersonalInfoController.getInstance().Tribes();
        religions = PersonalInfoController.getInstance().Religions();

        if (!tribes.isEmpty()) {
            comboTribe.removeAllItems();
            for (Tribe t : tribes) {
                comboTribe.addItem(t.getTribeDesc());
            }
        }
        if (!religions.isEmpty()) {
            comboReligion.removeAllItems();
            for (Religion r : religions) {
                comboReligion.addItem(r.getReligionDesc());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionGroupGender = new javax.swing.ButtonGroup();
        comboMarriedOption = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        txtMiddleName = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        txtPreviousAddress = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        optionMale = new javax.swing.JRadioButton();
        optionFemale = new javax.swing.JRadioButton();
        jLabel106 = new javax.swing.JLabel();
        comboTribe = new javax.swing.JComboBox();
        jLabel107 = new javax.swing.JLabel();
        comboReligion = new javax.swing.JComboBox();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        jLabel110 = new javax.swing.JLabel();
        comboEducationStatus = new javax.swing.JComboBox();
        jLabel113 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        txtBirthPlace = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        txtPresentAddress = new javax.swing.JTextField();
        try {
            txtBirthDate = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        btnTakePicture = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        txtCitizenship = new javax.swing.JTextField();

        comboMarriedOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Living Together", "Widower", "Legally Seperated", "Mutually Seperated" }));
        comboMarriedOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMarriedOptionItemStateChanged(evt);
            }
        });

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Last name");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        txtLastName.setToolTipText("PRESS F5 FOR EXISTING CUSTOMER");
        txtLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastNameFocusLost(evt);
            }
        });
        jPanel4.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 5, 255, -1));

        jLabel100.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel100.setText("First name");
        jPanel4.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));

        txtFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusLost(evt);
            }
        });
        jPanel4.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 30, 255, -1));

        jLabel101.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel101.setText("Middle name");
        jPanel4.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        txtMiddleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMiddleNameActionPerformed(evt);
            }
        });
        txtMiddleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMiddleNameFocusGained(evt);
            }
        });
        jPanel4.add(txtMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 55, 255, -1));

        jLabel102.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel102.setText("Birthdate");
        jPanel4.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, -1, -1));

        jLabel103.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel103.setText("Age");
        jPanel4.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 85, -1, -1));

        txtAge.setEditable(false);
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 80, 83, -1));

        jLabel104.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel104.setText("Previous Address");
        jPanel4.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 161, -1, -1));

        txtPreviousAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPreviousAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPreviousAddressFocusLost(evt);
            }
        });
        jPanel4.add(txtPreviousAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 156, 710, -1));

        jLabel105.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel105.setText("Gender");
        jPanel4.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        optionMale.setText("Male");
        jPanel4.add(optionMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 5, -1, -1));

        optionFemale.setText("Female");
        jPanel4.add(optionFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 5, 70, -1));

        jLabel106.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel106.setText("Tribe");
        jPanel4.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 35, -1, -1));

        jPanel4.add(comboTribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 144, -1));

        jLabel107.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel107.setText("Religion");
        jPanel4.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 60, -1, -1));

        jPanel4.add(comboReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 55, 144, -1));

        jLabel108.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel108.setText("Citizenship");
        jPanel4.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 85, -1, -1));

        jLabel109.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel109.setText("Status");
        jPanel4.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));
        comboStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboStatusFocusLost(evt);
            }
        });
        jPanel4.add(comboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 55, 144, -1));

        jLabel110.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel110.setText("If Married");
        jPanel4.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 85, -1, -1));

        comboEducationStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEMENTARY", "HIGH SCHOOL", "SOME COLLEGE", "COLLEGE GRADUATE" }));
        jPanel4.add(comboEducationStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 5, 144, -1));

        jLabel113.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel113.setText("Contact");
        jPanel4.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 35, -1, -1));

        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });
        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContactFocusGained(evt);
            }
        });
        jPanel4.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 30, 144, -1));

        jLabel114.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel114.setText("Education");
        jPanel4.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 10, -1, -1));

        jLabel116.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel116.setText("Present Address");
        jPanel4.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 136, -1, -1));

        txtBirthPlace.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBirthPlaceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBirthPlaceFocusLost(evt);
            }
        });
        jPanel4.add(txtBirthPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 105, 710, -1));

        jLabel111.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel111.setText("Birth Place");
        jPanel4.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        txtPresentAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPresentAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPresentAddressFocusLost(evt);
            }
        });
        jPanel4.add(txtPresentAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 131, 710, -1));

        txtBirthDate.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel4.add(txtBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 80, 120, -1));

        btnTakePicture.setText("Take Picture");
        btnTakePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakePictureActionPerformed(evt);
            }
        });
        jPanel4.add(btnTakePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 140, -1));

        lblPhoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 10, 130, 120));

        txtCitizenship.setText("FILIPINO");
        txtCitizenship.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCitizenshipFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCitizenshipFocusLost(evt);
            }
        });
        jPanel4.add(txtCitizenship, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 144, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboStatusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboStatusFocusLost
        if (comboStatus.getSelectedIndex() == 1) {
            comboMarriedOption.setEnabled(true);
        } else {
            comboMarriedOption.setEnabled(false);
        }
    }//GEN-LAST:event_comboStatusFocusLost

    private void txtLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusLost
        txtLastName.setText(txtLastName.getText().toUpperCase());
        lastnameTip.closeBalloon();
    }//GEN-LAST:event_txtLastNameFocusLost

    private void txtFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusLost
        txtFirstName.setText(UIValidator.validate(txtFirstName));
    }//GEN-LAST:event_txtFirstNameFocusLost

    private void txtMiddleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMiddleNameActionPerformed
        txtMiddleName.setText(UIValidator.validate(txtMiddleName));
    }//GEN-LAST:event_txtMiddleNameActionPerformed

    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactActionPerformed
        txtContact.setText(UIValidator.isNumeric(txtContact));
    }//GEN-LAST:event_txtContactActionPerformed

    private void comboMarriedOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMarriedOptionItemStateChanged
    }//GEN-LAST:event_comboMarriedOptionItemStateChanged

    private void txtBirthPlaceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBirthPlaceFocusLost
        txtBirthPlace.setText(UIValidator.validate(txtBirthPlace));
    }//GEN-LAST:event_txtBirthPlaceFocusLost

    private void txtPresentAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentAddressFocusLost
        txtPresentAddress.setText(txtPresentAddress.getText().toUpperCase());
        addressTip.closeBalloon();
    }//GEN-LAST:event_txtPresentAddressFocusLost

    private void txtPreviousAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPreviousAddressFocusLost
        txtPreviousAddress.setText(txtPreviousAddress.getText().toUpperCase());
        addressTip.closeBalloon();
    }//GEN-LAST:event_txtPreviousAddressFocusLost

    private void btnTakePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakePictureActionPerformed
        WebCamDlg dlg = new WebCamDlg(null, true);
        dlg.setCaller(this);
        dlg.setService(UISetting.getImageService());
        String filename = "";
        if (personalInfo != null) {
            filename = personalInfo.getTxFormNo() + "_" + personalInfo.getPersonType().getTypeID();
            dlg.setFilename(filename);
        } else {
            dlg.setFilename("");
        }
        if (!dlg.isVisible()) {
            dlg.setVisible(true);
        }

        if (dlg.isSave()) {
            LiveUpdatePicture luPic = new LiveUpdatePicture();
            luPic.setFileName(filename + ".jpg");
            luPic.setStatus("N");
            PhotoController.getInstance().save(luPic);
        } else {
            lblPhoto.setIcon(PhotoController.getInstance().findByName(filename));
        }
    }//GEN-LAST:event_btnTakePictureActionPerformed

    private void txtCitizenshipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCitizenshipFocusLost
        txtCitizenship.setText(txtCitizenship.getText().toUpperCase());
    }//GEN-LAST:event_txtCitizenshipFocusLost

    private void txtLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusGained
        lastnameTip = new BalloonTip(txtLastName, "PRESS F5 FOR EXISTING RECORDS");
        txtLastName.selectAll();
    }//GEN-LAST:event_txtLastNameFocusGained

    private void txtPresentAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentAddressFocusGained
        addressTip = new BalloonTip(txtPresentAddress, "PRESS F5 FOR ADDRESS DIALOG");
        txtPresentAddress.selectAll();
    }//GEN-LAST:event_txtPresentAddressFocusGained

    private void txtPreviousAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPreviousAddressFocusGained
        addressTip = new BalloonTip(txtPreviousAddress, "PRESS F5 FOR ADDRESS DIALOG");
        txtPreviousAddress.selectAll();
    }//GEN-LAST:event_txtPreviousAddressFocusGained

    private void txtFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusGained
        txtFirstName.selectAll();
    }//GEN-LAST:event_txtFirstNameFocusGained

    private void txtMiddleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMiddleNameFocusGained
        txtMiddleName.selectAll();
    }//GEN-LAST:event_txtMiddleNameFocusGained

    private void txtBirthPlaceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBirthPlaceFocusGained
        txtBirthPlace.selectAll();
    }//GEN-LAST:event_txtBirthPlaceFocusGained

    private void txtContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusGained
        txtContact.selectAll();
    }//GEN-LAST:event_txtContactFocusGained

    private void txtCitizenshipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCitizenshipFocusGained
        txtCitizenship.selectAll();
    }//GEN-LAST:event_txtCitizenshipFocusGained
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTakePicture;
    private javax.swing.JComboBox comboEducationStatus;
    private javax.swing.JComboBox comboMarriedOption;
    private javax.swing.JComboBox comboReligion;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JComboBox comboTribe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JRadioButton optionFemale;
    private javax.swing.ButtonGroup optionGroupGender;
    private javax.swing.JRadioButton optionMale;
    private javax.swing.JTextField txtAge;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtBirthDate;
    private javax.swing.JTextField txtBirthPlace;
    private javax.swing.JTextField txtCitizenship;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JTextField txtPresentAddress;
    private javax.swing.JTextField txtPreviousAddress;
    // End of variables declaration//GEN-END:variables
    private PersonalInfo personalInfo;
    private AddEditButtonPanel buttonPanel;
    List<Tribe> tribes = new ArrayList<>();
    List<Religion> religions = new ArrayList<>();
    private HeaderPanel headerPanel;
    private String personType;
    private String clientNo;
    private MainPanel mainPanel;
    private Address presentAddress;
    private Address previousAddress;
    BalloonTip lastnameTip;
    BalloonTip addressTip;

    public void setButtonPanel(AddEditButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPreviousAddress(Address previousAddress) {
        this.previousAddress = previousAddress;
    }

    public void setAddress(Address address) {
        this.presentAddress = address;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
        setPersonalInfoData(this.personalInfo, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (txtLastName.isFocusOwner()) {
                    txtFirstName.requestFocus();
                } else if (txtFirstName.isFocusOwner()) {
                    txtMiddleName.requestFocus();
                } else if (txtMiddleName.isFocusOwner()) {
                    txtBirthDate.requestFocus();
                } else if (txtBirthDate.isFocusOwner()) {
                    txtBirthPlace.requestFocus();
                } else if (txtBirthPlace.isFocusOwner()) {
                    optionMale.requestFocus();
                } else if (optionMale.isFocusOwner()) {
                    optionFemale.requestFocus();
                } else if (optionFemale.isFocusOwner()) {
                    txtContact.requestFocus();
                } else if (txtContact.isFocusOwner()) {
                    comboStatus.requestFocus();
                } else if (comboStatus.isFocusOwner()) {
                    if (comboStatus.getSelectedIndex() == 1) {
                        comboMarriedOption.requestFocus();
                    } else {
                        comboEducationStatus.requestFocus();
                    }
                } else if (comboMarriedOption.isFocusOwner()) {
                    comboEducationStatus.requestFocus();
                } else if (comboEducationStatus.isFocusOwner()) {
                    comboTribe.requestFocus();
                } else if (comboTribe.isFocusOwner()) {
                    comboReligion.requestFocus();
                } else if (comboReligion.isFocusOwner()) {
                    txtCitizenship.requestFocus();
                } else if (txtCitizenship.isFocusOwner()) {
                    txtPresentAddress.requestFocus();
                } else if (txtPresentAddress.isFocusOwner()) {
                    txtPreviousAddress.requestFocus();
                } else if (txtPreviousAddress.isFocusOwner()) {
                    if (buttonPanel.getBtnAdd().getText().equals("Save")) {
                        buttonPanel.getBtnAdd().requestFocus();
                    } else {
                        buttonPanel.getBtnEdit().requestFocus();
                    }
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                if (txtLastName.isFocusOwner()) {
                    txtFirstName.requestFocus();
                } else if (txtFirstName.isFocusOwner()) {
                    txtMiddleName.requestFocus();
                } else if (txtMiddleName.isFocusOwner()) {
                    txtBirthDate.requestFocus();
                } else if (txtBirthDate.isFocusOwner()) {
                    txtBirthPlace.requestFocus();
                } else if (txtBirthPlace.isFocusOwner()) {
                    optionMale.requestFocus();
                } else if (optionMale.isFocusOwner()) {
                    optionFemale.requestFocus();
                } else if (optionFemale.isFocusOwner()) {
                    txtContact.requestFocus();
                } else if (txtContact.isFocusOwner()) {
                    comboStatus.requestFocus();
                } else if (txtCitizenship.isFocusOwner()) {
                    txtPresentAddress.requestFocus();
                } else if (txtPresentAddress.isFocusOwner()) {
                    txtPreviousAddress.requestFocus();
                } else if (txtPreviousAddress.isFocusOwner()) {
                    if (buttonPanel.getBtnAdd().getText().equals("Save")) {
                        buttonPanel.getBtnAdd().requestFocus();
                    } else {
                        buttonPanel.getBtnEdit().requestFocus();
                    }
                }
                break;
            case KeyEvent.VK_UP:
                if (txtPreviousAddress.isFocusOwner()) {
                    txtPresentAddress.requestFocus();
                } else if (txtPresentAddress.isFocusOwner()) {
                    txtCitizenship.requestFocus();
                } else if (txtCitizenship.isFocusOwner()) {
                    comboReligion.requestFocus();
                } else if (comboReligion.isFocusOwner()) {
                    comboTribe.requestFocus();
                } else if (comboTribe.isFocusOwner()) {
                    comboEducationStatus.requestFocus();
                } else if (comboEducationStatus.isFocusOwner()) {
                    if (comboMarriedOption.isEnabled()) {
                        comboMarriedOption.requestFocus();
                    } else {
                        comboStatus.requestFocus();
                    }
                } else if (comboMarriedOption.isFocusOwner()) {
                    comboStatus.requestFocus();
                } else if (comboStatus.isFocusOwner()) {
                    txtContact.requestFocus();
                } else if (txtContact.isFocusOwner()) {
                    optionFemale.requestFocus();
                } else if (optionFemale.isFocusOwner()) {
                    optionMale.requestFocus();
                } else if (optionMale.isFocusOwner()) {
                    txtBirthPlace.requestFocus();
                } else if (txtBirthPlace.isFocusOwner()) {
                    txtBirthDate.requestFocus();
                } else if (txtBirthDate.isFocusOwner()) {
                    txtMiddleName.requestFocus();
                } else if (txtMiddleName.isFocusOwner()) {
                    txtFirstName.requestFocus();
                } else if (txtFirstName.isFocusOwner()) {
                    txtLastName.requestFocus();
                } else if (buttonPanel.getBtnAdd().isFocusOwner() || buttonPanel.getBtnEdit().isFocusOwner()) {
                    txtPreviousAddress.requestFocus();
                }
                break;
            case KeyEvent.VK_F5:
                if (txtLastName.isFocusOwner()) {
                    PersonalInfoDialog personalInfoDlg = new PersonalInfoDialog(null, true);
                    UIMgr.centerToScreen(personalInfoDlg);
                    personalInfoDlg.setVisible(true);
                    if (personalInfoDlg.getPersonalInfo() != null) {
                        setPersonalInfoData(personalInfoDlg.getPersonalInfo(), true);
                    }
                } else if (txtPresentAddress.isFocusOwner()) {
                    AddressDialog addressDialog = new AddressDialog(null, true);
                    UIMgr.centerToScreen(addressDialog);
                    addressDialog.setVisible(true);
                    if (addressDialog.getAddress() != null) {
                        setAddress(addressDialog.getAddress());
                    }
                    txtPresentAddress.setText(presentAddress.getAddress());
                } else if (txtPreviousAddress.isFocusOwner()) {
                    AddressDialog addressDialog = new AddressDialog(null, true);
                    UIMgr.centerToScreen(addressDialog);
                    addressDialog.setVisible(true);
                    if (addressDialog.getAddress() != null) {
                        setPreviousAddress(addressDialog.getAddress());
                    }
                    txtPreviousAddress.setText(previousAddress.getAddress());
                }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtLastName.setEditable(value);
        txtFirstName.setEditable(value);
        txtMiddleName.setEditable(value);
        txtBirthDate.setEditable(value);
        txtBirthPlace.setEditable(value);
        txtAge.setEditable(value);
        optionMale.setEnabled(value);
        optionFemale.setEnabled(value);
        txtContact.setEditable(value);
        comboStatus.setEnabled(value);
        comboMarriedOption.setEnabled(value);
        comboEducationStatus.setEnabled(value);
        comboTribe.setEnabled(value);
        comboReligion.setEnabled(value);
        txtCitizenship.setEditable(value);
        txtPresentAddress.setEditable(value);
        txtPreviousAddress.setEditable(value);

        txtLastName.setFocusable(value);
        txtFirstName.setFocusable(value);
        txtMiddleName.setFocusable(value);
        txtBirthDate.setFocusable(value);
        txtBirthPlace.setFocusable(value);
        txtAge.setFocusable(value);
        optionMale.setFocusable(value);
        optionFemale.setFocusable(value);
        txtContact.setFocusable(value);
        comboStatus.setFocusable(value);
        comboMarriedOption.setFocusable(value);
        comboEducationStatus.setFocusable(value);
        comboTribe.setFocusable(value);
        comboReligion.setFocusable(value);
        txtCitizenship.setFocusable(value);
        txtPresentAddress.setFocusable(value);
        txtPreviousAddress.setFocusable(value);

        if (value) {
            txtLastName.requestFocus();
            txtCitizenship.setText("FILIPINO");
        }
    }

    public void resetToDefault() {
        txtLastName.setText("");
        txtFirstName.setText("");
        txtMiddleName.setText("");
        txtBirthPlace.setText("");
        txtAge.setText("");
        optionMale.setSelected(false);
        optionFemale.setSelected(false);
        txtContact.setText("");
        txtCitizenship.setText("");
        txtPresentAddress.setText("");
        txtPreviousAddress.setText("");
        comboTribe.setSelectedItem(null);
        comboStatus.setSelectedItem(null);
        comboMarriedOption.setSelectedItem(null);
        comboEducationStatus.setSelectedItem(null);
        comboReligion.setSelectedItem(null);
        txtBirthDate.setValue(null);
    }

    public void setPersonalInfoData(Object o, boolean fromSearch) {
        if (o == null) {
            resetToDefault();
        } else {
            PersonalInfo p = (PersonalInfo) o;
            txtLastName.setText(p.getLastName());
            txtFirstName.setText(p.getFirstName());
            txtMiddleName.setText(p.getMiddleName());
            txtBirthDate.setDate(p.getDateOfBirth());
            txtAge.setText(p.getAge() + "");
            txtBirthPlace.setText(p.getPlaceOfBirth());
            switch (p.getGender().toUpperCase()) {
                case "MALE":
                    optionMale.setSelected(true);
                    optionFemale.setSelected(false);
                    break;
                case "FEMALE":
                    optionMale.setSelected(false);
                    optionFemale.setSelected(true);
                    break;
            }
            txtContact.setText(p.getContactNo());
            switch (p.getCivilStatus().trim().toUpperCase()) {
                case "SINGLE":
                    comboStatus.setSelectedIndex(0);
                    comboMarriedOption.setEnabled(false);
                    break;
                case "LIVING TOGETHER":
                    comboStatus.setSelectedIndex(1);
                    comboMarriedOption.setEnabled(true);
                    comboMarriedOption.setSelectedIndex(0);
                    break;
                case "WIDOWER":
                    comboStatus.setSelectedIndex(1);
                    comboMarriedOption.setEnabled(true);
                    comboMarriedOption.setSelectedIndex(1);
                    break;
                case "LEGALLY SEPERATED":
                    comboStatus.setSelectedIndex(1);
                    comboMarriedOption.setEnabled(true);
                    comboMarriedOption.setSelectedIndex(2);
                    break;
                case "MUTUALLY SEPERATED":
                    comboStatus.setSelectedIndex(1);
                    comboMarriedOption.setEnabled(true);
                    comboMarriedOption.setSelectedIndex(3);
                    break;
            }
            switch (p.getEducation()) {
                case "ELEMENTARY":
                    comboEducationStatus.setSelectedIndex(0);
                    break;
                case "HIGH SCHOOL":
                    comboEducationStatus.setSelectedIndex(1);
                    break;
                case "SOME COLLEGE":
                    comboEducationStatus.setSelectedIndex(2);
                    break;
                case "COLLEGE GRADUATE":
                    comboEducationStatus.setSelectedIndex(3);
                    break;
            }
            int tribeIndex = 0;
            int selectedTribeIndex = 0;
            for (Tribe tribe : tribes) {
                if (tribe.getTribeDesc().equals(p.getTribe().getTribeDesc())) {
                    selectedTribeIndex = tribeIndex;
                    break;
                } else {
                    tribeIndex++;
                }
            }
            comboTribe.setSelectedIndex(selectedTribeIndex);

            int religionIndex = 0;
            int selectedReligionIndex = 0;
            for (Religion religion : religions) {
                if (religion.getReligionDesc().equals(p.getReligion().getReligionDesc())) {
                    selectedReligionIndex = religionIndex;
                    break;
                } else {
                    religionIndex++;
                }
            }
            comboReligion.setSelectedIndex(selectedReligionIndex);

            txtCitizenship.setText(p.getCitizenship());
            if (fromSearch) {
                txtPresentAddress.setText("");
                txtPreviousAddress.setText("");
            } else {
                List<Address> addresses = AddressController.getInstance().findByFormNo(p.getTxFormNo(), p.getPersonType().getTypeID());
                for (Address address : addresses) {
                    if (address.getAddressType().equals("PRESENT")) {
                        txtPresentAddress.setText(address.getAddress() + ", " + address.getBrgyDesc());
                    } else {
                        txtPreviousAddress.setText(address.getAddress() + ", " + address.getBrgyDesc());
                    }
                }
            }
            enableTakePicture(true);
            TransactionForm tf = FormController.getInstance().findByFormNo(p.getTxFormNo());
            if (tf != null) {
                headerPanel.setFormNo(tf.getTxFormNo());
                headerPanel.setIDNo(tf.getFormNo());
                headerPanel.setApplicationDate(tf.getTxApplicationDate());
            }
        }
    }
    
    public final static int VALIDATE_ERROR = 1;
    public final static int PROCESS_COMPLETED = 2;
    public final static int PROCESS_FAILED = 3;

    public int savePersonalInfo() {
        PersonalInfo p = createNew(new PersonalInfo());
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().save(p, headerPanel.getIDNo(),
                headerPanel.getApplicationDate(), personType);
        saveAddresses(p);
        setPersonalInfo(p);
        headerPanel.setFormNo(p.getTxFormNo());

        boolean tempResult;
        tempResult = (p != null);
        enableTakePicture(tempResult);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int updatePersonalInfo() {
        PersonalInfo p = createNew(personalInfo);
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().update(headerPanel.getFormNo(),
                personalInfo.getPersonType().getTypeID(), p);
        setPersonalInfo(p);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int saveSpousePersonalInfo() {
        PersonalInfo p = createNew(new PersonalInfo());
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().save(p, headerPanel.getFormNo(), personType, clientNo);
        saveAddresses(p);
        setPersonalInfo(p);
        headerPanel.setFormNo(p.getTxFormNo());

        boolean tempResult;
        tempResult = p != null;
        enableTakePicture(tempResult);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int updateSpousePersonalInfo() {
        PersonalInfo p = createNew(personalInfo);
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().update(headerPanel.getFormNo(), personType, p);
        setPersonalInfo(p);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int saveCoMakerPersonalInfo() {
        String cmType;
        if (mainPanel.getComakers().isEmpty()) {
            cmType = "CM1";
        } else {
            cmType = "CM2";
        }

        PersonalInfo p = createNew(new PersonalInfo());
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().save(p, headerPanel.getFormNo(), cmType, clientNo);
        saveAddresses(p);
        setPersonalInfo(p);
        headerPanel.setFormNo(p.getTxFormNo());
        enableTakePicture(p != null);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int updateCoMakerPersonalInfo() {
        PersonalInfo p = createNew(personalInfo);
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().update(headerPanel.getFormNo(), personalInfo.getPersonType().getTypeID(), p);
        setPersonalInfo(p);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int saveCoMakerSpousePersonalInfo() {
        String cmType;
        if (mainPanel.getSelectedCoMaker().getPersonType().getTypeID().equals("CM1")) {
            cmType = "CS1";
        } else {
            cmType = "CS2";
        }

        PersonalInfo p = createNew(new PersonalInfo());
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().save(p, headerPanel.getFormNo(), cmType, clientNo);
        saveAddresses(p);
        setPersonalInfo(p);
        headerPanel.setFormNo(p.getTxFormNo());
        enableTakePicture(p != null);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int updateCoMakerSpousePersonalInfo() {
        String cmType;
        if (mainPanel.getSelectedCoMaker().getPersonType().getTypeID().equals("CM1")) {
            cmType = "CS1";
        } else {
            cmType = "CS2";
        }

        PersonalInfo p = createNew(personalInfo);
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().update(headerPanel.getFormNo(), cmType, p);
        setPersonalInfo(p);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int saveRepresentativePersonalInfo() {
        PersonalInfo p = createNew(new PersonalInfo());
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().save(p, headerPanel.getFormNo(), personType, clientNo);
        saveAddresses(p);
        setPersonalInfo(p);
        headerPanel.setFormNo(p.getTxFormNo());
        enableTakePicture(p != null);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public int updateRepresentativePersonalInfo() {
        PersonalInfo p = createNew(personalInfo);
        if (!isValidPersonalInfo(p)) {
            return VALIDATE_ERROR;
        }

        p = PersonalInfoController.getInstance().update(headerPanel.getFormNo(), personType, createNew(personalInfo));
        setPersonalInfo(p);
        
        return ((p != null) ? PROCESS_COMPLETED : PROCESS_FAILED);
    }

    public void saveAddresses(PersonalInfo p) {
        if (presentAddress != null) {
            presentAddress.setAddressType("PRESENT");
            presentAddress.setTxFormNo(p.getTxFormNo());
            AddressController.getInstance().save(p.getTxFormNo(), p.getPersonType().getTypeID(), presentAddress);
        }

        if (previousAddress != null) {
            previousAddress.setAddressType("PREVIOUS");
            previousAddress.setTxFormNo(p.getTxFormNo());
            AddressController.getInstance().save(p.getTxFormNo(), p.getPersonType().getTypeID(), previousAddress);
        }
    }

    public boolean isValidPersonalInfo(PersonalInfo info) {
        if (info != null) {
            if (info.getLastName().trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Last Name is a required field.",
                        "Empty Field", JOptionPane.ERROR_MESSAGE);
                txtLastName.requestFocus();
                return false;
            }
            if (info.getFirstName().trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "First Name is a required field.",
                        "Empty Field", JOptionPane.ERROR_MESSAGE);
                txtFirstName.requestFocus();
                return false;

            }
            if (info.getMiddleName().trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Middle Name is a required field.",
                        "Empty Field", JOptionPane.ERROR_MESSAGE);
                txtMiddleName.requestFocus();
                return false;
            }
            if (info.getGender().trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Gender is a required field.",
                        "Empty Field", JOptionPane.ERROR_MESSAGE);
                optionMale.requestFocus();
                return false;
            }
            if (info.getCivilStatus().trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Civil Status is a required field.",
                        "Empty Field", JOptionPane.ERROR_MESSAGE);
                comboStatus.requestFocus();
                return false;
            }
            if (txtPresentAddress.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Present Address is a required field.",
                        "Empty Field", JOptionPane.ERROR_MESSAGE);
                txtPresentAddress.requestFocus();
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private PersonalInfo createNew(PersonalInfo p) {
        p.setLastName(txtLastName.getText());
        p.setFirstName(txtFirstName.getText());
        p.setMiddleName(txtMiddleName.getText());
        try {
            p.setDateOfBirth(txtBirthDate.getDate());
        } catch (ParseException ex) {
            UIValidator.log(ex, PersonalInformationPanel.class);
        }
        p.setPlaceOfBirth(txtBirthPlace.getText());
        if (optionMale.isSelected()) {
            p.setGender("MALE");
        } else {
            p.setGender("FEMALE");
        }
        Tribe t = PersonalInfoController.getInstance().findTribeByDesc((String) comboTribe.getSelectedItem(), tribes);
        p.setTribe(t);
        Religion r = PersonalInfoController.getInstance().findReligionByDesc((String) comboReligion.getSelectedItem(), religions);
        p.setReligion(r);
        p.setCitizenship(txtCitizenship.getText());
        if (comboStatus.getSelectedIndex() == 1) {
            switch (comboMarriedOption.getSelectedIndex()) {
                case 0:
                    p.setCivilStatus("LIVING TOGETHER");
                    break;
                case 1:
                    p.setCivilStatus("WIDOWER");
                    break;
                case 2:
                    p.setCivilStatus("LEGALLY SEPERATED");
                    break;
                case 3:
                    p.setCivilStatus("MUTUALLY SEPERATED");
                    break;
            }
        } else {
            p.setCivilStatus("SINGLE");
        }

        p.setEducation((String) comboEducationStatus.getSelectedItem());
        p.setContactNo(txtContact.getText());

        return p;
    }

    @Override
    public void setPhoto(vg.img.classes.VgImageIcon vii) {
        lblPhoto.setIcon(vii);
    }

    @Override
    public void updatePhoto(vg.img.classes.VgImageIcon vii) {
    }

    public void enableTakePicture(boolean value) {
        btnTakePicture.setEnabled(value);
    }
}
