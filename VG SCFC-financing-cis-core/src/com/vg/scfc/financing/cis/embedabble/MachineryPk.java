/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.embedabble;

import com.vg.scfc.financing.cis.ent.Asset;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author raffy
 */

@Embeddable
public class MachineryPk implements Serializable {
    
    private Asset asset;
    private int lineNo;
    
    @ManyToOne
    public Asset getAsset() {
        return asset;
    }

    @Column(name="nLineNo")
    public int getLineNo() {
        return lineNo;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MachineryPk other = (MachineryPk) obj;
        if (!Objects.equals(this.asset, other.asset)) {
            return false;
        }
        if (this.lineNo != other.lineNo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.asset);
        hash = 79 * hash + this.lineNo;
        return hash;
    }

    @Override
    public String toString() {
        return asset.getTxFormNo() + "-" + lineNo;
    }
}
