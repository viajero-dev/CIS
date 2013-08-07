/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.SiblingPk;
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
@Table(name = "siblings")
public class Sibling implements Serializable, AuditTrailService, LiveUpdateService {

    private SiblingPk pk = new SiblingPk();
    private String siblingName;
    private String siblingAddress;
    private String siblingContactNo;
    private int version;

    //GETTERS ******************************************************************
    @Id
    public SiblingPk getPk() {
        return pk;
    }

    @Column(name="cSiblingAddress")
    public String getSiblingAddress() {
        return siblingAddress;
    }

    @Column(name="cSiblingContactNo")
    public String getSiblingContactNo() {
        return siblingContactNo;
    }

    @Column(name="cSiblingName")
    public String getSiblingName() {
        return siblingName;
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
    public void setPk(SiblingPk pk) {
        this.pk = pk;
    }

    public void setSiblingAddress(String siblingAddress) {
        this.siblingAddress = siblingAddress;
    }

    public void setSiblingContactNo(String siblingContactNo) {
        this.siblingContactNo = siblingContactNo;
    }

    public void setSiblingName(String siblingName) {
        this.siblingName = siblingName;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public void setLineNo(int lineNo) {
        getPk().setLineNo(lineNo);
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
          .append("^lineNo:").append(getLineNo())
          .append("^siblingName:").append(getSiblingName())
          .append("^siblingAddress:").append(getSiblingAddress())
          .append("^siblingContactNo:").append(getSiblingContactNo());
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
        return ("siblings" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$#~nLineNo~" + getLineNo() +"~N" + 
               "$cSiblingName~" + getSiblingName() + "~S" +
               "$cSiblingAddress~" + getSiblingAddress() + "~S" + 
               "$cSiblingContactNo~" + getSiblingContactNo() + "~S").replace("'", " ");  
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
