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
 * Servlet implementation class SerachHashtagServlet
 */
public class SerachHashtagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachHashtagServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement stmt = null;
		
		String hash = request.getParameter("hash");
	//	out.println("hash value is "+hash);
//		
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
//		String sql = "SELECT HashtagFeed.content,HashtagFeed.ParentFeed,HashtagFeed.timestamp FROM HashtagFeed LEFT JOIN hashtag ON HashtagFeed.hashtag = hashtag.tag WHERE hashtag.tag = '"+hash+"' ORDER BY HashtagFeed.timestamp DESC";
	//	String sql = "SELECT HashtagFeed.content,HashtagFeed.ParentFeed,HashtagFeed.timestamp FROM HashtagFeed WHERE HashtagFeed.hashtag = '"+hash+"' ORDER BY HashtagFeed.timestamp DESC";
		
		String sql = "SELECT * FROM HashtagFeed WHERE hashtag = '"+hash+"' ORDER BY timestamp DESC";
		
		
//		String sql ="SELECT * FROM ( SELECT * FROM HashtagFeed WHERE hashtag = '"+hash+"') ORDER BY timestamp DESC";
		
		//String sql = "SELECT * FROM HashtagFeed WHERE hashtag = '"+hash+"'";
		
		try {
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			ResultSet rs = pst.executeQuery();

			String htmlString="";

		//	out.println("<h2>hash is : "+hash+"</h2><br/><br/>");
			while(rs.next()){
				
				htmlString +="<tr><td class='content'>"+rs.getString("content")+"</td>";
				htmlString +="<td class='timestamp'>"+rs.getString("timestamp")+"</td>";
				htmlString += "<td><a href='/HashtagApplication/AddComment.jsp?hashId="+rs.getString("hashtag_id")+"&hashtag="+rs.getString("hashtag")+"'>Reply</a></td></tr>";
//				htmlString +="<td class='date'>"+rs.getString("timestamp")+"</td>";
//				htmlString +="<td class='comment'><a href='/HashtagApplication/AddComment.jsp?hashId="+id+"&hashtag="+rs.getString("tag")+"'&>Add Comment</a></td></tr>";
				
				
//				 out.println(rs.getString("content"));
//				 out.println(rs.getString("timestamp"));
//				 htmlString += rs.getString("content")+" "+rs.getString("timestamp"); 
			}
			response.setContentType("text/html");
			request.setAttribute("htmlString", htmlString);
			request.getRequestDispatcher("/SearchResult.jsp").forward(request, response);
			//out.println(htmlString);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
