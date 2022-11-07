package com.cybage.service;

import java.util.List;

import com.cybage.entity.Movie;
import com.cybage.entity.RatingAndComment;

public interface MovieService {

	void addMovie(Movie movie);

	List<Movie> getAllMovies();

	void addRatingAndComment(RatingAndComment ratingAndComment);

	void deteleMovie(int movieId);

}
