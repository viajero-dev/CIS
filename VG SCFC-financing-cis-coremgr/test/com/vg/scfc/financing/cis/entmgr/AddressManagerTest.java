/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import java.util.List;
import com.vg.hrm.user.entmgr.EmployeeManager;
import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.cis.ent.Address;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.entmgr.LocationManager;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffy
 */
public class AddressManagerTest {
    
    public AddressManagerTest() {
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
    
    private Address createAddress() {
        Address address = new Address();
        address.setClientNo("G0000001");
        address.setTxFormNo("G2080500001");
        address.setPersonType(PersonTypeManager.getInstance().findById("APP"));
        address.setBrgyCode("12345");
        address.setBrgyDesc("LABANGAL, GENERAL SANTOS CITY");
        address.setZipCode("9500");
        address.setAddress("PHASE 3B Blk15 Lot3");
        address.setDescription("CURRENT ADDRESS");
        address.setSketch("test");
        address.setStatus("OWN");
        address.setYearsOfStay("10");
        
        address.setStation("Raff-PC");
        address.setUser(EmployeeManager.getInstance().findById("M0522"));
        address.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return address;
    }

    /**
     * Tested on 2013-08-05 14:24
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        Address address = createAddress();
        
        boolean expResult = true;
        boolean result = AddressManager.getInstance().insert(address);
        assertEquals(expResult, result);
    }
    
    private Address editedAddress() {
        Address address = AddressManager.getInstance().findById("V003000001");
        address.setAddress("GENSANVILLE edited");
        address.setSketch("edited address 2");
        address.setStation("Raff-PC");
        address.setUser(EmployeeManager.getInstance().findById("M0522"));
        address.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return address;
    }

    /**
     * Tested on 2013-08-05 14:38
     */
    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");
        Address address = editedAddress();

        boolean expResult = true;
        boolean result = AddressManager.getInstance().update(address);
        assertEquals(expResult, result);
    }
    
    private Address changeAddress() {
        Address address = new Address();
        address.setClientNo("G0000001");
        address.setTxFormNo("G2080500001");
        address.setPersonType(PersonTypeManager.getInstance().findById("APP"));
        address.setBrgyCode("09876");
        address.setBrgyDesc("LABANGAL, GENERAL SANTOS CITY");
        address.setZipCode("9500");
        address.setAddress("PHASE 3B Blk22 Lot19");
        address.setDescription("CURRENT ADDRESS");
        address.setSketch("change address");
        address.setStatus("RENTED");
        address.setYearsOfStay("2");
        
        address.setStation("Raff-PC");
        address.setUser(EmployeeManager.getInstance().findById("M0522"));
        address.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return address;
    }

    /**
     * Tested on 2013-08-05 14:57
     */
    @Test
    public void testChangeAddress() {
        System.out.println("changeAddress");
        Address address = changeAddress();

        boolean expResult = true;
        boolean result = AddressManager.getInstance().changeAddress(address);
        assertEquals(expResult, result);
    }
    
    /**
     * Tested on 2013-08-05 14:29
     */
    @Ignore
    @Test
    public void testFilterBy() {
        System.out.println("filterBy");
        String clientNo = "G0000001";
        String formNo = "G2080500001";
        String personTypeId = "APP";
        
        List result = AddressManager.getInstance().filterBy(clientNo, formNo, personTypeId);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println(((Address) object).getAddressId());
        }
    }
}
