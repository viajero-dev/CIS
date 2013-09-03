/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.panel;

import com.vg.commons.dlg.WaitSplashScreen;
import com.vg.commons.listener.DoJasperPrintReport;
import com.vg.commons.renderer.IndexedFocusTraversalPolicy;
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
import com.vg.scfc.financing.cis.ui.controller.FormController;
import com.vg.scfc.financing.cis.ui.controller.IdentificationController;
import com.vg.scfc.financing.cis.ui.controller.PersonalInfoController;
import com.vg.scfc.financing.cis.ui.controller.PurchaseOrderController;
import com.vg.scfc.financing.cis.ui.controller.ReportController;
import com.vg.scfc.financing.cis.ui.controller.SearchController;
import com.vg.scfc.financing.cis.ui.dialog.AddressDialog;
import com.vg.scfc.financing.cis.ui.dialog.ApplicationFormDlg;
import com.vg.scfc.financing.cis.ui.listener.BasicActionListener;
import com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.ProcessValidator;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
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

    public IndexedFocusTraversalPolicy getPolicy() {
        IndexedFocusTraversalPolicy policy = UISetting.policy;

        return policy;
    }

    private void initCompanyInfoAddEditListener() {
        panelCompanyInformation.setHeaderPanel(headerPanel);
        panelCompanyInformation.setTxtCompanyName(txtCompanyName);
        panelCompanyInformation.setInstitutionalPanel(this);
        panelCompanyInformation.setButtonPanel(addEditCompanyInfo);
        addEditCompanyInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                resetToDefault();
                ApplicationFormDlg form = new ApplicationFormDlg(null, true);
                UIMgr.centerToScreen(form);
                do {
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
                    managedTab("tabCompany");
                    searchPanelInstitution.enableSearch(false);
                } while (form.getFormSeries().trim().equals("") || form.getFormSeries().trim().equals("00000"));
            }

            @Override
            public boolean onSaveAdd() {
                panelCompanyInformation.setAddress(companyAddress);
                int isSaved = panelCompanyInformation.saveCompanyInformation();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCompanyInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelCompanyInformation.setCompany(panelCompanyInformation.getCompany());
                fillValue(FormController.getInstance().findByFormNo(headerPanel.getFormNo()));
                panelCompanyInformation.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }

            @Override
            public void onEdit() {
                if(panelCompanyInformation.getCompany() == null) {
                    addEditCompanyInfo.resetActionStateToDefault();
                    return;
                }
                panelCompanyInformation.setHeaderPanel(headerPanel);
                panelCompanyInformation.setTxtCompanyName(txtCompanyName);
                panelCompanyInformation.setFieldsEditable(true);
                managedTab("tabCompany");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelCompanyInformation.updateCompanyInformation();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                }
                if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCompanyInformation.setFieldsEditable(false);
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelCompanyInformation.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
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
                managedTab("tabR1PersonalInfo");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelRepresentative1PersonalInformation.saveRepresentativePersonalInfo();
                if (isSaved == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative1PersonalInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative1PersonalInformation.resetToDefault();
                panelRepresentative1PersonalInformation.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelRepresentative1PersonalInformation.setFieldsEditable(true);
                managedTab("tabR1PersonalInfo");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelRepresentative1PersonalInformation.updateRepresentativePersonalInfo();
                if (isUpdated == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelRepresentative1PersonalInformation.setFieldsEditable(false);
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative1PersonalInformation.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }
        });
    }

    private void initRepresentative1EmploymentAddEditListener() {
        panelRepresentative1Employment.setHeaderPanel(headerPanel);
        panelRepresentative1Employment.setPersonType("RP1");
        panelRepresentative1Employment.setButtonPanel(addEditRepresentative1Employment);
        addEditRepresentative1Employment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative1Employment.setFieldsEditable(true);
                panelRepresentative1Employment.resetToDefault();
                managedTab("tabR1Employment");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelRepresentative1Employment.saveEmployment();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative1Employment.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative1Employment.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }

            @Override
            public void onEdit() {
                if(panelRepresentative1Employment.getRepresentativeEmployment() == null) {
                    addEditRepresentative1Employment.resetActionStateToDefault();
                    return;
                }
                panelRepresentative1Employment.setFieldsEditable(true);
                managedTab("tabR1Employment");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelRepresentative1Employment.updateEmployment();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelRepresentative1Employment.setFieldsEditable(false);
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative1Employment.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
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
                managedTab("tabR2PersonalInfo");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelRepresentative2PersonalInformation.saveRepresentativePersonalInfo();
                if (isSaved == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative2PersonalInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative2PersonalInformation.resetToDefault();
                panelRepresentative2PersonalInformation.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelRepresentative2PersonalInformation.setFieldsEditable(true);
                managedTab("tabR2PersonalInfo");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelRepresentative2PersonalInformation.updateRepresentativePersonalInfo();
                if (isUpdated == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative2PersonalInformation.setFieldsEditable(false);
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative2PersonalInformation.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }
        });
    }

    private void initRepresentative2EmploymentAddEditListener() {
        panelRepresentative2Employment.setHeaderPanel(headerPanel);
        panelRepresentative2Employment.setPersonType("RP2");
        panelRepresentative2Employment.setButtonPanel(addEditRepresentative2Employment);
        addEditRepresentative2Employment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative2Employment.setFieldsEditable(true);
                panelRepresentative2Employment.resetToDefault();
                managedTab("tabR2Employment");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelRepresentative2Employment.saveEmployment();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRepresentative2Employment.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelRepresentative2Employment.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }

            @Override
            public void onEdit() {
                if(panelRepresentative2Employment.getRepresentativeEmployment() == null) {
                    addEditRepresentative2Employment.resetActionStateToDefault();
                    return;
                }
                panelRepresentative2Employment.setFieldsEditable(true);
                managedTab("tabR2Employment");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelRepresentative2Employment.updateEmployment();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelRepresentative2Employment.setFieldsEditable(false);
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative2Employment.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }
        });
    }

    private void initPurchaseOrderAddEditListener() {
        panelPurchaseOrder.setHeaderPanel(headerPanel);
        panelPurchaseOrder.setButtonPanel(addEditPurchaseOrder);
        addEditPurchaseOrder.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelPurchaseOrder.setFieldsEditable(true);
                panelPurchaseOrder.resetToDefault();
                managedTab("tabPO");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelPurchaseOrder.savePurchaseOrder();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelPurchaseOrder.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelPurchaseOrder.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }

            @Override
            public void onEdit() {
                if(panelPurchaseOrder.getPurchaseOrder() == null) {
                    addEditPurchaseOrder.resetActionStateToDefault();
                    return;
                }
                panelPurchaseOrder.setFieldsEditable(true);
                managedTab("tabPO");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelPurchaseOrder.updatePurchaseOrder();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                }
                if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelPurchaseOrder.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelPurchaseOrder.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }
        });
    }

    private void initRidersToBuyer() {
        ridersToBuyerPanel.setHeaderPanel(headerPanel);
        ridersToBuyerPanel.setPersonType("APP");
        ridersToBuyerPanel.setButtonPanel(addEditID);
        addEditID.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                ridersToBuyerPanel.setFieldsEditable(true);
                ridersToBuyerPanel.resetToDefault();
                managedTab("tabID");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = ridersToBuyerPanel.saveAgreement();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    ridersToBuyerPanel.setFieldsEditable(false);
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                ridersToBuyerPanel.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }

            @Override
            public void onEdit() {
                if(ridersToBuyerPanel.getIdentification() == null) {
                    addEditID.resetActionStateToDefault();
                    return;
                }
                ridersToBuyerPanel.setFieldsEditable(true);
                managedTab("tabID");
                searchPanelInstitution.enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = ridersToBuyerPanel.updateAgreement();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    ridersToBuyerPanel.setFieldsEditable(false);
                    searchPanelInstitution.enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                ridersToBuyerPanel.setFieldsEditable(false);
                enableTabs();
                searchPanelInstitution.enableSearch(true);
            }
        });
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
            panelRepresentative1PersonalInformation.setClientNo(SearchController.getInstance().findByFormNo(form.getFormNo()).getClientNo());
            panelRepresentative1PersonalInformation.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "RP1"));
            panelRepresentative2PersonalInformation.setClientNo(SearchController.getInstance().findByFormNo(form.getFormNo()).getClientNo());
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
            Identification i = IdentificationController.getInstance().findByFormNo(form.getTxFormNo());
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

    private void managedTab(String tabName) {
        List<JPanel> panels = new ArrayList<>();
        panels.add(tabID);
        panels.add(tabPO);
        panels.add(tabR1Employment);
        panels.add(tabR1PersonalInfo);
        panels.add(tabR2Employment);
        panels.add(tabR2PersonalInfo);
        panels.add(tabCompany);
        tabDetail.setEnabled(false);
        tabR1Detail.setEnabled(false);
        tabR2Detail.setEnabled(false);

        UIValidator.manageTab(panels, tabName);
    }

    private void enableTabs() {
        List<JPanel> panels = new ArrayList<>();
        panels.add(tabID);
        panels.add(tabPO);
        panels.add(tabR1Employment);
        panels.add(tabR1PersonalInfo);
        panels.add(tabR2Employment);
        panels.add(tabR2PersonalInfo);
        panels.add(tabCompany);
        tabDetail.setEnabled(true);
        tabR1Detail.setEnabled(true);
        tabR2Detail.setEnabled(true);

        UIValidator.enableTabs(panels);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabDetail = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tabR1Detail = new javax.swing.JTabbedPane();
        tabR1PersonalInfo = new javax.swing.JPanel();
        panelRepresentative1PersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditRepresentative1PersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabR1Employment = new javax.swing.JPanel();
        addEditRepresentative1Employment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelRepresentative1Employment = new com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel();
        jPanel2 = new javax.swing.JPanel();
        tabR2Detail = new javax.swing.JTabbedPane();
        tabR2PersonalInfo = new javax.swing.JPanel();
        panelRepresentative2PersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditRepresentative2PersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabR2Employment = new javax.swing.JPanel();
        addEditRepresentative2Employment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelRepresentative2Employment = new com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel();
        tabID = new javax.swing.JPanel();
        ridersToBuyerPanel = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        addEditID = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabPO = new javax.swing.JPanel();
        addEditPurchaseOrder = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelPurchaseOrder = new com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2();
        btnPrint = new javax.swing.JButton();
        headerPanel = new com.vg.scfc.financing.cis.ui.reusable.HeaderPanel();
        searchPanelInstitution = new com.vg.scfc.financing.cis.ui.panel.SearchPanelInstitution();
        tabCompany = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        txtCompleteAddress = new javax.swing.JTextField();
        panelCompanyInformation = new com.vg.scfc.financing.cis.ui.panel.CompanyInformationPanel();
        addEditCompanyInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabDetail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabR1Detail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tabR1PersonalInfo.setName("tabR1PersonalInfo"); // NOI18N
        tabR1PersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabR1PersonalInfo.add(panelRepresentative1PersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));
        tabR1PersonalInfo.add(addEditRepresentative1PersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 200, -1, -1));

        tabR1Detail.addTab("Personal Information", tabR1PersonalInfo);

        tabR1Employment.setName("tabR1Employment"); // NOI18N
        tabR1Employment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabR1Employment.add(addEditRepresentative1Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        tabR1Employment.add(panelRepresentative1Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabR1Detail.addTab("Employment Data", tabR1Employment);

        jPanel1.add(tabR1Detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 310));

        tabDetail.addTab("1st Representative", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabR2PersonalInfo.setName("tabR2PersonalInfo"); // NOI18N
        tabR2PersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabR2PersonalInfo.add(panelRepresentative2PersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        tabR2PersonalInfo.add(addEditRepresentative2PersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 200, -1, -1));

        tabR2Detail.addTab("Personal Information", tabR2PersonalInfo);

        tabR2Employment.setName("tabR2Employment"); // NOI18N
        tabR2Employment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabR2Employment.add(addEditRepresentative2Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        tabR2Employment.add(panelRepresentative2Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabR2Detail.addTab("Employment Data", tabR2Employment);

        jPanel2.add(tabR2Detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1035, 310));

        tabDetail.addTab("2nd Representative", jPanel2);

        tabID.setName("tabID"); // NOI18N
        tabID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabID.add(ridersToBuyerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, -1, -1));
        tabID.add(addEditID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        tabDetail.addTab("RIDERS TO BUYERS", tabID);

        tabPO.setName("tabPO"); // NOI18N
        tabPO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabPO.add(addEditPurchaseOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));
        tabPO.add(panelPurchaseOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 830, 250));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        tabPO.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 90, -1));

        tabDetail.addTab("Purchase Order", tabPO);

        add(tabDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 1050, 350));
        add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));
        add(searchPanelInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 85, -1, -1));

        tabCompany.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabCompany.setName("tabCompany"); // NOI18N
        tabCompany.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Company Name");
        tabCompany.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Complete Address");
        tabCompany.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        txtCompanyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompanyNameFocusLost(evt);
            }
        });
        tabCompany.add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 5, 535, -1));
        tabCompany.add(txtCompleteAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 35, 535, -1));
        tabCompany.add(panelCompanyInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, 670, -1));
        tabCompany.add(addEditCompanyInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, -1, -1));
        tabCompany.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1070, 10));

        add(tabCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 95, 1050, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCompanyNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyNameFocusLost
        txtCompanyName.setText(txtCompanyName.getText().toUpperCase());
    }//GEN-LAST:event_txtCompanyNameFocusLost

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new WaitSplashScreen(null, true, this, "PURCHASE ORDER").getThisDlg();
    }//GEN-LAST:event_btnPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCompanyInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditID;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditPurchaseOrder;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative1Employment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative1PersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative2Employment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative2PersonalInfo;
    private javax.swing.JButton btnPrint;
    private com.vg.scfc.financing.cis.ui.reusable.HeaderPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private com.vg.scfc.financing.cis.ui.panel.CompanyInformationPanel panelCompanyInformation;
    private com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2 panelPurchaseOrder;
    private com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel panelRepresentative1Employment;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelRepresentative1PersonalInformation;
    private com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel panelRepresentative2Employment;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelRepresentative2PersonalInformation;
    private com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel ridersToBuyerPanel;
    private com.vg.scfc.financing.cis.ui.panel.SearchPanelInstitution searchPanelInstitution;
    private javax.swing.JPanel tabCompany;
    private javax.swing.JTabbedPane tabDetail;
    private javax.swing.JPanel tabID;
    private javax.swing.JPanel tabPO;
    private javax.swing.JTabbedPane tabR1Detail;
    private javax.swing.JPanel tabR1Employment;
    private javax.swing.JPanel tabR1PersonalInfo;
    private javax.swing.JTabbedPane tabR2Detail;
    private javax.swing.JPanel tabR2Employment;
    private javax.swing.JPanel tabR2PersonalInfo;
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
