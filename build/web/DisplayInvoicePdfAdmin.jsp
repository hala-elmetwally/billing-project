<%-- 
    Document   : user_login
    Created on : Jun 26, 2021, 3:46:08 AM
    Author     : Aya
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<% String path_folder = request.getParameter("folder_path");
   String path = request.getParameter("path");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="admin.css">

    </head>
    <body>

<!--
        <img  src="e4.jpg" style="margin-top:15px; margin-left: 40px;" width="120" height="120"  alt="logo-etisalat">

        <h1 class="admin_page" style=" margin-top:-45px; margin-left: 270px">User Page</h1>-->
        <%
        String full_path = "Invoices/"+path_folder+"/"+path;
        System.out.println(full_path);%>
        
        <embed src="<%=full_path%>" white-space:nowrap type="application/pdf"  height="1300px" width="1360px" >

    <footer >
        <p style="color: greenyellow ; font-size :25px; margin-top:340px; margin-left: 40px; font-family: ">Welcome 
            ${Name}  </p>
    </footer>
</body>
</html>      