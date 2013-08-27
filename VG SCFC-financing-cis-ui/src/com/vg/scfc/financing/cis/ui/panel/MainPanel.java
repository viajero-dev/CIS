/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.panel;

import com.vg.commons.dlg.WaitSplashScreen;
import com.vg.commons.listener.DoJasperPrintReport;
import com.vg.commons.util.NumberUtils;
import com.vg.commons.util.UIMgr;
import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.PersonalInfo;
import com.vg.scfc.financing.cis.ent.PurchaseOrder;
import com.vg.scfc.financing.cis.ent.SourceOfIncome;
import com.vg.scfc.financing.cis.ent.TransactionForm;
import com.vg.scfc.financing.cis.ui.controller.AddressController;
import com.vg.scfc.financing.cis.ui.controller.ApplianceAssetsController;
import com.vg.scfc.financing.cis.ui.controller.CharacterReferenceDependentController;
import com.vg.scfc.financing.cis.ui.controller.CreditReferenceController;
import com.vg.scfc.financing.cis.ui.controller.EmploymentController;
import com.vg.scfc.financing.cis.ui.controller.ExpenditureController;
import com.vg.scfc.financing.cis.ui.controller.FamilyBackgroundController;
import com.vg.scfc.financing.cis.ui.controller.LandAssetController;
import com.vg.scfc.financing.cis.ui.controller.MachineryAssetsController;
import com.vg.scfc.financing.cis.ui.controller.PersonalInfoController;
import com.vg.scfc.financing.cis.ui.controller.PhotoController;
import com.vg.scfc.financing.cis.ui.controller.PurchaseOrderController;
import com.vg.scfc.financing.cis.ui.controller.ReportController;
import com.vg.scfc.financing.cis.ui.controller.RidersToBuyerController;
import com.vg.scfc.financing.cis.ui.controller.SearchController;
import com.vg.scfc.financing.cis.ui.controller.SiblingController;
import com.vg.scfc.financing.cis.ui.controller.SourceOfIncomeController;
import com.vg.scfc.financing.cis.ui.controller.VehicleAssetsController;
import com.vg.scfc.financing.cis.ui.dialog.ApplicationFormDlg;
import com.vg.scfc.financing.cis.ui.listener.AddEditChangeListener;
import com.vg.scfc.financing.cis.ui.listener.BasicActionListener;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperPrint;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class MainPanel extends javax.swing.JPanel implements DoJasperPrintReport{

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        /* Listeners */
        initComponents();
        initPersonalInfoAddEditListener();
        initFields();
        initEmploymentDataAddEditListener();
        initFamilyBackgroundAddEditListener();
        initSiblingAddEditListener();
        initCharacterReferenceAddEditListener();
        initDependentsAddEditListener();
        initCreditReferenceAddEditListener();
        initSourceOfIncomeAddEditListener();
        initExpendituresAddEditListener();
        initLandAssetsAddEditListener();
        initVehicleAssetsAddEditListener();
        initApplianceAssetsAddEditListener();
        initMachineryAssetsAddEditListener();
        initSpousePersonalInfoAddEditListener();
        initSpouseEmploymentAddEditListener();
        initSpouseFamilyBackgroundAddEditListener();
        initCoMakerPersonalInfoAddEditListener();
        initCoMakerEmploymentAddEditListener();
        initCoMakerFamilyBackgroundAddEditListener();
        initCoMakerSourceOfIncomeAddEditListener();
        initCoMakerSpousePersonalInfoAddEditListener();
        initCoMakerSpouseEmploymentAddEditListener();
        initCoMakerSpouseFamilyBackgroundAddEditListener();
        initAddressAddEditChangeListener();
        initSpouseAddressAddEditChangeListener();
        initCoMakerAddressAddEditChangeListener();
        initCoMakerSpouseAddressAddEditChangeListener();
        initPurchaseOrderAddEditListener();
        initIdentification();
        initCoMakerTable();
        initTabs();
    }

    private void initTabs() {
        jTabbedPane1.putClientProperty("Quaqua.TabbedPane.shortenTabs", Boolean.FALSE);
    }

    private void initFields() {
        searchPanel.setMainPanel(this);
        
        panelPersonalInfo.setFieldsEditable(false);
        panelEmploymentData.setFieldsEditable(false);
        panelFamilyBackground.setFieldsEditable(false);
        panelSibling.setFieldsEditable(false);
        panelCharacterReference.setFieldsEditable(false);
        panelDependents.setFieldsEditable(false);
        panelCreditReference.setFieldsEditable(false);
        panelSourceOfIncome.setFieldsEditable(false);
        panelExpenditures.setFieldsEditable(false);
        panelLandAssets.setFieldsEditable(false);
        panelVehicle.setFieldsEditable(false);
        panelAppliance.setFieldsEditable(false);
        panelMachinery.setFieldsEditable(false);
        panelAddress.setFieldsEditable(false);
        panelPO.setFieldsEditable(false);

        panelSpousePersonalInfo.setFieldsEditable(false);
        panelSpouseEmployment.setFieldsEditable(false);
        panelSpouseFamilyBackground.setFieldsEditable(false);

        panelCoMakerPersonalInformation.setFieldsEditable(false);
        panelCoMakerEmploymentData.setFieldsEditable(false);
        panelCoMakerFamilyBackground.setFieldsEditable(false);
        panelCoMakerSourceOfIncome.setFieldsEditable(false);
    }

    private void initPersonalInfoAddEditListener() {
        panelPersonalInfo.setHeaderPanel(headerPanel);
        panelPersonalInfo.setPersonType("APP");
        addEditPersonalInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                resetFields();
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
                headerPanel.enableFields(false);
                panelPersonalInfo.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelPersonalInfo.savePersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelPersonalInfo.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelPersonalInfo.setFieldsEditable(false);
                searchPanel.refresh();
            }

            @Override
            public void onEdit() {
                panelPersonalInfo.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelPersonalInfo.updatePersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelPersonalInfo.setFieldsEditable(false);
                }
                return true;
            }

            @Override
            public void onCancelEdit() {
                panelPersonalInfo.setFieldsEditable(false);
            }
        });
    }

    private void initEmploymentDataAddEditListener() {
        panelEmploymentData.setHeaderPanel(headerPanel);
        panelEmploymentData.setPersonType("APP");
        addEditEmployment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelEmploymentData.setFieldsEditable(true);
                panelEmploymentData.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelEmploymentData.saveEmploymentData();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelEmploymentData.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelEmploymentData.setFieldsEditable(false);
                panelEmploymentData.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelEmploymentData.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelEmploymentData.updateEmploymentData();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelEmploymentData.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelEmploymentData.setFieldsEditable(false);
            }
        });
    }

    private void initFamilyBackgroundAddEditListener() {
        panelFamilyBackground.setHeaderPanel(headerPanel);
        panelFamilyBackground.setPersonType("APP");
        addEditFamily.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelFamilyBackground.setFieldsEditable(true);
                panelFamilyBackground.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelFamilyBackground.saveFamilyBackground();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelFamilyBackground.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelFamilyBackground.setFieldsEditable(false);
                panelFamilyBackground.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelFamilyBackground.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelFamilyBackground.updateFamilyBackground();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelFamilyBackground.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelFamilyBackground.setFieldsEditable(false);
            }
        });
    }

    private void initSiblingAddEditListener() {
        panelSibling.setHeaderPanel(headerPanel);
        addEditSibling.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelSibling.setFieldsEditable(true);
                panelSibling.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelSibling.saveSibling();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSibling.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelSibling.setFieldsEditable(false);
                panelSibling.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelSibling.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelSibling.updateSibling();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSibling.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelSibling.setFieldsEditable(false);
            }
        });
    }

    private void initCharacterReferenceAddEditListener() {
        panelCharacterReference.setHeaderPanel(headerPanel);
        addEditCharacterReference.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCharacterReference.setFieldsEditable(true);
                panelCharacterReference.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCharacterReference.saveCharacterReference();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCharacterReference.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCharacterReference.setFieldsEditable(false);
                panelCharacterReference.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCharacterReference.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCharacterReference.updateCharacterReference();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCharacterReference.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCharacterReference.setFieldsEditable(false);
            }
        });
    }

    private void initDependentsAddEditListener() {
        panelDependents.setHeaderPanel(headerPanel);
        addEditDependents.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelDependents.setFieldsEditable(true);
                panelDependents.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelDependents.saveDependent();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelDependents.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelDependents.setFieldsEditable(false);
                panelDependents.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelDependents.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelDependents.updateDependent();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelDependents.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelDependents.setFieldsEditable(false);
            }
        });
    }

    private void initCreditReferenceAddEditListener() {
        panelCreditReference.setHeaderPanel(headerPanel);
        addEditCreditReference.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCreditReference.setFieldsEditable(true);
                panelCreditReference.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCreditReference.saveCreditReference();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCreditReference.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCreditReference.setFieldsEditable(false);
                panelCreditReference.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCreditReference.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCreditReference.updateCreditReference();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCreditReference.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCreditReference.setFieldsEditable(false);
            }
        });
    }

    private void initSourceOfIncomeAddEditListener() {
        panelSourceOfIncome.setHeaderPanel(headerPanel);
        panelSourceOfIncome.setPersonType("APP");
        panelSourceOfIncome.setTxtTotalMonthlyIncome(txtTotalMonthlyIncome);
        addEditSourceOfInc.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelSourceOfIncome.setFieldsEditable(true);
                panelSourceOfIncome.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelSourceOfIncome.saveSourceOfIncome();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSourceOfIncome.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelSourceOfIncome.setFieldsEditable(false);
                panelSourceOfIncome.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelSourceOfIncome.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelSourceOfIncome.updateSourceOfIncome();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSourceOfIncome.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelSourceOfIncome.setFieldsEditable(false);
            }
        });
    }

    private void initExpendituresAddEditListener() {
        panelExpenditures.setHeaderPanel(headerPanel);
        panelExpenditures.setTotalMonthlyIncome(totalMonthlyIncome);
        addEditExpenditures.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelExpenditures.setFieldsEditable(true);
                panelExpenditures.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelExpenditures.saveExpenditures();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelExpenditures.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelExpenditures.setFieldsEditable(false);
                panelExpenditures.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelExpenditures.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelExpenditures.updateExpenditures();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelExpenditures.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelExpenditures.setFieldsEditable(false);
            }
        });
    }

    private void initLandAssetsAddEditListener() {
        panelLandAssets.setHeaderPanel(headerPanel);
        addEditLandAssets.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelLandAssets.setFieldsEditable(true);
                panelLandAssets.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelLandAssets.saveLandAssets();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelLandAssets.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelLandAssets.setFieldsEditable(false);
                panelLandAssets.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelLandAssets.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelLandAssets.updateLandAssets();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelLandAssets.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelLandAssets.setFieldsEditable(false);
            }
        });
    }

    private void initVehicleAssetsAddEditListener() {
        panelVehicle.setHeaderPanel(headerPanel);
        addEditVehicle.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelVehicle.setFieldsEditable(true);
                panelVehicle.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelVehicle.saveVehicleAsset();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelVehicle.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelVehicle.setFieldsEditable(false);
                panelVehicle.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelVehicle.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelVehicle.updateVehicleAsset();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelVehicle.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelVehicle.setFieldsEditable(false);
            }
        });
    }

    private void initApplianceAssetsAddEditListener() {
        panelAppliance.setHeaderPanel(headerPanel);
        addEditAppliance.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelAppliance.setFieldsEditable(true);
                panelAppliance.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelAppliance.saveApplianceAsset();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelAppliance.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelAppliance.setFieldsEditable(false);
                panelAppliance.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelAppliance.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelAppliance.updateApplianceAsset();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelAppliance.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelAppliance.setFieldsEditable(false);
            }
        });
    }

    private void initMachineryAssetsAddEditListener() {
        panelMachinery.setHeaderPanel(headerPanel);
        addEditMachinery.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelMachinery.setFieldsEditable(true);
                panelMachinery.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelMachinery.saveMachinery();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelMachinery.setFieldsEditable(false);
                panelMachinery.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelMachinery.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelMachinery.updateMachinery();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelMachinery.setFieldsEditable(false);
            }
        });
    }

    /* Spouse Information */
    private void initSpousePersonalInfoAddEditListener() {
        panelSpousePersonalInfo.setHeaderPanel(headerPanel);
        panelSpousePersonalInfo.setPersonType("SPO");

        addEditSpousePersonalInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelSpousePersonalInfo.setFieldsEditable(true);
                panelSpousePersonalInfo.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelSpousePersonalInfo.saveSpousePersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpousePersonalInfo.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelSpousePersonalInfo.resetToDefault();
                panelSpousePersonalInfo.setFieldsEditable(false);
            }

            @Override
            public void onEdit() {
                panelSpousePersonalInfo.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelSpousePersonalInfo.updateSpousePersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpousePersonalInfo.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelSpousePersonalInfo.setFieldsEditable(false);
            }
        });
    }

    private void initSpouseEmploymentAddEditListener() {
        panelSpouseEmployment.setHeaderPanel(headerPanel);
        panelSpouseEmployment.setPersonType("SPO");
        addEditSpouseEmployment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelSpouseEmployment.setFieldsEditable(true);
                panelSpouseEmployment.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelSpouseEmployment.saveEmploymentData();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpouseEmployment.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelSpouseEmployment.setFieldsEditable(false);
//                panelSpouseEmployment.setEmploymentData(o);                
                panelSpouseEmployment.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelSpouseEmployment.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelSpouseEmployment.updateEmploymentData();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpouseEmployment.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelSpouseEmployment.setFieldsEditable(false);
            }
        });
    }

    private void initSpouseFamilyBackgroundAddEditListener() {
        panelSpouseFamilyBackground.setHeaderPanel(headerPanel);
        panelSpouseFamilyBackground.setPersonType("SPO");
        addEditSpouseFamilyBackground.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelSpouseFamilyBackground.setFieldsEditable(true);
                panelSpouseFamilyBackground.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelSpouseFamilyBackground.saveFamilyBackground();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpouseFamilyBackground.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelSpouseFamilyBackground.setFieldsEditable(false);
//                panelSpouseFamilyBackground.setFamilyBackground(null);
                panelSpouseFamilyBackground.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelSpouseFamilyBackground.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelSpouseFamilyBackground.updateFamilyBackground();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpouseFamilyBackground.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelSpouseFamilyBackground.setFieldsEditable(false);
            }
        });
    }

    /* Co Maker Information */
    private void initCoMakerPersonalInfoAddEditListener() {
        panelCoMakerPersonalInformation.setHeaderPanel(headerPanel);

        panelCoMakerPersonalInformation.setMainPanel(this);
        addEditCoMakerPersonalInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCoMakerPersonalInformation.setFieldsEditable(true);
                panelCoMakerPersonalInformation.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerPersonalInformation.saveCoMakerPersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerPersonalInformation.setFieldsEditable(false);
                    refreshComakerTable(PersonalInfoController.getInstance().findCoMakersByFormNo(headerPanel.getFormNo()));
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerPersonalInformation.resetToDefault();
                panelCoMakerPersonalInformation.setFieldsEditable(false);
            }

            @Override
            public void onEdit() {
                panelCoMakerPersonalInformation.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerPersonalInformation.updateCoMakerPersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerPersonalInformation.setFieldsEditable(false);
                    refreshComakerTable(PersonalInfoController.getInstance().findCoMakersByFormNo(headerPanel.getFormNo()));
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerPersonalInformation.setFieldsEditable(false);
            }
        });
    }

    private void initCoMakerEmploymentAddEditListener() {
        panelCoMakerEmploymentData.setHeaderPanel(headerPanel);
        panelCoMakerEmploymentData.setMainPanel(this);
        addEditCoMakerEmployment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCoMakerEmploymentData.setFieldsEditable(true);
                panelCoMakerEmploymentData.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerEmploymentData.saveCoMakerEmploymentData();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerEmploymentData.setFieldsEditable(false);
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerEmploymentData.setFieldsEditable(false);
//                panelEmploymentData.setEmploymentData(o);                
                panelCoMakerEmploymentData.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCoMakerEmploymentData.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerEmploymentData.updateCoMakerEmploymentData();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerEmploymentData.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerEmploymentData.setFieldsEditable(false);
            }
        });
    }

    private void initCoMakerFamilyBackgroundAddEditListener() {
        panelCoMakerFamilyBackground.setHeaderPanel(headerPanel);
        panelCoMakerFamilyBackground.setMainPanel(this);
        addEditCoMakerFamilyBackground.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCoMakerFamilyBackground.setFieldsEditable(true);
                panelCoMakerFamilyBackground.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerFamilyBackground.saveCoMakerFamilyBackground();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerFamilyBackground.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerFamilyBackground.setFieldsEditable(false);
//                panelCoMakerFamilyBackground.setFamilyBackground(null);
                panelCoMakerFamilyBackground.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCoMakerFamilyBackground.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerFamilyBackground.updateCoMakerFamilyBackground();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerFamilyBackground.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerFamilyBackground.setFieldsEditable(false);
            }
        });
    }

    private void initCoMakerSourceOfIncomeAddEditListener() {
        panelCoMakerSourceOfIncome.setHeaderPanel(headerPanel);
        panelCoMakerSourceOfIncome.setMainPanel(this);
        panelCoMakerSourceOfIncome.setTxtTotalMonthlyIncome(txtTotalMonthlyIncome);
        if (searchPanel.getCustomer() != null) {
            panelCoMakerSourceOfIncome.setClientNo(searchPanel.getCustomer().getClientNo());
        }
        addEditCoMakerSourceOfIncome.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCoMakerSourceOfIncome.setFieldsEditable(true);
                panelCoMakerSourceOfIncome.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerSourceOfIncome.saveCoMakerSourceOfIncome();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerSourceOfIncome.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSourceOfIncome.setFieldsEditable(false);
//                panelCoMakerSourceOfIncome.setSourceOfIncomeData(ui);
                panelCoMakerSourceOfIncome.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCoMakerSourceOfIncome.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSourceOfIncome.updateSourceOfIncome();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSourceOfIncome.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSourceOfIncome.setFieldsEditable(false);
            }
        });
    }

    /* Co Maker Spouse Information */
    private void initCoMakerSpousePersonalInfoAddEditListener() {
        panelCoMakerSpousePersonalInformation.setHeaderPanel(headerPanel);
        if (searchPanel.getCustomer() != null) {
            panelCoMakerSpousePersonalInformation.setClientNo(searchPanel.getCustomer().getClientNo());
        }
        panelCoMakerSpousePersonalInformation.setMainPanel(this);
        addEditCoMakerSpousePersonalInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCoMakerSpousePersonalInformation.setFieldsEditable(true);
                panelCoMakerSpousePersonalInformation.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerSpousePersonalInformation.saveCoMakerSpousePersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpousePersonalInformation.resetToDefault();
                panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
            }

            @Override
            public void onEdit() {
                panelCoMakerSpousePersonalInformation.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSpousePersonalInformation.updateCoMakerSpousePersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
            }
        });
    }

    private void initCoMakerSpouseEmploymentAddEditListener() {
        panelCoMakerSpouseEmploymentData.setHeaderPanel(headerPanel);
        panelCoMakerSpouseEmploymentData.setMainPanel(this);

        addEditCoMakerSpouseEmployment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCoMakerSpouseEmploymentData.setFieldsEditable(true);
                panelCoMakerSpouseEmploymentData.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerSpouseEmploymentData.saveCoMakerSpouseEmploymentData();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerSpouseEmploymentData.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpouseEmploymentData.setFieldsEditable(false);
//                panelCoMakerSpouseEmploymentData.setEmploymentData(o);                
                panelCoMakerSpouseEmploymentData.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCoMakerSpouseEmploymentData.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSpouseEmploymentData.updateCoMakerSpouseEmploymentData();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSpouseEmploymentData.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSpouseEmploymentData.setFieldsEditable(false);
            }
        });
    }

    private void initCoMakerSpouseFamilyBackgroundAddEditListener() {
        panelCoMakerSpouseFamilyBackground.setHeaderPanel(headerPanel);
        panelCoMakerSpouseFamilyBackground.setMainPanel(this);
        addEditCoMakerSpouseFamilyBackground.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCoMakerSpouseFamilyBackground.setFieldsEditable(true);
                panelCoMakerSpouseFamilyBackground.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerSpouseFamilyBackground.saveCoMakerSpouseFamilyBackground();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerSpouseFamilyBackground.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpouseFamilyBackground.setFieldsEditable(false);
//                panelCoMakerSpouseFamilyBackground.setFamilyBackground(null);
                panelCoMakerSpouseFamilyBackground.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCoMakerSpouseFamilyBackground.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSpouseFamilyBackground.updateCoMakerSpouseFamilyBackground();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSpouseFamilyBackground.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSpouseFamilyBackground.setFieldsEditable(false);
            }
        });
    }

    /* Address Information */
    private void initAddressAddEditChangeListener() {
        panelAddress.setHeaderPanel(headerPanel);
        panelAddress.setPersonType("APP");
        addEditChangeAddress.setButtonListener(new AddEditChangeListener() {

            @Override
            public void onAdd() {
                panelAddress.setFieldsEditable(true);
                panelAddress.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelAddress.saveAddress();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelAddress.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onEdit() {
                panelAddress.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelAddress.updateAddress();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelAddress.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onChange() {
                panelAddress.setFieldsEditable(true);
                panelAddress.resetToDefault();
            }

            @Override
            public boolean onSaveChange() {
                boolean isChanged = panelAddress.changeAddress();
                if (!isChanged) {
                    UIValidator.promptErrorMessageOn("SAVE");
                }
                return isChanged;
            }

            @Override
            public void onCancelChange() {
                panelAddress.setFieldsEditable(false);
                // reset ui
            }
        });
    }

    private void initSpouseAddressAddEditChangeListener() {
        panelSpouseAddress.setHeaderPanel(headerPanel);
        panelSpouseAddress.setPersonType("SPO");
        addEditChangeSpouseAddress.setButtonListener(new AddEditChangeListener() {

            @Override
            public void onAdd() {
                panelSpouseAddress.setFieldsEditable(true);
                panelSpouseAddress.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelSpouseAddress.saveAddress();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpouseAddress.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelSpouseAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onEdit() {
                panelSpouseAddress.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelSpouseAddress.updateAddress();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpouseAddress.setFieldsEditable(false);
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelSpouseAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onChange() {
                panelSpouseAddress.setFieldsEditable(true);
                panelSpouseAddress.resetToDefault();
            }

            @Override
            public boolean onSaveChange() {
                boolean isChanged = panelSpouseAddress.changeAddress();
                if (!isChanged) {
                    UIValidator.promptErrorMessageOn("SAVE");
                }
                return isChanged;
            }

            @Override
            public void onCancelChange() {
                panelSpouseAddress.setFieldsEditable(false);
                // reset ui
            }
        });
    }

    private void initCoMakerAddressAddEditChangeListener() {
        panelCoMakerAddress.setHeaderPanel(headerPanel);
        panelCoMakerAddress.setMainPanel(this);
        addEditChangeCoMakerAddress.setButtonListener(new AddEditChangeListener() {

            @Override
            public void onAdd() {
                panelCoMakerAddress.setFieldsEditable(true);
                panelCoMakerAddress.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerAddress.saveCoMakerAddress();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerAddress.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onEdit() {
                panelCoMakerAddress.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerAddress.updateAddress();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onChange() {
                panelCoMakerAddress.setFieldsEditable(true);
                panelCoMakerAddress.resetToDefault();
            }

            @Override
            public boolean onSaveChange() {
                boolean isChanged = panelCoMakerAddress.changeAddress();
                if (!isChanged) {
                    UIValidator.promptErrorMessageOn("SAVE");
                }
                return isChanged;
            }

            @Override
            public void onCancelChange() {
                panelCoMakerAddress.setFieldsEditable(false);
                // reset ui
            }
        });
    }

    private void initCoMakerSpouseAddressAddEditChangeListener() {
        addEditChangeCoMakerSpouseAddress.setButtonListener(new AddEditChangeListener() {

            @Override
            public void onAdd() {
                panelCoMakerSpouseAddress.setFieldsEditable(true);
                panelCoMakerSpouseAddress.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerSpouseAddress.saveAddress();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpouseAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onEdit() {
                panelCoMakerSpouseAddress.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSpouseAddress.updateAddress();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSpouseAddress.setFieldsEditable(false);
                // reset ui
            }

            @Override
            public void onChange() {
                panelCoMakerSpouseAddress.setFieldsEditable(true);
                panelCoMakerSpouseAddress.resetToDefault();
            }

            @Override
            public boolean onSaveChange() {
                boolean isChanged = panelCoMakerSpouseAddress.changeAddress();
                if (!isChanged) {
                    UIValidator.promptErrorMessageOn("SAVE");
                }
                return isChanged;
            }

            @Override
            public void onCancelChange() {
                panelCoMakerSpouseAddress.setFieldsEditable(false);
                // reset ui
            }
        });
    }

    /* Purchase Order  */
    private void initPurchaseOrderAddEditListener() {
        panelPO.setHeaderPanel(headerPanel);
        addEditPO.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelPO.setFieldsEditable(true);
                panelPO.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelPO.savePurchaseOrder();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelPO.setFieldsEditable(false);
                     refreshSearch(headerPanel.getFormNo());
                }
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelPO.setFieldsEditable(false);
//                panelPO.setPurchaseOrder(PurchaseOrderController.getInstance().findByFormNo(form.getTxFormNo()));
            }

            @Override
            public void onEdit() {
                panelPO.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelPO.updatePurchaseOrder();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelPO.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelPO.setFieldsEditable(false);
                // TODO, reset ui
            }
        });
    }

    /* Riders to Buyers */
    private void initIdentification() {
        panelRidersToBuyer.setHeaderPanel(headerPanel);
        panelRidersToBuyer.setPersonType("APP");
        panelSpouseRidersToBuyer.setHeaderPanel(headerPanel);
        panelSpouseRidersToBuyer.setPersonType("SPO");
    }

    private void initCoMakerTable() {
        tableCoMaker.putClientProperty("Quaqua.Table.style", "striped");
        tableCoMaker.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCoMaker.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    selectedIndex = tableCoMaker.getSelectedRow();
                    if (selectedIndex >= 0) {
                        setSelectedCoMaker(comakers.get(selectedIndex));
                        fillCoMakerValues(selectedCoMaker);
                    }
                } catch (Exception e) {
                    UIValidator.log(e, MainPanel.class);
                }
            }
        });
    }

    /* Set all Data by Search */
    public void fillValue(TransactionForm form) {
        if (form != null) {
            headerPanel.setIDNo(form.getFormNo());
            headerPanel.setFormNo(form.getTxFormNo());
            headerPanel.setApplicationDate(form.getTxApplicationDate());
            headerPanel.enableFields(false);
            /* Applicant */
            panelPersonalInfo.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "APP"));
            panelPersonalInfo.setPhoto(PhotoController.getInstance().findByName(form.getTxFormNo() + "_" + "APP"));
            panelEmploymentData.setEmployment(EmploymentController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "APP"));
            panelFamilyBackground.setFamilies(FamilyBackgroundController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "APP"));
            panelSibling.refreshTable(SiblingController.getInstance().findAll(form.getTxFormNo()));
            panelCharacterReference.refreshTableCharacterReference(CharacterReferenceDependentController.getInstance().findCharacterReferencesByFormNo(form.getTxFormNo()));
            panelDependents.refreshTableDependent(CharacterReferenceDependentController.getInstance().findDependentsByFormNo(form.getTxFormNo()));
            panelCreditReference.refreshTable(CreditReferenceController.getInstance().findAll(form.getTxFormNo()));
            SourceOfIncome s = SourceOfIncomeController.getInstance().findByFormNoAndPersonType("", form.getTxFormNo(), "APP");
            txtTotalMonthlyIncome.setText(NumberUtils.doubleToString(SourceOfIncomeController.getInstance().computeTotalMonthlyIncome(s).doubleValue()));
            panelSourceOfIncome.setSourceOfIncome(s);
            panelExpenditures.setSourceOfIncome(s);
            panelExpenditures.setExpenditures(ExpenditureController.getInstance().findByFormNo(form.getTxFormNo()));
            panelLandAssets.setLands(LandAssetController.getInstance().findAllLandAssets(form.getTxFormNo()));
            panelVehicle.refreshTable(VehicleAssetsController.getInstance().findByFormNo(form.getTxFormNo()));
            panelAppliance.refreshTable(ApplianceAssetsController.getInstance().findAll(form.getTxFormNo()));
            panelMachinery.refreshTable(MachineryAssetsController.getInstance().findAll(form.getTxFormNo()));
            panelAddress.refreshTable(AddressController.getInstance().findByFormNo(form.getTxFormNo(), "APP"));
            PurchaseOrder p = PurchaseOrderController.getInstance().findByFormNo(form.getTxFormNo());
            if (p != null) {
                headerPanel.setApplicationStatus(p.getStatus());
                panelPO.setPurchaseOrder(p);
            } else {
                headerPanel.setApplicationStatus("");
                panelPO.setPurchaseOrder(null);
            }
            /* Spouse */
            if (searchPanel.getCustomer() != null) {
                panelSpousePersonalInfo.setClientNo(searchPanel.getCustomer().getClientNo());
            }
            panelSpousePersonalInfo.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "SPO"));
            panelSpouseEmployment.setEmployment(EmploymentController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "SPO"));
            panelSpouseFamilyBackground.setFamilies(FamilyBackgroundController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "SPO"));
            panelSpouseAddress.refreshTable(AddressController.getInstance().findByFormNo(form.getTxFormNo(), "SPO"));
            /* Co Makers */
            if (searchPanel.getCustomer() != null) {
                panelCoMakerPersonalInformation.setClientNo(searchPanel.getCustomer().getClientNo());
            }
            List<PersonalInfo> cmakers = new ArrayList<>();
            PersonalInfo cm1 = PersonalInfoController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "CM1");
            PersonalInfo cm2 = PersonalInfoController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "CM2");
            if (cm1 != null) {
                cmakers.add(cm1);
            }
            if (cm2 != null) {
                cmakers.add(cm2);
            }
            refreshComakerTable(cmakers);
            /* Riders to Buyers */
            panelRidersToBuyer.setIdentification(RidersToBuyerController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "APP"));
            panelSpouseRidersToBuyer.setIdentification(RidersToBuyerController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "SPO"));
        } else {
            headerPanel.setApplicationStatus("");
            headerPanel.setFormNo("");
            headerPanel.setIDNo("");
        }
    }

    public void fillCoMakerValues(PersonalInfo p) {
        panelCoMakerPersonalInformation.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), p.getPersonType().getTypeID()));
        panelCoMakerEmploymentData.setEmployment(EmploymentController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), p.getPersonType().getTypeID()));
        panelCoMakerFamilyBackground.setFamilies(FamilyBackgroundController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), p.getPersonType().getTypeID()));
        panelCoMakerSourceOfIncome.setSourceOfIncome(SourceOfIncomeController.getInstance().findByFormNoAndPersonType(p.getClientNo(), p.getTxFormNo(), p.getPersonType().getTypeID()));
        panelCoMakerAddress.refreshTable(AddressController.getInstance().findByFormNo(p.getTxFormNo(), p.getPersonType().getTypeID()));
        /* Co Maker Spouse */
        switch (p.getPersonType().getTypeID()) {
            case "CM1":
                panelCoMakerSpousePersonalInformation.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), "CS1"));
                panelCoMakerSpouseEmploymentData.setEmployment(EmploymentController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), "CS1"));
                panelCoMakerSpouseFamilyBackground.setFamilies(FamilyBackgroundController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), "CS1"));
                panelCoMakerSpouseAddress.refreshTable(AddressController.getInstance().findByFormNo(p.getTxFormNo(), "CS1"));
                break;
            case "CM2":
                panelCoMakerSpousePersonalInformation.setPersonalInfo(PersonalInfoController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), "CS2"));
                panelCoMakerSpouseEmploymentData.setEmployment(EmploymentController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), "CS2"));
                panelCoMakerSpouseFamilyBackground.setFamilies(FamilyBackgroundController.getInstance().findByFormNoAndPersonType(p.getTxFormNo(), "CS2"));
                panelCoMakerSpouseAddress.refreshTable(AddressController.getInstance().findByFormNo(p.getTxFormNo(), "CS2"));
                break;
        }
    }
    
    public void refreshSearch(String formNo) {
        List<Customer> customers = new ArrayList<>();
        Customer c = SearchController.getInstance().findByFormNo(formNo);
        customers.add(c);
        searchPanel.refreshCustomerTable(customers);
    }

    public void resetFields() {
        headerPanel.enableFields(false);

        panelPersonalInfo.resetToDefault();
        panelEmploymentData.resetToDefault();
        panelFamilyBackground.resetToDefault();
        panelSibling.resetToDefault();
        panelCharacterReference.resetToDefault();
        panelDependents.resetToDefault();
        panelCreditReference.resetToDefault();
        panelSourceOfIncome.resetToDefault();
        panelExpenditures.resetToDefault();
        panelLandAssets.resetToDefault();
        panelVehicle.resetToDefault();
        panelAppliance.resetToDefault();
        panelMachinery.resetToDefault();
        /* Spouse */
        panelSpousePersonalInfo.resetToDefault();
        panelSpouseEmployment.resetToDefault();
        panelSpouseFamilyBackground.resetToDefault();
        /* Co Maker */
        panelCoMakerPersonalInformation.resetToDefault();
        panelCoMakerEmploymentData.resetToDefault();
        panelCoMakerFamilyBackground.resetToDefault();
        panelCoMakerSourceOfIncome.resetToDefault();
        /* Co Maker Spouse */
        panelCoMakerSpousePersonalInformation.resetToDefault();
        panelCoMakerSpouseEmploymentData.resetToDefault();
        panelCoMakerSpouseFamilyBackground.resetToDefault();
        /* Address */
        panelAddress.resetToDefault();
        panelSpouseAddress.resetToDefault();
        panelCoMakerAddress.resetToDefault();
        panelCoMakerSpouseAddress.resetToDefault();
        /* Purchase Order */
        panelPO.resetToDefault();
        /* Riders to Buyers */
        panelRidersToBuyer.resetToDefault();
    }

    public void clearHeader() {
        headerPanel.setFormNo("");
        headerPanel.setApplicationDate(new Date());
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

        comakers = ObservableCollections.observableList(new LinkedList<PersonalInfo>());
        tabMain = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panelPersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panelEmploymentData = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel3 = new javax.swing.JPanel();
        panelFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditFamily = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel4 = new javax.swing.JPanel();
        panelSibling = new com.vg.scfc.financing.cis.ui.reusable.SiblingsPanel();
        addEditSibling = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel5 = new javax.swing.JPanel();
        panelCharacterReference = new com.vg.scfc.financing.cis.ui.reusable.CharacterReferenceDependentPanel();
        addEditCharacterReference = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel6 = new javax.swing.JPanel();
        addEditDependents = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelDependents = new com.vg.scfc.financing.cis.ui.reusable.DependentPanel();
        jPanel7 = new javax.swing.JPanel();
        panelCreditReference = new com.vg.scfc.financing.cis.ui.reusable.CreditReferencePanel();
        addEditCreditReference = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel8 = new javax.swing.JPanel();
        panelSourceOfIncome = new com.vg.scfc.financing.cis.ui.reusable.SourceOfIncomePanel();
        addEditSourceOfInc = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        lblAvgMonthlyIncomeForOtherSources = new javax.swing.JLabel();
        txtTotalMonthlyIncome = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        panelExpenditures = new com.vg.scfc.financing.cis.ui.reusable.ExpendituresPanel();
        addEditExpenditures = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        panelLandAssets = new com.vg.scfc.financing.cis.ui.reusable.LandPanel();
        addEditLandAssets = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel12 = new javax.swing.JPanel();
        panelVehicle = new com.vg.scfc.financing.cis.ui.reusable.VehiclePanel();
        addEditVehicle = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel13 = new javax.swing.JPanel();
        panelAppliance = new com.vg.scfc.financing.cis.ui.reusable.AppliancesPanel();
        addEditAppliance = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel14 = new javax.swing.JPanel();
        panelMachinery = new com.vg.scfc.financing.cis.ui.reusable.MachineryPanel();
        addEditMachinery = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel27 = new javax.swing.JPanel();
        panelAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        tabPO = new javax.swing.JPanel();
        addEditPO = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelPO = new com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2();
        btnPrint = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        panelRidersToBuyer = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        btnAgree1 = new javax.swing.JButton();
        addEditPersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel15 = new javax.swing.JPanel();
        panelSpousePersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        panelSpouseEmployment = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditSpouseEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel17 = new javax.swing.JPanel();
        panelSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel28 = new javax.swing.JPanel();
        panelSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        jPanel31 = new javax.swing.JPanel();
        panelSpouseRidersToBuyer = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        btnAgree2 = new javax.swing.JButton();
        addEditSpousePersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCoMaker = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        panelCoMakerPersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        jPanel20 = new javax.swing.JPanel();
        panelCoMakerEmploymentData = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditCoMakerEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel21 = new javax.swing.JPanel();
        panelCoMakerFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditCoMakerFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel22 = new javax.swing.JPanel();
        panelCoMakerSourceOfIncome = new com.vg.scfc.financing.cis.ui.reusable.SourceOfIncomePanel();
        addEditCoMakerSourceOfIncome = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel23 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        panelCoMakerSpousePersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditCoMakerSpousePersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel25 = new javax.swing.JPanel();
        panelCoMakerSpouseEmploymentData = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditCoMakerSpouseEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel26 = new javax.swing.JPanel();
        panelCoMakerSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditCoMakerSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel30 = new javax.swing.JPanel();
        panelCoMakerSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeCoMakerSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        jPanel29 = new javax.swing.JPanel();
        panelCoMakerAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeCoMakerAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        jPanel33 = new javax.swing.JPanel();
        panelCoMakerRidersToBuyer = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        btnAgree3 = new javax.swing.JButton();
        addEditCoMakerPersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        headerPanel = new com.vg.scfc.financing.cis.ui.reusable.HeaderPanel();
        searchPanel = new com.vg.scfc.financing.cis.ui.panel.SearchPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabMain.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(panelPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, -1, -1));

        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(panelEmploymentData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel2.add(addEditEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        jTabbedPane1.addTab("Employment", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(panelFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel3.add(addEditFamily, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 165, -1, -1));

        jTabbedPane1.addTab("Family", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(panelSibling, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel4.add(addEditSibling, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 185, -1, -1));

        jTabbedPane1.addTab("Siblings", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(panelCharacterReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel5.add(addEditCharacterReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        jTabbedPane1.addTab("Character Reference", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(addEditDependents, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));
        jPanel6.add(panelDependents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 620, -1));

        jTabbedPane1.addTab("Dependents", jPanel6);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(panelCreditReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel7.add(addEditCreditReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 240, -1, -1));

        jTabbedPane1.addTab("Credit Reference", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSourceOfIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel8.add(addEditSourceOfInc, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        lblAvgMonthlyIncomeForOtherSources.setText("Total Monthly Income");
        jPanel8.add(lblAvgMonthlyIncomeForOtherSources, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        txtTotalMonthlyIncome.setEditable(false);
        txtTotalMonthlyIncome.setFocusable(false);
        jPanel8.add(txtTotalMonthlyIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 285, 127, -1));

        jTabbedPane1.addTab("Src. of Income", jPanel8);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(panelExpenditures, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel9.add(addEditExpenditures, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        jTabbedPane1.addTab("Expenditures", jPanel9);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(panelLandAssets, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 970, 150));
        jPanel11.add(addEditLandAssets, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        jTabbedPane2.addTab("Land", jPanel11);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(panelVehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel12.add(addEditVehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        jTabbedPane2.addTab("Vehicle", jPanel12);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.add(panelAppliance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel13.add(addEditAppliance, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        jTabbedPane2.addTab("Appliances", jPanel13);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel14.add(panelMachinery, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel14.add(addEditMachinery, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 235, -1, -1));

        jTabbedPane2.addTab("Machinery", jPanel14);

        jPanel10.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 290));

        jTabbedPane1.addTab("Assets", jPanel10);

        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(panelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        jPanel27.add(addEditChangeAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        jTabbedPane1.addTab("Address", jPanel27);

        tabPO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabPO.add(addEditPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 260, -1, -1));
        tabPO.add(panelPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        tabPO.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 260, 90, -1));

        jTabbedPane1.addTab("Purchase Order", tabPO);

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel32.add(panelRidersToBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnAgree1.setText("Agree");
        btnAgree1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgree1ActionPerformed(evt);
            }
        });
        jPanel32.add(btnAgree1, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 280, 130, -1));

        jTabbedPane1.addTab("Identification", jPanel32);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 1020, 360));
        jPanel1.add(addEditPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, -1, -1));

        tabMain.addTab("Applicant Personal Information", jPanel1);

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel15.add(panelSpousePersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        jTabbedPane3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel16.add(panelSpouseEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel16.add(addEditSpouseEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        jTabbedPane3.addTab("Employment", jPanel16);

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel17.add(panelSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel17.add(addEditSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        jTabbedPane3.addTab("Family", jPanel17);

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(panelSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        jPanel28.add(addEditChangeSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        jTabbedPane3.addTab("Address", jPanel28);

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel31.add(panelSpouseRidersToBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnAgree2.setText("Agree");
        btnAgree2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgree2ActionPerformed(evt);
            }
        });
        jPanel31.add(btnAgree2, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 280, 130, -1));

        jTabbedPane3.addTab("Identification", jPanel31);

        jPanel15.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 1020, 350));
        jPanel15.add(addEditSpousePersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, -1, -1));

        tabMain.addTab("Spouse Information", jPanel15);

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, comakers, tableCoMaker);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${middleName}"));
        columnBinding.setColumnName("Middle Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactNo}"));
        columnBinding.setColumnName("Contact No");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane5.setViewportView(tableCoMaker);

        jPanel18.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 1000, 70));

        jTabbedPane4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel19.add(panelCoMakerPersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 5, -1, -1));

        jTabbedPane4.addTab("Personal Info", jPanel19);

        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel20.add(panelCoMakerEmploymentData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel20.add(addEditCoMakerEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        jTabbedPane4.addTab("Employment", jPanel20);

        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel21.add(panelCoMakerFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel21.add(addEditCoMakerFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 215, -1, -1));

        jTabbedPane4.addTab("Family", jPanel21);

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(panelCoMakerSourceOfIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel22.add(addEditCoMakerSourceOfIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jTabbedPane4.addTab("Source of Income", jPanel22);

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(panelCoMakerSpousePersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(-11, 5, -1, -1));
        jPanel24.add(addEditCoMakerSpousePersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 210, -1, -1));

        jTabbedPane5.addTab("Personal Info", jPanel24);

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel25.add(panelCoMakerSpouseEmploymentData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel25.add(addEditCoMakerSpouseEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jTabbedPane5.addTab("Employment", jPanel25);

        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel26.add(panelCoMakerSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        jPanel26.add(addEditCoMakerSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jTabbedPane5.addTab("Family", jPanel26);

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel30.add(panelCoMakerSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        jPanel30.add(addEditChangeCoMakerSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        jTabbedPane5.addTab("Address", jPanel30);

        jPanel23.add(jTabbedPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 400));

        jTabbedPane4.addTab("Spouse Information", jPanel23);

        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel29.add(panelCoMakerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        jPanel29.add(addEditChangeCoMakerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        jTabbedPane4.addTab("Address", jPanel29);

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel33.add(panelCoMakerRidersToBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnAgree3.setText("Agree");
        btnAgree3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgree3ActionPerformed(evt);
            }
        });
        jPanel33.add(btnAgree3, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 280, 130, -1));

        jTabbedPane4.addTab("Identification", jPanel33);

        jPanel18.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1030, 440));
        jPanel18.add(addEditCoMakerPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, -1, -1));

        tabMain.addTab("Co-Maker", jPanel18);

        add(tabMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 85, 1040, 630));
        add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 0, 1070, -1));
        add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 85, -1, 630));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgree1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgree1ActionPerformed
        boolean isSaved = panelRidersToBuyer.saveAgreement();
        if (isSaved) {
            UIValidator.promptSucessMessageFor("SAVE");
            panelRidersToBuyer.setFieldsEditable(false);
        } else {
            UIValidator.promptErrorMessageOn("SAVE");
        }
    }//GEN-LAST:event_btnAgree1ActionPerformed

    private void btnAgree2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgree2ActionPerformed
        boolean isSaved = panelSpouseRidersToBuyer.saveAgreement();
        if (isSaved) {
            UIValidator.promptSucessMessageFor("SAVE");
            panelSpouseRidersToBuyer.setFieldsEditable(false);
        } else {
            UIValidator.promptErrorMessageOn("SAVE");
        }
    }//GEN-LAST:event_btnAgree2ActionPerformed

    private void btnAgree3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgree3ActionPerformed
        panelCoMakerRidersToBuyer.setHeaderPanel(headerPanel);
        panelCoMakerRidersToBuyer.setPersonType(selectedCoMaker.getPersonType().getTypeID());
        boolean isSaved = panelCoMakerRidersToBuyer.saveAgreement();
        if (isSaved) {
            UIValidator.promptSucessMessageFor("SAVE");
            panelCoMakerRidersToBuyer.setFieldsEditable(false);
        } else {
            UIValidator.promptErrorMessageOn("SAVE");
        }
    }//GEN-LAST:event_btnAgree3ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new WaitSplashScreen(null, true, this, "PURCHASE ORDER").getThisDlg();
    }//GEN-LAST:event_btnPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditAppliance;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel addEditChangeAddress;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel addEditChangeCoMakerAddress;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel addEditChangeCoMakerSpouseAddress;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel addEditChangeSpouseAddress;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCharacterReference;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCoMakerEmployment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCoMakerFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCoMakerPersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCoMakerSourceOfIncome;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCoMakerSpouseEmployment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCoMakerSpouseFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCoMakerSpousePersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCreditReference;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditDependents;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditEmployment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditExpenditures;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditFamily;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditLandAssets;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditMachinery;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditPO;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditPersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSibling;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSourceOfInc;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSpouseEmployment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSpouseFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSpousePersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditVehicle;
    private javax.swing.JButton btnAgree1;
    private javax.swing.JButton btnAgree2;
    private javax.swing.JButton btnAgree3;
    private javax.swing.JButton btnPrint;
    private java.util.List<PersonalInfo> comakers;
    private com.vg.scfc.financing.cis.ui.reusable.HeaderPanel headerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel lblAvgMonthlyIncomeForOtherSources;
    private com.vg.scfc.financing.cis.ui.reusable.AddressPanel panelAddress;
    private com.vg.scfc.financing.cis.ui.reusable.AppliancesPanel panelAppliance;
    private com.vg.scfc.financing.cis.ui.reusable.CharacterReferenceDependentPanel panelCharacterReference;
    private com.vg.scfc.financing.cis.ui.reusable.AddressPanel panelCoMakerAddress;
    private com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel panelCoMakerEmploymentData;
    private com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel panelCoMakerFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelCoMakerPersonalInformation;
    private com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel panelCoMakerRidersToBuyer;
    private com.vg.scfc.financing.cis.ui.reusable.SourceOfIncomePanel panelCoMakerSourceOfIncome;
    private com.vg.scfc.financing.cis.ui.reusable.AddressPanel panelCoMakerSpouseAddress;
    private com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel panelCoMakerSpouseEmploymentData;
    private com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel panelCoMakerSpouseFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelCoMakerSpousePersonalInformation;
    private com.vg.scfc.financing.cis.ui.reusable.CreditReferencePanel panelCreditReference;
    private com.vg.scfc.financing.cis.ui.reusable.DependentPanel panelDependents;
    private com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel panelEmploymentData;
    private com.vg.scfc.financing.cis.ui.reusable.ExpendituresPanel panelExpenditures;
    private com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel panelFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.LandPanel panelLandAssets;
    private com.vg.scfc.financing.cis.ui.reusable.MachineryPanel panelMachinery;
    private com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2 panelPO;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelPersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel panelRidersToBuyer;
    private com.vg.scfc.financing.cis.ui.reusable.SiblingsPanel panelSibling;
    private com.vg.scfc.financing.cis.ui.reusable.SourceOfIncomePanel panelSourceOfIncome;
    private com.vg.scfc.financing.cis.ui.reusable.AddressPanel panelSpouseAddress;
    private com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel panelSpouseEmployment;
    private com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel panelSpouseFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelSpousePersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel panelSpouseRidersToBuyer;
    private com.vg.scfc.financing.cis.ui.reusable.VehiclePanel panelVehicle;
    private com.vg.scfc.financing.cis.ui.panel.SearchPanel searchPanel;
    private javax.swing.JTabbedPane tabMain;
    private javax.swing.JPanel tabPO;
    private javax.swing.JTable tableCoMaker;
    private javax.swing.JTextField txtTotalMonthlyIncome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private String formNo;
    private Date applicationDate;
    private BigDecimal totalMonthlyIncome;
    private int selectedIndex = -1;
    private PersonalInfo selectedCoMaker;

    public PersonalInfo getSelectedCoMaker() {
        return selectedCoMaker;
    }

    public void setSelectedCoMaker(PersonalInfo selectedCoMaker) {
        this.selectedCoMaker = selectedCoMaker;
    }

    public void setTotalMonthlyIncome(BigDecimal totalMonthlyIncome) {
        this.totalMonthlyIncome = totalMonthlyIncome;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public void refreshComakerTable(List<PersonalInfo> p) {
        comakers.clear();
        comakers.addAll(p);
        if (!comakers.isEmpty()) {
            tableCoMaker.setRowSelectionInterval(0, 0);
        }
    }

    public List<PersonalInfo> getComakers() {
        return comakers;
    }

    @Override
    public JasperPrint printNow() throws Exception {
        JasperPrint result = ReportController.getInstance().printPurchaseOrder(headerPanel.getFormNo());
        if(result == null) {
            throw new Exception();
        } else {
            return result;
        }
    }

}
