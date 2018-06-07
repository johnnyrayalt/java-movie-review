package dao;

import models.Movie;
import models.Review;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;
import org.sql2o.*;

import java.util.List;
import static org.junit.Assert.*;

public class Sql2oMovieDaoTest{
    private static Sql2oReviewDao reviewDao;
    private static Sql2oMovieDao movieDao;
    private static Connection conn;


    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/movie_reviews_test";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        movieDao = new Sql2oMovieDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        movieDao.clearAllMovies();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void addingMovieSetsId() throws Exception {
        Movie testMovie = addShrek();
        movieDao.add(testMovie);
        assertNotEquals(true, testMovie.getId());
    }

    @Test
    public void existingMovieCanBeFoundById() throws Exception {
        Movie testMovie = addShrek();
        movieDao.add(testMovie);
        Movie foundMovie = movieDao.findById(testMovie.getId());
        assertEquals(testMovie, foundMovie);
    }

    @Test
    public void existingMovieNameBlurbAndOrYearReleasedCanBeUpdated() {
        Movie testMovie = addShrek();
        movieDao.add(testMovie);
        int idOfMovieToUpdate = testMovie.getId();
        movieDao.update(idOfMovieToUpdate, "Shrek 2", "Double the fun", 2003);
        Movie updatedMovie = movieDao.findById(testMovie.getId());
        assertNotEquals(testMovie, updatedMovie);
    }

    @Test
    public void adminCanDeleteMovieById() {
        Movie testMovie = addShrek();
        Movie emptyMovieObject = setUpNewMovieObject();
        movieDao.add(testMovie);
        movieDao.add(emptyMovieObject);
        movieDao.deleteById(testMovie.getId());
        assertEquals(1, movieDao.getAll().size());
    }

    @Test
    public void getAll_getsAllMovieObjectsCorrectly_isTrue() {
        Movie testMovie = addShrek();
        Movie testMovie2 = addShrek();
        movieDao.add(testMovie);
        movieDao.add(testMovie2);
        assertEquals(2, movieDao.getAll().size());
    }

    @Test
    public void getAllReviewsByMovieId_GetsAllReviewsForAMovieCorrectly_isTrue() {
        Movie testMovie = addShrek();
        movieDao.add(testMovie);
        int movieId = testMovie.getId();
        Review newReview = new Review("10 / 10", movieId);
        Review nextReview = new Review("11 / 10", movieId);
        Review otherReview = new Review("12 / 10", movieId);
        reviewDao.add(newReview);
        reviewDao.add(nextReview);
        assertEquals(2, reviewDao.getAll().size());
        assertTrue(movieDao.getAllReviewsByMovieId(movieId).contains(newReview));
    }

    public Movie setUpNewMovieObject() {
        return new Movie();
    }

    public Movie addShrek() {
        Movie shrek = setUpNewMovieObject();
        shrek.setName("Shrek");
        shrek.setBlurb("This is the best movie");
        shrek.setYearReleased(2001);
        return shrek;
    }
}