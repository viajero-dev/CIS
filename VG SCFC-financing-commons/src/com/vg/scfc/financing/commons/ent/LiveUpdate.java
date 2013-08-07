/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.ent;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author raffy
 */
@Entity
@Table(name = "liveUpdate")
public class LiveUpdate implements Serializable {

    private String transNo;
    private String sqlStatement;
    private String status;
    private Date timeStamp;
    private int sendCount;
    private boolean specialTransaction;
    private String branchCode;

    @Column(name = "cSqlStatement")
    public String getSqlStatement() {
        return sqlStatement;
    }

    @Column(name = "cStatus")
    public String getStatus() {
        return status;
    }

    @Column(name = "dDateTimeStamp", length = 21)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimeStamp() {
        return timeStamp;
    }

    @Column(name = "nSendCount")
    public int getSendCount() {
        return sendCount;
    }

    @Id
    @Column(name = "cTransNo")
    public String getTransNo() {
        return transNo;
    }

    @Column(name = "cBranchCode")
    public String getBranchCode() {
        return branchCode;
    }

    @Column(name = "lIsSpecialTransaction")
    public boolean isSpecialTransaction() {
        return specialTransaction;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setSendCount(int sendCount) {
        this.sendCount = sendCount;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public void setSpecialTransaction(boolean specialTransaction) {
        this.specialTransaction = specialTransaction;
    }
}
