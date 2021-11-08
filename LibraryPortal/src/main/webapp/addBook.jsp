<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>

	<!-- Navigation Bar starts -->
	<%@ include file="adminHeader.jsp"%>
	<!-- Navigation Bar Ends -->
	<!-- Alert message for add book  starts here -->
	<c:if test="${addBookMessage !=null}">
		<div
			class="alert alert-dismissible alert-danger d-flex align-items-center fade show"
			role="alert">
			<div>${addBookMessage}</div>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
<!-- Alert message for add book  ends here -->
<!-- 	Add Book form starts here -->
	<div class="container-fluid my-3" >
		<div class="row">
			<div class=col-3></div>
			<div class=col-6>
				<form action="addBook" method="post">
					<div class="form-floating mb-3 ">
						<input type="number" class="form-control" id="scholarId"
							placeholder="like 202120008" name="isbn" > <label
							for="floatingInput" >ISBN Number</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" name="title"> <label
							for="floatingInput">Title</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" name="copies_owned"> <label
							for="floatingInput">Number of Copies</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingPassword"
							placeholder="Password" name="edition"> <label
							for="floatingPassword">Edition</label>
					</div>

					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" name="publisher_name"> <label
							for="floatingInput">Publisher Name</label>
					</div>
					<div class="form-floating mb-3">
						<input type="number" class="form-control" id="scholarId"
							placeholder="like 202120008" name="price"> <label
							for="floatingInput">Price</label>
					</div>
					<div class="form-floating mb-3">
						<input type="number" class="form-control" id="scholarId"
							placeholder="like 202120008" name="shelf_no"> <label
							for="floatingInput">Shelf Number </label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" name="author_name"> <label
							for="floatingInput">Author Name</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" name="category"> <label
							for="floatingInput">Category</label>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-success">Add Book</button>
						
					</div>
				</form>

			</div>
		</div>
	</div>
<!-- Add book form ends here -->

<!-- footer starts -->
	<%@ include file="footer.jsp"%>
	<!-- footer ends -->
</body>
</html>