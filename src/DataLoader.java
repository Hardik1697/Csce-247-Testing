/**
 * @author Hardik
 */
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

public class DataLoader extends DataWriter {
  private static Scanner sc = new Scanner(System.in);

  /**
   * This method takes in a String param and returns a boolean value, if the param
   * matches the email field in the user JSON file.
   * @param email_user
   * @return
   */
  public static boolean loadEmailForSignUp(String email_user) {
    try {
      FileReader reader = new FileReader(USER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < userJSON.size(); i++) {
        JSONObject user_JSON = (JSONObject)userJSON.get(i);
        String email = (String)user_JSON.get(USER_EMAIL);
        if (email.equalsIgnoreCase(email_user)) {
          return false;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }

  /**
   * This method takes in 3 String param's. It assigns param3 to either the theater json file or event json file,
   * by using a switch statement. It then, tries to match the param1 to the String variable name which it gets from
   * the param3 json file. It returns param2, by assigning name to it if the match is found.
   * This is done, so that it can be used by other classes to load the information of a specific json object in either the
   * theater json or event json.
   * @param1 name_provided_by_admin
   * @param2 test
   * @param3 file_provided_by_admin
   * @return
   */
  public static String loadSpecificStuff(String name_provided_by_admin, String test, String file_provided_by_admin) {
    String field = "";
    switch (file_provided_by_admin.toLowerCase()) {
      case "theater":
        file_provided_by_admin = THEATER_FILE_NAME;
        field = THEATER_NAME;
        break;
      case "event":
        file_provided_by_admin = EVENTS_FILE_NAME;
        field = EVENTS_NAME;
        break;
    }
    try {
      FileReader reader = new FileReader(file_provided_by_admin);
      JSONParser parser = new JSONParser();
      JSONArray json = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < json.size(); i++) {
        JSONObject theater_JSON = (JSONObject)json.get(i);
        String name = (String)theater_JSON.get(field);

        if (name_provided_by_admin.equals(name)) {
          test = name;
          return test;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return test;
  }

  /**
   * This method loads a specific user's information, to be used by another method in the helper class, to return
   * the info when the admin requests for a specific user's info.
   */
  public static void loadSpecificUser() {
    System.out.println("Enter the Email ID of the user you wish to view: ");
    String email_user = sc.nextLine();
    try {
      FileReader reader = new FileReader(USER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < userJSON.size(); i++) {
        JSONObject user_JSON = (JSONObject)userJSON.get(i);
        String firstName = (String)user_JSON.get(USER_FIRST_NAME);
        String lastName = (String)user_JSON.get(USER_LAST_NAME);
        String phoneNumber = (String)user_JSON.get(USER_PHONE_NUMBER);
        String age = (String)user_JSON.get(USER_AGE);
        String status = (String)user_JSON.get(USER_STATUS);
        String email = (String)user_JSON.get(USER_EMAIL);
        String password = (String)user_JSON.get(USER_PASSWORD);

        if (email_user.equals(email)) {
          System.out.println("\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nPhone Number: "
            + phoneNumber + "\nAge: " + age + "\nStatus: " + status + "\nEmail-ID: " + email
            + "\nPassword: " + password + "\n");
        }
        return;
      }
      System.out.println("Failed, please try again");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This method loads a specific user's information, to be used by another method in the helper class, to return
   * the info when the user tries to update his information.
   */
  public static void loadSpecificUser(String email_user) {
    try {
      FileReader reader = new FileReader(USER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < userJSON.size(); i++) {
        JSONObject user_JSON = (JSONObject)userJSON.get(i);
        String firstName = (String)user_JSON.get(USER_FIRST_NAME);
        String lastName = (String)user_JSON.get(USER_LAST_NAME);
        String phoneNumber = (String)user_JSON.get(USER_PHONE_NUMBER);
        String age = (String)user_JSON.get(USER_AGE);
        String status = (String)user_JSON.get(USER_STATUS);
        String email = (String)user_JSON.get(USER_EMAIL);
        String password = (String)user_JSON.get(USER_PASSWORD);

        if (email_user.equals(email)) {
          System.out.println("\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nPhone Number: "
            + phoneNumber + "\nAge: " + age + "\nStatus: " + status + "\nEmail-ID: " + email
            + "\nPassword: " + password + "\n");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This method takes in 2 String param's and returns param2 by matching the email from the user json file,
   * to param1. It then returns param2.
   * This is done to get the user's status, when purchasing a ticket for a movie or a play, to calculate adequate
   * discount based on the status of the user (Like: Student, Military, etc...)
   * @param1 email_user
   * @param2 status_user
   * @return
   */
  public static String getUserStatus(String email_user, String status_user) {
    try {
      FileReader reader = new FileReader(USER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < userJSON.size(); i++) {
        JSONObject user_JSON = (JSONObject)userJSON.get(i);
        String status = (String)user_JSON.get(USER_STATUS);
        String email = (String)user_JSON.get(USER_EMAIL);


        if (email_user.equals(email)) {
          status_user = status;
        }
        return status_user;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * This method loads the user information to the array list made from the singleuser class.
   * @return
   */
  public static ArrayList<SingleUser> loadUser() {
    ArrayList<SingleUser> users = new ArrayList<SingleUser>();

    try {
      FileReader reader = new FileReader(USER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < userJSON.size(); i++) {
        JSONObject user_JSON = (JSONObject)userJSON.get(i);
        String firstName = (String)user_JSON.get(USER_FIRST_NAME);
        String lastName = (String)user_JSON.get(USER_LAST_NAME);
        String phoneNumber = (String)user_JSON.get(USER_PHONE_NUMBER);
        String age = (String)user_JSON.get(USER_AGE);
        String status = (String)user_JSON.get(USER_STATUS);
        String email = (String)user_JSON.get(USER_EMAIL);
        String password = (String)user_JSON.get(USER_PASSWORD);
        String type = (String)user_JSON.get(USER_TYPE);

        users.add(new SingleUser(firstName, lastName, phoneNumber, age, status, email, password, type));
      }

      return users;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the event information to the array list made from the singleEvent class.
   * @return
   */
  public static ArrayList<SingleEvent> loadMovie() {
    ArrayList<SingleEvent> movies = new ArrayList<SingleEvent>();

    try {
      FileReader reader = new FileReader(EVENTS_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray movieJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < movieJSON.size(); i++) {
        JSONObject event_JSON = (JSONObject)movieJSON.get(i);
        String name = (String)event_JSON.get(EVENTS_NAME);
        String type = (String)event_JSON.get(EVENTS_TYPE);
        String id = (String)event_JSON.get(EVENTS_ID);
        String genre = (String)event_JSON.get(EVENTS_GENRE);
        String rating = (String)event_JSON.get(EVENTS_RATING);
        String description = (String)event_JSON.get(EVENTS_DESCRIPTION);
        String runtime = (String)event_JSON.get(EVENTS_RUNTIME);
        if (type.equalsIgnoreCase("Movie")) {
          movies.add(new SingleEvent(name, type, id, genre, rating, description, runtime));
        }
      }

      return movies;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the play information to the array list made from the singleEvent class.
   * @return
   */
  public static ArrayList<SingleEvent> loadPlay() {
    ArrayList<SingleEvent> movies = new ArrayList<SingleEvent>();

    try {
      FileReader reader = new FileReader(EVENTS_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray movieJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < movieJSON.size(); i++) {
        JSONObject event_JSON = (JSONObject)movieJSON.get(i);
        String name = (String)event_JSON.get(EVENTS_NAME);
        String type = (String)event_JSON.get(EVENTS_TYPE);
        String id = (String)event_JSON.get(EVENTS_ID);
        String genre = (String)event_JSON.get(EVENTS_GENRE);
        String rating = (String)event_JSON.get(EVENTS_RATING);
        String description = (String)event_JSON.get(EVENTS_DESCRIPTION);
        String runtime = (String)event_JSON.get(EVENTS_RUNTIME);
        if (type.equalsIgnoreCase("Play")) {
          movies.add(new SingleEvent(name, type, id, genre, rating, description, runtime));
        }
      }

      return movies;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the theater information to the array list made from the SingleTheater class.
   * @return
   */
  public static ArrayList<SingleTheater> loadTheater() {
    ArrayList<SingleTheater> theaters = new ArrayList<SingleTheater>();

    try {
      FileReader reader = new FileReader(THEATER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray theaterJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < theaterJSON.size(); i++) {
        JSONObject theater_JSON = (JSONObject)theaterJSON.get(i);
        String name = (String)theater_JSON.get(THEATER_NAME);
        String id = (String)theater_JSON.get(THEATER_ID);
        String address = (String)theater_JSON.get(THEATER_ADDRESS);
        String price = (String)theater_JSON.get(THEATER_PRICE);
        theaters.add(new SingleTheater(name, id, address, price));
      }

      return theaters;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the movie show times' information to the array list made from the SingleShowTime class.
   * @return
   */
  public static ArrayList<SingleShowTime> loadShowTimesMovies() {
    ArrayList<SingleShowTime> showTimes = new ArrayList<SingleShowTime>();

    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < showJSON.size(); i++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(i);
        String name = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        String type = (String)show_JSON.get(SHOWTIME_TYPE);
        String theater = (String)show_JSON.get(SHOWTIME_THEATER_NAME);
        String showtime = (String)show_JSON.get(SHOWTIME_TIME);

        if (type.equalsIgnoreCase("Movie")) {
          showTimes.add(new SingleShowTime(name, showtime, theater, type));
        }
      }

      return showTimes;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the play show times' information to the array list made from the SingleShowTime class.
   * @return
   */
  public static ArrayList<SingleShowTime> loadShowTimesPlays() {
    ArrayList<SingleShowTime> showTimes = new ArrayList<SingleShowTime>();

    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < showJSON.size(); i++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(i);
        String name = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        String type = (String)show_JSON.get(SHOWTIME_TYPE);
        String theater = (String)show_JSON.get(SHOWTIME_THEATER_NAME);
        String showtime = (String)show_JSON.get(SHOWTIME_TIME);

        if (type.equalsIgnoreCase("Play")) {
          showTimes.add(new SingleShowTime(name, showtime, theater, type));
        }
      }

      return showTimes;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the ticket's information to the array list made from the SingleTicket class.
   * @return
   */
  public static ArrayList<SingleTicket> loadTicket() {
    ArrayList<SingleTicket> ticketMovie = new ArrayList<SingleTicket>();

    try {
      FileReader reader = new FileReader(TICKET_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray ticketMovieJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < ticketMovieJSON.size(); i++) {
        JSONObject ticketMovie_JSON = (JSONObject)ticketMovieJSON.get(i);
        String email = (String)ticketMovie_JSON.get(TICKET_EMAIL);
        String type = (String)ticketMovie_JSON.get(TICKET_TYPE);
        String movieName = (String)ticketMovie_JSON.get(TICKET_MOVIE_NAME);
        String theaterName = (String)ticketMovie_JSON.get(TICKET_THEATER_NAME);
        String theaterLocation = (String)ticketMovie_JSON.get(TICKET_THEATER_LOCATION);
        String seat = (String)ticketMovie_JSON.get(TICKET_SEAT);
        String price = (String)ticketMovie_JSON.get(TICKET_PRICE);
        String time = (String)ticketMovie_JSON.get(TICKET_SHOW_TIME);

        ticketMovie.add(new SingleTicket(email, type, movieName, theaterName, theaterLocation, seat, price, time));
      }

      return ticketMovie;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the movie reviews' information to the array list made from the SingleReview class.
   * @return
   */
  public static ArrayList<SingleReview> loadReviewMovie() {
    ArrayList<SingleReview> review = new ArrayList<SingleReview>();

    try {
      FileReader reader = new FileReader(REVIEW_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray reviewJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < reviewJSON.size(); i++) {
        JSONObject review_JSON = (JSONObject)reviewJSON.get(i);
        String email = (String)review_JSON.get(REVIEW_EMAIL);
        String type = (String)review_JSON.get(REVIEW_TYPE);
        String name = (String)review_JSON.get(REVIEW_NAME);
        String description = (String)review_JSON.get(REVIEW_DESCRIPTION);
        String rating = (String)review_JSON.get(REVIEW_USER_RATING);
        if (type.equalsIgnoreCase("Movie")) {
          review.add(new SingleReview(email, type, name, description, rating));
        }
      }

      return review;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the play reviews'' information to the array list made from the SingleReview class.
   * @return
   */
  public static ArrayList<SingleReview> loadReviewPlay() {
    ArrayList<SingleReview> review = new ArrayList<SingleReview>();

    try {
      FileReader reader = new FileReader(REVIEW_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray reviewJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < reviewJSON.size(); i++) {
        JSONObject review_JSON = (JSONObject)reviewJSON.get(i);
        String email = (String)review_JSON.get(REVIEW_EMAIL);
        String type = (String)review_JSON.get(REVIEW_TYPE);
        String name = (String)review_JSON.get(REVIEW_NAME);
        String description = (String)review_JSON.get(REVIEW_DESCRIPTION);
        String rating = (String)review_JSON.get(REVIEW_USER_RATING);

        if (type.equalsIgnoreCase("Play")) {
          review.add(new SingleReview(email, type, name, description, rating));
        }
      }

      return review;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * This method loads the theater reviews' information to the array list made from the SingleReview class.
   * @return
   */
  public static ArrayList<SingleReview> loadReviewTheater() {
    ArrayList<SingleReview> review = new ArrayList<SingleReview>();

    try {
      FileReader reader = new FileReader(REVIEW_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray reviewJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < reviewJSON.size(); i++) {
        JSONObject review_JSON = (JSONObject)reviewJSON.get(i);
        String email = (String)review_JSON.get(REVIEW_EMAIL);
        String type = (String)review_JSON.get(REVIEW_TYPE);
        String name = (String)review_JSON.get(REVIEW_NAME);
        String description = (String)review_JSON.get(REVIEW_DESCRIPTION);
        String rating = (String)review_JSON.get(REVIEW_USER_RATING);

        if (type.equalsIgnoreCase("Theater")) {
          review.add(new SingleReview(email, type, name, description, rating));
        }
      }

      return review;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }



  /**
   * This method takes in a String event and returns a boolean value.
   * This is done to check if the event's name exists in the event json file.
   * @param event
   * @return
   */
  public static boolean getEventName(String event) {
    try {
      FileReader reader = new FileReader(EVENTS_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray theaterJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < theaterJSON.size(); i++) {
        JSONObject theater_JSON = (JSONObject)theaterJSON.get(i);
        String name = (String)theater_JSON.get(EVENTS_NAME);
        if (event.equals(name)) {
          return true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * This method takes in a String theater and returns a boolean value.
   * This is done to check if the theater's name exists in the theater json file.
   * @param theater
   * @return
   */
  public static boolean getTheaterName(String theater) {
    try {
      FileReader reader = new FileReader(THEATER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray theaterJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < theaterJSON.size(); i++) {
        JSONObject theater_JSON = (JSONObject)theaterJSON.get(i);
        String name = (String)theater_JSON.get(THEATER_NAME);
        String location1 = (String)theater_JSON.get(THEATER_ADDRESS);
        if (theater.equals(name)) {
          return true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * This method takes on 2 params and returns param2, if the price of the theater matches param2.
   * This is done to get the theater's price from the theater json file, when purchasing a movie or play ticket.
   * @param1 theater
   * @param2 price
   * @return
   */
  public static String getTheaterPrice(String theater, String price) {
    try {
      FileReader reader = new FileReader(THEATER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray theaterJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < theaterJSON.size(); i++) {
        JSONObject theater_JSON = (JSONObject)theaterJSON.get(i);
        String name = (String)theater_JSON.get(THEATER_NAME);
        String price1 = (String)theater_JSON.get(THEATER_PRICE);
        if (theater.equals(name)) {
          price = price1;
          return price;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return price;
  }
  /**
   * This method takes on 2 params and returns param2, if the price of the theater matches param2.
   * This is done to get the theater's location from the theater json file, when purchasing a movie or play ticket.
   * @param1 theater
   * @param2 location
   * @return
   */
  public static String getTheaterLocation(String theater, String location) {
    try {
      FileReader reader = new FileReader(THEATER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray theaterJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < theaterJSON.size(); i++) {
        JSONObject theater_JSON = (JSONObject)theaterJSON.get(i);
        String name = (String)theater_JSON.get(THEATER_NAME);
        String location1 = (String)theater_JSON.get(THEATER_ADDRESS);
        if (theater.equals(name)) {
          location = location1;
          return location;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * This method takes in 3 params and returns param 3, if param1 matches the the email of the user and param2 to the type
   * present in the review json file.
   * Increments param3 on every match.
   * This is done to determine the size of the reviews array by using param2.
   * @param1 email_user
   * @param2 type
   * @param3 num_reviews
   * @return
   */
  public static int getNumReviewsType(String email_user, String type, int num_reviews) {
    int number_of_reviews = 0;
    try {
      FileReader reader = new FileReader(REVIEW_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray reviewJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < reviewJSON.size(); i++) {
        JSONObject review_JSON = (JSONObject)reviewJSON.get(i);
        String email = (String)review_JSON.get(REVIEW_EMAIL);
        String type1 = (String)review_JSON.get(REVIEW_TYPE);
        if (email_user.equals(email) && type.equals(type1)) {
          number_of_reviews++;
        }
      }
      num_reviews = number_of_reviews;
      return num_reviews;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return num_reviews;
  }


  /**
   * This method takes in 2 params and returns param 2, if param1 matches the the email of the user present in the review json file.
   * Increments param2 on every match.
   * This is done to determine the size of the reviews array by using param2.
   * @param1 email_user
   * @param2 num_reviews
   * @return
   */
  public static int getNumReviewsAll(String email_user, int num_reviews) {
    int number_of_reviews = 0;
    try {
      FileReader reader = new FileReader(REVIEW_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray reviewJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < reviewJSON.size(); i++) {
        JSONObject review_JSON = (JSONObject)reviewJSON.get(i);
        String email = (String)review_JSON.get(REVIEW_EMAIL);
        if (email_user.equals(email)) {
          number_of_reviews++;
        }
      }
      num_reviews = number_of_reviews;
      return num_reviews;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return num_reviews;
  }

  /**
   * This method takes in 2 params and returns a String array by populating it from the review json file,
   * if param1 matches email from review json file and param1 natches the email from the review json file.
   * This is done to display reviews given by a specific user that are stored in the review json file.
   * @param1 email_user
   * @param2 reviewArray
   * @return
   */
  public static String[] displayReviewsAllJSON(String email_user, String[] reviewArray) {
    try {
      FileReader reader = new FileReader(REVIEW_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray reviewJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < reviewJSON.size(); i++) {
        JSONObject review_JSON = (JSONObject)reviewJSON.get(i);
        String email = (String)review_JSON.get(REVIEW_EMAIL);
        String type = (String)review_JSON.get(REVIEW_TYPE);
        String name = (String)review_JSON.get(REVIEW_NAME);
        String description = (String)review_JSON.get(REVIEW_DESCRIPTION);
        String rating = (String)review_JSON.get(REVIEW_USER_RATING);

        if (email_user.equals(email)) {
          String combined_string = type + " Name: " + name + "\nReview: " + description + "\nUser Rating: " + rating + "\n";
          reviewArray[i] = combined_string;
        }
      }

      return reviewArray;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return reviewArray;
  }

  /**
   * This method takes in 3 params and returns a String array by populating it from the review json file,
   * if param1 matches email from review json file and param2 natches the type from the review json file.
   * This is done to display reviews given by a specific user that are stored in the review json file.
   * @param1 email_user
   * @param2 type
   * @param3 reviewArray
   * @return
   */
  public static String[] displayReviewsTypeJSON(String email_user, String type, String[] reviewArray) {
    try {
      FileReader reader = new FileReader(REVIEW_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray reviewJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < reviewJSON.size(); i++) {
        JSONObject review_JSON = (JSONObject)reviewJSON.get(i);
        String email = (String)review_JSON.get(REVIEW_EMAIL);
        String type1 = (String)review_JSON.get(REVIEW_TYPE);
        String name = (String)review_JSON.get(REVIEW_NAME);
        String description = (String)review_JSON.get(REVIEW_DESCRIPTION);
        String rating = (String)review_JSON.get(REVIEW_USER_RATING);

        if (email_user.equals(email) && type.equalsIgnoreCase(type1)) {
          String combined_string = type + " Name: " + name + "\nReview: " + description + "\nUser Rating: " + rating + "\n";
          reviewArray[i] = combined_string;
        }
      }

      return reviewArray;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return reviewArray;
  }

  /**
   * This method takes in 3 params and returns param 1, if param2 matches the the event present in the showtimes json file,
   * and if param3 matches the theater present in the showtimes json file.
   * Increments param1 on every match.
   * Used when purchasing a ticket.
   * This is done to determine the size of the showTime array by using param2.
   * @param1 num
   * @param2 movie
   * @param3 theater
   * @return
   */
  public static int showTimeNumber(String movie, String theater) {
    int num = 0;
    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < showJSON.size(); i++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(i);
        String movieName = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        String theater_name = (String)show_JSON.get(SHOWTIME_THEATER_NAME);
        if (movie.equalsIgnoreCase(movieName) && theater.equalsIgnoreCase(theater_name)) {
          num++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return num;
  }

  /**
   * This method takes in 3 params and returns a String array by populating it from the showtime json file,
   * if param2 matches movie from showtime json file and param3 natches the theater from the showtime json file.
   * This is done to display showtimes of a specific event that are stored in the showtime json file.
   * @param1 showTimeArray
   * @param2 movie
   * @param3 theater
   * @return
   */
  public static String[] getShowTimeSpecific(String[] showTimeArray, String movie, String theater) {
    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);

      int k = 0;
      for(int i=0; i < showJSON.size(); i++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(i);
        String movieName = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        String theater_name = (String)show_JSON.get(SHOWTIME_THEATER_NAME);
        String showTime = (String)show_JSON.get(SHOWTIME_TIME);
        if (movie.equalsIgnoreCase(movieName) && theater.equalsIgnoreCase(theater_name)) {
          showTimeArray[k] = showTime;
          k++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return showTimeArray;
  }

  public static boolean validateShowTime(String event, String theater) {
    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);

      int k = 0;
      for(int i=0; i < showJSON.size(); i++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(i);
        String movieName = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        String theater_name = (String)show_JSON.get(SHOWTIME_THEATER_NAME);
        if (event.equalsIgnoreCase(movieName) && theater.equalsIgnoreCase(theater_name)) {
          return true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public static int showTimeNumberEvent(int num, String movie) {
    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);

      for(int k=0; k < showJSON.size(); k++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(k);
        String movieName = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        if (movie.equalsIgnoreCase(movieName)) {
          num++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return num;
  }

  public static String[] getShowTimeEvent(String[] showTimeArray, String movie) {
    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);
      int i = 0;
      for(int k=0; k < showJSON.size(); k++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(k);
        String movieName = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        String theater_name = (String)show_JSON.get(SHOWTIME_THEATER_NAME);
        String showTime = (String)show_JSON.get(SHOWTIME_TIME);
        if (movie.equalsIgnoreCase(movieName)) {
          showTimeArray[i] = "Theater: " + theater_name + "\nTime: " + showTime;
          i++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return showTimeArray;
  }

}
