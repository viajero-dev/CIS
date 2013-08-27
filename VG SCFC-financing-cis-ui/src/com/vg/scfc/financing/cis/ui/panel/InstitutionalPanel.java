/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.panel;

import com.vg.commons.dlg.WaitSplashScreen;
import com.vg.commons.listener.DoJasperPrintReport;
import com.vg.commons.util.UIMgr;
import com.vg.scfc.financing.cis.ent.Address;
import com.vg.scfc.financing.cis.ent.Company;
import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.Identification;
import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.ui.controller.AddressController;
import com.vg.scfc.financing.cis.ui.controller.CompanyController;
import com.vg.scfc.financing.cis.ui.controller.EmploymentController;
import com.vg.scfc.financing.cis.ui.controller.PersonalInfoController;
import com.vg.scfc.financing.cis.ui.controller.PurchaseOrderController;
import com.vg.scfc.financing.cis.ui.controller.ReportController;
import com.vg.scfc.financing.cis.ui.controller.RidersToBuyerController;
import com.vg.scfc.financing.cis.ui.controller.SearchController;
import com.vg.scfc.financing.cis.ui.dialog.AddressDialog;
import com.vg.scfc.financing.cis.ui.dialog.ApplicationFormDlg;
import com.vg.scfc.financing.cis.ui.listener.BasicActionListener;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author rodel
 */
public class InstitutionalPanel extends javax.swing.JPanel implements KeyListener, DoJasperPrintReport {

    /**
     * Creates new form InstitutionalPanel
     */
    public InstitutionalPanel() {
        initComponents();
        initCompanyInfoAddEditListener();
        initRepresentative1PersonalInfoAddEditListener();
        initRepresentative1EmploymentAddEditListener();
        initRepresentative2PersonalInfoAddEditListener();
        initRepresentative2EmploymentAddEditListener();
        initPurchaseOrderAddEditListener();
        initRidersToBuyer();
        fillValue(searchPanelInstitution.getTransactionForm());
        searchPanelInstitution.setInstitutionalPanel(this);
        initFields();
    }

    private void initTabs() {
//        jTabbedPane1.setLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.putClientProperty("Quaqua.TabbedPane.shortenTabs", Boolean.FALSE);
    }

    private void initCompanyInfoAddEditListener() {
        panelCompanyInformation.setHeaderPanel(headerPanel);
        panelCompanyInformation.setTxtCompanyName(txtCompanyName);
        panelCompanyInformation.setInstitutionalPanel(this);
        addEditCompanyInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                resetToDefault();
                 ApplicationFormDlg form = new ApplicationFormDlg(null, true);
                UIMgr.centerToScreen(form);
                form.setVisible(true);
                headerPanel.setFormNo("");
                headerPanel.setIDNo(form.getFormSeries());
                try {
                    headerPanel.setApplicationDate(form.getApplicationDate());
                } catch (ParseException ex) {
                    UIValidator.log(ex, MainPanel.class);
                }
                headerPanel.enableFields(true);
                panelCompanyInformation.setFieldsEditable(true);
                panelCompanyInformation.resetToDefault();
                txtCompanyName.setText("");
                txtCompleteAddress.setText("");
                txtCompanyName.requestFocus();
            }

            @Override
            public boolean onSaveAdd() {
                panelCompanyInformation.setAddress(companyAddress);
                boolean isSaved = panelCompanyInformation.saveCompanyInformation();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCompanyInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCompanyInformation.setFieldsEditable(false);
                // TODO, reset UI
            }

