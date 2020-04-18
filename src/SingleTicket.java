/*Written by Talin Arya, Copyright 2020*/
public class SingleTicket {
  public String email, type, movieName, theaterName, theaterLocation, seat, price, showTime;

  /* constructor for this class which takes in string variables as is paramter and sets it to the variable defined in the class */
  public SingleTicket(String email, String type, String movieName, String theaterName, String theaterLocation, String seat, String price, String showTime) {
    this.email = email;
    this.type = type;
    this.movieName = movieName;
    this.theaterName = theaterName;
    this.theaterLocation = theaterLocation;
    this.seat = seat;
    this.price = price;
    this.showTime = showTime;
  }

  /**
   * getters
   */
  public String getEmail() {
    return email;
  }

  public String getType() {
    return type;
  }

  public String getMovieName() {
    return movieName;
  }

  public String getTheaterName() {
    return theaterName;
  }

  public String getTheaterLocation() {
    return theaterLocation;
  }

  public String getSeat() {
    return seat;
  }

  public String getPrice() {
    return price;
  }

  public String getShowTime() {
    return showTime;
  }

  /**
   * Setters
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public void setTheaterName(String theaterName) {
    this.theaterName = theaterName;
  }

  public void setTheaterLocation(String theaterLocation) {
    this.theaterLocation = theaterLocation;
  }

  public void setSeat(String seat) {
    this.seat = seat;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public void setShowTime(String showTime) {
    this.showTime = showTime;
  }
}
