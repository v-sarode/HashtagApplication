package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewHashtagServlet
 */
public class ViewHashtagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewHashtagServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("viewHashtag");
		
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement stmt = null;
		
		String hash = request.getParameter("hash");
		
//		if(hash.length() == 0 || hash.contains(" ")|| hash.contains("")){
//			request.setAttribute("error", "hashtag value is empty...try again later");
//			request.getRequestDispatcher("/error.jsp").forward(request, response);
//		}
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL="jdbc:mysql://localhost:3306/hash";
		
		//  Database credentials
		 final String USER = "root";
		 final String PASS = "root";
		 
		 
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			out.println("driver error ....");
			return;
		}

		try {
			conn = DriverManager.getConnection( DB_URL,USER,PASS);
			        
		} catch (SQLException e) {
			out.println("Connection error ....");
			e.printStackTrace();
			return;
			
		} 
		
		
		PreparedStatement pst = null;
		String sql = "SELECT * FROM hashtag";
	
		try {
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();	
		}

		
		try {
			ResultSet rs = pst.executeQuery();
			String id = "";
			String tag = "";
			String htmlString ="";
			
			
			
		

			while(rs.next()){
//				 id=rs.getString("id");
//				 htmlString += rs.getString("id")+" "+rs.getString("tag")+" ";
				 
//					htmlString += "<div class='tagId'>Tag ID :  "+rs.getString("id")+"<div class='timestamp'> Tag Date/Time "+rs.getString("timestamp")+"</div>";
//					htmlString +="<div class='tagValue'>"+rs.getString("tag")+"</div></div>";
				id = rs.getString("id");
			//	htmlString +="<tr><td class='id'>"+rs.getString("id")+"</td>";
				htmlString +="<tr><td class='id'>"+id+"</td>";
				htmlString +="<td class='hash'>"+rs.getString("tag")+"</td>";
				htmlString +="<td class='date'>"+rs.getString("timestamp")+"</td>";
			//	out.println(id);
				htmlString +="<td class='comment'><a href='/HashtagApplication/AddComment.jsp?hashId="+id+"&hashtag="+rs.getString("tag")+"'&>Add Comment</a></td></tr>";
			//	htmlString +="<td class='comment'><a href='/HashtagApplication/AddComment.jsp?hashId='"+rs.getString("id")+">Add Comment</a></td></tr>";
				
				
			}
			
			//htmlString += "</tr>";
			//out.println(htmlString);
			response.setContentType("text/html");
			request.setAttribute("htmlString", htmlString);
			request.getRequestDispatcher("/ViewHashtag.jsp").forward(request, response);
//			out.println(htmlString);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
