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
@Table(name = "com_accgroup", catalog = "vgdb")
public class AccountGroup implements Serializable {

    private String accGroupCode;
    private String accGroupDesc;

    //Getter and Setter
    @Id
    @Column(name = "cAccGroup")
    public String getAccGroupCode() {
        return accGroupCode.trim();
    }

    @Column(name = "cDesc")
    public String getAccGroupDesc() {
        return accGroupDesc.trim();
    }

    public void setAccGroupDesc(String accGroupDesc) {
        this.accGroupDesc = accGroupDesc;
    }

    public void setAccGroupCode(String accGroupCode) {
        this.accGroupCode = accGroupCode;
    }

    @Override
    public String toString() {
        return accGroupCode + " : " + accGroupDesc;
    }
//  
}
