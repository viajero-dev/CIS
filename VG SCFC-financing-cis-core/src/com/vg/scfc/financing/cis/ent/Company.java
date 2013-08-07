/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.commons.util.DateUtil;
import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.service.AuditTrailService;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author raffy
 */

@Entity
@Table(name="company")
public class Company implements Serializable, AuditTrailService, LiveUpdateService {
    
    private String txFormNo;
    private String president;
    private String address;
    private String natureOfBusiness;
    private int yearOfService;
    private String tin;
    private String businessPermitNo;
    private String contactNo;
    private String email;
    private Date issuedDate;
    private Date expirationDate;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="cAddress")
    public String getAddress() {
        return address;
    }

    @Column(name="cPermitNo")
    public String getBusinessPermitNo() {
        return businessPermitNo;
    }

    @Column(name="cContactNo")
    public String getContactNo() {
        return contactNo;
    }

    @Column(name="cEmail")
    public String getEmail() {
        return email;
    }

    @Column(name="dExpirationDate")
    @Temporal(TemporalType.DATE)
    public Date getExpirationDate() {
        return expirationDate;
    }

    @Column(name="dIssuedDate")
    @Temporal(TemporalType.DATE)
    public Date getIssuedDate() {
        return issuedDate;
    }

    @Column(name="cNature")
    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    @Column(name="cPresident")
    public String getPresident() {
        return president;
    }

    @Column(name="cTin")
    public String getTin() {
        return tin;
    }

    @Id
    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    @Column(name="nYearOfService")
    public int getYearOfService() {
        return yearOfService;
    }

    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setAddress(String address) {
        this.address = address;
    }

    public void setBusinessPermitNo(String businessPermitNo) {
        this.businessPermitNo = businessPermitNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
    }

    public void setYearOfService(int yearOfService) {
        this.yearOfService = yearOfService;
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
        sb.append("txFormNo:").append(getTxFormNo())
          .append("^president:").append(getPresident())
          .append("^address:").append(getAddress())
          .append("^natureOfBusiness:").append(getNatureOfBusiness())
          .append("^yearOfService:").append(getYearOfService())
          .append("^tin:").append(getTin())
          .append("^businessPermitNo:").append(getBusinessPermitNo())
          .append("^contactNo:").append(getContactNo())
          .append("^email:").append(getEmail())
          .append("^issuedDate:").append((getIssuedDate() != null) ? DateUtil.toString(getIssuedDate(), "yyyy-MM-dd") : getIssuedDate())
          .append("^expirationDate:").append((getExpirationDate() != null) ? DateUtil.toString(getExpirationDate(), "yyyy-MM-dd") : getExpirationDate());
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
        return getTxFormNo();
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
        return ("company" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$cAddress~" + getAddress() + "~S" + 
               "$cPermitNo~" + getBusinessPermitNo() + "~S" +
               "$cContactNo~" + getContactNo() + "~S" +
               "$dExpirationDate~" + ((getExpirationDate() != null) ? (DateUtil.toString(getExpirationDate(), "yyyy-MM-dd") + "~D") : (getExpirationDate() + "~N")) +
               "$dIssuedDate~" + ((getIssuedDate() != null) ? (DateUtil.toString(getIssuedDate(), "yyyy-MM-dd") + "~D") : (getIssuedDate() + "~N")) +
               "$cNature~" + getNatureOfBusiness() + "~S" +
               "$cPresident~" + getPresident() + "~S" +
               "$cTin~" + getTin() + "~S" + 
               "$nYearOfService~" + getYearOfService() + "~N").replace("'", " "); 
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
