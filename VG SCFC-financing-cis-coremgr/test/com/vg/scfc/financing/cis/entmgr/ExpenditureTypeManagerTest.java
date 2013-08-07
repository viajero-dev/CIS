/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.scfc.financing.cis.ent.ExpenditureType;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffy
 */
public class ExpenditureTypeManagerTest {
    
    public ExpenditureTypeManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ConnectionProperties.setupConnection("localhost", "vgcis", "root", "root", false);
        CommonsUtil.setSessionFactory(ClientInfoUtil.getSessionFactory());
        HrmUserUtil.setSessionFactory(ClientInfoUtil.getSessionFactory());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of findById method, of class ExpenditureTypeManager.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int expenditureTypeId = 1;

        ExpenditureType result = ExpenditureTypeManager.getInstance().findById(expenditureTypeId);
        assertNotNull(result);
        
        System.out.println(result.getDescription());
    }

    /**
     * Test of getAll method, of class ExpenditureTypeManager.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        
        List result = ExpenditureTypeManager.getInstance().getAll();
        assertNotNull(result);

        for (Object object : result) {
            System.out.println( ((ExpenditureType) object).getDescription() );
        }
    }
}
