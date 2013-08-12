/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.reusable;

import com.vg.scfc.financing.cis.ent.CharacterReference;
import com.vg.scfc.financing.cis.ui.controller.CharacterReferenceDependentController;
import com.vg.scfc.financing.cis.ui.validator.UIValidator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author rodel
 */
public class CharacterReferenceDependentPanel extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form CharacterReferencePanel
     */
    public CharacterReferenceDependentPanel() {
        initComponents();
        startUpSettings();
    }

    private void initTableCharacterReference() {
        if (tableCharacterRef != null) {
            tableCharacterRef.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tableCharacterRef.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    try {
                        selectedIndex = tableCharacterRef.getSelectedRow();
                        if (selectedIndex >= 0) {
                            setCharacterReference(characterReferences.get(selectedIndex));
                        }
                    } catch (Exception e) {
                        UIValidator.log(e, CharacterReferenceDependentPanel.class);
                    }
                }
            });
        }
    }

    /**
     * Set TextBoxes KeyListener
     */
    private void initTextBoxesListener() {
        txtRefName.addKeyListener(this);
        txtRefAddress.addKeyListener(this);
        txtRefContact.addKeyListener(this);
        txtRefRelationship.addKeyListener(this);
    }

    private void startUpSettings() {
        setFieldsEditable(false);
        initTextBoxesListener();
        initTableCharacterReference();
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

        characterReferences = ObservableCollections.observableList(new LinkedList<CharacterReference>());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRefContact = new javax.swing.JTextField();
        txtRefAddress = new javax.swing.JTextField();
        txtRefName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRefRelationship = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCharacterRef = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 105, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Address");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Contact");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 155, -1, -1));

        txtRefContact.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtRefContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRefContactFocusLost(evt);
            }
        });
        add(txtRefContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 140, -1));

        txtRefAddress.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtRefAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRefAddressFocusLost(evt);
            }
        });
        add(txtRefAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 125, 255, -1));

        txtRefName.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtRefName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRefNameFocusLost(evt);
            }
        });
        add(txtRefName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 255, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Relationship");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, -1, -1));

        txtRefRelationship.setFont(new java.awt.Font("Monospaced", 0, 9)); // NOI18N
        txtRefRelationship.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRefRelationshipFocusLost(evt);
            }
        });
        add(txtRefRelationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 175, 140, -1));

        tableCharacterRef.setColumnSelectionAllowed(true);
        tableCharacterRef.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, characterReferences, tableCharacterRef);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${charRefName}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${charRelationship}"));
        columnBinding.setColumnName("Relationship");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${charRefContactNo}"));
        columnBinding.setColumnName("Contact #");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tableCharacterRef);
        tableCharacterRef.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 600, 90));

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRefNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRefNameFocusLost
        name = UIValidator.validate(txtRefName);
    }//GEN-LAST:event_txtRefNameFocusLost

    private void txtRefAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRefAddressFocusLost
        address = UIValidator.validate(txtRefAddress);
    }//GEN-LAST:event_txtRefAddressFocusLost

    private void txtRefContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRefContactFocusLost
        contact = UIValidator.isNumeric(txtRefContact);
    }//GEN-LAST:event_txtRefContactFocusLost

    private void txtRefRelationshipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRefRelationshipFocusLost
        relationship = UIValidator.validate(txtRefRelationship);
    }//GEN-LAST:event_txtRefRelationshipFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<CharacterReference> characterReferences;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableCharacterRef;
    private javax.swing.JTextField txtRefAddress;
    private javax.swing.JTextField txtRefContact;
    private javax.swing.JTextField txtRefName;
    private javax.swing.JTextField txtRefRelationship;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private String name;
    private String address;
    private String contact;
    private String relationship;
    private JTable tableDependent;
    private int selectedIndex;
    private CharacterReference characterReference;
    private HeaderPanel headerPanel;

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public void setCharacterReference(CharacterReference characterReference) {
        this.characterReference = characterReference;
    }

    public void setTableCharacterRef(JTable tableCharacterRef) {
        this.tableCharacterRef = tableCharacterRef;
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
                if (txtRefName.isFocusOwner()) {
                txtRefAddress.requestFocus();
            } else if (txtRefAddress.isFocusOwner()) {
                txtRefContact.requestFocus();
            } else if (txtRefContact.isFocusOwner()) {
                txtRefRelationship.requestFocus();
            }
                break;
            case KeyEvent.VK_UP:
                if (txtRefRelationship.isFocusOwner()) {
                txtRefContact.requestFocus();
            } else if (txtRefContact.isFocusOwner()) {
                txtRefAddress.requestFocus();
            } else if (txtRefAddress.isFocusOwner()) {
                txtRefName.requestFocus();
            }
                break;
        }
    }

    public void setFieldsEditable(boolean value) {
        txtRefName.setEditable(value);
        txtRefAddress.setEditable(value);
        txtRefContact.setEditable(value);
        txtRefRelationship.setEditable(value);
    }

    public void resetToDefault() {
        txtRefName.setText("");
        txtRefAddress.setText("");
        txtRefContact.setText("");
        txtRefRelationship.setText("");
    }

    public boolean saveCharacterReference() {
        List<CharacterReference> c = CharacterReferenceDependentController.getInstance().addCharacterReference(createNew(new CharacterReference()), headerPanel.getFormNo());
        refreshTableCharacterReference(c);
        return !c.isEmpty();
    }

    public boolean updateCharacterReference() {
        List<CharacterReference> c = CharacterReferenceDependentController.getInstance().updateCharacterReference(headerPanel.getFormNo(), createNew(characterReference));
        refreshTableCharacterReference(c);
        return !c.isEmpty();
    }

    public void setCharacterReference(Object o) {
        if (o == null) {
            resetToDefault();
        } else {
            CharacterReference chr = (CharacterReference) o;
            txtRefName.setText(chr.getCharRefName());
            txtRefAddress.setText(chr.getCharRefAddress());
            txtRefContact.setText(chr.getCharRefContactNo());
            txtRefRelationship.setText(chr.getCharRelationship());
        }
    }

    public void refreshTableCharacterReference(List<CharacterReference> c) {
        characterReferences.clear();
        characterReferences.addAll(c);
        if (!characterReferences.isEmpty()) {
            tableCharacterRef.setRowSelectionInterval(0, 0);
        }
    }

    private CharacterReference createNew(CharacterReference c) {
        c.setCharRefName(name);
        c.setCharRefAddress(address);
        c.setCharRefContactNo(contact);
        c.setCharRelationship(relationship);
        return c;
    }
}
