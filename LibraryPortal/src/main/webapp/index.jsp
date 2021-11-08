<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


<meta charset="ISO-8859-1">
<title>Library Portal</title>
</head>
<style>
</style>
<body>

	<!-- Bootstrap code starts here-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<!-- Bootstrap code ends here -->


	<!-- Admin login model starts here -->

	<div class="modal fade" id="adminLoginModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Admin Login</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="login?type=staff" method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="scholarId"
								placeholder="like 202120008" name="uname" required> <label
								for="floatingInput">Username</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control" id="floatingPassword"
								placeholder="Password" name="pass" required> <label
								for="floatingPassword">Password</label>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Login</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!--Admin login model ends here	 -->

	<!-- Member login model starts here -->

	<div class="modal fade" id="memberLoginModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Member Login</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="login?type=member" method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="scholarId"
								placeholder="like 202120008" name="id"> <label
								for="floatingInput">Scholar Id</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control" id="floatingPassword"
								placeholder="Password" name="pass"> <label
								for="floatingPassword">Password</label>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Login</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!--Member login model ends here	 -->

	<!-- 	Register model starts here -->

	<div class="modal fade" id="registerModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Register</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="register" method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="scholarId"
								placeholder="like 202120008" name="id"> <label
								for="floatingInput">Scholar Id</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="scholarId"
								placeholder="like 202120008" name="name"> <label
								for="floatingInput">Name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="Email" class="form-control" id="scholarId"
								placeholder="like 202120008" name="email"> <label
								for="floatingInput">Email</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control" id="floatingPassword"
								placeholder="Password" name="password"> <label
								for="floatingPassword">Password</label>
						</div>

						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="scholarId"
								placeholder="like 202120008" name="mobile_no"> <label
								for="floatingInput">Mobile No:</label>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Register</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			
			</div>
		</div>
	</div>
	<!-- Register model ends here	 -->

	<!-- Navigation Bar Start -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Library Portal</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About </a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Login </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><button type="button" class="btn dropdown-item"
									data-bs-toggle="modal" data-bs-target="#memberLoginModal">Member
									Login</button></li>
							<li><button type="button" class="btn dropdown-item"
									data-bs-toggle="modal" data-bs-target="#adminLoginModal">Admin
									Login</button></li>
						</ul></li>

					<li><button type="button" class="btn nav-link"
							data-bs-toggle="modal" data-bs-target="#registerModal">Register</button></li>
				</ul>
				<form action="search" method="get" class="d-flex">
					<%-- 					<c:if test="${username !=null}"> --%>
					<!-- 						<ul class="navbar-nav me-auto mb-2 mb-lg-0"> -->
					<!-- 							<li class="nav-item"><a class="nav-link active" -->
					<%-- 								aria-current="page" href="#"> <c:out value = "${username}"/></a></li> --%>
					<!-- 						</ul> -->
					<%-- 					</c:if> --%>

					<input class="form-control me-2 " type="search"
						placeholder="Search by Title,Author,Category"
						name="searchParameter" aria-label="Search">

					<button class="btn btn-outline-secondary" type="submit">Search</button>
				</form>

			</div>
		</div>
	</nav>
	<!-- Navigation Bar End -->


	<!-- Alert message if login fails starts here -->
	<c:if test="${loginMessage !=null}">
		<div
			class="alert alert-dismissible alert-danger d-flex align-items-center fade show"
			role="alert">
			<div>${loginMessage}</div>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<!-- Alert message if login fails ends here -->


<!-- Alert message for registration starts here -->
	<c:if test="${regMessage !=null}">
		<div
			class="alert alert-dismissible alert-danger d-flex align-items-center fade show"
			role="alert">
			<div>${regMessage}</div>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<!-- Alert message for registration ends here -->

	<!-- Carousel Starts -->
	<div id="carouselExampleCaptions" class="carousel slide carousel-fade "
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="Images/img2.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>First slide label</h5>
					<p>Some representative placeholder content for the first slide.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="Images/img3.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>Second slide label</h5>
					<p>Some representative placeholder content for the second
						slide.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="Images/img5.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>Third slide label</h5>
					<p>Some representative placeholder content for the third slide.</p>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!-- Carousel Ends -->



	<!-- Footer Starts -->
	<div class="container">
		<footer
			class="  d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
			<div class="col-md-4 d-flex align-items-center">

				<span class="text-muted">© All rights reserved by Library
					Portal </span>
			</div>


		</footer>
	</div>

	<!-- Footer Ends -->







	Hello world
	<a href="searchBook.jsp">search</a>
	<form action="search" method="get">
		<input type="text" name="searchParameter">
		<button type="submit">search</button>
	</form>
	<br />member
	<br />
	<form action="login?type=member" method="post">
		id:<input type="text" name="id"> pass:<input type="text"
			name="pass">
		<button type="submit">login</button>
	</form>
	<br />
	<br />

	<br />staff
	<br />
	<form action="login?type=staff" method="post">
		id:<input type="text" name="uname"> pass:<input type="text"
			name="pass">
		<button type="submit">login</button>
	</form>
	<br />
	<br />
	<form action="register" method="post">
		isbn<input type="text" name="isbn"> title<input type="text"
			name="title"> copies_owned<input type="text"
			name="copies_owned"> edition<input type="text" name="edition">
		publisher_name<input type="text" name="publisher_name"> price<input
			type="text" name="price"> shelf_no<input type="text"
			name="shelf_no"> author_name<input type="text"
			name="author_name"> category<input type="text"
			name="category">
		<button type="submit">Add Book</button>
	</form>
</body>
</html>