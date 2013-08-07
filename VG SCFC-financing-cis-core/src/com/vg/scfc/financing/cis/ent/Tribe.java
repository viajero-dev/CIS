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
@Table(name="tribe")
public class Tribe implements Serializable {
    
    private String tribeID;
    private String tribeDesc;
    private int version;
    
    @Column(name="cDesc")
    public String getTribeDesc() {
        return tribeDesc;
    }

    @Id
    @Column(name="cTribeID")
    public String getTribeID() {
        return tribeID;
    }
    
    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }

    public void setTribeDesc(String tribeDesc) {
        this.tribeDesc = tribeDesc;
    }

    public void setTribeID(String tribeID) {
        this.tribeID = tribeID;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
