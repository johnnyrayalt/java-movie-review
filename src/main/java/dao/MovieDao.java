package dao;

import models.Movie;
import models.Review;

import java.util.List;

public interface MovieDao {

    //LIST
    List<Movie> getAll();
    List<Review> getAllReviewsByMovieId(int movieId);

    //CREATE
    void add(Movie movie);

    //READ
    Movie findById(int id);

    //UPDATE
    void update(int id, String name, String blurb, int year_released);

    //DELETE
    void deleteById(int id);
    void clearAllMovies();
}
