/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis;

import com.vg.commons.util.EncryptorDecryptorMgr;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class SettingProperties {

    private String server;
    private int port;
    private static SettingProperties instance;

    public SettingProperties() {
        setupConnection();
    }

    public static SettingProperties getInstance() {
        if (instance == null) {
            instance = new SettingProperties();
        }
        return instance;
    }

    public int getPort() {
        return port;
    }

    public String getServer() {
        return server;
    }

    public void setupConnection() {
        try {
            //load a properties file
            Properties prop = new Properties();
            EncryptorDecryptorMgr edm = new EncryptorDecryptorMgr();
            prop.load(new FileInputStream("src" + File.separator + "cis.properties"));

            //get the property value and print it out
            server = prop.getProperty("cis.host");
            port = Integer.parseInt(prop.getProperty("cis.port"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "CIS Properties not found.", "File Not Found", JOptionPane.WARNING_MESSAGE);

        }
    }
}
