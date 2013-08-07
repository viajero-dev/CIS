/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.FamilyPk;
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
@Table(name = "family")
public class Family implements Serializable, AuditTrailService, LiveUpdateService {
    
    private FamilyPk pk = new FamilyPk();
    private String famName;
    private String famAddress;
    private String famOccupation;
    private int famAge;
    private int version;
    
    //GETTERS ******************************************************************
    @Column(name = "cFamAddress")
    public String getFamAddress() {
        return famAddress;
    }
    
    @Column(name = "nFamAge")
    public int getFamAge() {
        return famAge;
    }
    
    @Column(name = "cFamName")
    public String getFamName() {
        return famName;
    }
    
    @Column(name = "cFamOccupation")
    public String getFamOccupation() {
        return famOccupation;
    }
    
    public String getFamRelation() {
        return getPk().getFamRelation();
    }
    
    @Id
    public FamilyPk getPk() {
        return pk;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    
    @Transient
    public PersonType getPersonType() {
        return getPk().getPersonType();
    }
    
    @Transient
    public String getTxFormNo() {
        return getPk().getTxFormNo();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setFamAddress(String famAddress) {
        this.famAddress = famAddress;
    }

    public void setFamAge(int famAge) {
        this.famAge = famAge;
    }
    
    public void setFamName(String famName) {
        this.famName = famName;
    }
    
    public void setFamOccupation(String famOccupation) {
        this.famOccupation = famOccupation;
    }
    
    public void setFamRelation(String famRelation) {
        getPk().setFamRelation(famRelation);
    }
    
    public void setPk(FamilyPk pk) {
        this.pk = pk;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public void setPersonType(PersonType personType) {
        getPk().setPersonType(personType);
    }
    
    public void setTxForm(String txFormNo) {
        getPk().setTxFormNo(txFormNo);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("^txForm:").append(getTxFormNo())
          .append("^personType:").append(getPersonType().getTypeID())
          .append("^famName:").append(getFamName())
          .append("^famAddress:").append(getFamAddress())
          .append("^famOccupation:").append(getFamOccupation())
          .append("^famRelation:").append(getFamRelation())
          .append("^famAge:").append(getFamAge());
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
        return ("family" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" + 
               "$#~cPersonTypeID~" + getPersonType().getTypeID() +"~S" + 
               "$#~cFamName~" + getFamRelation() +"~S" + 
               "$cFamAddress~" + getFamAddress() + "~S" +
               "$nFamAge~" + getFamAge() + "~N" + 
               "$cFamOccupation~" + getFamOccupation() + "~S" +
               "$cFamRelation~" + getFamRelation() + "~S").replace("'", " "); 
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
