/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.Address;
import com.vg.scfc.financing.cis.ui.controller.AddressController;
import com.vg.scfc.financing.cis.ui.panel.MainPanel;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import com.vg.scfc.financing.commons.ent.Barangay;
import com.vg.scfc.financing.commons.ui.dlg.BarangayDlg;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class AddressPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form AddressPanel
     */
    public AddressPanel() {
        initComponents();
        startUpSettings();
    }

    private void startUpSettings() {
        setFieldsEditable(false);
        initOptionGroup();
        initKeyListeners();
        initAddressTable();
    }

    private void initOptionGroup() {
        optionAddressGroup.add(optionAddressOwned);
        optionAddressGroup.add(optionAddressRenting);
        optionAddressGroup.add(optionAddressLiving);
        optionAddressGroup.add(optionAddressOthers);

        optionAddressUseGroup.add(optionPresent);
        optionAddressUseGroup.add(optionPrevious);
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

    private void initAddressTable() {
        tableAddress.putClientProperty("Quaqua.Table.style", "striped" );
        tableAddress.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAddress.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tableAddress.getSelectedRow();
                    if (selectedIndex >= 0) {
                        setAddress(addresses.get(selectedIndex));
                    }
                } catch (Exception e) {
                    // TODO, log exception
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        optionAddressGroup = new javax.swing.ButtonGroup();
        optionAddressUseGroup = new javax.swing.ButtonGroup();
        addresses = ObservableCollections.observableList(new LinkedList<Address>());
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAddress = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBrgy = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtYrsOfStay = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        optionAddressOwned = new javax.swing.JRadioButton();
        optionAddressRenting = new javax.swing.JRadioButton();
        optionAddressLiving = new javax.swing.JRadioButton();
        optionAddressOthers = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtZipcode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        optionPresent = new javax.swing.JRadioButton();
        optionPrevious = new javax.swing.JRadioButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAddress.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, addresses, tableAddress);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${brgyCode}"));
        columnBinding.setColumnName("Brgy ");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${zipCode}"));
        columnBinding.setColumnName("Zip Code");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tableAddress);
        tableAddress.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableAddress.getColumnModel().getColumn(0).setMaxWidth(80);
        tableAddress.getColumnModel().getColumn(1).setPreferredWidth(80);
        tableAddress.getColumnModel().getColumn(1).setMaxWidth(80);
        tableAddress.getColumnModel().getColumn(2).setResizable(false);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 570, 90));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Brgy.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, -1, -1));

        txtBrgy.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtBrgy.setToolTipText("Press F5 to search");
        txtBrgy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBrgyFocusLost(evt);
            }
        });
        add(txtBrgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 115, 80, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Zipcode");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 120, -1, -1));

        txtYrsOfStay.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtYrsOfStay.setToolTipText("Press F5 to search");
        txtYrsOfStay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtYrsOfStayFocusLost(evt);
            }
        });
        add(txtYrsOfStay, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 165, 80, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Street");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 120, -1, -1));

        txtStreet.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtStreet.setToolTipText("Press F5 to search");
        txtStreet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStreetFocusLost(evt);
            }
        });
        add(txtStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 115, 230, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Description");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 145, -1, -1));

        txtDesc.setEditable(false);
        txtDesc.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtDesc.setToolTipText("Press F5 to search");
        txtDesc.setFocusable(false);
        add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 500, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Status");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 170, -1, -1));

        optionAddressOwned.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        optionAddressOwned.setText("Owned");
        optionAddressOwned.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionAddressOwnedItemStateChanged(evt);
            }
        });
        add(optionAddressOwned, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 166, -1, -1));

        optionAddressRenting.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        optionAddressRenting.setText("Renting");
        optionAddressRenting.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionAddressRentingItemStateChanged(evt);
            }
        });
        add(optionAddressRenting, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 166, -1, -1));

        optionAddressLiving.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        optionAddressLiving.setText("Living with Parents/Relatives");
        optionAddressLiving.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionAddressLivingItemStateChanged(evt);
            }
        });
        add(optionAddressLiving, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 166, -1, -1));

        optionAddressOthers.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        optionAddressOthers.setText("Others");
        optionAddressOthers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionAddressOthersItemStateChanged(evt);
            }
        });
        add(optionAddressOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 166, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Yrs. of stay");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        txtZipcode.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtZipcode.setToolTipText("Press F5 to search");
        txtZipcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtZipcodeFocusLost(evt);
            }
        });
        add(txtZipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 115, 80, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Use as");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 195, -1, -1));

        optionPresent.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        optionPresent.setText("Present Address");
        optionPresent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionPresentItemStateChanged(evt);
            }
        });
        add(optionPresent, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        optionPrevious.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        optionPrevious.setText("Previous Address");
        optionPrevious.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionPreviousItemStateChanged(evt);
            }
        });
        add(optionPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBrgyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrgyFocusLost
        brgyCode = UIValidator.validate(txtBrgy);
    }//GEN-LAST:event_txtBrgyFocusLost

    private void txtZipcodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtZipcodeFocusLost
        zipCode = UIValidator.validate(txtZipcode);
    }//GEN-LAST:event_txtZipcodeFocusLost

    private void txtStreetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStreetFocusLost
        street = UIValidator.validate(txtStreet);
        txtDesc.setText(street + "," + txtDesc.getText());
    }//GEN-LAST:event_txtStreetFocusLost

    private void optionAddressOwnedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionAddressOwnedItemStateChanged
        if (optionAddressOwned.isSelected()) {
            status = "OWNED";
        }
    }//GEN-LAST:event_optionAddressOwnedItemStateChanged

    private void optionAddressRentingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionAddressRentingItemStateChanged
        if (optionAddressRenting.isSelected()) {
            status = "RENTING";
        }
    }//GEN-LAST:event_optionAddressRentingItemStateChanged

    private void optionAddressLivingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionAddressLivingItemStateChanged
        if (optionAddressLiving.isSelected()) {
            status = "LIVING WITH PARENTS/RELATIVES";
        }
    }//GEN-LAST:event_optionAddressLivingItemStateChanged

    private void optionAddressOthersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionAddressOthersItemStateChanged
        if (optionAddressOthers.isSelected()) {
            status = "OTHERS";
        }
    }//GEN-LAST:event_optionAddressOthersItemStateChanged

    private void txtYrsOfStayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYrsOfStayFocusLost
        yearsOfStay = Integer.parseInt(UIValidator.isNumeric(txtYrsOfStay));
    }//GEN-LAST:event_txtYrsOfStayFocusLost

    private void optionPresentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionPresentItemStateChanged
        description = "PRESENT ADDRESS";
    }//GEN-LAST:event_optionPresentItemStateChanged

    private void optionPreviousItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionPreviousItemStateChanged
        description = "PREVIOUS ADDRESS";
    }//GEN-LAST:event_optionPreviousItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<Address> addresses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup optionAddressGroup;
    private javax.swing.JRadioButton optionAddressLiving;
    private javax.swing.JRadioButton optionAddressOthers;
    private javax.swing.JRadioButton optionAddressOwned;
    private javax.swing.JRadioButton optionAddressRenting;
    private javax.swing.ButtonGroup optionAddressUseGroup;
    private javax.swing.JRadioButton optionPresent;
    private javax.swing.JRadioButton optionPrevious;
    private javax.swing.JTable tableAddress;
    private javax.swing.JTextField txtBrgy;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtYrsOfStay;
    private javax.swing.JTextField txtZipcode;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private String brgyCode;
    private String zipCode;
    private String street;
    private String description;
    private String status;
    private int yearsOfStay;
    private int selectedIndex;
    private HeaderPanel headerPanel;
    private String personType;
    private MainPanel mainPanel;
    private Barangay barangay;

    public void setBarangay(Barangay barangay) {
        this.barangay = barangay;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
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
            } else if (txtYrsOfStay.isFocusOwner()) {
                optionPresent.requestFocus();
            } else if (optionPresent.isFocusOwner()) {
                optionPrevious.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (optionPrevious.isFocusOwner()) {
                optionPresent.requestFocus();
            } else if (optionPresent.isFocusOwner()) {
                optionPrevious.requestFocus();
            } else if (optionPrevious.isFocusOwner()) {
                txtYrsOfStay.requestFocus();
            } else if (txtYrsOfStay.isFocusOwner()) {
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
                if(txtBrgy.isFocusOwner()) {
                    BarangayDlg barangayDlg = new BarangayDlg(null, true);
                    barangayDlg.setBarangayService(UISetting.getBarangayService());
                    barangayDlg.setVisible(true);
                    if(barangayDlg.getBarangay() != null) {
                        setBarangay(barangayDlg.getBarangay());
                        txtBrgy.setText(barangay.getCode());
                        txtDesc.setText(barangay.getAddress());
                    }
                } 
            break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtBrgy.setEditable(value);
        txtZipcode.setEditable(value);
        txtStreet.setEditable(value);
        optionAddressOwned.setEnabled(value);
        optionAddressRenting.setEnabled(value);
        optionAddressLiving.setEnabled(value);
        optionAddressOthers.setEnabled(value);
        txtYrsOfStay.setEditable(value);
        optionPresent.setEnabled(value);
        optionPrevious.setEnabled(value);
        
        txtBrgy.setFocusable(value);
        txtZipcode.setFocusable(value);
        txtStreet.setFocusable(value);
        optionAddressOwned.setFocusable(value);
        optionAddressRenting.setFocusable(value);
        optionAddressLiving.setFocusable(value);
        optionAddressOthers.setFocusable(value);
        txtYrsOfStay.setFocusable(value);
        optionPresent.setFocusable(value);
        optionPrevious.setFocusable(value);
        tableAddress.setFocusable(value);
    }

    public void resetToDefault() {
        txtBrgy.setText("");
        txtZipcode.setText("");
        txtStreet.setText("");
        optionAddressOwned.setSelected(true);
        optionAddressRenting.setSelected(false);
        optionAddressLiving.setSelected(false);
        optionAddressOthers.setSelected(false);
        txtYrsOfStay.setText("");
        optionPresent.setSelected(true);
        optionPrevious.setSelected(false);
    }

    public void setAddress(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            Address a = (Address) o;
            txtBrgy.setText(a.getBrgyCode());
            txtZipcode.setText(a.getZipCode());
            txtStreet.setText(a.getAddress());
            txtDesc.setText(a.getAddress() + ", " + a.getBrgyDesc());
            switch (a.getStatus()) {
                case "OWNED":
                    optionAddressOwned.setSelected(true);
                    optionAddressRenting.setSelected(false);
                    optionAddressLiving.setSelected(false);
                    optionAddressOthers.setSelected(false);
                    break;
                case "RENTING":
                    optionAddressOwned.setSelected(false);
                    optionAddressRenting.setSelected(true);
                    optionAddressLiving.setSelected(false);
                    optionAddressOthers.setSelected(false);
                    break;
                case "LIVING WITH PARENTS/RELATIVES":
                    optionAddressOwned.setSelected(false);
                    optionAddressRenting.setSelected(false);
                    optionAddressLiving.setSelected(true);
                    optionAddressOthers.setSelected(false);
                    break;
                case "OTHERS":
                    optionAddressOwned.setSelected(false);
                    optionAddressRenting.setSelected(false);
                    optionAddressLiving.setSelected(false);
                    optionAddressOthers.setSelected(true);
                    break;
            }
            switch(a.getAddressType()) {
                case "PRESENT":
                    optionPresent.setSelected(true);
                    break;
                case "PREVIOUS":
                    optionPrevious.setSelected(true);
                    break;    
            }
            txtYrsOfStay.setText(a.getYearsOfStay());
        }
    }

    public boolean saveAddress() {
        List<Address> a = AddressController.getInstance().save(headerPanel.getFormNo(), personType, createNew(new Address()));
        refreshTable(a);
        return !a.isEmpty();
    }
    
    public boolean saveCoMakerAddress() {
        List<Address> a = AddressController.getInstance().save(headerPanel.getFormNo(), mainPanel.getSelectedCoMaker().getPersonType().getTypeID(), createNew(new Address()));
        refreshTable(a);
        return !a.isEmpty();
    }

    public boolean updateAddress() {
        return true;
    }
    
    public boolean changeAddress() {
        return true;
    }

    public void refreshTable(List<Address> a) {
        addresses.clear();
        addresses.addAll(a);
        if (!addresses.isEmpty()) {
            tableAddress.setRowSelectionInterval(0, 0);
        } else {
            resetToDefault();
        }
    }
    
    private Address createNew(Address a) {
        a.setBrgyCode(txtBrgy.getText());
        a.setBrgyDesc(barangay.getAddress());
        a.setZipCode(txtZipcode.getText());
        a.setAddress(txtStreet.getText());
        if(optionPresent.isSelected()) {
            a.setAddressType("PRESENT");
        } else {
            a.setAddressType("PREVIOUS");
        }
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

}
