<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fine Details</title>
</head>
<body>

	<!-- Navigation Bar starts -->
	<%@ include file="memberHeader.jsp"%>
	<!-- Navigation Bar Ends -->
	
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

</body>
</html>