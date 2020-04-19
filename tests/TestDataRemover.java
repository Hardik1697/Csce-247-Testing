import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class TestDataRemover {

	DataRemover dr;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dr = new DataRemover();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRemoveTheaterValid() {
		ArrayList<SingleTheater> list = new ArrayList<SingleTheater>();
		ArrayList<SingleTheater> list1 = new ArrayList<SingleTheater>();
		list1 = DataRemover.removeTheater("Regal", list1);
		list.add(new SingleTheater("AMC", "1697", "122 Afton Ct, Columbia, SC 29212", "9"));
		String[] arr1 = new String[list.size()];
		String[] arr2 = new String[list1.size()];
		int i = -1;
		int j = -1;
		for (SingleTheater theater : list) {
			i++;
			arr1[i] = theater.getName() + theater.getId() + theater.getAddress() + theater.getPrice();
		}
		for (SingleTheater theater : list1) {
			j++;
			arr2[j] = theater.getName() + theater.getId() + theater.getAddress() + theater.getPrice();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < list.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testRemoveTheaterInvalid() {
		ArrayList<SingleTheater> list = new ArrayList<SingleTheater>();
		ArrayList<SingleTheater> list1 = new ArrayList<SingleTheater>();
		list1 = DataRemover.removeTheater("hello", list1);
		list.add(new SingleTheater("AMC", "1697", "122 Afton Ct, Columbia, SC 29212", "9"));
		assertFalse(list.size() == list1.size());
	}

	@Test
	public void testRemoveEventValid() {
		ArrayList<SingleEvent> list = new ArrayList<SingleEvent>();
		ArrayList<SingleEvent> list1 = new ArrayList<SingleEvent>();
		list1 = DataRemover.removeEvent("Play 1", list1);
		list.add(new SingleEvent("Aladin", "Movie", "6443", "Fantsay", "IMDB: 7/10", "Aladdin is a 2019 American musical fantasy film produced by Walt Disney Pictures. Directed by Guy Ritchie, who co-wrote the screenplay with John August, it is a live-action adaptation of Disney's 1992 animated film of the same name, which itself is based on the eponymous tale from One Thousand and One Nights.", "128 minutes"));
		list.add(new SingleEvent("Frozen 2", "Movie", "6443", "Musical", "IMDB: 7/10", "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.", "103 minutes"));
		String[] arr1 = new String[list.size()];
		String[] arr2 = new String[list1.size()];
		int i = -1;
		int j = -1;
		for (SingleEvent movie : list) {
			i++;
			arr1[i] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() +  movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		for (SingleEvent movie: list1) {
			j++;
			arr2[j] = movie.getName() + movie.getType() + movie.getId() + movie.getGenre() +  movie.getRating() + movie.getDescription() + movie.getRuntime();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < list.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testRemoveEventInvalid() {
		ArrayList<SingleEvent> list = new ArrayList<SingleEvent>();
		ArrayList<SingleEvent> list1 = new ArrayList<SingleEvent>();
		list1 = DataRemover.removeEvent("hello", list1);
		list.add(new SingleEvent("Aladin", "Movie", "6443", "Fantsay", "IMDB: 7/10", "Aladdin is a 2019 American musical fantasy film produced by Walt Disney Pictures. Directed by Guy Ritchie, who co-wrote the screenplay with John August, it is a live-action adaptation of Disney's 1992 animated film of the same name, which itself is based on the eponymous tale from One Thousand and One Nights.", "128 minutes"));
		list.add(new SingleEvent("Frozen 2", "Movie", "6443", "Musical", "IMDB: 7/10", "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.", "103 minutes"));		assertFalse(list.size() == list1.size());
		assertFalse(list.size() == list1.size());
	}

	@Test
	public void testRemoveShowTimeValid() {
		ArrayList<SingleShowTime> list = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> list1 = new ArrayList<SingleShowTime>();
		list1 = DataRemover.removeShowTime("Aladin", list1);
		list.add(new SingleShowTime("Frozen 2", "9:45, 04/30/2020", "AMC", "Movie"));
		list.add(new SingleShowTime("Frozen Junior 2", "10:30, 04/24/2020", "PlaysRUs", "Play"));
		String[] arr1 = new String[list.size()];
		String[] arr2 = new String[list1.size()];
		int i = -1;
		int j = -1;
		for (SingleShowTime showTimes : list) {
			i++;
			arr1[i] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		for (SingleShowTime showTimes : list1) {
			j++;
			arr2[j] = showTimes.getName() + showTimes.getShowTime() + showTimes.getTheater() + showTimes.getType();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < list.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testRemoveShowTimeInvalid() {
		ArrayList<SingleShowTime> list = new ArrayList<SingleShowTime>();
		ArrayList<SingleShowTime> list1 = new ArrayList<SingleShowTime>();
		list1 = DataRemover.removeShowTime("hello", list1);
		list.add(new SingleShowTime("Frozen 2", "9:45, 04/30/2020", "AMC", "Movie"));
		list.add(new SingleShowTime("Frozen Junior 2", "10:30, 04/24/2020", "PlaysRUs", "Play"));
		assertFalse(list.size() == list1.size());
	}
}
