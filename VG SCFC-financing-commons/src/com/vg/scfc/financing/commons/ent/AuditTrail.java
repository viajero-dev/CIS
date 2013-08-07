/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.ent;

import com.vg.hrm.user.ent.Employee;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import com.vg.scfc.financing.commons.util.DateUtil;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author raffy
 */
@Entity
@Table(name = "auditTrail")
public class AuditTrail implements Serializable, LiveUpdateService {

    private Date timeStamp;
    private String station;
    private String transNo;
    private String action;
    private String detail;
    private Employee user;
    private String txNo;
    private String systemName;

    public AuditTrail() {
    }

    public AuditTrail(String station, String transNo, String action, String detail, Employee user, String systemName) {
        this.station = station;
        this.transNo = transNo;
        this.action = action;
        this.detail = detail;
        this.user = user;
        this.systemName = systemName;
    }

    @Column(name = "cAction")
    public String getAction() {
        return action;
    }

    @Column(name = "cDetail")
    public String getDetail() {
        return detail;
    }

    @Column(name = "cStation")
    public String getStation() {
        return station;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dTimeStamp", columnDefinition = "DATETIME")
    public Date getTimeStamp() {
        return timeStamp;
    }

    @Column(name = "cTransNo")
    public String getTransNo() {
        return transNo;
    }

    @OneToOne
    @JoinColumn(name = "cUserID", columnDefinition = "VARCHAR(50)")
    public Employee getUser() {
        return user;
    }

    @Column(name = "cSystem", columnDefinition = "VARCHAR(50)")
    public String getSystemName() {
        return systemName;
    }

    @Id
    @Column(name = "cTransNoID", columnDefinition = "VARCHAR(50)")
    public String getTxNo() {
        return txNo;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setTxNo(String txNo) {
        this.txNo = txNo;
    }

    @Transient
    @Override
    public String getDetailForSql() {
        return ("com_trail"
                + "$#~cTransNoID~" + this.txNo + "~S"
                + "$cAction~" + this.action + "~S"
                + "$cDetail~" + this.detail + "~S"
                + "$cStation~" + this.station + "~S"
                + "$cSystem~" + this.systemName + "~S"
                + "$dTimeStamp~" + (this.timeStamp != null ? DateUtil.toString(this.timeStamp, "yyyy-MM-dd HH:mm:ss") : " ") + "~D"
                + "$cTransNo~" + (this.transNo != null ? this.transNo : " ") + "~S"
                + "$cUserID~" + (this.user.getId() != null ? this.user.getId() : " ") + "~S").replace("'", "");
    }

    @Transient
    @Override
    public boolean isSpecialTransaction() {
        return false;
    }

    @Transient
    @Override
    public String getBranchCode() {
        return "V001";
    }
}
