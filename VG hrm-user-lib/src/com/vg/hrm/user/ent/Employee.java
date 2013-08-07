/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.hrm.user.ent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author raffy
 */
@Entity
@Table(name = "hrm_empinfo", catalog="vgdb")
public class Employee implements Serializable {    
    
    private String id;
    
    private String lastname;
    
    private String firstname;
    
    private String middlename;
    
    private String nickname;
    
    private boolean locked;
    
    private boolean voided;

    
    public Employee() {}
    
    
    //**************************************************************************
    //GETTERS
    @Id
    @Column(name = "cEmpNo")
    public String getId() { return id.toUpperCase(); }
    
    @Column(name = "cLastName")
    public String getLastname() { return lastname; }
    
    @Column(name = "cMiddle")
    public String getMiddlename() { return middlename; }
    
    @Column(name = "cNickName")
    public String getNickname() { return nickname; }
    
    @Column(name = "lisLocked")
    public boolean isLocked() { return locked; }
    
    @Column(name = "lvoid")
    public boolean isVoided() { return voided; }
    
    @Column(name = "cFirstName")
    public String getFirstname() { return firstname; }
    //END OF GETTERS
    //**************************************************************************

    
    //**************************************************************************
    //SETTERS
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setId(String id) { this.id = id; }
    
    public void setLastname(String lastname) { this.lastname = lastname; }
    
    public void setLocked(boolean locked) { this.locked = locked; }
    
    public void setMiddlename(String middlename) { this.middlename = middlename; }
    
    public void setNickname(String nickname) { this.nickname = nickname; }
    
    public void setVoided(boolean voided) { this.voided = voided; }
    //END OF SETTERS
    //**************************************************************************
    
    
    @Transient public String getFullName() {
        String fullName = (lastname + ", " + firstname + " " + ((middlename.isEmpty()) ? "" : (middlename.charAt(0) + "."))).toUpperCase() ;        
        return fullName;        
    }
    @Transient public String getProperName() {
        String properName = (firstname + " " + ((middlename.isEmpty()) ? "" : (middlename.charAt(0) + ". ")) + lastname).toUpperCase();        
        return properName;        
    }
    @Transient public String getInitials() {
        String initials = (firstname.charAt(0) + "" + ((middlename.isEmpty()) ? "" : (middlename.charAt(0))) + lastname.charAt(0)).toUpperCase();        
        return initials;        
    }
    
    @Override public String toString() { return getProperName(); }
}
