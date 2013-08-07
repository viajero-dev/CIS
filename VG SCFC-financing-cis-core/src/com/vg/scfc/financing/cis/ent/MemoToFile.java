/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.MemoToFilePk;
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
@Table(name="memoToFile")
public class MemoToFile implements Serializable, AuditTrailService, LiveUpdateService {
    
    private MemoToFilePk pk = new MemoToFilePk();
    private String description;
    private String remarks;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="cDescription")
    public String getDescription() {
        return description;
    }

    @Id
    public MemoToFilePk getPk() {
        return pk;
    }

    @Column(name="cRemarks")
    public String getRemarks() {
        return remarks;
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
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPk(MemoToFilePk pk) {
        this.pk = pk;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
          .append("^description:").append(getDescription())
          .append("^remarks:").append(getRemarks());
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
        return ("memoToFile" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$#~nLineNo~" + getLineNo() +"~N" + 
               "$cDescription~" + getDescription() + "~S" +
               "$cRemarks~" + getRemarks() + "~S").replace("'", " "); 
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
