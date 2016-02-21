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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateHashtagServlet
 */
public class CreateHashtagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateHashtagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement stmt = null;
		
		String hash = request.getParameter("hash");
		
//		if(hash.length() == 0 || hash.contains(" ")|| hash.contains("")){
//			request.setAttribute("error", "hashtag value is empty...try again later");
//			request.getRequestDispatcher("/error.jsp").forward(request, response);
//		}
		
		
		
	//	out.println("on controoleer exiting ....");
	 //       System.exit(0);
		// JDBC driver name and database URL
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

        try {
//        	/*
//        	PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM hashtag WHERE tag LIKE ?");//'"+hash+"'");
        	PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM hashtag WHERE tag = ?");//'"+hash+"'");
        	//pstmt1.setString(1,"'"+hash+"'" );
        	pstmt1.setString(1,  hash );
//        	out.println("sfafasfafaf");
    		ResultSet rs = pstmt1.executeQuery();
 //   		out.println("sfafasfafaf-------------- 1");
    		int count = 0;
    	//	int existng_id = rs.getInt(1);//rs.getInt("id");
    		while(rs.next()){
    			count++;
    		}
    		
    	//	out.println("existing id -------------- "+existng_id);
    		
    		
    		if(count > 0){
    			out.println("Hashtag already exist. Please try with some other hashtag");
    		//	request.getRequestDispatcher("/index.jsp").forward(request, response);
    		}else{
//    			out.println("Hashtag already exist. Please try with some other hashtag");
//    		}else{
    			//out.println("ERROR: Hashtag Insertion Failed. Sorry Please contact administrator...");
    	//	}
        	
        	
 //       	*/
	    		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO hashtag(tag,timestamp) VALUES(?, ?)");
	    		pstmt.setString(1,hash );
	    		pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
	    		
	    		int i = pstmt.executeUpdate();
	
	    		if(i>0){
	    			out.println("SUCCESS: Record Inserted Successfully");
	    			response.setContentType("text/html");
	    			out.println("<html><body><a href='index.jsp'>Homepage</a></body></html>");
	    		}else{
	    			out.println("ERROR: Hashtag Insertion Failed. Sorry Please contact administrator...");
	    			response.setContentType("text/html");
	    			out.println("<html><body><a href='index.jsp'>Homepage</a></body></html>");
	    		}
    		}
//        	}else{
//        		out.println("HASHTAG YOU TRY TO ADD ALREADY EXIST. PLEASE TRY WITH SOME NEW ONE..");
//        	}
		} catch (SQLException e) {
			out.println("statemtnt error ....");
			return;

		}

//================
	}

}
