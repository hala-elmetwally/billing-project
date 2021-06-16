<%-- 
    Document   : add_profile
    Created on : Jun 15, 2021, 10:18:25 PM
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
          <span>Add New Profile</span><br><br>
      </div>
      <div>
        <span>Profile Name</span>
        <input id="profileName" type="text" placeholder="Enter Profile Name" required name="profileName"/>
      </div>
      <div >
        <span>Renew Date</span>
        <input type="date"   name="Renew Date"/><br><br>
        
      </div> 

    </form>
<!--/////////////////////////////////////////////////////////////////////////////////////////////-->
    <form>
      <div>
          <span >Add Service To Profile </span><br><br>
      </div>
      <div >
        <span>Service Name</span>
        
     
        
        <input type="text" id="addServicetext"  placeholder="Enter Service Name"/><br><br>
      </div>

    </form>
<!--/////////////////////////////////////////////////////////////////////////////////////////////-->
    <form >
      <div >
          <span >Add Free Units to Profile</span><br><br>
      </div>
      <div >
        <span>Call Units On Net</span>
        <input type="number" required min="0" value="0" name="Call Units On Net"/>
        <label>Unit</label>
      </div>
      <div >
        <span>Call Units Cross Net</span>
        <input type="number" required min="0" value="0" name="Call Units Cross Net"/>
        <label>Unit</label>
      </div>
      <div >
        <span> SMS Units On Net</span>
        <input type="number" required min="0" value="0" name="SMS Units On Net"/>
        <label>Unit</label>
      </div>
      <div >
        <span> SMS Units Cross Net</span>
        <input type="number" required min="0" value="0" name="SMS Units Cross Net"/>
        <label>Unit</label>
      </div>
      <div >
        <span>Data Units</span>
        <input type="number" required min="0" value="0" name="Data Units"/>
        <label>Unit</label>
      </div>
      <div >
        <input  class="sub" type="submit" value="Submit">  
      </div>  
    </form>
</div>
</body>
</html>
  

