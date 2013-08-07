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
@Table(name="transactionForm")
public class TransactionForm implements Serializable, AuditTrailService, LiveUpdateService {
    
    private String txFormNo;
    private String clientNo;
    private Date txApplicationDate;
    private int version;
    
    //GETTERS ******************************************************************
    @Column(name="cClientNo")
    public String getClientNo() {
        return clientNo;
    }

    @Column(name="dAppDate")
    @Temporal(TemporalType.DATE)
    public Date getTxApplicationDate() {
        return txApplicationDate;
    }

    @Id
    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public void setTxApplicationDate(Date txApplicationDate) {
        this.txApplicationDate = txApplicationDate;
    }

    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
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
          .append("^clientNo:").append(getClientNo())
          .append("^txApplicationDate:").append(DateUtil.toString(getTxApplicationDate(), "yyyy-MM-dd"));  
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
        return "transactionForm" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$cClientNo~" + getClientNo() + "~S" +
               "$dAppDate~" + DateUtil.toString(getTxApplicationDate(), "yyyy-MM-dd") + "~D";  
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
