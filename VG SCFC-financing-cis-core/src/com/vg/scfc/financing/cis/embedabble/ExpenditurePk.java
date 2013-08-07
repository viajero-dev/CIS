/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.embedabble;

import com.vg.scfc.financing.cis.ent.ExpenditureType;
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
public class ExpenditurePk implements Serializable {
    
    private String txFormNo;
    private ExpenditureType expenditureType;

    @OneToOne
    @JoinColumn(name="cExpTypeId")
    public ExpenditureType getExpenditureType() {
        return expenditureType;
    }

    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    public void setExpenditureType(ExpenditureType expenditureType) {
        this.expenditureType = expenditureType;
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
        final ExpenditurePk other = (ExpenditurePk) obj;
        if (!Objects.equals(this.txFormNo, other.txFormNo)) {
            return false;
        }
        if (!Objects.equals(this.expenditureType, other.expenditureType)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.txFormNo);
        hash = 79 * hash + Objects.hashCode(this.expenditureType);
        return hash;
    }

    @Override
    public String toString() {
        return txFormNo + "-" + expenditureType.getId();
    }
}
