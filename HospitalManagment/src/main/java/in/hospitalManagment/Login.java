package in.hospitalManagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter out = resp.getWriter();
               String myEmail   = req.getParameter("email");
               String myPassword = req.getParameter("password");
               
               try {
            	   Class.forName("com.mysql.cj.jdbc.Driver");
            	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosp" , "root" , "root");
            	   PreparedStatement ps = conn.prepareStatement("select * from register where myEmail =? and myPass = ?");
            	   ps.setString(1, myEmail);
            	   ps.setString(2, myPassword);
            	   
            	   ResultSet rs = ps.executeQuery();
            	   
            	   if(rs.next())
            	   {
            		   RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            		   rd.include(req, resp);
            	   }
            	   else {
            		   resp.setContentType("text/html");
            		  
            		   out.print("<h3> Email id &password did not matcher</h3>");
            		   RequestDispatcher rd  = req.getRequestDispatcher("/login_user.jsp");
            		   rd.include(req, resp);
            		  
            		   
            	   }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				   resp.setContentType("text/html");
        		   out.print("<h3>"+ e.getMessage()+"</h3>");
        		   RequestDispatcher rd  = req.getRequestDispatcher("/login_user.jsp");
        		   rd.include(req, resp);
			}
}

}
