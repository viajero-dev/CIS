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
 * @author raffy
 */

@Entity
@Table(name="expenditureType")
public class ExpenditureType implements Serializable {
    
    private int id;
    private String description;
    private int version;

    @Column(name="cDescription")
    public String getDescription() {
        return description;
    }

    @Id
    @Column(name="nId")
    public int getId() {
        return id;
    }

    @Version
    @Column(name="nVersion")
    public int getVersion() {
        return version;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
