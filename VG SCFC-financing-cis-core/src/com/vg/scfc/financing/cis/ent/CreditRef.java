/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.CreditRefPk;
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
@Table(name = "creditRef")
public class CreditRef implements Serializable, AuditTrailService, LiveUpdateService {

    private CreditRefPk pk = new CreditRefPk();
    private String creRefName;
    private String creRefAddress;
    private String creItem;
    private String creRefTerm;
    private double creRefLoanAmount;
    private double creRefMonthly;
    private double creRefAmountPaid;
    private double creRefBalance;
    private int version;
 
    //GETTERS ******************************************************************
    @Column(name = "cAddress")
    public String getCreRefAddress() {
        return creRefAddress;
    }

    @Column(name = "nAmountPaid")
    public double getCreRefAmountPaid() {
        return creRefAmountPaid;
    }

    @Column(name = "nRemBalance")
    public double getCreRefBalance() {
        return creRefBalance;
    }

    @Column(name = "nLoanAmount")
    public double getCreRefLoanAmount() {
        return creRefLoanAmount;
    }

    @Column(name = "nMonthly")
    public double getCreRefMonthly() {
        return creRefMonthly;
    }

    @Column(name = "cName")
    public String getCreRefName() {
        return creRefName;
    }

    @Column(name = "cTerm")
    public String getCreRefTerm() {
        return creRefTerm;
    }

    @Column(name = "cItemOnCredit")
    public String getCreItem() {
        return creItem;
    }
    
    @Id
    public CreditRefPk getPk() {
        return pk;
    }

    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    
    @Transient
    public int getLineNo() {
        return getPk().getLineNo();
    }

    @Transient
    public String getTxFormNo() {
        return getPk().getTxFormNo();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setCreRefAddress(String creRefAddress) {
        this.creRefAddress = creRefAddress;
    }

    public void setCreRefAmountPaid(double creRefAmountPaid) {
        this.creRefAmountPaid = creRefAmountPaid;
    }

    public void setCreRefBalance(double creRefBalance) {
        this.creRefBalance = creRefBalance;
    }

    public void setCreRefLoanAmount(double creRefLoanAmount) {
        this.creRefLoanAmount = creRefLoanAmount;
    }

    public void setCreRefMonthly(double creRefMonthly) {
        this.creRefMonthly = creRefMonthly;
    }

    public void setCreRefName(String creRefName) {
        this.creRefName = creRefName;
    }

    public void setCreRefTerm(String creRefTerm) {
        this.creRefTerm = creRefTerm;
    }

    public void setCreItem(String creItem) {
        this.creItem = creItem;
    }
    
    public void setPk(CreditRefPk pk) {
        this.pk = pk;
    }

    public void setLineNo(int lineNo) {
        this.getPk().setLineNo(lineNo);
    }

    public void setTxFormNo(String txFormNo) {
        this.getPk().setTxFormNo(txFormNo);
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
        sb.append("txFormNo:").append(getTxFormNo());
        sb.append("^lineNo:").append(getLineNo());
        sb.append("^creRefName:").append(getCreRefName());
        sb.append("^creRefAddress:").append(getCreRefAddress());
        sb.append("^creItem:").append(getCreItem());
        sb.append("^creRefTerm:").append(getCreRefTerm());
        sb.append("^creRefLoanAmount:").append(getCreRefLoanAmount());
        sb.append("^creRefMonthly:").append(getCreRefMonthly());
        sb.append("^creRefAmountPaid:").append(getCreRefAmountPaid());
        sb.append("^creRefBalance:").append(getCreRefBalance());
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
        return ("creditRef" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$#~nLineNo~" + getLineNo() + "~N" + 
               "$cAddress~" + getCreRefAddress() + "~S" +
               "$cItemOnCredit~" + getCreItem() + "~S" + 
               "$nAmountPaid~" + getCreRefAmountPaid() + "~N" +
               "$nRemBalance~" + getCreRefBalance() + "~N" + 
               "$nLoanAmount~" + getCreRefLoanAmount() + "~N" +
               "$nMonthly~" + getCreRefMonthly() + "~N" +
               "$cName~" + getCreRefName() + "~S" +
               "$cTerm~" + getCreRefTerm() + "~S").replace("'", " "); 
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
