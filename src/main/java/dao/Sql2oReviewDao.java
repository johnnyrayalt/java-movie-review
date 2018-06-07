package dao;

import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oReviewDao implements ReviewDao {
    private final Sql2o sql2o;

    public Sql2oReviewDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Review> getAll() {
        return null;
    }

    @Override
    public void add(Review review) {

    }

    @Override
    public Review findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String review, int movieId) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllReviews() {
        String sql = "DELETE from reviews";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
