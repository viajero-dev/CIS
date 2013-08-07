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
import com.vg.scfc.financing.cis.ent.Expenditure;
import java.util.ArrayList;
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
public class ExpenditureManagerTest {
    
    public ExpenditureManagerTest() {
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
    
    private List<Expenditure> createExpenditures() {
        Expenditure expenditure = new Expenditure();
        expenditure.setTxFormNo("G2080500001");
        expenditure.setExpenditureType(ExpenditureTypeManager.getInstance().findById(1));
        expenditure.setAmount(1400.00);
        
        expenditure.setLocation(LocationManager.getInstance().findByID("V003"));
        expenditure.setStation("Raff-PC");
        expenditure.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        Expenditure expenditure2 = new Expenditure();
        expenditure2.setTxFormNo("G2080500001");
        expenditure2.setExpenditureType(ExpenditureTypeManager.getInstance().findById(2));
        expenditure2.setAmount(0.00);
        
        expenditure2.setLocation(LocationManager.getInstance().findByID("V003"));
        expenditure2.setStation("Raff-PC");
        expenditure2.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        Expenditure expenditure3 = new Expenditure();
        expenditure3.setTxFormNo("G2080500001");
        expenditure3.setExpenditureType(ExpenditureTypeManager.getInstance().findById(3));
        expenditure3.setAmount(3000.00);
        
        expenditure3.setLocation(LocationManager.getInstance().findByID("V003"));
        expenditure3.setStation("Raff-PC");
        expenditure3.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        List<Expenditure> expenditures = new ArrayList<Expenditure>();
        expenditures.add(expenditure);
        expenditures.add(expenditure2);
        expenditures.add(expenditure3);
        
        return expenditures;
    }

    /**
     * Test of insert method, of class ExpenditureManager.
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        List<Expenditure> expenditures = createExpenditures();
        
        boolean expResult = true;
        boolean result = ExpenditureManager.getInstance().insert(expenditures);
        assertEquals(expResult, result);
    }
    
    private List<Expenditure> editedExpenditures() {
        List<Expenditure> expenditures = ExpenditureManager.getInstance().findByFormNo("G2080500001");
        
        for (Expenditure expenditure : expenditures) {
            if(expenditure.getExpenditureType().getId() == 1) {
                expenditure.setAmount(2000.00);
        
                expenditure.setLocation(LocationManager.getInstance().findByID("V003"));
                expenditure.setStation("Raff-PC");
                expenditure.setUser(EmployeeManager.getInstance().findById("M0522"));
            } else if(expenditure.getExpenditureType().getId() == 2) {
                expenditure.setAmount(0.00);
        
                expenditure.setLocation(LocationManager.getInstance().findByID("V003"));
                expenditure.setStation("Raff-PC");
                expenditure.setUser(EmployeeManager.getInstance().findById("M0522"));
            } else if(expenditure.getExpenditureType().getId() == 3) {
                expenditure.setAmount(3500.00);
        
                expenditure.setLocation(LocationManager.getInstance().findByID("V003"));
                expenditure.setStation("Raff-PC");
                expenditure.setUser(EmployeeManager.getInstance().findById("M0522"));
            }
        }
        
        return expenditures;
    }

    /**
     * Test of update method, of class ExpenditureManager.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        List<Expenditure> expenditures = editedExpenditures();

        boolean expResult = true;
        boolean result = ExpenditureManager.getInstance().update(expenditures);
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class ExpenditureManager.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        String formNo = "G2080500001";
        int expenditureTypeId = 1;
        
        Expenditure result = ExpenditureManager.getInstance().findById(formNo, expenditureTypeId);
        assertNotNull(result);
        
        System.out.println(result.getExpenditureType().getDescription());
    }

    /**
     * Test of findByFormNo method, of class ExpenditureManager.
     */
    @Test
    public void testFindByFormNo() {
        System.out.println("findByFormNo");
        String formNo = "G2080500001";

        List result = ExpenditureManager.getInstance().findByFormNo(formNo);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println( ((Expenditure) object).getExpenditureType().getDescription() );
        }
    }
}
