/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.panel;

import ch.randelshofer.quaqua.JSheet;
import ch.randelshofer.quaqua.SheetEvent;
import ch.randelshofer.quaqua.SheetListener;
import com.vg.commons.renderer.IndexedFocusTraversalPolicy;
import com.vg.commons.util.UIMgr;
import com.vg.scfc.financing.cis.ent.CustomerCashInfo;
import com.vg.scfc.financing.cis.ui.controller.CashController;
import com.vg.scfc.financing.cis.ui.listener.BasicActionListener;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import com.vg.scfc.financing.commons.ui.dlg.BarangayDlg;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class CashPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form CashPanel
     */
    public CashPanel() {
        initComponents();
        initCustomerTable();
        initKeyListeners();
        initAddEditButtonListener();
        txtSearch.putClientProperty("Quaqua.TextField.style", "search");
        txtSearch.setText("Search");
        setFieldsEditable(false, true);
        btnSearch.setIcon(new ImageIcon("src/resources/icons/searchIcon.png"));
    }

    public IndexedFocusTraversalPolicy getPolicy() {
        IndexedFocusTraversalPolicy policy = new IndexedFocusTraversalPolicy();
        policy.addForwardTraversalKeys(this, KeyEvent.VK_ENTER);
        policy.addIndexedComponent(txtLastname);
        policy.addIndexedComponent(txtFirstname);
        policy.addIndexedComponent(txtMiddlename);
        policy.addIndexedComponent(txtBarangayCode);
        policy.addIndexedComponent(txtAddress);
        policy.addIndexedComponent(txtZipCode);
        policy.addIndexedComponent(txtContact);
//        policy.addIndexedComponent(txtSearch);
//        policy.addIndexedComponent(btnSearch);
        txtContact.setFocusTraversalKeysEnabled(false);
        txtSearch.setFocusTraversalKeysEnabled(false);

        return policy;
    }

    private void initKeyListeners() {
        txtLastname.addKeyListener(this);
        txtFirstname.addKeyListener(this);
        txtMiddlename.addKeyListener(this);
        txtBarangayCode.addKeyListener(this);
        txtAddress.addKeyListener(this);
        txtZipCode.addKeyListener(this);
        txtContact.addKeyListener(this);
        txtSearch.addKeyListener(this);
    }

    private void initAddEditButtonListener() {
        addEditButton.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                enableSearch(false);
                showSheet();
                setFieldsEditable(true, isPerson);
                resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                CustomerCashInfo c = createNew(new CustomerCashInfo());
                if (!isValidCustomerCashInfo(c)) {
                    return false;
                }

                c = CashController.getInstance().save(c);
                if (c != null) {
                    UIValidator.promptSucessMessageFor("SAVE");
                    setFieldsEditable(false, isPerson);
                    setCustomerCashInfo(c);
                    enableSearch(true);
                    return true;
                } else {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                }
            }

            @Override
            public void onCancelAdd() {
                setFieldsEditable(false, isPerson);
                if (customerCashInfo != null) {
                    setCustomerCashInfo(customerCashInfo);
                }
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                if (customerCashInfo != null) {
                    setFieldsEditable(true, isPerson);
                    enableSearch(false);
                } else {
                    addEditButton.resetActionStateToDefault();
                }
            }

            @Override
            public boolean onSaveEdit() {
                CustomerCashInfo c = createNew(customerCashInfo);
                if (!isValidCustomerCashInfo(c)) {
                    return false;
                }

                c = CashController.getInstance().update(c);
                if (c != null) {
                    UIValidator.promptSucessMessageFor("EDIT");
                    setFieldsEditable(false, isPerson);
                    setCustomerCashInfo(c);
                    enableSearch(true);
                    return true;
                } else {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                }
            }

            @Override
            public void onCancelEdit() {
                setFieldsEditable(false, isPerson);
                enableSearch(true);
            }
        });
    }

    private void initCustomerTable() {
        tableCashCustomer.putClientProperty("Quaqua.Table.style", "striped");
        tableCashCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCashCustomer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tableCashCustomer.getSelectedRow();
                    if (selectedIndex >= 0) {
                        setCustomerCashInfo(cashCustomers.get(selectedIndex));
                    }
                } catch (Exception e) {
                    UIValidator.log(e, CashPanel.class);
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

        cashCustomers = ObservableCollections.observableList(new LinkedList<CustomerCashInfo>());
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCashCustomer = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblLastname = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        lblFirstname = new javax.swing.JLabel();
        txtMiddlename = new javax.swing.JTextField();
        lblMiddlename = new javax.swing.JLabel();
        txtBarangayCode = new javax.swing.JTextField();
        txtBarangayDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtZipCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        addEditButton = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setText("Search");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 220, -1));

        tableCashCustomer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tableCashCustomer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cashCustomers, tableCashCustomer);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${middleName}"));
        columnBinding.setColumnName("Middle Name");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tableCashCustomer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 40, 330, 240));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/searchIcon.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 5, 110, -1));

        lblResult.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblResult.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblResult.setText("Search Result: 0");
        lblResult.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 285, 200, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 340, 310));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLastname.setText("Lastname");
        jPanel2.add(lblLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 25, -1, -1));

        txtLastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastnameFocusLost(evt);
            }
        });
        jPanel2.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 375, -1));

        txtFirstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFirstnameFocusLost(evt);
            }
        });
        jPanel2.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 45, 375, -1));

        lblFirstname.setText("Firstname");
        jPanel2.add(lblFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 50, -1, -1));

        txtMiddlename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMiddlenameFocusLost(evt);
            }
        });
        jPanel2.add(txtMiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 375, -1));

        lblMiddlename.setText("Middlename");
        jPanel2.add(lblMiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 75, -1, -1));

        txtBarangayCode.setEditable(false);
        jPanel2.add(txtBarangayCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 95, 100, -1));

        txtBarangayDesc.setEditable(false);
        txtBarangayDesc.setFocusable(false);
        jPanel2.add(txtBarangayDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 95, 270, -1));

        jLabel4.setText("Barangay");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 100, -1, -1));

        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 375, -1));

        jLabel5.setText("Address");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 125, -1, -1));

        txtZipCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtZipCodeFocusLost(evt);
            }
        });
        jPanel2.add(txtZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 145, 150, -1));

        jLabel6.setText("Zipcode");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 150, -1, -1));

        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactFocusLost(evt);
            }
        });
        jPanel2.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 260, -1));

        jLabel7.setText("Contact #");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 175, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 470, -1));
        jPanel2.add(addEditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, 480, 310));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        refreshSearchTable(CashController.getInstance().findBySearchCriteria(txtSearch.getText()));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtLastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastnameFocusLost
        txtLastname.setText(UIValidator.validate(txtLastname));
    }//GEN-LAST:event_txtLastnameFocusLost

    private void txtFirstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstnameFocusLost
        txtFirstname.setText(UIValidator.validate(txtFirstname));
    }//GEN-LAST:event_txtFirstnameFocusLost

    private void txtMiddlenameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMiddlenameFocusLost
        txtMiddlename.setText(UIValidator.validate(txtMiddlename));
    }//GEN-LAST:event_txtMiddlenameFocusLost

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        txtAddress.setText(UIValidator.validate(txtAddress));
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtZipCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtZipCodeFocusLost
        txtZipCode.setText(UIValidator.validate(txtZipCode));
    }//GEN-LAST:event_txtZipCodeFocusLost

    private void txtContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusLost
        txtContact.setText(UIValidator.validate(txtContact));
    }//GEN-LAST:event_txtContactFocusLost

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.selectAll();
    }//GEN-LAST:event_txtSearchFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditButton;
    private javax.swing.JButton btnSearch;
    private java.util.List<CustomerCashInfo> cashCustomers;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblMiddlename;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTable tableCashCustomer;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBarangayCode;
    private javax.swing.JTextField txtBarangayDesc;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtMiddlename;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtZipCode;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private JFrame frame;
    private int selectedIndex = 0;
    private CustomerCashInfo customerCashInfo;
    private boolean isPerson;

    public void setIsPerson(boolean isPerson) {
        this.isPerson = isPerson;
    }

    public void setCustomerCashInfo(CustomerCashInfo customerCashInfo) {
        this.customerCashInfo = customerCashInfo;
        setCustomerCashInfoData(this.customerCashInfo);
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public CustomerCashInfo createNew(CustomerCashInfo c) {
        c.setAddress(txtAddress.getText());
        c.setBarangayCode(txtBarangayCode.getText());
        c.setBarangayDescription(txtBarangayDesc.getText());
        c.setContactNo(txtContact.getText());
        c.setFirstName(txtFirstname.getText());
        c.setLastName(txtLastname.getText());
        c.setMiddleName(txtMiddlename.getText());
        c.setPerson(isPerson);
        return c;
    }

    public void setCustomerCashInfoData(CustomerCashInfo c) {
        if (c == null) {
            resetToDefault();
        } else {
            if (c.isPerson()) {
                lblLastname.setText("Lastname");
                lblFirstname.setText("Firstname");
                lblMiddlename.setText("Middlename");
            } else {
                lblLastname.setText("Company");
                lblFirstname.setText("");
                lblMiddlename.setText("");
            }
            setIsPerson(c.isPerson());
            txtLastname.setText(c.getLastName());
            txtFirstname.setText(c.getFirstName());
            txtMiddlename.setText(c.getMiddleName());
            txtBarangayCode.setText(c.getBarangayCode());
            txtBarangayDesc.setText(c.getBarangayDescription());
            txtAddress.setText(c.getAddress());
            txtZipCode.setText(c.getZipCode());
            txtContact.setText(c.getContactNo());
        }
    }

    public void refreshSearchTable(List<CustomerCashInfo> c) {
        cashCustomers.clear();
        cashCustomers.addAll(c);
        if (!cashCustomers.isEmpty()) {
            tableCashCustomer.setRowSelectionInterval(0, 0);
            tableCashCustomer.requestFocus();
        }
        if (txtSearch.getText().equals("")) {
            txtSearch.setText("Search");
        }
        countResult(cashCustomers);
    }

    public void setFieldsEditable(boolean value, boolean isPerson) {
        if (!isPerson) {
            lblLastname.setText("Company");
            lblFirstname.setText("");
            lblMiddlename.setText("");
            txtFirstname.setEditable(false);
            txtMiddlename.setEditable(false);
            txtFirstname.setFocusable(false);
            txtMiddlename.setFocusable(false);
        } else {
            lblLastname.setText("Lastname");
            lblFirstname.setText("Firstname");
            lblMiddlename.setText("Middlename");
            txtFirstname.setEditable(value);
            txtMiddlename.setEditable(value);
            txtFirstname.setFocusable(value);
            txtMiddlename.setFocusable(value);
        }
        txtLastname.setEditable(value);
        txtAddress.setEditable(value);
        txtZipCode.setEditable(value);
        txtContact.setEditable(value);
        txtLastname.setFocusable(value);
        txtBarangayCode.setFocusable(value);
        txtAddress.setFocusable(value);
        txtZipCode.setFocusable(value);
        txtContact.setFocusable(value);

        if (value) {
            txtLastname.requestFocus();
            txtLastname.selectAll();
        }
    }

    private boolean isValidCustomerCashInfo(CustomerCashInfo cashInfo) {
        if (cashInfo != null) {
            if (cashInfo.isPerson()) {
                if (cashInfo.getLastName().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Last Name is a required field.",
                            "Empty Field", JOptionPane.ERROR_MESSAGE);
                    txtLastname.requestFocus();
                    return false;

                } else if (cashInfo.getFirstName().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "First Name is a required field.",
                            "Empty Field", JOptionPane.ERROR_MESSAGE);
                    txtFirstname.requestFocus();
                } else if (cashInfo.getMiddleName().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Middle Name is a required field.",
                            "Empty Field", JOptionPane.ERROR_MESSAGE);
                    txtFirstname.requestFocus();
                }
            } else {
                if (cashInfo.getLastName().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Company Name is a required field.",
                            "Empty Field", JOptionPane.ERROR_MESSAGE);
                    txtLastname.requestFocus();
                }
            }
            if (cashInfo.getBarangayCode().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Barangay is a required field.",
                        "Empty Field", JOptionPane.ERROR_MESSAGE);
                txtBarangayCode.requestFocus();
            }
        } else {
            return false;
        }

        return true;
    }

    public void resetToDefault() {
        txtLastname.setText("");
        txtFirstname.setText("");
        txtMiddlename.setText("");
        txtBarangayCode.setText("");
        txtBarangayDesc.setText("");
        txtAddress.setText("");
        txtZipCode.setText("");
        txtContact.setText("");
    }

    private void countResult(List<CustomerCashInfo> customers) {
        lblResult.setText("Search Result: " + customers.size());
    }

    public void showSheet() {
        JOptionPane pane = new JOptionPane("<html>" + "<b>Please select Transaction type:</b><p>", JOptionPane.QUESTION_MESSAGE);
        Object[] options = {"PERSON", "COMPANY"};
        pane.setOptions(options);
        pane.setInitialValue(options[0]);
        pane.putClientProperty("Quaqua.OptionPane.destructiveOption", new Integer(2));
        JSheet.showSheet(pane, frame, new SheetListener() {
            @Override
            public void optionSelected(SheetEvent evt) {
                Object value = evt.getValue();
                if (value == null || value.equals("Cancel")) {
                    frame.setEnabled(true);
                } else if (value.equals("PERSON")) {
                    setIsPerson(true);
                    lblLastname.setText("Lastname");
                    lblFirstname.setText("Firstname");
                    lblMiddlename.setText("Middlename");
                } else if (value.equals("COMPANY")) {
                    setIsPerson(false);
                    lblLastname.setText("Company");
                    lblFirstname.setText("");
                    lblMiddlename.setText("");
                }
            }
        });
    }

    private void enableSearch(boolean value) {
        btnSearch.setEnabled(value);
        tableCashCustomer.setEnabled(value);
        txtSearch.setEnabled(value);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
                if (txtLastname.isFocusOwner()) {
                if (txtFirstname.isEditable()) {
                    txtFirstname.requestFocus();
                } else {
                    txtBarangayCode.requestFocus();
                }
            } else if (txtFirstname.isFocusOwner()) {
                txtMiddlename.requestFocus();
            } else if (txtMiddlename.isFocusOwner()) {
                txtBarangayCode.requestFocus();
            } else if (txtBarangayCode.isFocusOwner()) {
                txtAddress.requestFocus();
            } else if (txtAddress.isFocusOwner()) {
                txtZipCode.requestFocus();
            } else if (txtZipCode.isFocusOwner()) {
                txtContact.requestFocus();
            } else if (txtSearch.isFocusOwner()) {
                refreshSearchTable(CashController.getInstance().findBySearchCriteria(txtSearch.getText()));
            } else if (txtContact.isFocusOwner()) {
                if (addEditButton.getBtnAdd().getText().equals("Save")) {
                    addEditButton.getBtnAdd().requestFocusInWindow();
                } else {
                    addEditButton.getBtnEdit().requestFocusInWindow();
                }
            }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (txtContact.isFocusOwner()) {
                txtZipCode.requestFocus();
            } else if (txtZipCode.isFocusOwner()) {
                txtAddress.requestFocus();
            } else if (txtAddress.isFocusOwner()) {
                txtBarangayCode.requestFocus();
            } else if (txtBarangayCode.isFocusOwner()) {
                if (txtMiddlename.isFocusable()) {
                    txtMiddlename.requestFocus();
                } else {
                    txtLastname.requestFocus();
                }
            } else if (txtMiddlename.isFocusOwner()) {
                txtFirstname.requestFocus();
            } else if (txtFirstname.isFocusOwner()) {
                txtLastname.requestFocus();
            }
                break;
            case KeyEvent.VK_F5:
                if (txtBarangayCode.isFocusOwner()) {
                BarangayDlg barangayDlg = new BarangayDlg(null, true);
                barangayDlg.setBarangayService(UISetting.getBarangayService());
                UIMgr.centerToScreen(barangayDlg);
                barangayDlg.setVisible(true);
                if (barangayDlg.getBarangay() != null) {
                    txtBarangayCode.setText(barangayDlg.getBarangay().getCode());
                    txtBarangayDesc.setText(barangayDlg.getBarangay().getAddress());
                }
            }
                break;
        }
    }

//    public boolean validCashInfo(CustomerCashInfo c) {
//        if (c != null) {
//            boolean result = true;
//            if (!UIValidator.validate(txtLastname, "Lastname is required.")) {
//                result = false;
//            }
//            if (!UIValidator.validate(txtFirstname, "Firstname is required.")) {
//                result = false;
//            }
//            if (!UIValidator.validate(txtBarangayCode, "Barangay is required.")) {
//                result = false;
//            }
//            if (!UIValidator.validate(txtContact, "Contact # is required.")) {
//                result = false;
//            }
//            return result;
//        } else {
//            return false;
//        }
//    }

}
