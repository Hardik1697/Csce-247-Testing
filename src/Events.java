/**
 * @author Prathamjeet
 */
import java.util.ArrayList;

public class Events {
  private static Events events = null;
  private static ArrayList<SingleEvent> movieList = new ArrayList<SingleEvent>();
  private static ArrayList<SingleEvent> playList = new ArrayList<SingleEvent>();
  private static ArrayList<SingleEvent> eventList = new ArrayList<SingleEvent>();
  private static ArrayList<SingleEvent> eventList1 = new ArrayList<SingleEvent>();

  /**
   * Loads movie lists into the array from json files.
   */
  public Events() {
    movieList = DataLoader.loadMovie();
    playList = DataLoader.loadPlay();
  }

  /**
   * Method to create a new object if not present to prevent creating a new user
   * when not necessary
   *
   * @return
   */
  public static Events getInstance() {
    if(events == null) {
      events = new Events();
    }

    return events;
  }

  /**
   * @return the list of movies
   */
  public ArrayList<SingleEvent> getMovies() {
    return movieList;
  }

  /**
   * @return the list of getPlays
   */
  public ArrayList<SingleEvent> getPlays() {
    return playList;
  }

  /**
   * @return the list of getEvents
   */
  public ArrayList<SingleEvent> getEvents() {
    eventList.addAll(movieList);
    eventList.addAll(playList);
    return eventList;
  }

  public ArrayList<SingleEvent> getRemovedEvents() {
    return eventList1;
  }

  /**
   * Adds movies to the array list through json All of them are saved as a String
   *
   * @param name        - name
   * @param id          - id of movie
   * @param genre       - type of movie
   * @param rating      - rating of the movie
   * @param description - description of the movie
   * @param runtime     - showtimes of the movie
   */
  public void addMovie(String name, String type, String id, String genre, String rating, String description, String runtime) {
    movieList.add(new SingleEvent(name, type, id, genre, rating, description, runtime));
    DataWriter.saveEvents();
  }
  /**
   * Adds plays to the array list through json All of them are saved as a String
   *
   * @param name        - name
   * @param id          - id of play
   * @param genre       - type of play
   * @param rating      - rating of the play
   * @param description - description of the play
   * @param runtime     - showtimes of the play
   */
  public void addPlay(String name, String type, String id, String genre, String rating, String description, String runtime) {
    playList.add(new SingleEvent(name, type, id, genre, rating, description, runtime));
    DataWriter.saveEvents();
  }
  /**
   * removes a specific event to the array list through json, All others are saved as a String
   *
   * @param name        - name
   * @param list        - list of events
   */
  public void removeEvent(String name, ArrayList<SingleEvent> list) {
    DataRemover.removeEvent(name, list);
    DataRemover.saveRemovedEvents(list);
  }
}
