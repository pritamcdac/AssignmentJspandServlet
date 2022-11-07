package com.cybage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.cybage.entity.Movie;
import com.cybage.service.MovieService;
import com.cybage.service.MovieServiceImpl;


@WebServlet(urlPatterns = { "/addMovie" ,"/editMovie" , "/deleteMovie" , "/allMovies" , "/adminLogin" , "/userHome"})
public class AdminController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MovieService movieService = new MovieServiceImpl();
	RequestDispatcher requestDispatcher = null;

	public AdminController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPath = request.getServletPath();
		try {
			switch (servletPath) {
			case "/addMovie":
				addMovie(request , response);
				break;
				
			case "/userHome":
				userHomeLoad(request, response);
				break; 
			
				
			case "/deleteMovie":
				deleteMovie(request, response);
				break; 
				
			case "/adminLogin":
				login(request, response);
				break;
				
			case "/allMovies":
				displayAllMovies(request, response);
				break;
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("admin@gmail.com") && password.equals("admin@123")){
			requestDispatcher = request.getRequestDispatcher("adminHome.jsp");
			requestDispatcher.forward(request, response);
		}else {
			String msg = "Invalid email or password";
			request.getSession().setAttribute("message", msg);
			response.sendRedirect("adminLogin.jsp");
		}
	}
	protected void addMovie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Movie movie = new Movie();
		String movieName = request.getParameter("movieName");
		String movieType = request.getParameter("movieType");
		String movieReleaseDate = request.getParameter("movieReleaseDate");
		movie.setMovieName(movieName);
		movie.setMovieType(movieType);
		movie.setMovieReleaseDate(java.sql.Date.valueOf(movieReleaseDate));
		//System.out.println(movie);
		movieService.addMovie(movie);
		response.sendRedirect("http://localhost:8082/MovieWebApp/allMovies");
	}
	
	protected void displayAllMovies(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Movie> movieList=movieService.getAllMovies();
		ServletContext context = request.getServletContext();
		context.setAttribute("movieList", movieList);
		requestDispatcher = request.getRequestDispatcher("allMovies.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void userHomeLoad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Movie> movieList=movieService.getAllMovies();
		ServletContext context = request.getServletContext();
//		System.out.println(movieList);
		context.setAttribute("movieList", movieList);
		requestDispatcher = request.getRequestDispatcher("userHome.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
		
		
	protected void deleteMovie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int movieId = Integer.parseInt(request.getParameter("id"));
		movieService.deteleMovie(movieId);
		response.sendRedirect("http://localhost:8082/MovieWebApp/allMovies");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
}
