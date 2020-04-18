/**
 * @author Hardik
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

  /**
   * This method flushes data into the user json file.
   */
  public static void saveUsers() {
    Users users = Users.getInstance();
    ArrayList<SingleUser> user1 = users.getUsers();
    JSONArray jsonUsers = new JSONArray();

    //creating all the json objects
    for(int i=0; i< user1.size(); i++) {
      jsonUsers.add(putUsersJSON(user1.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(USER_FILE_NAME)) {

      file.write(jsonUsers.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method flushes data into the events json file.
   */
  public static void saveEvents() {
    Events events = Events.getInstance();
    ArrayList<SingleEvent> events1 = events.getEvents();
    //ArrayList<SingleEvent> events2 = events.getPlays();
    JSONArray jsonEvents = new JSONArray();

    //creating all the json objects
    for(int i=0; i< events1.size(); i++) {
      jsonEvents.add(putEventJSON(events1.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(EVENTS_FILE_NAME)) {

      file.write(jsonEvents.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method flushes data into the theaters json file.
   */
  public static void saveTheaters() {
    Theaters theaters = Theaters.getInstance();
    ArrayList<SingleTheater> theater1 = theaters.getTheaters();
    JSONArray jsonTheater = new JSONArray();

    //creating all the json objects
    for(int i=0; i< theater1.size(); i++) {
      jsonTheater.add(putTheatersJSON(theater1.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(THEATER_FILE_NAME)) {

      file.write(jsonTheater.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method flushes data into the showtimes json file.
   */
  public static void saveShowTimes() {
    ShowTimes showtime = ShowTimes.getInstance();
    ArrayList<SingleShowTime> showtime1 = new ArrayList<SingleShowTime>();
    showtime1 = showtime.getShowTimes();

    JSONArray jsonShowTime = new JSONArray();

    //creating all the json objects
    for(int i=0; i< showtime1.size(); i++) {
      jsonShowTime.add(putShowTimesJSON(showtime1.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(SHOWTIME_FILE_NAME)) {

      file.write(jsonShowTime.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method flushes data into the ticket json file.
   */
  public static void saveTicket() {
    Tickets ticket = Tickets.getInstance();
    ArrayList<SingleTicket> ticket1 = ticket.getTicket();
    JSONArray jsonTicket = new JSONArray();

    //creating all the json objects
    for(int i=0; i< ticket1.size(); i++) {
      jsonTicket.add(putTicketsJSON(ticket1.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(TICKET_FILE_NAME)) {

      file.write(jsonTicket.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method flushes data into the review json file.
   */
  public static void saveReview() {
    Review reviews = Review.getInstance();
    ArrayList<SingleReview> review1 = new ArrayList<SingleReview>();
    review1 = reviews.getReviews();

    JSONArray jsonReview = new JSONArray();

    //creating all the json objects
    for(int i=0; i< review1.size(); i++) {
      jsonReview.add(putReviewJSON(review1.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(REVIEW_FILE_NAME)) {

      file.write(jsonReview.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method is used to input data into the user json file
   * @param user
   * @return
   */
  public static JSONObject putUsersJSON(SingleUser user) {
    JSONObject userDetails = new JSONObject();
    userDetails.put(USER_FIRST_NAME, user.getFirstName());
    userDetails.put(USER_LAST_NAME, user.getLastName());
    userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
    userDetails.put(USER_AGE, user.getAge());
    userDetails.put(USER_STATUS, user.getStatus());
    userDetails.put(USER_EMAIL, user.getEmail());
    userDetails.put(USER_PASSWORD, user.getPassword());
    userDetails.put(USER_TYPE, user.getType());

    return userDetails;
  }

  /**
   * This method is used to input data into the event json file
   * @param event
   * @return
   */
  public static JSONObject putEventJSON(SingleEvent event) {
    JSONObject eventDetails = new JSONObject();
    eventDetails.put(EVENTS_NAME, event.getName());
    eventDetails.put(EVENTS_TYPE, event.getType());
    eventDetails.put(EVENTS_ID, event.getId());
    eventDetails.put(EVENTS_GENRE, event.getGenre());
    eventDetails.put(EVENTS_RATING, event.getRating());
    eventDetails.put(EVENTS_DESCRIPTION, event.getDescription());
    eventDetails.put(EVENTS_RUNTIME, event.getRuntime());

    return eventDetails;
  }

  /**
   * This method is used to input data into the theater json file
   * @param theater
   * @return
   */
  public static JSONObject putTheatersJSON(SingleTheater theater) {
    JSONObject theaterDetails = new JSONObject();
    theaterDetails.put(THEATER_NAME, theater.getName());
    theaterDetails.put(THEATER_ID, theater.getId());
    theaterDetails.put(THEATER_ADDRESS, theater.getAddress());
    theaterDetails.put(THEATER_PRICE, theater.getPrice());

    return theaterDetails;
  }

  /**
   * This method is used to input data into the showtimes json file
   * @param showtime
   * @return
   */
  public static JSONObject putShowTimesJSON(SingleShowTime showtime) {
    JSONObject showDetails = new JSONObject();
    showDetails.put(SHOWTIME_MOVIE_NAME, showtime.getName());
    showDetails.put(SHOWTIME_TIME, showtime.getShowTime());
    showDetails.put(SHOWTIME_THEATER_NAME, showtime.getTheater());
    showDetails.put(SHOWTIME_TYPE, showtime.getType());

    return showDetails;
  }

  /**
   * This method is used to input data into the ticket json file
   * @param ticketMovie
   * @return
   */
  public static JSONObject putTicketsJSON(SingleTicket ticketMovie) {
    JSONObject ticketMovieDetails = new JSONObject();
    ticketMovieDetails.put(TICKET_EMAIL, ticketMovie.getEmail());
    ticketMovieDetails.put(TICKET_TYPE, ticketMovie.getType());
    ticketMovieDetails.put(TICKET_MOVIE_NAME, ticketMovie.getMovieName());
    ticketMovieDetails.put(TICKET_THEATER_LOCATION, ticketMovie.getTheaterName());
    ticketMovieDetails.put(TICKET_THEATER_LOCATION, ticketMovie.getTheaterLocation());
    ticketMovieDetails.put(TICKET_SEAT, ticketMovie.getSeat());
    ticketMovieDetails.put(TICKET_PRICE, ticketMovie.getPrice());
    ticketMovieDetails.put(TICKET_SHOW_TIME, ticketMovie.getShowTime());


    return ticketMovieDetails;
  }

  /**
   * This method is used to input data into the review json file
   * @param review
   * @return
   */
  public static JSONObject putReviewJSON(SingleReview review) {
    JSONObject reviewDetails = new JSONObject();
    reviewDetails.put(REVIEW_EMAIL, review.getEmail());
    reviewDetails.put(REVIEW_TYPE, review.getType());
    reviewDetails.put(REVIEW_NAME, review.getName());
    reviewDetails.put(REVIEW_DESCRIPTION, review.getDescription());
    reviewDetails.put(REVIEW_USER_RATING, review.getRating());

    return reviewDetails;
  }
}
