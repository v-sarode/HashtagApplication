<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page - Hashtag Application..</title>
<link type="text/css" rel="stylesheet" href="Style.css"  /> 
<style type="text/css">
/* 
body{
	padding: 0xp;
	margin: 0px;
	font-family: sans-serif;
	font-size: 0.8em;
	
}

.container{
	margin : 0px auto;
	
}

.wrapper {
	width:900px;
	margin : 0px auto; 
	border : 0px solid #000;
	overflow: hidden;;
}

 */
.menu ul {
    margin: 0; 
    padding: 0;
    width:185px;
    list-style-type: none;
}

.menu ul li a {
    text-decoration: none;
    padding: 10.5px 11px;
    border: 1px solid white;
    display:block;
    color: black;
    background-color: #787878;
    
}
 
.menu ul li a:visited {
    color: white;
}
 
.menu ul li a:hover, .menu_simple ul li .current {
    color: white;
    background-color: #C8C8C8;
}

#header{
	width:100%;
	overflow: hidden;
	text-align: center;;
}



</style>
</head>
<body>
	<div class="container">
		<div class="wrapper">
		<div id="header" ><h2>HashTag Application</h2></div>
		
			<h3>Select the operation to perform by clicking followint links:</h3>
			<div class="menu">
				<ul>
					<li><a href="createhashtag.jsp">Insert Hashtag</a> </li> 
					<li><a href="Search.jsp">Search Hashtag</a>  </li>
					<li><a href="/HashtagApplication/ViewHashtagServlet">View Hashtag</a> </li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>