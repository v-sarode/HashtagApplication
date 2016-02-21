package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt1 = null;

	// JDBC driver name and database URL
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL="jdbc:mysql://localhost:3306/hash";
	
	//  Database credentials
	 final String USER = "root";
	 final String PASS = "root";
	 int statusNumber = 0;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		try {
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection( DB_URL,USER,PASS);
			
		} catch (ClassNotFoundException | SQLException e) {
			statusNumber = 1;
			e.printStackTrace();
			return;
		}

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
		String comment = request.getParameter("comment");
		String hashtag = request.getParameter("hashtag");
		String id = request.getParameter("id");

    	try {
			pstmt1 = conn.prepareStatement("INSERT INTO HashtagFeed(content,hashtag,hashtag_id,timestamp) VALUES(?, ?, ?, ? )");
			pstmt1.setString(1,  comment);
			pstmt1.setString(2,  hashtag);
			pstmt1.setString(3,  id);
			pstmt1.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

			int i = pstmt1.executeUpdate();
			response.setContentType("text/html");
    		if(i>0){
    			out.println("SUCCESS: Record Inserted Successfully");
    			out.println("<html><body><a href='index.jsp'>Homepage</a></body></html>");
    		}else{
    			out.println("ERROR: Hashtag Insertion Failed. Sorry Please contact administrator...");
    			out.println("<html><body><a href='index.jsp'>Homepage</a></body></html>");
    		}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
