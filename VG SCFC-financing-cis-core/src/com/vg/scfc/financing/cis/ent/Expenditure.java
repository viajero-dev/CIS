/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.ExpenditurePk;
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
@Table(name="expenditure")
public class Expenditure implements Serializable, AuditTrailService, LiveUpdateService {
    
    private ExpenditurePk pk = new ExpenditurePk();
    private String additionalInfo;
    private double amount;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="cAdditionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Column(name="cAmount")
    public double getAmount() {
        return amount;
    }

    @Id
    public ExpenditurePk getPk() {
        return pk;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }

    @Transient
    public ExpenditureType getExpenditureType() {
        return getPk().getExpenditureType();
    }

    @Transient
    public String getTxFormNo() {
        return getPk().getTxFormNo();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setPk(ExpenditurePk pk) {
        this.pk = pk;
    }
    
    public void setExpenditureType(ExpenditureType expenditureType) {
        this.getPk().setExpenditureType(expenditureType);
    }

    public void setTxFormNo(String txFormNo) {
        this.getPk().setTxFormNo(txFormNo);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("txFormNo:").append(getTxFormNo())
          .append("^expenditureType:").append(getExpenditureType().getId())
          .append("^additionalInfo:").append(getAdditionalInfo())
          .append("^amount:").append(getAmount());
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
        return ("expenditure" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$#~cExpTypeId~" + getExpenditureType().getId() +"~N" + 
               "$cAdditionalInfo~" + getAdditionalInfo() + "~S" +
               "$cAmount~" + getAmount() + "~N").replace("'", " "); 
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
