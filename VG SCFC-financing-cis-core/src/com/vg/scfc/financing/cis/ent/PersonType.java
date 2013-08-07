package com.vg.scfc.financing.cis.ent;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jp
 */
@Entity
@Table(name="personType")
public class PersonType implements Serializable {
    
    private String typeID;
    private String typeDesc;
    private int version;
    
    @Column(name="cTypeDesc")
    public String getTypeDesc() {
        return typeDesc;
    }

    @Id
    @Column(name="cTypeID")
    public String getTypeID() {
        return typeID;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
