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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author raffy
 */
@Entity
@Table(name = "asset")
public class Asset implements Serializable, AuditTrailService, LiveUpdateService {

    private String txFormNo;
    private int version;
    private List<Land> lands = new ArrayList<Land>();
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
    private List<Appliance> appliances = new ArrayList<Appliance>();
    private List<Machinery> machineries = new ArrayList<Machinery>();

    //GETTERS ******************************************************************
    @Id
    @Column(name = "cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    @Version
    @Column(name = "nVersion")
    public int getVersion() {
        return version;
    }

    @OneToMany(mappedBy = "landPk.asset", fetch = FetchType.LAZY)
    public List<Land> getLands() {
        return lands;
    }

    @OneToMany(mappedBy = "appliancePk.asset", fetch = FetchType.LAZY)
    public List<Appliance> getAppliances() {
        return appliances;
    }

    @OneToMany(mappedBy = "machineryPk.asset", fetch = FetchType.LAZY)
    public List<Machinery> getMachineries() {
        return machineries;
    }

    @OneToMany(mappedBy = "vehiclePk.asset", fetch = FetchType.LAZY)
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    //END GETTERS **************************************************************

    //SETTERS ******************************************************************
    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
    }

    public void setLands(List<Land> lands) {
        this.lands = lands;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public void setMachineries(List<Machinery> machineries) {
        this.machineries = machineries;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
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
        return getTxFormNo() + "";
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
        return "asset"
                + "$#~cTxFormNo~" + getTxFormNo() + "~S";
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