<%-- 
    Document   : EditProfile
    Created on : Jun 20, 2021, 9:20:18 PM
    Author     : Aya
--%>

<%@page import="web.billing.Profile_ServiceCRUD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.billing.ProfileCRUD"%>
<%@page import="web.billing.RatingCRUD"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="web.billing.ServiceCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>

        <link rel="stylesheet" href="main_menu.css">

        <title>Edit Profile</title>




    </head>


    <body>

        <%
            int count = 0;
            String profileID = request.getParameter("id");
            //String profileName = request.getParameter("profile");
            String onNet = request.getParameter("OnNet");
            String crossNet = request.getParameter("CrossNet");
            String feesInter = request.getParameter("FeesInter");
            String serviceID = request.getParameter("serID");
            String add_service_name = request.getParameter("addser_name");
            String add_service_fees = request.getParameter("addser_fees");
            
            if (add_service_name != null && add_service_fees != null){
                int serID = ServiceCRUD.insertService(add_service_name);
                Profile_ServiceCRUD.insertNewServiceToProfile(serID,Integer.parseInt(profileID));
                RatingCRUD.insertNewRating(serID, Integer.parseInt(profileID), Float.parseFloat(add_service_fees), 0, 0);
            }

            if (onNet != null && crossNet != null && feesInter != null && serviceID != null) {
                RatingCRUD.UpdateRating(Integer.parseInt(serviceID), Integer.parseInt(profileID), Float.parseFloat(onNet), Float.parseFloat(crossNet),
                        Float.parseFloat(feesInter));
         
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Profile edited sucessfully.\\nPress Ok to continue');");
            out.println("</script>");
            }

            ResultSet rs1 = ProfileCRUD.selectProfile(Integer.parseInt(profileID));
            ResultSet rs2 = RatingCRUD.selectServicesRatingForProfile(Integer.parseInt(profileID));
            ResultSet rs3 = ServiceCRUD.selectAllServices();
            String profile_name = "";
            Float FeesOnNet;
            Float FeesCrossNet;
            Float FeesInter;
            ArrayList<String> servicesName = new ArrayList<String>();
            rs1.next();
            profile_name = String.valueOf(rs1.getObject(2));
            while (rs3.next()) {
                servicesName.add(rs3.getString(2));
            }

        %>

        <div>

            <div>
                <h1 style="width: 900px;   text-align:center;  margin-left:230px; font-size: 45px;  margin-top: -15px; padding-bottom: 10px;  color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777;">Edit Profile Information</h1>
            </div>
            <div>
                <span class="Edit_prof" style=" font-size: 40px; margin-left:580px; margin-top: -100px;"> <%=profile_name%></span>
<!--                <input style="width: 100px; text-align: center;" id="" type="text"  name="profile" value="<%=profile_name%>"/>-->
            </div>

            <%
                ResultSet rs = ServiceCRUD.selectAllServices();
                ResultSetMetaData rsmd = rs.getMetaData();
                int totalColumn = rsmd.getColumnCount();


            %>
            <div >
                <span style=" font-size: 40px;"> </span>
                <center>
                    <br>    
                    <table border='2' style=" width:70%; border-collapse:collapse; margin-left:-5px; font-size: 25px; font-family:sans-serif;  margin-bottom:10px; color:yellowgreen; margin-top:30px; text-align:center;">
                        <tr>
                        <th style="padding-top:40px; padding-bottom: 30px; text-align: center; white-space:nowrap; padding-left:20px; padding-right:20px; width: 590px; " >Service Name</th>
                        <th style="padding-top:40px; padding-bottom: 30px; text-align: center;  width: 290px;  " >On Net Fees</th>
                        <th style="padding-top:40px; padding-bottom: 30px;  text-align: center; white-space:nowrap;  padding-left:20px; padding-right:20px; width: 290px; " >Cross Net Fees</th>
                        <th style="padding-top:40px; padding-bottom: 30px;   text-align: center; white-space:nowrap;  padding-left:20px; padding-right:20px; width: 290px; " >International Fees</th>
                        <th style="padding-top:40px; padding-bottom: 30px;   text-align: center; width: 290px;  " >Apply</th>
                        </tr>
                        <%      while (rs2.next()) {
                                FeesOnNet = rs2.getFloat(3);
                                FeesCrossNet = rs2.getFloat(4);
                                FeesInter = rs2.getFloat(5);%>
                        <form>
                            <tr style="text-align:center; ">
                            <td><%=servicesName.get(count)%> </td>
                            <td><input style="width: 100px; text-align: center; margin-left: 40px; margin-right: 40px;" id="" type="text"  name="OnNet" value="<%=FeesOnNet%>"/>
                            </td>
                            <td><input style="width: 100px; text-align: center; margin-left: 60px;" id="" type="text"  name="CrossNet" value="<%=FeesCrossNet%>"/>
                            </td>
                            <td><input style="width: 100px; text-align: center; margin-left: 70px; " id="" type="text"  name="FeesInter" value="<%=FeesInter%>"/>
                            </td>
                            <td><input style="width: 100px; text-align: center; margin-left: 60px; background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 45px;  "   class="custome_submit" type="submit" value="Apply"/>
                            </td>
                            </tr>

                            <input  type="hidden" name="id" value="<%=profileID%>">
                            <input type="hidden" name="serID" value="<%=rs2.getInt(1)%>">
                        </form>
                        <%count++;}%>
                    </table>
<!--                    <div class="servicesfees" >
                        <div style=" font-size: 40px; margin-left:-520px; margin-top: -5px; white-space: nowrap; " >Add Service</div>
                        <br>
                        <br>
                    </div>
                    <form>
                        <div >
                            <div class="Edit_prof" style=" font-size: 40px; margin-left:-950px; margin-top: -120px;" >Service Name:</div>
                            <input id="addprofile" style="margin-left: -350px" type="text" required min="0"  name="addser_name"/>
                        </div>

                        <div>
                            <div  class="Edit_prof" style=" font-size: 40px; margin-left:-970px; margin-top: 20px;">Service Fees:</div>
                            <input id="addprofile" style="margin-top: -50px; margin-left: -350px" type="number" required min="0" step="0.01"value="0" name="addser_fees"/>
                        </div>
                        <div>
                            <input id="submit" style="margin-top: 70px; margin-left: 50px" class="custome_submit"  type="submit" required  value="Add" />
                        </div>
                        <input  type="hidden" name="id" value="<%=profileID%>">
                    </form>-->


            </div>  
        </div> 


    </div>
<!--    <a href="Admin_Page.jsp" style="color: greenyellow; " >
        <img src="home.png" width="100px" height="100px"/>
    </a>-->
<br><br>
<br><br>
<br><br><br><br><br><br>
<footer > <p style="color: greenyellow ; font-size :25px; margin-top: -100px; margin-left: 30px; font-family:  sans-serif;" >Welcome ${Name}   </p>
</footer>


</body>
</html>
