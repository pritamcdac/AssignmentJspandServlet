package com.cybage.service;

import java.util.List;

import com.cybage.dao.MovieDao;
import com.cybage.dao.MovieDaoImpl;
import com.cybage.entity.Movie;
import com.cybage.entity.RatingAndComment;

public class MovieServiceImpl implements MovieService{
	
	private MovieDao movieDao = new MovieDaoImpl();

	@Override
	public void addMovie(Movie movie) {	
		movieDao.addMovie(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}

	@Override
	public void addRatingAndComment(RatingAndComment ratingAndComment) {
		movieDao.addRatingAndComment(ratingAndComment);
	}

	@Override
	public void deteleMovie(int movieId) {
		movieDao.deleteMovie(movieId);
	}

}
