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
					<li class="nav-item"><a class="nav-link" href="MemberIssuedBooks">Issued Books </a></li>
					
					<li class="nav-item"><a class="nav-link" href="MemberReturnedBooks">Returned Books </a></li>
					<li class="nav-item"><a class="nav-link" href="FineMember">View Fines </a></li>

				
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