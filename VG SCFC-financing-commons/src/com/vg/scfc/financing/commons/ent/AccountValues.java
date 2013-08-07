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
@Table(name = "com_accvalues")
public class AccountValues implements Serializable {

    private String accValueCode;
    private String accValueDesc;

    //Getter and Setter
    @Id
    @Column(name = "cAccVal")
    public String getAccValueCode() {
        return accValueCode.trim();
    }

    @Column(name = "cDesc")
    public String getAccValueDesc() {
        return accValueDesc.trim();
    }

    public void setAccValueDesc(String accValueDesc) {
        this.accValueDesc = accValueDesc;
    }

    public void setAccValueCode(String accValueCode) {
        this.accValueCode = accValueCode;
    }

    @Override
    public String toString() {
        return accValueCode + " : " + accValueDesc;
    }
}
