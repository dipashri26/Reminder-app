package reminderpack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reminderpack.ConnectDB;

/**
 * Servlet implementation class Registeruser
 */
public class Registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registeruser() {
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
		String name=request.getParameter("name");
		String mob=request.getParameter("mob");
		String email=request.getParameter("email");
		String pswd=request.getParameter("pswd");
		
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into users_tbl values(?,?,?,?,?)");
			
			ps1.setInt(1, 0);
			ps1.setString(2,name);
			ps1.setString(3,mob);
			ps1.setString(4,email);
			ps1.setString(5, pswd);
			
			int i=ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("login.html");
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
