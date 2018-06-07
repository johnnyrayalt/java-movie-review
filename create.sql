CREATE DATABASE movie_reviews;
\c movie_reviews;
CREATE TABLE movies (id SERIAL PRIMARY KEY, name VARCHAR, blurb VARCHAR, year_released INTEGER);
CREATE TABLE reviews (id SERIAL PRIMARY KEY, reviewer VARCHAR, review VARCHAR, movies_id INTEGER);
CREATE DATABASE movie_reviews_test WITH TEMPLATE movie_reviews;