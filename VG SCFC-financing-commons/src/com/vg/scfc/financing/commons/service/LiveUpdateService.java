/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.commons.service;

/**
 *
 * @author vmi-prog1
 */
public interface LiveUpdateService {

    public String getDetailForSql();

    public boolean isSpecialTransaction();

    public String getBranchCode();
}
