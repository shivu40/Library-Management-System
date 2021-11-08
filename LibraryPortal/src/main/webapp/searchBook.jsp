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
<title>Search Results</title>
</head>
<body>
	<!-- Bootstrap code starts here-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<!-- Bootstrap code ends here -->


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
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
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
					<!-- 						<li class="nav-item"><a class="nav-link active" -->
					<%-- 							aria-current="page" href="#">${username}</a></li> --%>
					<!-- 					</ul> -->
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

	<!--   table for searchResult starts -->
	<div class="container my-4 ">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">ISBN NO:</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Edition</th>
					<th scope="col">Shelf No.</th>
					<th scope="col">Category</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${searchBookResult}" var="bookItem">

					<tr>
						<td><c:out value="${bookItem.isbn}" /></td>
						<td><c:out value="${bookItem.title}" /></td>
						<td><c:out value="${bookItem.author_name}" /></td>
						<td><c:out value="${bookItem.edition}" /></td>
						<td><c:out value="${bookItem.shelf_no}" /></td>
						<td><c:out value="${bookItem.category}" /></td>
						<c:if test="${bookItem.copies_owned>0}">
							<td><c:out value="Available" /></td>
						</c:if>
						<c:if test="${bookItem.copies_owned<0}">
							<td><c:out value="Not Available" /></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- table for searchResults End -->





</body>
</html>