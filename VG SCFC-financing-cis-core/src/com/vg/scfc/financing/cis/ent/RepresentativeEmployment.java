/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.RepresentativeEmploymentPk;
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
@Table(name="representativeEmployment")
public class RepresentativeEmployment implements Serializable, AuditTrailService, LiveUpdateService {
    
    private RepresentativeEmploymentPk pk = new RepresentativeEmploymentPk();
    private String status;
    private String position;
    private String department;
    private double salary;
    private int yearOfService;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="cDepartment")
    public String getDepartment() {
        return department;
    }

    @Column(name="cPosition")
    public String getPosition() {
        return position;
    }

    @Id
    public RepresentativeEmploymentPk getPk() {
        return pk;
    }

    @Column(name="nSalary")
    public double getSalary() {
        return salary;
    }

    @Column(name="nStatus")
    public String getStatus() {
        return status;
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
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPk(RepresentativeEmploymentPk pk) {
        this.pk = pk;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setYearOfService(int yearOfService) {
        this.yearOfService = yearOfService;
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
        sb.append("txFormNo:").append(getTxFormNo())
          .append("^personTypeId:").append(getPersonType().getTypeID())
          .append("^status:").append(getStatus())
          .append("^position:").append(getPosition())
          .append("^department:").append(getDepartment())
          .append("^salary:").append(getSalary())
          .append("^yearOfService:").append(getYearOfService());
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
        return ("representativeEmployment" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$#~cPersonTypeID~" + getPersonType().getTypeID() +"~S" + 
               "$cDepartment~" + getDepartment() + "~S" +
               "$cPosition~" + getPosition() + "~S" + 
               "$nSalary~" + getSalary() + "~N" +
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
