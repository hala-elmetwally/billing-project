<%-- 
    Document   : display_profiles
    Created on : Jun 16, 2021, 12:30:46 AM
    Author     : New
--%>
<%@page import="web.billing.ProfileCRUD"%>
<%@include file="header.html"%>
<link rel="stylesheet" href="main_menu.css">

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>

<%
    
    String username = request.getParameter("Name");
    String profileID = request.getParameter("id");
    if(profileID != null){
        String check = ProfileCRUD.deleteProfile(Integer.parseInt(profileID));
        if(!(check.equals("done"))){
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('There are customers on this profile,\\nYou have change there profiles first.\\nPress Ok to continue');");
            out.println("</script>");
        }
        }
    ResultSet rs = ProfileCRUD.selectAllProfiles();

    ResultSetMetaData rsmd = rs.getMetaData();
    int totalColumn = rsmd.getColumnCount();

    out.println("<h1    style=\"width: 900px;   text-align:center;  font-size: 45px;  margin-top:-50px; margin-left:200px; margin-bottom:100px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; \"  ; >Display Profiles </h1>");
    
    
    out.println("<table border=\"2\" style=\"border-collapse:collapse; padding:80px; color:yellowgreen; margin-left:330px; margin-bottom:100px; margin-top:30px; width:50% \"; >");
 
    out.println("<tr style=\"text-align:center; \";>");
        out.println("<tr ><th style=\"padding:40px; font-size:20px;font-family:sans-serif; white-space: nowrap;\";>Profile ID</th><th style=\"padding:40px;font-size:20px;font-family:sans-serif;white-space: nowrap;\";>Profile Name</th>"
                + "<th style=\" padding:20px; font-size:20px;font-family:sans-serif; white-space: nowrap;\";>Edit Or Delete</th>"
           
             
             
            + "</tr >");
    

//    for (int i = 1; i <= totalColumn; i++) {
//        String columnName = rsmd.getColumnName(i);
//        out.println("<th >" + columnName + "</th>");
//    }
//    out.println("<th style=\"font-size:20px;font-family:sans-serif; width:100px; \";>Edit Or Delete</th>");
    
    out.println("</tr>");

    while (rs.next()) {
        out.println("<tr style=\"text-align:center; font-size:20px;\"; >");
        for (int col = 1; col <= totalColumn; col++) {
            Object obj = rs.getObject(col);
            out.println("<td>" + String.valueOf(obj) + "</td>");
        }
        String id = String.valueOf(rs.getObject(1));  
        out.println("<td>");
        


%>
   <input type="button" value="Edit" style="background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 29px;  " onclick="location.href = 'EditProfile.jsp?id=<%=id%>'">
   <input type="button" value="Delete" style="background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 29px;  " onclick="location.href = 'display_profiles.jsp?id=<%=id%>'">
   <input type="button" value="More Info" style="background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 29px;  " onclick="location.href = 'more_info.jsp?id=<%=id%>'">
<%
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");


%>
<!--<a href="Admin_Page.jsp" style="color: greenyellow; " >
    <img src="home.png" width="100px" height="100px"/>
            </a>-->
<footer > 
 <p style="color: greenyellow ; font-size :25px;   font-family:  sans-serif;" >Welcome ${Name}   </p>
 </footer>