package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewsTest {
    @Test
    public void NewReviewObjectGetsCorrectlyCreated_isTrue() {
        Review review = setUpNewReviewObject();
        assertEquals(true, review instanceof Review);
    }

    @Test
    public void getId_NewReviewObjectGetsIDCorrectly_isTrue() {
        Review review = setUpNewReviewObject();
        review.setId(1);
        assertEquals(1, review.getId());
    }

    @Test
    public void getReviewer_NewReviewObjectGetsReviewerCorrectly_isTrue() {
        Review review = setUpNewReviewObject();
        review.setReviewer("CoolGuy69");
        assertEquals("CoolGuy69", review.getReviewer());

    }

    @Test
    public void getReview_NewReviewObjectGetsReviewCorrectly_isTrue() {
        Review review = setUpNewReviewObject();
        review.setReview("This is the greatest movie of all time");
        assertEquals("This is the greatest movie of all time", review.getReview());
    }

    @Test
    public void getRating_NewReviewObjectGetsRatingCorrectly_isTrue() {
        Review review = setUpNewReviewObject();
        review.setRating(10);
        assertEquals(10, review.getRating());
    }

    @Test
    public void getMoviesId_NewReviewObjectGetsMoviesIdCorrectly_isTrue() {
        Review review = setUpNewReviewObject();
        review.setMovieId(1);
        assertEquals(1, review.getMovieId());
    }

    //HELPER METHOD
    public Review setUpNewReviewObject(){
        return new Review("string", 1);
    }

}