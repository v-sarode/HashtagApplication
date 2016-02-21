<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 	<jsp:useBean id="user" class="model.Hashtag" scope="request"></jsp:useBean>
	<jsp:setProperty  name="user" property="*"/>
	
	<%
	String action = request.getParameter("action");
	
	//request.getContextPath();
	
	if (action != null && action.equalsIgnoreCase("add")){
//	if((request.getParameter("action").compareTo("add")) == 0 ){
	 	if(user.validate()){
	 		out.println("input contains space or empty....");
		}else{
			request.getRequestDispatcher("/CreateHashtagServlet").forward(request, response);			
			out.println("validated ");

		}
	
	}
//	}

	
	%>
	
	
<%-- 	<% 	
	
		if(user.validate()){
			request.getRequestDispatcher("/HashtagApplication/CreateHashtagServlet").forward(request, response);
		}
	%>
 --%>	
	
 	<jsp:getProperty property="message" name="user"/>

	 <form action="/HashtagApplication/copyofcreatehashtag.jsp" method="post"> 
	<!-- 	<form action="/HashtagApplication/CreateHashtagServlet" method="post"> -->
		hash : <input type="text" name="hash"  value='<jsp:getProperty property="hash" name="user"/>' />  

		<input type="hidden" name="action" value="add"/> 
		<input type="submit" value="add" />
	</form>

</body>
</html>