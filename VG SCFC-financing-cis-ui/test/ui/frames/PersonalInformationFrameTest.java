/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.frames;

import com.vg.scfc.financing.cis.ui.frames.PersonalInformationFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rodel
 */
public class PersonalInformationFrameTest {
    
    public PersonalInformationFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class PersonalInformationFrame.
     */
    @Test
    public void testMain() {
        PersonalInformationFrame f = new PersonalInformationFrame();
        f.setVisible(true);
    }
    
}
