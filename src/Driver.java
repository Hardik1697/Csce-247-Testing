/**
 * @author Hardik
 */
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

  private static Scanner scanner;
  private static String enter = "Enter one of the following options: \n";
  static SignIn signInClass = SignIn.getInstance();
  public static String user_email_for_signIn = "";

  /**
   * Constructor, which initializes the Scanner variable
   */
  public Driver() {
    scanner = new Scanner(System.in);
  }

  private static String input(String prompt) {
    System.out.print(prompt + ": ");
    return scanner.nextLine();
  }

  /**
   * Initial Screen
   */
  public static void homeScreen() {
    boolean mainLoop = true;
    while (mainLoop) {
      signInClass.mainLoop = true;
      user_email_for_signIn = "";
      System.out.println("********************Welcome to FilmBooker********************");
      String choice = input(enter + "1. Create Account\n2. Sign in\n3. Sign in as a Guest\n4. Quit");
      switch (choice) {
        case "1":
          signInClass.createUser();
        case "2":
          String signIn = input("\nSign in as a:\n1. User\n2. Administrator\n3. Go Back\n (1, 2, 3)");
          switch (signIn) {
            case "1":
              signInClass.signInUser("user");
              break;
            case "2":
              signInClass.signInUser("admin");
              break;
            case "3":
              break;
          }
          break;
        case "3":
          signInClass.signInAsGuest();
          break;
        case "4":
          System.exit(0);
          break;
      }
    }
  }

  /**
   * main method
   * @param args
   */
  public static void main(String[] args) {

    Driver driver = new Driver();
    driver.homeScreen();
  }
}
