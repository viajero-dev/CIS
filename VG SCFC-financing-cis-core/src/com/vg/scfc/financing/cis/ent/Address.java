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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author jp
 */
@Entity
@Table(name = "address")
public class Address implements Serializable, AuditTrailService, LiveUpdateService {

    private String addressId;
    private String clientNo;
    private String txFormNo;
    private PersonType personType;
    private int lineNo;
    private String brgyCode;
    private String brgyDesc;
    private String zipCode;
    private String address;
    private String description;
    private String sketch;
    private String status;
    private String yearsOfStay;
    private int version;

    //GETTERS ******************************************************************
    @Id
    @Column(name="cAddressId")
    public String getAddressId() {
        return addressId;
    }
    
    @Column(name = "cAddress")
    public String getAddress() {
        return address;
    }

    @Column(name = "cBrgyCode")
    public String getBrgyCode() {
        return brgyCode;
    }

    @Column(name = "cBrgyDesc")
    public String getBrgyDesc() {
        return brgyDesc;
    }

    @Column(name = "cDescription")
    public String getDescription() {
        return description;
    }

    @OneToOne
    @JoinColumn(name="cPersonTypeId")
    public PersonType getPersonType() {
        return personType;
    }

    @Column(name="cClientNo")
    public String getClientNo() {
        return clientNo;
    }

    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    @Column(name="nLineNo")
    public int getLineNo() {
        return lineNo;
    }

    @Column(name = "cSketch")
    public String getSketch() {
        return sketch;
    }

    @Column(name = "cZipCode")
    public String getZipCode() {
        return zipCode;
    }
    
    @Column(name="cStatus")
    public String getStatus() {
        return status;
    }

    @Column(name="cYearsOfStay")
    public String getYearsOfStay() {
        return yearsOfStay;
    }

    @Version
    @Column(name = "nVersion")
    public int getVersion() {
        return version;
    }
    //END GETTERS **************************************************************

    //SETTERS ******************************************************************

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setBrgyCode(String brgyCode) {
        this.brgyCode = brgyCode;
    }

    public void setBrgyDesc(String brgyDesc) {
        this.brgyDesc = brgyDesc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSketch(String sketch) {
        this.sketch = sketch;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setYearsOfStay(String yearsOfStay) {
        this.yearsOfStay = yearsOfStay;
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("addressId:").append(getAddressId());
        sb.append("clientNo:").append(getClientNo());
        sb.append("^txFormNo:").append(getTxFormNo());
        sb.append("^personType:").append(getPersonType().getTypeID());
        sb.append("^lineNo:").append(getLineNo());
        sb.append("^brgyCode:").append(getBrgyCode());
        sb.append("^brgyDesc:").append(getBrgyDesc());
        sb.append("^zipCode:").append(getZipCode());
        sb.append("^address:").append(getAddress());
        sb.append("^description:").append(getDescription());
        sb.append("^sketch:").append(getSketch());
        sb.append("^status:").append(getStatus());
        sb.append("^yearsOfStay:").append(getYearsOfStay());
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
        return getAddressId() + "-" + getTxFormNo();
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
        return ("address" +
               "$#~cAddressId~" + getAddressId() +"~S" + 
               "$cClientNo~" + getClientNo() +"~S" +
               "$cTxFormNo~" + getTxFormNo() + "~S" +
               "$~cPersonTypeId~" + getPersonType().getTypeID() +"~S" +
               "$~nLineNo~" + getLineNo() + "~N" +
               "$cBrgyCode~" + getBrgyCode() + "~S" +
               "$cBrgyDesc~" + getBrgyDesc() + "~S" +
               "$cZipCode~" + getZipCode() + "~S" +
               "$cAddress~" + getAddress() + "~S" + 
               "$cDescription~" + getDescription() + "~S" +
               "$cStatus~" + getStatus() + "~S" + 
               "$cYearsOfStay~" + getYearsOfStay() + "~S" + 
               "$cSketch~" + getSketch() + "~S").replace("'", " ");
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
