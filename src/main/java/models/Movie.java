package models;

import java.util.Objects;

public class Movie {
    private String name;
    private String blurb;
    private int year_released;
    private int id;

    public Movie() {
        this.name = name;
        this.blurb = blurb;
        this.year_released = year_released;
    }

// GET & SET NAME
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

// GET & SET BLURB
    public String getBlurb() { return blurb; }
    public void setBlurb(String blurb) { this.blurb = blurb; }

// GET & SET YEAR RELEASED
    public int getYearReleased() { return year_released; }
    public void setYearReleased(int year_released) { this.year_released = year_released; }

// GET & SET ID
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

// EQUALS AND HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie Movie = (Movie) o;
        return year_released == Movie.year_released &&
                id == Movie.id &&
                Objects.equals(name, Movie.name) &&
                Objects.equals(blurb, Movie.blurb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, blurb, year_released, id);
    }

}
