package com.cybage.entity;

public class RatingAndComment {
	private int id;
	private float movieRating;
	private String comment;
	private int movieId;
	private int userId;

	public RatingAndComment() {
		super();
	}

	public RatingAndComment(int id, float movieRating, String comment, int movieId, int userId) {
		super();
		this.id = id;
		this.movieRating = movieRating;
		this.comment = comment;
		this.movieId = movieId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RatingAndComment [id=" + id + ", movieRating=" + movieRating + ", comment=" + comment + ", movieId="
				+ movieId + ", userId=" + userId + "]";
	}

}
