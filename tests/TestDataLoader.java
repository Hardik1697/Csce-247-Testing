import static org.junit.Assert.*;

import com.sun.beans.editors.ShortEditor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class TestDataLoader {

	DataLoader dL;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dL = new DataLoader();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadEmailForSignInUp1() {
		assertFalse(dL.loadEmailForSignUp("ishu"));
	}

	@Test
	public void testLoadUser() {
		ArrayList<SingleUser> list = new ArrayList<SingleUser>();
		ArrayList<SingleUser> list1 = new ArrayList<SingleUser>();
		list.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "ha2", "pass", "user"));
		list.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "hanand", "pass", "admin"));
		list.add(new SingleUser("Talin", "Arya", "XXX-XXX-XXXX", "22", "Student", "ta2", "new", "user"));
		list.add(new SingleUser("Ishu", "Singh", "98e", "22", "Student", "ishu", "user", "user"));
		list1 = DataLoader.loadUser();
		//assertArrayEquals(exp, test);
		//assertarray
	}

	@Test
	public void testGetUserStatus()	{
		String status = "", status1 = "";
		assertEquals("Student", dL.getUserStatus("ha2", status));
		assertNotEquals("Admin", dL.getUserStatus("ta2", status1));
	}
	
	@Test
	public void testGetEventName() {
		assertTrue(dL.getEventName("Aladin"));
		assertFalse(dL.getEventName("Test false"));
	}
	@Test
	public void testGetTheatertName() {
		assertTrue(dL.getTheaterName("AMC"));
		assertFalse(dL.getTheaterName("notthere"));
	}
	@Test
	public void testGetTheatertPrice() {
		assertEquals("9",dL.getTheaterPrice("AMC", "2"));
		assertNotEquals("10",dL.getTheaterPrice("notthere", "141"));
	}
	@Test
	public void testGetTheatertLocation() {
		String location = "";
		assertEquals("3400 Forest Dr Suite 3000, Columbia, SC 29204",dL.getTheaterLocation("Regal", location));
		assertNotEquals("10",dL.getTheaterLocation("notthere", "141"));
	}
	@Test
	public void testGetNumReviewsAll() {
		//could not fully test this one
		int num = 0;
		assertEquals(3, dL.getNumReviewsAll("ha2", num));
	}

	@Test
	public void testGetNumReviewsType() {
		int num = 0;
		assertEquals(1, dL.getNumReviewsType("ha2", "Movie", num));
		assertEquals(1, dL.getNumReviewsType("ha2", "Play", num));
		assertEquals(1, dL.getNumReviewsType("ha2", "Theater", num));
		assertNotEquals(3, dL.getNumReviewsType("ha2", "Movie", num));
	}

	@Test
	public void testShowTimeNumber() {
		assertEquals(1, dL.showTimeNumber("The Jungle Book", "AMC"));
	}
	
	@Test
	public void testLoadSpecificStuff() {
		String a = "";
		assertEquals(dL.loadSpecificStuff("Regal", a, "theater"), "Regal");
		assertNotEquals(dL.loadSpecificStuff("Regal", a, "theater"), "AMC");
	}

	@Test
	public void testLoadUsers() {
		Users users = Users.getInstance();
		ArrayList<SingleUser> userList = new ArrayList<SingleUser>();
		ArrayList<SingleUser> userList1 = users.getUsers();
		userList.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "ha2", "pass", "user"));
		userList.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "hanand", "pass", "admin"));
		userList.add(new SingleUser("Talin", "Arya", "XXX-XXX-XXXX", "22", "Student", "ta2", "new", "user"));
		userList.add(new SingleUser("Ishu", "Singh", "98e", "u9ed", "Student", "ishu", "user", "user"));
		String[] arr1 = new String[userList.size()];
		String[] arr2 = new String[userList1.size()];
		int i = -1;
		int j = -1;
		for (SingleUser user : userList) {
			i++;
			arr1[i] = user.getFirstName() + user.getLastName() + user.getPhoneNumber() + user.getAge() + user.getStatus() + user.getEmail() + user.getPassword() + user.getType();
		}
		for (SingleUser user : userList1) {
			j++;
			arr2[j] = user.getFirstName() + user.getLastName() + user.getPhoneNumber() + user.getAge() + user.getStatus() + user.getEmail() + user.getPassword() + user.getType();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < userList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLodMovie() {
		Events events = Events.getInstance();
		ArrayList<SingleEvent> movieList = new ArrayList<SingleEvent>();
		ArrayList<SingleEvent> movieList1 = events.getMovies();
		movieList.add(new SingleEvent("Aladin", "Movie", "6443", "Fantsay", "IMDB: 7/10", "Aladdin is a 2019 American musical fantasy film produced by Walt Disney Pictures. Directed by Guy Ritchie, who co-wrote the screenplay with John August, it is a live-action adaptation of Disney's 1992 animated film of the same name, which itself is based on the eponymous tale from One Thousand and One Nights.", "128 minutes"));
		movieList.add(new SingleEvent("Frozen 2", "Movie", "6443", "Musical", "IMDB: 7/10", "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.", "103 minutes"));
		String[] arr1 = new String[movieList.size()];
		String[] arr2 = new String[movieList1.size()];
		int i = -1;
		int j = -1;
		for (SingleEvent movie : movieList) {
			i++;
			arr1[i] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() +  movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		for (SingleEvent movie : movieList1) {
			j++;
			arr2[j] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() +  movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < movieList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLodPlay() {
		Events events = Events.getInstance();
		ArrayList<SingleEvent> playList = new ArrayList<SingleEvent>();
		ArrayList<SingleEvent> playList1 = events.getPlays();
		playList.add(new SingleEvent("Play 1", "Play", "4762", "comedy", "8", "This is a sample play", "25 minutes"));
		String[] arr1 = new String[playList.size()];
		String[] arr2 = new String[playList1.size()];
		int i = -1;
		int j = -1;
		for (SingleEvent movie : playList) {
			i++;
			arr1[i] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() +  movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		for (SingleEvent movie : playList) {
			j++;
			arr2[j] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() +  movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < playList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadTheater() {
		Theaters theaters = Theaters.getInstance();
		ArrayList<SingleTheater> theaterList = new ArrayList<SingleTheater>();
		ArrayList<SingleTheater> theaterList1 = theaters.getTheaters();
		theaterList.add(new SingleTheater("AMC", "1697", "122 Afton Ct, Columbia, SC 29212", "9"));
		theaterList.add(new SingleTheater("Regal", "8293", "3400 Forest Dr Suite 3000, Columbia, SC 29204", "10"));
		String[] arr1 = new String[theaterList.size()];
		String[] arr2 = new String[theaterList1.size()];
		int i = -1;
		int j = -1;
		for (SingleTheater theater : theaterList) {
			i++;
			arr1[i] = theater.getName() + theater.getId() + theater.getAddress() + theater.getPrice();
		}
		for (SingleTheater theater : theaterList1) {
			j++;
			arr2[j] = theater.getName() + theater.getId() + theater.getAddress() + theater.getPrice();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < theaterList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadShowTimes() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimes();
		showTimeList.add(new SingleShowTime("The Jungle Book", "12:15, 04/22/2020", "Regal", "Movie"));
		showTimeList.add(new SingleShowTime("The Jungle Book", "9:45, 04/30/2020", "AMC", "Movie"));
		showTimeList.add(new SingleShowTime("Frozen Junior 2", "10:30, 04/24/2020", "PlaysRUs", "Play"));
		String[] arr1 = new String[showTimeList.size()];
		String[] arr2 = new String[showTimeList1.size()];
		int i = -1;
		int j = -1;
		for (SingleShowTime showTimes : showTimeList) {
			i++;
			arr1[i] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		for (SingleShowTime showTimes : showTimeList1) {
			j++;
			arr2[j] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < showTimeList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadShowTimeMovie() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimesMovies();
		showTimeList.add(new SingleShowTime("The Jungle Book", "12:15, 04/22/2020", "Regal", "Movie"));
		showTimeList.add(new SingleShowTime("The Jungle Book", "9:45, 04/30/2020", "AMC", "Movie"));
		String[] arr1 = new String[showTimeList.size()];
		String[] arr2 = new String[showTimeList1.size()];
		int i = -1;
		int j = -1;
		for (SingleShowTime showTimes : showTimeList) {
			i++;
			arr1[i] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		for (SingleShowTime showTimes : showTimeList1) {
			j++;
			arr2[j] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < showTimeList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadShowTimePlay() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimesPlays();
		showTimeList.add(new SingleShowTime("Frozen Junior 2", "10:30, 04/24/2020", "PlaysRUs", "Play"));
		String[] arr1 = new String[showTimeList.size()];
		String[] arr2 = new String[showTimeList1.size()];
		int i = -1;
		int j = -1;
		for (SingleShowTime showTimes : showTimeList) {
			i++;
			arr1[i] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		for (SingleShowTime showTimes : showTimeList1) {
			j++;
			arr2[j] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < showTimeList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

//	@Test
//	public void testLoadTicket() {
//		Tickets tickets = Tickets.getInstance();
//		ArrayList<SingleTicket> ticketList = new ArrayList<SingleTicket>();
//		ArrayList<SingleTicket> ticketList1 = tickets.getTicket();
//		ticketList.add(new SingleTicket("ha2", "Movie", "Aladin", "", "", "", "", ""));
//		String[] arr1 = new String[showTimeList.size()];
//		String[] arr2 = new String[showTimeList1.size()];
//		int i = -1;
//		int j = -1;
//		for (SingleShowTime showTimes : showTimeList) {
//			i++;
//			arr1[i] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
//		}
//		for (SingleShowTime showTimes : showTimeList1) {
//			j++;
//			arr2[j] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
//		}
//		boolean bool1 = true, bool2 = true;
//		for (int k = 0; k < showTimeList.size(); k++) {
//			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
//				bool2 = false;
//				break;
//			}
//		}
//		assertTrue(bool1 == bool2);
//	}

}
