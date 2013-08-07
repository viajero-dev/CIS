/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.scfc.financing.cis.entmgr;

import java.util.Date;
import com.vg.hrm.user.entmgr.EmployeeManager;
import com.vg.scfc.financing.commons.entmgr.LocationManager;
import com.vg.hrm.user.util.HrmUserUtil;
import com.vg.scfc.financing.cis.util.ClientInfoUtil;
import com.vg.scfc.financing.commons.util.CommonsUtil;
import com.vg.scfc.financing.commons.value.ConnectionProperties;
import com.vg.scfc.financing.cis.ent.Company;
import com.vg.scfc.financing.cis.ent.Customer;
import com.vg.scfc.financing.cis.ent.CustomerCashInfo;
import com.vg.scfc.financing.cis.ent.PersonalInfo;
import com.vg.scfc.financing.cis.ent.TransactionForm;
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
public class CustomerManagerTest {
    
    public CustomerManagerTest() {
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
    
    private PersonalInfo createPersonalInfo(String formNo) {
        PersonalInfo info = new PersonalInfo();
        info.setTxFormNo(formNo);
        info.setPersonType(PersonTypeManager.getInstance().findById("APP"));
        
        info.setLastName("PALAHANG");
        info.setFirstName("JOJIE");
        info.setMiddleName("EWAN");
        
        info.setStation("Raff");
        info.setLocation(LocationManager.getInstance().findByID("V003"));
        info.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return info;
    }

    /**
     * Test of insert method, of class CustomerManager.
     */
//    @Ignore
    @Test
    public void testInsert_3args_1() {
        System.out.println("insert");
        TransactionForm form = createTransactionForm("C2080300001");
        PersonalInfo personalInfo = createPersonalInfo(form.getTxFormNo());
        Customer customer = createCustomer(personalInfo.getProperName(), 2);

        boolean expResult = true;
        boolean result = CustomerManager.getInstance().insert(customer, form, personalInfo);
        assertEquals(expResult, result);
    }
    
    private Company createCompany(String formNo) {
        Company company = new Company();
        company.setTxFormNo(formNo);
        company.setAddress("Dadiangas East, GSC");
        company.setBusinessPermitNo("1234567890");
        company.setContactNo("554-8112");
        company.setEmail("mis@viajero.com");
        company.setExpirationDate(new Date());
        company.setIssuedDate(new Date());
        company.setNatureOfBusiness("DEALER");
        company.setPresident("PNOY");
        company.setYearOfService(10);
        company.setTin("trefe");
        
        company.setStation("Raff");
        company.setLocation(LocationManager.getInstance().findByID("V003"));
        company.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return company;
    }
    
    private TransactionForm createTransactionForm(String formNo) {
        TransactionForm form = new TransactionForm();
        form.setTxApplicationDate(new Date());
        form.setTxFormNo(formNo);
        
        form.setStation("Raff");
        form.setLocation(LocationManager.getInstance().findByID("V003"));
        form.setUser(EmployeeManager.getInstance().findById("M0522"));
        
        return form;
    }
    
    /**
     * Tested 2013-08-06 9:58
     */
    @Ignore
    @Test
    public void testInsert_3args_2() {
        System.out.println("insert");
        Customer customer = createCustomer("MOTORTRADE", 3);
        TransactionForm form = createTransactionForm("C3080300001");
        Company company = createCompany(form.getTxFormNo());
        
        boolean expResult = true;
        boolean result = CustomerManager.getInstance().insert(customer, form, company);
        assertEquals(expResult, result);
    }
    
    private CustomerCashInfo createCustomerCashInfo() {
        CustomerCashInfo cashInfo = new CustomerCashInfo();  
        cashInfo.setLastName("LOGRONIO");
        cashInfo.setFirstName("RAFFY");
        cashInfo.setMiddleName("FERRER");
        cashInfo.setBarangayCode("12345");
        cashInfo.setBarangayDescription("LABANNGAL");
        cashInfo.setAddress("DONA");
        cashInfo.setPerson(true);      
        
        cashInfo.setStation("Raff-PC");
        cashInfo.setUser(EmployeeManager.getInstance().findById("M0522"));
        cashInfo.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return cashInfo;
    }
    
    private CustomerCashInfo createCustomerCashInfo2() {
        CustomerCashInfo cashInfo = new CustomerCashInfo();  
        cashInfo.setLastName("VIAJERO MOTORSALES");
        cashInfo.setBarangayCode("54311");
        cashInfo.setBarangayDescription("DADIANGAS EAST, GSC");
        cashInfo.setAddress("DE");
        cashInfo.setPerson(false);      
        
        cashInfo.setStation("Raff-PC");
        cashInfo.setUser(EmployeeManager.getInstance().findById("M0522"));
        cashInfo.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return cashInfo;
    }
    
    private Customer createCustomer(String name, int mode) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setTransactionMode(TransactionModeManager.getInstance().findByID(mode));
        
        customer.setStation("Raff-PC");
        customer.setUser(EmployeeManager.getInstance().findById("M0522"));
        customer.setLocation(LocationManager.getInstance().findByID("V003"));
        
        return customer;
    }

