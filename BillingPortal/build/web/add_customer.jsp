<%-- 
    Document   : add_customer
    Created on : Jun 16, 2021, 12:07:02 AM
    Author     : New
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@ page contentType="text/css" %>--%>
<html>
<head>
<title>Login page</title>
<style type="text/css"> 
    body {
       
        color: blue;
        margin: 0px;
    padding: 0px;
    height: 100vh;
    }
    form{
/*        text-align: center;*/
        margin: 0px;
        padding: 0px;
    }
    
</style>

</head>

<body>
<!-- Profile Area -->
  <div>
      <form>
      <div>
          <span>Add New Customer</span><br><br>
      </div>
      <div>
        <span> Name</span>
        <input id="customerName" type="text" placeholder="Enter Name" required name="customerName"/>
      </div>
      <div >
        <span>Email</span>
        <input type="text" placeholder="Enter Email" required  name="Email"/><br><br>
        
      </div> 

        <div >
        <span>MSISDN</span>
        <input type="text" placeholder="Enter MSISDN" required  name="MSISDN"/><br><br>
        
      </div> 
        <div >
        <span>IMSI</span>
        <input type="text" placeholder="Enter IMSI" required  name="IMSI"/><br><br>
        
      </div> 
        <div >
        <span>Address</span>
        <input type="text" placeholder="Enter Address" required  name="Address"/><br><br>
        
      </div> 
        <div >
        <span>Profile ID</span>
        <input type="text" placeholder="Enter Profile ID" required  name="Profile ID"/><br><br>
        
      </div> 
        
        <div >
        <input  class="sub" type="submit" value="Submit">  
        </div>  
    </form>
  </div>
   
</body>
</html>
  

