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


public class DataRemover extends DataLoader{

  /**
   * This method is used to add all theaters to the arraylist of type SingleTheater,
   * except the one specified by param1
   * @param1 input
   * @param2 list
   * @return
   */
  public static ArrayList<SingleTheater> removeTheater(String input, ArrayList<SingleTheater> list) {
    try {
      FileReader reader = new FileReader(THEATER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < peopleJSON.size(); i++) {
        JSONObject personJSON = (JSONObject)peopleJSON.get(i);
        String name = (String)personJSON.get(THEATER_NAME);
        String id = (String)personJSON.get(THEATER_ID);
        String address = (String)personJSON.get(THEATER_ADDRESS);
        String price = (String)personJSON.get(THEATER_PRICE);
        if (!input.equalsIgnoreCase(name)) {
          list.add(new SingleTheater(name, id, address, price));
        }
      }

      return list;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  /**
   * This method flushes data into the theater json file.
   * @param list
   */
  public static void saveRemovedTheaters(ArrayList<SingleTheater> list) {
    JSONArray jsonTheater = new JSONArray();

    //creating all the json objects
    for(int i=0; i< list.size(); i++) {
      jsonTheater.add(putTheatersJSON(list.get(i)));
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
   * This method is used to add all event to the arraylist of type SingleEvent,
   * except the one specified by param1
   * @param1 input
   * @param2 list
   * @return
   */
  public static ArrayList<SingleEvent> removeEvent(String input, ArrayList<SingleEvent> list) {
    try {
      FileReader reader = new FileReader(EVENTS_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray eventJSON = (JSONArray)new JSONParser().parse(reader);

          for(int i=0; i < eventJSON.size(); i++) {
            JSONObject event_JSON = (JSONObject)eventJSON.get(i);
            String name = (String)event_JSON.get(EVENTS_NAME);
            String id = (String)event_JSON.get(EVENTS_ID);
            String rating = (String)event_JSON.get(EVENTS_RATING);
            String genre = (String)event_JSON.get(EVENTS_GENRE);
            String description = (String)event_JSON.get(EVENTS_DESCRIPTION);
            String runtime = (String)event_JSON.get(EVENTS_RUNTIME);
            String type1 = (String)event_JSON.get(EVENTS_TYPE);

            if (!input.equalsIgnoreCase(name)) {
              list.add(new SingleEvent(name, type1, id, genre, rating, description, runtime));
            }
          }

         // return list;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  /**
   * This method flushes data into the events json file.
   * @param list
   */
  public static void saveRemovedEvents(ArrayList<SingleEvent> list) {
    JSONArray jsonEvent = new JSONArray();

    //creating all the json objects
    for(int i=0; i< list.size(); i++) {
      jsonEvent.add(putEventJSON(list.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(EVENTS_FILE_NAME)) {

      file.write(jsonEvent.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method is used to add all showtimes to the arraylist of type SingleShowTime,
   * except the one specified by param1
   * @param1 input
   * @param2 list
   * @return
   */
  public static ArrayList<SingleShowTime> removeShowTime(String input, ArrayList<SingleShowTime> list) {
    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray showJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i=0; i < showJSON.size(); i++) {
        JSONObject show_JSON = (JSONObject)showJSON.get(i);
        String movie = (String)show_JSON.get(SHOWTIME_MOVIE_NAME);
        String theater = (String)show_JSON.get(SHOWTIME_THEATER_NAME);
        String type1 = (String)show_JSON.get(SHOWTIME_TYPE);
        String time = (String)show_JSON.get(SHOWTIME_TIME);

        if (!input.equalsIgnoreCase(movie)) {
          list.add(new SingleShowTime(movie, time, theater, type1));
        }
      }

      return list;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  /**
   * This method flushes data into the showtimes json file.
   * @param list
   */
  public static void saveRemovedShowTimes(ArrayList<SingleShowTime> list) {
    JSONArray jsonShow = new JSONArray();

    //creating all the json objects
    for(int i=0; i< list.size(); i++) {
      jsonShow.add(putShowTimesJSON(list.get(i)));
    }

    //Write JSON file
    try (FileWriter file = new FileWriter(SHOWTIME_FILE_NAME)) {

      file.write(jsonShow.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
