
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSingleTicket {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	SingleTicket tkt;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tkt = new SingleTicket("e", "t", "m", "tn", "tl", "s", "p", "st");
	}
	// (String email, String type, String movieName, String theaterName, String
	// theaterLocation, String seat, String price, String showTime)

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmail() {
		assertEquals("e", tkt.getEmail());
	}

	@Test
	public void testType() {
		assertEquals("t", tkt.getType());
	}

	@Test
	public void testMovie() {
		assertEquals("m", tkt.getMovieName());
	}

	@Test
	public void testTN() {
		assertEquals("tn", tkt.getTheaterName());
	}

	@Test
	public void testTL() {
		assertEquals("tl", tkt.getTheaterLocation());
	}

	@Test
	public void testS() {
		assertEquals("s", tkt.getSeat());
	}

	@Test
	public void testP() {
		assertEquals("p", tkt.getPrice());
	}

	@Test
	public void testST() {
		assertEquals("st", tkt.getShowTime());
	}

	@Test
	public void testEmailAS() {
		tkt.setEmail("email");
		assertEquals("email", tkt.getEmail());
	}

	@Test
	public void testTypeAS() {
		tkt.setType("type");
		assertEquals("type", tkt.getType());
	}

	@Test
	public void testMovieAS() {
		tkt.setMovieName("mas");
		assertEquals("mas", tkt.getMovieName());
	}

	@Test
	public void testTNAS() {
		tkt.setTheaterName("tnas");
		assertEquals("tnas", tkt.getTheaterName());
	}

	@Test
	public void testTLAS() {
		tkt.setTheaterLocation("tlas");
		assertEquals("tlas", tkt.getTheaterLocation());
	}

	@Test
	public void testSAS() {
		tkt.setSeat("seat");
		assertEquals("seat", tkt.getSeat());
	}

	@Test
	public void testPAS() {
		tkt.setPrice("price");
		assertEquals("price", tkt.getPrice());
	}

	@Test
	public void testSTAS() {
		tkt.setShowTime("stas");
		assertEquals("stas", tkt.getShowTime());
	}

}
