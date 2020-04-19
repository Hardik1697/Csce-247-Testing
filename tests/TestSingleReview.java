import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSingleReview {

	SingleReview sr;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sr = new SingleReview("a", "b", "c", "d", "e");
	}

	@After
	public void tearDown() throws Exception {
	}

	// (String email, String type, String name, String description, String rating)
	@Test
	public void testEmail() {
		assertEquals("a", sr.getEmail());
	}

	@Test
	public void testType() {
		assertEquals("b", sr.getType());
	}

	@Test
	public void testName() {
		assertEquals("c", sr.getName());
	}

	@Test
	public void testDescription() {
		assertEquals("d", sr.getDescription());
	}

	@Test
	public void testRating() {
		assertEquals("e", sr.getRating());
	}

	@Test
	public void testEmailAS() {
		sr.setEmail("1");
		assertEquals("1", sr.getEmail());
	}

	@Test
	public void testTypeAS() {
		sr.setType("2");
		assertEquals("2", sr.getType());
	}

	@Test
	public void testNameAS() {
		sr.setName("3");
		assertEquals("3", sr.getName());
	}

	@Test
	public void testDescriptionAS() {
		sr.setDescription("4");
		assertEquals("4", sr.getDescription());
	}

	@Test
	public void testRatingAS() {
		sr.setRating("5");
		assertEquals("5", sr.getRating());
	}

}
