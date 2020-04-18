/**
 * @author Prathamjeet
 */
public class SingleReview {
  public String email, type, name, description, rating;

  /**
   * Constructor for the SingleReview class
   * @param email
   * @param type
   * @param name
   * @param description
   * @param rating
   */
  public SingleReview(String email, String type, String name, String description, String rating) {
    this.email = email;
    this.type = type;
    this.name = name;
    this.description = description;
    this.rating = rating;
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

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getRating() {
    return rating;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }
}
