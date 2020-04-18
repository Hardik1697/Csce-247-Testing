/*Written by Talin Arya, Copyright 2020*/
import java.util.ArrayList;

public class Theaters {
  private static Theaters theaters = null;
  private static ArrayList<SingleTheater> theaterList = new ArrayList<SingleTheater>();
  private static ArrayList<SingleTheater> theaterList1 = new ArrayList<SingleTheater>();

  /*loads Theaters information into the array from the json file */
  public Theaters() {
    theaterList = DataLoader.loadTheater();
  }

  /* creates a new object if not present to prevent creating a new user when not necessary */
  public static Theaters getInstance() {
    if(theaters == null) {
      theaters = new Theaters();
    }
    return theaters;
  }

  /* returns the list of theaters */
  public ArrayList<SingleTheater> getTheaters() {
    return theaterList;
  }

  /* returns the list of removed theaters */
  public ArrayList<SingleTheater> getRemovedTheaters() {
    return theaterList1;
  }

  /* adds theater to the array list through the json input and calls in saveTheater
   from DataWriter class */
  public void addTheater(String name, String id, String address, String price) {
    theaterList.add(new SingleTheater(name, id, address, price));
    DataWriter.saveTheaters();
  }

  /**Removes a specific theater from the array list, created through the json file, and adds the rest of the theaters, to be
   * uploaded to the json file theater
   * @param name
   * @param list
   */
  public void removeTheater(String name, ArrayList<SingleTheater> list) {
    DataRemover.removeTheater(name, list);
    DataRemover.saveRemovedTheaters(list);
  }
}
