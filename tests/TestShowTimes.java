import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestShowTimes {

	ShowTimes st;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		st = new ShowTimes();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstance() {
		ShowTimes st1 = new ShowTimes();
		st1 = st.getInstance();
		assertEquals(st1.getClass(), st.getClass());
	}
	
	@Test
	public void testGetShowTimesMovies() {
		ArrayList<SingleShowTime> t1 = st.getShowTimesMovies();
		assertEquals(t1, st.getShowTimesMovies());
	}
	
	@Test
	public void testGetShowTimesPlays() {
		ArrayList<SingleShowTime> t1 = st.getShowTimesPlays();
		assertEquals(t1, st.getShowTimesPlays());
	}
	
	@Test
	public void testGetShowTimes() {
		ArrayList<SingleShowTime> t1 = st.getShowTimes();
		assertEquals(t1, st.getShowTimes());
	}
	
	@Test
	public void testGetShowTimesRemoved() {
		ArrayList<SingleShowTime> t1 = st.getShowTimesRemoved();
		assertEquals(t1, st.getShowTimesRemoved());
	}

}
