import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSingleEvent {

	SingleEvent se;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		se = new SingleEvent("a", "b", "c", "d", "e", "f", "g");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testName() {
		assertEquals("a", se.getName());
	}

	@Test
	public void testType() {
		assertEquals("b", se.getType());
	}

	@Test
	public void testID() {
		assertEquals("c", se.getId());
	}

	@Test
	public void testGenre() {
		assertEquals("d", se.getGenre());
	}

	@Test
	public void testRating() {
		assertEquals("e", se.getRating());
	}

	@Test
	public void testDescription() {
		assertEquals("f", se.getDescription());
	}

	@Test
	public void testRuntime() {
		assertEquals("g", se.getRuntime());
	}

	@Test
	public void testNameAS() {
		se.setName("1");
		assertEquals("1", se.getName());
	}

	@Test
	public void testTypeAS() {
		se.setType("2");
		assertEquals("2", se.getType());
	}

	@Test
	public void testIDAS() {
		se.setId("3");
		assertEquals("3", se.getId());
	}

	@Test
	public void testGenreAS() {
		se.setGenre("4");
		assertEquals("4", se.getGenre());
	}

	@Test
	public void testRatingAS() {
		se.setRating("5");
		assertEquals("5", se.getRating());
	}

	@Test
	public void testDescriptionAS() {
		se.setDescription("6");
		assertEquals("6", se.getDescription());
	}

	@Test
	public void testRuntimeAS() {
		se.setRuntime("7");
		assertEquals("7", se.getRuntime());
	}
}
