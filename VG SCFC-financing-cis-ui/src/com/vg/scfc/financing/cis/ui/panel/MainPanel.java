/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.panel;

import com.vg.commons.dlg.WaitSplashScreen;
import com.vg.commons.listener.DoJasperPrintReport;
import com.vg.commons.renderer.IndexedFocusTraversalPolicy;
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
import com.vg.scfc.financing.cis.ui.controller.FormController;
import com.vg.scfc.financing.cis.ui.controller.IdentificationController;
import com.vg.scfc.financing.cis.ui.controller.LandAssetController;
import com.vg.scfc.financing.cis.ui.controller.MachineryAssetsController;
import com.vg.scfc.financing.cis.ui.controller.PersonalInfoController;
import com.vg.scfc.financing.cis.ui.controller.PhotoController;
import com.vg.scfc.financing.cis.ui.controller.PurchaseOrderController;
import com.vg.scfc.financing.cis.ui.controller.ReportController;
import com.vg.scfc.financing.cis.ui.controller.SearchController;
import com.vg.scfc.financing.cis.ui.controller.SiblingController;
import com.vg.scfc.financing.cis.ui.controller.SourceOfIncomeController;
import com.vg.scfc.financing.cis.ui.controller.VehicleAssetsController;
import com.vg.scfc.financing.cis.ui.dialog.ApplicationFormDlg;
import com.vg.scfc.financing.cis.ui.listener.AddEditChangeListener;
import com.vg.scfc.financing.cis.ui.listener.BasicActionListener;
import com.vg.scfc.financing.cis.ui.reusable.AddressPanel;
import com.vg.scfc.financing.cis.ui.reusable.AppliancesPanel;
import com.vg.scfc.financing.cis.ui.reusable.CharacterReferenceDependentPanel;
import com.vg.scfc.financing.cis.ui.reusable.CreditReferencePanel;
import com.vg.scfc.financing.cis.ui.reusable.DependentPanel;
import com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel;
import com.vg.scfc.financing.cis.ui.reusable.ExpendituresPanel;
import com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel;
import com.vg.scfc.financing.cis.ui.reusable.LandPanel;
import com.vg.scfc.financing.cis.ui.reusable.MachineryPanel;
import com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel;
import com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2;
import com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel;
import com.vg.scfc.financing.cis.ui.reusable.SiblingsPanel;
import com.vg.scfc.financing.cis.ui.reusable.SourceOfIncomePanel;
import com.vg.scfc.financing.cis.ui.reusable.VehiclePanel;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.ProcessValidator;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperPrint;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class MainPanel extends javax.swing.JPanel implements DoJasperPrintReport {

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
        btnPrint.setIcon(new ImageIcon("src/resources/icons/printIcon.png"));
    }

    private void initTabs() {
//        tabMain.setIconAt(0, null);
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
        panelPersonalInfo.setMainPanel(this);
        panelPersonalInfo.setButtonPanel(addEditPersonalInfo);
        addEditPersonalInfo.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                resetFields();
                ApplicationFormDlg form = new ApplicationFormDlg(null, true);
                UIMgr.centerToScreen(form);
                form.setVisible(true);
                if (form.getFormSeries().trim().equals("") || form.getFormSeries().trim().equals("00000")) {
                    addEditPersonalInfo.resetActionStateToDefault();
                } else {
                    headerPanel.setFormNo("");
                    headerPanel.setIDNo(form.getFormSeries());
                    try {
                        headerPanel.setApplicationDate(form.getApplicationDate());
                    } catch (ParseException ex) {
                        UIValidator.log(ex, MainPanel.class);
                    }
                    headerPanel.enableFields(false);
                    panelPersonalInfo.setFieldsEditable(true);
                    panelPersonalInfo.enableTakePicture(false);
                    managedTab("tabAppPersonalInfo");
                    enableSearch(false);
                }
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelPersonalInfo.savePersonalInfo();
                if (isSaved == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    panelPersonalInfo.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    UIValidator.promptSucessMessageFor("SAVE");
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelPersonalInfo.setPersonalInfo(panelPersonalInfo.getPersonalInfo());
                fillValue(FormController.getInstance().findByFormNo(headerPanel.getFormNo()));
                panelPersonalInfo.setFieldsEditable(false);
            }

            @Override
            public void onEdit() {
                if (panelPersonalInfo.getPersonalInfo() == null) {
                    addEditPersonalInfo.resetActionStateToDefault();
                    return;
                }

                enableSearch(false);
                managedTab("tabAppPersonalInfo");
                panelPersonalInfo.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelPersonalInfo.updatePersonalInfo();
                if (isUpdated == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelPersonalInfo.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabEmployment");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelEmploymentData.setEmployment(panelEmploymentData.getEmployment());
                panelEmploymentData.setFieldsEditable(false);
                panelEmploymentData.resetToDefault();
            }

            @Override
            public void onEdit() {
                enableSearch(false);
                managedTab("tabEmployment");
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabFamily");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelFamilyBackground.setFamilies(panelFamilyBackground.getFamilies());
                panelFamilyBackground.setFieldsEditable(false);
                panelFamilyBackground.resetToDefault();
            }

            @Override
            public void onEdit() {
                enableSearch(false);
                managedTab("tabFamily");
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabSibling");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelSibling.setFieldsEditable(false);
                panelSibling.resetToDefault();
            }

            @Override
            public void onEdit() {
                enableSearch(false);
                managedTab("tabSibling");
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabCharacterRef");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCharacterReference.setFieldsEditable(false);
                panelCharacterReference.resetToDefault();
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                enableSearch(false);
                managedTab("tabCharacterRef");
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabDependent");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelDependents.setFieldsEditable(false);
                panelDependents.resetToDefault();
            }

            @Override
            public void onEdit() {
                enableSearch(false);
                managedTab("tabDependent");
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabCreditRef");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelCreditReference.setFieldsEditable(false);
                panelCreditReference.resetToDefault();
            }

            @Override
            public void onEdit() {
                enableSearch(false);
                managedTab("tabCreditRef");
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabSourceOfInc");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelSourceOfIncome.setFieldsEditable(false);
                panelSourceOfIncome.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelSourceOfIncome.setFieldsEditable(true);
                managedTab("tabSourceOfInc");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabExpenditure");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelExpenditures.setFieldsEditable(false);
                panelExpenditures.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelExpenditures.setFieldsEditable(true);
                managedTab("tabExpenditure");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
                panelExpenditures.setFieldsEditable(false);
            }
        });
    }

    private void initLandAssetsAddEditListener() {
        panelLandAssets.setHeaderPanel(headerPanel);
        panelLandAssets.setButtonPanel(addEditLandAssets);
        addEditLandAssets.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelLandAssets.setFieldsEditable(true);
                panelLandAssets.resetToDefault();
                managedTab("tabAssetLand");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelLandAssets.saveLandAssets();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelLandAssets.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelLandAssets.setFieldsEditable(false);
                panelLandAssets.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelLandAssets.setFieldsEditable(true);
                managedTab("tabAssetLand");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelLandAssets.updateLandAssets();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelLandAssets.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
                panelLandAssets.setFieldsEditable(false);
            }
        });
    }

    private void initVehicleAssetsAddEditListener() {
        panelVehicle.setHeaderPanel(headerPanel);
        panelVehicle.setButtonPanel(addEditVehicle);
        addEditVehicle.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelVehicle.setFieldsEditable(true);
                panelVehicle.resetToDefault();
                managedTab("tabAssetVehicle");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelVehicle.saveVehicleAsset();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelVehicle.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelVehicle.setFieldsEditable(false);
                panelVehicle.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelVehicle.setFieldsEditable(true);
                managedTab("tabAssetVehicle");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelVehicle.updateVehicleAsset();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelVehicle.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
                panelVehicle.setFieldsEditable(false);
            }
        });
    }

    private void initApplianceAssetsAddEditListener() {
        panelAppliance.setHeaderPanel(headerPanel);
        panelAppliance.setButtonPanel(addEditAppliance);
        addEditAppliance.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelAppliance.setFieldsEditable(true);
                panelAppliance.resetToDefault();
                managedTab("tabAssetAppliance");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelAppliance.saveApplianceAsset();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelAppliance.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                enableTabs();
                panelAppliance.setFieldsEditable(false);
                panelAppliance.resetToDefault();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelAppliance.setFieldsEditable(true);
                managedTab("tabAssetAppliance");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelAppliance.updateApplianceAsset();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                }
                if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelAppliance.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
                panelAppliance.setFieldsEditable(false);
            }
        });
    }

    private void initMachineryAssetsAddEditListener() {
        panelMachinery.setHeaderPanel(headerPanel);
        panelMachinery.setButtonPanel(addEditMachinery);
        addEditMachinery.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelMachinery.setFieldsEditable(true);
                panelMachinery.resetToDefault();
                managedTab("tabAssetMachinery");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelMachinery.saveMachinery();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelMachinery.setFieldsEditable(false);
                panelMachinery.resetToDefault();
            }

            @Override
            public void onEdit() {
                enableSearch(false);
                panelMachinery.setFieldsEditable(true);
                managedTab("tabAssetMachinery");
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelMachinery.updateMachinery();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                }
                if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelMachinery.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
                panelMachinery.setFieldsEditable(false);
            }
        });
    }

    /* Spouse Information */
    private void initSpousePersonalInfoAddEditListener() {
        panelSpousePersonalInfo.setHeaderPanel(headerPanel);
        panelSpousePersonalInfo.setPersonType("SPO");
        panelSpousePersonalInfo.setMainPanel(this);
        panelSpousePersonalInfo.setButtonPanel(addEditSpousePersonalInfo);
        addEditSpousePersonalInfo.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelSpousePersonalInfo.resetToDefault();
                panelSpousePersonalInfo.setFieldsEditable(true);
                panelSpousePersonalInfo.enableTakePicture(false);
                managedTab("tabSpousePersonalInfo");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelSpousePersonalInfo.saveSpousePersonalInfo();
                if (isSaved == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpousePersonalInfo.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return false;
                }
            }

            @Override
            public void onCancelAdd() {
                enableTabs();
                panelSpousePersonalInfo.resetToDefault();
                panelSpousePersonalInfo.setPersonalInfo(panelSpousePersonalInfo.getPersonalInfo());
                panelSpousePersonalInfo.setFieldsEditable(false);
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                if (panelSpousePersonalInfo.getPersonalInfo() == null) {
                    addEditSpousePersonalInfo.resetActionStateToDefault();
                    return;
                }

                panelSpousePersonalInfo.setFieldsEditable(true);
                managedTab("tabSpousePersonalInfo");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelSpousePersonalInfo.updateSpousePersonalInfo();
                if (isUpdated == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpousePersonalInfo.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                enableTabs();
                panelSpousePersonalInfo.setFieldsEditable(false);
                enableSearch(true);
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
                managedTab("tabSpouseEmployment");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableTabs();
                panelSpouseEmployment.setEmployment(panelSpouseEmployment.getEmployment());
                panelSpouseEmployment.setFieldsEditable(false);
                panelSpouseEmployment.resetToDefault();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelSpouseEmployment.setFieldsEditable(true);
                managedTab("tabSpouseEmployment");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableTabs();
                panelSpouseEmployment.setFieldsEditable(false);
                enableSearch(true);
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
                managedTab("tabSpouseFamily");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableTabs();
                panelSpouseFamilyBackground.setFamilies(panelSpouseFamilyBackground.getFamilies());
                panelSpouseFamilyBackground.setFieldsEditable(false);
                panelSpouseFamilyBackground.resetToDefault();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelSpouseFamilyBackground.setFieldsEditable(true);
                managedTab("tabSpouseFamily");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelSpouseFamilyBackground.updateFamilyBackground();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpouseFamilyBackground.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
                panelSpouseFamilyBackground.setFieldsEditable(false);
            }
        });
    }

    /* Co Maker Information */
    private void initCoMakerPersonalInfoAddEditListener() {
        panelCoMakerPersonalInformation.setHeaderPanel(headerPanel);
        panelCoMakerPersonalInformation.setMainPanel(this);
        panelCoMakerPersonalInformation.setButtonPanel(addEditCoMakerPersonalInfo);
        addEditCoMakerPersonalInfo.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelCoMakerPersonalInformation.resetToDefault();
                panelCoMakerPersonalInformation.setFieldsEditable(true);
                panelCoMakerPersonalInformation.enableTakePicture(false);
                managedTab("tabCoMakerPersonalInfo");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelCoMakerPersonalInformation.saveCoMakerPersonalInfo();
                if (isSaved == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerPersonalInformation.setFieldsEditable(false);
                    refreshComakerTable(PersonalInfoController.getInstance().findCoMakersByFormNo(headerPanel.getFormNo()));
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerPersonalInformation.resetToDefault();
                panelCoMakerPersonalInformation.setPersonalInfo(panelCoMakerPersonalInformation.getPersonalInfo());
                panelCoMakerPersonalInformation.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                if (panelCoMakerPersonalInformation.getPersonalInfo() == null) {
                    addEditCoMakerPersonalInfo.resetActionStateToDefault();
                    return;
                }

                panelCoMakerPersonalInformation.setFieldsEditable(true);
                managedTab("tabCoMakerPersonalInfo");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelCoMakerPersonalInformation.updateCoMakerPersonalInfo();
                if (isUpdated == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerPersonalInformation.setFieldsEditable(false);
                    refreshComakerTable(PersonalInfoController.getInstance().findCoMakersByFormNo(headerPanel.getFormNo()));
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabCoMakerEmployment");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCoMakerEmploymentData.saveCoMakerEmploymentData();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerEmploymentData.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelCoMakerEmploymentData.setEmployment(panelCoMakerEmploymentData.getEmployment());
                panelCoMakerEmploymentData.setFieldsEditable(false);
                panelCoMakerEmploymentData.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCoMakerEmploymentData.setFieldsEditable(true);
                managedTab("tabCoMakerEmployment");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerEmploymentData.updateCoMakerEmploymentData();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerEmploymentData.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabCoMakerFamily");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableTabs();
                panelCoMakerFamilyBackground.setFamilies(panelCoMakerFamilyBackground.getFamilies());
                panelCoMakerFamilyBackground.setFieldsEditable(false);
                panelCoMakerFamilyBackground.resetToDefault();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelCoMakerFamilyBackground.setFieldsEditable(true);
                managedTab("tabCoMakerFamily");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerFamilyBackground.updateCoMakerFamilyBackground();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerFamilyBackground.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
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
                managedTab("tabCoMakerSourceOfIncome");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                enableSearch(true);
                enableTabs();
                panelCoMakerSourceOfIncome.setFieldsEditable(false);
                panelCoMakerSourceOfIncome.resetToDefault();
            }

            @Override
            public void onEdit() {
                panelCoMakerSourceOfIncome.setFieldsEditable(true);
                managedTab("tabCoMakerSourceOfIncome");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSourceOfIncome.updateSourceOfIncome();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSourceOfIncome.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                enableTabs();
                panelCoMakerSourceOfIncome.setFieldsEditable(false);
            }
        });
    }

    /* Co Maker Spouse Information */
    private void initCoMakerSpousePersonalInfoAddEditListener() {
        panelCoMakerSpousePersonalInformation.setHeaderPanel(headerPanel);
        panelCoMakerSpousePersonalInformation.setMainPanel(this);
        panelCoMakerSpousePersonalInformation.setButtonPanel(addEditCoMakerSpousePersonalInfo);
        addEditCoMakerSpousePersonalInfo.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelCoMakerSpousePersonalInformation.resetToDefault();
                panelCoMakerSpousePersonalInformation.setFieldsEditable(true);
                panelCoMakerSpousePersonalInformation.enableTakePicture(false);
                managedTab("tabCoMakerSpousePersonalInfo");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelCoMakerSpousePersonalInformation.saveCoMakerSpousePersonalInfo();
                if (isSaved == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return false;
                }
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpousePersonalInformation.resetToDefault();
                panelCoMakerSpousePersonalInformation.setPersonalInfo(panelCoMakerSpousePersonalInformation.getPersonalInfo());
                panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                if (panelCoMakerSpousePersonalInformation.getPersonalInfo() == null) {
                    addEditCoMakerSpousePersonalInfo.resetActionStateToDefault();
                    return;
                }

                panelCoMakerSpousePersonalInformation.setFieldsEditable(true);
                managedTab("tabCoMakerSpousePersonalInfo");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelCoMakerSpousePersonalInformation.updateCoMakerSpousePersonalInfo();
                if (isUpdated == PersonalInformationPanel.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == PersonalInformationPanel.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSpousePersonalInformation.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
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
                managedTab("tabCoMakerSpouseEmployment");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpouseEmploymentData.setEmployment(panelCoMakerSpouseEmploymentData.getEmployment());
                panelCoMakerSpouseEmploymentData.setFieldsEditable(false);
                panelCoMakerSpouseEmploymentData.resetToDefault();
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelCoMakerSpouseEmploymentData.setFieldsEditable(true);
                managedTab("tabCoMakerSpouseEmployment");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSpouseEmploymentData.updateCoMakerSpouseEmploymentData();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSpouseEmploymentData.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSpouseEmploymentData.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
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
                managedTab("tabCoMakerSpouseFamily");
                enableSearch(false);
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

                enableSearch(true);
                enableTabs();
                return isSaved;
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpouseFamilyBackground.setFamilies(panelCoMakerSpouseFamilyBackground.getFamilies());
                panelCoMakerSpouseFamilyBackground.setFieldsEditable(false);
                panelCoMakerSpouseFamilyBackground.resetToDefault();
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelCoMakerSpouseFamilyBackground.setFieldsEditable(true);
                managedTab("tabCoMakerSpouseFamily");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCoMakerSpouseFamilyBackground.updateCoMakerSpouseFamilyBackground();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerSpouseFamilyBackground.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                }

                enableSearch(true);
                enableTabs();
                return isUpdated;
            }

            @Override
            public void onCancelEdit() {
                enableSearch(true);
                panelCoMakerSpouseFamilyBackground.setFieldsEditable(false);
                enableTabs();
            }
        });
    }

    /* Address Information */
    private void initAddressAddEditChangeListener() {
        panelAddress.setHeaderPanel(headerPanel);
        panelAddress.setPersonType("APP");
        panelAddress.setButtonPanel(addEditChangeAddress);
        addEditChangeAddress.setButtonListener(new AddEditChangeListener() {
            @Override
            public void onAdd() {
                panelAddress.setFieldsEditable(true);
                panelAddress.resetToDefault();
                managedTab("tabAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelAddress.saveAddress();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelAddress.setFieldsEditable(true);
                managedTab("tabAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelAddress.updateAddress();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onChange() {
                panelAddress.setFieldsEditable(true);
                panelAddress.resetToDefault();
                managedTab("tabAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveChange() {
                int isChanged = panelAddress.changeAddress();
                if (isChanged == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                }
                if (isChanged == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelChange() {
                panelAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }
        });
    }

    private void initSpouseAddressAddEditChangeListener() {
        panelSpouseAddress.setHeaderPanel(headerPanel);
        panelSpouseAddress.setPersonType("SPO");
        panelSpouseAddress.setButtonPanel(addEditChangeSpouseAddress);
        addEditChangeSpouseAddress.setButtonListener(new AddEditChangeListener() {
            @Override
            public void onAdd() {
                panelSpouseAddress.setFieldsEditable(true);
                panelSpouseAddress.resetToDefault();
                managedTab("tabSpouseAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelSpouseAddress.saveAddress();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpouseAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelSpouseAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelSpouseAddress.setFieldsEditable(true);
                managedTab("tabSpouseAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelSpouseAddress.updateAddress();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpouseAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelSpouseAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onChange() {
                panelSpouseAddress.setFieldsEditable(true);
                panelSpouseAddress.resetToDefault();
                managedTab("tabSpouseAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveChange() {
                int isChanged = panelSpouseAddress.changeAddress();
                if (isChanged == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isChanged == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpouseAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelChange() {
                panelSpouseAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }
        });
    }

    private void initCoMakerAddressAddEditChangeListener() {
        panelCoMakerAddress.setHeaderPanel(headerPanel);
        panelCoMakerAddress.setMainPanel(this);
        panelCoMakerAddress.setButtonPanel(addEditChangeCoMakerAddress);
        addEditChangeCoMakerAddress.setButtonListener(new AddEditChangeListener() {
            @Override
            public void onAdd() {
                panelCoMakerAddress.setFieldsEditable(true);
                panelCoMakerAddress.resetToDefault();
                managedTab("tabCoMakerAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelCoMakerAddress.saveCoMakerAddress();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelCoMakerAddress.setFieldsEditable(true);
                managedTab("tabCoMakerAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelCoMakerAddress.updateCoMakerAddress();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onChange() {
                panelCoMakerAddress.setFieldsEditable(true);
                panelCoMakerAddress.resetToDefault();
                managedTab("tabCoMakerAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveChange() {
                int isSaved = panelCoMakerAddress.saveCoMakerAddress();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelChange() {
                panelCoMakerAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }
        });
    }

    private void initCoMakerSpouseAddressAddEditChangeListener() {
        panelCoMakerSpouseAddress.setButtonPanel(addEditChangeCoMakerSpouseAddress);
        addEditChangeCoMakerSpouseAddress.setButtonListener(new AddEditChangeListener() {
            @Override
            public void onAdd() {
                panelCoMakerSpouseAddress.setFieldsEditable(true);
                panelCoMakerSpouseAddress.resetToDefault();
                managedTab("tabCoMakerSpouseAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelCoMakerSpouseAddress.saveAddress();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerSpouseAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerSpouseAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelCoMakerSpouseAddress.setFieldsEditable(true);
                managedTab("tabCoMakerSpouseAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelCoMakerSpouseAddress.updateCoMakerAddress();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                }
                if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    refreshSearch(headerPanel.getFormNo());
                    panelCoMakerSpouseAddress.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerSpouseAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onChange() {
                panelCoMakerSpouseAddress.setFieldsEditable(true);
                panelCoMakerSpouseAddress.resetToDefault();
                managedTab("tabCoMakerSpouseAddress");
                enableSearch(false);
            }

            @Override
            public boolean onSaveChange() {
                int isSaved = panelCoMakerAddress.saveCoMakerAddress();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerAddress.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelChange() {
                panelCoMakerSpouseAddress.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }
        });
    }

    /* Purchase Order  */
    private void initPurchaseOrderAddEditListener() {
        panelPO.setHeaderPanel(headerPanel);
        panelPO.setButtonPanel(addEditPO);
        addEditPO.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelPO.setFieldsEditable(true);
                panelPO.resetToDefault();
                managedTab("tabPO");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelPO.savePurchaseOrder();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelPO.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelPO.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelPO.setFieldsEditable(true);
                managedTab("tabPO");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelPO.updatePurchaseOrder();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelPO.setFieldsEditable(false);
                    refreshSearch(headerPanel.getFormNo());
                    enableSearch(false);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelPO.setFieldsEditable(false);
                enableTabs();
                enableSearch(false);
            }
        });
    }

    /* Riders to Buyers */
    private void initIdentification() {
        panelRidersToBuyer.setHeaderPanel(headerPanel);
        panelRidersToBuyer.setPersonType("APP");
        panelRidersToBuyer.setButtonPanel(addEditIdentification);
        addEditIdentification.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelRidersToBuyer.setFieldsEditable(true);
                panelRidersToBuyer.resetToDefault();
                managedTab("tabID");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelRidersToBuyer.saveAgreement();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelRidersToBuyer.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelRidersToBuyer.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelRidersToBuyer.setFieldsEditable(true);
                managedTab("tabID");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelRidersToBuyer.updateAgreement();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelRidersToBuyer.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelRidersToBuyer.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }
        });

        panelSpouseRidersToBuyer.setHeaderPanel(headerPanel);
        panelSpouseRidersToBuyer.setPersonType("SPO");
        panelSpouseRidersToBuyer.setButtonPanel(addEditSpouseID);
        addEditSpouseID.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelSpouseRidersToBuyer.setFieldsEditable(true);
                panelSpouseRidersToBuyer.resetToDefault();
                managedTab("tabSpouseID");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelSpouseRidersToBuyer.saveAgreement();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelSpouseRidersToBuyer.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelSpouseRidersToBuyer.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelSpouseRidersToBuyer.setFieldsEditable(true);
                managedTab("tabSpouseID");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelSpouseRidersToBuyer.updateAgreement();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelSpouseRidersToBuyer.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelSpouseRidersToBuyer.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }
        });

        panelCoMakerRidersToBuyer.setHeaderPanel(headerPanel);
        panelCoMakerRidersToBuyer.setButtonPanel(addEditCMID);
        addEditCMID.setBasicActionListener(new BasicActionListener() {
            @Override
            public void onAdd() {
                panelCoMakerRidersToBuyer.setFieldsEditable(true);
                panelCoMakerRidersToBuyer.resetToDefault();
                managedTab("tabCoMakerID");
                enableSearch(false);
            }

            @Override
            public boolean onSaveAdd() {
                int isSaved = panelCoMakerRidersToBuyer.saveAgreement();
                if (isSaved == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isSaved == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("SAVE");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("SAVE");
                    panelCoMakerRidersToBuyer.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelAdd() {
                panelCoMakerRidersToBuyer.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }

            @Override
            public void onEdit() {
                panelCoMakerRidersToBuyer.setFieldsEditable(true);
                managedTab("tabCoMakerID");
                enableSearch(false);
            }

            @Override
            public boolean onSaveEdit() {
                int isUpdated = panelCoMakerRidersToBuyer.updateAgreement();
                if (isUpdated == ProcessValidator.VALIDATE_ERROR) {
                    return false;
                } else if (isUpdated == ProcessValidator.PROCESS_FAILED) {
                    UIValidator.promptErrorMessageOn("EDIT");
                    return false;
                } else {
                    UIValidator.promptSucessMessageFor("EDIT");
                    panelCoMakerRidersToBuyer.setFieldsEditable(false);
                    enableSearch(true);
                    enableTabs();
                    return true;
                }
            }

            @Override
            public void onCancelEdit() {
                panelCoMakerRidersToBuyer.setFieldsEditable(false);
                enableTabs();
                enableSearch(true);
            }
        });
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
                panelCoMakerSpousePersonalInformation.setClientNo(searchPanel.getCustomer().getClientNo());
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
            panelRidersToBuyer.setIdentification(IdentificationController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "APP"));
            panelSpouseRidersToBuyer.setIdentification(IdentificationController.getInstance().findByFormNoAndPersonType(form.getTxFormNo(), "SPO"));
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

    /* Tab Management */
    public void managedTab(String tabName) {
        List<JPanel> panels = new ArrayList<>();
        panels.add(tabAppPersonalInfo);
        panels.add(tabEmployment);
        panels.add(tabFamily);
        panels.add(tabSibling);
        panels.add(tabCharacterRef);
        panels.add(tabDependent);
        panels.add(tabCreditRef);
        panels.add(tabSourceOfInc);
        panels.add(tabExpenditure);
        panels.add(tabAssetLand);
        panels.add(tabAssetAppliance);
        panels.add(tabAssetMachinery);
        panels.add(tabAssetVehicle);
        panels.add(tabAddress);
        panels.add(tabPO);
        panels.add(tabID);

        /* Spouse */
        panels.add(tabSpousePersonalInfo);
        panels.add(tabSpouseEmployment);
        panels.add(tabSpouseFamily);
        panels.add(tabSpouseAddress);
        panels.add(tabSpouseID);

        /* Co Maker */
        panels.add(tabCoMaker);
        panels.add(tabCoMakerAddress);
        panels.add(tabCoMakerEmployment);
        panels.add(tabCoMakerFamily);
        panels.add(tabCoMakerID);
        panels.add(tabCoMakerPersonalInfo);
        panels.add(tabCoMakerSourceOfIncome);
        panels.add(tabCoMakerSpouseAddress);
        panels.add(tabCoMakerSpouseEmployment);
        panels.add(tabCoMakerSpouseFamily);
        panels.add(tabCoMakerSpousePersonalInfo);

        UIValidator.manageTab(panels, tabName);
        tabDetail.setEnabled(false);
        tabDetails.setEnabled(false);
        tabMain.setEnabled(false);
//        switch(tabName) {
//            case "tabAppPersonalInfo":
//            case "tabSpousePersonalInfo":
//            case "tabCoMakerPersonalInfo":
//                tabDetail.setEnabled(false);
//                break;
//            default:
//                tabDetail.setEnabled(false);
//                tabMain.setEnabled(false);
//                break;
//        }
    }

    public void enableTabs() {
        List<JPanel> panels = new ArrayList<>();
        panels.add(tabAppPersonalInfo);
        panels.add(tabEmployment);
        panels.add(tabFamily);
        panels.add(tabSibling);
        panels.add(tabCharacterRef);
        panels.add(tabDependent);
        panels.add(tabCreditRef);
        panels.add(tabSourceOfInc);
        panels.add(tabExpenditure);
        panels.add(tabAssetLand);
        panels.add(tabAssetAppliance);
        panels.add(tabAssetMachinery);
        panels.add(tabAssetVehicle);
        panels.add(tabAddress);
        panels.add(tabPO);
        panels.add(tabID);

        /* Spouse */
        panels.add(tabSpousePersonalInfo);
        panels.add(tabSpouseEmployment);
        panels.add(tabSpouseFamily);
        panels.add(tabSpouseAddress);
        panels.add(tabSpouseID);

        /* Co Maker */
        panels.add(tabCoMaker);
        panels.add(tabCoMakerAddress);
        panels.add(tabCoMakerEmployment);
        panels.add(tabCoMakerFamily);
        panels.add(tabCoMakerID);
        panels.add(tabCoMakerPersonalInfo);
        panels.add(tabCoMakerSourceOfIncome);
        panels.add(tabCoMakerSpouseAddress);
        panels.add(tabCoMakerSpouseEmployment);
        panels.add(tabCoMakerSpouseFamily);
        panels.add(tabCoMakerSpousePersonalInfo);

        UIValidator.enableTabs(panels);

        tabMain.setEnabled(true);
        tabDetail.setEnabled(true);
        tabDetails.setEnabled(true);
    }

    public IndexedFocusTraversalPolicy getPolicy() {
        IndexedFocusTraversalPolicy policy = UISetting.policy;

        return policy;
    }

    public void enableSearch(boolean value) {
        searchPanel.enableSearch(value);
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
        tabAppPersonalInfo = new javax.swing.JPanel();
        panelPersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditPersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabDetails = new javax.swing.JTabbedPane();
        tabEmployment = new javax.swing.JPanel();
        panelEmploymentData = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabFamily = new javax.swing.JPanel();
        panelFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditFamily = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabSibling = new javax.swing.JPanel();
        panelSibling = new com.vg.scfc.financing.cis.ui.reusable.SiblingsPanel();
        addEditSibling = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCharacterRef = new javax.swing.JPanel();
        panelCharacterReference = new com.vg.scfc.financing.cis.ui.reusable.CharacterReferenceDependentPanel();
        addEditCharacterReference = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabDependent = new javax.swing.JPanel();
        addEditDependents = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelDependents = new com.vg.scfc.financing.cis.ui.reusable.DependentPanel();
        tabCreditRef = new javax.swing.JPanel();
        panelCreditReference = new com.vg.scfc.financing.cis.ui.reusable.CreditReferencePanel();
        addEditCreditReference = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabSourceOfInc = new javax.swing.JPanel();
        panelSourceOfIncome = new com.vg.scfc.financing.cis.ui.reusable.SourceOfIncomePanel();
        addEditSourceOfInc = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        lblAvgMonthlyIncomeForOtherSources = new javax.swing.JLabel();
        txtTotalMonthlyIncome = new javax.swing.JTextField();
        tabExpenditure = new javax.swing.JPanel();
        panelExpenditures = new com.vg.scfc.financing.cis.ui.reusable.ExpendituresPanel();
        addEditExpenditures = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel10 = new javax.swing.JPanel();
        tabAsset = new javax.swing.JTabbedPane();
        tabAssetLand = new javax.swing.JPanel();
        panelLandAssets = new com.vg.scfc.financing.cis.ui.reusable.LandPanel();
        addEditLandAssets = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabAssetVehicle = new javax.swing.JPanel();
        panelVehicle = new com.vg.scfc.financing.cis.ui.reusable.VehiclePanel();
        addEditVehicle = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabAssetAppliance = new javax.swing.JPanel();
        panelAppliance = new com.vg.scfc.financing.cis.ui.reusable.AppliancesPanel();
        addEditAppliance = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabAssetMachinery = new javax.swing.JPanel();
        panelMachinery = new com.vg.scfc.financing.cis.ui.reusable.MachineryPanel();
        addEditMachinery = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabAddress = new javax.swing.JPanel();
        panelAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        tabPO = new javax.swing.JPanel();
        addEditPO = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        panelPO = new com.vg.scfc.financing.cis.ui.reusable.PurchaseOrderPanel2();
        btnPrint = new javax.swing.JButton();
        tabID = new javax.swing.JPanel();
        panelRidersToBuyer = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        addEditIdentification = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabSpousePersonalInfo = new javax.swing.JPanel();
        panelSpousePersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        tabSpouseEmployment = new javax.swing.JPanel();
        panelSpouseEmployment = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditSpouseEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabSpouseFamily = new javax.swing.JPanel();
        panelSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabSpouseAddress = new javax.swing.JPanel();
        panelSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        tabSpouseID = new javax.swing.JPanel();
        panelSpouseRidersToBuyer = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        addEditSpouseID = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        addEditSpousePersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCoMaker = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCoMaker = new javax.swing.JTable();
        tabDetail = new javax.swing.JTabbedPane();
        tabCoMakerPersonalInfo = new javax.swing.JPanel();
        panelCoMakerPersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditCoMakerPersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCoMakerEmployment = new javax.swing.JPanel();
        panelCoMakerEmploymentData = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditCoMakerEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCoMakerFamily = new javax.swing.JPanel();
        panelCoMakerFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditCoMakerFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCoMakerSourceOfIncome = new javax.swing.JPanel();
        panelCoMakerSourceOfIncome = new com.vg.scfc.financing.cis.ui.reusable.SourceOfIncomePanel();
        addEditCoMakerSourceOfIncome = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        jPanel23 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        tabCoMakerSpousePersonalInfo = new javax.swing.JPanel();
        panelCoMakerSpousePersonalInformation = new com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel();
        addEditCoMakerSpousePersonalInfo = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCoMakerSpouseEmployment = new javax.swing.JPanel();
        panelCoMakerSpouseEmploymentData = new com.vg.scfc.financing.cis.ui.reusable.EmploymentDataPanel();
        addEditCoMakerSpouseEmployment = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCoMakerSpouseFamily = new javax.swing.JPanel();
        panelCoMakerSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.FamilyBackgroundPanel();
        addEditCoMakerSpouseFamilyBackground = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        tabCoMakerSpouseAddress = new javax.swing.JPanel();
        panelCoMakerSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeCoMakerSpouseAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        tabCoMakerAddress = new javax.swing.JPanel();
        panelCoMakerAddress = new com.vg.scfc.financing.cis.ui.reusable.AddressPanel();
        addEditChangeCoMakerAddress = new com.vg.scfc.financing.cis.ui.reusable.AddEditChangeButtonPanel();
        tabCoMakerID = new javax.swing.JPanel();
        panelCoMakerRidersToBuyer = new com.vg.scfc.financing.cis.ui.reusable.RidersToBuyerPanel();
        addEditCMID = new com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel();
        headerPanel = new com.vg.scfc.financing.cis.ui.reusable.HeaderPanel();
        searchPanel = new com.vg.scfc.financing.cis.ui.panel.SearchPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabMain.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tabAppPersonalInfo.setName("tabAppPersonalInfo"); // NOI18N
        tabAppPersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabAppPersonalInfo.add(panelPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, -1, 190));
        tabAppPersonalInfo.add(addEditPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 192, -1, -1));

        tabDetails.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabDetails.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tabEmployment.setName("tabEmployment"); // NOI18N
        tabEmployment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabEmployment.add(panelEmploymentData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabEmployment.add(addEditEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        tabDetails.addTab("Employment", tabEmployment);

        tabFamily.setName("tabFamily"); // NOI18N
        tabFamily.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabFamily.add(panelFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabFamily.add(addEditFamily, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 165, -1, -1));

        tabDetails.addTab("Family", tabFamily);

        tabSibling.setName("tabSibling"); // NOI18N
        tabSibling.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabSibling.add(panelSibling, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        tabSibling.add(addEditSibling, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 185, -1, -1));

        tabDetails.addTab("Siblings", tabSibling);

        tabCharacterRef.setName("tabCharacterRef"); // NOI18N
        tabCharacterRef.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCharacterRef.add(panelCharacterReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        tabCharacterRef.add(addEditCharacterReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        tabDetails.addTab("Char Ref", tabCharacterRef);

        tabDependent.setName("tabDependent"); // NOI18N
        tabDependent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabDependent.add(addEditDependents, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));
        tabDependent.add(panelDependents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 620, -1));

        tabDetails.addTab("Dependents", tabDependent);

        tabCreditRef.setName("tabCreditRef"); // NOI18N
        tabCreditRef.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCreditRef.add(panelCreditReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        tabCreditRef.add(addEditCreditReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 240, -1, -1));

        tabDetails.addTab("Credit Ref", tabCreditRef);

        tabSourceOfInc.setName("tabSourceOfInc"); // NOI18N
        tabSourceOfInc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabSourceOfInc.add(panelSourceOfIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        tabSourceOfInc.add(addEditSourceOfInc, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        lblAvgMonthlyIncomeForOtherSources.setText("Total Monthly Income");
        tabSourceOfInc.add(lblAvgMonthlyIncomeForOtherSources, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        txtTotalMonthlyIncome.setEditable(false);
        txtTotalMonthlyIncome.setFocusable(false);
        tabSourceOfInc.add(txtTotalMonthlyIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 285, 127, -1));

        tabDetails.addTab("Src. of Inc", tabSourceOfInc);

        tabExpenditure.setName("tabExpenditure"); // NOI18N
        tabExpenditure.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabExpenditure.add(panelExpenditures, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabExpenditure.add(addEditExpenditures, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        tabDetails.addTab("Expenditure", tabExpenditure);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabAsset.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tabAssetLand.setName("tabAssetLand"); // NOI18N
        tabAssetLand.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabAssetLand.add(panelLandAssets, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 970, 150));
        tabAssetLand.add(addEditLandAssets, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        tabAsset.addTab("Land", tabAssetLand);

        tabAssetVehicle.setName("tabAssetVehicle"); // NOI18N
        tabAssetVehicle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabAssetVehicle.add(panelVehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabAssetVehicle.add(addEditVehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        tabAsset.addTab("Vehicle", tabAssetVehicle);

        tabAssetAppliance.setName("tabAssetAppliance"); // NOI18N
        tabAssetAppliance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabAssetAppliance.add(panelAppliance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabAssetAppliance.add(addEditAppliance, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        tabAsset.addTab("Appliances", tabAssetAppliance);

        tabAssetMachinery.setName("tabAssetMachinery"); // NOI18N
        tabAssetMachinery.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabAssetMachinery.add(panelMachinery, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabAssetMachinery.add(addEditMachinery, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 235, -1, -1));

        tabAsset.addTab("Machinery", tabAssetMachinery);

        jPanel10.add(tabAsset, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 290));

        tabDetails.addTab("Assets", jPanel10);

        tabAddress.setName("tabAddress"); // NOI18N
        tabAddress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabAddress.add(panelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        tabAddress.add(addEditChangeAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        tabDetails.addTab("Address", tabAddress);

        tabPO.setName("tabPO"); // NOI18N
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

        tabDetails.addTab("P.O.", tabPO);

        tabID.setName("tabID"); // NOI18N
        tabID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabID.add(panelRidersToBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, -1, -1));
        tabID.add(addEditIdentification, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        tabDetails.addTab("ID", tabID);

        tabAppPersonalInfo.add(tabDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 1020, 360));

        tabMain.addTab("Applicant Personal Information", tabAppPersonalInfo);

        tabSpousePersonalInfo.setName("tabSpousePersonalInfo"); // NOI18N
        tabSpousePersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabSpousePersonalInfo.add(panelSpousePersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tabSpouseEmployment.setName("tabSpouseEmployment"); // NOI18N
        tabSpouseEmployment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabSpouseEmployment.add(panelSpouseEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabSpouseEmployment.add(addEditSpouseEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        jTabbedPane3.addTab("Employment", tabSpouseEmployment);

        tabSpouseFamily.setName("tabSpouseFamily"); // NOI18N
        tabSpouseFamily.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabSpouseFamily.add(panelSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabSpouseFamily.add(addEditSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        jTabbedPane3.addTab("Family", tabSpouseFamily);

        tabSpouseAddress.setName("tabSpouseAddress"); // NOI18N
        tabSpouseAddress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabSpouseAddress.add(panelSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        tabSpouseAddress.add(addEditChangeSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        jTabbedPane3.addTab("Address", tabSpouseAddress);

        tabSpouseID.setName("tabSpouseID"); // NOI18N
        tabSpouseID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabSpouseID.add(panelSpouseRidersToBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, -1, -1));
        tabSpouseID.add(addEditSpouseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jTabbedPane3.addTab("Identification", tabSpouseID);

        tabSpousePersonalInfo.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 1020, 350));
        tabSpousePersonalInfo.add(addEditSpousePersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 195, -1, -1));

        tabMain.addTab("Spouse Information", tabSpousePersonalInfo);

        tabCoMaker.setName("tabCoMaker"); // NOI18N
        tabCoMaker.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tabCoMaker.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 1000, 100));

        tabDetail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tabCoMakerPersonalInfo.setName("tabCoMakerPersonalInfo"); // NOI18N
        tabCoMakerPersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerPersonalInfo.add(panelCoMakerPersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, -1, -1));
        tabCoMakerPersonalInfo.add(addEditCoMakerPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        tabDetail.addTab("Personal Info", tabCoMakerPersonalInfo);

        tabCoMakerEmployment.setName("tabCoMakerEmployment"); // NOI18N
        tabCoMakerEmployment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerEmployment.add(panelCoMakerEmploymentData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabCoMakerEmployment.add(addEditCoMakerEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, -1, -1));

        tabDetail.addTab("Employment", tabCoMakerEmployment);

        tabCoMakerFamily.setName("tabCoMakerFamily"); // NOI18N
        tabCoMakerFamily.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerFamily.add(panelCoMakerFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabCoMakerFamily.add(addEditCoMakerFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 215, -1, -1));

        tabDetail.addTab("Family", tabCoMakerFamily);

        tabCoMakerSourceOfIncome.setName("tabCoMakerSourceOfIncome"); // NOI18N
        tabCoMakerSourceOfIncome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerSourceOfIncome.add(panelCoMakerSourceOfIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabCoMakerSourceOfIncome.add(addEditCoMakerSourceOfIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        tabDetail.addTab("Source of Income", tabCoMakerSourceOfIncome);

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tabCoMakerSpousePersonalInfo.setName("tabCoMakerSpousePersonalInfo"); // NOI18N
        tabCoMakerSpousePersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerSpousePersonalInfo.add(panelCoMakerSpousePersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(-11, 0, -1, -1));
        tabCoMakerSpousePersonalInfo.add(addEditCoMakerSpousePersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 210, -1, -1));

        jTabbedPane5.addTab("Personal Info", tabCoMakerSpousePersonalInfo);

        tabCoMakerSpouseEmployment.setName("tabCoMakerSpouseEmployment"); // NOI18N
        tabCoMakerSpouseEmployment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerSpouseEmployment.add(panelCoMakerSpouseEmploymentData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabCoMakerSpouseEmployment.add(addEditCoMakerSpouseEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jTabbedPane5.addTab("Employment", tabCoMakerSpouseEmployment);

        tabCoMakerSpouseFamily.setName("tabCoMakerSpouseFamily"); // NOI18N
        tabCoMakerSpouseFamily.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerSpouseFamily.add(panelCoMakerSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));
        tabCoMakerSpouseFamily.add(addEditCoMakerSpouseFamilyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jTabbedPane5.addTab("Family", tabCoMakerSpouseFamily);

        tabCoMakerSpouseAddress.setName("tabCoMakerSpouseAddress"); // NOI18N
        tabCoMakerSpouseAddress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerSpouseAddress.add(panelCoMakerSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        tabCoMakerSpouseAddress.add(addEditChangeCoMakerSpouseAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        jTabbedPane5.addTab("Address", tabCoMakerSpouseAddress);

        jPanel23.add(jTabbedPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 400));

        tabDetail.addTab("Spouse Information", jPanel23);

        tabCoMakerAddress.setName("tabCoMakerAddress"); // NOI18N
        tabCoMakerAddress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerAddress.add(panelCoMakerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));
        tabCoMakerAddress.add(addEditChangeCoMakerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        tabDetail.addTab("Address", tabCoMakerAddress);

        tabCoMakerID.setName("tabCoMakerID"); // NOI18N
        tabCoMakerID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabCoMakerID.add(panelCoMakerRidersToBuyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, -1, -1));
        tabCoMakerID.add(addEditCMID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        tabDetail.addTab("Identification", tabCoMakerID);

        tabCoMaker.add(tabDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1030, 440));

        tabMain.addTab("Co-Maker", tabCoMaker);

        add(tabMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 85, 1040, 630));
        add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 0, 1070, -1));
        add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 85, -1, 630));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new WaitSplashScreen(null, true, this, "PURCHASE ORDER").getThisDlg();
    }//GEN-LAST:event_btnPrintActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditAppliance;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCMID;
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
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditIdentification;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditLandAssets;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditMachinery;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditPO;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditPersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSibling;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSourceOfInc;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSpouseEmployment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSpouseFamilyBackground;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSpouseID;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditSpousePersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditVehicle;
    private javax.swing.JButton btnPrint;
    private java.util.List<PersonalInfo> comakers;
    private com.vg.scfc.financing.cis.ui.reusable.HeaderPanel headerPanel;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
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
    private javax.swing.JPanel tabAddress;
    private javax.swing.JPanel tabAppPersonalInfo;
    private javax.swing.JTabbedPane tabAsset;
    private javax.swing.JPanel tabAssetAppliance;
    private javax.swing.JPanel tabAssetLand;
    private javax.swing.JPanel tabAssetMachinery;
    private javax.swing.JPanel tabAssetVehicle;
    private javax.swing.JPanel tabCharacterRef;
    private javax.swing.JPanel tabCoMaker;
    private javax.swing.JPanel tabCoMakerAddress;
    private javax.swing.JPanel tabCoMakerEmployment;
    private javax.swing.JPanel tabCoMakerFamily;
    private javax.swing.JPanel tabCoMakerID;
    private javax.swing.JPanel tabCoMakerPersonalInfo;
    private javax.swing.JPanel tabCoMakerSourceOfIncome;
    private javax.swing.JPanel tabCoMakerSpouseAddress;
    private javax.swing.JPanel tabCoMakerSpouseEmployment;
    private javax.swing.JPanel tabCoMakerSpouseFamily;
    private javax.swing.JPanel tabCoMakerSpousePersonalInfo;
    private javax.swing.JPanel tabCreditRef;
    private javax.swing.JPanel tabDependent;
    private javax.swing.JTabbedPane tabDetail;
    private javax.swing.JTabbedPane tabDetails;
    private javax.swing.JPanel tabEmployment;
    private javax.swing.JPanel tabExpenditure;
    private javax.swing.JPanel tabFamily;
    private javax.swing.JPanel tabID;
    private javax.swing.JTabbedPane tabMain;
    private javax.swing.JPanel tabPO;
    private javax.swing.JPanel tabSibling;
    private javax.swing.JPanel tabSourceOfInc;
    private javax.swing.JPanel tabSpouseAddress;
    private javax.swing.JPanel tabSpouseEmployment;
    private javax.swing.JPanel tabSpouseFamily;
    private javax.swing.JPanel tabSpouseID;
    private javax.swing.JPanel tabSpousePersonalInfo;
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
        if (result == null) {
            throw new Exception();
        } else {
            return result;
        }
    }

    public PersonalInformationPanel getPanelPersonalInfo() {
        return panelPersonalInfo;
    }

    public AddressPanel getPanelAddress() {
        return panelAddress;
    }

    public AppliancesPanel getPanelAppliance() {
        return panelAppliance;
    }

    public CharacterReferenceDependentPanel getPanelCharacterReference() {
        return panelCharacterReference;
    }

    public AddressPanel getPanelCoMakerAddress() {
        return panelCoMakerAddress;
    }

    public EmploymentDataPanel getPanelCoMakerEmploymentData() {
        return panelCoMakerEmploymentData;
    }

    public FamilyBackgroundPanel getPanelCoMakerFamilyBackground() {
        return panelCoMakerFamilyBackground;
    }

    public PersonalInformationPanel getPanelCoMakerPersonalInformation() {
        return panelCoMakerPersonalInformation;
    }

    public RidersToBuyerPanel getPanelCoMakerRidersToBuyer() {
        return panelCoMakerRidersToBuyer;
    }

    public SourceOfIncomePanel getPanelCoMakerSourceOfIncome() {
        return panelCoMakerSourceOfIncome;
    }

    public AddressPanel getPanelCoMakerSpouseAddress() {
        return panelCoMakerSpouseAddress;
    }

    public EmploymentDataPanel getPanelCoMakerSpouseEmploymentData() {
        return panelCoMakerSpouseEmploymentData;
    }

    public FamilyBackgroundPanel getPanelCoMakerSpouseFamilyBackground() {
        return panelCoMakerSpouseFamilyBackground;
    }

    public PersonalInformationPanel getPanelCoMakerSpousePersonalInformation() {
        return panelCoMakerSpousePersonalInformation;
    }

    public CreditReferencePanel getPanelCreditReference() {
        return panelCreditReference;
    }

    public DependentPanel getPanelDependents() {
        return panelDependents;
    }

    public EmploymentDataPanel getPanelEmploymentData() {
        return panelEmploymentData;
    }

    public ExpendituresPanel getPanelExpenditures() {
        return panelExpenditures;
    }

    public FamilyBackgroundPanel getPanelFamilyBackground() {
        return panelFamilyBackground;
    }

    public LandPanel getPanelLandAssets() {
        return panelLandAssets;
    }

    public MachineryPanel getPanelMachinery() {
        return panelMachinery;
    }

    public PurchaseOrderPanel2 getPanelPO() {
        return panelPO;
    }

    public RidersToBuyerPanel getPanelRidersToBuyer() {
        return panelRidersToBuyer;
    }

    public SiblingsPanel getPanelSibling() {
        return panelSibling;
    }

    public SourceOfIncomePanel getPanelSourceOfIncome() {
        return panelSourceOfIncome;
    }

    public AddressPanel getPanelSpouseAddress() {
        return panelSpouseAddress;
    }

    public EmploymentDataPanel getPanelSpouseEmployment() {
        return panelSpouseEmployment;
    }

    public FamilyBackgroundPanel getPanelSpouseFamilyBackground() {
        return panelSpouseFamilyBackground;
    }

    public PersonalInformationPanel getPanelSpousePersonalInfo() {
        return panelSpousePersonalInfo;
    }

    public RidersToBuyerPanel getPanelSpouseRidersToBuyer() {
        return panelSpouseRidersToBuyer;
    }

    public VehiclePanel getPanelVehicle() {
        return panelVehicle;
    }
}
