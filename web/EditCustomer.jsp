<%-- 
    Document   : EditCustomer
    Created on : Jun 19, 2021, 5:16:45 PM
    Author     : Mayada
--%>

<%@page import="web.billing.ProfileCRUD"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="web.billing.CustomerCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@include file="header.html"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
 
<html>
    <head>
  <link rel="stylesheet" href="admin.css">
   <link rel="stylesheet" href="main_menu.css">

        <title>Edit Customer</title>


    </head>

    <body>
        
        
             <img  src="e4.jpg" onclick="javascript:location.href='Admin_Page.jsp'" style="margin-top:  10px; margin-left: 30px;" width="120" height="120"  alt="logo-etisalat">
        <!-- Profile Area -->
        <%
            String customerID = request.getParameter("id");
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
            String adminFlag = request.getParameter("AdminOption");
            if (name != null && email != null && userName != null
                    && password != null && msisdn != null && imsi != null
                    && imsi != null && address != null && profile != null && renew != null && adminFlag != null) {
            /// it should be upDATE NOT INSERT
            CustomerCRUD.UpdateCustomer(Integer.parseInt(customerID),email,name, msisdn, imsi, address, Integer.parseInt(profile),  userName,password, Integer.parseInt(adminFlag), Integer.parseInt(renew));

            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Customer edited sucessfully.\\nPress Ok to continue');");
            out.println("</script>");
            }
           ResultSet rs=ProfileCRUD.selectAllProfiles();
            if(customerID != null){
            ResultSet result = CustomerCRUD.selectCustomer(Integer.parseInt(customerID));
            while(result.next()){
                name = result.getString(3);
                email = result.getString(2);
                userName = result.getString(8);
                password = result.getString(9);
                msisdn = result.getString(4);
                imsi = result.getString(5);
                address = result.getString(6);
                profile = result.getString(7);
                renew = result.getString(11);
                adminFlag = result.getString(10);
            }}
        %>
     <div >
            <form action="EditCustomer.jsp">
                <div  >
                    <h1 class="head_cus" style="padding-bottom: 100px;">Edit Customer Information</h1>
                </div>
                <div  class="cus_name" >
                    <span  class="customer_name"> Name</span>
                    <input  id="customerName" type="text" placeholder="Enter Name" required name="customerName" value="<%= name%>"/><br><br>
                </div>
                <div  class="cus_mail">
                    <span class="cus_email">Email</span>
                    <input   id="email" type="text" placeholder="Enter Email" required  name="Email" value="<%= email%>"/><br><br>

                </div> 

        <div  class="user_name" >
            <span class="cus_unam">User Name</span>
            <input  id="usr_name"  type="text" placeholder="Enter User Name" required  name="userName"value="<%= userName%>"/><br><br>

        </div> 

 
    <div class="cus_pass">
        <span class="cus_password">Password</span>
        <input  id="usr_cus"  type="password" placeholder="Enter Password" required  name="password" value="<%= password%>"/><br><br>

    </div> 
    <div class="cus_msisdn">
        <span class="customer_msisdn">MSISDN</span>
        <input  id="msisdn" type="text" placeholder="Enter MSISDN" required  name="MSISDN" value="<%= msisdn%>"/><br><br>

    </div> 
    <div class="cus_imsi">
        <span class="customer_imsi">IMSI</span>
        <input  id="imsi" type="text"  style="margin-bottom: 100px;" placeholder="Enter IMSI" required  name="IMSI" value="<%= imsi%>"/><br><br>

    </div> 
    <div  class="cus_address" style="margin-top: -100px;" >
        <span class="customer_address">Address</span>
        <input  id="address" type="text" placeholder="Enter Address" required  name="Address" value="<%= address%>"/><br><br>

    </div> 

<!--//prof id-->
 <div class="cus_prof" >
        <div class="customer_profile" style="margin-bottom:55px;">Profile Name</div>
        <select name="Profile_ID" id="addprofile">
        <%    
while(rs.next()){if(profile.equals(rs.getString(1))){%>
 <option value="<%=rs.getString(1)%>" selected ><%=rs.getString(2)%></option><%}else{%>
      <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option><%}
         
}

%></select>
    </div> 
<div  class="cus_renew"  style=" margin-top: -100px;">
    <span class="customer_renew">Renew Day</span>
    <input  id="usr_renew"  type="text" placeholder="Enter from 1 to 30" required  name="renewday" value="<%= renew%>"/><br><br>

</div> 
<div class="adm_flag" style=" margin-top: -30px;">
    <div class="admin_flag" style="margin-bottom:60px;">Admin Flag </div>
    <!--<input  id="flag_adm"  type="text" placeholder="Enter 0 or 1" required  name="Admin Flag" value="<%= adminFlag%>"/><br><br>-->
   <%if(adminFlag.equals("1")){%>
   
  <select name="AdminOption" id="addprofile"  required>
      <option value="1" selected >True</option>
      <option value="0">False</option>
    </select>
  <% }else if(adminFlag.equals("0")){
  
  %>
  <select name="AdminOption" required id="addprofile">
      <option value="0" selected >False</option>
      <option value="1">True</option>
    </select>
  <%}%>

</div> 
               
<div class="cus_sub">
    <input type="hidden" name="id" value="<%=customerID%>">

    <input  id="submit" style="margin-top: 170px" class="custome_submit" type="submit" value="Submit" name="submit"> 
      <%
//            String username = request.getParameter("Name");
            String flago = request.getParameter("submit");
            if(flago != null){
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Edit applied sucessfully.\\nPress Ok to continue');");
            out.println("</script>");}
        %>
        
</div>  
        
 </div> 

</form>
</div>
<!--<a href="Admin_Page.jsp" style="color: greenyellow; " >
    <img src="home.png" width="100px" height="100px"/>
            </a>-->
<footer >
    <p style="color: greenyellow ; font-size :25px; margin-top: -100px; margin-left: 70px; font-family:  sans-serif;" >Welcome  ${Name} </p>
  </footer>
</body>

     </html>