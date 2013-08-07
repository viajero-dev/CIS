/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.service;

import com.vg.hrm.user.ent.Employee;

/**
 *
 * @author vmi-prog1
 */
public interface AuditTrailService {

    public String getDetail();

    public String getStation();

    public String getTransNo();

    public String getActionTarget();

    public String getSystemName();

    public Employee getUser();
}
