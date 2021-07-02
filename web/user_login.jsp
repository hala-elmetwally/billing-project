<%-- 
    Document   : user_login
    Created on : Jun 26, 2021, 3:46:08 AM
    Author     : Aya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

  <% String name = request.getParameter("name");
  String id = request.getParameter("id");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="admin.css">
        <link rel="stylesheet" href="main_menu.css">
    
    </head>
    <body>
      
        
               <img  src="e4.jpg" style="margin-top:15px; margin-left: 40px;" width="120" height="120"  alt="logo-etisalat">
                <input type="button" value="Log out" style="background-color:  greenyellow; display: block; color: black; width: 100px; cursor:pointer; margin-left: 1225px;  margin-top:-90px; margin-bottom: 20px;  " onclick="location.href = 'index.jsp?'">
          <h1 class="admin_page" style=" margin-top:-45px; margin-left: 270px">User Page</h1>
     
                
            <a href="AllInvoicesForUser.jsp?id=<%= id %>&name=<%=name%>" style="margin-left: 350px; margin-bottom: -200px;" >
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Display Invoices
            </a>
     
            <a href="AccountInfo.jsp?id=<%= id %>&name=<%=name%>" style=" margin-left: 250px; margin-bottom: -200px;">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
               ACCOUNT INFO
            </a>
          
          
  <footer >
    <p style="color: greenyellow ; font-size :25px; margin-top:340px; margin-left: 40px; font-family: ">Welcome 
      ${Name}  </p>
    
    
 </footer>
    </body>
</html>      