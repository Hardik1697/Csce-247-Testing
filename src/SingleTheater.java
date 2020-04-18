/*Written by Talin Arya, Copyright 2020*/
public class SingleTheater {
  public String name, id, address, price;

  /* constructors for this class */
  public SingleTheater(String name, String id, String address, String price) {
    this.name = name;
    this.id = id;
    this.address = address;
    this.price = price;
  }

  /**
   * getters
   */
  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public String getAddress() {
    return address;
  }

  public String getPrice() {
    return price;
  }

  /**
   * Setters
   */
  public void setName(String name) {
    this.name = name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
