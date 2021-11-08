<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fine Module</title>
</head>
<body>

	<!-- Navigation Bar starts -->
	<%@ include file="adminHeader.jsp"%>
	<!-- Navigation Bar Ends -->

	<!-- Alert message for issue message starts here -->
	<c:if test="${fineMessage !=null}">
		<div
			class="alert alert-dismissible alert-danger d-flex align-items-center fade show"
			role="alert">
			<div>${fineMessage}</div>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<!-- Alert message for issue message ends here -->
	<!-- Alert message for return message starts here -->
	<c:if test="${returnMessage !=null}">
		<div
			class="alert alert-dismissible alert-danger d-flex align-items-center fade show"
			role="alert">
			<div>${returnMessage}</div>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<!-- Alert message for return message ends here -->

	<div class="container-fluid my-4">
		<div class="row">
			<div class="col-2"></div>

			<div class="col-4">
				<div class="card" style="width: 30rem;">
					<div class="card-header">
						<strong>Member Information:</strong>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><strong>Scholar Id:</strong>
							${member.id}</li>
						<li class="list-group-item"><strong>Name:</strong>
							${member.name}</li>
						<li class="list-group-item"><strong>Email:</strong>
							${member.email}</li>
						<%-- 						<li class="list-group-item"><strong>Active Status:</strong> ${member.active_status}</li> --%>
						<li class="list-group-item"><strong>Mobile NO:</strong>
							${member.mobile_no}</li>
					</ul>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-3">
				<form action="FineAdmin?type=search"
					method="post">
					<div class="form-floating mb-3">
						<input type="number" class="form-control" id="scholarId"
							placeholder="like 202120008" name="scholarId"> <label
							for="floatingInput">Enter Scholar NO:</label>
					</div>

					<div class="modal-footer">
						<button type="submit" class="btn btn-outline-secondary">Search</button>

					</div>
				</form>
				<form action="FineAdmin?type=removeFine&scholarId=${member.id}"
					method="post">
					<div class="d-grid gap-2">
						<button class="btn btn-outline-success" type="submit">Remove
							Fine</button>

					</div>
				</form>
			</div>
		</div>

		<!--   table for Fine List starts -->
		<div class="container my-4 ">
			<table class="table table-dark table-striped">
				<thead>
					<tr>

						<th scope="col">Borrow Id</th>
						<th scope="col">Book Title</th>
						<th scope="col">ISBN No:</th>
						<th scope="col">Issue Date</th>
						<th scope="col">Due Date</th>
						<th scope="col">Return Date</th>
						<th scope="col">Fine Amount</th>


					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookList}" var="bookItem">

						<tr>

							<td><c:out value="${bookItem.borrow_id}" /></td>
							<td><c:out value="${bookItem.title}" /></td>
							<td><c:out value="${bookItem.isbn}" /></td>							
							<td><c:out value="${bookItem.issue_date}" /></td>
							<td><c:out value="${bookItem.due_date}" /></td>
							<td><c:out value="${bookItem.return_date}" /></td>
							<td><c:out value="${bookItem.amount}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<!-- table for Fine List End -->

	</div>
</body>
</html>