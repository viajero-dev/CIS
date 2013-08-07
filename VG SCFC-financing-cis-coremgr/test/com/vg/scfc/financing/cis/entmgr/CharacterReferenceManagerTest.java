/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import java.util.List;
import com.vg.hrm.user.entmgr.EmployeeManager;
import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.scfc.financing.cis.ent.CharacterReference;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.entmgr.LocationManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffy
 */
public class CharacterReferenceManagerTest {
    
    public CharacterReferenceManagerTest() {
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
    
    private CharacterReference createCharacterReference() {
        CharacterReference characterReference = new CharacterReference();
        characterReference.setTxFormNo("G2080500001");
        characterReference.setCharRefName("JOJIE PALAHANG");
        characterReference.setCharRefAddress("APOPON?G GENSAN");
        characterReference.setCharRelationship("PROGRAMMER");
        characterReference.setCharRefContactNo("sample lang bala");
        characterReference.setStation("Raff-PC");
        characterReference.setUser(EmployeeManager.getInstance().findById("M0522"));
        characterReference.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return characterReference;
    }

    /**
     * Tested on 2013-08-05 15:35
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        CharacterReference characterReference = createCharacterReference();

        boolean expResult = true;
        boolean result = CharacterReferenceManager.getInstance().insert(characterReference);
        assertEquals(expResult, result);
    }
    
    private CharacterReference editedCharacterReference() {
        CharacterReference characterReference = CharacterReferenceManager.getInstance()
                .findById("G2080500001", 2);
        characterReference.setCharRefName("JOJIE PALAHANG");
        characterReference.setCharRefAddress("APOPONG GENSAN");
        characterReference.setCharRelationship("SOFTWARE DEVELOPER");
        characterReference.setCharRefContactNo("edited contact no");
        characterReference.setStation("Raff-PC");
        characterReference.setUser(EmployeeManager.getInstance().findById("M0522"));
        characterReference.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return characterReference;
    }

    /**
     * Tested on 2013-08-05 16:07
     */
    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");
        CharacterReference characterReference = editedCharacterReference();
        
        boolean expResult = true;
        boolean result = CharacterReferenceManager.getInstance().update(characterReference);
        assertEquals(expResult, result);
    }

    /**
     * Tested 2013-08-05 16:11
     */
    @Ignore
    @Test
    public void testFindByFormNo_String() throws Exception {
        System.out.println("findByFormNo");
        String formNo = "G2080500001";
        
        List result = CharacterReferenceManager.getInstance().findByFormNo(formNo);
        assertNotNull(result);
        for (Object object : result) {
            System.out.println(((CharacterReference) object).getCharRefName());
        }
    }
    
    /**
     * Tested on 2013-08-08 16:06
     */
    @Ignore
    @Test
    public void testFindById_String_int() {
        System.out.println("findById");
        String formNo = "G2080500001";
        int lineNo = 2;

        CharacterReference result = CharacterReferenceManager.getInstance().findById(formNo, lineNo);
        assertNotNull(result);
        
        System.out.println(result.getPk());
    }

    /**
     * Tested on 2013-08-08 15:06
     */
    @Ignore
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        CharacterReference characterReference = new CharacterReference();
        characterReference.setTxFormNo("G2080500001");
        characterReference.setCharRefName("RAFFY LOGRONIO");

        boolean expResult = true; 
        boolean result = CharacterReferenceManager.getInstance().isExist(characterReference);
        assertEquals(expResult, result);
    }
}
