/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.hrm.user.entmgr.EmployeeManager;
import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.scfc.financing.cis.ent.CreditRef;
import com.vg.scfc.financing.commons.entmgr.LocationManager;
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
public class CreditRefManagerTest {
    
    public CreditRefManagerTest() {
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
    
    private CreditRef createCreditRef() {
        CreditRef creditRef = new CreditRef();
        creditRef.setTxFormNo("G2080500001");
        creditRef.setCreItem("MC");
        creditRef.setCreRefAddress("JCAT");
        creditRef.setCreRefAmountPaid(25000);
        creditRef.setCreRefBalance(86000);
        creditRef.setCreRefLoanAmount(103000);
        creditRef.setCreRefMonthly(3000);
        creditRef.setCreRefName("VMI");
        creditRef.setCreRefTerm("30");
        
        creditRef.setLocation(LocationManager.getInstance().findByID("V003"));
        creditRef.setStation("Raff-PC");
        creditRef.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return creditRef;
    }

    /**
     * Tested on 2013-08-05 16:27
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        CreditRef creditRef = createCreditRef();
        
        boolean expResult = true;
        boolean result = CreditRefManager.getInstance().insert(creditRef);
        assertEquals(expResult, result);
    }
    
    private CreditRef editedCreditRef() {
        CreditRef creditRef = CreditRefManager.getInstance()
                .findById("G2080500001", 2);
        
        creditRef.setCreItem("ENGINE");
        creditRef.setCreRefAddress("TORIL");
        creditRef.setCreRefAmountPaid(15000);
        creditRef.setCreRefBalance(15000);
        creditRef.setCreRefLoanAmount(30000);
        creditRef.setCreRefMonthly(5000);
        creditRef.setCreRefName("JICJAM TORIL");
        creditRef.setCreRefTerm("6");
        
        creditRef.setLocation(LocationManager.getInstance().findByID("V003"));
        creditRef.setStation("Raff-PC");
        creditRef.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return creditRef;
    }

    /**
     * Tested 2013-08-05 16:35
     */
    @Ignore       
    @Test
    public void testUpdate() {
        System.out.println("update");
        CreditRef creditRef = editedCreditRef();
        
        boolean expResult = true;
        boolean result = CreditRefManager.getInstance().update(creditRef);
        assertEquals(expResult, result);
    }

    /**
     * Tested on 2013-08-05 16:30
     */
    @Ignore
    @Test
    public void testFindById() {
        System.out.println("findById");
        String formNo = "G2080500001";
        int lineNo = 1;

        CreditRef result = CreditRefManager.getInstance().findById(formNo, lineNo);
        assertNotNull(result);
        
        System.out.println(result.getCreRefName());
    }

    /**
     * Tested 2013-08-05 16:37
     */
    @Ignore
    @Test
    public void testFindByFormNo() throws Exception {
        System.out.println("findByFormNo");
        String formNo = "G2080500001";

        List result = CreditRefManager.getInstance().findByFormNo(formNo);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println( ((CreditRef) object).getCreRefName() );
        }
    }

    /**
     * Tested on 2013-08-05 16:28
     */
    @Ignore
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        CreditRef creditRef = new CreditRef();
        creditRef.setTxFormNo("G2080500001");
        creditRef.setCreRefName("VMI");
        
        boolean expResult = true;
        boolean result = CreditRefManager.getInstance().isExist(creditRef);
        assertEquals(expResult, result);
    }
}
