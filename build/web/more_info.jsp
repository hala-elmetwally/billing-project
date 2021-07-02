<%-- 
    Document   : display_customer
    Created on : Jun 16, 2021, 12:17:54 AM
    Author     : New
--%>
<%@page import="web.billing.ServiceCRUD"%>
<%@page import="web.billing.ProfileCRUD"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="web.billing.RatingCRUD"%>
<link rel="stylesheet" href="main_menu.css">

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@include file="header.html"%>

<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Customer Edit</title>
        <link rel="stylesheet" href="admin.css">
    
    </head>
    <body>-->
<%
    String username = request.getParameter("Name");
    int profileID = Integer.parseInt(request.getParameter("id"));
    if (profileID != 0) {
        RatingCRUD.selectServicesRatingForProfile(profileID);
    }

    ResultSet rs = RatingCRUD.selectServicesRatingForProfile(profileID);

    ResultSetMetaData rsmd = rs.getMetaData();
    int totalColumn = rsmd.getColumnCount();

    ResultSet rs1 = ProfileCRUD.selectProfile(profileID);
    rs1.next();
    String profile_name = rs1.getString(2);

    out.println("<h1    style=\"width: 900px;   text-align:center;  font-size: 45px;  margin-top:-50px; margin-left:200px; margin-bottom:100px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; \"  ; >More Information </h1>");%>
%>
<div>
    <span class="Edit_prof" style=" font-size: 40px; margin-left:580px; margin-top: -100px;"> <%=profile_name%></span>
</div> 

<table border="2"  width="100%"  style="  border-collapse:collapse;  margin-left:270px; width:50%; margin-bottom:10px; color:yellowgreen; margin-top:30px; text-align:center; ">
    <% out.println("<tr style=\"text-align:center; width:100%\";>");
        out.println("<tr ><th style=\"padding:20px; width:400px; font-size:20px;font-family:sans-serif;white-space:nowrap; \";>Service Name</th><th style=\"padding:20px; width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Fees On Net</th>"
                + "<th style=\"padding:20px;width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Fees Cross Net</th>"
                + "<th style=\"padding:20px;width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Fees International</th>" + "</tr >");

        //    for(int i=1;i<=totalColumn;i++)
        //    {
        //        String columnName = rsmd.getColumnName(i);
        //        out.println("<th style=\"padding:10px;font-size:20px;font-family:sans-serif;\";>"+columnName+" </th>");
        //    } 
        //   out.println("<th style=\"font-size:20px;font-family:sans-serif;\";> Delete</th>");
        out.println("</tr>");

        while (rs.next()) {
            out.println("<tr style=\"text-align:center;\";>");
            for (int col = 1; col <= totalColumn; col++) {
                if (col != 2) {
                    if (col == 1) {
                        Object obj = rs.getObject(col);
                        String serviceName = ServiceCRUD.getServiceName(Integer.parseInt(String.valueOf(obj)));
                        out.println("<td style=\"width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;\">" + serviceName + "</td>");

                    } else {
                        Object obj = rs.getObject(col);
                        DecimalFormat df = new DecimalFormat("###.##");
                        out.println("<td style=\"width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;\">" + df.format(Float.parseFloat(String.valueOf(obj))) + "</td>");
                    }
                }
            }
            //            String id = String.valueOf(rs.getObject(1));        
            //            out.println("<td>");        
            //         
            //        
    %>
    <%
//                        out.println("</td>");  
            out.println("</tr>");
        }

        out.println("</table>");

    %>


    <footer > 
        <p style="color: greenyellow ; font-size :25px;  margin-top: 120px; font-family:  sans-serif;" >Welcome ${Name}   </p>
    </footer>

    <!--
     </body>
    </html>-->