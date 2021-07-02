<%-- 
    Document   : add_customer
    Created on : Jun 16, 2021, 12:07:02 AM
    Author     : New
--%>

<%@page import="web.billing.OccCRUD"%>
<%@page import="web.billing.ProfileCRUD"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="web.billing.FreeUnitsCRUD"%>
<%@page import="web.billing.CustomerCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%--<%@ page contentType="text/css" %>--%>
<html>
    <head>
  <link rel="stylesheet" href="admin.css">
   <link rel="stylesheet" href="main_menu.css">

        <title>Edit Customer</title>


    </head>

    <body>
        
        
        
        <!--<div><form action="Admin_Page.jsp">-->
                <img  src="e4.jpg" onclick="javascript:location.href='Admin_Page.jsp'" style="margin-top:  10px; margin-left:30px;" width="120" height="120"  alt="logo-etisalat">
               
    <!--<input type="image" src="home.jpg" alt="Submit" style="float:right" width="48" height="48">-->
            <!--</form>-->
           
    </div>



   
        <!-- Profile Area -->
        <%
            String username = request.getParameter("Name");
            String name = request.getParameter("customerName");
            String email = request.getParameter("Email");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String msisdn = request.getParameter("MSISDN");
            String imsi = request.getParameter("IMSI");
            String address = request.getParameter("Address");
            String profile = request.getParameter("Profile_ID");
            String renew = request.getParameter("renewday");
            String adminFlag = request.getParameter("Admin Flag");
            String callOnNet = request.getParameter("Call Units On Net");
            String callCrossNet = request.getParameter("Call Units Cross Net");
            String smsOnNet = request.getParameter("SMS Units On Net");
            String smsCrossNet = request.getParameter("SMS Units Cross Net");
            String dataUnits = request.getParameter("Data Units");
            String serviceName = request.getParameter("ServiceName");
            String serviceFees = request.getParameter("ServiceFees");
            String month_no = request.getParameter("Month");
            
            ResultSet rs=ProfileCRUD.selectAllProfiles();
            if (name != null && email != null && userName != null
                    && password != null && msisdn != null && imsi != null
                    && imsi != null && address != null && profile != null && renew != null && adminFlag != null&&adminFlag !=""
                    && callOnNet != null && callCrossNet != null && smsOnNet != null && smsCrossNet != null
                    && dataUnits != null && serviceName != null && serviceFees != null ) {
                int customer_id = CustomerCRUD.insertCustomer(email, password, msisdn, imsi, address, Integer.parseInt(profile), 
                        name, userName, Integer.parseInt(adminFlag), Integer.parseInt(renew));
                FreeUnitsCRUD.insertFreeUnit(Integer.parseInt(callOnNet),Integer.parseInt(callCrossNet),
                        Integer.parseInt(smsOnNet),Integer.parseInt(smsCrossNet),Integer.parseInt(dataUnits),
                        customer_id);
                OccCRUD.insertOCC(customer_id, serviceName, Integer.parseInt(serviceFees), 0);
             
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Customer is added sucessfully.\\nPress Ok to continue');");
            out.println("</script>");
            }

        %>
        <div>
            <form>
                <div>
                    <h1 class="head_cus"   >Add New Customer</h1>
                </div>
                <div  class="cus_name" >
                    <span class="customer_name"> Name</span>
                    <input id="customerName" type="text" placeholder="Enter Name" required name="customerName"/><br><br>
                </div>
                <div class="cus_mail" >
                    <span class="cus_email">Email</span>
                    <input  id="email" type="text" placeholder="Enter Email" required  name="Email"/><br><br>

                </div> 

                <div  class="user_name">
                    <span class="cus_unam">User Name</span>
                    <input  id="u_name"  type="text" placeholder="Enter User Name" required  name="userName"/><br><br>

                </div> 


                <div class="cus_pass">
                    <span class="cus_password">Password</span>
                    <input  id="u_pass"  type="password" placeholder="Enter Password" required  name="password"/><br><br>

                </div> 
                <div class="cus_msisdn">
                    <span class="customer_msisdn">MSISDN</span>
                    <input  id="msisdn" type="text" placeholder="Enter MSISDN" required  name="MSISDN"/><br><br>

                </div> 
                <div class="cus_imsi">
                    <span class="customer_imsi">IMSI</span>
                    <input  id="imsi" type="text" placeholder="Enter IMSI" required  name="IMSI"/><br><br>

                </div> 
                <div class="cus_address">
                    <span class="customer_address">Address</span>
                    <input  id="address" type="text" placeholder="Enter Address" required  name="Address"/><br><br>

                </div> 


                <div class="cus_prof">
                    <span class="customer_profile" >Profile Name</span>
                    <!--<input  id="profile" type="text" placeholder="Enter Address" required  name="Profile_ID"/><br><br>-->
