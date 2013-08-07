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
 * @author jp
 */
@Entity
@Table(name="purchaseOrder")
public class PurchaseOrder implements Serializable, AuditTrailService, LiveUpdateService {
    
    private String txFormNo;
    private String unitApplied;
    private double downPayment;
    private double insurance;
    private double monthlyAmortization;
    private int term;
    private boolean brandNew; 
    private String purpose;
    private String remarks;
    private String status;
    private Date encodeDate;
    private Date statusDate;
    private String ciCollector;
    private int version;
    
    //GETTERS ******************************************************************
    @Column(name="lBrandNew")
    public boolean isBrandNew() {
        return brandNew;
    }

    @Column(name="cCI")
    public String getCiCollector() {
        return ciCollector;
    }

    @Column(name="nDownPayment")
    public double getDownPayment() {
        return downPayment;
    }

    @Column(name="dEncodeDate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEncodeDate() {
        return encodeDate;
    }

    @Column(name="nInsurance")
    public double getInsurance() {
        return insurance;
    }

    @Column(name="nMonthlyAmort")
    public double getMonthlyAmortization() {
        return monthlyAmortization;
    }

    @Column(name="cPurpose")
    public String getPurpose() {
        return purpose;
    }

    @Column(name="cRemarks")
    public String getRemarks() {
        return remarks;
    }

    @Column(name="cStatus")
    public String getStatus() {
        return status;
    }

    @Column(name="dStatusDate")
    @Temporal(TemporalType.DATE)
    public Date getStatusDate() {
        return statusDate;
    }

    @Column(name="nTerm")
    public int getTerm() {
        return term;
    }

    @Id
    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    @Column(name="cUnitApplied")
    public String getUnitApplied() {
        return unitApplied;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setBrandNew(boolean brandNew) {
        this.brandNew = brandNew;
    }

    public void setCiCollector(String ciCollector) {
        this.ciCollector = ciCollector;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public void setEncodeDate(Date encodeDate) {
        this.encodeDate = encodeDate;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public void setMonthlyAmortization(double monthlyAmortization) {
        this.monthlyAmortization = monthlyAmortization;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
    }

    public void setUnitApplied(String unitApplied) {
        this.unitApplied = unitApplied;
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
          .append("^unitApplied:").append(getUnitApplied())
          .append("^downPayment:").append(getDownPayment())
          .append("^insurance:").append(getInsurance())
          .append("^monthlyAmortization:").append(getMonthlyAmortization())
          .append("^term:").append(getTerm())
          .append("^brandNew:").append(isBrandNew())
          .append("^purpose:").append(getPurpose())
          .append("^remarks:").append(getRemarks())
          .append("^status:").append(getStatus())
          .append("^encodeDate:").append((getEncodeDate() != null) ? DateUtil.toString(getEncodeDate(), "yyyy-MM-dd HH:mm:ss") : getEncodeDate())
          .append("^statusDate:").append((getStatusDate() != null) ? DateUtil.toString(getStatusDate(), "yyyy-MM-dd") : getStatusDate())
          .append("^ciCollector:").append(getCiCollector());
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
        return ("purchaseOrder" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$lBrandNew~" + isBrandNew() + "~B" +
               "$cCI~" + getCiCollector() + "~S" + 
               "$nDownPayment~" + getDownPayment() + "~N" +
               "$dEncodeDate~" + ((getEncodeDate() != null) ? (DateUtil.toString(getEncodeDate(), "yyyy-MM-dd HH:mm:ss") + "~D") : (getEncodeDate() + "~N")) + 
               "$nInsurance~" + getInsurance() + "~N" +
               "$nMonthlyAmort~" + getMonthlyAmortization() + "~N" + 
               "$cPurpose~" + getPurpose() + "~S" +
               "$cRemarks~" + getRemarks() + "~S" + 
               "$cStatus~" + getStatus() + "~S" +
               "$dStatusDate~" + ((getStatusDate() != null) ? (DateUtil.toString(getStatusDate(), "yyyy-MM-dd") + "~D") : (getStatusDate() + "~N")) + 
               "$nTerm~" + getTerm() + "~N" +
               "$cUnitApplied~" + getUnitApplied() + "~S").replace("'", " ");  
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