            @Override
            public void onEdit() {
                panelCompanyInformation.setHeaderPanel(headerPanel);
                panelCompanyInformation.setTxtCompanyName(txtCompanyName);
                panelCompanyInformation.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCompanyInformation.updateCompanyInformation();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCompanyInformation.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCompanyInformation.setFieldsEditable(false);
                // TODO, reset UI
            }
        });
    }

    private void initRepresentative1PersonalInfoAddEditListener() {
        panelRepresentative1PersonalInformation.setHeaderPanel(headerPanel);
        panelRepresentative1PersonalInformation.setPersonType("RP1");
        addEditRepresentative1PersonalInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative1PersonalInformation.setFieldsEditable(true);
                panelRepresentative1PersonalInformation.resetToDefault();
                panelRepresentative1PersonalInformation.setClientNo(SearchController.getInstance().findByFormNo(headerPanel.getFormNo()).getClientNo());
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative1PersonalInformation.saveRepresentativePersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative1PersonalInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative1PersonalInformation.resetToDefault();
                panelRepresentative1PersonalInformation.setFieldsEditable(false);
            }

            @Override
            public void onEdit() {
                panelRepresentative1PersonalInformation.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelRepresentative1PersonalInformation.updateRepresentativePersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelRepresentative1PersonalInformation.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative1PersonalInformation.setFieldsEditable(false);
            }
        });
    }

    private void initRepresentative1EmploymentAddEditListener() {
        panelRepresentative1Employment.setHeaderPanel(headerPanel);
        panelRepresentative1Employment.setPersonType("RP1");
        addEditRepresentative1Employment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative1Employment.setFieldsEditable(true);
                panelRepresentative1Employment.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative1Employment.saveEmployment();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative1Employment.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative1Employment.setFieldsEditable(false);
                //TODO, reset UI
            }

            @Override
            public void onEdit() {
                panelRepresentative1Employment.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelRepresentative1Employment.updateEmployment();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelRepresentative1Employment.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative1Employment.setFieldsEditable(false);
                //TODO, reset UI
            }
        });
    }

    private void initRepresentative2PersonalInfoAddEditListener() {
        panelRepresentative2PersonalInformation.setHeaderPanel(headerPanel);
        panelRepresentative2PersonalInformation.setPersonType("RP2");
        addEditRepresentative2PersonalInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative2PersonalInformation.setFieldsEditable(true);
                panelRepresentative2PersonalInformation.resetToDefault();
                panelRepresentative2PersonalInformation.setClientNo(SearchController.getInstance().findByFormNo(headerPanel.getFormNo()).getClientNo());
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative2PersonalInformation.saveRepresentativePersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative2PersonalInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative2PersonalInformation.resetToDefault();
                panelRepresentative2PersonalInformation.setFieldsEditable(false);
            }

            @Override
            public void onEdit() {
                panelRepresentative2PersonalInformation.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelRepresentative2PersonalInformation.updateRepresentativePersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative2PersonalInformation.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative2PersonalInformation.setFieldsEditable(false);
            }
        });
    }

    private void initRepresentative2EmploymentAddEditListener() {
        panelRepresentative2Employment.setHeaderPanel(headerPanel);
        panelRepresentative2Employment.setPersonType("RP2");
        addEditRepresentative2Employment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative2Employment.setFieldsEditable(true);
                panelRepresentative2Employment.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative2Employment.saveEmployment();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative2Employment.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative2Employment.setFieldsEditable(false);
                //TODO, reset UI
            }

            @Override
            public void onEdit() {
                panelRepresentative2Employment.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelRepresentative2Employment.updateEmployment();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelRepresentative2Employment.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative2Employment.setFieldsEditable(false);
                //TODO, reset UI
            }
        });
    }

    private void initPurchaseOrderAddEditListener() {
        panelPurchaseOrder.setHeaderPanel(headerPanel);
        addEditPurchaseOrder.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelPurchaseOrder.setFieldsEditable(true);
                panelPurchaseOrder.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelPurchaseOrder.savePurchaseOrder();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelPurchaseOrder.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelPurchaseOrder.setFieldsEditable(false);
            }

            @Override
            public void onEdit() {
                panelPurchaseOrder.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelPurchaseOrder.updatePurchaseOrder();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelPurchaseOrder.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelPurchaseOrder.setFieldsEditable(false);
            }
        });
    }

    private void initRidersToBuyer() {
        ridersToBuyerPanel.setHeaderPanel(headerPanel);
        ridersToBuyerPanel.setPersonType("APP");
    }

    public void refreshSearch(String formNo) {
        List<Customer> customers = new ArrayList<>();
        Customer c = SearchController.getInstance().findByFormNo(formNo);
        customers.add(c);
        searchPanelInstitution.refreshCustomerTable(customers);
    }
    
    public void resetToDefault() {
        panelCompanyInformation.resetToDefault();
        panelPurchaseOrder.resetToDefault();
        panelRepresentative1Employment.resetToDefault();
        panelRepresentative1PersonalInformation.resetToDefault();
        panelRepresentative2Employment.resetToDefault();
        panelRepresentative2PersonalInformation.resetToDefault();
        txtCompanyName.setText("");
        txtCompleteAddress.setText("");
    }

    public void fillValue(TransactionForm form) {
        if (form != null) {
            headerPanel.setFormNo(form.getTxFormNo());
            headerPanel.setIDNo(form.getFormNo());
            headerPanel.setApplicationDate(form.getTxApplicationDate());
            headerPanel.enableFields(false);
            List<Address> addresses = AddressController.getInstance().findByFormNo(form.getTxFormNo(), "APP");
            if (!addresses.isEmpty()) {
                panelCompanyInformation.setAddress(addresses.get(0));
            }
            panelCompanyInformation.setCompany((Company) CompanyController.getInstance().findByFormNo(form.getTxFormNo()));
            panelRepresentative1PersonalInformation.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "RP1"));
            panelRepresentative2PersonalInformation.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "RP2"));
            panelRepresentative1Employment.setRepresentativeEmployment(EmploymentController.getInstance().findRepresentativeEmploymentByFormNoAndPersonType(form.getTxFormNo(), "RP1"));
            panelRepresentative2Employment.setRepresentativeEmployment(EmploymentController.getInstance().findRepresentativeEmploymentByFormNoAndPersonType(form.getTxFormNo(), "RP2"));
            PurchaseOrder p = PurchaseOrderController.getInstance().findByFormNo(form.getTxFormNo());
            if (p != null) {
                headerPanel.setApplicationStatus(p.getStatus());
                panelPurchaseOrder.setPurchaseOrder(p);
            } else {
                headerPanel.setApplicationStatus("");
                panelPurchaseOrder.setPurchaseOrder(null);
            }
            Identification i = RidersToBuyerController.getInstance().findByFormNo(form.getTxFormNo());
            if (i != null) {
                ridersToBuyerPanel.setIdentification(i);
            } else {
                ridersToBuyerPanel.setIdentification(null);
            }
        }
    }

    private void initFields() {
        panelCompanyInformation.setFieldsEditable(false);
        panelRepresentative1Employment.setFieldsEditable(false);
        panelRepresentative1PersonalInformation.setFieldsEditable(false);
        panelRepresentative2Employment.setFieldsEditable(false);
        panelRepresentative2PersonalInformation.setFieldsEditable(false);
        panelPurchaseOrder.setFieldsEditable(false);
        ridersToBuyerPanel.setFieldsEditable(false);

        txtCompanyName.addKeyListener(this);
        txtCompleteAddress.addKeyListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCompanyInformation = new com.vg.scfc.financing.cis.ui.panel.CompanyInformationPanel();
        addEditCompanyInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        panelRepresentative1PersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditRepresentative1PersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel4 = new javax.swing.JPanel();
        addEditRepresentative1Employment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelRepresentative1Employment = new com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        panelRepresentative2PersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditRepresentative2PersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel6 = new javax.swing.JPanel();
        addEditRepresentative2Employment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelRepresentative2Employment = new com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel();
        jPanel7 = new javax.swing.JPanel();
        ridersToBuyerPanel = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        btnAgree = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        addEditPurchaseOrder = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelPurchaseOrder = new com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2();
        btnPrint = new javax.swing.JButton();
        headerPanel = new com.vg.scfc.financing.cis.ui.reusable.HeaderPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        txtCompleteAddress = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        searchPanelInstitution = new com.vg.scfc.financing.cis.ui.panel.SearchPanelInstitution();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelCompanyInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 670, -1));
        add(addEditCompanyInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 300, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(panelRepresentative1PersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));
        jPanel3.add(addEditRepresentative1PersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 200, -1, -1));

        jTabbedPane2.addTab("Personal Information", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(addEditRepresentative1Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        jPanel4.add(panelRepresentative1Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.addTab("Employment Data", jPanel4);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 310));

        jTabbedPane1.addTab("1st Representative", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(panelRepresentative2PersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel5.add(addEditRepresentative2PersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 200, -1, -1));

        jTabbedPane3.addTab("Personal Information", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(addEditRepresentative2Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        jPanel6.add(panelRepresentative2Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane3.addTab("Employment Data", jPanel6);

        jPanel2.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1035, 310));

        jTabbedPane1.addTab("2nd Representative", jPanel2);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(ridersToBuyerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnAgree.setText("Agree");
        btnAgree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreeActionPerformed(evt);
            }
        });
        jPanel7.add(btnAgree, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 245, 130, -1));

        jTabbedPane1.addTab("RIDERS TO BUYERS", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(addEditPurchaseOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));
        jPanel8.add(panelPurchaseOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 830, 250));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel8.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 90, -1));

        jTabbedPane1.addTab("Purchase Order", jPanel8);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 1050, 350));
        add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Company Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 95, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Complete Address");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 120, -1, -1));

        txtCompanyName.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtCompanyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompanyNameFocusLost(evt);
            }
        });
        add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 90, 535, -1));

        txtCompleteAddress.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        add(txtCompleteAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 115, 535, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 143, 1070, 10));
        add(searchPanelInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 85, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreeActionPerformed
        boolean isSaved = ridersToBuyerPanel.saveAgreement();
        if (isSaved) {
            UIValidator.promptSucessMessageFor("SAVE");
        } else {
            UIValidator.promptErrorMessageOn("SAVE");
        }
    }//GEN-LAST:event_btnAgreeActionPerformed

    private void txtCompanyNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyNameFocusLost
        txtCompanyName.setText(txtCompanyName.getText().toUpperCase());
    }//GEN-LAST:event_txtCompanyNameFocusLost

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new WaitSplashScreen(null, true, this, "PURCHASE ORDER").getThisDlg();
    }//GEN-LAST:event_btnPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCompanyInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditPurchaseOrder;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative1Employment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative1PersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative2Employment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative2PersonalInfo;
    private javax.swing.JButton btnAgree;
    private javax.swing.JButton btnPrint;
    private com.vg.scfc.financing.cis.ui.reusable.HeaderPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private com.vg.scfc.financing.cis.ui.panel.CompanyInformationPanel panelCompanyInformation;
    private com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2 panelPurchaseOrder;
    private com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel panelRepresentative1Employment;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelRepresentative1PersonalInformation;
    private com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel panelRepresentative2Employment;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelRepresentative2PersonalInformation;
    private com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel ridersToBuyerPanel;
    private com.vg.scfc.financing.cis.ui.panel.SearchPanelInstitution searchPanelInstitution;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtCompleteAddress;
    // End of variables declaration//GEN-END:variables
    private Address companyAddress;

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
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
                if (txtCompanyName.isFocusOwner()) {
                txtCompleteAddress.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtCompleteAddress.isFocusOwner()) {
                txtCompanyName.requestFocus();
            }
                break;
            case KeyEvent.VK_F5:
                if (txtCompleteAddress.isFocusOwner()) {
                AddressDialog addressDialog = new AddressDialog(null, true);
                UIMgr.centerToScreen(addressDialog);
                addressDialog.setVisible(true);
                setCompanyAddress(addressDialog.getAddress());
                txtCompleteAddress.setText(companyAddress.getAddress() + ", " + companyAddress.getBrgyDesc());
            }
                break;
        }
    }

    public void fillValue(String companyName, Address address) {
        txtCompanyName.setText(companyName);
        if (address != null) {
            txtCompleteAddress.setText(address.getAddress() + ", " + address.getBrgyDesc());
            setCompanyAddress(address);
        } else {
            txtCompleteAddress.setText("");
        }
    }

    @Override
    public JasperPrint printNow() throws Exception {
        JasperPrint result = ReportController.getInstance().printPurchaseOrder(headerPanel.getFormNo());
        if (result == null) {
            throw new Exception();
        } else {
            return result;
        }
    }
}
