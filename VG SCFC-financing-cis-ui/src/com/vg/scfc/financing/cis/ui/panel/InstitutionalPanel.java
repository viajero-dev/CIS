/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.panel;

import com.vg.scfc.financing.cis.ui.listener.BasicActionListener;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;

/**
 *
 * @author rodel
 */
public class InstitutionalPanel extends javax.swing.JPanel {

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
    }
    
    private void initCompanyInfoAddEditListener() {
        addEditCompanyInfo.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelCompanyInformation.setFieldsEditable(true);
                panelCompanyInformation.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelCompanyInformation.saveCompanyInfo();
                if(!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
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
                panelCompanyInformation.setFieldsEditable(true);
            }

            @Override
            public boolean onSaveEdit() {
                boolean isUpdated = panelCompanyInformation.updateCompanyInfo();
                if(!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
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
        addEditRepresentative1PersonalInfo.setBasicActionListener(new BasicActionListener() {

             @Override
            public void onAdd() {
                panelRepresentative1PersonalInformation.setFieldsEditable(true);
                panelRepresentative1PersonalInformation.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative1PersonalInformation.savePersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
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
                boolean isUpdated = panelRepresentative1PersonalInformation.updatePersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                }
                return true;
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative1PersonalInformation.setFieldsEditable(false);
            }
        });
    }
    
    private void initRepresentative1EmploymentAddEditListener() {
        addEditRepresentative1Employment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative1Employment.setFieldsEditable(true);
                panelRepresentative1Employment.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative1Employment.saveEmployment();
                if(!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
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
                if(!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
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
        addEditRepresentative2PersonalInfo.setBasicActionListener(new BasicActionListener() {

             @Override
            public void onAdd() {
                panelRepresentative2PersonalInformation.setFieldsEditable(true);
                panelRepresentative2PersonalInformation.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative2PersonalInformation.savePersonalInfo();
                if (!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
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
                boolean isUpdated = panelRepresentative2PersonalInformation.updatePersonalInfo();
                if (!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
                }
                return true;
            }

            @Override
            public void onCancelEdit() {
                panelRepresentative2PersonalInformation.setFieldsEditable(false);
            }
        });
    }
    
    private void initRepresentative2EmploymentAddEditListener() {
        addEditRepresentative2Employment.setBasicActionListener(new BasicActionListener() {

            @Override
            public void onAdd() {
                panelRepresentative2Employment.setFieldsEditable(true);
                panelRepresentative2Employment.resetToDefault();
            }

            @Override
            public boolean onSaveAdd() {
                boolean isSaved = panelRepresentative2Employment.saveEmployment();
                if(!isSaved) {
                    UIValidator.promptErrorMessageOn("SAVE");
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
                if(!isUpdated) {
                    UIValidator.promptErrorMessageOn("EDIT");
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelCompanyInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(addEditCompanyInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(panelRepresentative1PersonalInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));
        jPanel3.add(addEditRepresentative1PersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 200, -1, -1));

        jTabbedPane2.addTab("Personal Information", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(addEditRepresentative1Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        jPanel4.add(panelRepresentative1Employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.addTab("Employment Data", jPanel4);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 310));

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

        jPanel2.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 310));

        jTabbedPane1.addTab("2nd Representative", jPanel2);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 180, 1030, 350));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditCompanyInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative1Employment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative1PersonalInfo;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative2Employment;
    private com.vg.scfc.financing.cis.ui.reusable.AddEditButtonPanel addEditRepresentative2PersonalInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private com.vg.scfc.financing.cis.ui.panel.CompanyInformationPanel panelCompanyInformation;
    private com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel panelRepresentative1Employment;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelRepresentative1PersonalInformation;
    private com.vg.scfc.financing.cis.ui.panel.EmploymentRepresentativePanel panelRepresentative2Employment;
    private com.vg.scfc.financing.cis.ui.reusable.PersonalInformationPanel panelRepresentative2PersonalInformation;
    // End of variables declaration//GEN-END:variables
}
