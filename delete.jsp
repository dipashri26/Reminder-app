<%@page import="reminderpack.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   
<html>   
<head>  
<title>Delete</title>   
</head>    
<body>    
    
         <%
         String rid=request.getParameter("rid"); 
         try
  { 
	  Connection con=ConnectDB.connect();
	  PreparedStatement ps1=con.prepareStatement("delete from remind_tbl where rid=?");
		ps1.setString(1,rid);
	
		int i=ps1.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("viewrem.jsp");
		}
 
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  
  %>
 
       
  
    
</body>     
</html>