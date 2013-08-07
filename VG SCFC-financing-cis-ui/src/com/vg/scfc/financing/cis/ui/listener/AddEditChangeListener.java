/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.ui.listener;

/**
 *
 * @author rodel
 */
public interface AddEditChangeListener {

    public void onAdd();

    public boolean onSaveAdd();

    public void onCancelAdd();

    public void onEdit();

    public boolean onSaveEdit();

    public void onCancelEdit();

    public void onChange();

    public boolean onSaveChange();

    public void onCancelChange();
}
