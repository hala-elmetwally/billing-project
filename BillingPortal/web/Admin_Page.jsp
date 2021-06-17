<%-- 
    Document   : Admin_Page
    Created on : Jun 15, 2021, 11:47:55 PM
    Author     : New
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <style type="text/css"> 
    body {
       text-align: center;
       
        margin: 0px;
    padding: 0px;
    height: 100vh;
       font-size: 20px;
      background-image: url('background2.jpg');
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
      background-color: white;
    color: white;
    }
    
/*    form{
        text-align: center;
        margin: 0px;
        padding: 0px;
    }*/
 #add{
    font-size: 27px;
    background-color: white;
    color: blueviolet;
    border: none;
    /* cursor: pointer; */
    width: 300px;
    height: 40px;
    border-radius: 70px;
    /* text-align: center; */
    text-align: center;
    font-family: cursive;
    border: none;
    
}

    
</style>
    </head>
    <body>
        <h1 >Hello Admin!</h1>
        <form action="add_customer.jsp">
        <input id="add" type="submit" value="Add Customer" /><br><br></form>
        <form action="add_profile.jsp">
            <input id="add" type="submit" value="Add Profile"/><br><br></form>
        <form action="upload_cdr.jsp">
            <input id="add" type="submit" value="Upload CDR"/><br><br></form>
        <form action="display_customer.jsp">
            <input id="add" type="submit" value="Display All Customers"/><br><br></form>
        <form action="display_profiles.jsp">
            <input id="add" type="submit" value="Display All Profiles"/><br><br></form>
        <form action="display_services.jsp">
            <input id="add" type="submit" value="Display All Services"/><br><br></form>
        <form action="display_invoices.jsp">
            <input id="add" type="submit" value="Display Invoices"/><br><br></form>
    </body>
</html>
