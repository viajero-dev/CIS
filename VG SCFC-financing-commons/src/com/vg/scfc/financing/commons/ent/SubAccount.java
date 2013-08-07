/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.ent;

import com.vg.hrm.user.ent.Employee;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author user
 */
@Entity
@Table(name = "com_subcode", catalog = "vgdb")
public class SubAccount implements Serializable {

    public static final int ALL = 1;
    public static final int SUPPLIER = 2;
    public static final int CUSTOMER = 3;
    public static final int AGENT = 4;
    public static final int EMPLOYEE = 5;
    public static final int BANK = 6;
    public static final int BRANCH = 7;
    public static final int FORWARDER = 8;
    private String code;
    private String name;
    private String classType;
    private String additionalDescription;
    private String oldCode;
    private String groupForFinancing;
    private Employee encoder;

    @Column(name = "cAddtlDesc")
    @NotFound(action = NotFoundAction.IGNORE)
    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    @Column(name = "cClassFinancing")
    public String getGroupForFinancing() {
        return groupForFinancing;
    }

    public void setGroupForFinancing(String groupForFinancing) {
        this.groupForFinancing = groupForFinancing;
    }

    @Column(name = "cClass")
    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Id
    @Column(name = "cSubcode")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToOne
    @JoinColumn(name = "cEncoder")
    public Employee getEncoder() {
        return encoder;
    }

    public void setEncoder(Employee encoder) {
        this.encoder = encoder;
    }

    @Column(name = "cSubname")
    @NotFound(action = NotFoundAction.IGNORE)
    public String getName() {
        name = name.trim();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "cOldCode")
    @NotFound(action = NotFoundAction.IGNORE)
    public String getOldCode() {
        return oldCode;
    }

    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}
