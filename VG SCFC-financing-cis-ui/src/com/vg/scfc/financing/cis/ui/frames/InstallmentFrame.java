/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.frames;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author rodel
 */
public class InstallmentFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form InstallmentFrame
     */
    public InstallmentFrame() {
        super("INSTALLMENT", false, true, false, true);
        initComponents();
        installmentPanel.setOwner(getThisFrame());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        installmentPanel = new com.vg.scfc.financing.cis.ui.panel.InstallmentPanel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(installmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vg.scfc.financing.cis.ui.panel.InstallmentPanel installmentPanel;
    // End of variables declaration//GEN-END:variables
    private JDesktopPane owner;

    public JDesktopPane getOwner() {
        return owner;
    }

    public void setOwner(JDesktopPane owner) {
        this.owner = owner;
    }
    
    public final JInternalFrame getThisFrame() {
        return this;
    }

}
