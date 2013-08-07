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
public class FamilyPk implements Serializable {
    
    private String txFormNo;
    private PersonType personType;
    private String famRelation;

    @OneToOne
    @JoinColumn(name="cPersonTypeID")
    public PersonType getPersonType() {
        return personType;
    }

    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    @Column(name = "cFamRelation")
    public String getFamRelation() {
        return famRelation;
    }
    
    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public void setTxFormNo(String txFormNo) {
        this.txFormNo = txFormNo;
    }
    
    public void setFamRelation(String famRelation) {
        this.famRelation = famRelation;
    }
        
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FamilyPk other = (FamilyPk) obj;
        if (!Objects.equals(this.txFormNo, other.txFormNo)) {
            return false;
        }
        if (!Objects.equals(this.personType, other.personType)) {
            return false;
        }
        if (!Objects.equals(this.famRelation, other.famRelation)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.txFormNo);
        hash = 79 * hash + Objects.hashCode(this.personType);
        hash = 79 * hash + Objects.hashCode(this.famRelation);
        return hash;
    }

    @Override
    public String toString() {
        return getTxFormNo() + "-" + personType.getTypeID() + "-" + famRelation;
    }
}
