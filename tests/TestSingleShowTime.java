import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSingleShowTime {
	SingleShowTime sst;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// (String name, String type, String theater, String showTime)
	@Before
	public void setUp() throws Exception {
		sst = new SingleShowTime("a", "b", "c", "d");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testName() {
		assertEquals("a", sst.getName());
	}

	@Test
	public void testType() {
		assertEquals("d", sst.getType());
	}

	@Test
	public void testTheater() {
		assertEquals("c", sst.getTheater());
	}

	@Test
	public void testST() {
		assertEquals("b", sst.getShowTime());
	}

	@Test
	public void testNameAS() {
		sst.setName("1");
		assertEquals("1", sst.getName());
	}

	@Test
	public void testTypeAS() {
		sst.setType("2");
		assertEquals("2", sst.getType());
	}

	@Test
	public void testTheaterAS() {
		sst.setTheater("3");
		assertEquals("3", sst.getTheater());
	}

	@Test
	public void testSTAS() {
		sst.setShowTime("4");
		assertEquals("4", sst.getShowTime());
	}

}
