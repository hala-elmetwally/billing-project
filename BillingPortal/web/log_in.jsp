<%-- 
    Document   : log_in
    Created on : Jun 16, 2021, 12:44:23 AM
    Author     : New
--%>
<style type="text/css"> 
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
</style>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>billing portal</title>
    <link rel="stylesheet" href="main_menu.css">
</head>
<body>

  <div class="container">
    <form id="login" class="login" action="login">
      <span class="loginTitle">Login</span>
      <div class="userName">
        <span >User Name</span>
        <input  type="text"  placeholder="UserName" name="Name" required/>
      </div>
      <div class="password">
        <span>Password</span>
        <input type="password"  placeholder="Password" name="password" required/>
      </div>
      <div class="submit">
        <input id="su" class="sub" type="submit" value="Log In"/>
      </div>            
    </form>
  </div>
<!-- Login Check -->


   
</body>
</html>