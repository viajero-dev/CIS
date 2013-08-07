/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.DependentPk;
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
@Table(name = "dependent")
public class Dependent implements Serializable, AuditTrailService, LiveUpdateService {

    private DependentPk pk = new DependentPk();
    private String depName;
    private String depAddress;
    private String depContactNo;
    private String depRelation;
    private int version;

    //GETTERS ******************************************************************
    @Column(name = "cDepAddress")
    public String getDepAddress() {
        return depAddress;
    }

    @Column(name = "cDepContactNo")
    public String getDepContactNo() {
        return depContactNo;
    }

    @Column(name = "cDepName")
    public String getDepName() {
        return depName;
    }

    @Column(name = "cDepRelation")
    public String getDepRelation() {
        return depRelation;
    }

    @Id
    public DependentPk getPk() {
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
    public void setDepAddress(String depAddress) {
        this.depAddress = depAddress;
    }

    public void setDepContactNo(String depContactNo) {
        this.depContactNo = depContactNo;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDepRelation(String depRelation) {
        this.depRelation = depRelation;
    }

    public void setPk(DependentPk pk) {
        this.pk = pk;
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
          .append("^depName:").append(getDepName())
          .append("^depAddress:").append(getDepAddress())
          .append("^depContactNo:").append(getDepContactNo())
          .append("^depRelation:").append(getDepRelation());
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
        return "dependent" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$#~nLineNo~" + getLineNo() +"~N" + 
               "$cDepAddress~" + getDepAddress() + "~S" +
               "$cDepContactNo~" + getDepContactNo() + "~S" + 
               "$cDepName~" + getDepName() + "~S" +
               "$cDepRelation~" + getDepRelation() + "~S";        
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
