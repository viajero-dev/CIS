/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.interceptor;

import com.vg.commons.util.StringUtils;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.ent.AuditTrail;
import com.vg.scfc.financing.commons.ent.LiveUpdate;
import com.vg.scfc.financing.commons.ent.Location;
import com.vg.scfc.financing.commons.entmgr.AuditTrailManager;
import com.vg.scfc.financing.commons.entmgr.LiveUpdateManager;
import com.vg.scfc.financing.commons.service.AuditTrailService;
import com.vg.scfc.financing.commons.service.LiveUpdateService;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import java.sql.Connection;
import java.util.Date;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jp
 */
public class ClientInfoInterceptorUtil {

    public static void logTrailNow(String action, AuditTrailService trail, Location location, Connection conn) throws Exception {
        ClientInfoInterceptor interceptor = new ClientInfoInterceptor();
        Session session = ClientInfoUtil.getSessionFactory().openSession(conn, interceptor);
        interceptor.setSession(session);
        interceptor.setLocation(location);
        int x = 0;
        do {
            String actionStr = action + " " + trail.getActionTarget();
            try {
                String lastTransNo = AuditTrailManager.getInstance().findLastTransNoBySystemName(session, "CIS");
                AuditTrail cisTrail = new AuditTrail();
                cisTrail.setTxNo(StringUtils.generateNextTransNoBySystem(lastTransNo));
                cisTrail.setTimeStamp(new Date());
                cisTrail.setStation(trail.getStation());
                cisTrail.setTransNo(trail.getTransNo());
                cisTrail.setAction(actionStr);
                cisTrail.setDetail(trail.getDetail());
                cisTrail.setUser(trail.getUser());
                cisTrail.setSystemName("CIS");

                session.save(cisTrail);
                session.flush();

                x = 10;
            } catch (Exception e) {
                System.out.println("LOG ERROR: " + e);
                LoggerFactory.getLogger(ClientInfoInterceptorUtil.class).error(StringUtils.formatException(e));
                x++;
            }

        } while (x < 5);
        if (session != null) {
            session.close();
        }
    }

    public static void logLiveUpdateNow(String action, LiveUpdateService live, Location location, Connection conn) {
        Session session = ClientInfoUtil.getSessionFactory().openSession(conn);
        session.beginTransaction();

        String lastTransNo = "";

        int x = 0;
        do {
            try {
                lastTransNo = LiveUpdateManager.getInstance().findLastTransNoBySystemName(session, "CIS");

                if (!ConnectionProperties.isUsingCentralDb()) {
                    LiveUpdate liveUpdate = new LiveUpdate();
                    liveUpdate.setTransNo(StringUtils.generateNextTransNoBySystem(lastTransNo));
                    liveUpdate.setSqlStatement(StringUtils.toSQLCommand(action, live.getDetailForSql()));
                    liveUpdate.setStatus("N");
                    liveUpdate.setSendCount(0);
                    liveUpdate.setBranchCode(live.getBranchCode());
                    liveUpdate.setSpecialTransaction(live.isSpecialTransaction());

                    session.save(liveUpdate);
                    session.flush();

                } else {
                    if (!location.getId().equalsIgnoreCase("V002") & !location.getId().endsWith("001")) {
                        LiveUpdate liveUpdate = new LiveUpdate();
                        liveUpdate.setTransNo(StringUtils.generateNextTransNoBySystem(lastTransNo));
                        liveUpdate.setSqlStatement(StringUtils.toSQLCommand(action, live.getDetailForSql()));
                        liveUpdate.setStatus("N");
                        liveUpdate.setSendCount(0);
                        liveUpdate.setBranchCode(location.getId());
                        liveUpdate.setSpecialTransaction(live.isSpecialTransaction());

                        session.save(liveUpdate);
                        session.flush();
                    }
                }
                x = 10;
            } catch (Exception e) {
                System.out.println("LU: " + e);
                LoggerFactory.getLogger(ClientInfoInterceptorUtil.class).error(StringUtils.formatException(e));
                x++;
            }
        } while (x < 5);

        if (session != null) {
            session.close();
        }

    }
}
