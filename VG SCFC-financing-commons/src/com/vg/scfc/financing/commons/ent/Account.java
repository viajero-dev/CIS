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

/**
 *
 * @author enesgee
 */
@Entity
@Table(name = "com_acc", catalog="vgdb")
public class Account implements Serializable {

    private String code;
    private String name;
    private String normalBalance;
    private String description;
    private boolean forCentral;
    private boolean forBranch;
    private boolean forDealer;
    private boolean forFinancing;
    private boolean discontinued;
    private Employee encoder;

    @Id
    @Column(name = "cAccCode")
    public String getCode() {
        return code;
    }

    @Column(name = "cDescription")
    public String getDescription() {
        return description;
    }

    @Column(name = "lisDiscon")
    public boolean isDiscontinued() {
        return discontinued;
    }

    @OneToOne
    @JoinColumn(name = "cEncoder")
    public Employee getEncoder() {
        return encoder;
    }

    @Column(name = "lisForBranch")
    public boolean isForBranch() {
        return forBranch;
    }

    @Column(name = "lisForCentral")
    public boolean isForCentral() {
        return forCentral;
    }

    @Column(name = "lisForDealer")
    public boolean isForDealer() {
        return forDealer;
    }

    @Column(name = "lisForFinancing")
    public boolean isForFinancing() {
        return forFinancing;
    }

    @Column(name = "cAccName")
    public String getName() {
        return name;
    }

    @Column(name = "cNorBal")
    public String getNormalBalance() {
        return normalBalance;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public void setEncoder(Employee encoder) {
        this.encoder = encoder;
    }

    public void setForBranch(boolean forBranch) {
        this.forBranch = forBranch;
    }

    public void setForCentral(boolean forCentral) {
        this.forCentral = forCentral;
    }

    public void setForDealer(boolean forDealer) {
        this.forDealer = forDealer;
    }

    public void setForFinancing(boolean forFinancing) {
        this.forFinancing = forFinancing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNormalBalance(String normalBalance) {
        this.normalBalance = normalBalance;
    }

    @Override
    public String toString() {
        return code + " - " + description;
    }
}
