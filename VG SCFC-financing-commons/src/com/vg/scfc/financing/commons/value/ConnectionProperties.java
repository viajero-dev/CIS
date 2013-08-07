/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.value;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author raffy
 */
public class ConnectionProperties {

    private static String server;
    private static String database;
    private static String userName;
    private static String passWord;
    private static boolean usingCentralDb;

    public static String getDatabase() {
        return database;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static String getServer() {
        return server;
    }

    public static String getUserName() {
        return userName;
    }

    public static boolean isUsingCentralDb() {
        return usingCentralDb;
    }

    public static void setDatabase(String database) {
        ConnectionProperties.database = database;
    }

    public static void setPassWord(String passWord) {
        ConnectionProperties.passWord = passWord;
    }

    public static void setServer(String server) {
        ConnectionProperties.server = server;
    }

    public static void setUserName(String userName) {
        ConnectionProperties.userName = userName;
    }

    public static void setUsingCentralDb(boolean usingCentralDb) {
        ConnectionProperties.usingCentralDb = usingCentralDb;
    }

    public static void setupConnection() {
        try {
            //load a properties file
            Properties prop = new Properties();
            EncryptorDecryptorMgr edm = new EncryptorDecryptorMgr();
            prop.load(new FileInputStream("src" + File.separator + "conn.properties"));

            //get the property value and print it out
            setServer(edm.decrypt(prop.getProperty("vg.server")));
            setDatabase(edm.decrypt(prop.getProperty("vg.database")));
            setUserName(edm.decrypt(prop.getProperty("vg.username")));
            setPassWord(edm.decrypt(prop.getProperty("vg.password")));
            setUsingCentralDb((edm.decrypt(prop.getProperty("vg.usingcentralDb")).equals("true") ? true : false));
        } catch (IOException ex) {
        }
    }

    public static void setupConnection(String server, String database,
            String userName, String passWord, boolean usingCentralDb) {
        setServer(server);
        setDatabase(database);
        setUserName(userName);
        setPassWord(passWord);
        setUsingCentralDb(usingCentralDb);
    }
}
