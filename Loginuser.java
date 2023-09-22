package reminderpack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Loginuser
 */
public class Loginuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email=request.getParameter("email");
		String pswd=request.getParameter("pswd");
		User.setEmail(email);
		try
		{
		
		Connection con=ConnectDB.connect();
		PreparedStatement ps2=con.prepareStatement("select * from users_tbl where email=? and pswd=?");
		ps2.setString(1,email);
		ps2.setString(2, pswd);
		ResultSet rs1=ps2.executeQuery();
		if(rs1.next())
		{
			response.sendRedirect("homepage.html");
			
		}
		else 
		{
			response.sendRedirect("failed.html");
		
		}
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
