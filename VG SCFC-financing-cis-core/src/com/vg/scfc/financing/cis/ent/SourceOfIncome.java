/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.SourceOfIncomePk;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.service.AuditTrailService;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import java.io.Serializable;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author jp
 */
@Entity
@Table(name = "sourceOfIncome")
public class SourceOfIncome implements Serializable, AuditTrailService, LiveUpdateService {
    
    private SourceOfIncomePk pk = new SourceOfIncomePk();
    private double incSalary;
    private double incBusiness;
    private String incNature;
    private boolean incRegistered;
    private double incFarm;
    private boolean incArgriculture;
    private boolean incLiveStock;
    private String incHarvestDate;
    private double incAverageProd;
    private double incOther;
    private String incOtherSource;
    private int version;
    
    //GETTERS ******************************************************************
    @Column(name = "cHarvestDate")
    public String getIncHarvestDate() {
        return incHarvestDate;
    }
    
    @Column(name = "lAgriculture")
    public boolean isIncArgriculture() {
        return incArgriculture;
    }
    
    @Column(name = "nAveProd")
    public double getIncAverageProd() {
        return incAverageProd;
    }
    
    @Column(name = "nBusinessInc")
    public double getIncBusiness() {
        return incBusiness;
    }
    
    @Column(name = "nFarmInc")
    public double getIncFarm() {
        return incFarm;
    }
    
    @Column(name = "lLiveStock")
    public boolean isIncLiveStock() {
        return incLiveStock;
    }
    
    @Column(name = "cNatureOfBusiness")
    public String getIncNature() {
        return incNature;
    }
    
    @Column(name = "nOtherIncome")
    public double getIncOther() {
        return incOther;
    }
    
    @Column(name = "cOtherSource")
    public String getIncOtherSource() {
        return incOtherSource;
    }
    
    @Column(name = "lRegistered")
    public boolean isIncRegistered() {
        return incRegistered;
    }
    
    @Column(name = "nSalary")
    public double getIncSalary() {
        return incSalary;
    }
    
    @Id
    public SourceOfIncomePk getPk() {
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
    public String getClientNo() {
        return getPk().getClientNo();
    }
    
    @Transient
    public TransactionForm getTxForm() {
        return getPk().getTxForm();
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    public void setIncHarvestDate(String incHarvestDate) {
        this.incHarvestDate = incHarvestDate;
    }
    
    public void setIncArgriculture(boolean incArgriculture) {
        this.incArgriculture = incArgriculture;
    }
    
    public void setIncAverageProd(double incAverageProd) {
        this.incAverageProd = incAverageProd;
    }
    
    public void setIncBusiness(double incBusiness) {
        this.incBusiness = incBusiness;
    }
    
    public void setIncFarm(double incFarm) {
        this.incFarm = incFarm;
    }
    
    public void setIncLiveStock(boolean incLiveStock) {
        this.incLiveStock = incLiveStock;
    }
    
    public void setIncNature(String incNature) {
        this.incNature = incNature;
    }
    
    public void setIncOther(double incOther) {
        this.incOther = incOther;
    }
    
    public void setIncOtherSource(String incOtherSource) {
        this.incOtherSource = incOtherSource;
    }
    
    public void setIncRegistered(boolean incRegistered) {
        this.incRegistered = incRegistered;
    }
    
    public void setIncSalary(double incSalary) {
        this.incSalary = incSalary;
    }
    
    public void setPk(SourceOfIncomePk pk) {
        this.pk = pk;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public void setPersonType(PersonType personType) {
        getPk().setPersonType(personType);
    }
    
    public void setClientNo(String clientNo) {
        getPk().setClientNo(clientNo);
    }
    
    public void setTxForm(TransactionForm txForm) {
        getPk().setTxForm(txForm);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("clientNo:").append(getClientNo())
          .append("^txForm:").append(getTxForm().getTxFormNo())
          .append("^personTypeId:").append(getPersonType().getTypeID())
          .append("^incSalary:").append(getIncSalary())
          .append("^incBusiness:").append(getIncBusiness())
          .append("^incNature:").append(getIncNature())
          .append("^incRegistered:").append(isIncRegistered())
          .append("^incFarm:").append(getIncFarm())
          .append("^incArgriculture:").append(isIncArgriculture())      
          .append("^incLiveStock:").append(isIncLiveStock())
          .append("^harvestDate:").append(getIncHarvestDate())
          .append("^incAverageProd:").append(getIncAverageProd())
          .append("^incOther:").append(getIncOther())
          .append("^incOtherSource:").append(getIncOtherSource());  
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
        return ("sourceOfIncome" +
               "$#~cClientNo~" + getClientNo() +"~S" +
               "$#~cTxFormNo~" + getTxForm().getTxFormNo() +"~S" + 
               "$#~cPersonTypeID~" + getPersonType().getTypeID() +"~N" +  
               "$cHarvestDate~" + getIncHarvestDate() + "~S" +
               "$lAgriculture~" + isIncArgriculture() + "~B" + 
               "$nAveProde~" + getIncAverageProd() + "~N" +
               "$nBusinessInc~" + getIncBusiness() + "~N" + 
               "$nFarmInc~" + getIncFarm() + "~N" +
               "$lLiveStock~" + isIncLiveStock() + "~B" + 
               "$cNatureOfBusiness~" + getIncNature() + "~S" +
               "$nOtherIncome~" + getIncOther() + "~N" + 
               "$cOtherSource~" + getIncOtherSource() + "~S" +
               "$lRegistered~" + isIncRegistered() + "~B" + 
               "$nSalary~" + getIncSalary() + "~N").replace("'", " ");  
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
