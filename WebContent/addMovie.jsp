<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movie</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" ></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
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
    	.col-6{
    	}
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Movie Web App</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      
    </div>
  </div>
</nav>
	    <br>
    <h1>Add Movie</h1>
<c:if test="${not empty message}">
   <div class="alert alert-warning">
       <strong><c:out value="${message}"/></strong>
   </div>
   <c:set var="message" value="" scope="session"/>
</c:if>
    <div class="container">
        <div class="row">
            <div class="col-3">

            </div>
            <div class="col-6">
                <form action="${pageContext.request.contextPath}/addMovie" id="target" method="post">
                 <div class="form-group" >
                        <label for="exampleInputMovieName" id="input-movieName">Movie Name</label>
                        <input type="text" class="form-control" name="movieName" aria-describedby="movieNameHelp" placeholder="Enter Movie Name" required>
                    </div>
                    <br>
                    <div class="form-group" >
                        <label for="exampleInputMovieType" id="input-movieType">Movie Type</label>
                        <input type="text" class="form-control" name="movieType" aria-describedby="movieTypeHelp" placeholder="Enter Movie Type" required>
                    </div>
                    <br>
                     <div class="form-group" >
                        <label for="exampleInputMovieReleaseDate" id="input-movieReleaseDate">Movie Release Date</label>
                        <input type="date" class="form-control" name="movieReleaseDate" aria-describedby="movieReleaseDateHelp" placeholder="Enter Movie Release Date" required>
                    </div>
                    <br>
                    <div  class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                </div>
                    <br>
                 
                </form>

            </div>
            <div class="col-3">

            </div>
        </div>
    </div>


</body>
</html>