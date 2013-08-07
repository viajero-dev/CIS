/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import com.vg.commons.util.DateUtil;
import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.cis.embedabble.PersonInfoPk;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.service.AuditTrailService;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author jp
 */
@Entity
@Table(name = "personInfo")
public class PersonalInfo implements Serializable, AuditTrailService, LiveUpdateService {

    private PersonInfoPk pk = new PersonInfoPk();
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String gender;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String civilStatus;
    private String education;
    private Tribe tribe;
    private Religion religion;
    private String citizenship;
    private String contactNo;
    private int version;

    //GETTERS ******************************************************************
    @Column(name = "cCivilStatus")
    public String getCivilStatus() {
        return civilStatus;
    }

    @Column(name = "dDateOfBirth")
    @Temporal(TemporalType.DATE)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "cEducation")
    public String getEducation() {
        return education;
    }

    @Column(name = "cFirstName")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "cGender")
    public String getGender() {
        return gender;
    }

    @Column(name = "cLastName")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "cMiddleName")
    public String getMiddleName() {
        return middleName;
    }

    @Column(name = "cNickName")
    public String getNickName() {
        return nickName;
    }

    @Id
    public PersonInfoPk getPk() {
        return pk;
    }

    @Column(name = "cPlaceOfBirth")
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @OneToOne
    @JoinColumn(name = "cReligionId")
    @NotFound(action= NotFoundAction.IGNORE)
    public Religion getReligion() {
        return religion;
    }

    @OneToOne
    @JoinColumn(name = "cTribeId")
    @NotFound(action= NotFoundAction.IGNORE)
    public Tribe getTribe() {
        return tribe;
    }

    @Column(name="cCitizenship")
    public String getCitizenship() {
        return citizenship;
    }

    @Column(name="cContactNo")
    public String getContactNo() {
        return contactNo;
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
    public String getTxFormNo() {
        return getPk().getTxFormNo();
    }
    
    @Transient
    public String getProperName() {
        return getLastName() + ", " + getFirstName() + " " + getMiddleName();
    }
    
    @Transient
    public String getFullName() {
        return getFirstName() + (getMiddleName() != null ? (getMiddleName().substring(0, 1) + ". ") : " ") + getLastName();
    }
    //END GETTERS **************************************************************
    
    //SETTERS ******************************************************************
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPk(PersonInfoPk pk) {
        this.pk = pk;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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

    public void setTxFormNo(String txFormNo) {
        getPk().setTxFormNo(txFormNo);
    }
    //END SETTERS **************************************************************

    //AUDIT TRAIL **************************************************************
    @Transient
    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("clientNo:").append(getClientNo())
          .append("^txFormNo:").append(getTxFormNo())
          .append("^personTypeId:").append(getPersonType().getTypeID())
          .append("^firstName:").append(getFirstName())
          .append("^middleName:").append(getMiddleName())
          .append("^lastName:").append(getLastName())
          .append("^nickName:").append(getNickName())
          .append("^gender:").append(getGender())
          .append("^dateOfBirth:").append((getDateOfBirth() != null) ? DateUtil.toString(getDateOfBirth(), "yyyy-MM-dd") : getDateOfBirth())
          .append("^placeOfBirth:").append(getPlaceOfBirth())
          .append("^civilStatus:").append(getCivilStatus())
          .append("^education:").append(getEducation())
          .append("^tribeId:").append((getTribe() != null) ? getTribe().getTribeID() : getTribe())
          .append("^citizenship:").append(getCitizenship())
          .append("^contactNo:").append(getContactNo())      
          .append("^religionId:").append((getReligion() != null) ? getReligion().getReligionID() : getReligion());
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
        return ("personInfo" +
               "$#~cClientNo~" + getClientNo() +"~S" +
               "$#~cTxFormNo~" + getTxFormNo() +"~S" + 
               "$#~cPersonTypeID~" + getPersonType().getTypeID() +"~S" +  
               "$cCivilStatus~" + getCivilStatus() + "~S" +
               "$dDateOfBirth~" + ((getDateOfBirth() != null) ? (DateUtil.toString(getDateOfBirth(), "yyyy-MM-dd") + "~D") : (getDateOfBirth() + "~N")) + 
               "$cEducation~" + getEducation() + "~S" +
               "$cFirstName~" + getFirstName() + "~S" + 
               "$cGender~" + getGender() + "~S" +
               "$cLastName~" + getLastName() + "~S" + 
               "$cMiddleName~" + getMiddleName() + "~S" +
               "$cNickName~" + getNickName() + "~S" + 
               "$cPlaceOfBirth~" + getPlaceOfBirth() + "~S" +
               "$cReligionId~" + ((getReligion() != null) ? (getReligion().getReligionID() + "~S") : (getReligion() + "~N")) + 
               "$cCitizenship~" + getCitizenship() + "~S" +
               "$cContactNo~" + getContactNo() + "~S" +  
               "$cTribeId~" + ((getTribe() != null) ? (getTribe().getTribeID() + "~S") : (getTribe() + "~N"))).replace("'", " ");  
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