    /**
     * Tested 2013-08-06 9:47
     */
    @Ignore
    @Test
    public void testInsert_Customer_CustomerCashInfo() {
        System.out.println("insert");
        CustomerCashInfo customerCashInfo = createCustomerCashInfo2();
        Customer customer = createCustomer(customerCashInfo.getProperName(), 1);
        
        boolean expResult = true;
        boolean result = CustomerManager.getInstance().insert(customer, customerCashInfo);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class CustomerManager.
     */
    @Ignore
    @Test
    public void testUpdate_Customer_PersonalInfo() {
        System.out.println("update");
        Customer customer = null;
        PersonalInfo personalInfo = null;
        CustomerManager instance = new CustomerManager();
        boolean expResult = false;
        boolean result = instance.update(customer, personalInfo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CustomerManager.
     */
    @Ignore
    @Test
    public void testUpdate_Customer_Company() {
        System.out.println("update");
        Customer customer = null;
        Company company = null;
        CustomerManager instance = new CustomerManager();
        boolean expResult = false;
        boolean result = instance.update(customer, company);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CustomerManager.
     */
    @Ignore
    @Test
    public void testUpdate_Customer_CustomerCashInfo() {
        System.out.println("update");
        Customer customer = null;
        CustomerCashInfo customerCashInfo = null;
        CustomerManager instance = new CustomerManager();
        boolean expResult = false;
        boolean result = instance.update(customer, customerCashInfo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class CustomerManager.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        String clientNo = "C0000001";
        CustomerManager instance = new CustomerManager();

        Customer result = instance.findById(clientNo);
        assertNotNull(result);

        System.out.println(result.getName());
        System.out.println("****************************************************");
    }

    /**
     * Test of findByTransactionMode method, of class CustomerManager.
     */
    @Test
    public void testFindByTransactionMode() {
        System.out.println("findByTransactionMode");
        int transactionModeId = 1;
        
        List result = CustomerManager.getInstance().findByTransactionMode(transactionModeId);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println( ((Customer) object).getName() );
        }
        System.out.println("****************************************************");
    }

    /**
     * Test of filterBy method, of class CustomerManager.
     */
    @Test
    public void testFilterBy() {
        System.out.println("filterBy");
        String searchString = "LOGRONIO, RAFFY FERRER";
        int transactionModeId = 1;

        List result = CustomerManager.getInstance().filterBy(searchString, transactionModeId);
        assertNotNull(result);
        
        for (Object object : result) {
            System.out.println( ((Customer) object).getName() );
        }
        System.out.println("****************************************************");
    }

    /**
     * Test of isExist method, of class CustomerManager.
     */
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        String name = "LOGRONIO, RAFFY FERRER";

        boolean expResult = true;
        boolean result = CustomerManager.getInstance().isExist(name);
        assertEquals(expResult, result);
        System.out.println("****************************************************");
    }
}
