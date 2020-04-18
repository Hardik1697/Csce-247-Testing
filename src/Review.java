/*Written by Talin Arya, Copyright 2020*/
import java.util.ArrayList;

public class Review {
  private static Review review = null;
  private static ArrayList<SingleReview> reviewListMovie = new ArrayList<SingleReview>();
  private static ArrayList<SingleReview> reviewListPlay = new ArrayList<SingleReview>();
  private static ArrayList<SingleReview> reviewListTheater = new ArrayList<SingleReview>();
  private static ArrayList<SingleReview> reviewList = new ArrayList<SingleReview>();

  /** contructor, loads data from json file to the array lists **/

  public Review() {
    reviewListMovie = DataLoader.loadReviewMovie();
    reviewListPlay = DataLoader.loadReviewPlay();
    reviewListTheater = DataLoader.loadReviewTheater();
  }

  /** creates a new object if not present to prevent
   * creating a new user when not needed
   **/
  public static Review getInstance() {
    if(review == null) {
      review = new Review();
    }

    return review;
  }
  /** returns the list of movie reviews **/
  public ArrayList<SingleReview> getReviewMovie() {
    return reviewListMovie;
  }

  /** returns the list of review  of plays **/
  public ArrayList<SingleReview> getReviewPlay() {
    return reviewListPlay;
  }

  /** returns the list of reviews for a theater **/
  public ArrayList<SingleReview> getReviewTheater() {
    return reviewListTheater;
  }

  /**populates the Review lists by adding reviewListMovie, reviewListPlay and reviewListTheater **/
  public ArrayList<SingleReview> getReviews() {
    reviewList.addAll(reviewListMovie);
    reviewList.addAll(reviewListPlay);
    reviewList.addAll(reviewListTheater);
    return reviewList;
  }

  /* adds reviews to the array list through the json file and calls in saveReview
  from DataWriter class  */
  public void addReviewMovie(String email, String type, String name, String description, String rating) {
    reviewListMovie.add(new SingleReview(email, type, name, description, rating));
    DataWriter.saveReview();
  }
  /* adds plays to the array list through the json input and calls in saveReview
  from DataWriter class  */
  public void addReviewPlay(String email, String type, String name, String description, String rating) {
    reviewListPlay.add(new SingleReview(email, type, name, description, rating));
    DataWriter.saveReview();
  }
  /* adds theaters to the array list through the json input and calls in saveReview
  from DataWriter class  */
  public void addReviewTheater(String email, String type, String name, String description, String rating) {
    reviewListTheater.add(new SingleReview(email, type, name, description, rating));
    DataWriter.saveReview();
  }
}
