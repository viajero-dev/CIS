/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.LandPk;
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
@Table(name="land")
@AssociationOverrides({
    @AssociationOverride(name="pk.asset", joinColumns=@JoinColumn(name="nAssetId"))
})
public class Land implements Serializable, AuditTrailService, LiveUpdateService {
    
    private LandPk landPk = new LandPk();
    private double area;
    private String address;
    private double amount;
    private String additionalInfo;
    private int version;

    //GETTERS ******************************************************************
    @Column(name="nAmount")
    public double getAmount() {
        return amount;
    }

    @Column(name="nArea")
    public double getArea() {
        return area;
    }

    @Id
    public LandPk getLandPk() {
        return landPk;
    }

    @Column(name="cLocation")
    public String getAddress() {
        return address;
    }

    @Column(name="cAdditionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }

    @Transient
    public Asset getAsset() {
        return getLandPk().getAsset();
    }

    @Transient
    public LandType getLandType() {
        return getLandPk().getLandType();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setLandPk(LandPk landPk) {
        this.landPk = landPk;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }

    public void setAsset(Asset asset) {
        getLandPk().setAsset(asset);
    }

    public void setLandType(LandType landType) {
        getLandPk().setLandType(landType);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("assetId:").append(getAsset().getTxFormNo())
          .append("^landTypeId:").append(getLandType().getId())
          .append("^area:").append(getArea())
          .append("^location:").append(getLocation())
          .append("^amount:").append(getAmount())
          .append("^additionalInfo:").append(getAmount());
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
        return getLandPk().toString();
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
        return "land" +
               "$#~nAssetId~" + getAsset().getTxFormNo() +"~S" +
               "$#~nLandTypeId~" + getLandType().getId() +"~N" + 
               "$nAmount~" + getAmount() + "~N" +
               "$nArea~" + getArea() + "~N" + 
               "$cLocation~" + getLocation() + "~S" +
               "$cAdditionalInfo~" + getAdditionalInfo() + "~S"; 
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
