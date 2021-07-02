<%-- 
    Document   : Admin_Page
    Created on : Jun 15, 2021, 11:47:55 PM
    Author     : New
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
          <link rel="stylesheet" href="main_menu.css">
        
    </head>
    <body>
        <%
            String username = request.getParameter("Name");
            String flag = request.getParameter("action");
            if(flag != null){
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('The file uploaded sucessfully.\\nPress Ok to continue');");
            out.println("</script>");}
        %>
      <h1 class="upload_cdr" >Upload CDR</h1>
     
      <form action="FilesUpload" method="post" enctype="multipart/form-data" >
            <input  id="add1" type="file" id="myFile" name="filename" style=""><br><br><br>
            <input id="add" type="submit" value="Submit"/><br><br>
        </form>
<!--   <a href="Admin_Page.jsp" style="color: greenyellow; " >
    <img src="home.png" width="100px" height="100px"/>
            </a>-->
<footer >
    <p style="color: greenyellow ; font-size :25px; margin-top: -120px;  font-family:  sans-serif;" >Welcome ${Name}  </p>
  </footer>
    </body>
</html>