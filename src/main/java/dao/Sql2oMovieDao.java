package dao;

import models.Movie;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oMovieDao implements MovieDao{

    private final Sql2o sql2o;

    public Sql2oMovieDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Movie> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM movies")
                    .executeAndFetch(Movie.class);
        }
    }

    @Override
    public void add(Movie movie) {
        String sql = "INSERT INTO movies (name, blurb, year_released) VALUES (:name, :blurb, :yearReleased)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(movie)
                    .executeUpdate()
                    .getKey();
            movie.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Movie findById(int id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM movies WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Movie.class);
        }
    }

    @Override
    public void update(int id, String newName, String newBlurb, int newYearReleased) {
        String sql = "UPDATE movies SET (name, blurb, year_released) = (:name, :blurb, :year_released) WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", newName)
                    .addParameter("blurb", newBlurb)
                    .addParameter("year_released", newYearReleased)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM movies where id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllMovies() {
        String sql = "DELETE from movies";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Review> getAllReviewsByMovieId(int movieId) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM reviews WHERE movieId = :movieId")
                    .addParameter("movieId", movieId)
                    .executeAndFetch(Review.class);
        }
    }
}
