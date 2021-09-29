<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello world
	<a href="searchBook.jsp" >search</a>
	<form action="search" method="get">
	<input type="text" name="searchParameter">
	<button type="submit" >search</button>
	</form>
	<br />member<br />
	<form action="login?type=member" method="post">
	id:<input type="text" name="id">
	pass:<input type="text" name="pass">
	<button type="submit" >login</button>
	</form>
	<br /><br />
	
	<br />staff<br />
	<form action="login?type=staff" method="post">
	id:<input type="text" name="uname">
	pass:<input type="text" name="pass">
	<button type="submit" >login</button>
	</form>
	<br /><br />
	<form action="register" method="post">
	isbn<input type="text" name="isbn">
	title<input type="text" name="title">
	copies_owned<input type="text" name="copies_owned">
	edition<input type="text" name="edition">
	publisher_name<input type="text" name="publisher_name">
	price<input type="text" name="price">
	shelf_no<input type="text" name="shelf_no">
	author_name<input type="text" name="author_name">
	category<input type="text" name="category">
	<button type="submit" >Add Book</button>
	</form>
</body>
</html>