/*Written by Talin Arya, Copyright 2020*/
import java.util.ArrayList;

public class ShowTimes {
  private static ShowTimes showTimes = null;
  private static ArrayList<SingleShowTime> showMovieList = new ArrayList<SingleShowTime>();
  private static ArrayList<SingleShowTime> showPlayList = new ArrayList<SingleShowTime>();
  private static ArrayList<SingleShowTime> showTime = new ArrayList<SingleShowTime>();
  private static ArrayList<SingleShowTime> showTime1 = new ArrayList<SingleShowTime>();

  /*constructor, loads data from json file to the array lists */
  public ShowTimes() {
    showMovieList = DataLoader.loadShowTimesMovies();
    showPlayList = DataLoader.loadShowTimesPlays();
  }

  /* creates a new object if not present to prevent creating a new user when not necesssary */
  public static ShowTimes getInstance() {
    if(showTimes == null) {
      showTimes = new ShowTimes();
    }

    return showTimes;
  }

  /* returns the the list of showTimes of movies */
  public ArrayList<SingleShowTime> getShowTimesMovies() {
    return showMovieList;
  }

  /* returns the list of ShowTimes of plays that are playing */
  public ArrayList<SingleShowTime> getShowTimesPlays() {
    return showPlayList;
  }

  /* populates the showtime lists by adding showmMovielist and showPlayList */
  public ArrayList<SingleShowTime> getShowTimes() {
    showTime.addAll(showMovieList);
    showTime.addAll(showPlayList);
    return showTime;
  }

  /* returns an empty array list */
  public ArrayList<SingleShowTime> getShowTimesRemoved() {
    return showTime1;
  }

  /* adds showTimes to the showMovieList through the json input and calls in save ShowTims
   from DataWriter class */
  public void addShowTimeMovie(String name, String showtime, String theater, String type) {
    showMovieList.add(new SingleShowTime(name, showtime, theater, type));
    DataWriter.saveShowTimes();
  }

  /* adds plays to the showplayList through the json input and calls in save ShowTims
     from DataWriter class  */
  public void addShowTimePlay(String name, String showTime, String theater, String type) {
    showPlayList.add(new SingleShowTime(name, showTime, theater, type));
    DataWriter.saveShowTimes();
  }

  /* calls in removeshowTime and saveremovedShowtime from DataRemover class */
  public void removeShowTime(String name, ArrayList<SingleShowTime> list) {
    DataRemover.removeShowTime(name, list);
    DataRemover.saveRemovedShowTimes(list);
  }

}
