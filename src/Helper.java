/**
 * @author Hardik
 */
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;

public class Helper extends DataRemover {
  private static Helper helper = null;
  private Scanner sc = new Scanner(System.in);
  private Random rand = new Random();
  String path = "src/ticket.txt";

  /**
   * A method to get this class' instance by other classes, checks if an instance has been created before.
   * @return
   */
  public static Helper getInstance() {
    if(helper == null) {
      helper = new Helper();
    }
    return helper;
  }

  /**
   * Helper method to store the input from the user to a String
   * @param prompt
   * @return
   */
  public String input(String prompt) {
      System.out.print(prompt);
      return sc.nextLine();
  }

  /**
   * Adds ticket to a text file
   * @param movie_name
   * @param theater_name
   * @param location
   * @param showTime
   * @param seat
   * @param discounted_price_string
   */
  private void addToTicketFile(String movie_name, String theater_name, String location
    , String showTime, String seat, String discounted_price_string) {
    String str = "*********FilmBooker*********\nName: " + movie_name + "\nTheater Name: " + theater_name + "\nTheater Location: " + location +
      "\nShow Time: " + showTime + "\nSeat Number: " + seat + "\nPrice: " + discounted_price_string + "\n*********FilmBooker*********\n";
    try {
      Files.write(Paths.get(path), str.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
    }
  }

  /**
   * Clears the text file of any data
   */
  private void clearFile() {
    try {
      FileWriter fw = new FileWriter(path, false);
      PrintWriter pw = new PrintWriter(fw, false);
      pw.flush();
      pw.close();
      fw.close();
    } catch (IOException e) {
      System.out.println("File not found");
    }

  }

  /**
   * This method lets the user update thier information and flushes it to the user json file
   * @param email
   */
  public void updateUserInfo(String email, String status) {
    boolean loop = true;
    while (loop) {
      String field = "";
      String choice = input("What would you like to update: \n1. First Name\n2. Last Name\3. Status\n4. Phone number\n5. Password\n6. Go Back\n" +
        "(1, 2, 3, 4, 5, 6)");
      switch (choice) {
        case "1":
          field = "first";
          break;
        case "2":
          field = "last";
          break;
        case "3":
          field = "status";
          break;
        case "4":
          field = "phone";
          break;
        case "5":
          field = "pass";
          break;
        case "6":
          System.out.println("Going Back...");
          accountSettings(email, status);
          //loop = false;
          break;
      }
      if (!field.equals("pass")) {
        String oldData = input("Enter Old Data: ");
        String newData = input("Enter New Data: ");
        Users user = Users.getInstance();
        ArrayList<SingleUser> userList = new ArrayList<SingleUser>();
        userList = user.getUsersUpdated();
        user.updateUser(email, newData, field, userList);
        loadSpecificUser(email);
      }
      else if (field.equals("pass")) {
        String oldData = input("Enter Old Data: ");
        String newData = input("Enter New Data: ");
        String newData1 = input("Re-Enter New Data: ");
        if (newData.equals(newData1)) {
          Users user = Users.getInstance();
          ArrayList<SingleUser> userList = new ArrayList<SingleUser>();
          userList = user.getUsersUpdated();
          user.updateUser(email, newData, field, userList);
          loadSpecificUser(email);
          if (!oldData.equals(newData1)) {
            System.out.println("Password has been changed, logging you out!");
            Driver driver = new Driver();
            driver.homeScreen();
          }
        } else {
          System.out.println("Failed, Going Back...");
          loop = false;
        }
      }
    }
  }

  /**
   * Displays all the users
   */
  public void displayUsers() {
    Users people = Users.getInstance();
    ArrayList<SingleUser> user1 = people.getUsers();
    int i = 0;

    for (SingleUser user : user1) {
      i++;
      System.out.println("\nUser " + i + ":" + "\nFirst Name: " + user.getFirstName() + "\nLast Name: " + user.getLastName() + "\nPhone Number: "
              + user.getPhoneNumber() + "\nAge: " + user.getAge() + "\nStatus: " + user.getStatus() + "\nEmail-ID: " + user.getEmail()
              + "\nPassword: " + user.getPassword());
    }
  }

  /**
   * Lets the admin add an event to the events json file
   * @param type
   */
  public void addSingleEvent(String type) {
    Events events = Events.getInstance();
    while (addSingleEventBool(type)) {
      String name = input(type + " Name: ");
      int random_id = rand.nextInt(10000);
      if (random_id < 1000) {
        random_id += 1000;
      }
      String id = String.valueOf(random_id);
      String genre = input("Genre: ");
      String rating = input("Rating (Enter the company name followed by a ': ', followed by the Rating");
      String description = input("Description: ");
      String runTime = input("Run Time: ");
      if (type.equalsIgnoreCase("Movie")) {
        events.addMovie(name, type, id, genre, rating, description, runTime);
        addSingleShowTime(name, type);
      }
      else if (type.equalsIgnoreCase("Play")) {
        events.addPlay(name, type, id, genre, rating, description, runTime);
        addSingleShowTime(name, type);
      }
    }
    while (displayEventsBool(type)) {
      displayEvents(type);
    }
  }

  /**
   * boolean method to validate if the admin wants to view the events
   * @param type
   * @return
   */
  public boolean displayEventsBool(String type) {
    System.out.print("Would you like to view the list of Events? (Y or N): ");
    String input = sc.nextLine();
    if (input.toLowerCase().trim().equals("y")) return true;
    return false;
  }

  /**
   * boolean method to validate if the admin wants to add an event
   * @param type
   * @return
   */
  public boolean addSingleEventBool(String type) {
    System.out.print("Would you like to add a " + type + "? (Y or N): ");
    String input = sc.nextLine();
    if (input.toLowerCase().trim().equals("y")) return true;
    return false;
  }

  /**
   * Displays the events on the console
   * @param type
   */
  public void displayEvents(String type) {
    Events movies = Events.getInstance();
    ArrayList<SingleEvent> movie1 = new ArrayList<SingleEvent>();
    if (type.equalsIgnoreCase("Movie")) {
      movie1 = movies.getMovies();
    }
    else if (type.equalsIgnoreCase("Play")) {
      movie1 = movies.getPlays();
    }
    int i = 0;
    System.out.println("\nList of " + type + ": ");
    for (SingleEvent movie : movie1) {
      i++;
      String description = movie.getDescription();
      char[] desc = new char[description.length()];
      if (description.length() > 196) {
        for (int j = 0; j < description.length(); j++) {
          desc[j] = description.charAt(j);
        }
      }
      System.out.println("\n" + type + " number " + i + "\n" + type + " name: " + movie.getName() + "\n" + type + " ID: " + movie.getId() + "\n" + type + " Genre: "
              + movie.getGenre() + "\n" + type + " Rating: " + movie.getRating() + "\n" + type + " Description: ");
      if (description.length() > 196) {
        for (int l = 0; l < 196; l++) {
          System.out.print(desc[l]);
        }
        for (int k = 196; k < description.length(); k++) {
          if (k % 196 == 0) {
            System.out.println(desc[k]);
          } else {
            System.out.print(desc[k]);
          }
        }
      } else {
        System.out.println(description + "\n");
      }
      int num_showTime = 0;
      num_showTime = showTimeNumberEvent(num_showTime, movie.getName());
      String[] showTimeArray = new String[num_showTime];
      getShowTimeEvent(showTimeArray, movie.getName());
      System.out.println();
      for (int j = 0; j < showTimeArray.length; j++) {
        int k = j + 1;
        System.out.println("\nShow Time " + k + ": \n" + showTimeArray[j]);
      }
      System.out.println();
    }
  }

  /**
   * Lets the admin add a theater to the theater json file
   * @param type
   */
  public void addSingleTheater(String type) {
    Theaters theaters = Theaters.getInstance();
    while (addSingleTheaterBool()) {
      String name = input("Theater Name: ");
      int random_id = rand.nextInt(10000);
      if (random_id < 1000) {
        random_id += 1000;
      }
      String id = String.valueOf(random_id);
      String address = input("Address: ");
      String price = input("Price for " + type + ": ");
      theaters.addTheater(name, id, address, price);
    }
    System.out.println("List of Theaters: \n");
    displayTheaters();
  }

  /**
   * boolean method to validate if the admin wants to add a theater
   * @return
   */
  public boolean addSingleTheaterBool() {
    System.out.print("Would you like to add a Theater? (Y or N): ");
    String input = sc.nextLine();
    if (input.toLowerCase().trim().equals("y")) return true;
    return false;
  }

  /**
   * Displays the theaters to the console
   */
  public void displayTheaters() {
    Theaters theaters = Theaters.getInstance();
    ArrayList<SingleTheater> theaters1 = theaters.getTheaters();
    int i = 0;
    System.out.println("\nList of Theaters: " + "\n");
    for (SingleTheater theater : theaters1) {
      i++;
      System.out.println("Theater number " + i + "\nTheater name: " + theater.getName() + "\nTheater ID: " + theater.getName()
        + "\nTheater Address: " + theater.getAddress() + "\n");
    }
  }

  /**
   * lets the admin add a showtime to the showtime json file
   * @param name
   * @param type
   */
  public void addSingleShowTime(String name, String type) {
    ShowTimes showTimes = ShowTimes.getInstance();
    while (addSingleShowTimeBool()) {
      String theater = input("Theater Name:");
      String time = input("Time, with date [Sample: 8:30, 04/18/2020]: ");

      if (type.equalsIgnoreCase("Movie")) {
        showTimes.addShowTimeMovie(name, time, theater, type);
      }
      else if (type.equalsIgnoreCase("Play")) {
        showTimes.addShowTimePlay(name, time, theater, type);
      }
    }
    System.out.println("List of Show Times: ");
    displayShowTimes(type);
  }

  /**
   * boolean method to validate if the admin wants to add a showtime
   * @return
   */
  public boolean addSingleShowTimeBool() {
    System.out.print("Would you like to add a Show Time? (Y or N): ");
    String input = sc.nextLine();
    if (input.toLowerCase().trim().equals("y")) return true;
    return false;
  }

  /**
   * displays showtimes to the console
   * @param type
   */
  public void displayShowTimes(String type) {
    ShowTimes showTimes = ShowTimes.getInstance();
    ArrayList<SingleShowTime> showTimes1 = new ArrayList<SingleShowTime>();
    if (type.equalsIgnoreCase("Movie")) {
      showTimes1 = showTimes.getShowTimesMovies();
    }
    else if (type.equalsIgnoreCase("Play")) {
      showTimes1 = showTimes.getShowTimesPlays();
    }
    int i = 0;

    for (SingleShowTime showTime : showTimes1) {
      i++;
      System.out.println("\nShow Time Number " + i + "\nShow Time: " + showTime.getShowTime() + "\n" + type + " Name: " + showTime.getName() +
        "\nTheater Name: " + showTime.getTheater());
    }
  }

  /**
   * lets the user purchase a ticket for an event
   * @param email
   * @param status
   * @param type
   */
  public void purchaseTicket(String email, String status, String type) {
    clearFile();
    Seats init = new Seats(6);
    String location = "", seat = "", discounted_price_string = "", showTime = "";
    String movie_name = input("Enter a " + type + " Name: ");
    String theater_name = input("Enter a Theater Name: ");
    if (validateShowTime(movie_name, theater_name)) {
    System.out.println("Enter the number of tickets you would like to purchase: ");
    String num_tickets = sc.nextLine();
    int num = 0;
    try {
      num = Integer.parseInt(num_tickets);
    } catch (NumberFormatException ignore) {
      System.out.println("Invalid input");
    }
    String[] ticketArray = new String[num];
    String details = "";
    for (int i = 0; i < num; i++) {
      if (getTheaterName(theater_name) && getEventName(movie_name)) {
        int num_showTime = 0;
        num_showTime = showTimeNumber(movie_name, theater_name);
        String[] showTimeArray = new String[num_showTime];
        getShowTimeSpecific(showTimeArray, movie_name, theater_name);
        String str_price = "";
        str_price = getTheaterPrice(theater_name, str_price);
        System.out.println("List of Showtimes: ");
        int k = 0;
        for (int j = 0; j < showTimeArray.length; j++) {
          k++;
          System.out.println("Show Time Number: " + k + "\nShow Time: " + showTimeArray[j] + "\nPrice before Discount: " + str_price);
        }
        if (showTimeArray.length == 0) {
          System.out.println("Sorry there are currently no Show Times, please try again at a later time!");
          break;
        }
        showTime = input("Enter Show Time Number [1, 2, 3...]");
        int time = Integer.parseInt(showTime);
        boolean loop = true;
        while (loop) {
          if (time != 0 && time <= showTimeArray.length) {
            showTime = showTimeArray[time - 1];
            loop = false;
          } else {
            System.out.println("You chose the wrong Show Time Number, please try again!");
          }
        }
        init.printSeats();
        seat = input("Enter the seat [A0, B1, C2...]: ");

        init.takeSeat(seat);
        System.out.println("Seat has been selected");
        init.printSeats();
        double double_price = Double.parseDouble(str_price);
        double discount = 0;
        switch (status.toLowerCase()) {
          case "student":
            discount = 10;
            break;
          case "veteran":
            discount = 20;
            break;
          case "military":
            discount = 25;
            break;
          case "none":
            discount = 0;
            break;
        }
        double discounted_price = double_price - (double_price * discount / 100);
        discounted_price_string = String.valueOf(discounted_price);
        location = getTheaterLocation(theater_name, location);
        System.out.println("Would you like to \n1. Purchase this\n2. No\n(1, 2)");
        String response = sc.nextLine();
        switch (response) {
          case "1":
            System.out.println("Thank you for your purchase!");
            Tickets ticket = Tickets.getInstance();
            ticket.addTicket(email, type, movie_name, theater_name, location, seat, discounted_price_string, showTime);
            addToTicketFile(movie_name, theater_name, location, showTime, seat, discounted_price_string);
            details = ("\nName: " + movie_name + "\nTheater Name: " + theater_name + "\nTheater Location: " + location +
              "\nShow Time: " + showTime + "\nSeat Number: " + seat + "\nPrice: " + discounted_price_string + "\n");
            ticketArray[i] = details;
            break;
          case "2":
            break;
        }
      } else {
        System.out.println("Either the Theater or Movie does not exist, Please try again");
        break;
      }
    }
    String response = input("Would you like to view your Purchased Tickets? (Y or N)");
    switch (response.toLowerCase()) {
      case "y":
        int k = 0;
        for (int i = 0; i < num; i++) {
          k = i + 1;
          System.out.println("\nTicket Number " + k + ":" + ticketArray[i]);
        }
      case "n":
        break;
    }
  } else {
      System.out.println("No Show Time found\nPlease try again");
      purchaseTicket(email, status, type);
    }
  }

  /**
   * lets the user add a review for either an event or a theater
   * @param user_email
   */
  public void addReview(String user_email) {
    Review review = new Review();
    boolean loop = true;
    while (loop) {
      String type = "";
      String response = input("Would you like to add a review? (Y or N)");
      switch (response.toLowerCase()) {
        case "y":
          String review_response = input("Would you like to add:\n1. Movie Review\n2. Play Review\n3. Theater Review");
          switch (review_response) {
            case "1":
              type = "Movie";
              break;
            case "2":
              type = "Play";
              break;
            case "3":
              type = "Theater";
              break;
          }
          String name = input("Enter the Name of the " + type + " you would like to review: " );
          String description = input(type + " Review: ");
          String rating = input(type + " Rating: ");

          if (type.equalsIgnoreCase("Movie")) {
            review.addReviewMovie(user_email, type, name, description, rating);
          }
          else if (type.equalsIgnoreCase("Play")) {
            review.addReviewPlay(user_email, type, name, description, rating);
          }
          else if (type.equalsIgnoreCase("Theater")) {
            review.addReviewTheater(user_email, type, name, description, rating);
          }

          String view = input("Would you wish to see the reviews? (Y or N)");
          switch (view.toLowerCase()) {
            case "y":
              System.out.println("\n" + type + " Name: " + name + "\n" + "Review: " + description + "\n" + type + " Rating: " + rating);
              //displayReviews(user_email);
              break;
            case "n":
              break;
          }
          break;
        case "n":
          System.out.println("Going back to previous menu options...\n");
          loop = false;
          break;
      }
    }
  }

  public void displayReviews(String email) {
    String response = input("Would you like to view\n1. Movie reviews\n2. Play reviews\n3. Theater reviews\n4. All reviews\n(1, 2, 3, 4)\n");
    String type = "";
    int len = 0, check = 0;
    switch (response) {
      case "1":
        type = "Movie";
        len = getNumReviewsType(email, type, len);
        break;
      case "2":
        type = "Play";
        len = getNumReviewsType(email, type, len);
        break;
      case "3":
        type = "Theater";
        len = getNumReviewsType(email, type, len);
        break;
      case "4":
        check = 1;
        break;
    }
    if (check == 1) {
      len = getNumReviewsAll(email, len);
      String[] reviewArray = new String[len];
      displayReviewsAllJSON(email, reviewArray);
      for (int i = 0; i < len; i++) {
        System.out.println(reviewArray[i]);
      }
    } else {
      String[] reviewArray = new String[len];
      displayReviewsTypeJSON(email, type, reviewArray);
      for (int i = 0; i < len; i++) {
        System.out.println(reviewArray[i]);
      }
    }

  }

  /**
   * Method for user's account settings
   * @param email
   */
  public void accountSettings(String email, String status) {
    boolean loop = true;
    while (loop) {
      System.out.println("Account Settings: \n1. View User information\n2. Update User Information\n3. Go Back\n(1, 2, 3)");
      String input = sc.nextLine();
      switch (input) {
        case "1":
          loadSpecificUser(email);
          break;
        case "2":
          updateUserInfo(email, status);
        case "3":
          SignIn signin = new SignIn();
          //driver.homeScreen();
          signin.userSignInOptions(email, status);
          loop = false;
          break;
      }
    }
  }

  /**
   * Method to remove either a theater or an event from its respective json file
   * @param type
   */
  public void removeStuff(String type) {
    boolean loop = true;
    while (loop) {
      String test = "";
      String name = input("Enter the Name of the " + type + " you would like to remove: \n");
      test = loadSpecificStuff(name, test, type);
      if (test.equalsIgnoreCase(name)) {
        switch (type.toLowerCase()) {
          case "theater":
            Theaters theaters = Theaters.getInstance();
            ArrayList<SingleTheater> theaterList = new ArrayList<SingleTheater>();
            theaterList = theaters.getRemovedTheaters();
            theaters.removeTheater(name, theaterList);
            theaterList.clear();
            ShowTimes show1 = ShowTimes.getInstance();
            ArrayList<SingleShowTime> showTimeList1 = new ArrayList<SingleShowTime>();
            showTimeList1 = show1.getShowTimesRemoved();
            show1.removeShowTime(name, showTimeList1);
            showTimeList1.clear();
            String response = input("Would you like to: \n1. Remove another Theater\n2. Go Back\n (1,2)");
            switch (response) {
              case "1":
                break;
              case "2":
                System.out.println("Going Back...\n");
                loop = false;
                break;
            }
            break;
          case "event":
            Events events = Events.getInstance();
            ArrayList<SingleEvent> eventList = new ArrayList<SingleEvent>();
            eventList = events.getRemovedEvents();
            events.removeEvent(name, eventList);
            eventList.clear();
            ShowTimes show = ShowTimes.getInstance();
            ArrayList<SingleShowTime> showTimeList = new ArrayList<SingleShowTime>();
            showTimeList = show.getShowTimesRemoved();
            show.removeShowTime(name, showTimeList);
            showTimeList.clear();
            String response1 = input("Would you like to: \n1. Remove another Theater\n2. Go Back\n (1,2)");
            switch (response1) {
              case "1":
                break;
              case "2":
                System.out.println("Going Back...\n");
                loop = false;
                break;
            }
            break;
        }
      } else {
        System.out.println(type + " does not exist");
      }

    }
  }
}
