/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.MachineryPk;
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
@Table(name="machinery")
@AssociationOverrides({
    @AssociationOverride(name="machineryPk.asset", joinColumns=@JoinColumn(name="nAssetId"))
})
public class Machinery implements Serializable, AuditTrailService, LiveUpdateService {
    
    private MachineryPk machineryPk = new MachineryPk();
    private String type;
    private int quantity;
    private double amount;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="nAmount")
    public double getAmount() {
        return amount;
    }

    @Id
    public MachineryPk getMachineryPk() {
        return machineryPk;
    }

    @Column(name="nQuantity")
    public int getQuantity() {
        return quantity;
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
        return getMachineryPk().getAsset();
    }

    public int getLineNo() {
        return getMachineryPk().getLineNo();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMachineryPk(MachineryPk machineryPk) {
        this.machineryPk = machineryPk;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setAsset(Asset asset) {
        getMachineryPk().setAsset(asset);
    }

    public void setLineNo(int lineNo) {
        getMachineryPk().setLineNo(lineNo);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("assetId:").append(getAsset().getTxFormNo())
          .append("^lineNo:").append(getLineNo())
          .append("^type:").append(getType())
          .append("^quantity:").append(getQuantity())
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
        return getMachineryPk().toString();
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
        return "machinery" +
               "$#~nAssetId~" + getAsset().getTxFormNo() +"~S" +
               "$#~nLineNo~" + getLineNo() +"~N" + 
               "$nAmount~" + getAmount() + "~N" +
               "$nQuantity~" + getQuantity() + "~N" + 
               "$cType~" + getType() + "~S"; 
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
