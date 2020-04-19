import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestReview {

	Review review;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		review = new Review();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	
	}

	@Test
	public void testInstance() {
		Review review1 = new Review();
		review1 = review.getInstance();
		assertEquals(review.getClass(),review1.getClass());
	}
	
	@Test
	public void testGetReviewMovie() {
		ArrayList<SingleReview> t1 = review.getReviewMovie();
		assertEquals(t1, review.getReviewMovie());
	}
	
	@Test
	public void testGetReviewPlay() {
		ArrayList<SingleReview> t1 = review.getReviewPlay();
		assertEquals(t1, review.getReviewPlay());
	}
	
	@Test
	public void testGetReviewTheater() {
		ArrayList<SingleReview> t1 = review.getReviewTheater();
		assertEquals(t1, review.getReviewTheater());
	}
	
	@Test
	public void testGetReviews() {
		ArrayList<SingleReview> t1 = review.getReviews();
		assertEquals(t1, review.getReviews());
	}
}
