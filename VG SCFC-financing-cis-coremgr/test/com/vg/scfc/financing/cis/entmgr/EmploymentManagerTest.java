/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import com.vg.hrm.user.entmgr.EmployeeManager;
import com.vg.scfc.financing.commons.entmgr.LocationManager;
import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.scfc.financing.cis.ent.Employment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffy
 */
public class EmploymentManagerTest {
    
    public EmploymentManagerTest() {
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
    
    private Employment createEmployment() {
        Employment employment = new Employment();
        employment.setTxFormNo("G2080500001");
        employment.setPersonType(PersonTypeManager.getInstance().findById("APP"));
        
        employment.setEmpCompany("VIAJERO MOTOR'SALES");
        
        employment.setLocation(LocationManager.getInstance().findByID("V003"));
        employment.setStation("Raff-PC");
        employment.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return employment;
    }

    /**
     * Test of insert method, of class EmploymentManager.
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        Employment employment = createEmployment();

        boolean expResult = true;
        boolean result = EmploymentManager.getInstance().insert(employment);
        assertEquals(expResult, result);
    }
    
    private Employment editedEmployment() {
        Employment employment = EmploymentManager.getInstance().findByFormNo("G2080500001");
        
        employment.setEmpCompany("VIAJERO MOTORSALES INC.");
        
        employment.setLocation(LocationManager.getInstance().findByID("V003"));
        employment.setStation("Raff-PC");
        employment.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return employment;
    }

    /**
     * Test of update method, of class EmploymentManager.
     */
//    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");
        Employment employment = editedEmployment();

        boolean expResult = true;
        boolean result = EmploymentManager.getInstance().update(employment);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByFormNo method, of class EmploymentManager.
     */
    @Test
    public void testFindByFormNo() {
        System.out.println("findByFormNo");
        String formNo = "G2080500001";
        
        Employment result = EmploymentManager.getInstance().findByFormNo(formNo);
        assertNotNull(result);
        
        System.out.println(result.getEmpCompany());
    }
}
