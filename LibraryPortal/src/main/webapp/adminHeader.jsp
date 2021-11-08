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
<title>Insert title here</title>
</head>
<body>
	<!-- Bootstrap code starts here-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<!-- Bootstrap code ends here -->


<!-- IssueBook model starts here -->

	<div class="modal fade" id="issueBookModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Issue Model</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="IssueReturn?type=search" method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="scholarId"
								placeholder="like 202120008" name="scholarId"> <label
								for="floatingInput">Enter Scholar Id</label>
						</div>
						
						<div class="modal-footer">
							<button type="submit" class="btn btn-success">Go</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- IssueBook model ends here	 -->



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
					<li class="nav-item"><a class="nav-link "
						aria-current="page" href="adminHome.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="addBook.jsp">Add Book </a></li>
					<li><button type="button" class="btn nav-link"
							data-bs-toggle="modal" data-bs-target="#issueBookModal">Issue Book</button></li>
					<li class="nav-item"><a class="nav-link" href="CrudBook?type=all">See All Books </a></li>
					<li class="nav-item"><a class="nav-link" href="FineAdminView.jsp">View Fines </a></li>

				
				</ul>
				<ul class=" navbar-nav nav justify-content-end">
				<c:if test="${username !=null}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#"><c:out value = "${username}"/></a></li>
						</c:if>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
					
					
				</ul>
			</div>
		</div>
	</nav>
	<!-- Navigation Bar End -->


</body>
</html>