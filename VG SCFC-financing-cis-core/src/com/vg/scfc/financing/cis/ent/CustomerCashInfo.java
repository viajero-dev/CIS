/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.service.AuditTrailService;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author raffy
 */

@Entity
@Table(name="customerCashInfo")
public class CustomerCashInfo implements Serializable, AuditTrailService, LiveUpdateService {
    
    private String clientNo;
    private String lastName;
    private String firstName;
    private String middleName;
    private String barangayCode;
    private String barangayDescription;
    private String address;
    private String contactNo;
    private boolean person;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="cAddress")
    public String getAddress() {
        return address;
    }

    @Column(name="cBrgyCode")
    public String getBarangayCode() {
        return barangayCode;
    }

    @Column(name="cBrgyDesc")
    public String getBarangayDescription() {
        return barangayDescription;
    }

    @Id
    @Column(name="cClientNo")
    public String getClientNo() {
        return clientNo;
    }

    @Column(name="cContactNo")
    public String getContactNo() {
        return contactNo;
    }

    @Column(name="cFirstName")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="cLastName")
    public String getLastName() {
        return lastName;
    }

    @Column(name="cMiddleName")
    public String getMiddleName() {
        return middleName;
    }

    @Column(name="lPerson")
    public boolean isPerson() {
        return person;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    
    @Transient
    public String getProperName() {
        if(isPerson())
            return getLastName() + ", " + getFirstName() + " " + getMiddleName();
        else
            return getLastName();
    }
    
    @Transient
    public String getFullName() {
        if(isPerson()) 
            return getFirstName() + (getMiddleName() != null ? (getMiddleName().substring(0, 1) + ". ") : " ") + getLastName();
        else
            return getLastName();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setAddress(String address) {
        this.address = address;
    }

    public void setBarangayCode(String barangayCode) {
        this.barangayCode = barangayCode;
    }

    public void setBarangayDescription(String barangayDescription) {
        this.barangayDescription = barangayDescription;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPerson(boolean person) {
        this.person = person;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("clientNo:").append(getClientNo())
          .append("^lastName:").append(getLastName())
          .append("^firstName:").append(getFirstName())
          .append("^middleName:").append(getMiddleName())
          .append("^barangayCode:").append(getBarangayCode())
          .append("^barangayDescription:").append(getBarangayDescription())
          .append("^address:").append(getAddress())
          .append("^contactNo:").append(getContactNo())
          .append("^person:").append(isPerson());
        return sb.toString();
    }
    
    private String station;
    public void setStation(String station) {
        this.station = station;
    }

    @Transient
    @Override
    public String getStation() {
        return this.station.trim();
    }

    @Transient
    @Override
    public String getTransNo() {
        return getClientNo();
    }

    @Transient
    @Override
    public String getActionTarget() {
        return "";
    }

    @Transient
    @Override
    public String getSystemName() {
        return "CIS";
    }
    
    private Employee user;
    public void setUser(Employee employee) {
        this.user = employee;
    }

    @Transient
    @Override
    public Employee getUser() {
        return this.user;
    }
    
    private Location location;
    public void setLocation(Location location) {
        this.location = location;
    }
    
    @Transient
    public Location getLocation() {
        return location;
    }
    //END AUDIT TRAIL **********************************************************

    //LIVEUPDATE ***************************************************************
    @Transient
    @Override
    public String getDetailForSql() {
        return ("customerCashInfo" +
               "$#~cClientNo~" + getClientNo() +"~S" +
               "$cAddress~" + getAddress() + "~S" +
               "$cBrgyCode~" + getBarangayCode() + "~S" + 
               "$cBrgyDesc~" + getBarangayDescription() + "~S" +
               "$cContactNo~" + getContactNo() + "~S" +
               "$cFirstName~" + getFirstName() + "~S" +
               "$cLastName~" + getLastName() + "~S" +
               "$cMiddleName~" + getMiddleName() + "~S" +
               "$lPerson~" + isPerson() + "~B").replace("'", " ");        
    }

    @Transient
    @Override
    public boolean isSpecialTransaction() {
        return false;
    }

    @Transient
    @Override
    public String getBranchCode() {
        return "V001";
    }
    //END LIVEUPDATE ***********************************************************
}
