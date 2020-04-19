import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSignIn {

	SignIn sI;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sI = new SignIn();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateSignInUserValid() {
		String[] arr1 = new String[3];
		String [] arr2 = new String[3];
		arr2 = sI.validateSignInUser("ha2", "pass", "User", arr2);
		arr1[0] = "ha2";
		arr1[1] = "pass";
		arr1[2] = "Hardik";
		boolean bool1 = true, bool2 = true;
		for (int i = 0; i < arr2.length; i++) {
			if (!arr1[i].equals(arr2[i])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testValidateSignInUserInvalid() {
		String[] arr1 = new String[3];
		String [] arr2 = new String[3];
		arr2 = sI.validateSignInUser("ha2", "pass", "User", arr2);
		arr1[0] = "ta2";
		arr1[1] = "pass";
		arr1[2] = "Hardik";
		boolean bool1 = true, bool2 = true;
		for (int i = 0; i < arr2.length; i++) {
			if (!arr1[i].equals(arr2[i])) {
				bool2 = false;
				break;
			}
		}
		assertFalse(bool1 == bool2);
	}

}
