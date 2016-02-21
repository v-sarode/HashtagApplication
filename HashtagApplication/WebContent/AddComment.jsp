<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Comment To Hashtag..</title>
<link type="text/css" rel="stylesheet" href="Style.css"  /> 
<style type="text/css">

textarea {
    width: 300px;
    height: 54px;
    margin-top: 6px;
    margin-bottom: 3px;
}

</style>
</head>
<body>
	<div class="container">
		<div class="wrapper">
		<div id="header" ><h2>HashTag Application</h2></div>
		


<%

String id = request.getParameter("hashId");
String tag = request.getParameter("hashtag");

//out.println("id is :"+id);
%>

<h2>Add Comment for the Hashtag</h2>
	
	<form action="/HashtagApplication/AddCommentServlet" method="post">
			<label for="searchHash">HashTag:</label> <input name="hashtag" type="text" value="<%=tag%>"/ > <br/>
			<input name="id" type="hidden" value="<%=id%>"/ > <br/>
			<label for="searchHash">Comment:</label> <textarea name="comment" ></textarea> <br/>
			<input type="submit" style="width:100px;;margin-left:320px;" value="add"/ > <br/>
	
	</form>
	
	
	</div>
	
	</div>
</body>
</html>