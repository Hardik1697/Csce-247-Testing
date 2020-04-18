/*Written by Talin Arya, Copyright 2020*/
public class SingleShowTime {
  public String name, type, theater, showTime;

  /* constructor for this class which takes in string variables as is paramter and sets it to the variable defined in the class */
  public SingleShowTime(String name, String showTime, String theater, String type) {
    this.name = name;
    this.type = type;
    this.theater = theater;
    this.showTime = showTime;
  }

  /**
   * getters
   */
  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getTheater() {
    return theater;
  }

  public String getShowTime() {
    return showTime;
  }


  /**
   * Setters
   */
  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setTheater(String theater) {
    this.theater = theater;
  }

  public void setShowTime(String showTime) {
    this.showTime = showTime;
  }

}
