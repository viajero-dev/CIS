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
 * @author raffy
 */

@Embeddable
public class RepresentativeEmploymentPk implements Serializable {
    
    private String txFormNo;
    private PersonType personType;

    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    @OneToOne
    @JoinColumn(name="cPersonTypeID")
    public PersonType getPersonType() {
        return personType;
    }

    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RepresentativeEmploymentPk other = (RepresentativeEmploymentPk) obj;
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
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.txFormNo);
        hash = 71 * hash + Objects.hashCode(this.personType);
        return hash;
    }

    @Override
    public String toString() {
        return txFormNo + "-" + personType.getTypeID();
    }
}
