package com.cybage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.entity.RatingAndComment;
import com.cybage.entity.User;
import com.cybage.service.MovieService;
import com.cybage.service.MovieServiceImpl;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

@WebServlet(urlPatterns = { "/register" ,"/login" , "/addRatingAndComment"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private MovieService movieService = new MovieServiceImpl();
	RequestDispatcher requestDispatcher = null;

	public UserController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPath = request.getServletPath();
		try {
			switch (servletPath) {
			case "/register":
				registerUser(request , response);
				break;
				
			case "/login":
				login(request , response);
				break;
				
			case "/addRatingAndComment":
				addRatingAndComment(request , response);
				break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	protected void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		if(userService.getUserByEmail(email)==null) {
		if (password.equals(confirmPassword)) {
			user.setUserName(userName);
			user.setEmail(email);
			user.setPassword(password);
			userService.registration(user);
			requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		} else {
			String msg = "Password Missmatch.....Please try again .... !!!";
			request.getSession().setAttribute("message", msg);
			response.sendRedirect("registration.jsp");
		}
		}else {
			String msg = "Email already exists....!!!";
			request.getSession().setAttribute("message", msg);
			response.sendRedirect("registration.jsp");
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user.setEmail(email);
		user.setPassword(password);
		if(userService.login(user)){
			request.getSession().setAttribute("userEmail", email);
			response.sendRedirect("http://localhost:8082/MovieWebApp/userHome");
		}else {
			String msg = "Invalid email or password";
			request.getSession().setAttribute("message", msg);
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void addRatingAndComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RatingAndComment ratingAndComment = new RatingAndComment();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		float movieRating = Float.parseFloat(request.getParameter("movieRating"));
		String comment = request.getParameter("comment");
		ratingAndComment.setMovieId(movieId);
		ratingAndComment.setMovieRating(movieRating);
		ratingAndComment.setComment(comment);
		
		String email = (String) request.getSession().getAttribute("userEmail");
		if(email!=null) {
			User user = userService.getUserByEmail(email);
			ratingAndComment.setUserId(user.getUserId());
			System.out.println(ratingAndComment);
			//movieService.addRatingAndComment(ratingAndComment);
			//response.sendRedirect("http://localhost:8082/MovieWebApp/userHome");	
		}else {
			response.sendRedirect("login.jsp");	
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
