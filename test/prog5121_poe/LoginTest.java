/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog5121_poe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thape
 */
public class LoginTest {
    
    public LoginTest() {
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
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        Login instance = new Login ("Tha_7","Thapedi1","+27684448740");
        assertTrue(instance.checkUserName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        Login instance = new Login("Tha_7","Thapedi1!","+27684448740");
        assertTrue(instance.checkPasswordComplexity());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        Login instance = new Login("Tha_7","Thapedi1!","+27684448740");
        assertTrue(instance.checkCellPhoneNumber());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of registerCellPhone method, of class Login.
     */
    @Test
    public void testRegisterCellPhone() {
        Login instance = new Login("Tha_7","Thapedi1!","+27684448740");
        String expResult = "Cell phone successfully captured.";
        String result = instance.registerCellPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser(){
        Login instance = new Login("Tha_7","Thapedi1!","+27684448740");
        String expResult = "User name successfully captured";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of registerPassword method, of class Login.
     */
    @Test
    public void testRegisterPassword() {
        Login instance = new Login("Tha_7","Thapedi1!","+27684448740");
        String expResult = "Password is Captured";
        String result = instance.registerPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        Login instance = new Login("Tha_7","Thapedi1!","+27684448740");
        assertTrue(instance.loginUser("Tha_7","Thapedi1!"));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        Login instance = new Login("Tha_7","Thapedi1!","+27684448740");
        String result = instance.returnLoginStatus(true);
        assertEquals("Welcome Tha_7, it is great to see you again.",result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
