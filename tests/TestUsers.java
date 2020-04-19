import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUsers {

	Users users;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		users = new Users();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstance() {
		Users users1 = new Users();
		users1 = users.getInstance();
		assertEquals(users1.getClass(), users.getClass());
	}

	@Test
	public void testGetUsers() {
//		ArrayList<SingleUser> t1 = DataLoader.loadUser();
//		assertEquals(t1, users.getUsers());
	}
	
	@Test
	public void testGetUsersUpdated() {
		ArrayList<SingleUser> t1 = new ArrayList<SingleUser>();
		assertEquals(t1, users.getUsersUpdated());
	}
}
