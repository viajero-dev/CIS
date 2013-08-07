/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.AppliancePk;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.service.AuditTrailService;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author raffy
 */

@Entity
@Table(name="appliance")
@AssociationOverrides({
    @AssociationOverride(name="appliancePk.asset", joinColumns=@JoinColumn(name="nAssetId"))
})
public class Appliance implements Serializable, AuditTrailService, LiveUpdateService {
    
    private AppliancePk appliancePk = new AppliancePk();
    private String type;
    private double amount;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="nAmount")
    public double getAmount() {
        return amount;
    }

    @Id
    public AppliancePk getAppliancePk() {
        return appliancePk;
    }

    @Column(name="cType")
    public String getType() {
        return type;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }

    @Transient
    public Asset getAsset() {
        return getAppliancePk().getAsset();
    }

    @Transient
    public int getLineNo() {
        return getAppliancePk().getLineNo();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAppliancePk(AppliancePk appliancePk) {
        this.appliancePk = appliancePk;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setAsset(Asset asset) {
        this.getAppliancePk().setAsset(asset);
    }

    public void setLineNo(int lineNo) {
        this.getAppliancePk().setLineNo(lineNo);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("assetId:").append(getAsset().getTxFormNo());
        sb.append("^lineNo:").append(getLineNo());
        sb.append("^type:").append(getType());
        sb.append("^amount:").append(getAmount());
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
        return getAppliancePk().toString();
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
        return "appliance" +
               "$#~nAssetId~" + getAsset().getTxFormNo() +"~S" +
               "$#~nLineNo~" + getLineNo() + "~N" +
               "$cType~" + getType() + "~S" +
               "$nAmount~" + getAmount() + "~N";
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
