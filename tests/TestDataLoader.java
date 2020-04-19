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

	@Before
	public void setUp() throws Exception {
		dL = new DataLoader();
	}

	@Test
	public void testLoadEmailForSignUpValid() {
		boolean bool1 = false;
		assertTrue(bool1 == dL.loadEmailForSignUp("ha2"));
	}

	@Test
	public void testLoadEmailForSignUpInvalid() {
		boolean bool1 = true;
		assertTrue(bool1 == dL.loadEmailForSignUp("newemail"));
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
		String price = "";
		assertEquals("9",dL.getTheaterPrice("AMC", price));
		assertNotEquals("10",dL.getTheaterPrice("notthere", price));
	}
	@Test
	public void testGetTheatertLocation() {
		String location = "";
		assertEquals("3400 Forest Dr Suite 3000, Columbia, SC 29204",dL.getTheaterLocation("Regal", location));
		assertNotEquals("10",dL.getTheaterLocation("notthere", "141"));
	}
	@Test
	public void testGetNumReviewsAll() {
		int num = 0;
		assertEquals(3, dL.getNumReviewsAll("ha2", num));
		assertNotEquals(1, dL.getNumReviewsAll("ha2", num));
	}

	@Test
	public void testGetNumReviewsType() {
		int num = 0;
		assertEquals(1, dL.getNumReviewsType("ha2", "Movie", num));
		assertEquals(1, dL.getNumReviewsType("ha2", "Play", num));
		assertEquals(1, dL.getNumReviewsType("ha2", "Theater", num));
		assertNotEquals(3, dL.getNumReviewsType("ha2", "Movie", num));
		assertNotEquals(2, dL.getNumReviewsType("ha2", "Play", num));
		assertNotEquals(5, dL.getNumReviewsType("ha2", "Theater", num));
	}

	@Test
	public void testShowTimeNumber() {
		assertEquals(1, dL.showTimeNumber("Frozen 2", "AMC"));
		assertNotEquals(5, dL.showTimeNumber("Frozen 2", "AMC"));
	}
	
	@Test
	public void testLoadSpecificStuff() {
		String a = "";
		assertEquals(dL.loadSpecificStuff("Regal", a, "theater"), "Regal");
		assertNotEquals(dL.loadSpecificStuff("Regal", a, "theater"), "AMC");
	}

	@Test
	public void testLoadUsersValid() {
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
	public void testLoadUsersInvalid() {
		Users users = Users.getInstance();
		ArrayList<SingleUser> userList = new ArrayList<SingleUser>();
		ArrayList<SingleUser> userList1 = users.getUsers();
		userList.add(new SingleUser("Name", "Anand", "XXX-XXX-XXXX", "22", "Student", "ha2", "pass", "user"));
		userList.add(new SingleUser("Hardik", "12", "XXX-XXX-XXXX", "22", "Student", "hanand", "pass", "admin"));
		userList.add(new SingleUser("edw", "Arya", "XXX-XXX-XXXX", "helllo", "Student", "ta2", "new", "user"));
		userList.add(new SingleUser("98r0", "Singh", "neijde", "u9ed", "Student", "ishu", "user", "user"));
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
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadMovieValid() {
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
	public void testLoadMovieInvalid() {
		Events events = Events.getInstance();
		ArrayList<SingleEvent> movieList = new ArrayList<SingleEvent>();
		ArrayList<SingleEvent> movieList1 = events.getMovies();
		movieList.add(new SingleEvent("edhed", "Movie", "6443", "idu93ue", "IMDB: 7/10", "Aladdin is a 2019 American musical fantasy film produced by Walt Disney Pictures. Directed by Guy Ritchie, who co-wrote the screenplay with John August, it is a live-action adaptation of Disney's 1992 animated film of the same name, which itself is based on the eponymous tale from One Thousand and One Nights.", "128 minutes"));
		movieList.add(new SingleEvent(" hecbfeb 2", "Mehfewhovie", "6443", "Musical", "jfehf: 7/10", "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.", "103 minutes"));
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
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadPlayValid() {
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
		for (SingleEvent movie : playList1) {
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
	public void testLoadPlayInvalid() {
		Events events = Events.getInstance();
		ArrayList<SingleEvent> playList = new ArrayList<SingleEvent>();
		ArrayList<SingleEvent> playList1 = events.getPlays();
		playList.add(new SingleEvent("Falese", "Play", "iejfirjf", "jdhdieh", "8", "This is a sample play", "25 minutes"));
		String[] arr1 = new String[playList.size()];
		String[] arr2 = new String[playList1.size()];
		int i = -1;
		int j = -1;
		for (SingleEvent movie : playList) {
			i++;
			arr1[i] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() + movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		for (SingleEvent movie : playList1) {
			j++;
			arr2[j] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() + movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < playList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadTheaterValid() {
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
	public void testLoadTheaterInvalid() {
		Theaters theaters = Theaters.getInstance();
		ArrayList<SingleTheater> theaterList = new ArrayList<SingleTheater>();
		ArrayList<SingleTheater> theaterList1 = theaters.getTheaters();
		theaterList.add(new SingleTheater("hdkce", "rfirrjgjr", "address", "9"));
		theaterList.add(new SingleTheater("dawkhdfiehf", "djediej", "3400 address1 Dr Suite 3000, Columbia, SC 29204", "10"));
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
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadShowTimesValid() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimes();
		showTimeList.add(new SingleShowTime("Aladin", "12:15, 04/22/2020", "Regal", "Movie"));
		showTimeList.add(new SingleShowTime("Frozen 2", "9:45, 04/30/2020", "AMC", "Movie"));
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
	public void testLoadShowTimesInvalid() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimes();
		showTimeList.add(new SingleShowTime("uehefh", "12:15, 04/22/2020", "Regal", "wuhdqefhof"));
		showTimeList.add(new SingleShowTime("Frozen 2", "9:45, fhebe/30/2020", "AMC", "Movie"));
		showTimeList.add(new SingleShowTime("Frozen fhwrefouhfoihf 2", "10:30, 04/24/2020", "PlaysRUs", "Play"));
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
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadShowTimeMovieValid() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimesMovies();
		showTimeList.add(new SingleShowTime("Aladin", "12:15, 04/22/2020", "Regal", "Movie"));
		showTimeList.add(new SingleShowTime("Frozen 2", "9:45, 04/30/2020", "AMC", "Movie"));
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
	public void testLoadShowTimeMovieInvalid() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimesMovies();
		showTimeList.add(new SingleShowTime("ided", "12:15, 04/22/2020", "Regal", "Movie"));
		showTimeList.add(new SingleShowTime("Frozen 2", "9:45, 04/jfejerwijf/2020", "AMC", "jfwrhf"));
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
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadShowTimePlayValid() {
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

	@Test
	public void testLoadShowTimePlayInvalid() {
		ShowTimes showTime = ShowTimes.getInstance();
		ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> showTimeList1 = showTime.getShowTimesPlays();
		showTimeList.add(new SingleShowTime("Frozen jehiej 2", "10:30, frhif/24/2020", "jfhhier", "Play"));
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
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadTicketValid() {
		Tickets tickets = Tickets.getInstance();
		ArrayList<SingleTicket> ticketList = new ArrayList<SingleTicket>();
		ArrayList<SingleTicket> ticketList1 = tickets.getTicket();
		ticketList.add(new SingleTicket("ha2", "Movie", "Aladin", "Regal", "3400 Forest Dr Suite 3000, Columbia, SC 29204", "A2", "9.0", "12:15, 04/22/2020"));
		String[] arr1 = new String[ticketList.size()];
		String[] arr2 = new String[ticketList1.size()];
		int i = -1;
		int j = -1;
		for (SingleTicket ticket : ticketList) {
			i++;
			arr1[i] = ticket.getEmail() + ticket.getType() + ticket.getMovieName() + ticket.getTheaterName() + ticket.getTheaterLocation() + ticket.getSeat() + ticket.getPrice() + ticket.getShowTime();
		}
		for (SingleTicket ticket : ticketList1) {
			j++;
			arr2[j] = ticket.getEmail() + ticket.getType() + ticket.getMovieName() + ticket.getTheaterName() + ticket.getTheaterLocation() + ticket.getSeat() + ticket.getPrice() + ticket.getShowTime();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < ticketList1.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadTicketInvalid() {
		Tickets tickets = Tickets.getInstance();
		ArrayList<SingleTicket> ticketList = new ArrayList<SingleTicket>();
		ArrayList<SingleTicket> ticketList1 = tickets.getTicket();
		ticketList.add(new SingleTicket("ha2", "jdhheeehd", "Aladin", "Regal", "3400 Forest Dr Suite 3000, Columbia, SC 29204", "A2", "9.0", "12:15, 04/22/2020"));
		String[] arr1 = new String[ticketList.size()];
		String[] arr2 = new String[ticketList1.size()];
		int i = -1;
		int j = -1;
		for (SingleTicket ticket : ticketList) {
			i++;
			arr1[i] = ticket.getEmail() + ticket.getType() + ticket.getMovieName() + ticket.getTheaterName() + ticket.getTheaterLocation() + ticket.getSeat() + ticket.getPrice() + ticket.getShowTime();
		}
		for (SingleTicket ticket : ticketList1) {
			j++;
			arr2[j] = ticket.getEmail() + ticket.getType() + ticket.getMovieName() + ticket.getTheaterName() + ticket.getTheaterLocation() + ticket.getSeat() + ticket.getPrice() + ticket.getShowTime();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < ticketList1.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadReviewMovieValid() {
		Review review = Review.getInstance();
		ArrayList<SingleReview> reviewList = new ArrayList<SingleReview>();
		ArrayList<SingleReview> reviewList1 = review.getReviewMovie();
		reviewList.add(new SingleReview("ha2", "Movie", "Play 1", "Nice Review", "8"));
		String[] arr1 = new String[reviewList.size()];
		String[] arr2 = new String[reviewList1.size()];
		int i = -1;
		int j = -1;
		for (SingleReview reviews : reviewList) {
			i++;
			arr1[i] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		for (SingleReview reviews : reviewList1) {
			j++;
			arr2[j] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < reviewList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadReviewMovieInvalid() {
		Review review = Review.getInstance();
		ArrayList<SingleReview> reviewList = new ArrayList<SingleReview>();
		ArrayList<SingleReview> reviewList1 = review.getReviewMovie();
		reviewList.add(new SingleReview("ha2", "juehdfih", "Play 1", "ehbjedbe Review", "8"));
		String[] arr1 = new String[reviewList.size()];
		String[] arr2 = new String[reviewList1.size()];
		int i = -1;
		int j = -1;
		for (SingleReview reviews : reviewList) {
			i++;
			arr1[i] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		for (SingleReview reviews : reviewList1) {
			j++;
			arr2[j] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < reviewList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadReviewPlayValid() {
		Review review = Review.getInstance();
		ArrayList<SingleReview> reviewList = new ArrayList<SingleReview>();
		ArrayList<SingleReview> reviewList1 = review.getReviewPlay();
		reviewList.add(new SingleReview("ha2", "Play", "play", "1", "s"));
		String[] arr1 = new String[reviewList.size()];
		String[] arr2 = new String[reviewList1.size()];
		int i = -1;
		int j = -1;
		for (SingleReview reviews : reviewList) {
			i++;
			arr1[i] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		for (SingleReview reviews : reviewList1) {
			j++;
			arr2[j] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < reviewList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadReviewPlayInvalid() {
		Review review = Review.getInstance();
		ArrayList<SingleReview> reviewList = new ArrayList<SingleReview>();
		ArrayList<SingleReview> reviewList1 = review.getReviewPlay();
		reviewList.add(new SingleReview("bjed", "hbebe", "play", "1", "s"));
		String[] arr1 = new String[reviewList.size()];
		String[] arr2 = new String[reviewList1.size()];
		int i = -1;
		int j = -1;
		for (SingleReview reviews : reviewList) {
			i++;
			arr1[i] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		for (SingleReview reviews : reviewList1) {
			j++;
			arr2[j] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < reviewList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testLoadReviewTheaterValid() {
		Review review = Review.getInstance();
		ArrayList<SingleReview> reviewList = new ArrayList<SingleReview>();
		ArrayList<SingleReview> reviewList1 = review.getReviewTheater();
		reviewList.add(new SingleReview("ha2", "Theater", "Play 1", "Nice Review", "8"));
		String[] arr1 = new String[reviewList.size()];
		String[] arr2 = new String[reviewList1.size()];
		int i = -1;
		int j = -1;
		for (SingleReview reviews : reviewList) {
			i++;
			arr1[i] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		for (SingleReview reviews : reviewList1) {
			j++;
			arr2[j] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < reviewList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testLoadReviewTheaterInvalid() {
		Review review = Review.getInstance();
		ArrayList<SingleReview> reviewList = new ArrayList<SingleReview>();
		ArrayList<SingleReview> reviewList1 = review.getReviewTheater();
		reviewList.add(new SingleReview("ha2", "jbhilbli", "Play 1", "Nice Review", "8"));
		String[] arr1 = new String[reviewList.size()];
		String[] arr2 = new String[reviewList1.size()];
		int i = -1;
		int j = -1;
		for (SingleReview reviews : reviewList) {
			i++;
			arr1[i] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		for (SingleReview reviews : reviewList1) {
			j++;
			arr2[j] = reviews.getEmail() + reviews.getType() + reviews.getName() + reviews.getDescription() + reviews.getRating();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < reviewList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertFalse(bool1 == bool2);
	}

	@Test
	public void testValidateShowTime() {
		boolean bool1 = true;
		assertTrue(bool1 == DataLoader.validateShowTime("Aladin", "Regal"));
		assertFalse(bool1 == DataLoader.validateShowTime("Testing", "Regal"));
	}
}
