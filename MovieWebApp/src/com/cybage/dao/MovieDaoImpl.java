 package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cybage.entity.Movie;
import com.cybage.entity.RatingAndComment;
import com.cybage.utility.JDBCUtility;

public class MovieDaoImpl implements MovieDao{

	@Override
	public void addMovie(Movie movie) {
		PreparedStatement preparedStatement = null;
		try {
			try (Connection con = JDBCUtility.getConnection();) {
				preparedStatement = con.prepareStatement(
						"insert into movie ( movie_name , movie_type , movie_release_date ) values(?,?,?)");
				preparedStatement.setString(1, movie.getMovieName());
				preparedStatement.setString(2, movie.getMovieType());
				preparedStatement.setDate(3, movie.getMovieReleaseDate());
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = new ArrayList<>();
		try {
			try (Connection con = JDBCUtility.getConnection();) {
				String sql = "SELECT * FROM movie";
				PreparedStatement prep = con.prepareStatement(sql);
				ResultSet resultSet = prep.executeQuery();
				while (resultSet.next()) {
					
					movieList.add(getMovieByName(resultSet.getString(2)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movieList;
	}
	
	private Movie getMovieByName(String movieName) {
		Movie movie = new Movie();
		try {
			try (Connection con = JDBCUtility.getConnection()) {
				String sql = "SELECT * FROM movie WHERE movie_name = ?";
				PreparedStatement prep = con.prepareStatement(sql);
				prep.setString(1, movieName);
				ResultSet resultSet = prep.executeQuery();
				if (resultSet.next()) {
					movie.setMovieId(resultSet.getInt(1));
					movie.setMovieName(resultSet.getString(2));
					movie.setMovieType(resultSet.getString(3));
					movie.setMovieReleaseDate(resultSet.getDate(4));
					movie.setAverageRating(getMovieAverageRating(resultSet.getInt(1)));
					return movie;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private float getMovieAverageRating(int movieId) {
		try {
			try (Connection con = JDBCUtility.getConnection()) {
				String sql = "SELECT avg(movie_rating) from rating_and_comment where movie_id=?";
				PreparedStatement prep = con.prepareStatement(sql);
				prep.setInt(1, movieId);
				ResultSet resultSet = prep.executeQuery();
				if (resultSet.next()) {
					return resultSet.getFloat(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (float) 0.0;
	}

	@Override
	public void addRatingAndComment(RatingAndComment ratingAndComment) {
		PreparedStatement preparedStatement = null;
		try {
			try (Connection con = JDBCUtility.getConnection();) {
				preparedStatement = con.prepareStatement(
						"insert into rating_and_comment ( movie_rating , comment , movie_id , user_id ) values(?,?,?,?)");
				preparedStatement.setFloat(1, ratingAndComment.getMovieRating());
				preparedStatement.setString(2, ratingAndComment.getComment());
				preparedStatement.setInt(3, ratingAndComment.getMovieId());
				preparedStatement.setInt(4, ratingAndComment.getUserId());
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMovie(int movieId) {
		try {
			try (Connection con = JDBCUtility.getConnection()) {
				String sql = "DELETE FROM movie WHERE movie_id = ?";
				PreparedStatement prep = con.prepareStatement(sql);
				prep.setInt(1, movieId);
				prep.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
