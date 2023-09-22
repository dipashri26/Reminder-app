package reminderpack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addremind
 */
public class Addremind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addremind() {
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
		String rtitle=request.getParameter("rtitle");
		String rdesc=request.getParameter("rdesc");
		
		try
		{
			String email=User.getEmail();
			Connection con=ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into remind_tbl values(?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2,rtitle);
			ps1.setString(3,rdesc);
			ps1.setString(4,email);
			
			
			int i=ps1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("success.html");
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
