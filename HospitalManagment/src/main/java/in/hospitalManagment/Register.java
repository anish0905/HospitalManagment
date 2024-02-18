package in.hospitalManagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user_register")
public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		             
		PrintWriter out =resp.getWriter();
		                   String myname    = req.getParameter("name1");
		                  String myEmail    = req.getParameter("email");
		                   String myPassword   = req.getParameter("password");
		                   System.out.println(myname + myEmail + myPassword);
		                   
		                   try {
		                	   Class.forName("com.mysql.cj.jdbc.Driver");
		                	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosp" , "root" ,"root");
		                	   
		                	   PreparedStatement ps = conn.prepareStatement("insert into register values(? ,?,?)");
		                	    ps.setString(1, myname);
		                	    ps.setString(2, myEmail);
		                	    ps.setString(3, myPassword);
		                	    
		                	    int count =ps.executeUpdate();
		                	    if(count>0)
		                	    {
		                	    	resp.setContentType("text/html");
		                	    	out.print("<h3>User Successfully</h3>");
		                	    	RequestDispatcher rd  = req.getRequestDispatcher("/index.jsp");
		                	    	rd.include(req, resp);
		                	    }
		                	    else {
		                	    	resp.setContentType("text/html");
		                	    	out.print("<h3>User unSuccessfully</h3>");
		                	    	RequestDispatcher rd  = req.getRequestDispatcher("/index.jsp");
		                	    	rd.include(req, resp);
		                	    	
		                	    }
		                	    
		                	   
		                	            
		                	   
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
							resp.setContentType("text/html");
                	    	out.print("<h3>User unSuccessfully</h3>");
                	    	RequestDispatcher rd  = req.getRequestDispatcher("/index.jsp");
                	    	rd.include(req, resp);
							
						}
		                   
		                   
		                   
	}

}
