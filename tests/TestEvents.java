import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEvents {

	Events event;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		event = new Events();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Events event1 = new Events();
		event1 = event.getInstance();
		assertEquals(event1.getClass(), event.getClass());
	}

	@Test
	public void TestGetEvents() {
		ArrayList<SingleEvent> arr = event.getEvents();
		assertEquals(event.getEvents(), arr);
	}
	
	@Test
	public void TestGetMovies() {
		ArrayList<SingleEvent> arr = event.getMovies();
		assertEquals(event.getMovies(), arr);
	}
	
	@Test
	public void TestGetPlays() {
		ArrayList<SingleEvent> arr = event.getPlays();
		assertEquals(event.getPlays(), arr);
	}
	
	@Test
	public void TestGetRemovedEvents() {
		ArrayList<SingleEvent> arr = event.getRemovedEvents();
		assertEquals(event.getRemovedEvents(), arr);
	}

	@Test
	public void TestAddMovie() {
		ArrayList<SingleEvent> movieList = DataLoader.loadMovie();
		ArrayList<SingleEvent> movieList1 = event.getMovies();
		movieList1.add(new SingleEvent("name", "type", "id", "genre", "rating", "description", "runtime"));
		int size1 = movieList.size() + 1;
		int size2 = movieList1.size();
		assertEquals(size1, size2);
	}

	@Test
	public void TestAddPlay() {
		ArrayList<SingleEvent> playList = DataLoader.loadPlay();
		ArrayList<SingleEvent> playList1 = event.getPlays();
		playList1.add(new SingleEvent("name", "type", "id", "genre", "rating", "description", "runtime"));
		int size1 = playList.size() + 1;
		int size2 = playList1.size();
		assertEquals(size1, size2);
	}

	@Test
	public void TestRemoveEvent() {
		ArrayList<SingleEvent> removeEvent = event.getEvents();
		ArrayList<SingleEvent> removeEvent1 = event.getRemovedEvents();
		DataRemover.removeEvent("Aladin", removeEvent1);
		int size1 = removeEvent.size() - 1;
		int size2 = removeEvent1.size();
		assertEquals(size1, size2);
	}
}
