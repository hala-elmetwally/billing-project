<%--
Document : add_profile
Created on : Jun 15, 2021, 10:18:25 PM
Author : New
--%>




<%@page import="web.billing.RatingCRUD"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="web.billing.FreeUnitsCRUD"%>
<%@page import="web.billing.Profile_ServiceCRUD"%>
<%@page import="web.billing.ProfileCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%--<%@ page contentType="text/css" %>--%>
<html>
    <head>
        <title>Login page</title>
        <link rel="stylesheet" href="admin.css">
        <link rel="stylesheet" href="main_menu.css">

    </head>
    <body>

        <img  src="e4.jpg" onclick="javascript:location.href='Admin_Page.jsp'" style="margin-top:  10px; margin-left:30px;" width="120" height="120"  alt="logo-etisalat">


        <%
            String profileName = request.getParameter("profile name");
            String callOnNet = request.getParameter("Call Units On Net");
            String smsOnNet = request.getParameter("SMS Units On Net");
            String Data = request.getParameter("Data Unit");
            String callCrossNet = request.getParameter("Call Units Cross Net");
            String smsCrossNet = request.getParameter("SMS Units Cross Net");
            String callInter = request.getParameter("Call International");
            String smsInter = request.getParameter("SMS International");

            if (profileName != null && callOnNet != null && smsOnNet != null && Data != null
                    && callCrossNet != null && smsCrossNet != null && callInter != null && smsInter != null ) {

                String prof_id = ProfileCRUD.insertProfile(profileName);
                Profile_ServiceCRUD.insertNewServiceToProfile(1, Integer.parseInt(prof_id));
                Profile_ServiceCRUD.insertNewServiceToProfile(2, Integer.parseInt(prof_id));
                Profile_ServiceCRUD.insertNewServiceToProfile(3, Integer.parseInt(prof_id));
                RatingCRUD.insertNewRating(1, Integer.parseInt(prof_id), Float.parseFloat(callOnNet), Float.parseFloat(callCrossNet)
                        , Float.parseFloat(callInter));
                RatingCRUD.insertNewRating(2, Integer.parseInt(prof_id), Float.parseFloat(smsOnNet), Float.parseFloat(smsCrossNet)
                        , Float.parseFloat(smsInter));
                RatingCRUD.insertNewRating(3, Integer.parseInt(prof_id), Float.parseFloat(Data),0,0);
  
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Profile is added sucessfully.\\nPress Ok to continue');");
            out.println("</script>");

            }
        %>
        <div>
            <form action="add_profile.jsp?id=">
                <div>
                    <h1  class="head_cus" >Add Profile</h1>
                </div>
                <div class="profilename" >
                    <span   style="  margin-left:18px;"> Profile Name:</span>
                       <input id="profile_name"  required name="profile name"/>
                </div>

                <div class="servicesfees" >
                    <span style= "white-space: nowrap; " >Services Fees</span>
                    <br>
                    <br>
                </div>

                  <div class="cus_name  " >
                    <span class="customer_name" style="margin-left:-70px" >Call Fees On Net</span>
                    <input class="call" id="customerName" type="number" required min="0" step="0.01" value="0" name="Call Units On Net"/>
                    <div class="label_unit" style="margin-right:500px;">LE</div><br><br>
                </div>
                
                <div class="call_cross">
                    <span  class="call_crossnet"  >SMS Fees On Net</span>
                    <input class="call" id="customerName" type="number" required min="0" step="0.01" value="0" name="SMS Units On Net"/>
                   <div class="label_unit" >LE</div><br><br>
                </div>
                
                <div class="sms_on">
                    <span  class="sms_onnet"> Data Fees</span>
                    <input class="call" id="customerName" type="number" required min="0" step="0.01" value="0" name="Data Unit"/>
                   <div class="label_unit" >LE</div><br><br>
                </div>

                <div class="cus_name">
                    <span class="customer_name" style="margin-left:-30px"> Call Fees Cross Net</span>
                    <input class="call" id="customerName" type="number" required min="0" step="0.01" value="0" name="Call Units Cross Net"/>
                   <div class="label_unit" style="margin-right:500px;">LE</div><br><br>
                </div>
                
                <div class="call_cross">
                    <p> <p>
                    <span  class="call_crossnet" style="margin-left:15px; white-space: nowrap;   ">SMS Fees Cross Net</span>
                    <input class="call" id="customerName" type="number" required min="0" step="0.01" value="0" name="SMS Units Cross Net"/>
                    <div class="label_unit" >LE</div><br><br>
                </div>       
              
                <div class="fees-voice "  style="margin-tip:1000px;">
                    <span class="fvoice" style="margin-left:5px; margin-top:1000px;"> Call International Fees</span>
                    <input class="call" id="customerName" type="number" required min="0" step="0.01" value="0" name="Call International"/>
                   <div class="label_unit" style="margin-right:500px;">LE</div><br><br>
                </div>
                    <div class="fees_sms">
                    <span  class="fsms" >SMS International Fees</span>
                    <input class="call" id="customerName" type="number" required min="0" step="0.01" value="0" name="SMS International"/>
                    <div class="label_unit" >Fees</div><br><br>
                </div>     
                   <div class="sfees">
                        <input  id="submit" class="subf" type="submit" value="Submit">
                    </div>

            </form>
        </div>
<!--        <a href="Admin_Page.jsp" style="color: greenyellow; " >
    <img src="home.png" width="100px" height="100px"/>
            </a>-->
    <footer > <p style="color: greenyellow ; font-size :25px; margin-top: -100px; margin-left: 30px; font-family:  sans-serif;" >Welcome ${Name}   </p>
    </footer>
       


    </body>
</html>