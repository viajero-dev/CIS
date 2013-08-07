/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.embedabble;

import com.vg.scfc.financing.cis.ent.Asset;
import com.vg.scfc.financing.cis.ent.LandType;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author raffy
 */

@Embeddable
public class LandPk implements Serializable {
    
    private Asset asset;
    private LandType landType;

    @ManyToOne
    public Asset getAsset() {
        return asset;
    }

    @OneToOne
    @JoinColumn(name="nLandTypeId")
    public LandType getLandType() {
        return landType;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LandPk other = (LandPk) obj;
        if (!Objects.equals(this.asset, other.asset)) {
            return false;
        }
        if (!Objects.equals(this.landType, other.landType)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.asset);
        hash = 43 * hash + Objects.hashCode(this.landType);
        return hash;
    }

    @Override
    public String toString() {
        return asset.getTxFormNo() + "-" + landType.getId();
    }
}