<select name="Profile_ID" id="addprofile" style="margin-top: 10px;">
    <option value="" disabled selected hidden >Choose Profile Name ..</option>
        <%    
while(rs.next()){ %>
 <option value="<%=rs.getString(1)%>"  ><%=rs.getString(2)%></option>
 <%        
}

%></select>
                </div> 
                <div class="cus_renew" style="margin-top: -90px;">
                    <span  class="customer_renew">Renew Day</span>
                    <input  id="renew"  type="text" placeholder="Enter from 1 to 30" required  name="renewday"/><br><br>

                </div> 

                <div class="adm_flag">
                    <span class="admin_flag">Admin Flag</span>
                    <!--<input  id="flag-admin"  type="text" placeholder="Enter 0 or 1" required  name="Admin Flag"/><br><br>-->
<select name="Admin Flag" required id="addprofile" style="margin-top: 10px;">
    <option value="" disabled selected hidden  >Choose Option ...</option>
      <option value="0" >False</option>
      <option value="1">True</option>
    </select>
                </div> 
                <div >
                    <h2 class="head_cus" style="margin-top:100px; " >Add Free Units to Profile</h2>
                </div>
                <div class="cus_name" style="margin-top:-30px; ">
                    <span class="customer_name" style="margin-left:-60px; ">Call Units On Net</span>
                    <input class="call" id="call_on" type="number" required min="0" value="0" name="Call Units On Net"/>
                    <div class="label_unit"style="margin-right:500px;" >Unit</div><br><br>
                </div>
                
                <div class="call_cross">
                    <span  class="call_crossnet"  >Call Units Cross Net</span>
                    <input class="call" id="call_cross" type="number" required min="0" value="0" name="Call Units Cross Net"/>
                   <div class="label_unit" >Unit</div><br><br>
                </div>
                <div class="sms_on">
                    <span  class="sms_onnet"> SMS Units On Net</span>
                    <input class="call" id="sms_on" type="number" required min="0" value="0" name="SMS Units On Net"/>
                   <div class="label_unit" >Unit</div><br><br>
                </div>
                <div class="cus_name">
                    <span class="customer_name" style="margin-left: -7px;  margin-top: 1000px;"> SMS Units Cross Net</span>
                    <input class="call" id="sms_cross" type="number" required min="0" value="0" name="SMS Units Cross Net"/>
                   <div class="label_unit"style="margin-right:500px;" >Unit</div><br><br>
                </div>
                <div class="call_cross">
                    <span  class="call_crossnet" style="margin-left:15px">Data Units</span>
                    <input class="call" id="data_unit" type="number" required min="0" value="0" name="Data Units"/>
                    <div class="label_unit" >Unit</div><br><br>
                </div> 
                
                 <div >
                    <h2 class="head_cus" style="margin-top:90px; " >Add VAS/OCC to Profile</h2>
                </div>
                <div class="cus_name" style="margin-top:-30px; ">
                    <span class="customer_name" style="margin-left:-90px; ">Service Name:</span>
                    <input class="call" id="call_on"  type="text" required min="0" name="ServiceName"/>
                   
                </div>
                
                <div class="call_cross" style="margin-top:-100px; ">
                    <span  class="call_crossnet"  >Service Fees:</span>
                    <input class="call" id="call_cross" type="number" required min="0" value="0" step="0.01" name="ServiceFees"/>
                 
                </div>
<!--                <div class="sms_on" style="margin-top:-100px;">
                    <span  class="sms_onnet"> Number of Month:</span>
                    <input class="call" id="sms_on" type="number" required min="0" value="0" name="Month"/>
        
                </div>-->
               
                
                <div class="cus_sub"  >
                    <input  id="submit"  class="custome_submit" style="margin-top:150px" type="submit" value="Submit">  
                </div>  
        </div> 
                
                
   
        </div> 

    </form>
</div>

<footer >
    <p style="color: greenyellow ; font-size :25px; margin-top: -10px; margin-left: 70px; font-family:  sans-serif;" >Welcome ${Name}   </p>
  </footer>
</body>

</html>


