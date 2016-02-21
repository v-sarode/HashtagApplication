<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="Style.css"  /> 
<style type="text/css">
td {
	width: 100px;
	padding: 3px;
}
table{
/* 	border: 1px solid #000; */
	
}
</style>
</head>
<body>
	<div class="container">
		<div class="wrapper">
		<div id="header" ><h2>HashTag Application</h2></div>

	<table cellpadding="1" cellspacing="1" border="1">

		<tr>
			<td class="id">ID</td>
			<td class="hash">HASHTAG</td>
			<td class="date">DATE</td>
			<td class="comment">ADD COMMENT</td>
		</tr>
		<%
			String htmlstring = (String) request.getAttribute("htmlString");

			out.println(htmlstring);
		%>


	</table>
</div></div>

</body>
</html>