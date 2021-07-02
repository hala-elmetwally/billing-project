<%-- 
    Document   : Admin_Page
    Created on : Jun 15, 2021, 11:47:55 PM
    Author     : New
--%>

<!DOCTYPE html>    
<a href="Admin_Page.jsp"></a>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <% String username = request.getParameter("Name"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="admin.css">
          <link rel="stylesheet" href="main_menu.css">
    </head>
    <body>
        
              <img  src="e4.jpg" style="margin-bottom:70px; margin-left: -90px;" width="120" height="120"  alt="logo-etisalat">
               <input type="button" value="Log out" style="background-color:  greenyellow; display: block; color: black; width: 100px; cursor:pointer; margin-left: 1225px;  margin-top:-170px; margin-bottom: 20px;  " onclick="location.href = 'index.jsp?'">
          <h1 class="admin_page" style="margin-top: 10px;" >Admin page</h1>
     
                
            <a href="add_customer.jsp" >
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Add Customer
            </a>
     
            <a href="add_profile.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Add Profile
            </a>
<!--        <a href="EditCustomer.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Edit Customer
            </a>
          
           <a href="EditProfile.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Edit Profile
            </a>
          
          -->
          
          
          
            <a href="UploadCdr.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Upload CDR
            </a>
       
            <a href="display_customer.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Display All Customers
            </a>
       
            <a href="display_profiles.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Display All Profiles
            </a>
      
            <a href="display_services.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Display All Services
            </a>
   
            <a href="DisplayInvoices.jsp">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Display Invoice
            </a>
        <footer >
    <p style="color: greenyellow ; font-size :25px; margin-top: -45px; margin-left: 40px; font-family: ">Welcome   ${Name} </p>
  </footer>
    </body>
</html>