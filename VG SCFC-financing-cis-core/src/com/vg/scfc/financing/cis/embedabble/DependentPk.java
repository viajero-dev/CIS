/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.embedabble;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jp
 */
@Embeddable
public class DependentPk implements Serializable {
    
    private String txFormNo;
    private int lineNo;
    
    @Column(name="nLineNo")
    public int getLineNo() {
        return lineNo;
    }

    @Column(name="cTxFormNo")
    public String getTxFormNo() {
        return txFormNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
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
        final DependentPk other = (DependentPk) obj;
        if (!Objects.equals(this.txFormNo, other.txFormNo)) {
            return false;
        }
        if (this.lineNo != other.lineNo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.txFormNo);
        hash = 53 * hash + this.lineNo;
        return hash;
    }

    @Override
    public String toString() {
        return txFormNo + "-" + lineNo;
    }
}
