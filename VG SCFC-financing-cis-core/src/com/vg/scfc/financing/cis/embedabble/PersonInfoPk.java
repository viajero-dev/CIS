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
public class PersonInfoPk implements Serializable {
    
    private String clientNo;
    private String txFormNo;
    private PersonType personType;

    @OneToOne
    @JoinColumn(name="cPersonTypeID")
    public PersonType getPersonType() {
        return personType;
    }

    @Column(name="cClientNo")
    public String getClientNo() {
        return clientNo;
    }

    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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
        final PersonInfoPk other = (PersonInfoPk) obj;
        if (!Objects.equals(this.clientNo, other.clientNo)) {
            return false;
        }
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
        hash = 97 * hash + Objects.hashCode(this.clientNo);
        hash = 97 * hash + Objects.hashCode(this.txFormNo);
        hash = 97 * hash + Objects.hashCode(this.personType);
        return hash;
    }

    @Override
    public String toString() {
        return clientNo + "-" + getTxFormNo() + "-" + personType.getTypeID();
    }
}
