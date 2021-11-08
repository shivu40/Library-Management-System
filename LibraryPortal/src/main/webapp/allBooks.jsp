<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<body>
	<!-- Navigation Bar starts -->
	<%@ include file="adminHeader.jsp"%>
	<!-- Navigation Bar Ends -->

<!-- Alert message for Update book  starts here -->
	<c:if test="${updateBookMessage !=null}">
		<div
			class="alert alert-dismissible alert-danger d-flex align-items-center fade show"
			role="alert">
			<div>${updateBookMessage}</div>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<!-- Alert message for Update book  ends here -->

<!-- Alert message for delete book message starts here -->
	<c:if test="${deleteBookMessage !=null}">
		<div
			class="alert alert-dismissible alert-danger d-flex align-items-center fade show"
			role="alert">
			<div>${deleteBookMessage}</div>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
<!-- Alert message for delete book message ends here -->


	<!--   table for searchResult starts -->
	<div class="container-fluid my-4 ">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form action="CrudBook?type=search"
					method="post">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" name="searchParameter"> <label
							for="floatingInput">Search by Title, Category, Author Name</label>
					</div>

					<div class="modal-footer">
						<button type="submit" class="btn btn-secondary">Search</button>

					</div>
				</form>
			</div>
		</div>


		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">ISBN NO:</th>
					<th scope="col">Title</th>
					<th scope="col">Copies Owned</th>
					<th scope="col">Author Name</th>
					<th scope="col">Edition</th>
					<th scope="col">Shelf No.</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Publisher Name</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${BookResult}" var="bookItem">

					<tr>
						<td><c:out value="${bookItem.isbn}" /></td>
						<td><c:out value="${bookItem.title}" /></td>
						<td><c:out value="${bookItem.copies_owned}" /></td>
						<td><c:out value="${bookItem.author_name}" /></td>
						<td><c:out value="${bookItem.edition}" /></td>
						<td><c:out value="${bookItem.shelf_no}" /></td>
						<td><c:out value="${bookItem.category}" /></td>
						<td><c:out value="${bookItem.price}" /></td>
						<td><c:out value="${bookItem.publisher_name}" /></td>
						<td><a href ="CrudBook?type=updateRequest&isbn=${bookItem.isbn}" style="color:white;">Update</a></td>
						<td><a href ="CrudBook?type=delete&isbn=${bookItem.isbn}" style="color:white;">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- table for searchResults End -->
</body>
</html>