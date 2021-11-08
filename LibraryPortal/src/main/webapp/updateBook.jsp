<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Navigation Bar starts -->
	<%@ include file="adminHeader.jsp"%>
	<!-- Navigation Bar Ends -->
	
	<!-- 	Add Book form starts here -->
	<div class="container-fluid my-3">
		<div class="row">
			<div class=col-3></div>
			<div class=col-6>
				<form action="CrudBook?type=update" method="post">
					<div class="form-floating mb-3 ">
						<input type="number" class="form-control" id="scholarId"
							placeholder="like 202120008" value="${toBeUpdated.isbn}" name="isbn" > <label
							for="floatingInput">ISBN Number</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" name="title" value="${toBeUpdated.title}"> <label
							for="floatingInput">Title</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" value="${toBeUpdated.copies_owned}" name="copies_owned"> <label
							for="floatingInput">Number of Copies</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingPassword"
							placeholder="Password" value="${toBeUpdated.edition}" name="edition"> <label
							for="floatingPassword">Edition</label>
					</div>

					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" value="${toBeUpdated.publisher_name}" name="publisher_name"> <label
							for="floatingInput">Publisher Name</label>
					</div>
					<div class="form-floating mb-3">
						<input type="number" class="form-control" id="scholarId"
							placeholder="like 202120008" value="${toBeUpdated.price}" name="price"> <label
							for="floatingInput">Price</label>
					</div>
					<div class="form-floating mb-3">
						<input type="number" class="form-control" id="scholarId"
							placeholder="like 202120008" value="${toBeUpdated.shelf_no}" name="shelf_no"> <label
							for="floatingInput">Shelf Number </label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" value="${toBeUpdated.author_name}" name="author_name"> <label
							for="floatingInput">Author Name</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="scholarId"
							placeholder="like 202120008" value="${toBeUpdated.category}" name="category"> <label
							for="floatingInput">Category</label>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-success">Update Book</button>

					</div>
				</form>

			</div>
		</div>
	</div>
	<!-- Update book form ends here -->
</body>
</html>