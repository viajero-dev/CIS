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
import com.vg.scfc.financing.cis.ent.Family;
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
public class FamilyManagerTest {
    
    public FamilyManagerTest() {
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
    
    private Family createFamily() {
        Family family = new Family();
        family.setTxForm("G2080500001");
        family.setFamRelation("FATHER");
        family.setPersonType(PersonTypeManager.getInstance().findById("APP"));
        
        family.setFamAddress("GSC");
        family.setFamAge(12);
        family.setFamName("PER");
        family.setFamOccupation("TEACHER");
       
        family.setLocation(LocationManager.getInstance().findByID("V003"));
        family.setStation("Raff-PC");
        family.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return family;
    }

    /**
     * Test of insert method, of class FamilyManager.
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        Family family = createFamily();

        boolean expResult = true;
        boolean result = FamilyManager.getInstance().insert(family);
        assertEquals(expResult, result);
    }
    
    private Family editedFamily() {
        Family family = FamilyManager.getInstance()
                .findById("G2080500001", "APP", "MOTHER");
        family.setFamAddress("GSC");
        family.setFamAge(47);
        family.setFamName("RUFILEN");
        family.setFamOccupation("TEACHER");
       
        family.setLocation(LocationManager.getInstance().findByID("V003"));
        family.setStation("Raff-PC");
        family.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return family;
    }

    /**
     * Test of update method, of class FamilyManager.
     */
    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");
        Family family = editedFamily();

        boolean expResult = true;
        boolean result = FamilyManager.getInstance().update(family);
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class FamilyManager.
     */
    @Ignore
    @Test
    public void testFindById_3args() {
        System.out.println("findById");
        String formNo = "G2080500001";
        String personTypeId = "APP";
        String famRelation = "FATHER";

        Family result = FamilyManager.getInstance().findById(formNo, personTypeId, famRelation);
        assertNotNull(result);
        
        System.out.println(result.getFamName());
    }

    /**
     * Test of findById method, of class FamilyManager.
     */
    @Ignore
    @Test
    public void testFindById_String_String() {
        System.out.println("findById");
        String formNo = "G2080500001";
        String personTypeId = "APP";

        List result = FamilyManager.getInstance().findById(formNo, personTypeId);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println( ((Family) object).getFamName() );
        }
    }
}
