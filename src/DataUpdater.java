/**
 * @author Hardik
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataUpdater extends DataLoader {

  /**
   * This method is used to update user info, by adding everything to the arraylist of type SingleUser. It modifies the data
   * according to param1, by switching the respctive field using param3
   * @param1 email_user
   * @param2 input
   * @param3 replace
   * @param4 list
   * @return
   */
  public static ArrayList<SingleUser> updateUser(String email_user, String input, String replace, ArrayList<SingleUser> list) {
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
        String type = (String)user_JSON.get(USER_TYPE);
        String email = (String)user_JSON.get(USER_EMAIL);
        String password = (String)user_JSON.get(USER_PASSWORD);
        if (email.equals(email_user)) {
          if (replace.equals("first")) {
            list.add(new SingleUser(input, lastName, phoneNumber, age, status, email, password, type));
          }
          else if (replace.equals("last")) {
            list.add(new SingleUser(firstName, input, phoneNumber, age, status, email, password, type));
          }
          else if (replace.equals("status")) {
            list.add(new SingleUser(firstName, lastName, phoneNumber, age, input, email, password, type));
          }
          else if (replace.equals("phone")) {
            list.add(new SingleUser(firstName, lastName, input, age, status, email, password, type));
          }
          else if (replace.equals("pass")) {
            list.add(new SingleUser(firstName, lastName, phoneNumber, age, status, email, input, type));
          } else {
            list.add(new SingleUser(firstName, lastName, phoneNumber, age, status, email, password, type));
          }
        } else {
            list.add(new SingleUser(firstName, lastName, phoneNumber, age, status, email, password, type));
        }
      }

      return list;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  /**
   * This method flushes data into the user json file.
   * @param list
   */
  public static void saveUpdatedUser(ArrayList<SingleUser> list) {
    JSONArray jsonFriends = new JSONArray();

    //creating all the json objects
    for(int i=0; i< list.size(); i++) {
      jsonFriends.add(putUsersJSON(list.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(USER_FILE_NAME)) {

      file.write(jsonFriends.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
