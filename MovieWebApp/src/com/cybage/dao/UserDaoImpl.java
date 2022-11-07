package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cybage.entity.User;
import com.cybage.utility.JDBCUtility;

public class UserDaoImpl implements UserDao {

	@Override
	public void registration(User user) {
		PreparedStatement preparedStatement = null;
		try {
			try (Connection con = JDBCUtility.getConnection();) {
				preparedStatement = con.prepareStatement(
						"insert into user ( user_name , email , password ) values(?,?,?)");
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getPassword());
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		try {
			try (Connection con = JDBCUtility.getConnection()) {
				String sql = "SELECT * FROM user WHERE email = ?";
				PreparedStatement prep = con.prepareStatement(sql);
				prep.setString(1, email);
				ResultSet resultSet = prep.executeQuery();
				if (resultSet.next()) {
					user.setUserId(resultSet.getInt(1));
					user.setUserName(resultSet.getString(2));
					user.setEmail(resultSet.getString(3));
					user.setPassword(resultSet.getString(4));
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean login(User user) {
		try {
			try (Connection con = JDBCUtility.getConnection();) {
				String sql = "select email , password from user where email=? and password=?";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, user.getEmail());
				preparedStatement.setString(2, user.getPassword());
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next() == true)
					return true;
				else
					return false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
