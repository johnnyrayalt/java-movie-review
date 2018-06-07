package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class moviesTest {

    @Test
    public void NewMoviesObjectGetsCorrectlyCreated_isTrue() throws Exception{
        Movie testMovie = setUpNewMoviesObject();
        assertEquals(true, testMovie instanceof Movie);
    }

    @Test
    public void NewMoviesObjectGetNameCorrectly_isShrek() {
        Movie testMovie = setUpNewMoviesObject();
        testMovie.setName("Shrek");
        assertEquals("Shrek", testMovie.getName());
    }

    @Test
    public void getBlurb() {
    }

    @Test
    public void getYearReleased() {
    }

    @Test
    public void getId() {
    }

    // HELPER METHOD
    public Movie setUpNewMoviesObject() {
        return new Movie();
    }
}