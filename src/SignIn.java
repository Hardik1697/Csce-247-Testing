/**
 * @author Prathamjeet
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
public class SignIn extends DataLoader {
  private Scanner k = new Scanner(System.in);
  Helper helper = Helper.getInstance();
  public static String signed_in_user_email = "", signed_in_status = "";;
  private static SignIn signInClass = null;
  public boolean mainLoop = false;

  /**
   * Method to create a new object if not present to prevent creating a new user
   * when not necessary
   *
   * @return
   */
  public static SignIn getInstance() {
    if(signInClass == null) {
      signInClass = new SignIn();
    }

    return signInClass;
  }

  /**
   * Helper method to get response from user
   * @param prompt
   * @return
   */
  public String input(String prompt) {
    System.out.print(prompt);
    return k.nextLine();
  }

  /**
   * Creates User Account
   */
  public void createUser() {
    boolean loop = true;
    while (loop) {
      String firstName = input("Enter your First Name: ");
      String lastName = input("Enter your Last Name: ");
      String phoneNumber = input("Enter your Phone Number: ");
      String age = input("Enter your Age: ");
      String status = input("Enter your Status (Student, Military, etc. or Enter None): ");
      String email = input("Enter your Email ID: ");
      String password = input("Enter your Password: ");
      String password1 = input("Re-enter your Password: ");
      String choice = input("Do you wish to\n1. Confirm\n2. Re-do\n3. Cancel\n(1, 2, 3)");
      switch (choice) {
        case "1":
          if (loadEmailForSignUp(email)) {
            if (password.equals(password1)) {
              Users user = Users.getInstance();
              user.addUser(firstName, lastName, phoneNumber, age, status.toLowerCase(), email, password, "user");
              System.out.println("Successful!, Re-Directing to Sign in Page");
              loop = false;
            }
          } else {
            System.out.println("Email already exists, please try again!");
          }
          break;
        case "2":
          break;
        case "3":
          loop = false;
          break;
      }
    }
  }

  /**
   * Logins as a guest by creating a new user with random numbers generated
   */
  public void signInAsGuest() {
    boolean loop = true;
    while (loop) {
      System.out.println("Assigning Random Account Details");
      Random rand = new Random();
      int fName = rand.nextInt(10000);
      int lName = rand.nextInt(10000);
      int phone = rand.nextInt(10000);
      int ageInt = rand.nextInt(10000);
      int emailInt = rand.nextInt(10000);
      int passInt = rand.nextInt(10000);

      String firstName = String.valueOf(fName);
      String lastName = String.valueOf(lName);
      String phoneNumber = String.valueOf(phone);
      String age = String.valueOf(ageInt);
      String status = "none";
      String email = String.valueOf(emailInt);
      String password = String.valueOf(passInt);
      String choice = input("Do you wish to\n1. Confirm\n2. Re-do\n3. Cancel\n(1, 2, 3)");
      switch (choice) {
        case "1":
          Users user = Users.getInstance();
          user.addUser(firstName, lastName, phoneNumber, age, status, email, password, "guest");
          System.out.println("Your Guest Email ID is: " + email + "\nYour Guest Password is: " + password + "\n" +
            "You can use this account in the Future!\n");
          guestSignIn(email, "none");
          loop = false;
          break;
        case "2":
          break;
        case "3":
          loop = false;
          break;
      }
    }
  }

  /**
   * Helper method for guest sign in
   * @param email
   */
  public void guestSignIn(String email, String status) {
    boolean loop = true;
    while (loop) {
      System.out.println("Enter one of the following options: \n1. Look for Movies\n2. Look for Theaters\n3. Look for Plays\n" +
        "4. Purchase a Movie Ticket\n5. Purchase a Play Ticket\n6. Leave a Review\n7. Account Settings\n" +
        "8. Sign Out\n (1, 2, 3, 4, 5, 6, 7, 8)");
      String input = k.nextLine();
      switch (input) {
        case "1":
          helper.displayEvents("Movie");
          break;
        case "2":
          helper.displayTheaters();
          break;
        case "3":
          helper.displayEvents("Play");
          break;
        case "4":
          helper.purchaseTicket(email, "none", "Movie");
          break;
        case "5":
          helper.purchaseTicket(email, "none", "Play");
          break;
        case "6":
          helper.addReview(email);
          break;
        case "7":
          helper.accountSettings(email, status);
          break;
        case "8":
          signed_in_user_email = "";
          mainLoop = false;
          loop = false;
          break;
      }
    }

  }

  /**
   * Method used to sign in the users
   */
  public void signInUser(String type) {
    mainLoop = true;
    while (mainLoop) {
      String email = input("\nEmail: ");
      String password = input("Password: ");
      String[] user_details = new String[3];
      user_details = validateSignInUser(email, password, type, user_details);
      if (user_details[0].equals(email) && user_details[1].equals(password)) {
        System.out.println("\nSign in validated\nWelcome " + user_details[2] + "!");
        signed_in_user_email = email;
        signed_in_status = getUserStatus(email, signed_in_status);
        String status = signed_in_status;
        switch (type.toLowerCase()) {
          case "user":
            userSignInOptions(email, status);
            break;
          case "admin":
            adminSignInOptions(email);
            break;
        }
      }
       else if (!user_details[0].equals(email) && !user_details[1].equals(password)) {
          break;
      } else {
        System.out.println("System error, please restart program");
      }
    }
  }

  /**
   * This method returns a boolean value by taking in 2 params.
   * This is to validate the user's sign in.
   * @param1 email
   * @param2 password
   * @return
   */
  public String[] validateSignInUser(String email, String password, String type, String[] string_array) {
    try {
      FileReader reader = new FileReader(USER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < userJSON.size(); i++) {
        JSONObject user_JSON = (JSONObject)userJSON.get(i);
        String validate_email = user_JSON.get(USER_EMAIL).toString();
        String validate_password = user_JSON.get(USER_PASSWORD).toString();
        String validate_name = user_JSON.get(USER_FIRST_NAME).toString();
        if (validate_email.equals(email) && validate_password.equals(password)) {
          string_array[0] = validate_email;
          string_array[1] = validate_password;
          string_array[2] = validate_name;
          return string_array;
        }
      }
      System.out.println("Sign in Failed, please try again");
      signInUser(type);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return string_array;
  }

  /**
   * Shows options for the user to use to navigate through the application
   */
  public void userSignInOptions(String email, String status) {
    boolean loop = true;
    while (loop) {
      System.out.println("\nEnter one of the following options: \n1. Look for Movies\n2. Look for Theaters\n3. Look for Plays\n" +
              "4. Purchase a Movie Ticket\n5. Purchase a Play Ticket\n6. Leave a Review\n7. Display Reviews\n8. Account Settings\n" +
              "9. Sign Out\n (1, 2, 3, 4, 5, 6, 7, 8, 9)");
      String input = k.nextLine();
      switch (input) {
        case "1":
          helper.displayEvents("Movie");
          break;
        case "2":
          helper.displayTheaters();
          break;
        case "3":
          helper.displayEvents("Play");
          break;
        case "4":
          helper.purchaseTicket(email, status, "Movie");
          break;
        case "5":
          helper.purchaseTicket(email, status, "Play");
          break;
        case "6":
          helper.addReview(email);
          break;
        case "7":
          helper.displayReviews(email);
          break;
        case "8":
          helper.accountSettings(email, status);
          break;
        case "9":
          Driver.homeScreen();
      }
    }
  }

  /**
   * Shows options for the administrator to use to navigate through the application
   * and make changes.
   */
  public void adminSignInOptions(String email) {
    boolean loop = true;
    while (loop) {
      System.out.println("Enter one of the following options: \n1. Add a Movie\n2. Add a Play \n3. Add a  Movie Theater" +
              "\n4. Add a Play House\n5. View Users\n6. Remove a Movie\n7. Remove a Theater\n8. Remove a Play" +
              "\n9. Sign out\n");
      String input = k.nextLine();
      switch (input) {
        case "1":
          helper.addSingleEvent("Movie");
          break;
        case "2":
          helper.addSingleEvent("Play");
          break;
        case "3":
          helper.addSingleTheater("Movie");
          break;
        case "4":
          helper.addSingleTheater("Play");
          break;
        case "5":
          String viewUsers = input("Do you want to view:\n1. A Specific User\n2. All Users");
          switch (viewUsers) {
            case "1":
              loadSpecificUser();
              break;
            case "2":
              helper.displayUsers();
              break;
          }
          break;
        case "6":
          helper.removeStuff("event");
          break;
        case "7":
          helper.removeStuff("theater");
          break;
        case "8":
          helper.removeStuff("event");
          break;
        case "9":
          mainLoop = false;
          loop = false;
          break;
      }
    }
  }
}
