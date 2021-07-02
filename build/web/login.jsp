<%-- 
    Document   : login
    Created on : Jun 23, 2021, 8:07:55 PM
    Author     : Aya
--%>

<%@page import="web.billing.SignInCheck"%>
<!--<style type="text/css"> 
    body {
     
        color: blue;
        margin: 0px;
    padding: 0px;
    height: 100vh;
       font-size: 50px;
      background-image: url('background2.jpg');
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
      background-color: black;
    color: white;
    
 
    }
</style>-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>billing portal</title>
    <link rel="stylesheet" href="main_menu.css">
    <script src="jscript.js"></script>
</head>
<body>

 <%
        String message ="";
        String username = request.getParameter("Name");
        String passwrd = request.getParameter("password");
        String submit = request.getParameter("submit");
 
       
        if(username != null && passwrd != null && submit != null &&
           !(username.equals("")) && !(passwrd.equals("")) && !(submit.equals(""))){
          
               String flag = SignInCheck.checkSiginIn(username, passwrd);
        if (flag.equals("admin")){    session.setAttribute("Name", username); response.sendRedirect("Admin_Page.jsp");    }
        else if (flag.equals("user")){   session.setAttribute("Name", username);  response.sendRedirect("user_login.jsp");}
        else {message = "UserName or Password is wrong";}
        }
        else if (submit != null && (username == null || passwrd == null ||username.equals("") || passwrd.equals(""))){
        message = "Please insert all fields";
        
    }
      
        
        %>
     



    <form action="">
        <h2><span class="entypo-login"><i class="fa fa-sign-in"></i></span> Login</h2>
        <button class="submit"><span class="entypo-lock"><i class="fa fa-lock"></i></span></button>
        <span class="entypo-user inputUserIcon">
            <i class="fa fa-user"></i>
        </span>
        <input type="text" class="user" name="Name"  placeholder="ursername"/>
        <span class="entypo-key inputPassIcon">
            <i class="fa fa-key"></i>
        </span>
        <input type="password"  name="password"  class="pass"placeholder="password"/>
        <center><span style="color: greenyellow;font-size: 17px;  margin-left:-40px;" ><%=message%></span></center>
         <input type="hidden" name="submit" value="yes"> 
    </form>

 <footer >
    <p class="footer">Welcome to  Billing Portal </ps>
  </footer>

</body>
