/**
 * @author Prathamjeet
 */
public class SingleEvent {
  public String name, type, id, genre, rating, description, runtime;

  /**
   * Constructor for singleEvent class
   *
   * @param name        - name of event
   * @param id          - id of event
   * @param genre       - type of event
   * @param rating      - rating of the event
   * @param description - description of the event
   * @param runtime     - showtimes of the event
   */
  public SingleEvent(String name, String type, String id, String genre, String rating, String description, String runtime) {
    this.name = name;
    this.type = type;
    this.id = id;
    this.genre = genre;
    this.rating = rating;
    this.description = description;
    this.runtime = runtime;
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

  public String getId() {
    return id;
  }

  public String getGenre() {
    return genre;
  }

  public String getRating() {
    return rating;
  }

  public String getDescription() { return description; }

  public String getRuntime() { return runtime; }


  /**
   * Setters
   */
  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRuntime(String runtime) { this.runtime = runtime; }

}
