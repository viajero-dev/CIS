/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.ent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jp
 */
@Entity
@Table(name = "com_accclass", catalog = "vgdb")
public class AccountClass implements Serializable {

    private String accClassCode;
    private String accClassDesc;

    @Id
    @Column(name = "cAccClass")
    public String getAccClassCode() {
        return accClassCode.trim();
    }

    @Column(name = "cDesc")
    public String getAccClassDesc() {
        return accClassDesc.trim();
    }

    public void setAccClassDesc(String accClassDesc) {
        this.accClassDesc = accClassDesc;
    }

    public void setAccClassCode(String accClassCode) {
        this.accClassCode = accClassCode;
    }

    @Override
    public String toString() {
        return accClassCode + " : " + accClassDesc;
    }
}
