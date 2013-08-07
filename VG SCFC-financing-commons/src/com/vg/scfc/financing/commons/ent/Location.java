/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.ent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author java
 */
@Entity
@Table(name = "com_location", catalog = "vgdb")
public class Location implements Serializable {

    private String id;
    private String description;
    private String subAccount;
    private String centralOffice;
    private String oldIdForDealer;
    private String oldIdForFinancing;
    private boolean discontinued;
    private String finCode;
    private String finStartCode;
    
    
    @OneToOne
    @JoinColumn(name = "cMain")
    public String getCentralOffice() {
        return centralOffice;
    }

    @Column(name = "cLocationDesc")
    public String getDescription() {
        return description;
    }

    @Column(name = "lisDiscon")
    public boolean isDiscontinued() {
        return discontinued;
    }

    @Id
    @Column(name = "cLocationID")
    public String getId() {
        return id;
    }

    @Column(name = "cOldLoc")
    public String getOldIdForDealer() {
        return oldIdForDealer;
    }

    @Column(name = "cOldCode")
    public String getOldIdForFinancing() {
        return oldIdForFinancing;
    }

    @OneToOne
    @JoinColumn(name = "cSubCode")
    public String getSubAccount() {
        return subAccount;
    }

    @Column(name="cFinCode")
    public String getFinCode() {
        return finCode;
    }

    @Column(name="cFinBegCode")
    public String getFinStartCode() {
        return finStartCode;
    }
    
    

    public void setCentralOffice(String centralOffice) {
        this.centralOffice = centralOffice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOldIdForDealer(String oldIdForDealer) {
        this.oldIdForDealer = oldIdForDealer;
    }

    public void setOldIdForFinancing(String oldIdForFinancing) {
        this.oldIdForFinancing = oldIdForFinancing;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }

    public void setFinStartCode(String finStartCode) {
        this.finStartCode = finStartCode;
    }
    
    

    @Override
    public String toString() {
        return this.id + " - " + this.description;
    }
}
