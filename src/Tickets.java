/*Written by Talin Arya, Copyright 2020*/
import java.util.ArrayList;

public class Tickets {
  private static Tickets tickets = null;
  private static ArrayList<SingleTicket> ticketList = new ArrayList<SingleTicket>();

  /* loads tickets information into the array from the json files */
  public Tickets() {
    ticketList = DataLoader.loadTicket();
  }

  /* creates a new object if not present to prevent a new user from being created */
  public static Tickets getInstance() {
    if(tickets == null) {
      tickets = new Tickets();
    }

    return tickets;
  }

  /* returns the list of tickets */
  public ArrayList<SingleTicket> getTicket() {
    return ticketList;
  }

  /* adds ticket to the array through the json input and calls in saveTicket
   from DataWriter class  */
  public void addTicket(String email, String type, String movieName, String theaterName, String theaterLocation, String seat, String price, String showTime) {
    ticketList.add(new SingleTicket(email, type, movieName, theaterName, theaterLocation, seat, price, showTime));
    DataWriter.saveTicket();
  }
}
