/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ent;

import java.io.Serializable;
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
@Table(name="religion")
public class Religion implements Serializable {
    private String religionID;
    private String religionDesc;
    private int version;

    @Column(name="cDesc")
    public String getReligionDesc() {
        return religionDesc;
    }

    @Id
    @Column(name="cReligionID")
    public String getReligionID() {
        return religionID;
    }

    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    
    public void setReligionDesc(String religionDesc) {
        this.religionDesc = religionDesc;
    }

    public void setReligionID(String religionID) {
        this.religionID = religionID;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String toString() {
        return religionID + " - " + religionDesc + " - " + version;
    }
}
