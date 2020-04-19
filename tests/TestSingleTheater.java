import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSingleTheater {
	SingleTheater st;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// (String name, String id, String address, String price)
	@Before
	public void setUp() throws Exception {
		st = new SingleTheater("a", "b", "c", "d");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testName() {
		assertEquals("a", st.getName());
	}

	@Test
	public void testId() {
		assertEquals("b", st.getId());
	}

	@Test
	public void testAddress() {
		assertEquals("c", st.getAddress());
	}

	@Test
	public void testPrice() {
		assertEquals("d", st.getPrice());
	}

	@Test
	public void testNameAS() {
		st.setName("1");
		assertEquals("1", st.getName());
	}

	@Test
	public void testIdAS() {
		st.setId("2");
		assertEquals("2", st.getId());
	}

	@Test
	public void testAddressAS() {
		st.setAddress("3");
		assertEquals("3", st.getAddress());
	}

	@Test
	public void testPriceAS() {
		st.setPrice("4");
		assertEquals("4", st.getPrice());
	}

}
