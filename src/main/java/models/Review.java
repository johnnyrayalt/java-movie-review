package models;

import java.util.Objects;

public class Review {
    private int id;
    private String reviewer;
    private String review;
    private int rating;
    private int movieId;

    public Review(String review, int movieId) {
        this.review = review;
        this.reviewer = reviewer;
        this.rating = rating;
        this.movieId = movieId;
    }

// GETTERS AND SETTERS FOR ID
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // GETTERS AND SETTERS FOR REVIEW
    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

// GETTERS AND SETTERS FOR REVIEWER
    public String getReviewer() { return reviewer; }
    public void setReviewer(String reviewer) { this.reviewer = reviewer; }

// GETTERS AND SETTERS FOR RATING
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

// GETTERS AND SETTERS FOR MOVIES_ID
    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

// GETTERS AND SETTERS FOR EQUALS & HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return rating == review.rating &&
                id == review.id &&
                Objects.equals(reviewer, review.reviewer) &&
                Objects.equals(this.review, review.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review, reviewer, rating, id);
    }
}
