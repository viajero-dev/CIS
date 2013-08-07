/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.interceptor;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.service.AuditTrailService;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jp
 */
public class ClientInfoInterceptor extends EmptyInterceptor {

    private List trailDetails = new ArrayList();
    private List<String> trailActions = new ArrayList<String>();
    private List updateDetails = new ArrayList();
    private List<String> updateActions = new ArrayList<String>();
    private Session session;
    private Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

        if (entity instanceof AuditTrailService) {
            if (!trailDetails.contains(entity)) {
                trailDetails.add(entity);
                trailActions.add("INSERT");
            }
        }

        if (entity instanceof LiveUpdateService) {
            if (!updateDetails.contains(entity)) {
                updateDetails.add(entity);
                updateActions.add("INSERT");
            }
        }
        return false;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof AuditTrailService) {
            if (!trailDetails.contains(entity)) {
                trailDetails.add(entity);
                trailActions.add("UPDATE");
            }
        }

        if (entity instanceof LiveUpdateService) {
            if (!updateDetails.contains(entity)) {
                updateDetails.add(entity);
                updateActions.add("UPDATE");
            }
        }
        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof AuditTrailService) {
            if (!trailDetails.contains(entity)) {
                trailDetails.add(entity);
                trailActions.add("DELETE");
            }
        }

        if (entity instanceof LiveUpdateService) {
            if (!updateDetails.contains(entity)) {
                updateDetails.add(entity);
                updateActions.add("DELETE");
            }
        }
    }

    @Override
    public void postFlush(Iterator entities) {


        try {
            for (int i = 0; i < trailDetails.size(); i++) {
                ClientInfoInterceptorUtil.logTrailNow(trailActions.get(i), (AuditTrailService) trailDetails.get(i), location, session.connection());
            }
            for (int i = 0; i < updateDetails.size(); i++) {
                ClientInfoInterceptorUtil.logLiveUpdateNow(updateActions.get(i), (LiveUpdateService) updateDetails.get(i), location, session.connection());
            }


        } catch (Exception e) {
            System.out.println("FLUSH ERROR: " + e);
            LoggerFactory.getLogger(ClientInfoInterceptor.class).error(StringUtils.formatException(e));
        } finally {
            trailDetails.clear();
            trailActions.clear();

            updateDetails.clear();
            updateActions.clear();

        }
    }
}
