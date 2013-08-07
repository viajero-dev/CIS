/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.CharacterReferencePk;
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
@Table(name = "charReference")
public class CharacterReference implements Serializable, AuditTrailService, LiveUpdateService {

    private CharacterReferencePk pk = new CharacterReferencePk();
    private String charRefName;
    private String charRefAddress;
    private String charRelationship;
    private String charRefContactNo;
    private int version;

    //GETTERS ******************************************************************
    @Column(name = "cCharRefAddress")
    public String getCharRefAddress() {
        return charRefAddress;
    }

    @Column(name = "cCharRefContactNo")
    public String getCharRefContactNo() {
        return charRefContactNo;
    }

    @Column(name = "cCharRefName")
    public String getCharRefName() {
        return charRefName;
    }

    @Id
    public CharacterReferencePk getPk() {
        return pk;
    }

    @Column(name="cRelationship")
    public String getCharRelationship() {
        return charRelationship;
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
    public void setCharRefAddress(String charRefAddress) {
        this.charRefAddress = charRefAddress;
    }

    public void setCharRefContactNo(String charRefContactNo) {
        this.charRefContactNo = charRefContactNo;
    }

    public void setCharRefName(String charRefName) {
        this.charRefName = charRefName;
    }

    public void setPk(CharacterReferencePk pk) {
        this.pk = pk;
    }

    public void setCharRelationship(String charRelationship) {
        this.charRelationship = charRelationship;
    }
    
    public void setLineNo(int lineNo) {
        getPk().setLineNo(lineNo);
    }

    public void setTxFormNo(String txFormNo) {
        getPk().setTxFormNo(txFormNo);
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
        sb.append("txFormNo:").append(getTxFormNo())
          .append("^lineNo:").append(getLineNo())
          .append("^charRefName:").append(getCharRefName())
          .append("^charRefAddress:").append(getCharRefAddress())
          .append("^charRelationship:").append(getCharRefAddress())
          .append("^charRefContactNo:").append(getCharRefContactNo());
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
        return ("charReference" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" +
               "$#~nLineNo~" + getLineNo() + "~N" + 
               "$cCharRefName~" + getCharRefName() + "~S" +
               "$cCharRefAddress~" + getCharRefAddress() + "~S" +
               "$cRelationship~" + getCharRelationship() + "~S" + 
               "$cCharRefContactNo~" + getCharRefContactNo() + "~S").replace("'", " "); 
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
