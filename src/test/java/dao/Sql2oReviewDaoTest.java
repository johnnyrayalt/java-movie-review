package dao;

import models.Movie;
import models.Review;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;
public class Sql2oReviewDaoTest {
    private static Sql2oReviewDao reviewDao;
    private static Sql2oMovieDao movieDao;
    private static Connection conn;


    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/movie_reviews_test";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing Database");
        reviewDao.clearAllReviews();
        movieDao.clearAllMovies();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void add_addsReviewToMovieObjectCorrectly() {
        Review testReview = setNewReview();
        int originalMovieId = testReview.getId();
        reviewDao.add(testReview);
        assertNotEquals(originalMovieId, testReview.getId());
    }

    public Review setNewReview() {
        return new Review("10 outa 10", 1);
    }

    public Movie addShrek() {
        Movie shrek = new Movie();
        movieDao.add(shrek);
        shrek.setName("Shrek");
        shrek.setBlurb("This is the best movie");
        shrek.setYearReleased(2001);
        return shrek;
    }
}