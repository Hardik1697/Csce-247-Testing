import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTheaters {

	Theaters theaters;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		theaters = new Theaters();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstance() {
		Theaters theaters1 = new Theaters();
		theaters = theaters.getInstance();
		assertEquals(theaters1.getClass(), theaters.getClass());
	}
	
	@Test
	public void testGetTheaters() {
		ArrayList<SingleTheater> t1 = theaters.getTheaters();
		assertEquals(t1, theaters.getTheaters());
	}
	
	@Test
	public void testGetRemovedTheaters() {
		ArrayList<SingleTheater> t1 = theaters.getRemovedTheaters();
		assertEquals(t1, theaters.getRemovedTheaters());
	}

}
