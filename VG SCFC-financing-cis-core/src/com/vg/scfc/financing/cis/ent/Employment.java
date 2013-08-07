/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.EmploymentPk;
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
 * @author jp
 */
@Entity
@Table(name="employment")
public class Employment implements Serializable, AuditTrailService, LiveUpdateService {
    
    private EmploymentPk pk = new EmploymentPk();
    private String empPosition;
    private String empCompany;
    private String empAddress;
    private String empContactNo;
    private String empNature;
    private String empStatus;
    private int empYearsInService;
    private int version;
    
    //GETTERS ******************************************************************
    @Column(name="cAddress")
    public String getEmpAddress() {
        return empAddress;
    }

    @Column(name="cCompany")
    public String getEmpCompany() {
        return empCompany;
    }

    @Column(name="cContactNo")
    public String getEmpContactNo() {
        return empContactNo;
    }

    @Column(name="cNature")
    public String getEmpNature() {
        return empNature;
    }

    @Column(name="cPosition")
    public String getEmpPosition() {
        return empPosition;
    }

    @Column(name="cStatus")
    public String getEmpStatus() {
        return empStatus;
    }

    @Id
    public EmploymentPk getPk() {
        return pk;
    }

    @Column(name="nYearsInService")
    public int getEmpYearsInService() {
        return empYearsInService;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    
    @Transient
    public PersonType getPersonType() {
        return getPk().getPersonType();
    }

    @Transient
    public String getTxFormNo() {
        return getPk().getTxFormNo();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpCompany(String empCompany) {
        this.empCompany = empCompany;
    }

    public void setEmpContactNo(String empContactNo) {
        this.empContactNo = empContactNo;
    }

    public void setEmpNature(String empNature) {
        this.empNature = empNature;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public void setPk(EmploymentPk pk) {
        this.pk = pk;
    }

    public void setEmpYearsInService(int empYearsInService) {
        this.empYearsInService = empYearsInService;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public void setPersonType(PersonType personType) {
        getPk().setPersonType(personType);
    }

    public void setTxFormNo(String txFormNo) {
        getPk().setTxFormNo(txFormNo);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("^txFormNo:").append(getTxFormNo())
          .append("^personType:").append(getPersonType().getTypeID())
          .append("^empPosition:").append(getEmpPosition())
          .append("^empCompany:").append(getEmpCompany())
          .append("^empAddress:").append(getEmpAddress())
          .append("^empContactNo:").append(getEmpContactNo())
          .append("^empNature:").append(getEmpNature())
          .append("^empStatus:").append(getEmpStatus())
          .append("^empYearsInService:").append(getEmpYearsInService());
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
        return getPk().toString();
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
        return ("employment" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" + 
               "$#~cPersonTypeID~" + getPersonType().getTypeID() +"~S" + 
               "$cAddress~" + getEmpAddress() + "~S" +
               "$ccCompany~" + getEmpCompany() + "~S" + 
               "$cContactNo~" + getEmpContactNo() + "~S" +
               "$cNature~" + getEmpNature() + "~S" + 
               "$cPosition~" + getEmpPosition() + "~S" + 
               "$cStatus~" + getEmpStatus() + "~S" +
               "$nYearsInService~" + getEmpYearsInService() + "~N").replace("'", " "); 
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
