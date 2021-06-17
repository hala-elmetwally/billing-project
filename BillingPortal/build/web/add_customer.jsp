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
       text-align: center;
        color: blue;
        margin: 0px;
    padding: 0px;
    height: 100vh;
       font-size: 30px;
      background-image: url('background2.jpg');
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
      background-color: black;
    color: white;
    }
    
    #customerName{
         font-size: 27px;
    background-color: white;
    color: black;
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
    #email {
         font-size: 27px;
    background-color: white;
    color: black;
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
    
   #msisdn{
         font-size: 27px;
    background-color: white;
    color: black;
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
    #imsi{
         font-size: 27px;
    background-color: white;
    color: black;
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
    #address{
         font-size: 27px;
    background-color: white;
    color: black;
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
    #profile_id{
         font-size: 27px;
    background-color: white;
    color: black;
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
    
    #submit{
         font-size: 27px;
    background-color: blueviolet;
    color: black;
    border: none;
    /* cursor: pointer; */
    width: 300px;
    height: 60px;
    border-radius: 70px;
    /* text-align: center; */
    text-align: center;
    font-family: cursive;
    border: solid;
       
          text-align: center;
        
    }
    
    
</style>



</head>

<body>
<!-- Profile Area -->
  <div>
      <form>
      <div>
          <h1>Add New Customer</h1>
      </div>
      <div>
        <span style=" font-size: 40px;"> Name</span>
        <input id="customerName" type="text" placeholder="Enter Name" required name="customerName"/><br><br>
      </div>
      <div >
        <span style=" font-size: 40px;">Email</span>
        <input  id="email" type="text" placeholder="Enter Email" required  name="Email"/><br><br>
        
      </div> 

        <div >
        <span style=" font-size: 40px;">MSISDN</span>
        <input  id="msisdn" type="text" placeholder="Enter MSISDN" required  name="MSISDN"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 40px;">IMSI</span>
        <input  id="imsi" type="text" placeholder="Enter IMSI" required  name="IMSI"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 40px;">Address</span>
        <input  id="address" type="text" placeholder="Enter Address" required  name="Address"/><br><br>
        
      </div> 
        <div >
        <span style=" font-size: 40px;">Profile ID</span>
        <input  id="profile_id"  type="text" placeholder="Enter Profile ID" required  name="Profile ID"/><br><br>
        
      </div> 
        
        <div >
        <input  style=" font-size: 40px;"id="submit" class="sub" type="submit" value="Submit">  
        </div>  
    </form>
  </div>
   
</body>
</html>
  

