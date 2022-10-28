package com.cybage.dao;

import java.util.List;

import com.cybage.entity.Movie;
import com.cybage.entity.RatingAndComment;

public interface MovieDao {

	void addMovie(Movie movie);

	List<Movie> getAllMovies();

	void addRatingAndComment(RatingAndComment ratingAndComment);

	void deleteMovie(int movieId);

}
