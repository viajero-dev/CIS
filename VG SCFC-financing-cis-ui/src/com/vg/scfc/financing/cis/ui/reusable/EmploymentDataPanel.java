/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.commons.renderer.IndexedFocusTraversalPolicy;
import com.vg.scfc.financing.cis.ent.Employment;
import com.vg.scfc.financing.cis.ui.controller.EmploymentController;
import com.vg.scfc.financing.cis.ui.panel.MainPanel;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author rodel
 */
public class EmploymentDataPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form EmploymentDataPanel
     */
    public EmploymentDataPanel() {
        initComponents();
        initUIListener();
        startUpSettings();
        policySetting();
    }
    
    public final void policySetting() {
        UISetting.policy.addIndexedComponent(comboEmploymentStatus);
        UISetting.policy.addIndexedComponent(txtPositionDepartment);
        UISetting.policy.addIndexedComponent(txtCompanyEmployer);
        UISetting.policy.addIndexedComponent(txtEmployerAddress);
        UISetting.policy.addIndexedComponent(txtEmployerContact);
        UISetting.policy.addIndexedComponent(txtYearInService);
        UISetting.policy.addIndexedComponent(txtEmployerBusinessNature);
    }
    
    private void startUpSettings() {
        setFieldsEditable(false);
    }

    /**
     * Set TextBox Listener
     */
    private void initUIListener() {
        comboEmploymentStatus.addKeyListener(this);
        txtPositionDepartment.addKeyListener(this);
        txtCompanyEmployer.addKeyListener(this);
        txtEmployerAddress.addKeyListener(this);
        txtEmployerContact.addKeyListener(this);
        txtYearInService.addKeyListener(this);
        txtEmployerBusinessNature.addKeyListener(this);
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
        comboEmploymentStatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtCompanyEmployer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPositionDepartment = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmployerAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmployerContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmployerBusinessNature = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtYearInService = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Address");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, -1, -1));

        comboEmploymentStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Regular", "Self-Employed", "Project-Hired", "Contractual", "Probationary", "Others" }));
        add(comboEmploymentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 5, 144, -1));

        jLabel3.setText("Status");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        txtCompanyEmployer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompanyEmployerFocusLost(evt);
            }
        });
        add(txtCompanyEmployer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 55, 320, -1));

        jLabel4.setText("Position/Department");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));

        txtPositionDepartment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPositionDepartmentFocusLost(evt);
            }
        });
        add(txtPositionDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 320, -1));

        jLabel5.setText("Company/Employer");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        txtEmployerAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmployerAddressFocusLost(evt);
            }
        });
        add(txtEmployerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 320, -1));

        jLabel6.setText("Contact #");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        txtEmployerContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmployerContactFocusLost(evt);
            }
        });
        add(txtEmployerContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 105, 144, -1));

        jLabel7.setText("Business");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 136, -1, -1));

        txtEmployerBusinessNature.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmployerBusinessNatureFocusLost(evt);
            }
        });
        add(txtEmployerBusinessNature, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 131, 320, -1));

        jLabel8.setText("Years in Service");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 110, -1, -1));

        txtYearInService.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtYearInServiceFocusLost(evt);
            }
        });
        add(txtYearInService, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 105, 70, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPositionDepartmentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPositionDepartmentFocusLost
        txtPositionDepartment.setText(UIValidator.validate(txtPositionDepartment));
    }//GEN-LAST:event_txtPositionDepartmentFocusLost

    private void txtCompanyEmployerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyEmployerFocusLost
        txtCompanyEmployer.setText(UIValidator.validate(txtCompanyEmployer));
    }//GEN-LAST:event_txtCompanyEmployerFocusLost

    private void txtEmployerAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmployerAddressFocusLost
        txtEmployerAddress.setText(UIValidator.validate(txtEmployerAddress)); 
    }//GEN-LAST:event_txtEmployerAddressFocusLost

    private void txtEmployerContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmployerContactFocusLost
        txtEmployerContact.setText(UIValidator.isNumeric(txtEmployerContact));
    }//GEN-LAST:event_txtEmployerContactFocusLost

    private void txtEmployerBusinessNatureFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmployerBusinessNatureFocusLost
        txtEmployerBusinessNature.setText(UIValidator.validate(txtEmployerBusinessNature)); 
    }//GEN-LAST:event_txtEmployerBusinessNatureFocusLost

    private void txtYearInServiceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYearInServiceFocusLost
        txtYearInService.setText(UIValidator.isNumeric(txtYearInService));
    }//GEN-LAST:event_txtYearInServiceFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboEmploymentStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCompanyEmployer;
    private javax.swing.JTextField txtEmployerAddress;
    private javax.swing.JTextField txtEmployerBusinessNature;
    private javax.swing.JTextField txtEmployerContact;
    private javax.swing.JTextField txtPositionDepartment;
    private javax.swing.JTextField txtYearInService;
    // End of variables declaration//GEN-END:variables
    private String personType;
    private Employment employment;
    private HeaderPanel headerPanel;
    private MainPanel mainPanel;

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
        setEmploymentData(employment);
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
//            case KeyEvent.VK_TAB:
//            case KeyEvent.VK_ENTER:
//                if (comboEmploymentStatus.isFocusOwner()) {
//                txtPositionDepartment.requestFocus();
//            } else if (txtPositionDepartment.isFocusOwner()) {
//                txtCompanyEmployer.requestFocus();
//            } else if (txtCompanyEmployer.isFocusOwner()) {
//                txtEmployerAddress.requestFocus();
//            } else if (txtEmployerAddress.isFocusOwner()) {
//                txtEmployerContact.requestFocus();
//            } else if (txtEmployerContact.isFocusOwner()) {
//                txtYearInService.requestFocus();
//            } else if (txtYearInService.isFocusOwner()) {
//                txtEmployerBusinessNature.requestFocus();
//            }
//                break;
            case KeyEvent.VK_UP:
                if (txtEmployerBusinessNature.isFocusOwner()) {
                txtYearInService.requestFocus();
            } else if (txtYearInService.isFocusOwner()) {
                txtEmployerContact.requestFocus();
            } else if (txtEmployerContact.isFocusOwner()) {
                txtEmployerAddress.requestFocus();
            } else if (txtEmployerAddress.isFocusOwner()) {
                txtCompanyEmployer.requestFocus();
            } else if (txtCompanyEmployer.isFocusOwner()) {
                txtPositionDepartment.requestFocus();
            } else if (txtPositionDepartment.isFocusOwner()) {
                comboEmploymentStatus.requestFocus();
            }
                break;
        }
    }

    public boolean saveEmploymentData() {
        Object o = EmploymentController.getInstance().save(createNew(new Employment()), personType, headerPanel.getFormNo());
        setEmployment((Employment) o);
        return o != null;
    }

    public boolean updateEmploymentData() {
        Object o = EmploymentController.getInstance().update(headerPanel.getFormNo(), personType, createNew(employment));
        setEmployment((Employment) o);
        return o != null;
    }
    
    public boolean saveCoMakerEmploymentData() {
        Object o = EmploymentController.getInstance().save(createNew(new Employment()), mainPanel.getSelectedCoMaker().getPersonType().getTypeID(), headerPanel.getFormNo());
        setEmployment((Employment) o);
        return o != null;
    }
    
    public boolean updateCoMakerEmploymentData() {
        Object o = EmploymentController.getInstance().update(headerPanel.getFormNo(), mainPanel.getSelectedCoMaker().getPersonType().getTypeID(), createNew(employment));
        setEmployment((Employment) o);
        return o != null;
    }
    
    public boolean saveCoMakerSpouseEmploymentData() {
        String typeID;
        if(mainPanel.getSelectedCoMaker().getPersonType().getTypeID().equals("CM1")) {
            typeID = "CS1";
        } else {
            typeID = "CS2";
        }
        Object o = EmploymentController.getInstance().save(createNew(new Employment()), typeID, headerPanel.getFormNo());
        setEmployment((Employment) o);
        return o != null;
    }
    
    public boolean updateCoMakerSpouseEmploymentData() {
        String typeID;
        if(mainPanel.getSelectedCoMaker().getPersonType().getTypeID().equals("CM1")) {
            typeID = "CS1";
        } else {
            typeID = "CS2";
        }
        Object o = EmploymentController.getInstance().update(headerPanel.getFormNo(), typeID, createNew(employment));
        setEmployment((Employment) o);
        return o != null;
    }

    public void setEmploymentData(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            Employment e = (Employment) o;
            switch (e.getEmpStatus()) {
                case "REGULAR":
                    comboEmploymentStatus.setSelectedIndex(0);
                    break;
                case "SELF-EMPLOYED":
                    comboEmploymentStatus.setSelectedIndex(1);
                    break;
                case "PROJECT-HIRED":
                    comboEmploymentStatus.setSelectedIndex(2);
                    break;
                case "CONTRACTUAL":
                    comboEmploymentStatus.setSelectedIndex(3);
                    break;
                case "PROBITIONARY":
                    comboEmploymentStatus.setSelectedIndex(0);
                    break;
                case "OTHERS":
                    comboEmploymentStatus.setSelectedIndex(0);
                    break;
            }
            txtPositionDepartment.setText(e.getEmpPosition());
            txtCompanyEmployer.setText(e.getEmpCompany());
            txtEmployerAddress.setText(e.getEmpAddress());
            txtEmployerContact.setText(e.getEmpContactNo());
            txtEmployerBusinessNature.setText(e.getEmpNature());
            txtYearInService.setText(e.getEmpYearsInService() + "");
        }
    }

    public void setFieldsEditable(boolean value) {
        comboEmploymentStatus.setEnabled(value);
        txtPositionDepartment.setEditable(value);
        txtCompanyEmployer.setEditable(value);
        txtEmployerAddress.setEditable(value);
        txtEmployerContact.setEditable(value);
        txtEmployerBusinessNature.setEditable(value);
        txtYearInService.setEditable(value);
        
        comboEmploymentStatus.setFocusable(value);
        txtPositionDepartment.setFocusable(value);
        txtCompanyEmployer.setFocusable(value);
        txtEmployerAddress.setFocusable(value);
        txtEmployerContact.setFocusable(value);
        txtEmployerBusinessNature.setFocusable(value);
        txtYearInService.setFocusable(value);
        
        if(value == true) {
            comboEmploymentStatus.requestFocus();
        }
    }

    public void resetToDefault() {
        comboEmploymentStatus.setSelectedIndex(0);
        txtPositionDepartment.setText("");
        txtCompanyEmployer.setText("");
        txtEmployerAddress.setText("");
        txtEmployerContact.setText("");
        txtEmployerBusinessNature.setText("");
        txtYearInService.setText("");

        comboEmploymentStatus.requestFocus();
    }

    public Employment createNew(Employment e) {
        e.setEmpStatus((String) comboEmploymentStatus.getSelectedItem());
        e.setEmpPosition(txtPositionDepartment.getText());
        e.setEmpCompany(txtCompanyEmployer.getText());
        e.setEmpAddress(txtEmployerAddress.getText());
        e.setEmpContactNo(txtEmployerContact.getText());
        e.setEmpNature(txtEmployerBusinessNature.getText());
        if(txtYearInService.getText().equals("")) {
            e.setEmpYearsInService(0);
        } else {
            e.setEmpYearsInService(Integer.parseInt(txtYearInService.getText()));
        }
        return e;
    }
}
