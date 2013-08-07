/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.scfc.financing.commons.entmgr.LocationManager;
import com.vg.hrm.user.entmgr.EmployeeManager;
import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.scfc.financing.cis.ent.Dependent;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffy
 */
public class DependentManagerTest {
    
    public DependentManagerTest() {
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
    
    private Dependent createDependent() {
        Dependent dependent = new Dependent();
        dependent.setTxFormNo("G2080500001");
        dependent.setDepAddress("Davao");
        dependent.setDepContactNo("09097117108");
        dependent.setDepName("rafiboy");
        dependent.setDepRelation("boy");
                
        dependent.setLocation(LocationManager.getInstance().findByID("V003"));
        dependent.setStation("Raff-PC");
        dependent.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return dependent;
    }

    /**
     * Tested 2013-08-05 17:02
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        Dependent dependent = createDependent();
        
        boolean expResult = true;
        boolean result = DependentManager.getInstance().insert(dependent);
        assertEquals(expResult, result);
    }
    
    private Dependent editedDependent() {
        Dependent dependent = DependentManager.getInstance()
                .findById("G2080500001", 2);
        
        dependent.setDepAddress("General Santos City");
        dependent.setDepContactNo("contact here");
        dependent.setDepName("Ruffa");
        dependent.setDepRelation("no relation");
                
        dependent.setLocation(LocationManager.getInstance().findByID("V003"));
        dependent.setStation("Raff-PC");
        dependent.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return dependent;
    }

    /**
     * Tested 2013-08-05 17:10
     */
    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");
        Dependent dependent = editedDependent();
        
        boolean expResult = true;
        boolean result = DependentManager.getInstance().update(dependent);
        assertEquals(expResult, result);
    }

    /**
     * Tested 2013-08-05 17:04
     */
    @Ignore
    @Test
    public void testFindById() {
        System.out.println("findById");
        String formNo = "G2080500001";
        int lineNo = 1;

        Dependent result = DependentManager.getInstance().findById(formNo, lineNo);
        assertNotNull(result); 
        
        System.out.println(result.getDepName());
    }

    /**
     * Tested 2013-08-05 17:18
     */
    @Ignore
    @Test
    public void testFindByFormNo() throws Exception {
        System.out.println("findByFormNo");
        String formNo = "G2080500001";
        DependentManager instance = new DependentManager();
        
        List result = DependentManager.getInstance().findByFormNo(formNo);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println( ((Dependent) object).getDepName() );
        }
    }

    /**
     * Tested 2013-08-05 16:57
     */
    @Ignore
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        Dependent dependent = new Dependent();
        dependent.setTxFormNo("G2080500001");
        dependent.setDepName("rafiboy");
        
        boolean expResult = true;
        boolean result = DependentManager.getInstance().isExist(dependent);
        assertEquals(expResult, result);
    }
}
