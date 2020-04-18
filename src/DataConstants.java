/**
 * @author Prathamjeet
 */
public abstract class DataConstants {
  /**
   * This attributes are for user's info and include their file location
   */
  protected static final String USER_FILE_NAME = "src/users.json";
  protected static final String USER_FIRST_NAME = "firstName";
  protected static final String USER_LAST_NAME = "lastName";
  protected static final String USER_PHONE_NUMBER = "phoneNumber";
  protected static final String USER_AGE = "age";
  protected static final String USER_STATUS = "status";
  protected static final String USER_EMAIL = "email";
  protected static final String USER_PASSWORD = "password";
  protected static final String USER_TYPE = "type";

  /**
   * This attributes are for event's info and include their file location
   */
  protected static final String EVENTS_FILE_NAME = "src/events.json";
  protected static final String EVENTS_TYPE = "type";
  protected static final String EVENTS_NAME = "name";
  protected static final String EVENTS_ID = "id";
  protected static final String EVENTS_GENRE = "genre";
  protected static final String EVENTS_RATING = "rating";
  protected static final String EVENTS_DESCRIPTION = "description";
  protected static final String EVENTS_RUNTIME = "runtime";

  /**
   * This attributes are for theater's info and include their file location
   */
  protected static final String THEATER_FILE_NAME = "src/theaters.json";
  protected static final String THEATER_NAME = "name";
  protected static final String THEATER_ID = "id";
  protected static final String THEATER_ADDRESS = "address";
  protected static final String THEATER_PRICE = "price";

  /**
   * This attributes are for showtime's info and include their file location
   */

  protected static final String SHOWTIME_FILE_NAME = "src/showtimes.json";
  protected static final String SHOWTIME_MOVIE_NAME = "movie";
  protected static final String SHOWTIME_TYPE = "type";
  protected static final String SHOWTIME_THEATER_NAME = "theater";
  protected static final String SHOWTIME_TIME = "time";

  /**
   * This attributes are for user's info and include their file location
   */
  protected static final String TICKET_FILE_NAME = "src/tickets.json";
  protected static final String TICKET_EMAIL = "email";
  protected static final String TICKET_TYPE = "type";
  protected static final String TICKET_MOVIE_NAME = "moviename";
  protected static final String TICKET_THEATER_NAME = "thetaername";
  protected static final String TICKET_THEATER_LOCATION = "theaterlocation";
  protected static final String TICKET_SEAT = "seat";
  protected static final String TICKET_PRICE = "price";
  protected static final String TICKET_SHOW_TIME = "time";

  /**
   * This attributes are for review's info and include their file location
   */
  protected static final String REVIEW_FILE_NAME = "src/reviews.json";
  protected static final String REVIEW_EMAIL = "email";
  protected static final String REVIEW_TYPE = "type";
  protected static final String REVIEW_NAME = "name";
  protected static final String REVIEW_DESCRIPTION = "description";
  protected static final String REVIEW_USER_RATING = "userrating";
}
