/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.ent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vmi-prog1
 */
@Entity
@Table(name = "com_lusetting")
public class UpdateSetting implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "nID", columnDefinition = "INTEGER(20)")
    private int id;
    @Column(name = "nQ1Interval", columnDefinition = "INTEGER(20)")
    private int q1_Interval;
    @Column(name = "nQ2Interval", columnDefinition = "INTEGER(20)")
    private int q2_Interval;
    @Column(name = "nQ3Interval", columnDefinition = "INTEGER(20)")
    private int q3_Interval;
    @Column(name = "cCurrLocation", columnDefinition = "VARCHAR(25)")
    private String currLocation;
    @Column(name = "cIpAddress", columnDefinition = "VARCHAR(25)")
    private String ipAddress;
    @Column(name = "nPort", columnDefinition = "INTEGER(20)")
    private int port;
    @Column(name = "nServerTimeOut", columnDefinition = "INTEGER(20)")
    private int serverTimeOut = 0;
    @Column(name = "nClientTimeOut", columnDefinition = "INTEGER(20)")
    private int clientTimeOut = 30000;

    public String getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(String currLocation) {
        this.currLocation = currLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQ1_Interval() {
        return q1_Interval;
    }

    public void setQ1_Interval(int q1_Interval) {
        this.q1_Interval = q1_Interval;
    }

    public int getQ2_Interval() {
        return q2_Interval;
    }

    public void setQ2_Interval(int q2_Interval) {
        this.q2_Interval = q2_Interval;
    }

    public int getQ3_Interval() {
        return q3_Interval;
    }

    public void setQ3_Interval(int q3_Interval) {
        this.q3_Interval = q3_Interval;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getClientTimeOut() {
        return clientTimeOut;
    }

    public void setClientTimeOut(int clientTimeOut) {
        this.clientTimeOut = clientTimeOut;
    }

    public int getServerTimeOut() {
        return serverTimeOut;
    }

    public void setServerTimeOut(int serverTimeOut) {
        this.serverTimeOut = serverTimeOut;
    }
}
