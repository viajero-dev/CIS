/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.embedabble;

import com.vg.scfc.financing.cis.ent.PersonType;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author jp
 */
@Embeddable
public class EmploymentPk implements Serializable {
    
    private String txFormNo;
    private PersonType personType;

    @OneToOne
    @JoinColumn(name="cPersonTypeID")
    public PersonType getPersonType() {
        return personType;
    }

    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmploymentPk other = (EmploymentPk) obj;
        if (!Objects.equals(this.txFormNo, other.txFormNo)) {
            return false;
        }
        if (!Objects.equals(this.personType, other.personType)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.txFormNo);
        hash = 23 * hash + Objects.hashCode(this.personType);
        return hash;
    }

    @Override
    public String toString() {
        return getTxFormNo() + "-" + personType.getTypeID();
    }
}
