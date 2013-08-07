/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import java.util.List;
import com.vg.hrm.user.entmgr.EmployeeManager;
import com.vg.scfc.financing.commons.entmgr.LocationManager;
import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.scfc.financing.cis.ent.MemoToFile;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffy
 */
public class MemoToFileManagerTest {
    
    public MemoToFileManagerTest() {
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
    
    private MemoToFile createMemoToFile() {
        MemoToFile memoToFile = new MemoToFile();
        memoToFile.setTxFormNo("G2080500001");
        memoToFile.setDescription("No spouse");
        memoToFile.setRemarks("abroad");
        
        memoToFile.setLocation(LocationManager.getInstance().findByID("V003"));
        memoToFile.setStation("Raff-PC");
        memoToFile.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return memoToFile;
    }

    /**
     * Tested 2013-08-05 17:48
     */
    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");
        MemoToFile memoToFile = createMemoToFile();
        
        boolean expResult = true;
        boolean result = MemoToFileManager.getInstance().insert(memoToFile);
        assertEquals(expResult, result);
    }
    
    private MemoToFile editedMemoToFile() {
        MemoToFile memoToFile = MemoToFileManager.getInstance()
                .findById("G2080500001", 1);
        memoToFile.setDescription("No Co maker 2");
        memoToFile.setRemarks("not necessary");
        
        memoToFile.setLocation(LocationManager.getInstance().findByID("V003"));
        memoToFile.setStation("Raff-PC");
        memoToFile.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return memoToFile;
    }

    /**
     * Tested 2013-08-05 18:03
     */
    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");
        MemoToFile memoToFile = editedMemoToFile();

        boolean expResult = true;
        boolean result = MemoToFileManager.getInstance().update(memoToFile);
        assertEquals(expResult, result);
    }

    /**
     * Tested 2013-08-05 18:07
     */
    @Ignore
    @Test
    public void testDelete() {
        System.out.println("delete");
        MemoToFile memoToFile = MemoToFileManager.getInstance().findById("G2080500001", 1);
        memoToFile.setLocation(LocationManager.getInstance().findByID("V003"));
        memoToFile.setStation("Raff-PC");
        memoToFile.setUser(EmployeeManager.getInstance().findById("M0522"));

        boolean expResult = true;
        boolean result = MemoToFileManager.getInstance().delete(memoToFile);
        assertEquals(expResult, result);
    }

    /**
     * Tested 2013-08-05 17:50
     */
    @Ignore
    @Test
    public void testFindById() {
        System.out.println("findById");
        String formNo = "G2080500001";
        int lineNo = 2;

        MemoToFile result = MemoToFileManager.getInstance().findById(formNo, lineNo);
        assertNotNull(result);
        
        System.out.println(result.getDescription());
    }

    /**
     * Tested 2013-08-05 17:53
     */
    @Ignore
    @Test
    public void testFindByFormNo() {
        System.out.println("findByFormNo");
        String formNo = "G2080500001";
        
        List result = MemoToFileManager.getInstance().findByFormNo(formNo);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println( ((MemoToFile) object).getDescription() );
        }
    }
}
