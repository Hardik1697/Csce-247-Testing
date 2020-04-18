/**
 * @author Hardik
 */

import java.util.ArrayList;

public class Users {
  private static Users users = null;
  private static ArrayList<SingleUser> userList = new ArrayList<SingleUser>();
  private static ArrayList<SingleUser> userList1 = new ArrayList<SingleUser>();

  /**
   * Loads users info lists into the array from json files.
   */
  public Users() {
    userList = DataLoader.loadUser();
  }

  /**
   * Method to create a new object if not present to prevent creating a new user
   * when not necessary
   *
   * @return user instance
   */
  public static Users getInstance() {
    if(users == null) {
      users = new Users();
    }

    return users;
  }

  /**
   * @return the list of users
   */
  public ArrayList<SingleUser> getUsers() {
    return userList;
  }

  /**
   * returns a list, on which DataLoader.loadPeeople has not been called.
   * @return
   */
  public ArrayList<SingleUser> getUsersUpdated() {
    return userList1;
  }

  /**
   * Adds users to the array list through json All of them are saved as a String
   * @param firstName
   * @param lastName
   * @param phoneNumber
   * @param age
   * @param status
   * @param email
   * @param password
   * @param type
   */
  public void addUser(String firstName, String lastName, String phoneNumber, String age, String status, String email, String password, String type) {
    userList.add(new SingleUser(firstName, lastName, phoneNumber, age, status, email, password, type));
    DataWriter.saveUsers();
  }

  /**
   * Method to update a specific user's details, by calling in the updateUser and saveUser mtehod from the DataUpdater class.
   * @param email
   * @param input
   * @param replace
   * @param list
   */
  public void updateUser(String email, String input, String replace, ArrayList<SingleUser> list) {
    DataUpdater.updateUser(email, input, replace, list);
    DataUpdater.saveUpdatedUser(list);
  }
}
