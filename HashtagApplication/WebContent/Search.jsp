<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Particular Hashtag..</title>
<link type="text/css" rel="stylesheet" href="Style.css"  /> 
</head>
<body>
	<div class="container">
		<div class="wrapper">
		<div id="header" ><h2>HashTag Application</h2></div>

			<form action="/HashtagApplication/SerachHashtagServlet" method="post">
				<label for="searchHash">Search hash :</label> <input type="text" name="hash" value="" /> 
				<input type="submit" style="width:100px;;margin-left:320px;" value="add" />
			</form>
		</div>
	</div>
</body>
</html>