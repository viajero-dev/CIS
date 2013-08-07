/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.hrm.user.ent;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import sun.misc.BASE64Encoder;

/**
 *
 * @author raffy
 */
@Entity
@Table(name = "hrm_users", catalog="vgdb")
public class User implements Serializable {
    
    private String id; // this is the username
    
    private String password;    
    
    private String newPassword;
    
    private String privilege;   // PUSR, ADMI, USER 

    
    //**************************************************************************
    //GETTERS
    @Id
    @Column(name = "cUserID")
    public String getId() { return id; }
    
    @Column(name = "cPassWord")
    public String getPassword() { return password; } 
    
    @Column(name = "cNewPassword", length = 24)
    public String getNewPassword() { return newPassword; }
    
    @Column(name = "cUserLevel")
    public String getPrivilege() { return privilege; } 
    //END OF GETTERS
    //**************************************************************************
    
    
    //**************************************************************************
    //SETTERS
    public void setId(String id) { this.id = id; }
    
    public void setPassword(String password) { this.password = password; }
    
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }  
    
    public void setPrivilege(String privilege) { this.privilege = privilege; }    
    //END OF SETTERS
    //**************************************************************************
    
    // CALL:  encrypt("inputPassword", "MD5", "UTF-8"));
    public static String encrypt(String plainPassword,
            String algorithm, String encoding) throws Exception {
        MessageDigest msgDigest = null;
        String hashValue = null;
        try {
            msgDigest = MessageDigest.getInstance(algorithm);
            msgDigest.update(plainPassword.getBytes(encoding));
            byte rawByte[] = msgDigest.digest();
            hashValue = (new BASE64Encoder()).encode(rawByte);             
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
        } catch (UnsupportedEncodingException e) {
            System.out.println("The Encoding Is Not Supported");
        }
        return hashValue;
    }
    
    // encryptedInputPassword = User.encrypt("inputPassword", "MD5", "UTF-8"));
    public boolean isValidPassword(String inputPassword) {
        String encryptedInputPassword = null;
        try {
            encryptedInputPassword = User.encrypt(inputPassword, "MD5", "UTF-8");
        } catch (Exception ex) {}
        return newPassword.equals(encryptedInputPassword);
    }
    
}
