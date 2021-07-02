<%-- 
    Document   : user_login
    Created on : Jun 26, 2021, 3:46:08 AM
    Author     : Aya
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<% 
   String path_folder = request.getParameter("path");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
        <link rel="stylesheet" href="admin.css">
        <link rel="stylesheet" href="main_menu.css">

    </head>
    <body>


        <img  src="e4.jpg" onclick="javascript:location.href='Admin_Page.jsp'" style="margin-top:15px; margin-left: 40px;" width="120" height="120"  alt="logo-etisalat">

        <h1 class="admin_page" style=" margin-top:-45px; margin-left: 270px">Admin Page</h1>
        <%
         
               
                  
                        File customer_invoice = new File("F:\\mayada\\ITI\\Billing\\web\\BillingPortal\\web\\Invoices\\" + path_folder +"\\");
                        for (File fileEntry1 : customer_invoice.listFiles()) {
                            if (!(fileEntry1.isDirectory())) { 
                             String path = fileEntry1.getName();%>
                                <input type="button" value="<%=fileEntry1.getName()%>" style="background-color:  greenyellow; display: block; color: black; width: 300px; cursor:pointer; margin-left: 570px;  margin-bottom: 20px;  " onclick="location.href = 'DisplayInvoicePdfAdmin.jsp?path=<%=path%>&folder_path=<%=path_folder%>'">
<%
                            }
                        }
                    
                
            
        %>
       
    <footer >
        <p style="color: greenyellow ; font-size :25px; margin-top:340px; margin-left: 40px; font-family: ">Welcome 
            ${Name}  </p>
    </footer>
</body>
</html>      