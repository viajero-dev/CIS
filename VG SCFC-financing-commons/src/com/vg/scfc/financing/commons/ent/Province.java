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
 * @author enesgee
 */
@Entity
@Table(name = "com_province", catalog = "vgdb")
public class Province implements Serializable {

    private String id;
    private String name;
    private String code;

    @Column(name = "cProvcode")
    public String getCode() {
        return code;
    }

    @Id
    @Column(name = "cProvID")
    public String getId() {
        return id;
    }

    @Column(name = "cProvince")
    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }
}
