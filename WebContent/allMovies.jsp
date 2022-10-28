<%@page import="com.cybage.service.MovieServiceImpl"%>
<%@page import="com.cybage.service.MovieService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Movies</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" ></script>
    <script src="//code.jquery.com/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <style>
        	.navbar-brand{
    		 font-family: 'Comforter', cursive;
    		 color: red;
    		 text-shadow: 5px 5px 5px #83647e;
    		 font-size: 30px;
    	}
    	.navbar{
    		 background: linear-gradient(to bottom, #ffffff 0%, #ffff66 100%);
    	}
    	.nav-link , #home{
    		font-family: 'Times New Roman', Times, serif;
    		font-size: 20px;
    		color: black;
		}
    	.nav-link:hover , #home:hover{
  			 color: blueviolet;
		}
    	h1{
    		text-align: center;
    		font-family: Merriweather;
    		 color: blue;
    		 text-shadow: 5px 5px 5px #83647e;
    	}
    	.alert{
    		background: linear-gradient(to bottom, #ffccff 0%, #ccffcc 100%);
    	}
    	strong{
    		text-align: center;
    	}
    	.userInfo{
    		 background: linear-gradient(to bottom, #66ffff 0%, #ffffff 100%);
    		text-align: center;
    		color:green;
    	}
    </style>
</head>
<body>
<%
	MovieService movieService = new MovieServiceImpl();
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">MovieWebApp</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
    </div>
  </div>
</nav>
<br>
	    <br>
<div class = "container">
		
		<h1>All Movies In List</h1>
		<hr/>

		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Movie Id</th>
				<th>Movie Name</th>
				<th>Movie Type</th>
				<th>Release Date</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${movieList}" var="movie">
			
				<tr>
					<td>${movie.movieId}</td>
					<td>${movie.movieName}</td>
					<td>${movie.movieType}</td>
					<td>${movie.movieReleaseDate}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/editMovieDetails.jsp?action=EDIT&id=${movie.movieId}&">Edit</a> 
						| 
						<a href = "${pageContext.request.contextPath}/deleteMovie?action=DELETE&id=${movie.movieId}">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
		
	</div>
</body>
</html>