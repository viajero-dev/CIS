/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.value;

import com.vg.hrm.user.ent.User;
import com.vg.scfc.financing.commons.ent.Location;
import java.io.Serializable;

/**
 *
 * @author raffy
 */
public class ClientInfoSetting implements Serializable {
    
    private static ClientInfoSetting instance;
    private User user;
    private Location location;
    private String station;

    public static ClientInfoSetting getInstance() {
        if(instance == null) instance = new ClientInfoSetting();
        return instance;
    }
    
    public Location getLocation() {
        return location;
    }

    public String getStation() {
        return station;
    }

    public User getUser() {
        return user;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
