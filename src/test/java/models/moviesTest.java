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
    public void getName_NewMoviesObjectGetNameCorrectly_isShrek() {
        Movie testMovie = setUpNewMoviesObject();
        testMovie.setName("Shrek");
        assertEquals("Shrek", testMovie.getName());
    }

    @Test
    public void getBlurb_NewMoviesObjectGetBlurbCorrectly_isTrue() {
        Movie testMovie = setUpNewMoviesObject();
        testMovie.setBlurb("a love story about an ogre and a donkey");
        assertEquals("a love story about an ogre and a donkey", testMovie.getBlurb());
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