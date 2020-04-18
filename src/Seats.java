/**
 * @author Prathamjeet
 */
public class Seats {

  private String[][] seatName;
  private int max = 10;
  private int maxY = 4;
  private boolean[][] taken;
  public String allSeats = "";
  private int column = 0;
  private String[][] secondSeatName;

  /**
   * Constructor
   * @param n
   */
  protected Seats(int n) {
    column = n;
    seatName = new String[maxY][n];
    taken = new boolean[maxY][n];
    if (n > max)
      n = 9;
    String s = "A";
    for (int i = 0; i < maxY; i++) {
      seatInitializer(n, s, i);
      if (s == "A")
        s = "B";
      else if (s == "B")
        s = "C";
      else if (s == "C")
        s = "D";
    }
  }

  /**
   * Initializes seats in a 2d array
   * @param n
   * @param string
   * @param row
   */
  private void seatInitializer(int n, String string, int row) {
    for (int i = 0; i < n; i++) {
      String name = string + i;
      seatName[row][i] = name;
      taken[row][i] = false;
    }
  }

  /**
   * prints out the seats
   */
  public void printSeats() {
    System.out.println();
    for (int i = 0; i < seatName.length; i++) {
      for (int j = 0; j < seatName[i].length; j++) {
        if (taken[i][j] == false)
          System.out.print(seatName[i][j] + " ");
        else
          System.out.print("XX ");
      }
      System.out.println();
    }
  }

  /**
   * replaces seat with XX, if a seat has been selected by the user
   * @param i
   * @param j
   */
  private void takeSeat(int i, int j) {
    taken[i][j] = true;
    seatName[i][j] = "XX";
  }

  /**
   * Determines which seat has to be replaced by an XX
   * @param s
   */
  public void takeSeat(String s) {
    for (int i = 0; i < seatName.length; i++) {
      for (int j = 0; j < seatName[i].length; j++) {
        if (seatName[i][j].equals(s)) {
          takeSeat(i, j);
          return;
        }
      }
    }
  }
}
