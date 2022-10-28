
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminHome</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" ></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">

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
    	.userOption1{
    		font-family: 'Times New Roman', Times, serif;
    		font-size: 30px;
    		color: black;
    	}
		a{
			text-decoration: none;
		}
    	</style>
</head>
<body>

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
    <h1>AdminHome</h1>
    <br>
    <div class="container">
  <div class="row">
    <div class="col-3">
    </div>
    <div class="col-6">
    	<div class="userOption1">
    		<a href="${pageContext.request.contextPath}/addMovie.jsp">Add Movie</a>
    	</div>
    	<br>
    	<div class="userOption1">
    		<a href="${pageContext.request.contextPath}/allMovies">Show All Movies</a>
    	</div>
    </div>
    <div class="col-3">
    </div>
  </div>
</div>
</body>
</html>