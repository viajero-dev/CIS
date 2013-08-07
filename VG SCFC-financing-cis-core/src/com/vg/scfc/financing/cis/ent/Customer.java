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
 * @author raffy
 */

@Entity
@Table(name="customer")
public class Customer implements Serializable, AuditTrailService, LiveUpdateService {
    
    private String clientNo;
    private String name;
    private TransactionMode transactionMode;
    private int version;

    //GETTERS ******************************************************************
    @Id
    @Column(name="cClientNo", length=8, nullable=false, unique=true)
    public String getClientNo() {
        return clientNo;
    }

    @Column(name="cName", length=255)
    public String getName() {
        return name;
    }

    @OneToOne
    @JoinColumn(name="nTransModeId")
    public TransactionMode getTransactionMode() {
        return transactionMode;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransactionMode(TransactionMode transactionMode) {
        this.transactionMode = transactionMode;
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
          .append("^name:").append(getName())
          .append("^transactionMode:").append(getTransactionMode().getId());
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
        return "customer" +
               "$#~cClientNo~" + getClientNo() +"~S" +
               "$cName~" + getName() + "~S" +
               "$nTransModeId~" + getTransactionMode().getId() + "~N"; 
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
