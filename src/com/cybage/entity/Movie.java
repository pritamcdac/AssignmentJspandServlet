package com.cybage.entity;

import java.sql.Date;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieType;
	private Date movieReleaseDate;
	private float averageRating;

	public Movie() {
		super();
	}

	public Movie(int movieId, String movieName, String movieType, Date movieReleaseDate, float averageRating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieReleaseDate = movieReleaseDate;
		this.averageRating = averageRating;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieReleaseDate=" + movieReleaseDate + ", averageRating=" + averageRating + "]";
	}

}
