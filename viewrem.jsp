<%@page import="reminderpack.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: slateblue;  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;
        margin-top:50px;   
        margin-right:500px;   
        margin-left:500px;
        margin-bottom:50px;      
    }   
 table,th,td
 {
 border: 1px solid black;
 border-collapse:collapse;
 border-spacing:30px;
  width:30%;
  height:30%;
   margin-top:50px;   
        margin-right:500px;   
        margin-left:500px;
        margin-bottom:50px;   
   
   }      
 
 }
 input[type=text], input[type=text] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: lightblue;  
    }   
</style>   
</head>    
<body>    
    <center><h1>MY REMINDERS</h1> </center>   
    <form action="viewrem.jsp" method="post">  
        
         </form>
         <%
         String email=User.getEmail();

         %>  
  <table>
  <tr>
    <th>Reminder ID</th>
    <th>Reminder Title</th>
    <th>Reminder Description</th>
    <th>Action</th>
  </tr>
  <%
  Connection con=ConnectDB.connect();
  try
  {
	  PreparedStatement ps1=con.prepareStatement("select * from remind_tbl where email=?");
		ps1.setString(1,email);
	
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
  %>
  <tr>
    <td><%=rs1.getInt("rid") %></td>
    <td><%=rs1.getString("rtitle") %></td>
    <td><%=rs1.getString("rdesc") %></td>
    <td><a href="delete.jsp?rid=<%=rs1.getInt("rid") %>">Delete</a></td>
    
  </tr>
  <%
		}
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  
  %>
</table>
             
       
  
    
</body>     
</html>