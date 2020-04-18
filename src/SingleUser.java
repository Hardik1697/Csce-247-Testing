/**
 * @author Prathamjeet
 */
public class SingleUser {
  public String firstName, lastName, phoneNumber, age, status, email, password, type;

  /**
   * Constructor for the user class
   * @param firstName first name of the user
   * @param lastName last name of the user
   * @param phoneNumber contact of user
   * @param age age to verify of user
   * @param status status of user either adult or minor
   * @param email contact of user
   * @param password password of the user's account
   */
  public SingleUser(String firstName, String lastName, String phoneNumber, String age, String status, String email, String password, String type) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.age = age;
    this.status = status;
    this.email = email;
    this.password = password;
    this.type = type;
  }

  /**
   * getters
   */
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAge() {
    return age;
  }

  public String getStatus() {
    return status;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getType() {
    return type;
  }

  /**
   * Setters
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastNameName) {
    this.lastName = lastNameName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setType(String type) {
    this.type = type;
  }
}
