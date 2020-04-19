import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSingleUser {

	SingleUser user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new SingleUser("a", "b", "c", "d", "e", "f", "g", "h");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserName() {
		assertEquals("a", user.getFirstName());
	}

	@Test
	public void testLastName() {
		assertEquals("b", user.getLastName());
	}

	@Test
	public void testPhone() {
		assertEquals("c", user.getPhoneNumber());
	}

	@Test
	public void testAge() {
		assertEquals("d", user.getAge());
	}

	@Test
	public void testStatus() {
		assertEquals("e", user.getStatus());
	}

	@Test
	public void testEmail() {
		assertEquals("f", user.getEmail());
	}

	@Test
	public void testPassword() {
		assertEquals("g", user.getPassword());
	}

	@Test
	public void testType() {
		assertEquals("h", user.getType());
	}

	@Test
	public void testUserNameAfterSet() {
		user.setFirstName("1");
		assertEquals("1", user.getFirstName());
	}

	@Test
	public void testLastNameAfterSet() {
		user.setLastName("2");
		assertEquals("2", user.getLastName());
	}

	@Test
	public void testPhoneAfterSet() {
		user.setPhoneNumber("3");
		assertEquals("3", user.getPhoneNumber());
	}

	@Test
	public void testAgeAfterSet() {
		user.setAge("4");
		assertEquals("4", user.getAge());
	}

	public @Test void testStatusAfterSet() {
		user.setStatus("5");
		assertEquals("5", user.getStatus());
	}

	@Test
	public void testEmailAfterSet() {
		user.setEmail("6");
		assertEquals("6", user.getEmail());
	}

	@Test
	public void testPasswordAfterSet() {
		user.setPassword("7");
		assertEquals("7", user.getPassword());
	}

	@Test
	public void testTypeAfterSet() {
		user.setType("8");
		assertEquals("8", user.getType());
	}

}
