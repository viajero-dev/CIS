/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PictureReportPanel.java
 *
 * Created on Aug 19, 2013, 2:44:58 PM
 */
package com.vg.scfc.financing.cis.ui.panel;

import com.vg.commons.dlg.WaitSplashScreen;
import com.vg.commons.listener.DoJasperPrintReport;
import com.vg.scfc.financing.cis.ui.settings.UISetting;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import com.vg.scfc.financing.cis.value.PictureReport;
import com.vg.scfc.financing.commons.ent.Location;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperPrint;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author raffy
 */
public class PictureReportPanel extends javax.swing.JPanel implements KeyListener, DoJasperPrintReport {

    private List<Location> locations;
    private List<PictureReport> holder;
    private List<String> txFormNos = new ArrayList<>();
    private final KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    public void setDefault() {
        applicants.clear();
        txtSearch.setText("");
        cboxSelectAll.setSelected(false);
        cboxSelectAll.setEnabled(false);
        cboBranch.setSelectedItem(UISetting.getStoreLocation());
        txtFromDate.requestFocus();
    }

    private void renderTable(List<PictureReport> pictureReports) {
        applicants.clear();
        applicants.addAll(pictureReports);

        if (!applicants.isEmpty()) {
            cboxSelectAll.setEnabled(true);
            tblApplicants.setRowSelectionInterval(0, 0);
        } else {
            cboxSelectAll.setEnabled(false);
        }
    }

    private void setKeyListeners() {
        txtFromDate.addKeyListener(this);
        txtSearch.addKeyListener(this);
        txtToDate.addKeyListener(this);
        btnGenerate.addKeyListener(this);
        tblApplicants.addKeyListener(this);
        btnPrint.addKeyListener(this);
    }

    private void setComponents() {
        cboBranch.removeAllItems();
        try {
            locations = UISetting.getLocationService().findAll();
            for (Location location : locations) {
                cboBranch.addItem(location);
            }
        } catch (Exception ex) {
            UIValidator.log(ex, PictureReportPanel.class);
        }
    }

    private void generateApplicants() {
        try {
            holder = UISetting.getPrintReportService().findApplicantsForPicturePrinting((Location) cboBranch.getSelectedItem(), txtFromDate.getDate(), txtToDate.getDate());
        } catch (Exception e) {
            UIValidator.log(e, PictureReportPanel.class);
        }

        renderTable(holder);
    }

    private void selectAll() {
        for (PictureReport pictureReport : holder) {
            pictureReport.setSelected(cboxSelectAll.isSelected());
        }
        renderTable(holder);
    }

    private void searchApplicants() {
        List<PictureReport> temp = new ArrayList<>();
        try {
            String searchString = txtSearch.getText();
            if (!searchString.isEmpty()) {
                if (!holder.isEmpty()) {
                    for (PictureReport pictureReport : holder) {
                        if (pictureReport.getClientId().contains(searchString) || pictureReport.getTxFormNo().contains(searchString) || pictureReport.getName().contains(searchString)) {
                            temp.add(pictureReport);
                        }
                    }
                }
            }
        } catch (Exception e) {
            UIValidator.log(e, PictureReportPanel.class);
        }

        renderTable(temp);
    }

    private JasperPrint printPictures() {
        JasperPrint jasperPrint = null;
        txFormNos.clear();
        try {
            if (!holder.isEmpty()) {
                for (PictureReport a : holder) {
                    if (a.isSelected()) {
                        txFormNos.add(a.getTxFormNo());
                    }
                }
            }
            System.out.println("Selected report: " + txFormNos.size());
            jasperPrint = UISetting.getPrintReportService().printPicture(txFormNos);
        } catch (Exception e) {
            UIValidator.log(e, PictureReportPanel.class);
        }
        return jasperPrint;

    }

    private void initTable() {
        tblApplicants.putClientProperty("Quaqua.Table.style", "striped");
        tblApplicants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblApplicants.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                lblRecordIndex.setText(String.valueOf(tblApplicants.getSelectedRow() + 1) + "/" + applicants.size());
            }
        });

        scrApplicants.setBorder(new BevelBorder(BevelBorder.RAISED));
        tblApplicants.setBorder(new BevelBorder(BevelBorder.LOWERED));
    }

    /**
     * Creates new form PictureReportPanel
     */
    public PictureReportPanel() {
        initComponents();
        initTable();
        setComponents();
        setKeyListeners();
        txtSearch.putClientProperty("Quaqua.TextField.style", "search");
        txtSearch.setText("Search");
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

        applicants = ObservableCollections.observableList(new LinkedList<PictureReport>());
        scrApplicants = new javax.swing.JScrollPane();
        tblApplicants = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblRecordIndex = new javax.swing.JLabel();
        cboxSelectAll = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        try {
            txtFromDate = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        try {
            txtToDate = new com.vg.commons.formattedfields.FormattedSimpleDateField();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        }
        jLabel4 = new javax.swing.JLabel();
        cboBranch = new javax.swing.JComboBox();
        btnGenerate = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();

        tblApplicants.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, applicants, tblApplicants);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${selected}"));
        columnBinding.setColumnName("Select");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${txFormNo}"));
        columnBinding.setColumnName("Form #");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${clientId}"));
        columnBinding.setColumnName("Client ID");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrApplicants.setViewportView(tblApplicants);
        tblApplicants.getColumnModel().getColumn(0).setResizable(false);
        tblApplicants.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblApplicants.getColumnModel().getColumn(1).setResizable(false);
        tblApplicants.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblApplicants.getColumnModel().getColumn(2).setResizable(false);
        tblApplicants.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblApplicants.getColumnModel().getColumn(3).setResizable(false);
        tblApplicants.getColumnModel().getColumn(3).setPreferredWidth(440);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblRecordIndex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecordIndex.setText("0/0"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(581, Short.MAX_VALUE)
                .addComponent(lblRecordIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRecordIndex)
        );

        cboxSelectAll.setFont(new java.awt.Font("Dialog", 1, 10));
        cboxSelectAll.setText("SELECT ALL");
        cboxSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSelectAllActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFont(new java.awt.Font("Monospaced", 0, 10));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel1.setText("From");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel2.setText("Branch:");

        txtFromDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtToDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel4.setText("To");

        cboBranch.setFont(new java.awt.Font("Dialog", 1, 10));
        cboBranch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnGenerate)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate)
                    .addComponent(cboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel3.setText("Search:");

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrApplicants, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboxSelectAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxSelectAll)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrApplicants, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        generateApplicants();
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new WaitSplashScreen(null, true, this, "PRINT PICTURES").getThisDlg();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void cboxSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSelectAllActionPerformed
        selectAll();
    }//GEN-LAST:event_cboxSelectAllActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.selectAll();
    }//GEN-LAST:event_txtSearchFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<PictureReport> applicants;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox cboBranch;
    private javax.swing.JCheckBox cboxSelectAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblRecordIndex;
    private javax.swing.JScrollPane scrApplicants;
    private javax.swing.JTable tblApplicants;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtFromDate;
    private javax.swing.JTextField txtSearch;
    private com.vg.commons.formattedfields.FormattedSimpleDateField txtToDate;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (!tblApplicants.isFocusOwner()) {
                focusManager.focusNextComponent();
            } else if (txtSearch.isFocusOwner()) {
                searchApplicants();
            }
                break;
        }
    }

    @Override
    public JasperPrint printNow() throws Exception {
        JasperPrint jasperPrint = printPictures();
        if (jasperPrint == null) {
            throw new Exception();
        } else {
            return jasperPrint;
        }
    }
}
