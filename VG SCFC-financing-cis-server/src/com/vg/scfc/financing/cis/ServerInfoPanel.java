/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServerInfoPanel.java
 *
 * Created on 08 8, 13, 6:17:27 PM
 */
package com.vg.scfc.financing.cis;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class ServerInfoPanel extends javax.swing.JPanel {

    /** Creates new form ServerInfoPanel */
    public ServerInfoPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIP = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bthExit = new javax.swing.JButton();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(lblIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 15));
        add(lblPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 150, 15));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 10)); // NOI18N
        jLabel2.setText("IP        :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 10)); // NOI18N
        jLabel3.setText("Port      :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, -1));

        bthExit.setFont(new java.awt.Font("Monospaced", 1, 10)); // NOI18N
        bthExit.setText("Exit");
        bthExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthExitActionPerformed(evt);
            }
        });
        add(bthExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 220, -1));
    }// </editor-fold>//GEN-END:initComponents

private void bthExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthExitActionPerformed
    int choice = JOptionPane.showConfirmDialog(this, "Exit this server?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
}//GEN-LAST:event_bthExitActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthExit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblPort;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblIP() {
        return lblIP;
    }

    public JLabel getLblPort() {
        return lblPort;
    }

    
}
